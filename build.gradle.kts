plugins {
    kotlin("jvm") version "2.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "me.tapxyz_qq"
version = "0.2.9"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.9-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(21)
}