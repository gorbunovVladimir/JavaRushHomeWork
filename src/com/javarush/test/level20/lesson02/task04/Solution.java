package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            System.out.println(loadedObject.staticString+" "+loadedObject.i+" "+loadedObject.j+"//ClassWithStatic //"+ClassWithStatic.staticString);
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            if(!staticString.equals("it's test static string")){
                writer.print("yes,");
                writer.print(staticString + ",");}
            else
                writer.print("no,empty,");

            if(i!=0){
                writer.print("yes,");
                writer.print(i + ",");}
            else
                writer.print("no,empty,");
            if(j!=0){
                writer.print("yes,");
                writer.print(j + ",");}
            else
                writer.print("no,empty,");
            //System.out.println(staticString+" "+i+" "+j);
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataInputStream reader = new DataInputStream(inputStream);
            String is;
            while ((is=reader.readLine())!=null)
            {
                String[] arr = is.split(",");
                if (arr[0].equals("yes")) staticString=arr[1];//System.out.println(staticString+" ="+arr[1]+" 00");
                if (arr[2].equals("yes"))i=Integer.parseInt(arr[3]);
                if (arr[4].equals("yes"))j=Integer.parseInt(arr[5]);
            }
           // System.out.println(staticString+" "+i+" "+j);
            reader.close();

        }
    }
}
