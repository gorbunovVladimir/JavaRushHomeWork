package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Vl on 19.04.2015.
 */
public class CurrencyManipulator
{String currencyCode;
 Map<Integer, Integer> denominations;

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();

    }
    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
            count += denominations.get(denomination);
        }
        denominations.put(denomination, count);
    }
    public int getTotalAmount()
    {
        int totalMoney = 0;
        for (Map.Entry<Integer, Integer> x : denominations.entrySet())
        {
            totalMoney += (x.getKey() * x.getValue());
        }
        return totalMoney;
    }
    public boolean hasMoney() {
        boolean result = false;

        for(Map.Entry<Integer, Integer> pair : denominations.entrySet()){
            if(pair.getValue() != 0){
                result = true;
            }
        }
        return result;
    }


    /**
     * method withdrawAmount
     * Жадный алгоритм возвращающий мапу с выводимыми купюрами
     */
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        // копия старой мапы, в которой еще не меняли значения, его храним, если окажется, что нам надо бросать NotEnoughMoneyException
        Map<Integer, Integer> copyOfDenominations = new TreeMap<Integer, Integer>(denominations);
        int withdrawMoney = expectedAmount; //количество снимаемых денег (остаток)
        //мапа с результом с сортировка от большего к меньшему
        Map<Integer, Integer> result = new TreeMap<Integer, Integer>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (o1 > o2) ? -1 : ((o1 == o2) ? 0 : 1);
            }
        });
        try{
        //в этом блоке кода происходит основная магия

        Iterator<Map.Entry<Integer, Integer>> iterator = denominations.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> x = iterator.next();
            int currentBanknote = x.getKey(); //номинал банкнот
            int remainingBanknotes = x.getValue(); //количество банкнот
            int countOfCurrentBanknotes = 0; //число текущих банкнот, которые следует выдать
            //если кол-во банкнот данного номинала и остаток от снятия в случае удачно операции >=0, то...
            while ((remainingBanknotes > 0) && ((withdrawMoney - currentBanknote) >= 0))
            {
                //изменяем остаток
                withdrawMoney -= currentBanknote;
                //изменяем кол-во оставшихся банкнот в мапе
                remainingBanknotes--;
                //проверяем кол-во оставшихся банкнот, что бы удалить, если их не осталось.
                if (remainingBanknotes == 0)
                {
                    iterator.remove();
                } else x.setValue(remainingBanknotes);
                countOfCurrentBanknotes++;
            }
            //заносим в мапу "результ" наши банкноты текущего номинала
            if (countOfCurrentBanknotes > 0)
            {
                result.put(currentBanknote, countOfCurrentBanknotes);
            }
        }
        //ЕЩЕ разок проверяем если остаток>0 и при этом у нас в мапе еще остались деньги, то это означает, что
        //данными банкнотами невозможно выдать запрашиваемую сумму, кидаем эксепшен
        if ((withdrawMoney > 0) && (withdrawMoney < getTotalAmount()))
        {
            //нужно как-то откатить на старую версию denominations
            denominations.clear();
            denominations.putAll(copyOfDenominations);
            //это все если данными купюрами не можем выдать
            throw new NotEnoughMoneyException();
        }}
        catch (ConcurrentModificationException e){}
        return result;
    }


    public boolean isAmountAvailable(int expectedAmount)
    {
        return (expectedAmount <= getTotalAmount()) ? true : false;
    }
}
