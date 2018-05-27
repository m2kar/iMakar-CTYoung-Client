// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;


// Referenced classes of package org.ksoap2.serialization:
//            AttributeContainer

public class SoapPrimitive extends AttributeContainer
{

    public SoapPrimitive(String s, String s1, Object obj)
    {
        namespace = s;
        name = s1;
        value = obj;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if(!(obj instanceof SoapPrimitive))
            return false;
        obj = (SoapPrimitive)obj;
        boolean flag;
        if(name.equals(((SoapPrimitive) (obj)).name) && (namespace != null ? namespace.equals(((SoapPrimitive) (obj)).namespace) : ((SoapPrimitive) (obj)).namespace == null) && (value != null ? value.equals(((SoapPrimitive) (obj)).value) : ((SoapPrimitive) (obj)).value == null))
            flag = true;
        else
            flag = false;
        if(!flag || !attributesAreEqual(((AttributeContainer) (obj))))
            flag1 = false;
        return flag1;
    }

    public String getName()
    {
        return name;
    }

    public String getNamespace()
    {
        return namespace;
    }

    public Object getValue()
    {
        return value;
    }

    public int hashCode()
    {
        int j = name.hashCode();
        int i;
        if(namespace == null)
            i = 0;
        else
            i = namespace.hashCode();
        return i ^ j;
    }

    public String toString()
    {
        if(value != null)
            return value.toString();
        else
            return null;
    }

    public static final Object NullNilElement = new Object();
    public static final Object NullSkip = new Object();
    protected String name;
    protected String namespace;
    protected Object value;

}
