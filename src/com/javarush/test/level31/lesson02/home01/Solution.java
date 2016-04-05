package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/

    public class Solution {
        private static File path;

        public static void main(String[] args) {
            if (args.length < 2) return;
            path = new File(args[0]);
            File resultFileAbsolutePath = new File(args[1]);

            /*path = new File("d:\\0\\8\\");
            File resultFileAbsolutePath = new File("d:\\0\\8\\7\\7\\6\\vanya.txt");*/
            List<File> files = new ArrayList<>();

            try {
                files = getFileTree(path.getAbsolutePath(), resultFileAbsolutePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*for (int i=0;i<files.size();i++)System.out.print(files.get(i).getAbsolutePath() + " ");
            System.out.println("");*/

            removeEmptyFolders(path.getAbsolutePath());

            Collections.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

//        System.out.println(Arrays.toString(fileList.toArray()));
            File newFile = new File(resultFileAbsolutePath.getParent() + File.separator + "allFilesContent.txt");
//        System.out.println(newFile);
            if (newFile.exists()) {
                newFile.delete();
            }

            boolean isRenamed = resultFileAbsolutePath.renameTo(newFile);
//        System.out.println(isRenamed);
            resultFileAbsolutePath = newFile;
//        System.out.println(resultFileAbsolutePath.getAbsolutePath());

            try{
            FileOutputStream out = new FileOutputStream(resultFileAbsolutePath);
            for (int i = 0; i < files.size(); i++) {
                File file = files.get(i);
                InputStream in = new FileInputStream(file);
                byte buffer[] = new byte[in.available()];
                in.read(buffer);
                out.write(buffer);
                if (i < files.size() - 1)
                    out.write(System.lineSeparator().getBytes());
                //out.write("\n".getBytes());
                in.close();
            }
            out.close();
            }
            catch (FileNotFoundException e)
            {
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            //writeFilesContent(resultFileAbsolutePath, files);


        }

        private static void removeEmptyFolders(String root) {
            LinkedList<File> dirsQueue = new LinkedList<>();
            dirsQueue.add(new File(root));
            while (!dirsQueue.isEmpty()) {
                File dir = dirsQueue.poll();
                if (dir == null) {//? ?
                    break;
                }
                if (dir.isDirectory()) {
                    File[] files = dir.listFiles();
                    if (files != null && files.length != 0) {
                        for (File file : files) {
                            dirsQueue.push(file);
                        }
                    } else if (files != null) {
                        File parentDir = dir.getParentFile();
                        //System.out.println("delete "+dir.getAbsoluteFile()+"//"+dir.listFiles().toString()+" "+files.length);
                        dir.delete();
                        removeEmptyParents(parentDir);
                    }
                }
            }
        }

        private static void removeEmptyParents(File parentDir) {
            if (parentDir.equals(path)) {
                return;
            }
            File[] parentFiles = parentDir.listFiles();
            if (parentFiles != null && parentFiles.length == 0) {
                File superParent = parentDir.getParentFile();
                //System.out.println("delete parents "+parentDir.getAbsoluteFile()+"//"+parentDir.listFiles().toString()+" "+parentFiles.length);
                parentDir.delete();
                removeEmptyParents(superParent);
            }
        }

        /*private static void writeFilesContent(File resultFileAbsolutePath, List<File> files) {
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(resultFileAbsolutePath));

                BufferedReader bufferedReader = null;
                int count = 0;
                for (File filePath : files) {
                    count++;
                    try {
                        bufferedReader = new BufferedReader(new FileReader(filePath));
                        while (bufferedReader.ready()) {
                            String line = bufferedReader.readLine();
//                        System.out.println(line);
                            bufferedWriter.write(line);
                        }
                        if (count < files.size()) {
                            bufferedWriter.write(System.lineSeparator());
                        }
                        bufferedWriter.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }*/

        public static List<File> getFileTree(String root, File resultFileAbsolutePath) throws IOException {
            List<File> resultList = new ArrayList<>();
            Queue<File> fileQueue = new ArrayDeque<>();
            fileQueue.add(new File(root));
            while (!fileQueue.isEmpty()) {
                File file = fileQueue.poll();
                if (file.getAbsoluteFile().equals(resultFileAbsolutePath)) {//file==
                    continue;
                }
                if (file == null) {//?
                    break;
                }
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    if (files != null) {//?
                        Collections.addAll(fileQueue, files);
                    }
                } else {
                    if (file.length() > 50) {
                        //System.out.println("delete 50" + file.getAbsoluteFile() + "//" + file.length());
                        file.delete();
                    } else {
                        resultList.add(file.getAbsoluteFile());
                    }
                }
            }
            return resultList;
        }
    }

