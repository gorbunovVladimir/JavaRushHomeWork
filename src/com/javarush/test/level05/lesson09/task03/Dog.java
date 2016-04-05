package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{   public String name;
    public int height;
    public String colour;

    public Dog(String name)
    {
        this.name = name;

    }
    public Dog(String name, int height)
    {
        this.name = name;
        this.height = height;
    }
    public Dog(String name, int height, String colour)
    {
        this.name = name;
        this.height = height;
        this.colour = colour;
    }





    public static void main(String[] args) {
        Dog friend1= new Dog("Olya");

        Dog friend2= new Dog("Art", 5);

        Dog friend3= new Dog("Olesya", 6, "red");



    }
}

