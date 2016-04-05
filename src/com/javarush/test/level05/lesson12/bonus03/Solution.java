package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maximum=-2786448;
        for (int i=0;i<n;i++)
        {   String s=reader.readLine();
            int a = Integer.parseInt(s);
            maximum = max(a,maximum);
            //a=0;s=null;//Напишите тут ваш код
        }
        System.out.println(maximum);
    }
    public static int max(int a, int b)
    {
        return a > b ? a : b;
    }
}
