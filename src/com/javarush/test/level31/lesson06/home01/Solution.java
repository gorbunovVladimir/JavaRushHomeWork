package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length!=2) return;

        String fileName = args[0];
        String zipFile = args[1];
        /*String fileName = "D:\\+.torrent";
        String zipFile = "D:\\test.zip";*/
        String substring = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
        System.out.println(substring);

        FileInputStream fos = new FileInputStream(zipFile);
        ZipInputStream zipInputStream = new ZipInputStream(fos);
        Map<String, ByteArrayOutputStream> map = new HashMap<>();

        ZipEntry zipEntry = null;
        while ((zipEntry = zipInputStream.getNextEntry()) != null)
        {
            if (zipEntry.isDirectory())
            {   map.put(zipEntry.getName(), null);
            } else
            {   //System.out.println(zipEntry.getSize()+"///"+(int)zipEntry.getSize());
                byte[] buff = new byte[(int)zipEntry.getSize()];
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int i = zipInputStream.read(buff);
                bos.write(buff, 0, i);
                map.put(zipEntry.getName(), bos);

               /* ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[8192*2];
                int count;
                while ((count = zipInputStream.read(buffer)) != -1) {
                    baos.write(buffer, 0, count);
                }
                map.put(zipEntry.getName(), baos);*/
            }
        }

        zipInputStream.close();
        fos.close();


        FileInputStream fis = new FileInputStream(fileName);
        byte[] buff = new byte[fis.available()];
        fis.read(buff);
        fis.close();

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        for (Map.Entry<String, ByteArrayOutputStream> pair : map.entrySet())
        {
            if (pair.getKey().equals(substring)||(pair.getKey().contains(File.separator)&& pair.getKey().substring(pair.getKey().lastIndexOf(File.separator)+1).equals(substring))) continue;
            zos.putNextEntry(new ZipEntry(pair.getKey()));
            if (pair.getValue() == null)
            {
                continue;
            }
            zos.write(pair.getValue().toByteArray());
        }

        zos.putNextEntry(new ZipEntry("new" + File.separator + substring));
        zos.write(buff);
        zos.close();
    }
}

