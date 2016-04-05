package com.javarush.test.level05.lesson05.task01;

/* Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, String), возраст (age, int), вес (weight, int), сила (strength, int).
*/

public class Cat
{
    //Напишите тут ваш код
    public String name;
    public int age;
    public int weight;
    public int strength;

    public static void main(String[] args)
    {
        Cat cat = new Cat();
        cat.name = "Вася";
        cat.age = 3;
        cat.strength=30;
        cat.weight = 4;

    }

}

