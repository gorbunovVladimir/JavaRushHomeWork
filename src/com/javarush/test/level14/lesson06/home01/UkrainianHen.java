package com.javarush.test.level14.lesson06.home01;
//import com.javarush.test.level14.lesson06.home01.*;
public class UkrainianHen extends Hen{int getCountOfEggsPerMonth(){return 33;}
    String getDescription(){
        String s=super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+UkrainianHen.this.getCountOfEggsPerMonth()+" яиц в месяц." ;return s;}}
