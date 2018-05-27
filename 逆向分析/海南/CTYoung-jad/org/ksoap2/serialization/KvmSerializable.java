// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.util.Hashtable;

// Referenced classes of package org.ksoap2.serialization:
//            PropertyInfo

public interface KvmSerializable
{

    public abstract Object getProperty(int i);

    public abstract int getPropertyCount();

    public abstract void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyinfo);

    public abstract void setProperty(int i, Object obj);
}
