package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {  int[] array1 = new int[20];
        int[] array = new int[10];
        int[] arrayInt = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < array1.length; i++)
        {
            array1[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < array1.length-10; i++)
        {
            array[i]=array1[i];
        }
        for (int i = 10; i < array1.length; i++)
        {
            arrayInt[i-10]=array1[i];
        }

        //Напишите тут ваш код
        for (int i=0;i<arrayInt.length; i++)
            System.out.println(arrayInt[i]);
    }
}
