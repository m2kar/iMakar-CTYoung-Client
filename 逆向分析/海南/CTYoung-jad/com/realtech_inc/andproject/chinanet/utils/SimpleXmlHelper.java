// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleXmlHelper
{

    public SimpleXmlHelper()
    {
    }

    public static String buildStrByTagAndValue(String s, String s1)
    {
        boolean flag;
        if(s1 == null || s1.trim().equals(""))
            flag = true;
        else
            flag = false;
        if(flag)
            return (new StringBuilder(32)).append("<").append(s).append("/>").toString();
        else
            return (new StringBuilder(128)).append("<").append(s).append(">").append(s1).append("</").append(s).append(">").toString();
    }

    public static String getPropValue(String s, String s1)
    {
        String s2 = "";
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(" ");
        stringbuilder.append(s1);
        stringbuilder.append("=");
        stringbuilder.append("[\"']");
        stringbuilder.append("(.*?)");
        stringbuilder.append("[\"']");
        s1 = Pattern.compile(stringbuilder.toString()).matcher(s);
        s = s2;
        if(s1.find())
            s = s1.group(1);
        return s;
    }

    public static ArrayList getTagDataList(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        String s2 = (new StringBuilder()).append("</").append(s1).append(">").toString();
        s1 = (new StringBuilder()).append("<").append(s1).toString();
        s = s.split(s2);
        int j = s.length;
        for(int i = 0; i < j; i++)
        {
            String s3 = s[i];
            if(s3.indexOf(s1) >= 0)
                arraylist.add((new StringBuilder()).append(s3).append(s2).toString());
        }

        return arraylist;
    }

    public static String getTagValue(String s, String s1)
    {
        String s2 = "";
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<");
        stringbuilder.append(s1);
        stringbuilder.append("(.*?)");
        stringbuilder.append(">");
        stringbuilder.append("([\\s\\S]*)");
        stringbuilder.append("</");
        stringbuilder.append(s1);
        stringbuilder.append(">");
        s1 = Pattern.compile(stringbuilder.toString()).matcher(s);
        s = s2;
        if(s1.find())
            s = s1.group(s1.groupCount());
        return s;
    }

    public static String getValue(String s, String s1, String s2, String s3)
    {
        String s4 = "";
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<");
        stringbuilder.append(s1);
        stringbuilder.append(" ");
        stringbuilder.append(s2);
        stringbuilder.append("=");
        stringbuilder.append("\"");
        stringbuilder.append(s3);
        stringbuilder.append("\"");
        stringbuilder.append(">");
        stringbuilder.append("([\\s\\S]*)");
        stringbuilder.append("</");
        stringbuilder.append(s1);
        stringbuilder.append(">");
        s1 = Pattern.compile(stringbuilder.toString()).matcher(s);
        s = s4;
        if(s1.find())
            s = s1.group(s1.groupCount());
        return s.substring(0, 1);
    }

    public static void insertStringBuilderByTagAndValue(StringBuilder stringbuilder, String s, String s1)
    {
        boolean flag;
        if(s1 == null || s1.trim().equals(""))
            flag = true;
        else
            flag = false;
        if(flag)
        {
            stringbuilder.append("<").append(s).append(" />").toString();
            return;
        } else
        {
            stringbuilder.append("<").append(s).append(">").append(s1).append("</").append(s).append(">").toString();
            return;
        }
    }

    public static void insertStringBuilderByTagAndValueAndType(StringBuilder stringbuilder, String s, String s1, String s2)
    {
        boolean flag;
        if(s1 == null || s1.trim().equals(""))
            flag = true;
        else
            flag = false;
        if(flag)
        {
            stringbuilder.append("<").append(s).append(" />").toString();
            return;
        }
        if(s2 == null || s2.trim().equals(""))
        {
            stringbuilder.append("<").append(s).append(">").append(s1).append("</").append(s).append(">").toString();
            return;
        } else
        {
            stringbuilder.append("<").append(s).append(" type=\"").append(s2).append("\">").append(s1).append("</").append(s).append(">").toString();
            return;
        }
    }

    public static void main(String args[])
    {
        getTagValue("<req cmd=\"login\" id=\"0001\" userid='0001' ver=\"\"><state1 user=\"057181930662\"/><a>112233</a></req>", "req");
        getPropValue("<req cmd=\"login\" id=\"0001\" userid='0001' ver=\"\"><state1 user=\"057181930662\"/><a>112233</a></req>", "userid");
    }

    public static void parseXml(DefaultHandler defaulthandler, String s)
    {
        try
        {
            XMLReader xmlreader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xmlreader.setContentHandler(defaulthandler);
            xmlreader.parse(new InputSource(new ByteArrayInputStream(s.getBytes())));
            return;
        }
        // Misplaced declaration of an exception variable
        catch(DefaultHandler defaulthandler)
        {
            defaulthandler.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(DefaultHandler defaulthandler)
        {
            defaulthandler.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(DefaultHandler defaulthandler)
        {
            defaulthandler.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(DefaultHandler defaulthandler)
        {
            defaulthandler.printStackTrace();
        }
    }

    public static String replace(String s, String s1, String s2)
    {
        int i = s.indexOf(s1);
        if(i < 0)
            return s;
        StringBuffer stringbuffer = new StringBuffer(s.substring(0, i));
        int j = s1.length();
        do
        {
            stringbuffer.append(s2);
            int k = i + j;
            i = s.indexOf(s1, k);
            if(i < 0)
            {
                stringbuffer.append(s.substring(k));
                return stringbuffer.toString();
            }
            stringbuffer.append(s.substring(k, i));
        } while(true);
    }

    public static void setValue(String s, String s1, String s2)
    {
        s.replaceAll((new StringBuilder()).append("${").append(s1).append("}").toString(), s2);
    }

    public static String xmlEscape(String s)
    {
        return replace(replace(replace(replace(replace(s, "&", "&amp;"), "<", "&lt;"), ">", "&gt;"), "\"", "&quot;"), "'", "&apos;");
    }

    public static String xmlUnEscape(String s)
    {
        return replace(replace(replace(replace(replace(s, "&amp;", "&"), "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'");
    }
}
