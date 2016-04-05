package com.javarush.test.level28.lesson08.task01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* Знакомство с Executors
1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
2. В цикле отправь на исполнение в пул 10 тасок Runnable.
3. У каждой таски в методе run вызови метод doExpensiveOperation с порядковым номером таски начиная с 1, см. пример вывода
4. Запрети добавление новых тасок на исполнение в пул (метод shutdown)
5. Дай экзэкьютору 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS)
Не должно быть комментариев кроме приведенного output example
*/
public class Solution {
    public static AtomicInteger i=new AtomicInteger(1);
    public static void main(String[] args) throws InterruptedException {
        //Add your code here
        ExecutorService service=Executors.newFixedThreadPool(5);
        while(i.get()<=10){
            service.submit(new Runnable()
            {
                @Override
                public void run()
                {doExpensiveOperation(i.getAndIncrement());

                }
            });

        }
        /*for(int i=1; i<11; i++){
            final int localId = i;
            pool.execute(new Runnable() {
                @Override
                public void run()
                {
                    doExpensiveOperation(localId);
                }
            });
        }*/
        service.shutdown();
        service.awaitTermination(5,TimeUnit.SECONDS);

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
/*Задачу эту прошёл, но в процессе решения появился вопрос, а именно, почему в этом коде создаётся более 10 задач для пула?

Проблема в том, что эта штука `doExpensiveOperation(i.getAndIncrement()); не будет срабатывать каждую итерацию цикла,
поэтому создается так много тасок. Можете поэксперементировать и инкремент сделать при оглашении цикла, тогда будет
именно 10 тасок, но обратите внимание на значение localId)
 */