package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arrS = s.toCharArray();
        /*ArrayList<String> gl=new ArrayList<String>(); ArrayList<String> other=new ArrayList<String>();
        for (int i = 0; i < arrS.length; i++) {
            if (isVowel(arrS[i])){gl.add(new String(arrS,i,1)+" "); }
            else {other.add(new String(arrS,i,1) + " ");}
        }
                System.out.println(gl);System.out.println(other);*/
        String gl, other;gl="";other="";
        for (int i = 0; i < arrS.length; i++) {
            if (isVowel(arrS[i])){gl=gl+(new String(arrS,i,1)+" "); }
            else {other+=(arrS[i] + " ");}
        }
        System.out.println(gl);System.out.println(other);
}

 public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
