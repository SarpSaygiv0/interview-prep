# Interview Prep

This is my hands-on preparation project for live coding interviews. Everything I practice lives here: algorithm problems, TDD katas, and Java standard library drills, all written as tested, runnable code instead of notes.

## Structure

```
src/main/java/com/easy/   one package per easy algorithm problem
src/main/java/com/medium/ one package per medium algorithm problem
src/main/java/com/.../katas/      one package per TDD kata
src/test/java/com/.../drills/     Java standard library drill sheets
```

Tests mirror the main packages. There is no application here, only code and the tests that prove it.

## Stack

Java 21, Maven, JUnit 5, AssertJ.

## Running

```bash
mvn test
```

Or open the project in IntelliJ and run any test class from the gutter.

## Note
No LLM used in this project's implementation. 