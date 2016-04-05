package com.javarush.test.level17.lesson10.bonus01;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException //start here - начни тут
    {  SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
       SimpleDateFormat datFormat = new SimpleDateFormat( "dd-MMM-yyyy",Locale.ENGLISH);
        String name="",sex="";Date bd=new Date(Long.MIN_VALUE);


       if (args.length > 0)
       {
        if ("-c".equals(args[0]) && args.length >= 4)
         {name=args[1];sex=args[2];
          bd = sdf.parse(args[3]);
          if (sex.equals("м"))
            {allPeople.add(Person.createMale(name, bd));}
          else if (sex.equals("ж"))
            {allPeople.add(Person.createFemale(name, bd));}
          else return;
          System.out.println(allPeople.size()-1);
         }

        else if ("-u".equals(args[0]) && args.length >= 5)
         {int id = Integer.parseInt(args[1]);
          name=args[2];
          sex=args[3];
          bd = sdf.parse(args[4]);
          if (id < allPeople.size()){
          if (sex.equals("м"))
            {allPeople.set(id, Person.createMale(name, bd));}
          else if (sex.equals("ж"))
          {allPeople.set(id, Person.createFemale(name, bd));}
          else return;
          }
         }

        else if ("-d".equals(args[0]) && args.length == 2)
          {int id = Integer.parseInt(args[1]);
           //if (id < allPeople.size())   allPeople.remove(id);
           if (id < allPeople.size())
              {
                  allPeople.get(id).setName(null);
                  allPeople.get(id).setSex(null);
                  allPeople.get(id).setBirthDay(new Date(Long.MIN_VALUE));
              }}

        else if ("-i".equals(args[0]) && args.length == 2)
          {int id = Integer.parseInt(args[1]);
          if (id < allPeople.size()){
          Person person3 = allPeople.get(id);
          bd=person3.getBirthDay();
          name=person3.getName();
              if (allPeople.get(id).getSex() == Sex.MALE) sex = "м";
              else if (allPeople.get(id).getSex() == Sex.FEMALE) sex = "ж";

          System.out.println(name+" "+sex+" " +datFormat.format(bd));
          }}
       }
    }
}
