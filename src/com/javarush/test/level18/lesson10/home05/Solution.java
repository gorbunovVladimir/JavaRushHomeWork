package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1=new BufferedReader(new FileReader(reader.readLine()));
        String s=reader1.readLine();
        //FileOutputStream file11=new FileOutputStream(reader.readLine());
        BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine(),true));
        String[] as = s.split(" "); String str="";
        for (int i=0;i<as.length;i++)
        {Double l1=Double.parseDouble(as[i]);as[i]= Math.round(l1)+" ";str+=as[i];}
        str.trim();
        bw.write(str);
        reader.close();bw.close();
    }
}
