package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Vl on 31.03.2015.
 */
public class Horse
{   private String name;
    private double speed;
    private double distance;
    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public void move() { distance += speed*Math.random(); }
    public void print(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Math.round(getDistance()); i++)
        {
            sb.append(".");
        }
        System.out.println(sb.toString()+getName());
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getSpeed()
    {
        return speed;
    }
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
    public double getDistance()
    {
        return distance;
    }
    public void setDistance(double distance)
    {
        this.distance = distance;
    }

}
