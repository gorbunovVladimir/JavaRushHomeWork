package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
public class Solution implements Serializable
{
   /*public static void main(String[] args) throws IOException,ClassNotFoundException {
        System.out.println(new Solution(4));
        {ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("D:\\temp.txt"));
         Solution solution1=new Solution(4);
         outputStream.writeObject(solution1);
         outputStream.close();
         ObjectInputStream objectStream =new ObjectInputStream(new FileInputStream("D:\\temp.txt"));
         Solution solution=(Solution)objectStream.readObject();
         //solution.temperature =objectStream.readInt();
         System.out.println(solution);
         objectStream.close();
        }*/
   public static void main(String[] args) {
       System.out.println(new Solution(4));
   }
    private static final long serialVersionUID = 1L;
    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(){super();}
    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }
    @Override
    public String toString() {
        return this.string;
    }
}
