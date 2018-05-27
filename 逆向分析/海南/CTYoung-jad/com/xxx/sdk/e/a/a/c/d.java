// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.c;

import com.xxx.sdk.e.a.a.d.a.a;
import com.xxx.sdk.e.a.a.d.a.b;
import com.xxx.sdk.e.a.a.d.a.e;
import com.xxx.sdk.e.a.a.d.a.f;
import com.xxx.sdk.e.a.a.d.a.g;
import com.xxx.sdk.e.a.a.d.a.k;
import com.xxx.sdk.e.a.a.d.a.l;
import com.xxx.sdk.e.a.a.d.a.m;
import com.xxx.sdk.e.a.a.d.a.n;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.e.a.a.d.i;
import com.xxx.sdk.e.a.a.e.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{

    public d()
    {
    }

    public d(ByteBuffer bytebuffer)
    {
        byteOrder = ByteOrder.LITTLE_ENDIAN;
        a_java_nio_ByteBuffer_fld = bytebuffer.duplicate();
        a_java_nio_ByteBuffer_fld.order(byteOrder);
        a_java_util_Set_fld = new HashSet();
    }

    private b a()
    {
        long l1 = a_java_nio_ByteBuffer_fld.position();
        b b1 = new b();
        long l2 = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
        com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, 4);
        b1.bK = (new String(com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, 2))).replace("\0", "");
        b1.bL = (new String(com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, 2))).replace("\0", "");
        long l3 = a_java_nio_ByteBuffer_fld.position();
        com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, (int)(l2 - (l3 - l1)));
        return b1;
    }

    private f a()
    {
        return a_com_xxx_sdk_e_a_a_d_a_f_fld;
    }

    private com.xxx.sdk.e.a.a.e.b a(a a1)
    {
        com.xxx.sdk.e.a.a.e.b b1 = new com.xxx.sdk.e.a.a.e.b();
        e e1 = new e(a1);
        b1.b = e1;
        long l1 = a_java_nio_ByteBuffer_fld.position();
        if(a1.t > 0L)
        {
            a_java_nio_ByteBuffer_fld.position((int)((a1.t + l1) - (long)((com.xxx.sdk.e.a.a.d.b) (a1)).headerSize));
            e1.b = c.a(a_java_nio_ByteBuffer_fld, (i)a());
        }
        if(a1.v > 0L)
        {
            a_java_nio_ByteBuffer_fld.position((int)((l1 + a1.v) - (long)((com.xxx.sdk.e.a.a.d.b) (a1)).headerSize));
            e1.c = c.a(a_java_nio_ByteBuffer_fld, (i)a());
        }
label0:
        do
        {
            if(!a_java_nio_ByteBuffer_fld.hasRemaining())
                break;
            a1 = a();
            switch(((com.xxx.sdk.e.a.a.d.b) (a1)).bu)
            {
            default:
                throw new com.xxx.sdk.e.a.a.b.a((new StringBuilder("unexpected chunk type:")).append(((com.xxx.sdk.e.a.a.d.b) (a1)).bu).toString());

            case 514: 
                long l2 = a_java_nio_ByteBuffer_fld.position();
                a1 = (n)a1;
                long al[] = new long[(int)((n) (a1)).B];
                for(int j = 0; (long)j < ((n) (a1)).B; j++)
                    al[j] = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);

                m m1 = new m(a1);
                m1.b = al;
                h h1 = e1.b;
                short word0 = ((n) (a1)).W;
                m1.name = h1.e[word0 - 1];
                e1.g.put(Short.valueOf(m1.W), m1);
                a_java_nio_ByteBuffer_fld.position((int)(l2 + (long)a1.o()));
                break;

            case 513: 
                long l3 = a_java_nio_ByteBuffer_fld.position();
                l l6 = (l)a1;
                a1 = new long[(int)l6.B];
                for(int i1 = 0; (long)i1 < l6.B; i1++)
                    a1[i1] = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);

                k k1 = new k(l6);
                Object obj = e1.b;
                short word1 = l6.W;
                k1.name = ((h) (obj)).e[word1 - 1];
                long l4 = l6.C;
                long l5 = ((com.xxx.sdk.e.a.a.d.b) (l6)).headerSize;
                a_java_nio_ByteBuffer_fld.position((int)((l4 + l3) - l5));
                obj = a_java_nio_ByteBuffer_fld.slice();
                ((ByteBuffer) (obj)).order(byteOrder);
                k1.a_java_nio_ByteBuffer_fld = ((ByteBuffer) (obj));
                k1.c = e1.c;
                k1.a_long_array1d_fld = a1;
                k1.a_com_xxx_sdk_e_a_a_d_h_fld = a_com_xxx_sdk_e_a_a_d_h_fld;
                obj = (List)e1.h.get(Short.valueOf(k1.W));
                a1 = ((a) (obj));
                if(obj == null)
                {
                    a1 = new ArrayList();
                    e1.h.put(Short.valueOf(k1.W), a1);
                }
                a1.add(k1);
                a_java_util_Set_fld.add(k1.locale);
                a_java_nio_ByteBuffer_fld.position((int)(l3 + (long)l6.o()));
                break;

            case 512: 
                b1.c = (a)a1;
                break label0;
            }
        } while(true);
        return b1;
    }

    private Set a()
    {
        return a_java_util_Set_fld;
    }

    private void parse()
    {
        g g1 = (g)a();
        a_com_xxx_sdk_e_a_a_d_h_fld = c.a(a_java_nio_ByteBuffer_fld, (i)a());
        a_com_xxx_sdk_e_a_a_d_a_f_fld = new f();
        a_com_xxx_sdk_e_a_a_d_a_f_fld.a = a_com_xxx_sdk_e_a_a_d_h_fld;
        Object obj = (a)a();
        for(int j = 0; (long)j < g1.y; j++)
        {
            com.xxx.sdk.e.a.a.e.b b1 = new com.xxx.sdk.e.a.a.e.b();
            e e2 = new e(((a) (obj)));
            b1.b = e2;
            long l1 = a_java_nio_ByteBuffer_fld.position();
            if(((a) (obj)).t > 0L)
            {
                a_java_nio_ByteBuffer_fld.position((int)((((a) (obj)).t + l1) - (long)((com.xxx.sdk.e.a.a.d.b) (obj)).headerSize));
                e2.b = c.a(a_java_nio_ByteBuffer_fld, (i)a());
            }
            if(((a) (obj)).v > 0L)
            {
                a_java_nio_ByteBuffer_fld.position((int)((l1 + ((a) (obj)).v) - (long)((com.xxx.sdk.e.a.a.d.b) (obj)).headerSize));
                e2.c = c.a(a_java_nio_ByteBuffer_fld, (i)a());
            }
label0:
            do
            {
                if(!a_java_nio_ByteBuffer_fld.hasRemaining())
                    break;
                obj = a();
                switch(((com.xxx.sdk.e.a.a.d.b) (obj)).bu)
                {
                default:
                    throw new com.xxx.sdk.e.a.a.b.a((new StringBuilder("unexpected chunk type:")).append(((com.xxx.sdk.e.a.a.d.b) (obj)).bu).toString());

                case 514: 
                    long l2 = a_java_nio_ByteBuffer_fld.position();
                    obj = (n)obj;
                    long al[] = new long[(int)((n) (obj)).B];
                    for(int i1 = 0; (long)i1 < ((n) (obj)).B; i1++)
                        al[i1] = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);

                    m m1 = new m(((n) (obj)));
                    m1.b = al;
                    h h1 = e2.b;
                    short word0 = ((n) (obj)).W;
                    m1.name = h1.e[word0 - 1];
                    e2.g.put(Short.valueOf(m1.W), m1);
                    a_java_nio_ByteBuffer_fld.position((int)(l2 + (long)((n) (obj)).o()));
                    break;

                case 513: 
                    long l3 = a_java_nio_ByteBuffer_fld.position();
                    l l6 = (l)obj;
                    obj = new long[(int)l6.B];
                    for(int j1 = 0; (long)j1 < l6.B; j1++)
                        obj[j1] = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);

                    k k1 = new k(l6);
                    Object obj1 = e2.b;
                    short word1 = l6.W;
                    k1.name = ((h) (obj1)).e[word1 - 1];
                    long l4 = l6.C;
                    long l5 = ((com.xxx.sdk.e.a.a.d.b) (l6)).headerSize;
                    a_java_nio_ByteBuffer_fld.position((int)((l4 + l3) - l5));
                    obj1 = a_java_nio_ByteBuffer_fld.slice();
                    ((ByteBuffer) (obj1)).order(byteOrder);
                    k1.a_java_nio_ByteBuffer_fld = ((ByteBuffer) (obj1));
                    k1.c = e2.c;
                    k1.a_long_array1d_fld = ((long []) (obj));
                    k1.a_com_xxx_sdk_e_a_a_d_h_fld = a_com_xxx_sdk_e_a_a_d_h_fld;
                    obj1 = (List)e2.h.get(Short.valueOf(k1.W));
                    obj = obj1;
                    if(obj1 == null)
                    {
                        obj = new ArrayList();
                        e2.h.put(Short.valueOf(k1.W), obj);
                    }
                    ((List) (obj)).add(k1);
                    a_java_util_Set_fld.add(k1.locale);
                    a_java_nio_ByteBuffer_fld.position((int)(l3 + (long)l6.o()));
                    break;

                case 512: 
                    b1.c = (a)obj;
                    break label0;
                }
            } while(true);
            obj = a_com_xxx_sdk_e_a_a_d_a_f_fld;
            e e1 = (e)b1.b;
            ((f) (obj)).i.put(Short.valueOf(e1.W), e1);
            obj = (a)b1.c;
        }

    }

    public final com.xxx.sdk.e.a.a.d.b a()
    {
        long l1 = a_java_nio_ByteBuffer_fld.position();
        int j = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        int i1 = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        long l2 = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
        switch(j)
        {
        default:
            throw new com.xxx.sdk.e.a.a.b.a((new StringBuilder("Unexpected chunk Type:")).append(Integer.toHexString(j)).toString());

        case 2: // '\002'
            g g1 = new g(j, i1, l2);
            g1.y = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return g1;

        case 1: // '\001'
            i j1 = new i(j, i1, l2);
            j1.o = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            j1.p = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            j1.q = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            j1.r = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            j1.s = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return j1;

        case 512: 
            a a1 = new a(j, i1, l2);
            a1.id = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a1.name = c.a(a_java_nio_ByteBuffer_fld);
            a1.t = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a1.u = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a1.v = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a1.w = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return a1;

        case 514: 
            n n1 = new n(j, i1, l2);
            n1.W = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            n1.I = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            n1.bD = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
            n1.B = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return n1;

        case 513: 
            l l5 = new l(j, i1, l2);
            l5.W = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            l5.I = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            l5.bD = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
            l5.B = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            l5.C = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            l2 = a_java_nio_ByteBuffer_fld.position();
            b b1 = new b();
            long l3 = com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld);
            com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, 4);
            b1.bK = (new String(com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, 2))).replace("\0", "");
            b1.bL = (new String(com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, 2))).replace("\0", "");
            long l4 = a_java_nio_ByteBuffer_fld.position();
            com.xxx.sdk.e.a.a.d.b.a(a_java_nio_ByteBuffer_fld, (int)(l3 - (l4 - l2)));
            l5.a = b1;
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return l5;
        }
    }

    private static int ANY = 65535;
    private static int BOOLEAN = 8;
    private static int COLOR = 16;
    private static int FLOAT = 32;
    private static int INTEGER = 4;
    private static int bf = 1;
    private static int bg = 2;
    private static int bh = 64;
    private static int bi = 128;
    private static int bj = 0x10000;
    private static int bk = 0x20000;
    public f a_com_xxx_sdk_e_a_a_d_a_f_fld;
    public h a_com_xxx_sdk_e_a_a_d_h_fld;
    public ByteBuffer a_java_nio_ByteBuffer_fld;
    public Set a_java_util_Set_fld;
    public ByteOrder byteOrder;
}
