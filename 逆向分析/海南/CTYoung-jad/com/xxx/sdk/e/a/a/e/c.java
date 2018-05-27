// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e;

import com.xxx.sdk.e.a.a.b.a;
import com.xxx.sdk.e.a.a.c.e;
import com.xxx.sdk.e.a.a.d.a.f;
import com.xxx.sdk.e.a.a.d.a.k;
import com.xxx.sdk.e.a.a.d.a.m;
import com.xxx.sdk.e.a.a.d.b;
import com.xxx.sdk.e.a.a.d.d;
import com.xxx.sdk.e.a.a.d.g;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.e.a.a.d.i;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class c
{

    public c()
    {
    }

    public static g a(ByteBuffer bytebuffer, h h1)
    {
        d d1;
        d1 = new d();
        d1.size = bytebuffer.getShort() & 0xffff;
        d1.I = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        d1.J = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        d1.J;
        JVM INSTR lookupswitch 12: default 152
    //                   0: 308
    //                   1: 256
    //                   3: 226
    //                   5: 367
    //                   6: 513
    //                   16: 207
    //                   17: 207
    //                   18: 275
    //                   28: 346
    //                   29: 325
    //                   30: 346
    //                   31: 325;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L8 _L9 _L10 _L9 _L10
_L1:
        d1.a = new g((new StringBuilder("{")).append(d1.J).append(":").append(com.xxx.sdk.e.a.a.d.b.a(bytebuffer)).append("}").toString());
_L20:
        return d1.a;
_L7:
        d1.a = new g(bytebuffer.getInt());
        continue; /* Loop/switch isn't completed */
_L4:
        int j = bytebuffer.getInt();
        if(j >= 0)
            d1.a = new g(h1.e[j]);
        continue; /* Loop/switch isn't completed */
_L3:
        d1.a = new g(com.xxx.sdk.e.a.a.d.b.a(bytebuffer));
        continue; /* Loop/switch isn't completed */
_L8:
        boolean flag;
        if(bytebuffer.getInt() != 0)
            flag = true;
        else
            flag = false;
        d1.a = new g(flag);
        continue; /* Loop/switch isn't completed */
_L2:
        d1.a = new g("");
        continue; /* Loop/switch isn't completed */
_L10:
        d1.a = new g(b(bytebuffer, 6));
        continue; /* Loop/switch isn't completed */
_L9:
        d1.a = new g(b(bytebuffer, 8));
        continue; /* Loop/switch isn't completed */
_L5:
        short word0;
        long l;
        l = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        word0 = (short)(int)(255L & l);
        word0;
        JVM INSTR tableswitch 0 5: default 420
    //                   0 483
    //                   1 489
    //                   2 495
    //                   3 501
    //                   4 507
    //                   5 477;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L11:
        bytebuffer = (new StringBuilder("unknown unit:0x")).append(Integer.toHexString(word0)).toString();
_L18:
        d1.a = new g((new StringBuilder()).append(l >> 8).append(bytebuffer).toString());
        continue; /* Loop/switch isn't completed */
_L17:
        bytebuffer = "mm";
        continue; /* Loop/switch isn't completed */
_L12:
        bytebuffer = "px";
        continue; /* Loop/switch isn't completed */
_L13:
        bytebuffer = "dp";
        continue; /* Loop/switch isn't completed */
_L14:
        bytebuffer = "sp";
        continue; /* Loop/switch isn't completed */
_L15:
        bytebuffer = "pt";
        continue; /* Loop/switch isn't completed */
_L16:
        bytebuffer = "in";
        if(true) goto _L18; else goto _L6
_L6:
        l = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        short word1 = (short)(int)(15L & l);
        switch(word1)
        {
        default:
            bytebuffer = (new StringBuilder("unknown type:0x")).append(Integer.toHexString(word1)).toString();
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_620;
        }
_L21:
        float f1 = Float.intBitsToFloat((int)(l >> 4));
        d1.a = new g((new StringBuilder()).append(f1).append(bytebuffer).toString());
        if(true) goto _L20; else goto _L19
_L19:
        bytebuffer = "%";
          goto _L21
        bytebuffer = "%p";
          goto _L21
    }

    public static h a(ByteBuffer bytebuffer, i j)
    {
        long l3 = bytebuffer.position();
        long al[] = new long[(int)j.o];
        if(j.o > 0L)
        {
            for(int l = 0; (long)l < j.o; l++)
                al[l] = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);

        }
        long l2 = j.q;
        boolean flag;
        e ae[];
        if((j.q & 256L) != 0L)
            flag = true;
        else
            flag = false;
        l2 = (j.r + l3) - (long)((b) (j)).headerSize;
        bytebuffer.position((int)l2);
        ae = new e[al.length];
        for(int i1 = 0; i1 < al.length; i1++)
            ae[i1] = new e(i1, al[i1] + l2);

        String s = null;
        l2 = -1L;
        h h1 = new h((int)j.o);
        int k2 = ae.length;
        int j1 = 0;
        while(j1 < k2) 
        {
            e e1 = ae[j1];
            if(e1.offset == l2)
            {
                int k1 = e1.idx;
                h1.e[k1] = s;
            } else
            {
                bytebuffer.position((int)e1.offset);
                l2 = e1.offset;
                int l1;
                if(flag)
                {
                    b(bytebuffer);
                    s = new String(com.xxx.sdk.e.a.a.d.b.a(bytebuffer, b(bytebuffer)), a);
                    com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
                } else
                {
                    int j2 = bytebuffer.getShort() & 0xffff;
                    int i2 = j2;
                    if((0x8000 & j2) != 0)
                        i2 = ((j2 & 0x7fff) << 15 | 0) + (bytebuffer.getShort() & 0xffff);
                    s = com.xxx.sdk.e.a.a.d.b.a(bytebuffer, i2);
                    bytebuffer.getShort();
                }
                l1 = e1.idx;
                h1.e[l1] = s;
            }
            j1++;
        }
        l2 = j.p;
        bytebuffer.position((int)((long)j.o() + l3));
        return h1;
    }

    public static String a(long l, f f1, Locale locale)
    {
        int j;
        int j1;
        Object obj;
        Object obj1;
        m m1;
        Iterator iterator;
        if(l > 0x1030000L && l < 0x1031000L)
            return (new StringBuilder("@android:style/")).append((String)f.j.get(Integer.valueOf((int)l))).toString();
        obj = (new StringBuilder("resourceId:0x")).append(Long.toHexString(l)).toString();
        if(f1 == null)
            return ((String) (obj));
        short word0 = (short)(int)(l >> 24 & 255L);
        short word1 = (short)(int)(l >> 16 & 255L);
        j1 = (int)(65535L & l);
        obj1 = (com.xxx.sdk.e.a.a.d.a.e)f1.i.get(Short.valueOf(word0));
        if(obj1 == null)
            return ((String) (obj));
        m1 = (m)((com.xxx.sdk.e.a.a.d.a.e) (obj1)).g.get(Short.valueOf(word1));
        obj1 = (List)((com.xxx.sdk.e.a.a.d.a.e) (obj1)).h.get(Short.valueOf(word1));
        if(m1 == null || obj1 == null)
            return ((String) (obj));
        boolean flag;
        if(j1 < m1.b.length)
            flag = true;
        else
            flag = false;
        if(!flag)
            return ((String) (obj));
        j = -1;
        iterator = ((List) (obj1)).iterator();
        obj1 = null;
        obj = null;
_L3:
        int i1;
        com.xxx.sdk.e.a.a.d.a.c c1;
        k k1;
        do
        {
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_397;
            k1 = (k)iterator.next();
            c1 = k1.a(j1);
        } while(c1 == null || c1.b != null && c1.b.n == 0L && c1.b.value == null);
        obj1 = c1.key;
        i1 = com.xxx.sdk.e.a.a.a.e.a(locale, k1.locale);
        if(i1 != 2) goto _L2; else goto _L1
_L1:
        if(locale == null || c1 == null)
            return (new StringBuilder("@")).append(m1.name).append("/").append(((String) (obj1))).toString();
        else
            return c1.a(f1, locale);
_L2:
        if(i1 > j)
        {
            obj = c1;
            j = i1;
        }
          goto _L3
        c1 = ((com.xxx.sdk.e.a.a.d.a.c) (obj));
          goto _L1
    }

    public static String a(ByteBuffer bytebuffer)
    {
        bytebuffer = com.xxx.sdk.e.a.a.d.b.a(bytebuffer, 128);
        for(int j = 0; j < bytebuffer.length(); j++)
            if(bytebuffer.charAt(j) == 0)
                return bytebuffer.substring(0, j);

        return bytebuffer;
    }

    private static String a(ByteBuffer bytebuffer, boolean flag)
    {
        if(flag)
        {
            b(bytebuffer);
            String s = new String(com.xxx.sdk.e.a.a.d.b.a(bytebuffer, b(bytebuffer)), a);
            com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
            return s;
        }
        int l = bytebuffer.getShort() & 0xffff;
        int j = l;
        if((0x8000 & l) != 0)
            j = ((l & 0x7fff) << 15 | 0) + (bytebuffer.getShort() & 0xffff);
        String s1 = com.xxx.sdk.e.a.a.d.b.a(bytebuffer, j);
        bytebuffer.getShort();
        return s1;
    }

    private static int b(ByteBuffer bytebuffer)
    {
        short word0 = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        int j = word0;
        if((word0 & 0x80) != 0)
            j = ((word0 & 0x7f) << 7 | 0) + com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        return j;
    }

    private static String b(ByteBuffer bytebuffer)
    {
        short word0;
        long l;
        l = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        word0 = (short)(int)(255L & l);
        word0;
        JVM INSTR tableswitch 0 5: default 52
    //                   0 100
    //                   1 106
    //                   2 112
    //                   3 118
    //                   4 124
    //                   5 94;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        bytebuffer = (new StringBuilder("unknown unit:0x")).append(Integer.toHexString(word0)).toString();
_L9:
        return (new StringBuilder()).append(l >> 8).append(bytebuffer).toString();
_L7:
        bytebuffer = "mm";
        continue; /* Loop/switch isn't completed */
_L2:
        bytebuffer = "px";
        continue; /* Loop/switch isn't completed */
_L3:
        bytebuffer = "dp";
        continue; /* Loop/switch isn't completed */
_L4:
        bytebuffer = "sp";
        continue; /* Loop/switch isn't completed */
_L5:
        bytebuffer = "pt";
        continue; /* Loop/switch isn't completed */
_L6:
        bytebuffer = "in";
        if(true) goto _L9; else goto _L8
_L8:
    }

    private static String b(ByteBuffer bytebuffer, int j)
    {
        long l = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        bytebuffer = new StringBuilder();
        for(j = j / 2 - 1; j >= 0; j--)
            bytebuffer.append(Integer.toHexString((int)(l >> (j << 3) & 255L)));

        return bytebuffer.toString();
    }

    private static int c(ByteBuffer bytebuffer)
    {
        int l = bytebuffer.getShort() & 0xffff;
        int j = l;
        if((0x8000 & l) != 0)
            j = ((l & 0x7fff) << 15 | 0) + (bytebuffer.getShort() & 0xffff);
        return j;
    }

    private static String c(ByteBuffer bytebuffer)
    {
        short word0;
        long l;
        l = com.xxx.sdk.e.a.a.d.b.a(bytebuffer);
        word0 = (short)(int)(15L & l);
        word0;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 83
    //                   1 89;
           goto _L1 _L2 _L3
_L1:
        bytebuffer = (new StringBuilder("unknown type:0x")).append(Integer.toHexString(word0)).toString();
_L5:
        float f1 = Float.intBitsToFloat((int)(l >> 4));
        return (new StringBuilder()).append(f1).append(bytebuffer).toString();
_L2:
        bytebuffer = "%";
        continue; /* Loop/switch isn't completed */
_L3:
        bytebuffer = "%p";
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static void u(int j)
    {
        if(1 != j)
            throw new a((new StringBuilder("Expect chunk type:")).append(Integer.toHexString(1)).append(", but got:").append(Integer.toHexString(j)).toString());
        else
            return;
    }

    private static Charset a = Charset.forName("UTF-8");

}
