package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Vl on 23.04.2015.
 */
public enum Dish
{Fish, Steak, Soup, Juice, Water;
    public static String allDishesToString(){
        Dish[] arrayDish = Dish.values();
        StringBuilder s = new StringBuilder();
        s.append(arrayDish[0]);
        for (int i = 1; i < arrayDish.length; i++) {
            s.append(", ").append(arrayDish[i]);
        }
        return s.toString();}
}
