package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

  /*  public Cat(String name, int age, int weight, int strength)
    {this.name=name;
        this.age=age;
        this.weight=weight;
        this.strength=strength;
    }*/

    public boolean fight (Cat anotherCat)
    {
        if (this.strength*this.weight > anotherCat.strength*anotherCat.weight ){
            return true;
        }else {
            return false;
        }//Напишите тут ваш код
    }

    public static void main (String[]args)
    {
        Cat cat1 = new Cat();
        cat1.name="Мордор";
        cat1.age=3;
        cat1.weight=10;
        cat1.strength=9;
        Cat cat2 = new Cat();
        cat2.name="Eminem";
        cat2.age=5;
        cat2.weight=12;
        cat2.strength=8;

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
    }
}
