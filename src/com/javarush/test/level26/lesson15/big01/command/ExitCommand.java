package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Vl on 20.04.2015.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Are you sure to want EXIT? (press y / n)");
        String answer = ConsoleHelper.readString();
        if ("y".equalsIgnoreCase(answer.trim()))
            ConsoleHelper.writeMessage("Bye");
    }
}