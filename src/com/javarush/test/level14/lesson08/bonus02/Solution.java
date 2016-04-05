package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    { Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter first digit ");
        int N = scanner.nextInt();
       // System.out.println("Enter second digit ");
        int K = scanner.nextInt();
        int more = max(N, K);
        int less = min(N, K);
        for (int i = less; i >= 1; i--) {
            if (((more % i) == 0) && ((less % i) == 0)) {
                System.out.println(/*"Maximum common divider is " +*/ i);
                break;
            }
        }
    }

    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    }

