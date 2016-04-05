package com.javarush.test.level21.lesson10.task02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/* Освобождаем ресурсы
Реализуйте метод finalize, подумайте, что именно в нем должно быть.
Отрефакторите метод getUsers в соответствии с java7 try-with-resources.
Допускаются только текстовые коментарии.
*/
public class Solution {
    private Connection connection;

    public Solution(Connection connection) {
        this.connection = connection;
    }

    @Override
    protected void finalize() throws Throwable {super.finalize();connection.close();}

    public List<User> getUsers() {
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";
        List<User> result = new LinkedList();
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        )
        {   while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");
                result.add(new User(id, name, level, lesson));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }
   /* -override finalize()
      public List<User> getUsers() {
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";

        List<User> result = new LinkedList();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");

                result.add(new User(id, name, level, lesson));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }*/

    public static class User {
        private int id;
        private String name;
        private int level;
        private int lesson;

        public User(int id, String name, int level, int lesson) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.lesson = lesson;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", lesson=" + lesson +
                    '}';
        }
    }
}
/*finalize() —
метод, который помогает при сборке мусора
. Метод, который вызывается перед тем, как объект будет уничтожен сборщиком мусора
он не может быть использован как основной способ для очистки закрытия потоков сначала вызываются специальные средства добавленные в java 7 а потом уже этот метод


=Да прав осталось только решить что делать с connection. Сам когда то задачу эту решал. Мне решение данной задачи показалось довольно странным. Взять допустим con.close() vs con.commit(). У меня к примеру с commit() пару месяцев назад не принялось может сейчас что изменили. А открыавть и закрывать каждый раз довольно странная практика.
=Не буду переубеждать. Займетесь базами данных поймете почему практика очень странная.
Пример из жизни так для общего развития. (база пусть будет HSQLDB чтобы было проще)
Есть ДБ и много юзеров. Юзер нажал на кнопку и его 1 000 000 entries летят в дб. Это занимает где то 14 секунд вся операция, из них почти 2 секунды открыть connection. Юзеров сотни и постоянно вставляют данные удаляют данные. Каждая операция будет сьедать дополнительно 2 секунды + garbage collector будет стартовать daemon потоки чтобы удалять из памяти ненужные данные о использованых connection.
=Криво описал. Вобщем в данном примере я так понимаю этот connection приходит из connection pool. И что не мало важно connection pool передает connection уже завернутый во что точно не помню. Когда метод getUsers отработал если сделать connection.commit() все запишется в датабазу и наш pool вернет connection себе с обнуленными данными и готовым к работе. У меня же не прошла задача пока в finalize() не прибил connection() вот это меня и смутило причем очень. Смысл данной операции непонятен до сих пор
=Когда метод getUsers отработал если сделать connection.commit() все запишется в датабазу
В getUsers только select, возможно, поэтому не нужен commit()

 сообщение компилятора: "try-with-resources are not supported at this language level".
В самой IDEA в настройках джава 7 включите
File ->Project Structure ->Project -> Project language level
 */