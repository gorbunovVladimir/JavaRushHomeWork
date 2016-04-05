package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
   /*  // BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));  //add your code here
      //  char[] arrS = reader.readLine().toCharArray();
        char[] arrS = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo".toCharArray();
        int c = arrS.length;
        for (int i = 0; i < arrS.length; i++){ if (arrS[i]=='?'){c=i;}}//ищим ?
        //ищим obj
        int c1 = arrS.length;int c2 = arrS.length;
        for (int i = c+1; i < arrS.length-3; i++)
               {if (new String(arrS, i, 3).equals("obj")){c1=i+4;
                 for (int j = c1; j < arrS.length; j++){{if (arrS[j]=='&'){c2=j;break;}}}}}
        String str = new String(arrS, c1, c2-c1);

        ArrayList<String> list=new ArrayList<String>();ArrayList<Integer> list1=new ArrayList<Integer>();list1.add(c+1);
       // for (int i = c+1; i < arrS.length; i++){if (arrS[i]=='=' || arrS[i]=='&'){list1.add(i);}}
        for (int i = c+1; i < arrS.length; i++){if (arrS[i]=='&'){list1.add(i);}}
        list1.add(arrS.length);
        for (int i=0;i<list1.size(); i++) { System.out.print(list1.get(i)+" 1 ");}

        try{for (int i = 0; i < list1.size(); i++) {int vl=list1.get(i+1)-list1.get(i);list.add(new String(arrS,list1.get(i),vl));}}
        catch (Exception e){}

        for (int i=0;i<list.size(); i++) { System.out.print(list.get(i)+" ");}
        System.out.println("");

        try {double l1=Double.parseDouble(str);alert(l1);}
        catch (Exception e){alert(str);}
        }*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String allArguments = s.substring(s.indexOf("?") + 1);
        String[] parsed = allArguments.split("&");
        for (int i = 0; i < parsed.length; i++) {
            //String currentArg = parsed[i];
            String[] currentArgArr = parsed[i].split("=");
            if(i == parsed.length - 1){
                System.out.print(currentArgArr[0]);
            }else{
                System.out.print(currentArgArr[0] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < parsed.length; i++) {
            //String currentArg = parsed[i];
            String[] currentArgArr = parsed[i].split("=");
            if(currentArgArr[0].equals("obj"))/*{
                if(currentArgArr[1].contains(".")){
                    alert(Double.parseDouble(currentArgArr[1]));
                }else{
                    alert(currentArgArr[1]);
                }
            }*/
            {try{alert(Double.parseDouble(currentArgArr[1]));}
            catch (Exception e){alert(currentArgArr[1]);}}
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
