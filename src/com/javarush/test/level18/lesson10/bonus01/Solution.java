package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        File createFile = new File(args[2]);
        createFile.createNewFile();
        FileInputStream readFile = new FileInputStream(args[1]);
        FileOutputStream writeFile = new FileOutputStream(args[2]);

        if(args[0].equals("-e"))
        {
            byte[] byteFile = new byte[readFile.available()];
            int len = readFile.read(byteFile);

            for(int i = 0; i < len; i++)    // Шифруем увеличивая каждый байт на 1
            {
                byteFile[i]++;
            }

            writeFile.write(byteFile, 0, len);
        }
        else if(args[0].equals("-d"))
        {
            byte[] byteFile = new byte[readFile.available()];
            int len = readFile.read(byteFile);

            for(int i = 0; i < len; i++)    // Дешифруем уменьшая каждый байт на 1
            {
                byteFile[i]--;
            }

            writeFile.write(byteFile, 0, len);
        }
        else
        {
            System.out.println("Wrong!");
        }


        readFile.close();
        writeFile.close();
    }

}
