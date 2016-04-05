package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {

        public static void main(String[] args) throws IOException
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
            int outputFile1BytesCount = fileInputStream.available();
            byte[] outputFile1Bytes = new byte[outputFile1BytesCount];

            fileInputStream.read(outputFile1Bytes);

            for (int i=outputFile1Bytes.length-1;i>=0;i--) {
                fileOutputStream1.write(outputFile1Bytes[i]);
                //System.out.println(String.valueOf(outputFile1Bytes[i])+" "+i);
            }

            fileInputStream.close();
            reader.close();
            fileOutputStream1.close();
        }
    }

