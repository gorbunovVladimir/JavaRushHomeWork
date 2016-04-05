package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (int i=0;i<threads.length;i++)
        {switch (threads[i].getState()){
                case NEW: threads[i].start();break;
                case TIMED_WAITING:
                case WAITING:
                case BLOCKED:threads[i].interrupt();break;
                case RUNNABLE: threads[i].isInterrupted();break;
                case TERMINATED: System.out.println(threads[i].getPriority());break;
            }}

        /*{if (threads[i].getState().equals(Thread.State.NEW)){threads[i].start();}
         if (threads[i].getState().equals(Thread.State.WAITING)&&threads[i].getState().equals(Thread.State.TIMED_WAITING)){threads[i].interrupt();}
         if (threads[i].getState().equals(Thread.State.RUNNABLE)){threads[i].;}
            if (threads[i].getState().equals(Thread.State.TERMINATED)){System.out.println(threads[i].getPriority());}
        }*/
    }
}
