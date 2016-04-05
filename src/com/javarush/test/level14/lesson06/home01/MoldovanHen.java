package com.javarush.test.level14.lesson06.home01;
//import com.javarush.test.level14.lesson06.home01.*;
public class MoldovanHen extends Hen{int getCountOfEggsPerMonth(){return 36;}
    String getDescription(){
        String s=super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+MoldovanHen.this.getCountOfEggsPerMonth()+" яиц в месяц." ;return s;}}

