package com.javarush.test.level31.lesson10.home01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;

/* Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.
Подсказка: возможно, Вам понадобится File.separator.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName)
    {
        Properties properties = new Properties();
        String fileSeparator = File.separator;
        Path path = Paths.get(fileName).toAbsolutePath();
        //System.out.println(path);
        Iterator<Path> iter = path.iterator();
        String resultPath = path.getRoot().toString();
        //System.out.println(resultPath);
        while (iter.hasNext())
        {
            resultPath += fileSeparator + iter.next();//System.out.println(resultPath);
        }
        /*Properties properties = new Properties();
        String resultPath=Paths.get(fileName).toAbsolutePath().toFile().getName();*/

        FileInputStream fis = null;FileReader fis1=null;
        try
        {
            try
            {
                fis = new FileInputStream(resultPath);
                properties.loadFromXML(fis);
            }
            catch (InvalidPropertiesFormatException e)
            {
                fis1 = new FileReader(resultPath);
                properties.load(fis1);
            }
            catch (FileNotFoundException e)
            {
                properties = new Properties();
            }
            finally
            {
                if (fis != null)
                    fis.close();
                if (fis1 != null)
                    fis1.close();
            }
        }
        catch (IOException e)
        {/*NOP*/}
        return properties;
    }
}
