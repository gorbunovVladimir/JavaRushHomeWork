package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<String, Double>();
        while (reader.ready())
        {
            String[] s = reader.readLine().split(" ");
            if (!map.containsKey(s[0]))
            {
                map.put(s[0], Double.parseDouble(s[1]));
            } else
            {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            }
        }
        Double db = Double.MIN_VALUE;
        StringBuilder s = new StringBuilder("");
        for (Map.Entry<String, Double> lk : map.entrySet())
        {

                if (lk.getValue() == db)
                {
                    s.append(lk.getKey() + " ");
                }
                if (lk.getValue() > db)
                {
                    s = new StringBuilder(lk.getKey() + " ");
                }
            }
            System.out.println(s);
            reader.close();
        }
    }

