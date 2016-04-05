package com.javarush.test.level21.lesson02.task02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет,
содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true//1
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false//8

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true//9/8
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        return ((allModifiers)&(specificModifier))==(specificModifier);
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
/*Представь значения модификаторов в двоичном коде:
1 = 0001; 1 = 0001; возвращает true;
1 = 0001; 8 = 1000; возвращает false;
9 = 1001; 8 = 1000; возвращает true;
исходя из этого придумай более лаконичное и грамотное условие с использованием поразрядной конъюнкции (&)

return allModifiers & specificModifier != 0;

зажми контрал и клоцни на Modifier. там увидишь значения каждого модификатора. Мне помогло

Метод getModifiers() возвращает общую сумму значений модификаторов у запрашиваемого класса/метода/поля, в данном случае складываются значение модификаторов метода main, public (1) + static (8) = 9.
Надо узнать, содержится ли модификатор static в методе main, вот и думай, как побитовым сравнением это решить :)

9 берется от сложения кодов модификаторов, которые имеются у метода, а именно PUBLIC = 0x00000001 и STATIC = 0x00000008.

http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.1-200-E.1
http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/lang/reflect/Modifier.java*/