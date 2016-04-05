package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Vl on 06.04.2015.
 */
public class Consumer implements Runnable
{   protected BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try
        {   //String msg="";
            //for (int i=0;i<queue.size();i++)
            while (true)
            System.out.println(queue.take());
        }
        catch (InterruptedException e){ System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));/*e.printStackTrace();*/}
    }
}
