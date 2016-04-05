package com.javarush.test.level20.lesson10.home05;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 1L;

    public static class Person implements Serializable{
        private static final long serialVersionUID = 1L;
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString="Hello, ";
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;
        /*Person(){
            this.greetingString = "Hello, ";
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }*/
        Person(){
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
            }
        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);

            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
/*Потому что это костыль, нам искусственно приходится восстанавливать часть полей объекта в конструкторе без аргументов. В итоге конструктор без аргументов выполняет не свойственные ему функции. Если нужна дефолтная инициализация каких-то полей, то ее правильнее делать сразу при объявлении этих полей в классе. Но это мое личное мнение, я могу и ошибаться.


http://www.oracle.com/technetwork/articles/java/javaserial-1536170.html И собственно поле transient: http://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.3.1.3

в общем плане transient ведь не относится конкретно к какому-то из двух интерфейсов, это просто отметка о том, что данное поле не является персистентным (то есть его значение не должно записываться при помощи любого из существующих механизмов сохранения персистентности).

Кажется догадался, что тут имелось ввиду. Сериализуются только те поля, которые передаются в конструктор. Соответственно для полного восстановления объекта необходимо вызвать конструктор и передать в него поля от «урезанного» десериализованного объекта.

transient используется только со стандартной сериализацией, но со стандартной получается не совсем корректное решение — обнуляется константа, если ее объявить transient

Нормальная задача. Ответьте себе на вопросы:
1. Какие поля являются вычислимыми?
2. Нужно ли сохранять константу класса?
3. Какие объекты не стоит сериализовывать (было в лекции)?
*/