package com.javarush.test.level09.lesson08.task04;

import java.io.IOException;
import java.rmi.RemoteException;

/* Перехват checked исключений
В методе processExceptions обработайте все checked исключения.
Нужно вывести на экран каждое возникшее checked исключение.
Можно использовать только один блок try..
*/

public class Solution {
    public static void main(String[] args) {
        processExceptions(new Solution());

    }

    public static void processExceptions(Solution obj) {

    try
    {/*int i = (int) (Math.RANDOM() * 3);
        if (i == 0)
        {obj.method1();}
        if (i == 1)
            obj.method2();
        if (i == 2)
            obj.method3();}*/
        obj.method1();obj.method2();obj.method3();
    }

    catch (NoSuchFieldException e)
    {System.out.println(e);}
    catch (RemoteException e)
    {System.out.println(e);}
    catch (IOException e)
    {System.out.println(e);}

    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
