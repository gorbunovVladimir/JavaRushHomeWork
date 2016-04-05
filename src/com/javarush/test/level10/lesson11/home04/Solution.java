package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] chars = s.toCharArray();
        for (int i=0;i< chars.length;i++)
        {   if (i==40){break;}
            System.out.println(new String(chars,0,chars.length-i));
            for (int k=0;k< chars.length;k++)
            {  if (k==chars.length-1){break;}
                chars[k] = chars[k + 1];
            }
        }
        //Напишите тут ваш код
    }

}
