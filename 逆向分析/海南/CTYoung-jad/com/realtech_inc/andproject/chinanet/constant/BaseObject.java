// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.constant;

import java.io.Serializable;

public abstract class BaseObject
    implements Serializable
{

    public BaseObject()
    {
    }

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract String toString();

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String TIMEZONE = "GMT+08:00";
    public static final String TIME_FORMAT = "HH:mm:ss";
}
