package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vl on 19.04.2015.
 */
public class ConsoleHelper
{ private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

  public static void writeMessage(String message) {
    System.out.println(message);
}


    public static String readString() throws InterruptOperationException{
        String result= null;

        try{
            result= reader.readLine();
            if (result.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
        }
        catch (IOException ignored){ }

        return result;}

    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage("Input currency code, please...");
        String currencyCode = readString();
        if(currencyCode.length() != 3){
            writeMessage("You put wrong currency code. Please try again.");
            currencyCode = askCurrencyCode();
        }
        return currencyCode.toUpperCase();}

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage("Input denomination and amount, please...");
        String[] result;
        try
        {
            result = readString().trim().split(" ");
            if(result.length != 2 ||Integer.parseInt(result[0]) <= 0 || Integer.parseInt(result[1]) < 0){
                writeMessage("You put wrong denomination and amount. Try Again...");
                result = getValidTwoDigits(currencyCode);
            }
        }
        catch (NumberFormatException e){
            writeMessage("You put wrong denomination and amount. Try Again...");
            result = getValidTwoDigits(currencyCode);
        }

        return  result;
    }
    public static Operation askOperation() throws InterruptOperationException{
        writeMessage("Input code of Operation (1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT)...");
        Operation result = null;
        try
        {
            result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        }
        catch (Exception e)
        {
            writeMessage("You put wrong code of Operation. Please try again.");
            result = askOperation();
        }
        return result;
    }

}
