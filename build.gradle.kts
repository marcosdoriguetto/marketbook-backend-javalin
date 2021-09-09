import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
}

group = "me.marcos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "io.javalin", name = "javalin", version = "3.13.11")
    implementation("com.fasterxml.jackson.core:jackson-core:2.10.5")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.10.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.5")
    implementation("com.zaxxer:HikariCP:3.4.2")
    implementation("org.jdbi:jdbi3-core:3.5.1")
    implementation("org.jdbi:jdbi3-kotlin:3.5.1")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:3.5.1")
    implementation("org.slf4j:slf4j-simple:1.7.30")
    implementation("mysql:mysql-connector-java:8.0.15")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}