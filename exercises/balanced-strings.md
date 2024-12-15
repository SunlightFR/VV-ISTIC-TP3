# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer
1. Il n'y a qu'un paramètre, il faut donc choisir de vérifier des propriétés dessus. Voici celles que j'ai choisi de tester :
- Chaîne vide
- Chaîne de taille impaire
- Chaîne simple contenant deux caractères correspondants (par exemple `[]`)
- Séquences imbriquées (par exemple `[()]`)
- Séquences successives (par exemple `[][]`)
- Chaîne contenant les deux.
- Pour les trois critères ci-dessus, vérifier que le comportement est le même si les caractères sont différents (ex. `[][]` vs `[]()`)

2. Mon code se fait en plusieurs étapes :
- Vérification que la chaîne est de taille paire : couvert par les deux premiers critères
- On cherche deux caractères successifs correspondants (ex. `()`) et on les supprime de la chaîne jusqu'à ce que la chaîne soit vide. Tous les cas sont couverts par les tests : 
- - Cas où les deux premiers caractères matchent (critères chaîne simple et séquences successives)
- - Cas où il faut attendre quelques caractères avant d'en trouver deux qui matchent (critères séquences imbriquées et mélange des deux)
- Enfin, en sortant de la boucle, on vérifie que la chaîne résultante est vide. Il y a deux cas possibles, vrai et faux. J'avais oublié d'ajouter un test vérifiant le cas faux. Il s'agit d'une situation dans laquelle le code a parcouru toute la chaîne sans trouver deux caractères successifs correspondants (ex. `()`). Il faut donc ajouter un critère : 

- Séquence ne contenant *pas* deux caractères correspondants successifs (par exemple `[[))`).