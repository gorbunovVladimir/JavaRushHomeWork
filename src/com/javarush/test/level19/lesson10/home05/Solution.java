package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        List<String> wordlist = new ArrayList<String>();
        while (reader1.ready())
        {
            String[] words = reader1.readLine().split(" ");
            for (String word: words)
            {
                if(word.matches(".*\\d.*"))
                {
                    wordlist.add(word);
                }
            }
        }
        for (String s : wordlist)
        {
            writer.write(s + " ");
        }
        writer.close();
        reader1.close();
    }
}
