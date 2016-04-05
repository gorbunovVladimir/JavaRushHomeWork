package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
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
        FileOutputStream file1=new FileOutputStream(reader.readLine());
        FileInputStream file2=new FileInputStream(reader.readLine());
        FileInputStream file3=new FileInputStream(reader.readLine());
        /*byte[] buffer=new byte[file2.available()+file3.available()];
        if (file2.available()>0&&file3.available()>0)
        {   file2.read(buffer);file3.read(buffer);
            file1.write(buffer);
        }*/
        byte[] date2 = new byte[file2.available()];
        byte[] date3 = new byte[file3.available()];
        file1.write(date2, 0, file2.read(date2));
        file1.write(date3, 0, file3.read(date3));

        file1.close();file2.close();file3.close();

    }
}
