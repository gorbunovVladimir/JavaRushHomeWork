package com.javarush.test.level33.lesson10.home01;

/**
 * Created by Vl on 17.04.2015.
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop
{

    @XmlElementWrapper(name = "goods",nillable = true)
    @XmlElement(name = "names")
    public List<String> names ;
    @XmlElement(name = "count")
    public int count;
    @XmlElement(name = "profit")
    public double profit;
    @XmlElement(name = "secretData")
    public List <String> secretData;
    /*@XmlElement(name = "secretData")
    public String s1;
    @XmlElement(name = "secretData")
    public String s2;
    @XmlElement(name = "secretData")
    public String s3;
    @XmlElement(name = "secretData")
    public String s4;
    @XmlElement(name = "secretData")
    public String s5;*/

    public Shop()
    {
        names = new ArrayList<>();
        secretData=new ArrayList<>();
    }
}
