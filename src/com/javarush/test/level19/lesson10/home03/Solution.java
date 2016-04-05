package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready())
        {String s=reader.readLine();
         String[] sn=s.split(" ");
         StringBuilder name=new StringBuilder("");
         Calendar calendar = new GregorianCalendar(Integer.parseInt(sn[sn.length-1]), Integer.parseInt(sn[sn.length-2])-1, Integer.parseInt(sn[sn.length-3]));
         for (int i=0;i<sn.length-3;i++) name.append(sn[i]+" ");
         PEOPLE.add(new Person(new String(name).trim(),calendar.getTime()));
         }
        reader.close();


        }
    }


