package com.javarush.test.level29.lesson09.task01;

import java.math.BigDecimal;

/* Этот странный BigDecimal
Исправьте ошибку реализации, приводящую к погрешности вычисления, в методе getValue.
Сигнатуру метода не менять. Округление не использовать.
Читайте доп. статью про особенности автобоксинга.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        return new BigDecimal(v1).add(new BigDecimal(v2));
        //return new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2)));
    }
}
/*Подводные камни BigDecimal

Узнав, что класс BigDecimal позволяет хранить дробные числа произвольной точности, и увидев, что у него есть конструктор от double, некоторые решат, что всё ясно и можно делать так:
System.out.println(new BigDecimal(1.1));

Делать так действительно никто не запрещает, вот только результат может показаться неожиданным: 1.100000000000000088817841970012523233890533447265625. Так происходит, потому что примитивный double хранится в формате IEEE754, в котором невозможно представить 1.1 идеально точно (в двоичной системе счисления получается бесконечная периодическая дробь). Поэтому там хранится максимально близкое значение к 1.1. А конструктор BigDecimal(double) напротив работает точно: он идеально преобразует заданное число в IEEE754 к десятичному виду (конечная двоичная дробь всегда представима в виде конечной десятичной). Если же хочется представить в виде BigDecimal именно 1.1, то можно написать либо new BigDecimal("1.1"), либо BigDecimal.valueOf(1.1). Если число не выводить сразу, а поделать с ним какие-то операции, можно и не понять, откуда берётся ошибка. FindBugs выдаёт предупреждение DMI_BIGDECIMAL_CONSTRUCTED_FROM_DOUBLE, в котором даются те же советы.

А вот ещё одна штука:
BigDecimal d1 = new BigDecimal("1.1");
BigDecimal d2 = new BigDecimal("1.10");
System.out.println(d1.equals(d2));

Фактически d1 и d2 представляют собой одно и то же число, но equals выдаёт false, потому что он сравнивает не только значение чисел, но и текущий порядок (число знаков после запятой). Это написано в документации, но мало кто будет читать документацию к такому знакомому методу как equals. Такая проблема может всплыть далеко не сразу. Сам FindBugs об этом, к сожалению, не предупреждает, но есть популярное расширение к нему — fb-contrib, в котором данный баг учтён:
MDM_BIGDECIMAL_EQUALS

equals() being called to compare two java.math.BigDecimal numbers. This is normally a mistake, as two BigDecimal objects are only equal if they are equal in both value and scale, so that 2.0 is not equal to 2.00. To compare BigDecimal objects for mathematical equality, use compareTo() instead.*/