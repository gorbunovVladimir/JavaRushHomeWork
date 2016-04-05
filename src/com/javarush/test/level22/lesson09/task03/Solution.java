package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args)
    {
        /*//...
        StringBuilder result = getLine();
        System.out.println(result.toString());*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allWords = "";
        try{
        String file = reader.readLine();
        //Scanner sc = new Scanner(new FileInputStream(file), "Windows-1251");
        Scanner sc = new Scanner(new FileInputStream(file));
        while(sc.hasNext()){allWords = allWords + sc.nextLine() + " ";}
        }
        catch (Exception e){}

        StringBuilder result = getLine(allWords.trim().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (String word : words)
            list.add(word);
        boolean ok = false;
        while (!ok)
        {   Collections.shuffle(list);
            for (int i = 0; i < list.size() - 1; i++)
            {   char end = list.get(i).toLowerCase().charAt(list.get(i).length() - 1);
                char begin = list.get(i + 1).toLowerCase().charAt(0);
                if (end == begin)  ok = true;
                else { ok = false; break;}
            }
        }
        for (String word : list)
            sb.append(word + " ");
        sb.delete(sb.length() - 1, sb.length());
        return sb;
    }
}