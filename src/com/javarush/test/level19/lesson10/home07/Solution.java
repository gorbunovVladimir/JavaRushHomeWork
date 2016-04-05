package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);

        ArrayList<String> list = new ArrayList<String>();

        while (reader.ready())
        {
            String str = reader.readLine();
            String[] array = str.split(" ");
            for (int i = 0; i < array.length; i++)
                if (array[i].length() > 6) list.add(array[i]);
        }

        for (int i = 0; i < list.size(); i++)
        {
            if (i < (list.size() - 1))
                writer.write(list.get(i) + ",");
            else if (i < (list.size()))
                writer.write(list.get(i));
        }
        reader.close();
        writer.close();
    }


}


