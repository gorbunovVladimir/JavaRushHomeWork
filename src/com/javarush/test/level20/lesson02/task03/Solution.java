package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
     /*public static void main(String[] args) throws Exception {
        new Solution().fillInPropertiesMap();

        for(Map.Entry<String,String> entry: properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " - " + value);
        }
    }*/


    public void fillInPropertiesMap() {
        /*BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {BufferedReader reader1=new BufferedReader(new FileReader(reader.readLine()));
            while (reader1.ready())
            {String s=reader1.readLine();
             StringBuilder s1=new StringBuilder("");StringBuilder s2=new StringBuilder("");
                String arg[]=s.split(" ");
             if (arg[0].equals("#")||arg[0].equals("!")){break;}
             for (int i=0;i<arg.length;i++)
             {if (arg[i].equals("=")){
                 for (int j=0;j<i;j++){if (j==i-1){s1.append(arg[i]);break;} s1.append(arg[i]+" ");}
                 for (int j=i;j<arg.length;j++){
                     if (arg[arg.length-1].equals("\\")){String se[]=reader1.readLine().split(" ");s2.append()}
                     s2.append(arg[i]);}
             }}
            }
        }
        catch (IOException e){e.printStackTrace();}*/
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
//        FileOutputStream fos = new FileOutputStream("test2");
            load(fis);
//        save(fos);
            fis.close();
//        fos.close();
        }
        catch (IOException e){e.printStackTrace();}
        catch (Exception e){e.printStackTrace();}

        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for(Map.Entry<String,String> entry: properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            prop.setProperty(key,value);// set the properties value
        }
        prop.store(outputStream,null);// save properties to project root folder
        outputStream.close();

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);// load a properties file
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);// get the property value
            properties.put(key,value);
        }
        inputStream.close();

    }
}
