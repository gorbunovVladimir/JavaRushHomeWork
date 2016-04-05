package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Vl on 23.02.2015.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName(){return "USD";}
}