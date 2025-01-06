# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Voici une violation de la règle `UnitTestShouldUseTestAnnotation` sur le projet Apache common collections :
```
commons-collections-master\src\test\java\org\apache\commons\collections4\keyvalue\AbstractMapEntryTest.java:95:	UnitTestShouldUseTestAnnotation:	
Unit tests should use the @Test annotation or wont be run. In case of JUnit 5, test methods might use @RepeatedTest, @TestFactory, @TestTemplate or @ParameterizedTest annotations instead.
```

La ligne concernée est la suivante :
```java
/**
 * Subclasses should provide tests for their constructors.
 */
public abstract void testConstructors();
```
Il s'agit donc d'un faux positif, l'annotation `@Test` sera bien utilisée sur les implémentations de cette fonction.

En revanche avec la règle `JUnitUseExpected`, on trouve au total 11 violations dans le même projet. Voici un exemple :
```java
@Test
public void testMapComputeIfAbsent() {
    ...
    try {
        // two possible exception here, either valid
        computeIfAbsent(keys[0], k -> newValues[0]);
        fail("Expected IllegalArgumentException or UnsupportedOperationException on putIfAbsent (change)");
    }
}
```

On voit que le test peut lancer une exception mais qu'elle n'utilise pas `@Test(expected)`.
Cependant même en ajoutant `@Test(expected=Exception.class)` npm détecte toujours cette violation, et je ne sais pas pourquoi.





