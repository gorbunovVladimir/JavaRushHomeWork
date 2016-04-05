package com.javarush.test.level34.lesson02.task02;

/* Факториал с помощью рекурсии
Почитать про вычисление факториала.
Реализовать логику метода factorial, где n - это число, факториал которого нужно вычислить.
Не создавайте статические переменные и поля класса.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        /*return (n == 0) ? 1 : n * factorial(n - 1);*/
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
//Факториа́л числа n (лат. factorialis — действующий, производящий, умножающий; обозначается n!, произносится эн факториа́л) — произведение всех натуральных чисел от 1 до n включительно: