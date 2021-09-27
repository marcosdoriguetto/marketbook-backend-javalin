package com.marketbook.javalin.infra

import com.marketbook.javalin.controller.request.PostBookRequest
import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.enums.BookStatus
import com.marketbook.javalin.infra.connection.DatabaseHelper
import com.marketbook.javalin.infra.connection.DatabaseHelper.runCommand
import com.marketbook.javalin.infra.mapper.BookMapper
import com.marketbook.javalin.infra.mapper.CustomerMapper
import com.marketbook.javalin.model.ActivitiesRepositoryModel
import com.marketbook.javalin.model.BookModel
import com.marketbook.javalin.model.CustomerModel
import java.awt.print.Book

class ActivitiesRepositoryImpl: ActivitiesRepositoryModel {
    //Customers
    override fun fetchCustomers(name: String?): List<CustomerModel> {
        return runCommand {
            it.select("SELECT * FROM customer where (:name is null or name LIKE '%$name%')").bind("name", name).map(CustomerMapper()).list()
        }
    }

    override fun fetchCustomer(id: Int): CustomerModel {
        return runCommand {
            it.select("SELECT * FROM customer WHERE id IN ($id)").map(CustomerMapper()).findOnly()
        }
    }

    override fun getLastCustomerId(): CustomerModel {
        return fetchCustomers(null).last()
    }

    override fun postCustomer(customer: CustomerModel) {
        val id = getLastCustomerId().id!! + 1
        runCommand {
            it.createUpdate("INSERT INTO customer(id, name, email) VALUES ($id, '${customer.name}', '${customer.email}')").execute()
        }
    }

    override fun putCustomer(customer: CustomerModel) {
        runCommand {
            it.createUpdate("UPDATE customer SET name = '${customer.name}', email = '${customer.email}' WHERE id = ${customer.id}").execute()
        }
    }

    override fun deleteCustomer(id: Int) {
        runCommand {
            it.createUpdate("UPDATE FROM customer WHERE id = $id").execute()
        }
    }

    //Books
    override fun fetchBooks(name: String?): List<BookModel> {
        return runCommand {
            it.select("""select b.id, b.name, b.price, b.status, c.id idCustomer, c.name nameCustomer, c.email emailCustomer from book b INNER JOIN customer c on b.customer_id = c.id where (:name is null or b.name LIKE '%$name%')""").bind("name", name).map(BookMapper()).list()
        }
    }

    override fun fetchBook(id: Int): BookModel {
        return runCommand {
            it.select("select b.id, b.name, b.price, b.status, c.id idCustomer, c.name nameCustomer, c.email emailCustomer from book b INNER JOIN customer c on b.customer_id = c.id where b.id = $id").map(BookMapper()).findOnly()
        }
    }

    override fun fetchBooksCustomer(id: Int): List<BookModel> {
        return runCommand {
            it.select("select b.id, b.name, b.price, b.status, c.id idCustomer, c.name nameCustomer, c.email emailCustomer from book b INNER JOIN customer c on b.customer_id = c.id where c.id = $id").map(BookMapper()).list()
        }
    }

    override fun fetchBooksStatus(status: String): List<BookModel> {
        return runCommand {
            it.select("select b.id, b.name, b.price, b.status, c.id idCustomer, c.name nameCustomer, c.email emailCustomer from book b INNER JOIN customer c on b.customer_id = c.id where b.status = '$status'").map(BookMapper()).list()
        }
    }

    override fun getLastBookId(): BookModel {
        return fetchBooks(null).last()
    }

    override fun postBook(book: BookModel) {
        val id = getLastBookId().id!! + 1
        runCommand {
            it.createUpdate("INSERT INTO book(id, name, price, status, customer_id) VALUES ($id, '${book.name}', ${book.price}, 'ACTIVE', ${book.customer!!.id})").execute()
        }
    }

    override fun putBook(book: BookModel) {
        runCommand {
            it.createUpdate("UPDATE book SET name = '${book.name}', price = ${book.price}, status = '${book.status}' WHERE id = ${book.id}").execute()
        }
    }

    override fun deleteBooksByCustomer(id: Int) {
        val books = fetchBooksCustomer(id)

        for(book in books) {
            book.status = BookStatus.DELETED

            runCommand {
                it.createUpdate("UPDATE book SET status = 'DELETED' WHERE id = ${book.id}").execute()
            }
        }
    }

    override fun deleteBook(id: Int) {
        val book = fetchBook(id)

        book.status = BookStatus.CANCELED
        putBook(book)
    }
}