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
    implementation("com.zaxxer:HikariCP:3.4.2")
    implementation("org.jdbi:jdbi3-core:3.5.1")
    implementation("org.jdbi:jdbi3-kotlin:3.5.1")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:3.5.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}