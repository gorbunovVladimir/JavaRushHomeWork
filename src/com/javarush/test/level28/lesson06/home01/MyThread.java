package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Vl on 09.04.2015.
 */
public class MyThread extends Thread
{   private static AtomicInteger threadNumber = new AtomicInteger(0);
    public MyThread()
    {   super();
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        this.setPriority(threadNumber.get());}

    public MyThread(Runnable target)
    {   super(target);
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        this.setPriority(threadNumber.get());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {   super(group, target);
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        this.setPriority(threadNumber.get());
    }

    public MyThread(String name)
    {   super(name);
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        this.setPriority(threadNumber.get());
    }

    public MyThread(ThreadGroup group, String name)
    {   super(group, name);
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        if (threadNumber.get()>group.getMaxPriority())this.setPriority(group.getMaxPriority());
        else this.setPriority(threadNumber.get());
    }

    public MyThread(Runnable target, String name)
    {   super(target, name);
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        this.setPriority(threadNumber.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {   super(group,target, name);
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        if (threadNumber.get()>group.getMaxPriority())this.setPriority(group.getMaxPriority());
        else this.setPriority(threadNumber.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {   super(group, target, name, stackSize);
        threadNumber.incrementAndGet();threadNumber.compareAndSet(11,1);
        if (threadNumber.get()>group.getMaxPriority())this.setPriority(group.getMaxPriority());
        else this.setPriority(threadNumber.get());
    }
}
