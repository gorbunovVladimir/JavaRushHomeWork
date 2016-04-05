package com.javarush.test.level27.lesson04.home01;

/* Модификаторы и дедлоки
Расставьте модификаторы так, чтобы при работе с этим кодом появился дедлок
*/
public class Solution {
    public synchronized Object getData() {
        return new ThreadDeadlock().getData();
    }
}
/*2 класса 2 метода. Один ссылается на другой. Есть вероятность дед лока а не дед лок.
 В данном примере увы не потестить.
 Допустим метод getData() класса ThreadDeadlock делает какую нить операцию очень долгую, качать что
 нить с интернета в потоке и тут этот же метод из другого потока запустился, метод под монитором.
 Другой поток ждет, и если первый поток зависнет или уснет когда под монитором, случится дед лок.
 Но это все теория, вероятность а не 100%. */