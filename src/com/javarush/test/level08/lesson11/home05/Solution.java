package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] arrS = s.toCharArray();
        //arrS[0] = Character.toUpperCase(arrS[0]);
        for (int i = 0; i < arrS.length - 1; i++) {
            if (i == 0 && Character.isLetter(arrS[i])){arrS[i] = Character.toUpperCase(arrS[i]);}
            if (arrS[i] == ' ' /*| !Character.isLetter(arrS[i])*/ && Character.isLetter(arrS[i + 1]))
                arrS[i + 1] = Character.toUpperCase(arrS[i +1 ]);
        }
        String string = new String(arrS);
        System.out.println(string);
        //Напишите тут ваш код
    }


}
