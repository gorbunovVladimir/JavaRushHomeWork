package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {

        while (!isValuePresent)
            try{this.wait();}
            catch (InterruptedException e){e.printStackTrace();}
        System.out.println("Got: " + value);
        isValuePresent=false;
        this.notify();
        return value;
    }

    public synchronized void put(int value) {

        while (isValuePresent)
            try{this.wait();}
            catch (InterruptedException e){e.printStackTrace();}
        this.value = value;
        this.isValuePresent=true;
        System.out.println("Put: " + value);
        this.notify();
    }
}
