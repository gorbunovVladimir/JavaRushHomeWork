package com.javarush.test.level25.lesson07.home02;

import java.util.concurrent.*;

/* Все не так легко, как кажется
1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable
2. Реализуйте логику метода cancel в классе SocketTask
3. Реализуйте логику метода cancel для локального класса внутри метода newTask в классе SocketTask
*/
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }
}
/*
* https://www.google.com.ua/?gws_rd=ssl#q=java+Socket%2C+ThreadPoolExecutor%2C+RunnableFuture%2C+Callable
*http://jcip.net.s3-website-us-east-1.amazonaws.com/listings/SocketUsingTask.java
* */