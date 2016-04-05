package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bis.readLine());
        int M=Integer.parseInt(bis.readLine());
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0;i<N;i++)
            list.add(bis.readLine());
        for (int i=0;i<M;) { list.add(list.get(i));M--;list.remove(i);}

        for (int i = 0; i<list.size();i++) System.out.println(list.get(i));

        //Напишите тут ваш код
    }
}
