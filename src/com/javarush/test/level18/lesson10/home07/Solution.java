package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(reader1.readLine()));

        while(true){
        String s=reader.readLine();
        if(s.startsWith(args[0] + " ")) {
            System.out.println(s);
            /*int c=s.indexOf(" ");
            System.out.println(s.substring(c + 1));*/
            break;}}
        /*
        ArrayList<String> list = new ArrayList<String>();
        while(true){
        String s=reader.readLine();
        if (s.isEmpty()) break;
        list.add(s);}

        for (int i=0;i<list.size();i++){
            if(list.get(i).startsWith(args[0]+" ")) {
            int c=list.get(i).indexOf(" ");
            System.out.println(list.get(i).substring(c+1));
            break;}}
        reader.close();reader1.close();*/
        reader.close();reader1.close();

    }
}