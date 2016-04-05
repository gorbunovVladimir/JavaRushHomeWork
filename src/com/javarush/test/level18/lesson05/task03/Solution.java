package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        //byte[]buffer=new byte[inputStream.available()];
        /*byte[]buffer=new byte[1000000];
        while (inputStream.available() > 0)
            {int count=inputStream.read(buffer);
             if (count%2==0){
             outputStream1.write(buffer,0,count/2);
             outputStream2.write(buffer,count/2,count);}
             else {
                 outputStream1.write(buffer,0,(count+1)/2);
                 outputStream2.write(buffer,((count+1)/2),count);}
            }*/
        byte[] date2 = new byte[inputStream.available() / 2];
        byte[] date = new byte[inputStream.available() - inputStream.available() / 2];
        outputStream1.write(date, 0, inputStream.read(date));
        outputStream2.write(date2, 0, inputStream.read(date2));



        inputStream.close();outputStream1.close();outputStream2.close();
        //reader.close();
    }
}
