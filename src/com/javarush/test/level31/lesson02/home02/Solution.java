package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> resultList = new ArrayList<>();
        Queue<File> fileQueue = new ArrayDeque<>();
        fileQueue.add(new File(root));
        while (!fileQueue.isEmpty()) {
            File file = fileQueue.poll();
            if (file == null) {
                break;
            }
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    Collections.addAll(fileQueue, files);
                }
            } else {
                resultList.add(file.getAbsolutePath());
            }
        }
        return resultList;
    }
}

