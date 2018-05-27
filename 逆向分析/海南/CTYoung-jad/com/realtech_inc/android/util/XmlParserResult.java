// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.android.util;

import java.util.*;

public class XmlParserResult
{

    public XmlParserResult(String s)
    {
        mName = s;
        mSubElements = new ArrayList();
    }

    public XmlParserResult addSubElement(String s)
    {
        s = new XmlParserResult(s);
        mSubElements.add(s);
        return s;
    }

    public List getvalues(String s)
    {
        ArrayList arraylist = new ArrayList();
        if(mName.equals(s) && mValue != null)
            arraylist.add(mValue);
        for(Iterator iterator = mSubElements.iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((XmlParserResult)iterator.next()).getvalues(s).iterator();
            while(iterator1.hasNext()) 
                arraylist.add((String)iterator1.next());
        }

        return arraylist;
    }

    public void setValue(String s)
    {
        mValue = s;
    }

    String mName;
    List mSubElements;
    String mValue;
}
