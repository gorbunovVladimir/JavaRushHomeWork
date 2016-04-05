package com.javarush.test.level16.lesson07.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Обратный отсчет
1. Разберись, что делает программа.
2. Реализуй логику метода printCountdown так, чтобы каждые полсекунды выводился объект из
переменной list в обратном порядке - от переданного индекса до нуля.
Пример: Передан индекс 3
Строка 2
Строка 1
Строка 0
*/

public class Solution {
    public static volatile List<String> list = new ArrayList<String>(5);

    static {
        for (int i = 0; i < 5; i++) {
            list.add("Строка " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Countdown(3));
        t.start();
    }

    public static class Countdown implements Runnable {
        private int countFrom;

        public Countdown(int countFrom) {
            this.countFrom = countFrom;
        }

        public void run() {
            try {
                while (countFrom > 0) {
                    printCountdown();
                }
            } catch (InterruptedException e) {
            }
        }

        public void printCountdown() throws InterruptedException {
            for (int i=countFrom-1;i+1>0;i--){
                System.out.println(list.get(i));Thread.sleep(500);if (i==0){countFrom=0;}
            }
           /* System.out.println(list.get(countFrom));Date l1=new Date();Thread.sleep(500);
            for (int i=0;i<countFrom;countFrom--){Date l2=new Date();System.out.println(l2.getTime()-l1.getTime());System.out.println(list.get(countFrom-1));

                Thread.sleep(500);}*/
            //System.out.println(list.get(countFrom));Thread.sleep(500);
           /* countFrom++;
            for (int i=0;i<countFrom;countFrom--){Thread.sleep(500);System.out.println(list.get(countFrom-1));

                }*/

            //add your code here - добавь код тут
        }
    }
}
