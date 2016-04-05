package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set1=new HashSet<Integer>(); //Напишите тут ваш код
      set1.add(1);set1.add(41);set1.add(21);set1.add(71);set1.add(13);set1.add(45);set1.add(56);set1.add(23);
        set1.add(9);set1.add(8);set1.add(7);set1.add(2);set1.add(3);set1.add(6);set1.add(36);set1.add(34);
        set1.add(12);set1.add(109);set1.add(580);set1.add(454);
        ;
        return set1;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
          Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext())
            {
                int t1 = iterator.next();
                if (t1>10) iterator.remove();

            }return set;
        }


        }
