package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Vl on 19.04.2015.
 */
public enum Operation
{
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {   if (i < 1 || i > 4) throw new IllegalArgumentException();
        return Operation.values()[i - 1];
    }
}
