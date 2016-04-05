package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());//bufferedReader.readLine()

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        while (fileInputStream.available()>0){
            int kay = fileInputStream.read();
            if (!list1.contains(kay)){list1.add(kay);}
            }
        Collections.sort(list1);

        /*Set<Integer> set = new TreeSet<Integer>();
        while (fileInputStream.available() > 0) {
            set.add(fileInputStream.read());
        }
        for (Integer next : set) {
            System.out.print(next + " ");
        }*/

        for (Integer i:list1) System.out.print(i+" ");
        bufferedReader.close();
        fileInputStream.close();
    }
}
