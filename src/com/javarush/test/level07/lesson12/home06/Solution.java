package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandPaFather = new Human("дедушка 1", true, 65, null, null);
        Human grandMoFather = new Human("бабушка 1", false, 62, null, null);
        Human grandPaMother = new Human("дедушка 2", true, 69, null, null);
        Human grandMoMother = new Human("бабушка 2", false, 66, null, null);
        Human father = new Human("отец", true, 35, grandPaFather, grandMoFather);
        Human mother = new Human("мать", false, 32, grandPaMother, grandMoMother);
        Human child1 = new Human("детей 1", true, 12, father, mother);
        Human child2 = new Human("детей 2", true, 10, father, mother);
        Human child3 = new Human("детей 3", false, 8, father, mother);
        System.out.println(grandPaFather);
        System.out.println(grandMoFather);
        System.out.println(grandPaMother);
        System.out.println(grandMoMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.father != null)
                text += ", отец: " + this.father.name;
            if (this.mother != null)
                text += ", мать: " + this.mother.name;
            return text;
        }
    }
}


