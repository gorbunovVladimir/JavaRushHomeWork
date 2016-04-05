package com.javarush.test.level14.lesson06.home01;
//import com.javarush.test.level14.lesson06.home01.*;
public class RussianHen extends Hen
{int getCountOfEggsPerMonth(){return 35;}
    String getDescription(){
        String s=super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+RussianHen.this.getCountOfEggsPerMonth()+" яиц в месяц." ;return s;}
}