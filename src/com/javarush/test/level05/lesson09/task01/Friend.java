package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    public String name;
    public int age;
    public String pol;

    public Friend (String name)
    {
        this.name = name;
    }

    public Friend(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Friend(String name, int age, String pol)
    {
        this.name = name;
        this.age = age;
        this.pol = pol;
    }
    public static void main(String[] args) {
        Friend friend1= new Friend("Olya");
        Friend friend2= new Friend("Olesya", 18);
        Friend friend3= new Friend("Arg", 29, "м");

    }
}
