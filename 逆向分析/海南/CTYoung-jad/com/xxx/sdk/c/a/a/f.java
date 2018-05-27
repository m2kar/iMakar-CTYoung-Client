// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a.a;

import java.util.ArrayList;
import java.util.List;

final class f
{

    f()
    {
        m = new ArrayList();
    }

    public final String toString()
    {
        return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"bundle\":\"%s\",\"cat\":%s}", new Object[] {
            id, name, bv, m
        });
    }

    private final String bl;
    String bv;
    String id;
    List m;
    String name;
}
