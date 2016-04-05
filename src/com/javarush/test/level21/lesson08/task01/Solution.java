package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User)super.clone();
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution solutionClone = (Solution)super.clone();
        solutionClone.users = new LinkedHashMap<>();
        for(Map.Entry<String, User> mEntry : this.users.entrySet()){
//            solutionClone.users.put(new String(mEntry.getKey()),(User)mEntry.getValue().clone());
            solutionClone.users.put(mEntry.getKey(),mEntry.getValue().clone());
        }
        return solutionClone;
    }
}
/*три хинта:
1. Прочитай первую и последнюю строчку задания;
2. Посмотри сигнатуру метода clone() у Object;
3. В Java 1.5 появилась возможность сужать тип возвращаемого значения при переопределении методов.
==За 3-й пункт как то и не догадывался. Не думал что повлияет на проверку. Хотя теперь понимаю что если в проверочном коде не будет приведения к типу Solution (а его там скорее нет) то будет ошибка компиляции.
==Разве отсутствие сужение типа является ошибкой
==Ну вообще да, потому что если ты будешь переопределять метод как
protected Object clone() throws CloneNotSupportedException
, что по умолчанию делает IDEA, то у тебя метод и будет возвращать объект типа Object, а не Solution, поэтому сужение типа обязательно.

По пунктам:
1. В clone() возвращаем требуем тип;
2. В клоне создаётся новый объект;
3. Он заполняется путём извлечения данных из текущего объекта.
P.S из users тоже нужно доставать значения.

1.Хочу написать как я понял(на более абстрактном уровне), может кому то поможет.

Первый случай: у нас есть кот Рыжик (класс), у него есть имя, возраст, вес, порода. Мы хотим сделать клон Рыжика с такой же породой, но другими остальными данными, для этого нам нужно сделать — поверхностное клонирование(так как все данные кота его личные, то есть нету никаких ссылок на другие обьекты). Для этого мы просто в методе clone возвращаем метод (Cat)super.clone(). И когда уже у нас есть клон, мы даем ему новое имя, возраст и вес и это никак не влияет на первого кота.

Второй случай: у Рыжика помимо вышеперечисленных данных еще есть список (ArrayListlist = new ArrayList()) еды, которую он больше всего любит. Что же будет если использовать обычное клонирование?
А будет следующее, когда мы создадим клона, ему нужно будет создать тоже список его любимой еды и что бы вы не делали, добавляли, удаляли элементы, все будет отражаться и на первом коте и наоборот, потому что ссылка у двух котов на список одна, грубо говоря у них есть один листок бумаги, чтобы они с ним не делали изменения будут происходит у обоих. Для того чтобы этого избежать нужен следующий вид клонирования.
Тут нам пригодится глубокое клонирование, так как у нас есть в классе ссылка на другой обьект. Все что нужно сделать это в методе clone() прописать вот такие вот строчки:

 Cat clone = (Cat)super.clone();
clone.list=(ArrayList<String>)list.clone();
 return clone;

И после этого наши коты будут иметь разные ссылки на списки и у каждого из них будет разный список любимой еды :)
Если же у нас вместо списка допустим словарь Map, то так как он не имеет метода clone(), тут как я понимаю, нужно будет в самом методе clone вручную создать новую ссылку. Надеюсь кому то поможет такое обьяснение, понять суть клонирования ))

2.в Вашем примере с ArrayList нужно уточнить, что list.clone() будет работать (в смысле глубокого клонирования) для ArrayList, а для ArrayList- нет, т.к. ссылки на список будут, действительно, разные, а вот ссылки на элементы списка - одинаковые. Соответственно, результаты манипуляций со значениями полей этих объектов будут отражаться в обоих списках.
Строго говоря, аналогично будет и для String, т.к. элементы списка типа String тоже объекты. Но для String это не критично, т.к. манипуляции со значением элемента приведут к созданию нового объекта String.

* */
