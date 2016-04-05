package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        protected A clone() throws CloneNotSupportedException { return (A)super.clone();}
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        protected B clone() throws CloneNotSupportedException { throw new CloneNotSupportedException();}
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        protected C clone() throws CloneNotSupportedException { return new C(getI(), getJ(), getName());}
    }
}
/*=Если предок запрещает клонирование, нужно обходится контсрукторами для клонирования и не использовать interface Cloneable?
=нужно использовать interface Cloneable
нужно обходится контсрукторами для клонирования реализуя логику метода clone

=return new C(getI(), getJ(), getName());
Данный метод просто отличный
читая интернет появляется ощущение что данным методом народ ваще не пользуется
=Пользуется.создание клона конструктором — это широко распространенный метод клонирования. Его используют, когда есть доступ ко всем полям класса, например, есть геттеры.

=Честно говоря так и не понял зачем в классе А необходим метод
protected A clone() throws CloneNotSupportedException
если мы всё равно в классе B переопределяем метод clone и запрещаем клонирование
=Можно не переопределять. В главном родителе А проверить, если this — класс B, то выбросить исклюение. В остальных случаях клонировать
 */