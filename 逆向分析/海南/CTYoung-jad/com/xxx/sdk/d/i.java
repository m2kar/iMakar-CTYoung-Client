// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.Message;
import com.xxx.c.m;
import com.xxx.sdk.a.j;
import com.xxx.sdk.api.a;
import com.xxx.sdk.b;
import com.xxx.sdk.c;
import com.xxx.sdk.c.g;
import com.xxx.sdk.c.h;
import com.xxx.sdk.f.d;
import com.xxx.sdk.f.e;
import com.xxx.sdk.p;
import com.xxx.sdk.s;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.sdk.d:
//            a, j, k

public final class i extends com.xxx.sdk.d.a
{

    private i(Context context, m m1)
    {
        a_android_content_Context_fld = context;
        b = m1;
    }

    static Context a(i l)
    {
        return l.a_android_content_Context_fld;
    }

    public static i a()
    {
        return a_com_xxx_sdk_d_i_static_fld;
    }

    private void a(long l, com.xxx.d.a a1, String s1)
    {
label0:
        {
label1:
            {
                if(!a.d.get())
                {
                    p p1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a();
                    long l1 = a1.a;
                    if(a1.a != 0L && l - l1 < (long)p1.a_com_xxx_sdk_s_fld.D)
                        break label0;
                    if(!p1.a_java_util_List_fld.contains(s1))
                        break label1;
                    a(88, f);
                }
                return;
            }
            a1.a = l;
            if(c.a(com/xxx/sdk/f/d, s1))
            {
                com.xxx.sdk.api.a.b(true);
                b.a(s1, false);
                return;
            } else
            {
                a(88, f);
                return;
            }
        }
        a(88, f);
    }

