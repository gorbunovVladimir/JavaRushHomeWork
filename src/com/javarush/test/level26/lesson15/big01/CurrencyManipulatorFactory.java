package com.javarush.test.level26.lesson15.big01;

import java.util.*;

/**
 * Created by Vl on 19.04.2015.
 */
public class CurrencyManipulatorFactory
{static final private Map<String, CurrencyManipulator> manipulators = new HashMap<>();

    private CurrencyManipulatorFactory(){}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if(!manipulators.containsKey(currencyCode)){
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }
        return manipulators.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }

}
