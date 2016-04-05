package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{   public static class Cat{}
    public static class Dog{}
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();
        for (int i=0;i<4;i++){result.add(new Cat());}
        return result;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> result1 = new HashSet<Dog>();
        for (int i=0;i<3;i++){result1.add(new Dog());}
        return result1;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {  HashSet<Object> result2 = new HashSet<Object>();
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext())
        {
            result2.add(iterator.next());
         }
        Iterator<Dog> iterator2= dogs.iterator();
        while (iterator2.hasNext())
        {
            result2.add(iterator2.next());
        }
        return result2;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {   pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets)
    {
        Iterator<Object> iterator3 = pets.iterator();
        while (iterator3.hasNext())
        {
          System.out.println(iterator3.next());
        }//Написать тут ваш код
    }

    //Написать тут ваш код
}
