package com.javarush.test.level25.lesson11.task01;

import java.util.Random;

/* Обеспечение отсутствия прерывания важной операции
Если RANDOM.nextInt(5000) больше порогового значения THRESHOLD_VALUE,
то обеспечьте переуступку кванта времени.
Добавьте этот код в единственное допустимое место.
*/
public class Solution {
    private static final double THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {
        from.setBalance(from.getBalance() - amount);
        if (THRESHOLD_VALUE < RANDOM.nextInt(5000))
        {Thread.yield();}
        //почему с currentThread() не прошло
        //public static void yield()
        //На сколько я понимаю, метод yield() — это статический метод класса Thread, он сам по себе действует в отношении текущей нити, более подробно, к сожалению, пока не могу.


        to.setBalance(to.getBalance() + amount);
    }

    private class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}
