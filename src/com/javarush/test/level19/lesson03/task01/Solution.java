package com.javarush.test.level19.lesson03.task01;

/* TableAdapter
Измените класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable"
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable{
      private ATable atable;
        TableAdapter (ATable atable){this.atable=atable;}

        @Override
        public String getHeaderText()
        {
            return "["+this.atable.getCurrentUserName()+"]"+" : "+this.atable.getTableName();
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}