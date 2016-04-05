package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "Windows-1251"));
        //BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        ArrayList<String> dataLine = new ArrayList<String>();
        //Записываем все слова из файла в ArrayList.
        while(in.ready()){
            dataLine.addAll(Arrays.asList((in.readLine().split(" "))));
        }in.close();

        for(int i = 0; i < dataLine.size(); i++)
        {   for(int j = 0; j < dataLine.size();)
            {   StringBuilder stringBuilder = new StringBuilder(dataLine.get(i));
                String s = stringBuilder.reverse().toString();
                //Если перевернутая строчка равна обычной строчке, сохраняем данные в result
                //уже записанные данные из dataList удаляем.
                if(dataLine.get(j).equals(s)&&j!=i)
                {
                    Pair pair = new Pair();
                    pair.first = dataLine.get(j);
                    pair.second = dataLine.get(i);
                    result.add(pair);
                    dataLine.remove(j);
                    dataLine.remove(i);
                    j = 0;
                }
                else
                    j++;
            }
        }

        for (Pair pr : result){System.out.println(String.format("\"%s\" - \"%s\"",pr.first, pr.second));}
    }


    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
/*?
D:\temp.txt
система



аметсис еще



еще


"аметсис" - "система"
"" - ""
"" - ""
"еще" - "еще"
"" - ""


 */