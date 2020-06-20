import java.net.URI

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    jcenter()
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    annotationProcessor("com.google.errorprone:error_prone_core:2.4.0") {
        exclude("com.google.errorprone", "javac")
    }
}

tasks {
    compileJava {
        options.compilerArgs.addAll(listOf("-Xplugin:ErrorProne", "-XDcompilePolicy=simple"))
    }
}
