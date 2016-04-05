package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Vl on 16.04.2015.
 */
public class CustomInvocationHandler implements InvocationHandler
{private SomeInterfaceWithMethods swih;

    public CustomInvocationHandler(SomeInterfaceWithMethods swih)
    {
        this.swih = swih;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {   //System.out.println(method.getName()+" in");
        //return method.invoke(swih,args);
        //System.out.println(method.getName()+" out");
        System.out.println(method.getName()+" in");
        method.invoke(swih, args);
        System.out.println(method.getName()+" out");
        return null;
    }
}
