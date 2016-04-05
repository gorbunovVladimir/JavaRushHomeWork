package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
        @Override
        protected Tree clone() throws CloneNotSupportedException {
            /*StringBuilder nameClone=new StringBuilder("");
            for (int i=0;i<getName().length();i++){nameClone.append(getName().charAt(i));}

            String[] BranchesClone=new String[getBranches().length];
            StringBuilder branchesClone=new StringBuilder("");
            for (int i=0;i<getBranches().length;i++){
                for (int j=0;j<getBranches()[i].length();j++){branchesClone.append(getBranches()[i].charAt(j));}
                BranchesClone[i]=new String(branchesClone);
                branchesClone=new StringBuilder("");
                }
            Tree treeClone;
            if (branches == null) {
                treeClone = new Tree(new String(nameClone),null);
            } else treeClone = new Tree(new String(nameClone),BranchesClone);
            return treeClone;*/
            Tree treeClone;
            if (branches == null) treeClone = new Tree(getName(),null);
            else treeClone = new Tree(getName(),branches.clone());
            return treeClone;
        }
    }
}
/*Класс Plant не реализует Clonable.
То есть ваше новое дерево, которое делается в методе clone() не будет иметь то же имя (name) что и объект с которого клонируем. (в super.clone() клонирования name не происходит, в вашем методе тоже).
Еще не знаю насколько это обязательно, но у меня метод clone() возвращал Tree. Даже если это необязательно, но логично.

=Strings in Java are imutable(Can't change their value). So there is no detectable difference between a deep and shallow copy when copying strings.
And just to further reference: The copy will be shallow but that should not be a problem since strings are imutable.
Oh and funny fact: Strings can't be cloned with the clone method, so if you try to do a deep copy of strings with the clone method, you will get a CloneNotSupportedException.
=Для массива типа String достаточно просто вызвать метод clone, т.к. String — immutable.
=В данном случае достаточно вызвать метод clone() для массива. Это и выполниться оптимальнее и писать кода нужно меньше.
*/