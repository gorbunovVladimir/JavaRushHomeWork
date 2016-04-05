package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{   public int CenterX;
    public int CenterY;
    public int radius;
    public int width;
    public String color;
    public Circle(int CenterX, int CenterY, int radius)
    {
        this.CenterX = CenterX;
        this.CenterY = CenterY;
        this.radius = radius;
    }
    public Circle(int CenterX, int CenterY, int radius, int width)
    {
        this.CenterX = CenterX;
        this.CenterY = CenterY;
        this.radius = radius;
        this.width = width;
    }
    public Circle(int CenterX, int CenterY, int radius, int width, String color)
    {
        this.CenterX = CenterX;
        this.CenterY = CenterY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
    public static void main(int[] args) {
        Circle friend1= new Circle(20,18,5);

        Circle friend2= new Circle(18,14,3,10);

        Circle friend3= new Circle(19,28,5,1,"red");
    }
}
