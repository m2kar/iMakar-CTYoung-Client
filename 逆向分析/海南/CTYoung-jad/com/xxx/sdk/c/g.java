// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import android.content.Context;
import com.xxx.sdk.a.d;
import com.xxx.sdk.a.i;
import com.xxx.sdk.a.j;
import com.xxx.sdk.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.f.e;
import com.xxx.sdk.k;
import com.xxx.sdk.m;
import com.xxx.sdk.p;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.sdk.c:
//            h, i

public final class g extends k
{

    public g()
    {
        l = new AtomicBoolean(false);
        a_com_xxx_sdk_b_fld = null;
        a_com_xxx_sdk_a_g_fld = null;
        a_com_xxx_sdk_a_i_fld = null;
        b = null;
        c = null;
        k = 0L;
    }

    private void O()
    {
        m.a().execute(new h(this));
    }

    private void P()
    {
        if(System.currentTimeMillis() - k - 60000L > 0L)
            m.a().execute(new h(this));
    }

    private void Q()
    {
        if(!com.xxx.sdk.e.b.f(a_com_xxx_sdk_b_fld.a().R))
        {
            boolean flag;
            long l1;
            long l2;
            long l3;
            long l4;
            long l5;
            Calendar calendar;
            if(com.xxx.sdk.e.b.f(c.value))
            {
                l1 = (long)(Math.random() * 5D * 60D) * 60000L;
                c.value = String.valueOf(l1);
                a_com_xxx_sdk_a_i_fld.a(c);
            } else
            {
                l1 = Long.valueOf(c.value).longValue();
            }
            l2 = 0L;
            if(!com.xxx.sdk.e.b.f(b.value))
                l2 = Long.valueOf(b.value).longValue();
            calendar = Calendar.getInstance();
            calendar.set(11, 1);
            calendar.set(12, 0);
            calendar.set(13, 0);
            l3 = calendar.getTimeInMillis();
            calendar.set(11, 6);
            l4 = calendar.getTimeInMillis();
            l5 = System.currentTimeMillis();
            if(l5 - l2 >= 0x5265c00L && l5 >= l3 && l5 <= l4 && l5 - l3 >= l1)
                flag = true;
            else
                flag = false;
            if(flag)
            {
                m.a().execute(new com.xxx.sdk.c.i(this, l2));
                return;
            }
        }
    }

