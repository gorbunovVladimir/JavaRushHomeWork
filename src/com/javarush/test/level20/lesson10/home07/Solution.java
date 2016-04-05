package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String filename;
    private static final long serialVersionUID=11111111;
    public Solution(String fileName) throws FileNotFoundException {
        filename = fileName;
        stream = new FileOutputStream(filename);
    }
    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //?out.writeObject(filename);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //?filename=(String)in.readObject();
        stream = new FileOutputStream(filename,true);
    }
    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    //for testing
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("D:\\qqq.txt");
        sol.writeObject("eeeeee");
        System.out.println(sol.stream);
        System.out.println(sol.filename);
        //save to file
        FileOutputStream fos = new FileOutputStream("D:\\save.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sol);
        oos.close();
        fos.close();sol.close();
        //
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while (!br.readLine().equals("q")){System.out.println("!!!!!!Vedi q");}
        //load from file
        FileInputStream fis = new FileInputStream("D:\\save.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution sol2 = (Solution) ois.readObject();
        ois.close();fis.close();
        System.out.println(sol2.stream);
        sol2.writeObject("wwwwwwww");System.out.println(sol2.filename);sol2.close();
    }
}
/*Подумайте, если записать что-либо в файл fileName,
сериализовать объект Solution,
то после десериализации Solution, например, на другом компьютере:
1. должен появиться такой же файл fileName, содержащий введенные ранее данные,
2. должна быть возможность дополнить файл fileName новыми данными.

1) Надо создать поле fileName и как полагается считать и записать его в соответствующих методах readObject () и writeObject () (ну про конструктор уж молчу).
2) Наше поле stream должно же как-то инициализироваться после десериализации, а посему после считывания fileName инициализируем stream.
3) Когда инициализируем stream, ооооочень внимательно смотрим на параметры конструктора (должен передать 2 параметра)
4) stream не сериализуется, добавляем соответствущий модификатор.

new FileOutputStream(filename, true);
public FileOutputStream(String name, boolean append){...}
If the second argument is true, then bytes will be written to the end of the file rather than the beginning
из документации. а я то думал, что хоть немного понял эту тему, ага - фиг, без заглядывание в документацию ничего нельзя понять
*/