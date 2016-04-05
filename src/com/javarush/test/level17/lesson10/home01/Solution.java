package com.javarush.test.level17.lesson10.home01;

import java.util.*;

/* Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution implements List<Long>{
    private ArrayList<Long> original = new ArrayList<Long>();
    @Override
    public synchronized int size(){return original.size();}

    @Override
    public synchronized boolean isEmpty(){return original.isEmpty();}

    @Override
    public synchronized boolean contains(Object o){return original.contains(o);}

    @Override//<Long>
    public synchronized Iterator<Long> iterator(){return original.iterator();}

    @Override
    public synchronized Object[] toArray(){return original.toArray();}

    @Override //<Long>
    public synchronized boolean add(Long aLong){return original.add(aLong);}

    @Override
    public synchronized boolean remove(Object o){return original.remove(o);}

    @Override//<? extends Long>
    public synchronized boolean addAll(Collection<? extends Long> c){return original.addAll(c);}

    @Override//<? extends Long>
    public synchronized boolean addAll(int index, Collection<? extends Long> c){return original.addAll(index, c);}

    @Override
    public synchronized void clear(){original.clear();}

    @Override//Long
    public synchronized Long get(int index){return original.get(index);}

    @Override//Long
    public synchronized Long set(int index, Long element){return original.set(index, element);}

    @Override//Long
    public synchronized void add(int index, Long element){original.add(index, element);}

    @Override//Long
    public synchronized Long remove(int index){return original.remove(index);}

    @Override
    public synchronized int indexOf(Object o){return original.indexOf(o);}

    @Override
    public synchronized int lastIndexOf(Object o){return original.lastIndexOf(o);}

    @Override//ListIterator<Long>
    public synchronized ListIterator<Long>  listIterator(){return original.listIterator();}

    @Override//ListIterator<Long>
    public synchronized ListIterator<Long>  listIterator(int index){return original.listIterator(index);}

    @Override//List<Long>
    public synchronized List<Long> subList(int fromIndex, int toIndex){return original.subList(fromIndex, toIndex);}

    @Override//Collection<?> c
    public synchronized boolean retainAll(Collection<?> c){return original.retainAll(c);}

    @Override//Collection<?> c
    public synchronized boolean removeAll(Collection<?> c){return original.removeAll(c);}

    @Override//Collection<?> c
    public synchronized boolean containsAll(Collection<?> c){return original.containsAll(c);}

    @Override
    public synchronized <T> T[] toArray(T[] a){return original.toArray(a);}
    /*не нужно 3 метода переопределять spliterator, replaceAll, sort;
     потому что эти методы помечены как default и их переопределение не нужно(реализованы прямо в интерфейсе).

     p.s. для тех, кто не знает откуда этот список берется — зажимаете ctrl и щелкаете на List, в сорцах берете методы и уже у них проставляете нужный тип и дописываете тела.
     ?;
     Отличная задача, чтобы поучится заставлять IDEA работать за вас, а именно попробуйте изменить файл темплейт «Implementation method body», чтобы он сам за вас прописал все что нужно (ну почти все :) )
     Спасибо за подсказку. В IntelliJ IDEA 14 есть возможность генерировать делегирующие методы см. Generating Delegation Methods (https://www.jetbrains.com/idea/help/generating-delegation-methods.html). Вызывается командой Alt + Insert, далее «Delegate Methods».
     У ArrayList методов больше, чем в интерфейсе List, поэтому при генерировании кода с использованием original нужно быть внимательным.

      еще одна подсказка, решение кроется в «Delegate Methods»
      просто загрузите заново исходный код и делегируйте методы инструментами ИДЕИ.
      Класс не должен быть абстрактным, все методы имплементятся и делегируются

      Задача до одурения простая. Наследуем от List, оверрайтим методы и в каждом методе вызываем такой же метод для orogin. Никакое приведение типов или изменение сигнатур методов тут не требуется. Разве что добавить synchronized в каждый
      Задача простая, если изначально наследоваться правильно, т.е. от List<Long>. Если наследоваться просто от List, её можно решать очень долго.

      кто столкнется с такой же ошибкой, избавьтесь от @NotNull и не имплементите его.

      не знаю актуально ли еще, но ensureCapacity() и trimToSize() появляються если Delegate Methods (menu--> code --> delegate methods)

      Всем спасибо за советы.
Как у меня прошло?
1) implements List2) делегирование
3) исправление:
@Override
    public synchronized boolean containsAll(Collection<?> c)
    {
        return false;
    }

на:
@Override
    public synchronized boolean containsAll(Collection<?> c)
    {
        return original.containsAll©;
    }







     */

}