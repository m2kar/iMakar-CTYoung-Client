// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.a;

import com.xxx.sdk.e.a.a.d.b;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.e.a.a.e.c;
import java.nio.ByteBuffer;
import java.util.Locale;

// Referenced classes of package com.xxx.sdk.e.a.a.d.a:
//            l, b, c, d, 
//            h

public final class k
{

    public k(l l1)
    {
        W = l1.W;
        locale = new Locale(l1.a.bK, l1.a.bL);
    }

    private com.xxx.sdk.e.a.a.d.a.c a()
    {
        long l1 = a_java_nio_ByteBuffer_fld.position();
        com.xxx.sdk.e.a.a.d.a.c c1 = new com.xxx.sdk.e.a.a.d.a.c();
        c1.size = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        c1.flags = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        long l2 = a_java_nio_ByteBuffer_fld.getInt();
        h h1 = c;
        int i = (int)l2;
        c1.key = h1.e[i];
        if((c1.flags & 1) != 0)
        {
            d d1 = new d(c1);
            d1.x = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            d1.count = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)c1.size));
            c1 = new com.xxx.sdk.e.a.a.d.a.h[(int)d1.count];
            for(int j = 0; (long)j < d1.count; j++)
            {
                com.xxx.sdk.e.a.a.d.a.h h2 = new com.xxx.sdk.e.a.a.d.a.h();
                h2.z = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
                h2.c = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
                if((h2.z & 0x2000000L) == 0L)
                    l1 = h2.z;
                c1[j] = h2;
            }

            d1.a = c1;
            return d1;
        } else
        {
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)c1.size));
            c1.b = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
            return c1;
        }
    }

    private com.xxx.sdk.e.a.a.d.a.h a()
    {
        com.xxx.sdk.e.a.a.d.a.h h1 = new com.xxx.sdk.e.a.a.d.a.h();
        h1.z = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
        h1.c = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
        long l1;
        if((h1.z & 0x2000000L) == 0L)
            l1 = h1.z;
        return h1;
    }

    private ByteBuffer a()
    {
        return a_java_nio_ByteBuffer_fld;
    }

    private void a(ByteBuffer bytebuffer)
    {
        a_java_nio_ByteBuffer_fld = bytebuffer;
    }

    private void a(long al[])
    {
        a_long_array1d_fld = al;
    }

    private long[] a()
    {
        return a_long_array1d_fld;
    }

    private h b()
    {
        return c;
    }

    private void b(h h1)
    {
        c = h1;
    }

    private h c()
    {
        return a_com_xxx_sdk_e_a_a_d_h_fld;
    }

    private void c(h h1)
    {
        a_com_xxx_sdk_e_a_a_d_h_fld = h1;
    }

    private Locale getLocale()
    {
        return locale;
    }

    private String getName()
    {
        return name;
    }

    private short o()
    {
        return W;
    }

    private void o(short word0)
    {
        W = word0;
    }

    private void setLocale(Locale locale1)
    {
        locale = locale1;
    }

    private void setName(String s)
    {
        name = s;
    }

    public final com.xxx.sdk.e.a.a.d.a.c a(int i)
    {
        while(i >= a_long_array1d_fld.length || a_long_array1d_fld[i] == 0xffffffffL) 
            return null;
        a_java_nio_ByteBuffer_fld.position((int)a_long_array1d_fld[i]);
        long l1 = a_java_nio_ByteBuffer_fld.position();
        com.xxx.sdk.e.a.a.d.a.c c1 = new com.xxx.sdk.e.a.a.d.a.c();
        c1.size = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        c1.flags = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        long l2 = a_java_nio_ByteBuffer_fld.getInt();
        h h1 = c;
        i = (int)l2;
        c1.key = h1.e[i];
        if((c1.flags & 1) != 0)
        {
            d d1 = new d(c1);
            d1.x = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            d1.count = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)c1.size));
            c1 = new com.xxx.sdk.e.a.a.d.a.h[(int)d1.count];
            for(i = 0; (long)i < d1.count; i++)
            {
                com.xxx.sdk.e.a.a.d.a.h h2 = new com.xxx.sdk.e.a.a.d.a.h();
                h2.z = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
                h2.c = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
                if((h2.z & 0x2000000L) == 0L)
                    l1 = h2.z;
                c1[i] = h2;
            }

            d1.a = c1;
            return d1;
        } else
        {
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)c1.size));
            c1.b = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
            return c1;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Type{name='")).append(name).append('\'').append(", id=").append(W).append(", locale=").append(locale).append('}').toString();
    }

    public short W;
    public h a_com_xxx_sdk_e_a_a_d_h_fld;
    public ByteBuffer a_java_nio_ByteBuffer_fld;
    public long a_long_array1d_fld[];
    public h c;
    public Locale locale;
    public String name;
}
