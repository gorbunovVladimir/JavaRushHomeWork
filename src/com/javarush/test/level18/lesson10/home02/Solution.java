package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream(args[0].toString());
        //FileInputStream inputStream = new FileInputStream("D:\\temp.txt");

        //D:\temp.txt
        int c=0;int all=inputStream.available();
        while (inputStream.available() > 0)
        {   //all++;
            int k=inputStream.read();
            if (k==32){c++;}
        }
        inputStream.close();
        //System.out.println(c);System.out.println(all);
        double d = (double)c/all*100;
        d = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);
    }//BigDecimal.ROUND_HALF_UP
}
