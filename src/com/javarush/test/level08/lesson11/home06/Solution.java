package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> list = new ArrayList<Human>();
        //ArrayList<Human> list2 = new ArrayList<Human>();
        ArrayList<Human> list3 = new ArrayList<Human>();
        ArrayList<Human> list4 = new ArrayList<Human>();
        Human son1 = new Human("Гена", true, 7, null);
        Human son2 = new Human("Вася", true, 11, null);
        Human daughter = new Human("Галина", false, 9, null);
        list.add(son1);
        list.add(son2);
        list.add(daughter);
        Human father = new Human("Лев", true, 35, list);
        Human mother = new Human("Львица", false, 40, list);
// System.out.println(list.get(1));
        list3.add(father);
        Human GrandFather = new Human("дед",true,74,list3);
        Human GrandMother = new Human("Ильична", false, 74, list3);
        list4.add(mother);
        Human GrandFather1 = new Human("Батько", true, 80, list4);
        Human GrandMother1 = new Human("Васильевна", false, 79, list4);
        System.out.println(GrandFather1);
        System.out.println(GrandMother1);
        System.out.println(GrandFather);
        System.out.println(GrandMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter);

    }

    public static class Human
    {
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();
        public Human(String name, Boolean sex, int age, ArrayList<Human> children ) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (children==null){this.children=new ArrayList<Human>();}
            else this.children = children;
            //this.children = children;

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
