package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Vl on 13.04.2015.
 */
public class Producer implements Runnable
{ private TransferQueue<ShareItem> queue;
    public Producer(TransferQueue<ShareItem> queue)
    {this.queue=queue;
    }

    @Override
    public void run()
    {try {
      {for (int i=1;i<=9;i++){
        System.out.format("Элемент 'ShareItem-%d' добавлен\n", i);
        queue.offer(new ShareItem(String.format("ShareItem-%d", i), i));
//•	offer(E e) - добавить элемент в очередь. Если места нет, то возвращается значение false
//•	offer(E e, long timeout, TimeUnit unit) - добавить элемент в очередь, если необходимо ждать свободное место указанное время;
       Thread.sleep(100);
       if (queue.hasWaitingConsumer()){System.out.println("Consumer в ожидании!");}
      }}}
    catch (InterruptedException e){return;}
    }

}
/*public boolean hasWaitingConsumer()
Description copied from interface: TransferQueue
Returns true if there is at least one consumer waiting to receive an element via BlockingQueue.take() or timed poll. The return value represents a momentary state of affairs.
Specified by:
hasWaitingConsumer in interface TransferQueue<E>
Returns:
true if there is at least one waiting consumer
*/