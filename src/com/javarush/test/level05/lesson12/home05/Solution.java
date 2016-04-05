package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/
import java.io.*;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int k=0;BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;true;)
        {   String s=reader.readLine();
            if (s.equals("сумма"))
            {
                System.out.println(k);
                break;
            }
            int a = Integer.parseInt(s);
            k = k + a;

            a=0;s=null;//Напишите тут ваш код
    }}
}
