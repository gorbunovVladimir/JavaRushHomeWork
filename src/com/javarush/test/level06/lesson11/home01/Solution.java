package com.javarush.test.level06.lesson11.home01;

/* Класс Cat и статическая переменная catCount
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная
catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
      /*for (int i=0;i<10;i++){  //Cоздай 10 объектов Cat тут
Cat cat1=new Cat();}*/
        Cat cat = new Cat();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        System.out.println(Cat.catCount);
        // Выведи на экран catCount тут
    }

    public static class Cat
    {
        public static int catCount=0;//Cоздай статическую переменную тут
   public Cat()
   {Cat.catCount++;}
        //создай конструктор тут
    }

}
