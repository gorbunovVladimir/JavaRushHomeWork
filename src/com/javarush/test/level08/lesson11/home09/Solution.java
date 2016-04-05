package com.javarush.test.level08.lesson11.home09;


import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("JANUARY 1 2015");
    }
    public static boolean isDateOdd(String date)
    {
        Date yearStartTime = new Date() ;
        yearStartTime.setHours(-2) ;
        yearStartTime.setMinutes(0) ;
        yearStartTime.setSeconds(0) ;
        yearStartTime.setDate(1) ;
        yearStartTime.setMonth(0) ;
        Date today = new Date (date) ;
        long cd = today.getTime() ;
        int days = (int) ((cd - yearStartTime.getTime())/(24*3600*1000)) ;
        if (days % 2 == 0) return false;        else return true;
    }
}