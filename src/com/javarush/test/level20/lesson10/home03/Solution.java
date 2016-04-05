package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 1L;
    public static class A {
        protected String name = "A";
        public A() { }
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        private static final long serialVersionUID = 1L;
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject(); // дефолтная сериализация (метод аналогичен используемому при обычной сериализации)
            // код сериализации нужных нам переменных
            String n = (String) s.readObject();
            name = n;

        }
        private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject(); // дефолтная десериализация
            // код десериализации нужных нам переменных (метод аналогичен используемому при обычной десериализации)
            s.writeObject(this.name);

        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);
        Solution s = new Solution();
        B b = s.new B("aaa");
        oos.writeObject(b);
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
        B bb = (B)ois.readObject();
        //System.out.print(bb.name);
    }
}
