// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.kobjects.util;

import java.util.Enumeration;

public class SingleEnumeration
    implements Enumeration
{

    public SingleEnumeration(Object obj)
    {
        object = obj;
    }

    public boolean hasMoreElements()
    {
        return object != null;
    }

    public Object nextElement()
    {
        Object obj = object;
        object = null;
        return obj;
    }

    Object object;
}
