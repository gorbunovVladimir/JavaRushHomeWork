package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/





public class Solution implements Serializable {
    private static final long serialVersionUID = 1L;
    public static class SubSolution extends Solution {
        private static final long serialVersionUID = 7863262235394607247L;
        /*public SubSolution() throws NotSerializableException
        {
            throw new NotSerializableException();
        }*/

        private void writeObject(ObjectOutputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }


    }
}