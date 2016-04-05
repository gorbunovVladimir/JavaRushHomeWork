package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{   public String name;
    public int age;
    public int weight;
    public String colour;
    public String adress;

    public void initialize(String name)
    {
        this.name = name;
        this.age = 7;
        this.weight = 7;
        this.colour = null;
        this.adress = null;
    }
    public void initialize(String name, int weight, int age)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.colour = null;
        this.adress = null;}
    public void initialize(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.weight = 7;
        this.colour = null;
        this.adress = null;
    }

    public void initialize(int weight, String colour)
    {
        this.name = null;
        this.age = 7;
        this.weight = weight;
        this.colour = colour;
        this.adress = null;
    }


    public void initialize(int weight, String colour, String adress)
    {
        this.name = null;
        this.age = 7;
        this.weight = weight;
        this.colour = colour;
        this.adress = adress;
    }
    public static void main(String[] args) {
        Cat friend1= new Cat();
        friend1.initialize("Olya");
        Cat friend2= new Cat();
        friend2.initialize("Olesya", 6, 18);
        Cat friend3= new Cat();
        friend3.initialize("Arg", 1);
        Cat friend4= new Cat();
        friend4.initialize(2, "red");
        Cat friend5= new Cat();
        friend5.initialize(10, "blue", "Lenina 17");

    }
}