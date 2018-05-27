// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.util.Vector;

// Referenced classes of package org.ksoap2.serialization:
//            HasAttributes, AttributeInfo, PropertyInfo

public class AttributeContainer
    implements HasAttributes
{

    public AttributeContainer()
    {
        attributes = new Vector();
    }

    private Integer attributeIndex(String s)
    {
        for(int i = 0; i < attributes.size(); i++)
            if(s.equals(((AttributeInfo)attributes.elementAt(i)).getName()))
                return new Integer(i);

        return null;
    }

    public void addAttribute(String s, Object obj)
    {
        AttributeInfo attributeinfo = new AttributeInfo();
        attributeinfo.name = s;
        if(obj == null)
            s = PropertyInfo.OBJECT_CLASS;
        else
            s = obj.getClass();
        attributeinfo.type = s;
        attributeinfo.value = obj;
        addAttribute(attributeinfo);
    }

    public void addAttribute(AttributeInfo attributeinfo)
    {
        attributes.addElement(attributeinfo);
    }

    public void addAttributeIfValue(String s, Object obj)
    {
        if(obj != null)
            addAttribute(s, obj);
    }

    public void addAttributeIfValue(AttributeInfo attributeinfo)
    {
        if(attributeinfo.value != null)
            attributes.addElement(attributeinfo);
    }

    protected boolean attributesAreEqual(AttributeContainer attributecontainer)
    {
        int j = getAttributeCount();
        if(j == attributecontainer.getAttributeCount()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if(i >= j)
                    break label1;
                AttributeInfo attributeinfo = (AttributeInfo)attributes.elementAt(i);
                Object obj = attributeinfo.getValue();
                if(!attributecontainer.hasAttribute(attributeinfo.getName()) || !obj.equals(attributecontainer.getAttributeSafely(attributeinfo.getName())))
                    break label0;
                i++;
            }
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public Object getAttribute(int i)
    {
        return ((AttributeInfo)attributes.elementAt(i)).getValue();
    }

    public Object getAttribute(String s)
    {
        Integer integer = attributeIndex(s);
        if(integer != null)
            return getAttribute(integer.intValue());
        else
            throw new RuntimeException("illegal property: " + s);
    }

    public String getAttributeAsString(int i)
    {
        return ((AttributeInfo)attributes.elementAt(i)).getValue().toString();
    }

    public String getAttributeAsString(String s)
    {
        Integer integer = attributeIndex(s);
        if(integer != null)
            return getAttribute(integer.intValue()).toString();
        else
            throw new RuntimeException("illegal property: " + s);
    }

    public int getAttributeCount()
    {
        return attributes.size();
    }

    public void getAttributeInfo(int i, AttributeInfo attributeinfo)
    {
        AttributeInfo attributeinfo1 = (AttributeInfo)attributes.elementAt(i);
        attributeinfo.name = attributeinfo1.name;
        attributeinfo.namespace = attributeinfo1.namespace;
        attributeinfo.flags = attributeinfo1.flags;
        attributeinfo.type = attributeinfo1.type;
        attributeinfo.elementType = attributeinfo1.elementType;
        attributeinfo.value = attributeinfo1.getValue();
    }

    public Object getAttributeSafely(String s)
    {
        s = attributeIndex(s);
        if(s != null)
            return getAttribute(s.intValue());
        else
            return null;
    }

    public Object getAttributeSafelyAsString(String s)
    {
        s = attributeIndex(s);
        if(s != null)
            return getAttribute(s.intValue()).toString();
        else
            return "";
    }

    public boolean hasAttribute(String s)
    {
        return attributeIndex(s) != null;
    }

    protected Vector attributes;
}
