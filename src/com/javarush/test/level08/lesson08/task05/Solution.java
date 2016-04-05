package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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
        return map;//Напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {   HashMap<String, String> map1=new HashMap<String, String>();
        map1=map;
        List<String> list = new ArrayList<String>();//Напишите тут ваш код
        List<String> list1 = new ArrayList<String>();
        Iterator<Map.Entry<String, String>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            list.add(pair.getValue());list1.add(pair.getKey());
         }
        for ( int b = 0; b < 10; b++){
            for ( int j = b+1; j < 10; j++){
                if ( list.get(b).equals(list.get(j))){
                    map.remove(list1.get(b));
                    map.remove(list1.get(j));
                }
            }
        }


    }



    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
