package com.practice.Utility;


import org.apache.commons.lang3.RandomStringUtils;
import org.w3c.dom.NodeList;
import sun.plugin.dom.core.Document;
import sun.plugin.dom.core.Element;
import sun.plugin.dom.core.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;

public class TestUtilis {

    public static final long Wait=10;

    public HashMap<String, String> parseXMLString (InputStream file) throws Exception {

        HashMap<String,String> stringMap = new HashMap<String, String>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = (Document) builder.parse(file);
        document.getDocumentElement().normalize();

        Element root = (Element) document.getDocumentElement();

        NodeList nodeList = document.getElementsByTagName("string");

        for(int temp = 0;temp<nodeList.getLength();temp++){
            Node node = (Node) nodeList.item(temp);
            if(node.getNodeType() == Node.ELEMENT_NODE){

                Element element = (Element) node;

                stringMap.put(element.getAttribute("name"),element.getTextContent());
            }
        }

        return stringMap;
    }
    public static String getUserEmailId(){

       String emailid = RandomStringUtils.randomAlphabetic(5);
       return (emailid);

    }
}
