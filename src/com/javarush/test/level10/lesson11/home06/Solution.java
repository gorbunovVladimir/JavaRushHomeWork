package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {  int age;boolean pol;ArrayList<String> children;String name; String adress;int growth;
        //напишите тут ваши переменные и конструкторы
        Human(int age){this.age=age;}
        Human(int age, int growth){this.age=age;this.growth=growth;}
        Human(int age, boolean pol){this.age=age;this.pol=pol;}
        Human(String name){this.name=name;}
        Human(ArrayList<String> children){this.children=children;}
        Human(String name, String adress){this.name=name;this.adress=adress;}
        Human(String name, String adress,int age, int growth){this.name=name;this.adress=adress;this.age=age;this.growth=growth;}
        Human(String name, String adress,int age){this.name=name;this.adress=adress;this.age=age;}
        Human(String name, int age){this.name=name;this.age=age;}
        Human(String name, int age, boolean pol){this.name=name;this.age=age;this.pol=pol;}
    }
}
