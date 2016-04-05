package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;
        PersonScannerAdapter (Scanner scanner)
        {this.scanner=scanner;}

        @Override
        public Person read() throws IOException
        {   String string = scanner.nextLine();
            String[] line = string.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(line[5]), Integer.parseInt(line[4])-1, Integer.parseInt(line[3]));
            return new Person(line[1], line[2], line[0], calendar.getTime());

            /*Calendar calendar = new Calendar.Builder().build();
            calendar.set(Integer.parseInt(line[5]), Integer.parseInt(line[4])-1, Integer.parseInt(line[4]));
            new GregorianCalendar(year, --month, day);
            return new Person(line[1], line[2], line[0], calendar.getTime());

            Person person=null;
            if(scan.hasNext()){

                String last = scan.next();
                String first = scan.next();
                String middle = scan.next();
                int day = scan.nextInt();
                int month = scan.nextInt()-1;
                int year = scan.nextInt();
                Calendar date = new GregorianCalendar(year, month, day);
                person = new Person(first, middle, last,date.getTime());*/

        }

        @Override
        public void close() throws IOException
        {
            scanner.close();

        }
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PersonScanner adapter = new PersonScannerAdapter(s);
        System.out.println(adapter.read());
        adapter.close();
    }


}
