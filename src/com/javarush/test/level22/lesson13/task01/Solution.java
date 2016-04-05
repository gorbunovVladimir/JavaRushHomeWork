package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        if(query != null && delimiter !=null && query.length()!=0){
        StringTokenizer tokenizer=new StringTokenizer(query,delimiter);
        /*String[] tok=new String[tokenizer.countTokens()];int i=0;
        while (tokenizer.hasMoreTokens())
        {   str[i] = tokenizer.nextToken();i++;
        }
        return str;
        */
        ArrayList<String> list=new ArrayList<String>();
        while (tokenizer.hasMoreTokens())
        {list.add(tokenizer.nextToken());}
        String[] tok=list.toArray(new String[list.size()]);
        return tok;}
        else return null;
    }
}
