package com.javarush.test.level07.lesson06.task04;

/* 5 строчек в начало списка
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        list.add(0,in.readLine());list.add(0,in.readLine());list.add(0,in.readLine());list.add(0,in.readLine());list.add(0,in.readLine());

        for (int i=0;i<5;i++)
        {
            System.out.println(list.get(i));}
        //Напишите тут ваш код

    }
}
