package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {Integer a=1;int b=2;
        print(a);print(b);

    }
    public static void print(int n){System.out.print(n+"1");}
    public static void print(Integer n){System.out.print(n+"2");}
    //Напишите тут ваши методы
}
