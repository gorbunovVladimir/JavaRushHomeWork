package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        for (int i=0;i<realOrder.length;i++)
        {for (int j=0;j<realOrder.length;j++){if (realOrder[j]>=0&&realOrder[j]==i)result.add(Column.values()[j]);}}

        return result;}

        //@return полное имя колонки
        public String getColumnName(){return columnName;}

        //Возвращает true, если колонка видимая, иначе false
        public boolean isShown(){return realOrder[this.ordinal()] != -1;}

        //Скрывает колонку - маркирует колонку -1 в массиве realOrder.Сдвигает индексы отображаемых колонок, которые идут после скрытой
        public void hide(){
            /*int index = this.ordinal();
            for (int i = 0; i < realOrder.length; i++) {
                if (realOrder[i] == index)realOrder[i] = -1;
            }*/
            Column[] columns = values();
            for (int i = 0; i < columns.length; i++)
            {
                if (columns[i] == columns[this.ordinal()])
                {
                    realOrder[i] = -1;
                }
            }

        }



}
