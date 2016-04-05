package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
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
    public void initialize(int CenterX, int CenterY, int radius)
    {
        this.CenterX = CenterX;
        this.CenterY = CenterY;
        this.radius = radius;
    }
    public void initialize(int CenterX, int CenterY, int radius, int width)
    {
        this.CenterX = CenterX;
        this.CenterY = CenterY;
        this.radius = radius;
        this.width = width;
    }
    public void initialize(int CenterX, int CenterY, int radius, int width, String color)
    {
        this.CenterX = CenterX;
        this.CenterY = CenterY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
    public static void main(int[] args) {
        Circle friend1= new Circle();
        friend1.initialize(20,18,5);

        Circle friend2= new Circle();
        friend2.initialize(18,14,3,10);

        Circle friend3= new Circle();
        friend3.initialize(19,28,5,1,"red");
    }
}
