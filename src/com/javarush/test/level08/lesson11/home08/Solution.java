package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        int[] array1 = new int[5];
        int c=array[0];int k,i;k=0;int b=c;
        for (i=1;i<array.length;i++){//Напишите тут ваш код
         // c= c < array[i] ? array[i]  : c ;
          if (c < array[i]){c=array[i];k=i;}
        }
        array1[0]=c;array[k]=-2147483648;c=b;

        for (i=1;i<array.length;i++){//Напишите тут ваш код
            if (c < array[i]){c=array[i];k=i;}
    }array1[1]=c;array[k]=-2147483648;c=b;

        for (i=1;i<array.length;i++){//Напишите тут ваш код
            if (c < array[i]){c=array[i];k=i;}
            }array1[2]=c;array[k]=-2147483648;c=b;

        for (i=1;i<array.length;i++){//Напишите тут ваш код
            if (c < array[i]){c=array[i];k=i;}
            }array1[3]=c;array[k]=-2147483648;c=b;

        for (i=1;i<array.length;i++){//Напишите тут ваш код
            if (c < array[i]){c=array[i];k=i;}
            }array1[4]=c;array[k]=-2147483648;c=b;
       for (i=0;i<5;i++){array[i]=array1[i];}
    }}
