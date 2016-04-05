package com.javarush.test.level17.lesson10.home05;

/* Лишняя синхронизация
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов
*/

public class Solution {
    char[] value;
    int count;

    public Solution append(CharSequence s) {
        //synchronized (Solution.class) {
        if (s == null) {
            // synchronized (this) {
            s = "null";
            // }
        }

        if (s instanceof String) {
            // synchronized (this) {
            return this.append((String) s);
            //}
        }

        if (s instanceof Solution) {
            // synchronized (this) {
            return this.appendThis((Solution) s);
            // }
            // }
        }
        return this.append(s);
    }

    public synchronized Solution appendThis(Solution s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };

    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();
        //synchronized (fields) {
        fields.put("value", value);
        fields.put("count", count);
        fields.put("shared", false);
        //}
        //synchronized (s) {
        s.writeFields();
        // }
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        //synchronized (new java.io.IOException()) {
        java.io.ObjectInputStream.GetField fields = s.readFields();
        value = (char[]) fields.get("value", null);
        count = fields.get("count", 0);
        // }
    }
}
/*synchonized перед сигнатурой метода эквивалентно тому, что все тело метода будет заключено в блок synchronized(this). Так что synchronized(this) из синхронизированных методов убираем сразу.
Синхронизироваться по локальным переменным и параметрам метода тоже не имеет смысла, т.к. они уникальны каждого вызова метода из разных нитей. А синхронизация по классу видимо также является излишней, т.к. метод уже синхронизирован по экземпляру класса.
synchronized (new java.io.IOException())
а это будет всегда синхронизироваться по какому-то новому объекту, к которому невозможно доступиться.
Дам свою версию подсказки: метод append() не нужно никак синхронизировать, потому что результатом его работы (рано или поздно из-за рекурсии внутри него) будет обращение к методу appendThis(), который итак синхронизирован.

синхронизация по Solution.class используется обычно для статических методов, да и какой смысл блокировать весь класс из-за простого метода?
по new java.io.IOException() не имеет смысла синхронизироваться, т.к. ссылок на этот объект мы не сосхраняем, соответственно им не управляем и вообще никак не пользуемся.
*/