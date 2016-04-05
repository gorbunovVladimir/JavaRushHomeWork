package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //Написать тут ваш код. step 3 - пункт 3
       /* Iterator<Cat> i = cats.iterator();
        i.next();
        i.remove();*/
        Iterator<Cat> i = cats.iterator();
        Cat cat = i.next();
        i.remove();

        printCats(cats);
    }
    public static class Cat
    {}
    public static Set<Cat> createCats()
    {   Set<Cat> set = new HashSet<Cat>();
        Cat cat1 = new Cat();Cat cat2 = new Cat();Cat cat3 = new Cat();
        set.add(cat1);
        set.add(cat2);
        set.add(cat3);

        //Написать тут ваш код. step 2 - пункт 2
        return set;
    }

    public static void printCats(Set<Cat> cats)
    {
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext())
        {
            //String text = iterator.next();
            System.out.println(iterator.next());
        }// step 4 - пункт 4
    }

    // step 1 - пункт 1
}
