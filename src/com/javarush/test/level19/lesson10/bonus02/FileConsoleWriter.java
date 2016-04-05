package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{

    public FileConsoleWriter(String fileName) throws IOException
    {super(fileName);}
    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {super(fileName, append);}
    public FileConsoleWriter(File file) throws IOException
    {super(file);}
    public FileConsoleWriter(File file, boolean append) throws IOException
    {super(file, append);}
    public FileConsoleWriter(FileDescriptor fd)
    {super(fd);}
    public void write(int c) throws IOException {
        System.out.println((char) c);
        //System.out.println(new char[]{(char) c});
        super.write(c);
    }
    public void write(char cbuf[], int off, int len) throws IOException {
        /*for (int i = off; i < len; i++)
        {
            System.out.print(cbuf[i]);
        }*/
        System.out.println(String.valueOf(cbuf).substring(off, off + len));
        super.write(cbuf, off, len);
    }
    public void write(String str, int off, int len) throws IOException {
        /*char [] chars = str.toCharArray();
        for (int i = off; i < len; i++)
        {
            System.out.print(chars[i]);
        }*/
        System.out.println(str.substring(off, off + len));
        super.write(str, off, len);
    }
   /* write(String str) и write(char[] cbuf) не надо, т.к. они просто вызывают соответствующие методы с дополнительными параметрами int off и int len. Т.е., если переписать их, то это, возможно, не повлияет на тест, но все переписывание сведется к простому вызову super.write(str/cbuf) - смысла в этом нет.

   public void write(char cbuf[]) throws IOException {
        System.out.print(cbuf);
        super.write(cbuf, 0, cbuf.length);
    }
    public void write(String str) throws IOException {
        System.out.print(str);
        super.write(str, 0, str.length());
    }*/
   /*public static void main(String[] args) throws IOException
   {
       FileConsoleWriter f = new FileConsoleWriter("D:\\temp.txt");
       f.write("test");
       f.write("t");
       f.write("twewjhjhhj",1,3);
       char tmp[] = {'a','b','c'};
       f.write(tmp,1,2);
       f.close();
   }*/

}
