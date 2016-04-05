package com.javarush.test.level17.lesson04.task04;

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
*/

public class Solution {
    public static class OurPresident {
       static {
           synchronized(OurPresident.class) {}
       }
        private static OurPresident president;

        private OurPresident() {}

        public static OurPresident getOurPresident() {
            return president;
        }
    }
}
/*
=сделал так, и оно прошло, только если честно ничего не понял, поясните плиз.
static {synchronized (OurPresident.class){getOurPresident();}}
=Всё дело в static. Если бы была синхронизация в теле обычного класса, то экземпляр уже был бы создан и можно было бы использовать this ссылаясь на него. При static экземпляра класса ещё нету, а при создании как-то надо выкручиваться и как-то указать на принадлежность конкретному классу, тут и приходит на помощь MyClass.class, что в коде означает применять к экземпляру этого класса (ну и при инициализации класса файл MyClass.class скачивается на твой компьютер и становиться доступным, что позволяет его задействовать для решения данного вопроса). Я так понимаю.

=А у меня вот так сработало
static synchronized void add()  {getOurPresident(); }
* */