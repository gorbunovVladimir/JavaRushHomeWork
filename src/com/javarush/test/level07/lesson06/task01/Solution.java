package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
       //list.set(0,"a"); list.set(1,"b");list.set(2,"c");list.set(3,"d");list.set(4,"e");
        list.add("a"); list.add("b"); list.add("c"); list.add("d"); list.add("e");
        //String s="a";list.set(4,s);
        System.out.println(list.size());
        //Напишите тут ваш код
        for (int i=0;i<list.size(); i++)
            System.out.println(list.get(i));
    }
}
