package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int base=10;
        if (s.substring(0,2).equals("0x")) {base=16;s=s.substring(2);}
        else if (s.substring(0,2).equals("0b")) {base=2;s=s.substring(2);}
        else if (s.substring(0,1).equals("0")) {base=8;s=s.substring(1);}
        return String.valueOf(Integer.parseInt(s, base));
    }
}
/*public static int parseInt(String s,int radix) throws NumberFormatException
Parses the string argument as a signed integer in the radix specified by the second argument. The characters in the string must all be digits of the specified radix (as determined by whether Character.digit(char, int) returns a nonnegative value), except that the first character may be an ASCII minus sign '-' ('\u002D') to indicate a negative value or an ASCII plus sign '+' ('\u002B') to indicate a positive value. The resulting integer value is returned.
An exception of type NumberFormatException is thrown if any of the following situations occurs:

The first argument is null or is a string of length zero.
The radix is either smaller than Character.MIN_RADIX or larger than Character.MAX_RADIX.
Any character of the string is not a digit of the specified radix, except that the first character may be a minus sign '-' ('\u002D') or plus sign '+' ('\u002B') provided that the string is longer than length 1.
The value represented by the string is not a value of type int.

Анализирует строковый параметр как целое число со знаком в основании, определенном вторым параметром. Символы в строке должны все быть цифры указанном основании (определяется ли характером.цифр(типа char, int) возвращает неотрицательное значение), за исключением того, что первый символ может представлять собой ASCII-знак минус '-' ('\u002D') указать на отрицательную величину или текстовый знак плюс '+' ('\u002B'), чтобы указать положительное значение. Результирующее целочисленное значение возвращается.
Исключение типа NumberFormatException бросается, если какой-либо из следующих ситуаций происходит:

Первый аргумент имеет значение NULL или является строкой нулевой длины.
Радикс либо меньше, чем персонаж.MIN_RADIX или больше, чем персонаж.MAX_RADIX.
Любой символ строки не цифра в указанном основании, за исключением того, что первым символом может быть знак минус '-' ('\u002D') или знак плюс '+' ('\u002B') при условии, что строка длиннее длины 1.
Значение, представленное строкой, не является значением типа int.
Examples:

 parseInt("0", 10) returns 0
 parseInt("473", 10) returns 473
 parseInt("+42", 10) returns 42
 parseInt("-0", 10) returns 0
 parseInt("-FF", 16) returns -255
 parseInt("1100110", 2) returns 102
 parseInt("2147483647", 10) returns 2147483647
 parseInt("-2147483648", 10) returns -2147483648
 parseInt("2147483648", 10) throws a NumberFormatException
 parseInt("99", 8) throws a NumberFormatException
 parseInt("Kona", 10) throws a NumberFormatException
 parseInt("Kona", 27) returns 411787

Parameters:
s - the String containing the integer representation to be parsed
radix - the radix to be used while parsing s.
Returns:
the integer represented by the string argument in the specified radix.
Throws:
NumberFormatException - if the String does not contain a parsable int.*/