    public static void a(Context context, m m1)
    {
        com/xxx/sdk/d/i;
        JVM INSTR monitorenter ;
        if(a_com_xxx_sdk_d_i_static_fld == null)
            a_com_xxx_sdk_d_i_static_fld = new i(context, m1);
        com/xxx/sdk/d/i;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private void a(Message message, String s1)
    {
        boolean flag1;
        boolean flag2;
        long l;
        String s2;
        String s3;
        s2 = (String)message.obj;
        if(message.arg1 == 1)
            flag1 = true;
        else
            flag1 = false;
        l = System.currentTimeMillis();
        message = a.a;
        s3 = ((com.xxx.d.a) (message)).H;
        flag2 = com.xxx.e.b.i(s1);
        if(flag2 && (a.i.get() || a.d.get() || a.e_java_util_concurrent_atomic_AtomicBoolean_static_fld.get() || a.j.get()))
            com.xxx.sdk.api.a.C();
        if(!s3.equals("")) goto _L2; else goto _L1
_L1:
        message.H = s1;
        a(88, f);
_L4:
        return;
_L2:
        String s4;
        s4 = ((com.xxx.d.a) (message)).G;
        if(s4.equals(""))
        {
            message.G = s3;
            message.H = s1;
            a(88, f);
            return;
        }
        if(s2 == null || com.xxx.sdk.e.b.f(s2) || !s2.equals(s1))
            break; /* Loop/switch isn't completed */
        if(c.c())
        {
            message.a = l;
            message.H = s1;
            message.G = s1;
            com.xxx.sdk.api.a.b(true);
            b.a(s1, flag1);
            return;
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(com.xxx.e.b.i(s4) && flag2)
        {
            message.G = s1;
            message.H = s1;
            a(88, f);
            return;
        }
        if(!com.xxx.e.b.i(s4) && flag2)
        {
            message.G = s1;
            message.H = s1;
            message.startTime = l;
            a(88, f);
            com.xxx.sdk.api.a.C();
            (new com.xxx.c.c(a_android_content_Context_fld)).a("home");
            return;
        }
        if(!com.xxx.e.b.i(s4) && !flag2)
        {
            if(s4.equals(s1))
                message.I = s4;
            message.G = s1;
            message.H = s1;
            a(88, f);
            return;
        }
        if(com.xxx.e.b.i(s4) && !flag2)
        {
            message.H = s1;
            message.G = s1;
            boolean flag;
            if(!s1.equals(((com.xxx.d.a) (message)).I) || s1.equals(((com.xxx.d.a) (message)).I) && l - ((com.xxx.d.a) (message)).startTime >= 30000L)
                flag = true;
            else
                flag = false;
            if(((com.xxx.d.a) (message)).startTime == 0L || flag)
            {
                if(!a.d.get())
                {
                    p p1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a();
                    long l1 = ((com.xxx.d.a) (message)).a;
                    if(((com.xxx.d.a) (message)).a == 0L || l - l1 >= (long)p1.a_com_xxx_sdk_s_fld.D)
                    {
                        if(p1.a_java_util_List_fld.contains(s1))
                        {
                            a(88, f);
                            return;
                        }
                        message.a = l;
                        if(c.a(com/xxx/sdk/f/d, s1))
                        {
                            com.xxx.sdk.api.a.b(true);
                            b.a(s1, false);
                            return;
                        } else
                        {
                            a(88, f);
                            return;
                        }
                    } else
                    {
                        a(88, f);
                        return;
                    }
                }
            } else
            {
                a(88, f);
                return;
            }
        } else
        {
            message.H = s1;
            message.G = s3;
            a(88, f);
            return;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    private void a(com.xxx.f.p p1)
    {
        if(p1 != null)
        {
            b.c(p1);
            a.d.set(true);
            return;
        } else
        {
            a(88, f);
            return;
        }
    }

    static void a(i l, com.xxx.f.p p1)
    {
        l.g(p1);
    }

    private void b(Message message)
    {
        boolean flag;
        long l;
        long l1;
        ba++;
        Object obj = com.xxx.sdk.e.e.a.e(a_android_content_Context_fld);
        Object obj1 = (String)message.obj;
        boolean flag1;
        boolean flag2;
        long l2;
        long l3;
        long l4;
        String s1;
        if(message.arg1 == 1)
            flag1 = true;
        else
            flag1 = false;
        l = System.currentTimeMillis();
        message = a.a;
        s1 = ((com.xxx.d.a) (message)).H;
        flag2 = com.xxx.e.b.i(((String) (obj)));
        if(flag2 && (a.i.get() || a.d.get() || a.e_java_util_concurrent_atomic_AtomicBoolean_static_fld.get() || a.j.get()))
            com.xxx.sdk.api.a.C();
        if(s1.equals(""))
        {
            message.H = ((String) (obj));
            a(88, f);
        } else
        {
            String s2 = ((com.xxx.d.a) (message)).G;
            if(s2.equals(""))
            {
                message.G = s1;
                message.H = ((String) (obj));
                a(88, f);
            } else
            if(obj1 != null && !com.xxx.sdk.e.b.f(((String) (obj1))) && ((String) (obj1)).equals(obj))
            {
                if(c.c())
                {
                    message.a = l;
                    message.H = ((String) (obj));
                    message.G = ((String) (obj));
                    com.xxx.sdk.api.a.b(true);
                    b.a(((String) (obj)), flag1);
                }
            } else
            if(com.xxx.e.b.i(s2) && flag2)
            {
                message.G = ((String) (obj));
                message.H = ((String) (obj));
                a(88, f);
            } else
            if(!com.xxx.e.b.i(s2) && flag2)
            {
                message.G = ((String) (obj));
                message.H = ((String) (obj));
                message.startTime = l;
                a(88, f);
                com.xxx.sdk.api.a.C();
                (new com.xxx.c.c(a_android_content_Context_fld)).a("home");
            } else
            if(!com.xxx.e.b.i(s2) && !flag2)
            {
                if(s2.equals(obj))
                    message.I = s2;
                message.G = ((String) (obj));
                message.H = ((String) (obj));
                a(88, f);
            } else
            if(com.xxx.e.b.i(s2) && !flag2)
            {
                message.H = ((String) (obj));
                message.G = ((String) (obj));
                if(!((String) (obj)).equals(((com.xxx.d.a) (message)).I) || ((String) (obj)).equals(((com.xxx.d.a) (message)).I) && l - ((com.xxx.d.a) (message)).startTime >= 30000L)
                    flag = true;
                else
                    flag = false;
                if(((com.xxx.d.a) (message)).startTime == 0L || flag)
                {
                    if(!a.d.get())
                    {
                        p p1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a();
                        l1 = ((com.xxx.d.a) (message)).a;
                        if(((com.xxx.d.a) (message)).a == 0L || l - l1 >= (long)p1.a_com_xxx_sdk_s_fld.D)
                        {
                            if(p1.a_java_util_List_fld.contains(obj))
                            {
                                a(88, f);
                            } else
                            {
                                message.a = l;
                                if(c.a(com/xxx/sdk/f/d, ((String) (obj))))
                                {
                                    com.xxx.sdk.api.a.b(true);
                                    b.a(((String) (obj)), false);
                                } else
                                {
                                    a(88, f);
                                }
                            }
                        } else
                        {
                            a(88, f);
                        }
                    }
                } else
                {
                    a(88, f);
                }
            } else
            {
                message.H = ((String) (obj));
                message.G = s1;
                a(88, f);
            }
        }
        a(88, f);
        if(aX >= f && ba % (aX / f + 1) != 0) goto _L2; else goto _L1
_L1:
        message = com.xxx.sdk.b.a(a_android_content_Context_fld).a;
        if(!((g) (message)).l.getAndSet(true))
        {
            message.a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
            obj1 = ((g) (message)).a_com_xxx_sdk_b_fld.getContext();
            message.a_com_xxx_sdk_a_g_fld = new com.xxx.sdk.a.g(((Context) (obj1)));
            message.a_com_xxx_sdk_a_i_fld = new com.xxx.sdk.a.i(((Context) (obj1)));
            message.b = ((g) (message)).a_com_xxx_sdk_a_i_fld.a("collect_lasttime");
            message.c = ((g) (message)).a_com_xxx_sdk_a_i_fld.a("collect_fixedtime");
        }
        obj1 = ((g) (message)).a_com_xxx_sdk_b_fld.getContext();
        if(com.xxx.sdk.e.e.a.a(((Context) (obj1)), ((String) (obj))) || g.bc != null && g.bc.equals(obj))
            break MISSING_BLOCK_LABEL_422;
        g.bc = ((String) (obj));
        if(((Context) (obj1)).getPackageName().equals(obj))
            break MISSING_BLOCK_LABEL_422;
        obj = ((g) (message)).a_com_xxx_sdk_b_fld.a(((String) (obj)));
        if(obj == null)
            break MISSING_BLOCK_LABEL_422;
        if(((e) (obj)).state == 2 && System.currentTimeMillis() / 0x5265c00L > ((e) (obj)).updated / 0x5265c00L && System.currentTimeMillis() / 0x5265c00L > ((e) (obj)).lastReactivated / 0x5265c00L && (((e) (obj)).reactivateExpires / 0x5265c00L == 0L || ((e) (obj)).lastReactivated / 0x5265c00L - ((e) (obj)).updated / 0x5265c00L <= ((e) (obj)).reactivateExpires / 0x5265c00L))
            ((com.xxx.sdk.f.a) (obj)).d(null);
        if(!com.xxx.sdk.e.e.a.f(((g) (message)).a_com_xxx_sdk_b_fld.getContext())) goto _L4; else goto _L3
_L3:
        if(com.xxx.sdk.e.b.f(((g) (message)).a_com_xxx_sdk_b_fld.a().R)) goto _L6; else goto _L5
_L5:
        if(!com.xxx.sdk.e.b.f(((g) (message)).c.value)) goto _L8; else goto _L7
_L7:
        l = (long)(Math.random() * 5D * 60D) * 60000L;
        ((g) (message)).c.value = String.valueOf(l);
        ((g) (message)).a_com_xxx_sdk_a_i_fld.a(((g) (message)).c);
_L10:
        if(com.xxx.sdk.e.b.f(((g) (message)).b.value))
            break MISSING_BLOCK_LABEL_1254;
        l1 = Long.valueOf(((g) (message)).b.value).longValue();
_L11:
        obj = Calendar.getInstance();
        ((Calendar) (obj)).set(11, 1);
        ((Calendar) (obj)).set(12, 0);
        ((Calendar) (obj)).set(13, 0);
        l2 = ((Calendar) (obj)).getTimeInMillis();
        ((Calendar) (obj)).set(11, 6);
        l3 = ((Calendar) (obj)).getTimeInMillis();
        l4 = System.currentTimeMillis();
        if(l4 - l1 >= 0x5265c00L && l4 >= l2 && l4 <= l3 && l4 - l2 >= l)
            flag = true;
        else
            flag = false;
        if(!flag) goto _L6; else goto _L9
_L9:
        com.xxx.sdk.m.a().execute(new com.xxx.sdk.c.i(message, l1));
_L6:
        if(System.currentTimeMillis() - ((g) (message)).k - 60000L > 0L)
            com.xxx.sdk.m.a().execute(new h(message));
_L4:
        if(com.xxx.sdk.e.e.a.r() < 100L)
        {
            com.xxx.sdk.e.c.warn("SD\u5361\u7A7A\u95F4\u4E0D\u8DB3100M\uFF0C\u5F00\u59CB\u6E05\u7406\u7CFB\u7EDF\u5783\u573E");
            com.xxx.sdk.e.e.a.r();
        }
_L2:
        return;
_L8:
        try
        {
            l = Long.valueOf(((g) (message)).c.value).longValue();
        }
        // Misplaced declaration of an exception variable
        catch(Message message)
        {
            com.xxx.sdk.e.c.error("\u672A\u77E5\u9519\u8BEF\uFF01", message);
            return;
        }
          goto _L10
        l1 = 0L;
          goto _L11
    }

    private void b(com.xxx.f.p p1)
    {
        removeMessages(89);
        removeMessages(88);
        removeMessages(85);
        removeMessages(87);
        removeMessages(86);
        if(a.d.getAndSet(false))
            b.d(p1);
    }

    private void countDown()
    {
        if(System.currentTimeMillis() - a.e_long_static_fld > (long)m())
        {
            sendEmptyMessageDelayed(87, f);
            return;
        } else
        {
            sendEmptyMessageDelayed(89, f);
            return;
        }
    }

    private void f(com.xxx.f.p p1)
    {
        if(p1 == null)
        {
            g(p1);
            return;
        }
        if(p1.E > 0L)
        {
            long l = System.currentTimeMillis() - p1.E - (long)com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.G;
            if(l < 0L)
            {
                p1.setVisibility(8);
                a_com_xxx_sdk_d_i_static_fld.postDelayed(new com.xxx.sdk.d.j(this, p1), -l);
                return;
            } else
            {
                g(p1);
                return;
            }
        } else
        {
            g(p1);
            return;
        }
    }

    public static void g(int l)
    {
        f = l;
    }

    private void g(com.xxx.f.p p1)
    {
        if(a.d.getAndSet(false))
        {
            removeMessages(89);
            b.d(p1);
        }
        a(88, f);
    }

    public static void i(int l)
    {
        aX = l;
    }

    public final void handleMessage(Message message)
    {
        Object obj;
        obj = null;
        if(message.what != 88 || message.what != 89)
            obj = com.xxx.sdk.api.a.a();
        message.what;
        JVM INSTR lookupswitch 8: default 104
    //                   83: 1584
    //                   84: 1564
    //                   85: 1422
    //                   86: 1458
    //                   87: 1458
    //                   88: 110
    //                   89: 104
    //                   102: 1602;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L6 _L1 _L7
_L1:
        super.handleMessage(message);
        return;
_L6:
        boolean flag;
        long l;
        long l2;
        Object obj1;
        ba++;
        obj = com.xxx.sdk.e.e.a.e(a_android_content_Context_fld);
        Object obj2 = (String)message.obj;
        boolean flag1;
        boolean flag2;
        long l3;
        long l4;
        long l5;
        String s1;
        if(message.arg1 == 1)
            flag1 = true;
        else
            flag1 = false;
        l = System.currentTimeMillis();
        obj1 = a.a;
        s1 = ((com.xxx.d.a) (obj1)).H;
        flag2 = com.xxx.e.b.i(((String) (obj)));
        if(flag2 && (a.i.get() || a.d.get() || a.e_java_util_concurrent_atomic_AtomicBoolean_static_fld.get() || a.j.get()))
            com.xxx.sdk.api.a.C();
        if(s1.equals(""))
        {
            obj1.H = ((String) (obj));
            a(88, f);
        } else
        {
            String s2 = ((com.xxx.d.a) (obj1)).G;
            if(s2.equals(""))
            {
                obj1.G = s1;
                obj1.H = ((String) (obj));
                a(88, f);
            } else
            if(obj2 != null && !com.xxx.sdk.e.b.f(((String) (obj2))) && ((String) (obj2)).equals(obj))
            {
                if(c.c())
                {
                    obj1.a = l;
                    obj1.H = ((String) (obj));
                    obj1.G = ((String) (obj));
                    com.xxx.sdk.api.a.b(true);
                    b.a(((String) (obj)), flag1);
                }
            } else
            if(com.xxx.e.b.i(s2) && flag2)
            {
                obj1.G = ((String) (obj));
                obj1.H = ((String) (obj));
                a(88, f);
            } else
            if(!com.xxx.e.b.i(s2) && flag2)
            {
                obj1.G = ((String) (obj));
                obj1.H = ((String) (obj));
                obj1.startTime = l;
                a(88, f);
                com.xxx.sdk.api.a.C();
                (new com.xxx.c.c(a_android_content_Context_fld)).a("home");
            } else
            if(!com.xxx.e.b.i(s2) && !flag2)
            {
                if(s2.equals(obj))
                    obj1.I = s2;
                obj1.G = ((String) (obj));
                obj1.H = ((String) (obj));
                a(88, f);
            } else
            if(com.xxx.e.b.i(s2) && !flag2)
            {
                obj1.H = ((String) (obj));
                obj1.G = ((String) (obj));
                if(!((String) (obj)).equals(((com.xxx.d.a) (obj1)).I) || ((String) (obj)).equals(((com.xxx.d.a) (obj1)).I) && l - ((com.xxx.d.a) (obj1)).startTime >= 30000L)
                    flag = true;
                else
                    flag = false;
                if(((com.xxx.d.a) (obj1)).startTime == 0L || flag)
                {
                    if(!a.d.get())
                    {
                        p p1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a();
                        l2 = ((com.xxx.d.a) (obj1)).a;
                        if(((com.xxx.d.a) (obj1)).a == 0L || l - l2 >= (long)p1.a_com_xxx_sdk_s_fld.D)
                        {
                            if(p1.a_java_util_List_fld.contains(obj))
                            {
                                a(88, f);
                            } else
                            {
                                obj1.a = l;
                                if(c.a(com/xxx/sdk/f/d, ((String) (obj))))
                                {
                                    com.xxx.sdk.api.a.b(true);
                                    b.a(((String) (obj)), false);
                                } else
                                {
                                    a(88, f);
                                }
                            }
                        } else
                        {
                            a(88, f);
                        }
                    }
                } else
                {
                    a(88, f);
                }
            } else
            {
                obj1.H = ((String) (obj));
                obj1.G = s1;
                a(88, f);
            }
        }
        a(88, f);
        if(aX >= f && ba % (aX / f + 1) != 0) goto _L1; else goto _L8
_L8:
        obj1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a;
        if(!((g) (obj1)).l.getAndSet(true))
        {
            obj1.a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
            obj2 = ((g) (obj1)).a_com_xxx_sdk_b_fld.getContext();
            obj1.a_com_xxx_sdk_a_g_fld = new com.xxx.sdk.a.g(((Context) (obj2)));
            obj1.a_com_xxx_sdk_a_i_fld = new com.xxx.sdk.a.i(((Context) (obj2)));
            obj1.b = ((g) (obj1)).a_com_xxx_sdk_a_i_fld.a("collect_lasttime");
            obj1.c = ((g) (obj1)).a_com_xxx_sdk_a_i_fld.a("collect_fixedtime");
        }
        obj2 = ((g) (obj1)).a_com_xxx_sdk_b_fld.getContext();
        if(com.xxx.sdk.e.e.a.a(((Context) (obj2)), ((String) (obj))) || g.bc != null && g.bc.equals(obj))
            break MISSING_BLOCK_LABEL_547;
        g.bc = ((String) (obj));
        if(((Context) (obj2)).getPackageName().equals(obj))
            break MISSING_BLOCK_LABEL_547;
        obj = ((g) (obj1)).a_com_xxx_sdk_b_fld.a(((String) (obj)));
        if(obj == null)
            break MISSING_BLOCK_LABEL_547;
        if(((e) (obj)).state == 2 && System.currentTimeMillis() / 0x5265c00L > ((e) (obj)).updated / 0x5265c00L && System.currentTimeMillis() / 0x5265c00L > ((e) (obj)).lastReactivated / 0x5265c00L && (((e) (obj)).reactivateExpires / 0x5265c00L == 0L || ((e) (obj)).lastReactivated / 0x5265c00L - ((e) (obj)).updated / 0x5265c00L <= ((e) (obj)).reactivateExpires / 0x5265c00L))
            ((com.xxx.sdk.f.a) (obj)).d(null);
        if(!com.xxx.sdk.e.e.a.f(((g) (obj1)).a_com_xxx_sdk_b_fld.getContext())) goto _L10; else goto _L9
_L9:
        if(com.xxx.sdk.e.b.f(((g) (obj1)).a_com_xxx_sdk_b_fld.a().R)) goto _L12; else goto _L11
_L11:
        if(!com.xxx.sdk.e.b.f(((g) (obj1)).c.value)) goto _L14; else goto _L13
_L13:
        l = (long)(Math.random() * 5D * 60D) * 60000L;
        ((g) (obj1)).c.value = String.valueOf(l);
        ((g) (obj1)).a_com_xxx_sdk_a_i_fld.a(((g) (obj1)).c);
_L16:
        if(com.xxx.sdk.e.b.f(((g) (obj1)).b.value))
            break MISSING_BLOCK_LABEL_1619;
        l2 = Long.valueOf(((g) (obj1)).b.value).longValue();
_L17:
        obj = Calendar.getInstance();
        ((Calendar) (obj)).set(11, 1);
        ((Calendar) (obj)).set(12, 0);
        ((Calendar) (obj)).set(13, 0);
        l3 = ((Calendar) (obj)).getTimeInMillis();
        ((Calendar) (obj)).set(11, 6);
        l4 = ((Calendar) (obj)).getTimeInMillis();
        l5 = System.currentTimeMillis();
        if(l5 - l2 >= 0x5265c00L && l5 >= l3 && l5 <= l4 && l5 - l3 >= l)
            flag = true;
        else
            flag = false;
        if(!flag) goto _L12; else goto _L15
_L15:
        com.xxx.sdk.m.a().execute(new com.xxx.sdk.c.i(((g) (obj1)), l2));
_L12:
        if(System.currentTimeMillis() - ((g) (obj1)).k - 60000L > 0L)
            com.xxx.sdk.m.a().execute(new h(((g) (obj1))));
_L10:
        if(com.xxx.sdk.e.e.a.r() < 100L)
        {
            com.xxx.sdk.e.c.warn("SD\u5361\u7A7A\u95F4\u4E0D\u8DB3100M\uFF0C\u5F00\u59CB\u6E05\u7406\u7CFB\u7EDF\u5783\u573E");
            com.xxx.sdk.e.e.a.r();
        }
          goto _L1
        obj;
        com.xxx.sdk.e.c.error("\u672A\u77E5\u9519\u8BEF\uFF01", ((Throwable) (obj)));
          goto _L1
_L14:
        l = Long.valueOf(((g) (obj1)).c.value).longValue();
          goto _L16
_L4:
        if(obj != null)
        {
            b.c(((com.xxx.f.p) (obj)));
            a.d.set(true);
        } else
        {
            a(88, f);
        }
          goto _L1
_L5:
        com.xxx.sdk.api.a.b(false);
        b.g();
        if(obj != null && ((com.xxx.f.p) (obj)).E > 0L)
        {
            long l1 = System.currentTimeMillis() - ((com.xxx.f.p) (obj)).E - (long)com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.G;
            if(l1 < 0L)
            {
                ((com.xxx.f.p) (obj)).setVisibility(8);
                a_com_xxx_sdk_d_i_static_fld.postDelayed(new com.xxx.sdk.d.j(this, ((com.xxx.f.p) (obj))), -l1);
            } else
            {
                g(((com.xxx.f.p) (obj)));
            }
        } else
        {
            g(((com.xxx.f.p) (obj)));
        }
          goto _L1
_L3:
        b.g();
        com.xxx.sdk.api.a.b(false);
        b(((com.xxx.f.p) (obj)));
          goto _L1
_L2:
        b(((com.xxx.f.p) (obj)));
        a(88, f);
          goto _L1
_L7:
        com.xxx.sdk.m.a().execute(new k(this));
          goto _L1
        l2 = 0L;
          goto _L17
    }

    public final int m()
    {
        p p1;
        for(p1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a(); p1 == null || p1.a_com_xxx_sdk_s_fld == null || p1.a_com_xxx_sdk_s_fld.F == 0;)
            return 6000;

        return p1.a_com_xxx_sdk_s_fld.F + 1;
    }

    private static int RESTART = 83;
    private static i a_com_xxx_sdk_d_i_static_fld = null;
    private static int aS = 89;
    private static final int aT = 87;
    private static int aU = 86;
    private static final int aW = 30000;
    private static int aX = 0;
    private static int aY = 102;
    private static int aZ = 3000;
    private static int ba = 0;
    public static int f = 0;
    private static int g = 88;
    private static int h = 85;
    private static int i = 84;
    private Context a_android_content_Context_fld;
    private m b;

    static 
    {
        f = 200;
        aX = 500;
        ba = 0;
    }
}
