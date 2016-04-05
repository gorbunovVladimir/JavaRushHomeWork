package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        //FileInputStream inputStream = new FileInputStream("D:\\temp.txt");
        List<Character> list = new ArrayList<Character>();
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        while (inputStream.available() > 0) {
            int c=inputStream.read();//if (c>10&&c<32) {System.out.println(c);}
            list.add((char) c);
        }

       /* for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    char temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }*/
        Collections.sort(list);


        int frequency = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))) {
                    frequency++;map.put(list.get(j), frequency);

                }
            }
            frequency = 0;
        }

        Set<Map.Entry<Character, Integer>> pair = map.entrySet();

        for (Map.Entry<Character, Integer> set : pair)
        {
            /*if ((((byte) set.getKey().charValue()) != 10) && (((byte) set.getKey().charValue()) != 13))
            {
                System.out.println(set.getKey() + " " + set.getValue());
            }
            else if (((byte) set.getKey().charValue()) == 10) System.out.println("\\n" + " " + set.getValue());
            else if (((byte) set.getKey().charValue()) == 13) System.out.println("\\r" + " " + set.getValue());*/
            //if (((byte) set.getKey().charValue()) != 10)//(set.getKey().equals((char)10))
            {System.out.println(set.getKey() + " " + set.getValue());}

        }
        inputStream.close();
    }
}