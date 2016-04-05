package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[4];
        result[0] = (byte) (ip[0]& mask[0]);
        result[1] = (byte) (ip[1]& mask[1]);
        result[2] = (byte) (ip[2]& mask[2]);
        result[3] = (byte) (ip[3]& mask[3]);
        return result;
    }

    public static void print(byte[] bytes) {
        String[] result = new String[4];
        for (int i=0; i<bytes.length;i++)
        {   int valueLong = bytes[i] & 0xFF;
            System.out.println(bytes[i]+"&"+0xFF+"="+valueLong);
            System.out.println(Integer.toBinaryString(bytes[i])+"&"+Integer.toBinaryString(0xFF)+"="+Integer.toBinaryString(valueLong));
            System.out.println(Integer.toBinaryString((int) bytes[i] + 256).substring(1) + "&" + Integer.toBinaryString((int) 0xFF + 256).substring(1) + "=" + Integer.toBinaryString((int) valueLong + 256).substring(1));
            result[i] = String.format("%8s",Integer.toBinaryString(valueLong));
            result[i]=result[i].replaceAll(" ","0");
        }System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]);
    }
    /*public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(Byte.toUnsignedInt(bytes[i]), 2));
            while (sb.length() < 8) {
                sb.insert(0, "0");
            }
            System.out.print(sb);
            if (i < 3) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }*/
}
/*
* 0xFF это число 255 записанное в шестнадцатеричной системе
& 0xFF    = 00000000 00000000 00000000 11111111

Преобразование byte в short (int, long)
Обычный каст (int) myByte выполнит расширение до 32 бит со знаком — это означает, что если старший бит байта был установлен в 1, то результатом будет то же самое отрицательное число, но записанное в 32-битном формате:
0xff -> 0xffffffff (-1)
Часто это не то, чего бы мы хотели. Для того, чтобы выполнить расширение до 32 бит без знака и получить 0x000000ff, в Java можно записать:
int myInt = myByte & 0xff;
short myShort = myByte & 0xff;

Integer.ToBinaryString() - переводит целочисленное число в строку двоичного кода

String a = Integer.toBinaryString(256 + (int) data);
a.substring(a.length() -8);
or
Integer.toBinaryString(256 + (int) data).subString(1);

for(int i=0; i<bytes.length; i++){
            byte b = bytes[i];
            for(int j=7; j>=0; j--){
                System.out.print((b>>j)&1);
            }
            System.out.print(" ");
        }
        System.out.println();

Я поковырял и-нет и пришел к такому выводу, если байт выходит за рамки 127, то остальное уходит в минус и если прибавить исходные 256 то получается начальное значение(интегер), дописал это в код и норма прокатило
        int f = (int) bytes[i]; // получаем значение и приводим его к интегер
        if(f < 0) f += 256;  // если значение меньше 0, то + 256 - тут получается исходник из -64 192
        String str = Integer.toBinaryString(f); // преобразовываем к двоичному коду


http://stackoverflow.com/questions/11380062/what-does-value-0xff-do-in-java/23801667#23801667
http://stackoverflow.com/questions/842817/how-does-java-convert-int-into-byte
http://stackoverflow.com/questions/12310017/how-to-convert-a-byte-to-its-binary-string-representation
http://stackoverflow.com/questions/11528898/convert-byte-to-binary-in-java
http://stackoverflow.com/questions/6393873/how-to-get-the-binary-values-of-the-bytes-stored-in-byte-array
* */