package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception//NullPointerException
        try {float i = 1 / 0;}
        catch (Exception e) {exceptions.add(e);}//ArithmeticException e
        try {String[] catNames = {"Васька", "Барсик", "Мурзик"};catNames[3] = "Рыжик";}
        catch (Exception e) {exceptions.add(e);}//ArrayIndexOutOfBoundsException
        try {throw new NoSuchFieldException();}
        catch (Exception e) {exceptions.add(e);}//NoSuchFieldException
        try { throw new RemoteException();}
        catch (Exception e) {exceptions.add(e);}//RemoteException
        try {throw new NumberFormatException();/*BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(System.in)));
            while (in.ready()) {int i = Integer.parseInt(in.readLine()); if (i % 2 == 0){} if (in.readLine().isEmpty()) break;}
        */}
        catch (Exception e) {exceptions.add(e);}//NumberFormatException        //IOException
        try {throw new IndexOutOfBoundsException();}
        catch (Exception e) {exceptions.add(e);}//IndexOutOfBoundsException
        try {Thread.sleep(100);throw new InterruptedException();}
        catch (Exception e) {exceptions.add(e);}//InterruptedException
        try {throw new FileNotFoundException();}
        catch (Exception e) {exceptions.add(e);}//FileNotFoundException
        try {throw new RuntimeException();}
        catch (Exception e) {exceptions.add(e);}//RuntimeException
        try {throw new IOException();}
        catch (Exception e) {exceptions.add(e);}//IOException
        //Add your code here
    }
}
