package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    //public static ArrayList<Integer> ids = new ArrayList<Integer>();
    public static void main(String[] args){
        if(args.length < 2) return;
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            ArrayList<String> list = new ArrayList<String>();
            //String fileName="D:\\temp.txt";//
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = fileReader.readLine()) != null)
            {list.add(line);}
            fileReader.close();
            //getId(list);
            ArrayList<Integer> ids = getId(list);
            if (args[1].length() > 8) return;
            int id_parametr=Integer.parseInt(args[1]);
            if (Collections.frequency(ids, id_parametr) != 0)
            {
                if (args[0].equals("-d") && args.length == 2)
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    for (int i = 0; i < ids.size(); i++)
                    {
                        if (ids.get(i).equals(id_parametr))
                            list.remove(i);
                    }
                    for (String s : list)
                    {
                        writer.write(s);
                        writer.newLine();
                    }
                    writer.close();
                }
                if (args[0].equals("-u") && args.length >= 5)
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    try
                    {
                        String pronuctName = "";
                        for (int i = 2; i < args.length - 2; i++) pronuctName = pronuctName + args[i] + " ";
                        if (pronuctName.length() > 30) {pronuctName = pronuctName.substring(0, 30);}

                        String price = args[args.length - 2];
                        if (price.length() > 8) return;

                        String quantity = args[args.length - 1];
                        if (quantity.length() > 4) return;

                        String tovar = String.format("%-8.8s%-30.30s%-8.8s%-4.4s%n", id_parametr, pronuctName, price, quantity);
                        for (int i = 0; i < ids.size(); i++)
                        {
                            if (ids.get(i).equals(id_parametr))
                            {
                                list.set(i, tovar);
                            }
                        }
                        for (String s : list)
                        {
                            writer.write(s);
                            //writer.newLine();
                        }
                    }
                    catch (NumberFormatException e){System.out.println("Неверный формат параметров");}
                    writer.close();
                }
            } else return;
        }
        catch (IOException e){}
    }
    public static ArrayList<Integer> getId(ArrayList<String> list)
    {   //if(list.size()==0)return;
        ArrayList<Integer> ids=new ArrayList<Integer>();
        for (int i = 0; i <list.size() ; i++)
        {   //if(list.get(i).length()>50) return;
            int id=Integer.parseInt(list.get(i).substring(0, 8).replaceAll(" ", ""));
             ids.add(id);
        }return ids;
    }
}



