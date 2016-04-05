package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution
{   public static class TooShortStringException extends Exception
    {}

    public static String getPartOfString(String string) throws TooShortStringException
    {   //?if(string.isEmpty())throw new TooShortStringException();

        //?if (string.length()<2) throw new TooShortStringException();

       /*
        char[] chars = string.toCharArray();
        int countTab = 0;
        for (char ch : chars)
        {
            if (ch == '\t')
            {countTab++;}

        }
        String result;
        if (countTab < 2)
        {
            throw new TooShortStringException();
        } else
        {
            result = string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t"));
        }
        return result;
        */
        if(string == null)throw new TooShortStringException();
        int openingTabIdx, closingTabIdx;
        openingTabIdx = string.indexOf('\t');
        closingTabIdx = string.indexOf('\t', openingTabIdx + 1);
        if (openingTabIdx==-1 || closingTabIdx==-1) throw new TooShortStringException();
        return string.substring(openingTabIdx+1, closingTabIdx);

    }
}