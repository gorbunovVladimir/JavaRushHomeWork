package com.javarush.test.level30.lesson08.home01;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        y= y ^ x;
        x=y ^ x;
        y=y ^ x;
    }
}

/*- А что это за XOR еще такой – «исключающее или»?
- Тут тоже все просто: когда значение разные – истина (true, 1), когда одинаковые – (false, 0)
1 ^ 1 ==0
0 ^ 0 ==0
1 ^ 0 ==1
0 ^ 1 ==1

4=Number{numerationSystem=_2, digit='100'}
5=Number{numerationSystem=_2, digit='101'}

y=y ^ x;//1
x=y ^ x;//2
y=y ^ x;//3

100 y
101 x
===
001//1 y=y ^ x

001 y
101 x
===
100//2 x=y ^ x

001 y
100 x
===
101//3 y=y ^ x*/