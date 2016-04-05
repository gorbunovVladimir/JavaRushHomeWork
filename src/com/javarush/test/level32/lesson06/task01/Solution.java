package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Каждый сгенерированный символ пароля пишите сразу в ByteArrayOutputStream.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream pass=new ByteArrayOutputStream();
        String alphabetUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLow=alphabetUp.toLowerCase();
        String digits="0123456789";
        String mixed=digits+alphabetLow+alphabetUp;
        for (int i=0;i<5;i++) pass.write(mixed.charAt(new Random().nextInt(mixed.length())));
        pass.write(alphabetUp.charAt(new Random().nextInt(alphabetUp.length())));
        pass.write(alphabetLow.charAt(new Random().nextInt(alphabetLow.length())));
        pass.write(digits.charAt(new Random().nextInt(digits.length())));
        /*System.out.println(sum);
        Random r = new Random();Random ran = new Random();
        System.out.println(alphabetUp.charAt(ran.nextInt(alphabetUp.length())) + " " + alphabetLow.charAt(r.nextInt(alphabetLow.length())));
        System.out.println((char)65+""+(char)48);*/
        return pass;
    }
}

