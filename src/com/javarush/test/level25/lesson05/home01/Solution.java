package com.javarush.test.level25.lesson05.home01;

/* Мониторинг состояния нити
В отдельном классе создать нить LoggingStateThread,
которая будет выводить в консоль все изменения состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        Thread.sleep(100);
        target.start();  //NEW
        Thread.sleep(10000); //RUNNABLE
        target.join(10000);
        //target.sleep(100000);
        Thread.sleep(4000);
        target.interrupted(); //TERMINATED
        Thread.sleep(500);
    }

}
