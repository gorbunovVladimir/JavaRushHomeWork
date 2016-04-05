package com.javarush.test.level20.lesson04.task03;

/**
 * Created by Vl on 01.12.2015.
 */
import java.io.*;

public class SNB implements Serializable
{
    private String str = "aaa";

    public String toString() { return str; }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        ObjectOutputStream out = new ObjectOutputStream(pos);
        ObjectInputStream in = new ObjectInputStream(pis);

        SNB s = new SNB();

        out.writeObject(s);
        out.flush();

        Object o = in.readObject(); // <- Тут получается объект, возвращённый readResolve

        if(o instanceof SNB)
        {
            System.out.println("Solution:" + o);
        }
        else if(o instanceof Integer)
        {
            System.out.println("Integer:" + o);
        }
        else
        {
            System.out.println("?????");
        }

        in.close();
        out.close();
    }

    /*private Object readResolve() throws ObjectStreamException
    {
        return Integer.valueOf(1293);  // <- Подменяем объект на Integer вместо Solution
    }*/
}