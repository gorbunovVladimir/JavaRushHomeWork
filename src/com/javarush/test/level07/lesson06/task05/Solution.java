package com.javarush.test.level07.lesson06.task05;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {   ArrayList<String> list = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //list.add(0,in.readLine());list.add(0,in.readLine());list.add(0,in.readLine());list.add(0,in.readLine());list.add(0,in.readLine());
        for (int i=0;i<5;i++)
        list.add(in.readLine());
        String s;
        for (int i=0;i<13;i++){
            s=list.get(4);
            list.add(0,s);
        }

        for (int i=0;i<5;i++)
        { System.out.println(list.get(i));}
        //Напишите тут ваш код

    }
}
