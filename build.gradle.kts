import java.net.URI

plugins {
    java
    id("net.ltgt.errorprone").version("1.2.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    maven { url = URI("https://plugins.gradle.org/m2/") }
    jcenter()
}

repositories {
    maven { url = URI("https://plugins.gradle.org/m2/") }
    mavenCentral()
    jcenter()
}

dependencies {
    errorprone("com.google.errorprone:error_prone_core:2.4.0")
}
