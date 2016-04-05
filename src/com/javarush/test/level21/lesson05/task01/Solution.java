package com.javarush.test.level21.lesson05.task01;



import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        if (last != null ? !last.equals(solution.last) : solution.last != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    /*
                public boolean equals(Solution n) {
                    return n.first.equals(first) && n.last.equals(last);
                }

                public int hashCode() {
                    return 31 * first.hashCode() + last.hashCode();
                }*/


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
/*стандартные hashcode и equals в idea. alt+insert
а, понял, дело в последних галочках которые я там ставил в диалоге, где select-all-non-null fields, которые убирали проверки на null

1. Хэши лучше считать не так, как вам вздумается (даже если вам кажется, что вы выполнили все требования к этой функции), а так как рекомендуется с точки зрения равномерности распределения и уменьшения коллизий.
2. null-ы. Они могут быть везде!

Да, в этой задаче есть подвох. Следующие пары объектов нужно считать равными:
new Solution(null, null)
new Solution(null, null)

new Solution("first", null)
new Solution("first", null)

new Solution(null, "last")
new Solution(null, "last")

Внимательно, очень внимательно смотрим сигнатуры методов. А потом курим лекцию про перегрузку методов.

В hascode надо бы добавить проверку на null, иначе может получится, что Вы с null какие-то действия выполнить пытаетесь. В equals() почему не Object в метод передается? Первая проверка должна быть на равенство, вдруг это один объект. Кроме того, нужно добавить проверку на null для полей, опять же, два null не сравниваются, а они равны. В общем, почитайте Хорстмана, у него это хорошо расписано.


* */