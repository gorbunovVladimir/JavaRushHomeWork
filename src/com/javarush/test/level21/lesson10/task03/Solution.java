package com.javarush.test.level21.lesson10.task03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* Найти и исправить ошибку
Найти и исправить ошибку
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++)
            try {
                new Solution().readFile("ggg");
            } catch (Throwable throwable) {
                System.out.println(i + " " + throwable.getClass().getSimpleName());//4
            }
    }

    public void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {//1
            System.out.println(br.readLine());
            dispose();
        } catch (FileNotFoundException ignored) {
            dispose();//2
        } catch (IOException ignored) {
            dispose();
        } /*finally {
            System.out.println("finally");
        }*/
    }

    public void dispose() {
        //pretend to call some method that throws an exception
        throw new RuntimeException("no matter");//3
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("inside finalize - before throwing");
        dispose();   //исключения игнорируются в finalize
        System.out.println("inside finalize - after throwing");
    }
}

//Попробуйте обернуть в try/catch/finally, в блок finally добавьте еще раз вызов super.finalize();
//FNFE унаследован от IOE