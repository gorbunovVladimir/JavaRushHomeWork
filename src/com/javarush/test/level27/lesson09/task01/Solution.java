package com.javarush.test.level27.lesson09.task01;

import java.util.concurrent.CountDownLatch;

/*CountDownLatch
Дана стандартная реализация методологии wait-notify.
Почитайте про CountDownLatch и перепишите тело метода someMethod используя поле latch.
Весь лишний код удалите из класса.
*/
public abstract class Solution {
   // private final Object lock = new Object();
   // private volatile boolean isWaitingForValue = true;

    private final CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        //synchronized (lock) {while (isWaitingForValue) {lock.wait();}}
        latch.await();
        retrieveValue();
        //isWaitingForValue = false;lock.notify();
        latch.countDown();
    }

    abstract void retrieveValue();
}
/*public class Solution
{   public static class LatchedThread extends Thread
    {   private final CountDownLatch startLatch;
        public LatchedThread(CountDownLatch startLatch)
        {
            this.startLatch = startLatch;
        }
        public void run()
        {   System.out.println("PreRun");
            try {startLatch.await();System.out.println("Run");}
            catch (InterruptedException iex){}
        }
    }
    public static void main(String[] args) throws Exception {
    CountDownLatch startLatch = new CountDownLatch(1);
    for(int threadNo = 0;threadNo<4;threadNo++){Thread t = new LatchedThread(startLatch); t.start();}
    Thread.sleep(200);
    startLatch.countDown();
}}*/
