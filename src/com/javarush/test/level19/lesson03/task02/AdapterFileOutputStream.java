package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
  private FileOutputStream fileOutputStream1;
  AdapterFileOutputStream (FileOutputStream fileOutputStream1){this.fileOutputStream1=fileOutputStream1;}
    public void flush() throws IOException{this.fileOutputStream1.flush();}

    public void writeString(String s) throws IOException{this.fileOutputStream1.write(s.getBytes());}

    public void close() throws IOException{this.fileOutputStream1.close();}


}

