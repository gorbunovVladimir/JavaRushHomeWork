package com.javarush.test.level06.lesson05.task04;

/* Cчётчик котов
В конструкторе класса Cat [public Cat()] увеличивать счётчик котов (статическую переменную этого же класса catCount) на 1. В методе finalize уменьшать на 1.
*/
public class Cat
{
    public static int catCount = 0;
public Cat(){
    Cat.catCount++;
        }
protected void finalize() throws Throwable{
        Cat.catCount--;
        }
//Напишите тут ваш код
public static void main(String[] args) {
        }

        }
/*public class Cat
{   public String name;
    public static int catCount = 0;

    public Cat(String name)
    { this.name=name;
    Cat.catCount++;}//Напишите тут ваш код

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        //System.out.println("Cat destroyed");
        Cat.catCount--;
    }

    public static void main(String[] args) {
        /*for (int i = 0; i<50000; i++)
        {
            Cat cat=new Cat("Vasya");}
*//*
    }
}
*/

