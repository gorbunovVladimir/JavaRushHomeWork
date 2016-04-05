package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable
{
    public A getOriginalObject(ObjectInputStream objectStream) {

        Object object = new Object();
        try {
            object = objectStream.readObject();
        } catch (IOException e) {} catch (ClassNotFoundException e) {}
        if (object instanceof B)
            return (B) object;
        else if (object instanceof A)
            return (A) object;
        else
            return null;


    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
