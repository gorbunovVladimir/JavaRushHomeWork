package com.javarush.test.level31.lesson06.bonus01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {   if (args.length < 2){return;}
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String[] fileParts = new String[args.length - 1];
        for (int i = 0; i < fileParts.length; i++)
        {fileParts[i] = args[i + 1];
        }

        Arrays.sort(fileParts);

        for (int i = 0; i < fileParts.length; i++)
        {
            baos.write(Files.readAllBytes(Paths.get(fileParts[i])));
        }

        baos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

        ZipInputStream zis = new ZipInputStream(bais);
        bais.close();
        ByteArrayOutputStream tempBaos = new ByteArrayOutputStream();
        try {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
              byte[] buffer = new byte[1024];
              int count;
              while ((count = zis.read(buffer)) != -1)
               {
               tempBaos.write(buffer, 0, count);
               }}}
        finally
        {tempBaos.close();
         zis.close();
        }
        Files.write(Paths.get(args[0]), tempBaos.toByteArray());
    }
}
