package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{   public String name;
    public int age;
    public int weight;
    public String colour;
    public String adress;

    public Cat(String name)
    {
        this.name = name;
        this.age = 7;
        this.weight = 7;
        this.colour = null;
        this.adress = null;
    }
    public Cat(String name, int weight, int age)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.colour = null;
        this.adress = null;}
    public Cat(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.weight = 7;
        this.colour = null;
        this.adress = null;
    }

    public Cat(int weight, String colour)
    {
        this.name = null;
        this.age = 7;
        this.weight = weight;
        this.colour = colour;
        this.adress = null;
    }


    public Cat(int weight, String colour, String adress)
    {
        this.name = null;
        this.age = 7;
        this.weight = weight;
        this.colour = colour;
        this.adress = adress;
    }
    public static void main(String[] args) {
        Cat friend1= new Cat("Olya");
        Cat friend2= new Cat("Olesya", 6, 18);
        Cat friend3= new Cat("Arg", 1);
        Cat friend4= new Cat(2, "red");
        Cat friend5= new Cat(10, "blue", "Lenina 17");

    }
}
