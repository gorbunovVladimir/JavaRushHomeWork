package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {String s=reader.readLine();
         if (s.equals("exit")){break;}
         ReadThread readThread = new ReadThread(s);
         readThread.start();
        }reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName="";
        public ReadThread(String fileName) {
            this.fileName=fileName;//implement constructor body
        }
        public void run()
        {   try{
            Map<Integer,Integer> list = new HashMap<Integer,Integer>();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available()>0){
                int kay = fileInputStream.read();
                if(list.containsKey(kay)){
                    int value = list.get(kay);
                    list.put(kay, ++value);
                }
                else list.put(kay, 1);
            }
            int tempValue=0;
            for(Map.Entry<Integer, Integer> l:list.entrySet()){
                if(tempValue<l.getValue())
                    tempValue = l.getValue();
            }
            for(Map.Entry<Integer, Integer> l:list.entrySet()){
                if(l.getValue()==tempValue)
                {resultMap.put(fileName,l.getKey());}
            }fileInputStream.close();}

        catch (Exception e){}
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
