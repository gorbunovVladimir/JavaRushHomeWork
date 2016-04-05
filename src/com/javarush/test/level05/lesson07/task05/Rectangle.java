package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{ public int left, top, width, height;
    //Напишите тут ваш код
    public void initialize(int left, int top, int width, int height)
    {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height =  height;
    }
    public void initialize(int left, int top)
    {
        this.left = left;
        this.top = top;
        this.width = 0;
        this.height = 0;
    }
    public void initialize(int left, int top, int width)
    {
        this.left = left;
        this.top = top;
        this.width =width;
        this.height =width;
    }
    public void initialize(Rectangle rec1)
    {
        this.left = rec1.left;
        this.top = rec1.top;
        this.width = rec1.width;
        this.height =  rec1.height;
    }
    public static void main(int[] args) {
        Rectangle friend1= new Rectangle();
        friend1.initialize(20,18,5,15);

        Rectangle friend2= new Rectangle();
        friend2.initialize(18,14);

        Rectangle friend3= new Rectangle();
        friend3.initialize(19,28,5);

        Rectangle friend4= new Rectangle();
        friend4.initialize(friend3);
    }
}

