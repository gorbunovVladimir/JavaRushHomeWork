package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        int count=0;
        while (fileReader.ready())
        {   String[] s = fileReader.readLine().toLowerCase().replaceAll("(\\p{Punct}|\\r|\\n)", " ").split(" ");
            for (String ss : s)
                if (ss.equals("world")) count++;


        }
        System.out.println(count);
        fileReader.close();


    }
}
