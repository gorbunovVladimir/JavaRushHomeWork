package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User Vl=new User();
            Vl.setFirstName ("Vladimir");
            Vl.setFirstName ("sdf");
            final Calendar instance = Calendar.getInstance();
            instance.set( 2012, 01, 26 );
            Date date = instance.getTime();
            Vl.setBirthDate(date);
            Vl.setMale(true);
            Vl.setCountry(User.Country.OTHER);

            User Br=new User();
            Vl.setFirstName ("Bronislav");
            Vl.setFirstName ("fds");
            //SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            instance.set( 2012, 01, 01 );
            Date dat = instance.getTime();
            Vl.setBirthDate(dat);
            Vl.setMale(true);
            Vl.setCountry(User.Country.RUSSIA);

            javaRush.users.add(Vl);javaRush.users.add(Br);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
            e.printStackTrace();
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<User>();
        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            for(User x: users)
            {
                if(x.getFirstName()!=null){
                    writer.print("yes,");
                    writer.print(x.getFirstName() + ",");}
                else
                    writer.print("no,empty,");
                if(x.getLastName()!=null){
                    writer.print("yes,");
                    writer.print(x.getLastName() + ",");}
                else
                    writer.print("no,empty,");
                if(x.getBirthDate()!=null){
                    writer.print("yes,");
                    /*SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    instance1.set( 2012, 01, 01 );
                    Date dat = instance1.getTime();
                    Vl.setBirthDate(dat);*/
                    //SimpleDateFormat datFormat = new SimpleDateFormat( "MMM dd, yyyy",Locale.ENGLISH);
                    SimpleDateFormat datFormat = new SimpleDateFormat("dd.MM.yyyy");
                    //System.out.println(datFormat.format(x.getBirthDate());
                    //writer.print(x.getBirthDate() + ",");}
                    writer.print(datFormat.format(x.getBirthDate()) + ",");}
                else
                    writer.print("no,empty,");
                writer.print(x.isMale()+",");
                if(x.getCountry()!=null){
                    writer.print("yes,");
                    writer.print(x.getCountry());}
                else
                    writer.print("no,empty");
                writer.println("");
            }
            writer.flush();
            writer.close();
        }
        public void load(InputStream inputStream) throws Exception {
            DataInputStream reader = new DataInputStream(inputStream);

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String is;
            while ((is=reader.readLine())!=null)
            {
                User user = new User();
                String[] arr = is.split(",");
                if (arr[0].equals("yes"))
                    user.setFirstName(arr[1]);
                if (arr[2].equals("yes"))
                    user.setLastName(arr[3]);
                if (arr[4].equals("yes"))
                    user.setBirthDate(format.parse(arr[5]));
                if (arr[6].equals("true"))
                    user.setMale(true);
                if (arr[6].equals("false"))
                    user.setMale(false);
                if (arr[7].equals("yes"))
                    user.setCountry(User.Country.valueOf(arr[8]));
                users.add(user);
            }
            reader.close();
        }
    }
}
