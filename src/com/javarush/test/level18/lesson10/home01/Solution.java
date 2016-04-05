package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
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
            if ((k>=65&&k<=90)||(k>=97&&k<=122)){c++;}
        }
        System.out.println(c);
        inputStream.close();
    }
}

