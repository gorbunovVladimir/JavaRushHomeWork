package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();
        FileInputStream file1=new FileInputStream(s);
        FileInputStream file2=new FileInputStream(reader.readLine());
        byte[] date1 = new byte[file1.available()];
        byte[] date2 = new byte[file2.available()];
        file1.read(date1);
        file1.close();
        FileOutputStream file11=new FileOutputStream(s);
        file11.write(date2, 0, file2.read(date2));
        file11.write(date1, 0, date1.length);
        file11.close();file2.close();
    }
}
