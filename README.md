This repository contains a small Java program, which reproduces a strange Java compiler error that occurs when using Error Prone 2.4.0

If an enum constant declares a method that has a Javadoc that references any class with a `{@link }`, the compiler errors out with
`error: enum types may not be instantiated`.
Removing the `{@link }` from Javadocs fixes the issue. 


To reproduce, run  `./gradlew clean build` 
```
$ ./gradlew clean build
  
  > Task :compileJava FAILED
  /home/error-prone-openjdk11-repro/src/main/java/repro/EnumThatReproduces.java:19: warning: [UnusedMethod] Private method 'method' is never used.
          private void method() {
                       ^
      (see https://errorprone.info/bugpattern/UnusedMethod)
    Did you mean to remove this line?
  /home/error-prone-openjdk11-repro/src/main/java/repro/EnumThatReproduces.java:5: error: enum types may not be instantiated
      INSTANCE {
               ^
  1 error
  1 warning
```

The warning is expected, but the Java compiler error is not.

When Error Prone is removed from `dependencies` is `build.gradle.kts`, the error disappears.

Decreasing the version to `2.3.4` also makes the error disappear.

Environment info:

```
$ ./gradlew -v

------------------------------------------------------------
Gradle 6.5
------------------------------------------------------------

Build time:   2020-06-02 20:46:21 UTC
Revision:     a27f41e4ae5e8a41ab9b19f8dd6d86d7b384dad4

Kotlin:       1.3.72
Groovy:       2.5.11
Ant:          Apache Ant(TM) version 1.10.7 compiled on September 1 2019
JVM:          11.0.7 (AdoptOpenJDK 11.0.7+10)
OS:           Mac OS X 10.15.4 x86_64
```

