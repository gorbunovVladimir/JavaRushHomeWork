package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{   public String name;
    public int height;
    public String colour;

    public void initialize(String name)
    {
        this.name = name;

    }
    public void initialize(String name, int height)
    {
        this.name = name;
        this.height = height;
    }
    public void initialize(String name, int height, String colour)
    {
        this.name = name;
        this.height = height;
        this.colour = colour;
    }





    public static void main(String[] args) {
        Dog friend1= new Dog();
        friend1.initialize("Olya");

        Dog friend2= new Dog();
        friend2.initialize("Art", 5);

        Dog friend3= new Dog();
        friend3.initialize("Olesya", 6, "red");



    }
}