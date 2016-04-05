package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
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

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name.equals("Ivanov"));
            for (Asset as : somePerson.assets)
            {
                System.out.println(as.getName());
                //pw.println(as.getPrice());
            }

           //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }


      public void save(OutputStream outputStream) throws Exception {
          PrintWriter writer = new PrintWriter(outputStream);
          String isNamePresent = name != null ? "yn" : "no";

          writer.println(isNamePresent);
          if (name != null)
              writer.println(name);

          if (assets.size()>0)
          {
              for (int i = 0; i < assets.size(); i++)
              {
                  String isAssetPresent = assets.get(i) != null ? "yes" : "no";
                  if (isAssetPresent.equals("yes"))
                  {
                      writer.println(isAssetPresent);
                      Asset as = assets.get(i);
                      if (assets.get(i) != null) writer.println(as.getName());
                      if (assets.get(i) != null) writer.println(as.getPrice());
                  }
                  //implement this method - реализуйте этот метод
              }
          }
          writer.flush();
          writer.close();
      }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader  reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready())
            {
                String isNamePresent = reader.readLine();
                if (isNamePresent.equals("yn"))
                {
                    name = reader.readLine();
                }

                else if (name != null)
                {
                    if (isNamePresent.equals("yes"))
                    {


                        Asset as = new Asset(reader.readLine());
                        assets.add(as);

                    }
                    else if (isNamePresent.equals("no")) break;
                }
            }

            //implement this method - реализуйте этот метод
        }
    }
    }

