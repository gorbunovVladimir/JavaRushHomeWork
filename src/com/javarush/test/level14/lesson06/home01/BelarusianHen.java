package com.javarush.test.level14.lesson06.home01;
//import com.javarush.test.level14.lesson06.home01.*;
//import com.javarush.test.level14.lesson06.home01.Country;

public class BelarusianHen extends Hen{
    int getCountOfEggsPerMonth(){return 30;}
    String getDescription(){
        String s=super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+BelarusianHen.this.getCountOfEggsPerMonth()+" яиц в месяц." ;return s;}}
