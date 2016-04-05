package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    public String name;
    public int age;
    public String pol;

    public void initialize(String name)
    {
        this.name = name;
    }

    public void initialize(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void initialize(String name, int age, String pol)
    {
        this.name = name;
        this.age = age;
        this.pol = pol;
    }
    public static void main(String[] args) {
        Friend friend1= new Friend();
        friend1.initialize("Olya");
        Friend friend2= new Friend();
        friend1.initialize("Olesya", 18);
        Friend friend3= new Friend();
        friend1.initialize("Arg", 29, "м");

    }
}