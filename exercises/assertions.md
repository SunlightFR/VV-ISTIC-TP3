# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. L'assertion échoue à cause du point flottant. Le résultat donne une valeur proche de 1.2 mais pas exactement 1.2. Il faut le prendre en compte lors du test, en prévoyant une marge d'erreur par exemple.
2. assertSame compare les références et assertEquals se sert de la méthode `equals()` (qui part défaut compare elle aussi les références). Ainsi par défaut elles produiront toujours le même résultat. Si en revanche on override la méthode equals() pour comparer certains attributs par exemple, alors les deux méthodes ne renverront pas le même résultat.
3. nsp.
4. Cela permet de choisir quelle exception est lancée dans chaque cas. Les tests sont donc plus précis.
