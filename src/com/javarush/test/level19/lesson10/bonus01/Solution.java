package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr1 = new BufferedReader(new FileReader(br.readLine()));
        BufferedReader fr2 = new BufferedReader(new FileReader(br.readLine()));

        /*BufferedReader fr1 = new BufferedReader(new FileReader("D:\\temp.txt"));
        BufferedReader fr2 = new BufferedReader(new FileReader("D:\\temp1.txt"));*/
        br.close();
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();
        while (true)
        {
            String s = fr1.readLine();
            if (s == null)
                break;
            file1.add(s);
        }
        fr1.close();
        while (true)
        {
            String s = fr2.readLine();
            if (s == null)
                break;
            file2.add(s);
        }
        fr2.close();
        int j=0;
        for (int i=0;i< file1.size();i++)
        {   //if ((j==file2.size()-1)&&(i<file1.size())){lines.add(new LineItem(Type.REMOVED, file1.get(i)));i++;}
            if (file1.get(i).equals(file2.get(j))){lines.add(new LineItem(Type.SAME, file1.get(i)));j++;}
            else {if ((j<file2.size()-1)&&(file1.get(i).equals(file2.get(j+1)))){lines.add(new LineItem(Type.ADDED, file2.get(j)));j++;i--;}
                  else {lines.add(new LineItem(Type.REMOVED, file1.get(i)));}

            }
            if ((i==file1.size()-1)&&(j<file2.size())){lines.add(new LineItem(Type.ADDED, file2.get(j)));}

        }

        for (LineItem li : lines)
        {
            System.out.println(li.type.toString() + " " + li.line);
        }
    }
    public static enum Type {
        ADDED, //добавлена новая строка
        REMOVED, //удалена строка
        SAME //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
