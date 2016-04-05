package com.javarush.test.level26.lesson05.task02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Трудолюбие - душа всякого дела и залог благосостояния.
Расставьте volatile там, где необходимо
*/
public class Solution {
    private static ScheduledExecutorService interruptScheduledExecutor;
    private static Thread taskThread;
    private static RethrowableTask task;

    public static void main(String[] args) throws Exception {
        // Запуск задании Шедулером(графиком)+ переопределяем метод run для какой-то нити,
        // НО она не стартуется....Скорее всего run - это инициаилизатор
        runTaskBySchedule(new Runnable() {
                              @Override
                              public void run() {
                                  System.out.println("A");
                                  throw new RuntimeException("it's test");
                              }
                          }, 1_000, TimeUnit.MILLISECONDS
        );
        interruptScheduledExecutor.shutdown();
    }

    public static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit) throws Exception {
        //Этот RethrowableTask task как бы запускает наш инициализаотр runnable в своем run методе и стартует свою нить
        task = new RethrowableTask(runnable);
        taskThread = new Thread(task);
        // Нить стартовала
        taskThread.start();

        // Используются утилиты конкурент
        // ScheduledExecutorService - запуск задания через определенные интервалы времени
        interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
        // Вот у нас задание, которое останавливает наш таск , скорее всего для запутывания
        // т.к наш таск НЕ while(!iSInterupted)
        interruptScheduledExecutor.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        // Текущая main нить присоединяется к нашему таску
        taskThread.join(unit.toMillis(timeout));
        // Итого 1-нить main 2- нить таск 3-нить в Шедулере
        // итого все три нити выкинут есепшн
        // 1ая main-  через task.rethrow()- Exception
        // 2ая task - RuntimeException в блоке run при инициализации
        // 3я - InteruptedException
        // Ответ готов, кто то первый из них займет перменную
        try {
            task.rethrow();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    public static class RethrowableTask implements Runnable {
        private volatile Throwable throwable;
        private Runnable runnable;

        public RethrowableTask(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            try {
                // запуск нити инициализатора параметров таска шедулера
                runnable.run();
            } catch (Throwable throwable) {
                this.throwable = throwable;
            }
        }

        public void rethrow() throws Exception {
            if (throwable != null) {
                System.out.println("B");
                throw new Exception(throwable);
            }
        }
    }
}

/*Не понимаю в чем дело, сначала попробовал volatile «где надо поставить», потом по одоному перебирал, но так и не приняло. WTF? точно один volatile должен быть?
класс-то у нас не один ;)*/
//Есть две нити, в одной переменная изменяется, в другой читается. Вывод: она должна быть волатильной…
//Суть в том, что разными нитями выбрасываются исключения. А переменная, хранящая исключение, всего одна.

