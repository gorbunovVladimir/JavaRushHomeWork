package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static{

    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }}

   /*public static void main(String[] args) throws ParseException,  NumberFormatException //start here - начни тут
    {
        if (args.length > 0)
        { if ("-c".equals(args[0]) && args.length>=4)
            create(args);
        else if ("-u".equals(args[0]) && args.length>=5)
            update(args);
        else if ("-d".equals(args[0]) && args.length >= 2)
            delete(args);
        else if ("-i".equals(args[0]) && args.length >= 2)
             info(args);
        }
    }

    static void create(String... args) throws ParseException
    {   String name="",sex="";Date bd=new Date(Long.MIN_VALUE);
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i=0;i<(args.length-1)/3;i++){ //4 7
            name=args[1+i*3];sex=args[2+i*3];//1 2 3 4 5 6
        bd = sdf.parse(args[3+i*3]);
        synchronized (allPeople){
        if (sex.equals("м"))
        {allPeople.add(Person.createMale(name, bd));}
        else if (sex.equals("ж"))
        {{allPeople.add(Person.createFemale(name, bd));}}
        else return;
        System.out.println(allPeople.size()-1);}
    }}

    static void update(String... args) throws ParseException, NumberFormatException {
        String name="",sex="";Date bd=new Date(Long.MIN_VALUE);
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i=0;i<(args.length-1)/3;i++){
            int id = Integer.parseInt(args[1+i*3]);
            name=args[2+i*3];
            sex=args[3+i*3];
            bd = sdf.parse(args[4+i*3]);
            synchronized (allPeople){
            if (id < allPeople.size()){
                if (sex.equals("м"))
                {allPeople.set(id, Person.createMale(name, bd));}
                else if (sex.equals("ж"))
                {allPeople.set(id, Person.createFemale(name, bd));}
                else return;
            }}}
    }

    static void delete(String... args) {
        for (int i=1;i<args.length-1;i++){
            int id = Integer.parseInt(args[i]);
            synchronized (allPeople){
            if (id < allPeople.size())
            {
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(new Date(Long.MIN_VALUE));
            }}}
    }

    static void info(String... args) throws NumberFormatException {
        String name="",sex="";Date bd=new Date(Long.MIN_VALUE);
        SimpleDateFormat datFormat = new SimpleDateFormat( "dd-MMM-yyyy",Locale.ENGLISH);
        for (int i=1;i<args.length-1;i++){
            int id = Integer.parseInt(args[i]);
            synchronized (allPeople){
            if (id < allPeople.size()){
                Person person3 = allPeople.get(id);
                bd=person3.getBirthDay();
                name=person3.getName();
                if (allPeople.get(id).getSex() == Sex.MALE) sex = "м";
                else if (allPeople.get(id).getSex() == Sex.FEMALE) sex = "ж";
                else return;
                System.out.println(name+" "+sex+" " +datFormat.format(bd));
            }}}
    }*/
   public static void main(String[] args) throws ParseException{
       //start here - начни тут
       SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
       SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
       if(args[0].equals("-c"))
       {
           synchronized (Solution.class) {
               for(int i = 1; i<args.length; i = i+3)
               {
                   if(args[i+1].equals("м"))
                   {
                       Person m = Person.createMale(args[i], sdf1.parse(args[i+2]));
                       allPeople.add(m);
                       System.out.println(allPeople.indexOf(m));
                   }
                   else if(args[i+1].equals("ж"))
                   {
                       Person w = Person.createFemale(args[i], sdf1.parse(args[i+2]));
                       allPeople.add(w);
                       System.out.println(allPeople.indexOf(w));
                   }
               }  }
       }
       else if(args[0].equals("-u"))
       {
           synchronized (Solution.class) {
               for(int i = 1; i<args.length; i = i+4)
               {
                   int id = Integer.parseInt(args[i]);
                   allPeople.get(id).setName(args[i+1]);
                   allPeople.get(id).setBirthDay(sdf1.parse(args[i+3]));
                   if(args[i+2].equals("м"))
                       allPeople.get(id).setSex(Sex.MALE);
                   else if(args[i+2].equals("ж"))
                       allPeople.get(id).setSex(Sex.FEMALE);
               } }
       }
       else if(args[0].equals("-d"))
       {
           synchronized (Solution.class) {
               for(int i = 1; i<args.length; i++)
               {
                   int id = Integer.parseInt(args[i]);
                   allPeople.get(id).setName(null);
                   allPeople.get(id).setBirthDay(null);
                   allPeople.get(id).setSex(null);
               }   }
       }
       else if(args[0].equals("-i"))
       {
           synchronized (Solution.class) {
               for(int i = 1; i<args.length; i++)
               {
                   int id = Integer.parseInt(args[i]);
                   System.out.print(allPeople.get(id).getName() + " ");
                   if(allPeople.get(id).getSex().equals(Sex.MALE))
                       System.out.print("м ");
                   else if(allPeople.get(id).getSex().equals(Sex.FEMALE))
                       System.out.print("ж ");
                   System.out.print(sdf2.format(allPeople.get(id).getBirthDay()) + " ");
               }
           }   }
   }

}