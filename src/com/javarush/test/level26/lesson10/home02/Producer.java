package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Vl on 06.04.2015.
 */
public class Producer implements Runnable
{    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();

        try {
            int k = 1;
            while (true) {
                String s=String.format("Some text for %d", k);
                map.putIfAbsent(String.valueOf(k), s);
                //System.out.println(s);
                Thread.sleep(500);
                k++;
                /*map.put(String.valueOf(k),"//");
                System.out.println(String.format("Some text for [%d]", k));
                Thread.sleep(500);
                k++;*/

            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
        }
    }
}
