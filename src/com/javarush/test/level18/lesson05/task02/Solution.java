package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        /*String s="D:\\temp.txt";System.out.println(s);
        FileInputStream inputStream = new FileInputStream(s);*/
        int c=0;
        while (inputStream.available() > 0)
        {
            /*byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);*/
            //System.out.println(inputStream.available());
            int k=inputStream.read();
            //System.out.println(k+" 1q ");
            if (k==44){c++;}
        }
        System.out.println(c);
        inputStream.close();reader.close();
    }
}

