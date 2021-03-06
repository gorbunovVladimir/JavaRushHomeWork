package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
/*public class Solution {
    public static int[] getNumbers(int N) {
        int[] result = null;
        return result;
    }
}*/
public class Solution {
    public static int[] getNumbers(int N) {
        final int NUMBERS = 10;
        final int SQRT = 12;
        List<Integer> list = new ArrayList<>();
        long [][] przv = new long[NUMBERS][SQRT];
        for (int i = 0; i < NUMBERS; i++) {
            for (int j = 0; j < SQRT; j++) {
                long temp = i;
                for (int z = 0; z < j - 1; z++) {temp *= i;}
                przv[i][j] = temp;
            }
        }

        for (int i = 1; i < N; i++) {
            long mult = 0;
            int stp = 0;

            boolean flag = false;

            int num = i;
            int last = -1;
            while (num > 0) {
                if (last == -1) {
                    last = num % 10;
                    num = num / 10;
                    stp++;}
                else if (num % 10 <= last) {
                    last = num % 10;
                    if (last == 0) {last = 10;}
                    num = num / 10;
                    stp++;
                    continue;}
                else {
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            long res = 0;
            for (int j = i; j > 0; j /= 10) {res += przv[j % 10][stp];}
            int len = 0;
            for (long j = res; j > 0; j /= 10) {
                mult += przv[(int)(j % 10)][stp];
                len++;
            }

            if (res == mult && stp == len) {
                boolean flag2 = true;
                for (Integer num1 : list) {
                    if (num1.intValue() == res) {
                        flag2 = false;
                        break;
                    }
                }
                if (flag2) {
                    list.add((int) res);
                }
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++){if (list.get(i)>N) {list.remove(i);}/*if (list.get(i)<N)break;*/}
        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int[] m = getNumbers(150000000);
        Long t1 = System.currentTimeMillis();
        for (int a : m) {
            System.out.println(a);
        }
        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024d) + " Mb.");
        System.out.println("Time: " + (t1 - t0)/1000d + " sec.");
    }
}
/*
ноль в данном случае натуральным числом не считается

память как здесь -http://stackoverflow.com/questions/17374743/how-can-i-get-the-memory-that-my-java-program-uses-via-javas-runtime-api

1. Не надо использовать медленные Hash-коллекции;
2. Работайте с числами, не переводите их в строку и обратно. Алгоритмы поиска цифр в числах элементарны, просто нужно один раз понять - ускорите раза в 2 алгоритм;
3. Сделайте массив всех цифр во всех возможных степенях и не возводите каждый раз в степень при вычислении - раза в 4 быстрее, чем в лоб возводить каждый раз;
4. (опционально) перебирайте значения, а не числа - это самое сложное и задача проходит без этого;
5. Внимательно вглядитесь в строчку: public static int[] getNumbers(int N);

http://info.javarush.ru/search/topics/?q=level20.lesson10.bonus01
http://acmp.ru/article.asp?id_text=198,


Дело в том, что 1 сек это ~ (приблизительно) 100 млн операций. значит 10 сек это 1 млрд операций
Теперь можно оценить ваш алгоритм. На входе int N, т.е. чисто формально можно ввести на вход число 2_000_000_000
Далее делается цикл по всем 2 млрд числам (и мы уже привысили 10 сек отведенных)
Но с каждым числом делаются еще следующие операции:

перевод числа в строку (это как минимум около 5 операций [хотя реально больше думаю], так как для числа 1 - длина 1, а для 2 млрд длина 10, то среднее будет 5)
затем заполнение массива nuck циклом по длине числа (еще 5 операций)
далее двойной цикл по длине числа, т.е. длина числа в квадрате (5^2 = 25 операций)
вывод в result учитывать не буду
Т.е. на каждое число получается 5 + 5 + 25 = 35 операций (это минимум, скорее больше, там еще массив создается для каждого числа, объект строки - это все операции). Даже если вводить максимум число 1 млрд, то это 35 млрд операций. (так как есть, например, число 912_985_153, которое удовлетворяет условию)

Вам надо придумать более эффективный алгоритм. Реализация перебором здесь не подойдет

П.С. я бы посоветовал подумать сначала над задачей самостоятельно, но если ничего не будет приходить в голову, то на info.javarush эта задача довольно подробно обсуждалась, а также можете погуглить "числа Армстронга"

// что-то вроде этого. Предполагается, что число имеет не больше 12 цифр int[] digits = new int[12];
int i = digits.length - 1;
while (n > 0) {
  digits[i] = n % 10;
  n /= 10;
  i--;
}
(27 Ноя, 02:45)deshaion
Разбирать просто. Чтобы не переводить в строку, можно получить все числа следующим образом: сначала % 10, потом / 10
т.е., например, число 467
467 % 10 = 7
467 / 10 = 46
46 % 10 = 6
46 / 10 = 4
4 % 10 = 4
4 / 10 = 0
наши числа 7 6 4


Отчего не подсказать. Только мой метод какой то очень простой, не знаю работает правильно или нет.
Вобщем тестирование памяти
long memoryStart = Runtime.getRuntime().freeMemory();
long memoryEnd = Runtime.getRuntime().freeMemory();
long memoTaken = memoryStart — memoryEnd; // итог получаем байты.
На всякий случай памятка сколько времени заняла работа программы
Long t0 = System.currentTimeMillis();
Long t1 = System.currentTimeMillis();
out.println(«Time need to create the arrray = » + (t1 — t0));
Про память тут есть с рисунком в низу.
stackoverflow.com/questions/3571203/what-is-the-exact-meaning-of-runtime-getruntime-totalmemory-and-freememory

Пол-дня просидел из-за одной строчки if (String.valueOf(i).contains(«0»)) break; которая съедала огромную кучу памяти, проходя в цикле.

Кажется мне что для степени ты используешь Math.pow(). Если это так срочно избавляйся от него.

Постарайся использовать в цикле только int,short,byte и возможно List.

После оптимизации и использования где возможно byte вместо int ест памяти ровно столько сколько и при пустом цикле)). Самое ресурсо/время-емкая операция оказалась разбить число на цифры

Пипец, столько убитого времени: перестановки цифр, дополнительные массивы, хэшсеты, сортировки… А решается все простым перебором, но без использования Math.pow.

— не стоит применять Integer, только примитивные int, а лучше byte
— Math.pow стоит заменить на заранее рассчитанный двумерный массив, мы же знаем диапазон с которым работаем. Лично мне это дало ускорение в разы.
— никаких Collections


Решил с первого раза. Логика такая: самое трудоемкое — возведение в степень, следовательно этот процесс надо сделать всего один раз, а потом уже брать готовые результаты. Дальше — простой перебор. Больше ничего не оптимизировал.

Да-да, слушайте больше тех людей, которые говорят что оптимизация ничего не дает… Вот вам 3 результата у меня: сначала перебор в лоб (суть ясна, здесь время в сек., дальше в мс.), потом оптимизация №1 из ссылки выше, затем к ней добавляем оптимизацию с двумерным массивом.
p.s. Сдал кучу вариантов, а оказалось цикл крутить надо с 1, а не с 0 ))))
без оптимизации:
88593477 time: 65sec
146511208 time: 102sec
Оптимизация №1
88593477 time: 12sec
146511208 time: 29sec
Оптимизация №2
88593477 time: 1394 ms
146511208 time: 3504 ms
*/