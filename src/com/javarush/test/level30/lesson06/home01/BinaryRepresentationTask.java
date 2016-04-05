package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Vl on 13.04.2015.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{   private int i;
    public BinaryRepresentationTask(int i)
    {this.i=i;
    }

    @Override
    protected String compute()
    {   int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);
        if (b > 0)
        {   BinaryRepresentationTask task = new BinaryRepresentationTask(a);
            task.fork();
            return new BinaryRepresentationTask(b).compute() + task.join();
        }
        return result;
    }
}
/*
* habrahabr.ru/post/128985/
docs.oracle.com/javase/7/docs/api/java/util/concurrent/RecursiveTask.html
stackoverflow.com/questions/27650451/stackoverflowerror-when-scaling-with-fork-join-architecture — наиболее близкое к нашей StackOverflowError из найденого

* */