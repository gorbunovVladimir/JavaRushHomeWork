package com.javarush.test.level16.lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;Date l1;

        public void run() {
            try {l1=new Date();sleep(100000000);
                //add your code here - добавьте код тут
            } catch (InterruptedException e) {Date l2=new Date();seconds=(int)(l2.getTime()-l1.getTime())/1000;
                System.out.println(seconds);
            }
        }
    }
}
/*System.out.println(list.get(countFrom));Date l1=new Date();Thread.sleep(500);
        for (int i=0;i<countFrom;countFrom--){Date l2=new Date();System.out.println(l2.getTime()-l1.getTime());System.out.println(list.get(countFrom-1));
*/