    private static boolean a(long l1, long l2)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 1);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long l3 = calendar.getTimeInMillis();
        calendar.set(11, 6);
        long l4 = calendar.getTimeInMillis();
        long l5 = System.currentTimeMillis();
        return l5 - l1 >= 0x5265c00L && l5 >= l3 && l5 <= l4 && l5 - l3 >= l2;
    }

    private void b(long l1)
    {
        m.a().execute(new com.xxx.sdk.c.i(this, l1));
    }

    private static void cleanup()
    {
        if(com.xxx.sdk.e.e.a.r() < 100L)
        {
            com.xxx.sdk.e.c.warn("SD\u5361\u7A7A\u95F4\u4E0D\u8DB3100M\uFF0C\u5F00\u59CB\u6E05\u7406\u7CFB\u7EDF\u5783\u573E");
            com.xxx.sdk.e.e.a.r();
        }
    }

    private boolean f()
    {
        if(l.getAndSet(true))
        {
            return true;
        } else
        {
            a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
            Context context = a_com_xxx_sdk_b_fld.getContext();
            a_com_xxx_sdk_a_g_fld = new com.xxx.sdk.a.g(context);
            a_com_xxx_sdk_a_i_fld = new i(context);
            b = a_com_xxx_sdk_a_i_fld.a("collect_lasttime");
            c = a_com_xxx_sdk_a_i_fld.a("collect_fixedtime");
            return true;
        }
    }

    private void g(String s)
    {
        if(!l.getAndSet(true))
        {
            a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
            Context context = a_com_xxx_sdk_b_fld.getContext();
            a_com_xxx_sdk_a_g_fld = new com.xxx.sdk.a.g(context);
            a_com_xxx_sdk_a_i_fld = new i(context);
            b = a_com_xxx_sdk_a_i_fld.a("collect_lasttime");
            c = a_com_xxx_sdk_a_i_fld.a("collect_fixedtime");
        }
        Context context1 = a_com_xxx_sdk_b_fld.getContext();
        if(!com.xxx.sdk.e.e.a.a(context1, s) && (bc == null || !bc.equals(s)))
        {
            bc = s;
            if(!context1.getPackageName().equals(s))
            {
                s = a_com_xxx_sdk_b_fld.a(s);
                if(s != null && ((e) (s)).state == 2 && System.currentTimeMillis() / 0x5265c00L > ((e) (s)).updated / 0x5265c00L && System.currentTimeMillis() / 0x5265c00L > ((e) (s)).lastReactivated / 0x5265c00L && (((e) (s)).reactivateExpires / 0x5265c00L == 0L || ((e) (s)).lastReactivated / 0x5265c00L - ((e) (s)).updated / 0x5265c00L <= ((e) (s)).reactivateExpires / 0x5265c00L))
                    s.d(null);
            }
        }
    }

    private void h(String s)
    {
        if(!l.getAndSet(true))
        {
            a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
            Context context = a_com_xxx_sdk_b_fld.getContext();
            a_com_xxx_sdk_a_g_fld = new com.xxx.sdk.a.g(context);
            a_com_xxx_sdk_a_i_fld = new i(context);
            b = a_com_xxx_sdk_a_i_fld.a("collect_lasttime");
            c = a_com_xxx_sdk_a_i_fld.a("collect_fixedtime");
        }
        Context context1 = a_com_xxx_sdk_b_fld.getContext();
        if(com.xxx.sdk.e.e.a.a(context1, s) || bc != null && bc.equals(s))
            break MISSING_BLOCK_LABEL_235;
        bc = s;
        if(context1.getPackageName().equals(s))
            break MISSING_BLOCK_LABEL_235;
        s = a_com_xxx_sdk_b_fld.a(s);
        if(s == null)
            break MISSING_BLOCK_LABEL_235;
        if(((e) (s)).state == 2 && System.currentTimeMillis() / 0x5265c00L > ((e) (s)).updated / 0x5265c00L && System.currentTimeMillis() / 0x5265c00L > ((e) (s)).lastReactivated / 0x5265c00L && (((e) (s)).reactivateExpires / 0x5265c00L == 0L || ((e) (s)).lastReactivated / 0x5265c00L - ((e) (s)).updated / 0x5265c00L <= ((e) (s)).reactivateExpires / 0x5265c00L))
            s.d(null);
        if(!com.xxx.sdk.e.e.a.f(a_com_xxx_sdk_b_fld.getContext())) goto _L2; else goto _L1
_L1:
        if(com.xxx.sdk.e.b.f(a_com_xxx_sdk_b_fld.a().R)) goto _L4; else goto _L3
_L3:
        if(!com.xxx.sdk.e.b.f(c.value)) goto _L6; else goto _L5
_L5:
        long l1;
        l1 = (long)(Math.random() * 5D * 60D) * 60000L;
        c.value = String.valueOf(l1);
        a_com_xxx_sdk_a_i_fld.a(c);
_L13:
        if(com.xxx.sdk.e.b.f(b.value)) goto _L8; else goto _L7
_L7:
        long l2 = Long.valueOf(b.value).longValue();
_L11:
        long l3;
        long l4;
        long l5;
        s = Calendar.getInstance();
        s.set(11, 1);
        s.set(12, 0);
        s.set(13, 0);
        l3 = s.getTimeInMillis();
        s.set(11, 6);
        l4 = s.getTimeInMillis();
        l5 = System.currentTimeMillis();
        boolean flag;
        if(l5 - l2 >= 0x5265c00L && l5 >= l3 && l5 <= l4 && l5 - l3 >= l1)
            flag = true;
        else
            flag = false;
        if(!flag) goto _L4; else goto _L9
_L9:
        m.a().execute(new com.xxx.sdk.c.i(this, l2));
_L4:
        if(System.currentTimeMillis() - k - 60000L > 0L)
            m.a().execute(new h(this));
_L2:
        if(com.xxx.sdk.e.e.a.r() < 100L)
        {
            com.xxx.sdk.e.c.warn("SD\u5361\u7A7A\u95F4\u4E0D\u8DB3100M\uFF0C\u5F00\u59CB\u6E05\u7406\u7CFB\u7EDF\u5783\u573E");
            com.xxx.sdk.e.e.a.r();
            return;
        }
          goto _L10
_L6:
        try
        {
            l1 = Long.valueOf(c.value).longValue();
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            com.xxx.sdk.e.c.error("\u672A\u77E5\u9519\u8BEF\uFF01", s);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        l2 = 0L;
          goto _L11
_L10:
        return;
        if(true) goto _L13; else goto _L12
_L12:
    }

    final void R()
    {
        com.xxx.sdk.e.c.info("\u5F00\u59CB\u6E05\u7406\u4E0D\u63A8\u5E7F\u7684\u5E7F\u544A\u8D44\u6E90\u3002");
        com.xxx.sdk.a.c c1 = new com.xxx.sdk.a.c(a_com_xxx_sdk_b_fld.getContext());
        Object obj = c1.a("launcher", new Integer[] {
            Integer.valueOf(0)
        });
        if(!com.xxx.sdk.e.b.a(((List) (obj))))
        {
            com.xxx.sdk.e.c.info((new StringBuilder("\u6E05\u7406app\u5E7F\u544A\u8D44\u6E90\u5217\u8868\uFF1A")).append(obj).toString());
            obj = ((List) (obj)).iterator();
            do
            {
                if(!((Iterator) (obj)).hasNext())
                    break;
                d d1 = (d)((Iterator) (obj)).next();
                e e1 = e.d(d1.ao);
                if(System.currentTimeMillis() - e1.updated >= 0x5265c00L)
                {
                    com.xxx.sdk.e.b.b(new String[] {
                        e1.installer, e1.icon, e1.bannerAd, e1.floatingAd
                    });
                    c1.a(new d[] {
                        d1
                    });
                }
            } while(true);
        }
        obj = c1.a("floating", new Integer[] {
            Integer.valueOf(0)
        });
        if(!com.xxx.sdk.e.b.a(((List) (obj))))
        {
            com.xxx.sdk.e.c.info((new StringBuilder("\u6E05\u7406\u63D2\u5C4F\u5E7F\u544A\u8D44\u6E90\u5217\u8868\uFF1A")).append(obj).toString());
            d d2;
            for(obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); c1.a(new d[] {
    d2
}))
            {
                d2 = (d)((Iterator) (obj)).next();
                com.xxx.sdk.e.b.b(new String[] {
                    d2.ao
                });
            }

        }
    }

    private static int ar = 3;
    public static volatile String bc = null;
    private static long j = 0x5265c00L;
    public com.xxx.sdk.a.g a_com_xxx_sdk_a_g_fld;
    public i a_com_xxx_sdk_a_i_fld;
    public b a_com_xxx_sdk_b_fld;
    public j b;
    public j c;
    public long k;
    public AtomicBoolean l;

}
