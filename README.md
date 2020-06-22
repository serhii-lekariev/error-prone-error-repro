This repository contains a small Java program, which reproduces a strange Java compiler error that occurs when using Error Prone 2.4.0

If an enum constant declares a method that has a Javadoc that references any class with a `{@link }`, the compiler errors out with
`enum types may not be instantiated`.
Removing the `{@link }` from Javadocs fixes the issue. 


To reproduce, run  `mvn clean compile` 
```
$ mvn clean compile
  
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.0:compile (default-compile) on project reproduction: Compilation failure
[ERROR] /home/error-prone-openjdk11-repro/src/main/java/repro/EnumThatReproduces.java:[5,14] enum types may not be instantiated

```

I was unable to reproduce this with Error Prone `2.3.4` or below.

I'm using Maven 3.6.3 and Java 13. The error can be reproduced using the Gradle plugin, using Java 11 and Java 8.

```
$ mvn -v 
  Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
  Maven home: /usr/local/Cellar/maven/3.6.3_1/libexec
  Java version: 13.0.2, vendor: N/A, runtime: /usr/local/Cellar/openjdk/13.0.2+8_2/libexec/openjdk.jdk/Contents/Home
  Default locale: en_UA, platform encoding: UTF-8
  OS name: "mac os x", version: "10.15.4", arch: "x86_64", family: "mac"
```

