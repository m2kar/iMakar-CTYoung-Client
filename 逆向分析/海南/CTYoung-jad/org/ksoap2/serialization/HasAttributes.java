// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;


// Referenced classes of package org.ksoap2.serialization:
//            AttributeInfo

public interface HasAttributes
{

    public abstract int getAttributeCount();

    public abstract void getAttributeInfo(int i, AttributeInfo attributeinfo);
}
