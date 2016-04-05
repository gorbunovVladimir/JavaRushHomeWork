package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Vl on 17.04.2015.
 */

@XmlType(name = "anExample")
@XmlRootElement
public class AnExample {
    public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};
}
