package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).
Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < 32; i++)
        {
            alphabet.add((char) ('а' + i));
        }
        alphabet.add(6, 'ё');
       // System.out.println(alphabet);
        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        Map<Character, Integer> mapOfChars = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < alphabet.size(); i++)
        {   //System.out.print(alphabet.get(i));
            mapOfChars.put(alphabet.get(i),0);
        }

        for (int i = 0; i < 33; i++)
        {for (int j=0;j<list.size();j++)
            {char[] arrS = list.get(j).toCharArray();
            for (int k=0;k<arrS.length;k++)
              {if (alphabet.get(i).equals(arrS[k]))
              {for( Map.Entry<Character, Integer> pair : mapOfChars.entrySet() )
                if( alphabet.get(i).equals(pair.getKey()) ){ pair.setValue(pair.getValue()+1);}}}



            }}
        for (Map.Entry<Character,Integer> pair : mapOfChars.entrySet()) { System.out.println(pair.getKey() + " " + pair.getValue()); }
        //Напишите тут ваш код
    }}