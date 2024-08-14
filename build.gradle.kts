plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // my sql connector
    implementation("mysql:mysql-connector-java:8.0.33")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}