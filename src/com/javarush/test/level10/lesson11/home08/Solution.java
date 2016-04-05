package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arrayOfStringList=new ArrayList[7];
        for (int i=0;i<7;i++)
        {arrayOfStringList[i]=new ArrayList<String>();
            for (int k=0;k<3;k++){
        arrayOfStringList[i].add("ffwe");}
        }
        //Напишите тут ваш код
       /* ArrayList<string> arrayList1 = new ArrayList<string>();
        arrayList1.add("Создать");
        ArrayList<string> arrayList2 = new ArrayList<string>(); arrayList2.add("массив");*/

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}