# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer
Pour le constructeur, les caractéristiques sont au nombre de trois : jour, mois et année.
- mois : valeur inférieure à 1, valeur supérieure à 12, mois à 31 jours, mois à 30 jours, février.
- année : année bissextile, année non bissextile
- jour : pour le jour, les valeurs dépendent aussi du mois. Ainsi si le mois est février, on devra vérifier qu'une valeur de 30 est mauvaise alors qu'elle ne le serait pas pour un autre mois. Il faut donc le vérifier conjointement au mois. On peut néanmoins vérifier qu'il doit toujours être supérieur à 1.

Pour les méthodes nextDate et previousDate, les valeurs des bornes sont particulièrement importantes. Il est inutile de vérifier les valeurs < 1 puisqu'on travaille sur des dates supposées correctes. Les blocs de cette méthode sont un sous-ensemble de ceux du constructeur, c'est à dire :
- nextDate : 
- - mois : 31 jours, 30 jours, février, 
- - année : bissextile, non bissextile
- - jour : 30 sur un mois à 30 jours, 31 sur un mois à 31, 28 en février d'une année non bissextile, 29 en février d'une année bissextile, 1<=autre valeur<=28
- previousDate :
- - mois : 31 jours, 30 jours, février
- - année : bissextile, non bissextile
- - jour : 1 sur un mois où le mois précédent a 31 jours, 1 sur un mois où le mois précédent a 30 jours/29 jours/28 jours, autre valeur
Il faut également tester les bornes des années (31 décembre pour nextDate et 1er janvier pour previousDate).

Pour compareTo, on a toujours les mêmes 3 caractéristiques. Les blocs associés sont <, > ou = à la valeur correspondante de l'autre date. (exemple : this.day peut prendre les valeurs "> other.day", "< other.day" ou "= other.day").
Cette fois les valeurs en elles-mêmes ne sont pas importantes. On travaille sur des dates correctes donc on n'a pas besoin de vérifier la cohérence des valeurs, et des valeurs de "borne" (dernier jour d'un mois par exemple) ne produisent pas un résultat différent de valeurs quelconques.


