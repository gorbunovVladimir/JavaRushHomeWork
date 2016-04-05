package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(!args[0].equals("-c"))
            return;
        if(args.length < 4)
            return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String productName = getProductName(args);
        String price = args[args.length - 2];
        if (price.length() < 8) {
            for (int i = price.length(); i < 8; i++) {
                price += " ";
            }
        } else if(price.length() > 8)
            return;
        String quantity = args[args.length - 1];
        if (quantity.length() < 4) {
            for (int i = quantity.length(); i < 4; i++) {
                quantity += " ";
            }
        } else if (quantity.length() > 4)
            return;
        String id = getMaxIDIncremented(fileName);
        if(id == null)
            return;


        FileWriter fw = new FileWriter(fileName, true);
        fw.write("\r\n" + id + productName + price + quantity);
        fw.flush();
        fw.close();
    }

    public static String getMaxIDIncremented(String fileName) throws IOException
    {
        String id;
        int tmpID;
        int max = 0;
        BufferedReader freader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        while((line = freader.readLine()) != null) {
            try {
                if (line.isEmpty())
                    continue;
                tmpID = Integer.parseInt(line.substring(0, 8).trim());
                if(tmpID > max)
                    max = tmpID;
            } catch (NumberFormatException e) { continue; }
            catch (IndexOutOfBoundsException e) { continue; }
        }
        freader.close();
        if(max == 99999999) {
            return null;
        }
        max++;
        id = "" + max;
        if(id.length() < 8) {
            for (int i = id.length(); i < 8; i++) {
                id += " ";
            }
        }
        return id;
    }

    public static String getProductName(String par[]) {
        String name = "";
        for (int i = 1; i < par.length - 2; i++) {
            name += par[i] + " ";
        }
        if (name.length() > 30) {
            name = name.substring(0, 30);
        }   else if (name.length() < 30) {
            for (int i = name.length(); i < 30; i++)
                name += " ";
        }
        return name;
    }
}