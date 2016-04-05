package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;

/**
 * Created by Vl on 20.04.2015.
 */


class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        int amountToWithdraw = 0; //деньги для снятия

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode); // берем манипулятор
        while (true) //цикл, пока все условия не будут соблюдены
        {
            try
            {
                ConsoleHelper.writeMessage("Введите сумму");
                amountToWithdraw = Integer.parseInt(ConsoleHelper.readString());
                if (amountToWithdraw <= 0)
                {
                    ConsoleHelper.writeMessage("Введены некорректные данные");
                    continue;
                }
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("Введены некорректные данные");
                continue;
            }

            //здесь выполняется пункт 1.3.3
            if (!currencyManipulator.isAmountAvailable(amountToWithdraw))
            {
                ConsoleHelper.writeMessage("недостаточно денег");
                continue;
            }

            //ниже иедет снятие денег, и отоброжение результата снятия в виде: <табуляция>номинал - количество
            try
            {
                Map<Integer, Integer> withdrawMoney = currencyManipulator.withdrawAmount(amountToWithdraw);

                for (Map.Entry<Integer, Integer> x : withdrawMoney.entrySet())
                {
                    ConsoleHelper.writeMessage("\t" + x.getKey() + " - " + x.getValue());
                }
                ConsoleHelper.writeMessage("транзакция проведена успешно");
                break;
            }

            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("нехватает банкнот для проведения транзакции");
            }
        }

    }

}