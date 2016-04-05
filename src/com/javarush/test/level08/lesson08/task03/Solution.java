package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map=new HashMap<String, String>();//Напишите тут ваш код
        map.put("family","name");
        map.put("family1","name");
        map.put("family2","name");
        map.put("family3","name1");
        map.put("family4","name2");
        map.put("family5","name2");
        map.put("family6","name2");
        map.put("family7","name2");
        map.put("family8","name2");
        map.put("family9","name3");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
       /* Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ":" + value);
        }
    }*/
    int k=0;
    for (Map.Entry<String, String> pair : map.entrySet())
    {String value = pair.getValue();
        if (value.equals(name)) k++;
        //System.out.println(key + ":" + value);
    } return k;
       //Напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {   int k=0;
        for (Map.Entry<String, String> pair : map.entrySet())
        { String key = pair.getKey();
            if (key.equals(familiya)) k++;
            //System.out.println(key + ":" + value);
        } return k;



    }
}
