package com.javarush.test.level07.lesson06.task02;

/* 5 строчек: «101», «102», «103», «104», «105»
1. Создай список строк.
2. Добавь в него 5 строчек: «101», «102», «103», «104», «105».
3. Удали первую, среднюю и последнюю.
4. Используя цикл выведи на экран его содержимое, каждое значение с новой строки.
5. Выведи его размер. (После удаления одного элемента индексы остальных меняются.
Например, если удалить 0-й элемент, то тот, который был 1-м, станет 0-м. И т.д.)
*/
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        //list.set(0,"a"); list.set(1,"b");list.set(2,"c");list.set(3,"d");list.set(4,"e");
        list.add("101"); list.add("102"); list.add("103"); list.add("104"); list.add("105");
        list.remove(0);list.remove(1);list.remove(2);
        //String s="a";list.set(4,s);
        //System.out.println(list.size());
        //Напишите тут ваш код
        for (int i=0;i<list.size(); i++)
            System.out.println(list.get(i));//Напишите тут ваш код
        System.out.println(list.size());

    }
}
