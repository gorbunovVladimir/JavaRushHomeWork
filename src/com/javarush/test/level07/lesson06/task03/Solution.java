package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
       /* ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> array = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));String s;
       for (int i = 0; i < 5; i++)
        { s=reader.readLine();
            list.add(s);//list.set(i,s);
        }
        for(int i = 0; i <5; i++){
            int k=list.size() - i - 1;
            array.add(k, list.get(i));
            System.out.println(array.get(i));
            }*/
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<5;i++)
            list.add(in.readLine());
        for (int i=4;i>=0;i--)
            System.out.println(list.get(i));
      /*  for (int i = 0; i < 5; i++)
        { //String s=
            list.set(i,array.get(i));
            System.out.println(list.get(i));
        }*/
       //list.set(0,"a"); list.set(1,"b");list.set(2,"c");list.set(3,"d");list.set(4,"e");
       /* list.add("101"); list.add("102"); list.add("103"); list.add("104"); list.add("105");
        list.remove(0);list.remove(1);list.remove(2);
        //String s="a";list.set(4,s);
        //System.out.println(list.size());
        //Напишите тут ваш код*/
      /*  for (int i=0;i<list.size(); i++)
            System.out.println(list.get(i));//Напишите тут ваш код
        System.out.println(list.size()); //Напишите тут ваш код*/

    }
}
