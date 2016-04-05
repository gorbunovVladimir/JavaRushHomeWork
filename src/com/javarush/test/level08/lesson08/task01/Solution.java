package com.javarush.test.level08.lesson08.task01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> l1=new HashSet<String>();//Напишите тут ваш код

       /* l1.addAll(Arrays.asList("луна", "лига", "лайм", "лакост", "латвия", "лети", "лом", "лак", "лик", "лор", "лира", "лук", "лэп",
                "лирика", "ласка", "локоть", "лоб", "лим", "лаболатория", "лансер"));*/
        l1.add("луна");l1.add("лига");l1.add("лайм");l1.add("лакост");l1.add("латвия");l1.add("лети");l1.add("лом");l1.add("лак")
    ;l1.add("лик");l1.add("лор");l1.add("лира");l1.add("лук");
        l1.add("лэп");l1.add("лирика");l1.add("ласка");l1.add("локоть");l1.add("лоб");l1.add("лим");l1.add("лаболатория");l1.add("лансер");
 return l1;

    }
}
