// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import android.util.Xml;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public class XmlDom
{

    public XmlDom(InputStream inputstream)
        throws SAXException
    {
        DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
        try
        {
            root = documentbuilderfactory.newDocumentBuilder().parse(inputstream).getDocumentElement();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(InputStream inputstream)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch(InputStream inputstream)
        {
            throw new SAXException(inputstream);
        }
    }

    public XmlDom(String s)
        throws SAXException
    {
        this(s.getBytes());
    }

    public XmlDom(Element element)
    {
        root = element;
    }

    public XmlDom(byte abyte0[])
        throws SAXException
    {
        this(((InputStream) (new ByteArrayInputStream(abyte0))));
    }

    private static XmlDom convert(Node node, String s, String s1, String s2)
    {
        if(node.getNodeType() == 1)
        {
            node = (Element)node;
            if((s == null || s.equals(node.getTagName())) && (s1 == null || node.hasAttribute(s1)) && (s2 == null || s2.equals(node.getAttribute(s1))))
                return new XmlDom(node);
        }
        return null;
    }

    private static List convert(NodeList nodelist, String s, String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < nodelist.getLength(); i++)
        {
            XmlDom xmldom = convert(nodelist.item(i), s, s1, s2);
            if(xmldom != null)
                arraylist.add(xmldom);
        }

        return arraylist;
    }

    private String serialize(Element element, int i)
    {
        XmlSerializer xmlserializer;
        StringWriter stringwriter;
        try
        {
            xmlserializer = Xml.newSerializer();
            stringwriter = new StringWriter();
            xmlserializer.setOutput(stringwriter);
            xmlserializer.startDocument("utf-8", null);
        }
        // Misplaced declaration of an exception variable
        catch(Element element)
        {
            element.printStackTrace();
            return null;
        }
        element = null;
        if(i <= 0)
            break MISSING_BLOCK_LABEL_55;
        element = new char[i];
        Arrays.fill(element, ' ');
        element = new String(element);
        serialize(root, xmlserializer, 0, ((String) (element)));
        xmlserializer.endDocument();
        element = stringwriter.toString();
        return element;
    }

    private void serialize(Element element, XmlSerializer xmlserializer, int i, String s)
        throws Exception
    {
        int k;
        int l;
        String s1;
        s1 = element.getTagName();
        writeSpace(xmlserializer, i, s);
        xmlserializer.startTag("", s1);
        if(element.hasAttributes())
        {
            NamedNodeMap namednodemap = element.getAttributes();
            for(int j = 0; j < namednodemap.getLength(); j++)
            {
                Attr attr1 = (Attr)namednodemap.item(j);
                xmlserializer.attribute("", attr1.getName(), attr1.getValue());
            }

        }
        if(!element.hasChildNodes())
            break MISSING_BLOCK_LABEL_281;
        element = element.getChildNodes();
        l = 0;
        k = 0;
_L7:
        int i1;
        Node node;
        if(k >= element.getLength())
            break MISSING_BLOCK_LABEL_268;
        node = element.item(k);
        i1 = l;
        node.getNodeType();
        JVM INSTR tableswitch 1 4: default 188
    //                   1 205
    //                   2 192
    //                   3 229
    //                   4 249;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_249;
_L2:
        break; /* Loop/switch isn't completed */
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = l;
_L8:
        k++;
        l = i1;
        if(true) goto _L7; else goto _L6
_L6:
        serialize((Element)node, xmlserializer, i + 1, s);
        i1 = l + 1;
          goto _L8
_L4:
        xmlserializer.text(text(node));
        i1 = l;
          goto _L8
        xmlserializer.cdsect(text(node));
        i1 = l;
          goto _L8
        if(l > 0)
            writeSpace(xmlserializer, i, s);
        xmlserializer.endTag("", s1);
        return;
    }

    private String text(Node node)
    {
        Object obj = null;
        node.getNodeType();
        JVM INSTR tableswitch 3 4: default 32
    //                   3 45
    //                   4 66;
           goto _L1 _L2 _L3
_L1:
        node = obj;
_L5:
        Object obj1 = node;
        if(node == null)
            obj1 = "";
        return ((String) (obj1));
_L2:
        String s = node.getNodeValue();
        node = s;
        if(s != null)
            node = s.trim();
        continue; /* Loop/switch isn't completed */
_L3:
        node = node.getNodeValue();
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void writeSpace(XmlSerializer xmlserializer, int i, String s)
        throws Exception
    {
        if(s != null)
        {
            xmlserializer.text("\n");
            for(int j = 0; j < i; j++)
                xmlserializer.text(s);

        }
    }

    public String attr(String s)
    {
        return root.getAttribute(s);
    }

    public XmlDom child(String s)
    {
        return child(s, null, null);
    }

    public XmlDom child(String s, String s1, String s2)
    {
        s = children(s, s1, s2);
        if(s.size() == 0)
            return null;
        else
            return (XmlDom)s.get(0);
    }

    public List children(String s)
    {
        return children(s, null, null);
    }

    public List children(String s, String s1, String s2)
    {
        return convert(root.getChildNodes(), s, s1, s2);
    }

    public Element getElement()
    {
        return root;
    }

    public XmlDom tag(String s)
    {
        NodeList nodelist = root.getElementsByTagName(s);
        Object obj = null;
        s = obj;
        if(nodelist != null)
        {
            s = obj;
            if(nodelist.getLength() > 0)
                s = new XmlDom((Element)nodelist.item(0));
        }
        return s;
    }

    public XmlDom tag(String s, String s1, String s2)
    {
        s = tags(s, s1, s2);
        if(s.size() == 0)
            return null;
        else
            return (XmlDom)s.get(0);
    }

    public List tags(String s)
    {
        return tags(s, null, null);
    }

    public List tags(String s, String s1, String s2)
    {
        return convert(root.getElementsByTagName(s), null, s1, s2);
    }

    public String text()
    {
        NodeList nodelist = root.getChildNodes();
        if(nodelist.getLength() == 1)
            return nodelist.item(0).getNodeValue();
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < nodelist.getLength(); i++)
            stringbuilder.append(text(nodelist.item(i)));

        return stringbuilder.toString();
    }

    public String text(String s)
    {
        s = child(s);
        if(s == null)
            return null;
        else
            return s.text();
    }

    public String toString()
    {
        return toString(0);
    }

    public String toString(int i)
    {
        return serialize(root, i);
    }

    private Element root;
}
