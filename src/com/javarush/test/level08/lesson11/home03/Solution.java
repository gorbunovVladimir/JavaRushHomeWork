package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {  Map<String, String> map = new HashMap<String, String>();
        map.put("family","name");
        map.put("family","name");
        map.put("family2","name");
        map.put("family3","name1");
        map.put("family4","name2");
        map.put("family5","name2");
        map.put("family6","name2");
        map.put("family7","name2");
        map.put("family8","name2");
        map.put("family9","name3");
        return map;
        //Напишите тут ваш код

        //return null;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
