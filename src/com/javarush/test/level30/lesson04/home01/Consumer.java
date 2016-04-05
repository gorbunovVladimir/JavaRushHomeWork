package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Vl on 13.04.2015.
 */
public class Consumer implements Runnable
{private TransferQueue<ShareItem> queue;
    public Consumer(TransferQueue<ShareItem> queue)
    {this.queue=queue;
    }

    @Override
    public void run()
    {try
    {Thread.sleep(500);
     while (true){System.out.println("Processing " + queue.take().toString());}
//•	take() - взять элемент из очереди, если необходимо ждать появления элемента в очереди;
    }
    catch (InterruptedException e){return;}
    }

}
