package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> list = new HashMap<Integer,Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        while (fileInputStream.available()>0){
            int kay = fileInputStream.read();
            if(list.containsKey(kay)){
                int value = list.get(kay);
                list.put(kay, ++value);
            }
            else list.put(kay, 1);
        }
       /* int tempValue=1;
        for(Map.Entry<Integer, Integer> l:list.entrySet()){
            for(Map.Entry<Integer, Integer> l2:list.entrySet())
                if(l.getValue()<l2.getValue())
                    tempValue = l2.getValue();
        }
        */
        int tempValue=0;
        for(Map.Entry<Integer, Integer> l:list.entrySet()){
            if(tempValue<l.getValue())
                tempValue = l.getValue();
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> l:list.entrySet()){
            if(l.getValue()==tempValue)
                list1.add(l.getKey());
        }

        Collections.sort(list1);
        for (Integer i:list1)
            System.out.print(i+" ");
        bufferedReader.close();
        fileInputStream.close();
    }
}
