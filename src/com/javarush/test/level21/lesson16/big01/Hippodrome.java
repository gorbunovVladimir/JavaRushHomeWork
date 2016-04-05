package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Vl on 31.03.2015.
 */

public class Hippodrome
{   static ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        game.horses.add(new Horse("Бам",3,0));
        game.horses.add(new Horse("Дан",3,0));
        game.horses.add(new Horse("иаа",3,0));
        game.run();
        game.printWinner();


}
    public Horse getWinner(){
        Horse winner = null;
        double d = 0;
        for(Horse a : horses){
            if (a.getDistance() > d){
                d = a.getDistance();
                winner = a;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(500);
        }
    }
    public void print() {
        for (Horse h: horses) {
            h.print();
        }
        System.out.println();
        System.out.println();
    }
    public void move() {
        for (Horse h: horses) {
            h.move();
        }
    }
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
}
