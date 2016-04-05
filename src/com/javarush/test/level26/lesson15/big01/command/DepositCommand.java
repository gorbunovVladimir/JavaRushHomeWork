package com.javarush.test.level26.lesson15.big01.command;

/**
 * Created by Vl on 20.04.2015.
 */
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException //throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] denominationAmount = ConsoleHelper.getValidTwoDigits(currencyCode);
        manipulator.addAmount(Integer.parseInt(denominationAmount[0]), Integer.parseInt(denominationAmount[1]));
    }
}
