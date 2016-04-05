package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            while (in.ready()) {
                int i = Integer.parseInt(in.readLine());
                if (i % 2 == 0)
                    list.add(i);}}
        catch (NumberFormatException e) {/*NOP*/}
        for (int i = 0; i <list.size() ; i++) { //сортируем по возрастанию
            for (int j = i+1; j <list.size() ; j++) {
                if (list.get(i)>list.get(j)){
                    int tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }
            }}
        for (int e=0;e<list.size();e++)
        {System.out.println(list.get(e));}
    }
}
