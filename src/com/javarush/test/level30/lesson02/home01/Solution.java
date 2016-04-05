package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        /*try
        {
            int c = Integer.parseInt(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
            if (c < 0)
            {
                throw new IllegalArgumentException();
            }
            return new Number(expectedNumerationSystem, new BigInteger(String.valueOf(c)).toString(expectedNumerationSystem.getNumerationSystemIntValue()));
        }
        catch (Exception e) {
            throw new NumberFormatException();
        }*/
        try {

            BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());

            if (bigInteger.compareTo(BigInteger.ZERO) < 0)
                throw new Exception();

            String result = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());

            return new Number(expectedNumerationSystem, result.toUpperCase());
        }
        catch (Exception e) {
            throw new NumberFormatException();
        }

    }
}
/*Господа, тестите на нестандартных данных. Вот, например. Число в двоичной системе
1101001000000001100001001110110111111100110010101000100111011011011001001011001100011001100000111101111

public BigInteger(String val,int radix)
Translates the String representation of a BigInteger in the specified radix into a BigInteger. The String representation consists of an optional minus or plus sign followed by a sequence of one or more digits in the specified radix. The character-to-digit mapping is provided by Character.digit. The String may not contain any extraneous characters (whitespace, for example).
Parameters:
val - String representation of BigInteger.
radix - radix to be used in interpreting val.
Преобразовывает Строковое представление biginteger в указанном основании в biginteger. Строковое представление состоит из необязательного знака плюс или минус и следующей за ним последовательности из одной или более цифр в указанном основании. Персонаж-к-разрядному обеспеченный Character.цифр. Строка может не содержать посторонних символов (пробел, например).
Параметры:
Валь - Строковое представление как biginteger.
основание системы счисления - системы счисления будет использоваться в интерпретации знач.

Throws:
NumberFormatException - val is not a valid representation of a BigInteger in the specified radix, or radix is outside the range from Character.MIN_RADIX to Character.MAX_RADIX, inclusive.


Перевод систем счисления с помощью класса BigInteger. Или как перевести число в другую систему счисления с помощью одной сроки кода
Перевод систем счисления – одна из наиболее распространённых задач в программировании.
Среди многочисленных возможностей, которые предоставляет разработчикам класс BigInteger, это достаточно простой перевод целых чисел из одной системы счисления в другую.
Для этого необходимо особым образом воспользоваться конструктором этого класса в сочетании с перегрузкой его метода toString, которая возвращает строковое представление числа в соответствующей системе счисления.
Допустим, имеется объект BigInteger, в котором хранится число 8. После вызова метода toString с параметром 2 будет возвращено строковое представление этого числа в двоичной системе счисления.
BigInteger a= new BigInteger("8");
String s=a.toString(2);
В переменной s будет строка “1000”, что соответствует 8 в двоичной системе. Таким образом, было получено число в виде строки, но для работы с числом необходимо, чтобы оно было в виде числа.
Поэтому создадим второй объект BigInteger, который будет хранить число уже в двоичной системе.
BigInteger b= new BigInteger(s);
В итоге получается фрагмент из 3х строк кода:
BigInteger a= new BigInteger("8");
String s=a.toString(2);
BigInteger b= new BigInteger(s);
Он весьма наглядно иллюстрирует суть алгоритма, но, в тоже время является довольно громоздким. Попробуем его упростить.

Первое, от чего можно в нём отказаться, это промежуточная строковая переменная s. После отказа от неё алгоритм сводится уже к двум строкам:
BigInteger a= new BigInteger("8");
BigInteger b= new BigInteger(a.toString(2));
Java также позволяет создать объект с исходными данными непосредственно в параметре конструктора объекта для хранения результата. Поэтому, в конечном итоге, весь алгоритм перевода систем счисления может быть представлен всего на всего одной единственной строкой кода.
BigInteger b =new BigInteger(new BigInteger("8").toString(2));
Таким образом, с помощью класса BigInteger можно просто и удобно переводить числа из одной системы счисления в другую.

*/