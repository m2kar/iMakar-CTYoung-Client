// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a;

import com.xxx.sdk.e.a.a.c.c;
import com.xxx.sdk.e.a.a.c.d;
import com.xxx.sdk.e.a.a.c.i;
import com.xxx.sdk.e.a.a.c.j;
import com.xxx.sdk.e.a.a.d.a.e;
import com.xxx.sdk.e.a.a.d.a.f;
import com.xxx.sdk.e.a.a.d.a.g;
import com.xxx.sdk.e.a.a.d.a.k;
import com.xxx.sdk.e.a.a.d.a.l;
import com.xxx.sdk.e.a.a.d.a.m;
import com.xxx.sdk.e.a.a.d.a.n;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.e.a.a.e.b;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipFile;

public final class a
    implements Closeable
{

    public a(File file)
    {
        a_java_util_Locale_fld = DEFAULT_LOCALE;
        a_java_util_zip_ZipFile_fld = new ZipFile(file);
    }

    public a(String s)
    {
        this(new File(s));
    }

    private void V()
    {
        if(bE == null)
            W();
    }

    private void W()
    {
        j j1 = new j();
        com.xxx.sdk.e.a.a.c.a a1 = new com.xxx.sdk.e.a.a.c.a();
        a("AndroidManifest.xml", new c(new i[] {
            j1, a1
        }));
        bE = j1.a.toString();
        if(bE == null)
        {
            throw new com.xxx.sdk.e.a.a.b.a("manifest xml not exists");
        } else
        {
            a_com_xxx_sdk_e_a_a_a_a_fld = a1.a;
            return;
        }
    }

    private void X()
    {
        Object obj = a_java_util_zip_ZipFile_fld.getEntry("resources.arsc");
        if(obj == null)
        {
            a_com_xxx_sdk_e_a_a_d_a_f_fld = new f();
            a_java_util_Set_fld = Collections.emptySet();
            return;
        }
        a_com_xxx_sdk_e_a_a_d_a_f_fld = new f();
        a_java_util_Set_fld = Collections.emptySet();
        d d1 = new d(ByteBuffer.wrap(h.a(a_java_util_zip_ZipFile_fld.getInputStream(((java.util.zip.ZipEntry) (obj))))));
        g g1 = (g)d1.a();
        d1.a_com_xxx_sdk_e_a_a_d_h_fld = com.xxx.sdk.e.a.a.e.c.a(d1.a_java_nio_ByteBuffer_fld, (com.xxx.sdk.e.a.a.d.i)d1.a());
        d1.a_com_xxx_sdk_e_a_a_d_a_f_fld = new f();
        d1.a_com_xxx_sdk_e_a_a_d_a_f_fld.a = d1.a_com_xxx_sdk_e_a_a_d_h_fld;
        obj = (com.xxx.sdk.e.a.a.d.a.a)d1.a();
        for(int i1 = 0; (long)i1 < g1.y; i1++)
        {
            b b1 = new b();
            e e2 = new e(((com.xxx.sdk.e.a.a.d.a.a) (obj)));
            b1.b = e2;
            long l1 = d1.a_java_nio_ByteBuffer_fld.position();
            if(((com.xxx.sdk.e.a.a.d.a.a) (obj)).t > 0L)
            {
                d1.a_java_nio_ByteBuffer_fld.position((int)((((com.xxx.sdk.e.a.a.d.a.a) (obj)).t + l1) - (long)((com.xxx.sdk.e.a.a.d.b) (obj)).headerSize));
                e2.b = com.xxx.sdk.e.a.a.e.c.a(d1.a_java_nio_ByteBuffer_fld, (com.xxx.sdk.e.a.a.d.i)d1.a());
            }
            if(((com.xxx.sdk.e.a.a.d.a.a) (obj)).v > 0L)
            {
                d1.a_java_nio_ByteBuffer_fld.position((int)((l1 + ((com.xxx.sdk.e.a.a.d.a.a) (obj)).v) - (long)((com.xxx.sdk.e.a.a.d.b) (obj)).headerSize));
                e2.c = com.xxx.sdk.e.a.a.e.c.a(d1.a_java_nio_ByteBuffer_fld, (com.xxx.sdk.e.a.a.d.i)d1.a());
            }
label0:
            do
            {
                if(!d1.a_java_nio_ByteBuffer_fld.hasRemaining())
                    break;
                obj = d1.a();
                switch(((com.xxx.sdk.e.a.a.d.b) (obj)).bu)
                {
                default:
                    throw new com.xxx.sdk.e.a.a.b.a((new StringBuilder("unexpected chunk type:")).append(((com.xxx.sdk.e.a.a.d.b) (obj)).bu).toString());

                case 514: 
                    long l2 = d1.a_java_nio_ByteBuffer_fld.position();
                    obj = (n)obj;
                    long al[] = new long[(int)((n) (obj)).B];
                    for(int j1 = 0; (long)j1 < ((n) (obj)).B; j1++)
                        al[j1] = com.xxx.sdk.e.a.a.d.b.a(d1.a_java_nio_ByteBuffer_fld);

                    m m1 = new m(((n) (obj)));
                    m1.b = al;
                    h h1 = e2.b;
                    short word0 = ((n) (obj)).W;
                    m1.name = h1.e[word0 - 1];
                    e2.g.put(Short.valueOf(m1.W), m1);
                    d1.a_java_nio_ByteBuffer_fld.position((int)(l2 + (long)((n) (obj)).o()));
                    break;

                case 513: 
                    long l3 = d1.a_java_nio_ByteBuffer_fld.position();
                    l l6 = (l)obj;
                    obj = new long[(int)l6.B];
                    for(int k1 = 0; (long)k1 < l6.B; k1++)
                        obj[k1] = com.xxx.sdk.e.a.a.d.b.a(d1.a_java_nio_ByteBuffer_fld);

                    k k2 = new k(l6);
                    Object obj1 = e2.b;
                    short word1 = l6.W;
                    k2.name = ((h) (obj1)).e[word1 - 1];
                    long l4 = l6.C;
                    long l5 = ((com.xxx.sdk.e.a.a.d.b) (l6)).headerSize;
                    d1.a_java_nio_ByteBuffer_fld.position((int)((l4 + l3) - l5));
                    obj1 = d1.a_java_nio_ByteBuffer_fld.slice();
                    ((ByteBuffer) (obj1)).order(d1.byteOrder);
                    k2.a_java_nio_ByteBuffer_fld = ((ByteBuffer) (obj1));
                    k2.c = e2.c;
                    k2.a_long_array1d_fld = ((long []) (obj));
                    k2.a_com_xxx_sdk_e_a_a_d_h_fld = d1.a_com_xxx_sdk_e_a_a_d_h_fld;
                    obj1 = (List)e2.h.get(Short.valueOf(k2.W));
                    obj = obj1;
                    if(obj1 == null)
                    {
                        obj = new ArrayList();
                        e2.h.put(Short.valueOf(k2.W), obj);
                    }
                    ((List) (obj)).add(k2);
                    d1.a_java_util_Set_fld.add(k2.locale);
                    d1.a_java_nio_ByteBuffer_fld.position((int)(l3 + (long)l6.o()));
                    break;

                case 512: 
                    b1.c = (com.xxx.sdk.e.a.a.d.a.a)obj;
                    break label0;
                }
            } while(true);
            obj = d1.a_com_xxx_sdk_e_a_a_d_a_f_fld;
            e e1 = (e)b1.b;
            ((f) (obj)).i.put(Short.valueOf(e1.W), e1);
            obj = (com.xxx.sdk.e.a.a.d.a.a)b1.c;
        }

        a_com_xxx_sdk_e_a_a_d_a_f_fld = d1.a_com_xxx_sdk_e_a_a_d_a_f_fld;
        a_java_util_Set_fld = d1.a_java_util_Set_fld;
    }

    private com.xxx.sdk.e.a.a.a.d a()
    {
        byte abyte0[] = null;
        String s = a().icon;
        if(s == null)
            return null;
        java.util.zip.ZipEntry zipentry = a_java_util_zip_ZipFile_fld.getEntry(s);
        if(zipentry != null)
            abyte0 = h.a(a_java_util_zip_ZipFile_fld.getInputStream(zipentry));
        return new com.xxx.sdk.e.a.a.a.d(s, abyte0);
    }

    private Locale a()
    {
        return a_java_util_Locale_fld;
    }

    private Set a()
    {
        if(a_java_util_Set_fld == null)
            X();
        return a_java_util_Set_fld;
    }

    private void a(String s, i i1)
    {
        s = a_java_util_zip_ZipFile_fld.getEntry(s);
        if(s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.xxx.sdk.e.a.a.c.b b1;
        if(a_com_xxx_sdk_e_a_a_d_a_f_fld == null)
            X();
        b1 = new com.xxx.sdk.e.a.a.c.b(ByteBuffer.wrap(h.a(a_java_util_zip_ZipFile_fld.getInputStream(s))), a_com_xxx_sdk_e_a_a_d_a_f_fld);
        s = a_java_util_Locale_fld;
        if(s != null)
            b1.locale = s;
        b1.a_com_xxx_sdk_e_a_a_c_i_fld = i1;
        s = b1.a();
        if(s == null || ((com.xxx.sdk.e.a.a.d.b) (s)).bu != 3) goto _L1; else goto _L3
_L3:
        s = b1.a();
        if(s == null) goto _L1; else goto _L4
_L4:
        com.xxx.sdk.e.a.a.e.c.u(((com.xxx.sdk.e.a.a.d.b) (s)).bu);
        b1.a_com_xxx_sdk_e_a_a_d_h_fld = com.xxx.sdk.e.a.a.e.c.a(b1.a_java_nio_ByteBuffer_fld, (com.xxx.sdk.e.a.a.d.i)s);
        i1 = b1.a();
        if(i1 == null) goto _L1; else goto _L5
_L5:
        s = i1;
        if(((com.xxx.sdk.e.a.a.d.b) (i1)).bu != 384)
            continue; /* Loop/switch isn't completed */
        int l2 = ((com.xxx.sdk.e.a.a.d.b.k)i1).o() / 4;
        s = new long[l2];
        for(int j1 = 0; j1 < l2; j1++)
            s[j1] = com.xxx.sdk.e.a.a.d.b.a(b1.a_java_nio_ByteBuffer_fld);

        b1.d = new String[s.length];
        for(int k1 = 0; k1 < s.length; k1++)
            b1.d[k1] = com.xxx.sdk.e.a.a.d.b.b.a(s[k1]);

          goto _L6
_L10:
        int l1 = b1.a_java_nio_ByteBuffer_fld.getInt();
        int i3 = b1.a_java_nio_ByteBuffer_fld.getInt();
        i1 = new com.xxx.sdk.e.a.a.d.b.f();
        if(l1 > 0)
            i1.prefix = b1.a_com_xxx_sdk_e_a_a_d_h_fld.e[l1];
        if(i3 > 0)
            i1.uri = b1.a_com_xxx_sdk_e_a_a_d_h_fld.e[i3];
        b1.a_com_xxx_sdk_e_a_a_c_i_fld.a(i1);
_L14:
        long l3;
        b1.a_java_nio_ByteBuffer_fld.position((int)(l3 + (long)s.o()));
_L6:
        s = b1.a();
        if(s == null) goto _L1; else goto _L7
_L7:
        l3 = b1.a_java_nio_ByteBuffer_fld.position();
        ((com.xxx.sdk.e.a.a.d.b) (s)).bu;
        JVM INSTR tableswitch 256 260: default 380
    //                   256 415
    //                   257 227
    //                   258 494
    //                   259 503
    //                   260 585;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        int i2;
        int j3;
        if(((com.xxx.sdk.e.a.a.d.b) (s)).bu >= 256 && ((com.xxx.sdk.e.a.a.d.b) (s)).bu <= 383)
            com.xxx.sdk.e.a.a.d.b.a(b1.a_java_nio_ByteBuffer_fld, s.o());
        else
            throw new com.xxx.sdk.e.a.a.b.a((new StringBuilder("Unexpected chunk type:")).append(((com.xxx.sdk.e.a.a.d.b) (s)).bu).toString());
          goto _L14
_L9:
        i2 = b1.a_java_nio_ByteBuffer_fld.getInt();
        j3 = b1.a_java_nio_ByteBuffer_fld.getInt();
        i1 = new com.xxx.sdk.e.a.a.d.b.g();
        if(i2 > 0)
            i1.prefix = b1.a_com_xxx_sdk_e_a_a_d_h_fld.e[i2];
        if(j3 > 0)
            i1.uri = b1.a_com_xxx_sdk_e_a_a_d_h_fld.e[j3];
        b1.a_com_xxx_sdk_e_a_a_c_i_fld.a(i1);
          goto _L14
_L11:
        b1.a();
          goto _L14
_L12:
        i1 = new com.xxx.sdk.e.a.a.d.b.h();
        int j2 = b1.a_java_nio_ByteBuffer_fld.getInt();
        int k3 = b1.a_java_nio_ByteBuffer_fld.getInt();
        if(j2 > 0)
            i1.bP = b1.a_com_xxx_sdk_e_a_a_d_h_fld.e[j2];
        i1.name = b1.a_com_xxx_sdk_e_a_a_d_h_fld.e[k3];
        if(b1.a_com_xxx_sdk_e_a_a_c_i_fld != null)
            b1.a_com_xxx_sdk_e_a_a_c_i_fld.a(i1);
          goto _L14
_L13:
        i1 = new com.xxx.sdk.e.a.a.d.b.d();
        int k2 = b1.a_java_nio_ByteBuffer_fld.getInt();
        if(k2 > 0)
            i1.data = b1.a_com_xxx_sdk_e_a_a_d_h_fld.e[k2];
        i1.e = com.xxx.sdk.e.a.a.e.c.a(b1.a_java_nio_ByteBuffer_fld, b1.a_com_xxx_sdk_e_a_a_d_h_fld);
        i1 = b1.a_com_xxx_sdk_e_a_a_c_i_fld;
          goto _L14
    }

    private void a(Locale locale)
    {
        if(!com.xxx.sdk.e.b.equals(a_java_util_Locale_fld, locale))
        {
            a_java_util_Locale_fld = locale;
            bE = null;
            a_com_xxx_sdk_e_a_a_a_a_fld = null;
        }
    }

    private byte[] a(String s)
    {
        s = a_java_util_zip_ZipFile_fld.getEntry(s);
        if(s == null)
            return null;
        else
            return h.a(a_java_util_zip_ZipFile_fld.getInputStream(s));
    }

    private String g(String s)
    {
        if(a_java_util_zip_ZipFile_fld.getEntry(s) == null)
            return null;
        if(a_com_xxx_sdk_e_a_a_d_a_f_fld == null)
            X();
        j j1 = new j();
        a(s, j1);
        return j1.a.toString();
    }

    private String o()
    {
        if(bE == null)
            W();
        return bE;
    }

    public final com.xxx.sdk.e.a.a.a.a a()
    {
        if(a_com_xxx_sdk_e_a_a_a_a_fld == null && bE == null)
            W();
        return a_com_xxx_sdk_e_a_a_a_a_fld;
    }

    public final void close()
    {
        a_com_xxx_sdk_e_a_a_d_a_f_fld = null;
        a_java_util_zip_ZipFile_fld.close();
    }

    private static final Locale DEFAULT_LOCALE;
    private com.xxx.sdk.e.a.a.a.a a_com_xxx_sdk_e_a_a_a_a_fld;
    private f a_com_xxx_sdk_e_a_a_d_a_f_fld;
    private Locale a_java_util_Locale_fld;
    private Set a_java_util_Set_fld;
    public final ZipFile a_java_util_zip_ZipFile_fld;
    private String bE;
    private File d;

    static 
    {
        DEFAULT_LOCALE = Locale.US;
    }
}
