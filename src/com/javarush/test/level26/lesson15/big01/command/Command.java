package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Vl on 20.04.2015.
 */
interface Command
{public void execute() throws InterruptOperationException;
}
