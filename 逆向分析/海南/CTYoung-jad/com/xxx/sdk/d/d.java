// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.Message;
import com.xxx.sdk.api.a;
import com.xxx.sdk.c;
import com.xxx.sdk.e.b;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.sdk.d:
//            a, e

public final class d extends com.xxx.sdk.d.a
{

    private d(Context context, com.xxx.c.b b1)
    {
        a_android_content_Context_fld = context;
        a_com_xxx_c_b_fld = b1;
    }

    public static com.xxx.sdk.d.a a()
    {
        return a_com_xxx_sdk_d_d_static_fld;
    }

    public static void a(Context context, com.xxx.c.b b1)
    {
        com/xxx/sdk/d/d;
        JVM INSTR monitorenter ;
        if(a_com_xxx_sdk_d_d_static_fld == null)
            a_com_xxx_sdk_d_d_static_fld = new d(context, b1);
        com/xxx/sdk/d/d;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private void a(Message message)
    {
        boolean flag1;
        long l;
        String s;
        com.xxx.d.a a1;
        String s1;
        s = (String)message.obj;
        if(message.arg1 == 1)
            flag1 = true;
        else
            flag1 = false;
        l = System.currentTimeMillis();
        a1 = a.b;
        s1 = a1.H;
        message = com.xxx.sdk.e.e.a.e(a_android_content_Context_fld);
        if(!s1.equals("")) goto _L2; else goto _L1
_L1:
        a1.H = message;
        a(98, f);
_L4:
        return;
_L2:
        String s2;
        s2 = a1.G;
        if(s2.equals(""))
        {
            a1.G = s1;
            a1.H = message;
            a(98, f);
            return;
        }
        if(s == null || b.f(s) || !s.equals(message))
            break; /* Loop/switch isn't completed */
        if(com.xxx.sdk.c.c())
        {
            a1.H = message;
            a1.G = message;
            a1.a = l;
            com.xxx.sdk.api.a.c(true);
            a_com_xxx_c_b_fld.a(message, flag1);
            return;
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(com.xxx.e.b.i(s2) && com.xxx.e.b.i(message))
        {
            a1.G = message;
            a1.H = message;
            if(a.i.get())
            {
                sendEmptyMessageDelayed(97, f);
                return;
            } else
            {
                a(98, f);
                return;
            }
        }
        if(!com.xxx.e.b.i(s2) && com.xxx.e.b.i(message))
        {
            a1.G = message;
            a1.H = message;
            a1.startTime = l;
            a(98, f);
            com.xxx.sdk.api.a.C();
            return;
        }
        if(!com.xxx.e.b.i(s2) && !com.xxx.e.b.i(message))
        {
            if(s2.equals(message))
                a1.I = s2;
            a1.G = message;
            a1.H = message;
            a(98, f);
            return;
        }
        if(com.xxx.e.b.i(s2) && !com.xxx.e.b.i(message))
        {
            a1.H = message;
            a1.G = message;
            boolean flag;
            if(!message.equals(a1.I) || message.equals(a1.I) && l - a1.startTime >= 30000L)
                flag = true;
            else
                flag = false;
            if(a1.startTime == 0L || flag)
            {
                if(!a.i.get())
                {
                    p p1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a();
                    long l1 = a1.a;
                    if(a1.a == 0L || l - l1 >= (long)p1.a_com_xxx_sdk_q_fld.D)
                    {
                        if(p1.a_java_util_List_fld.contains(message))
                        {
                            a(98, f);
                            return;
                        }
                        a1.a = l;
                        if(com.xxx.sdk.c.a(com/xxx/sdk/f/c, message))
                        {
                            com.xxx.c.b b1 = a_com_xxx_c_b_fld;
                            com.xxx.sdk.api.a.c(true);
                            b1.a(message, false);
                            return;
                        } else
                        {
                            a(98, f);
                            return;
                        }
                    } else
                    {
                        a(98, f);
                        return;
                    }
                }
            } else
            {
                a(98, f);
                return;
            }
        } else
        {
            a1.H = message;
            a1.G = s1;
            a(98, f);
            return;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    static void a(d d1, com.xxx.f.b b1)
    {
        d1.g(b1);
    }

    private void c(com.xxx.f.b b1)
    {
        if(b1 != null)
        {
            a_com_xxx_c_b_fld.a(b1);
            a.i.set(true);
            a.e = System.currentTimeMillis();
        }
        a(98, f);
    }

    private void countDown()
    {
        if(System.currentTimeMillis() - a.e > 6000L)
        {
            sendEmptyMessageDelayed(97, f);
            return;
        } else
        {
            sendEmptyMessageDelayed(99, f);
            return;
        }
    }

    private void d(com.xxx.f.b b1)
    {
        removeMessages(99);
        removeMessages(98);
        removeMessages(95);
        removeMessages(97);
        removeMessages(96);
        if(a.i.getAndSet(false))
            a_com_xxx_c_b_fld.b(b1);
    }

    private void f(com.xxx.f.b b1)
    {
        if(b1 == null)
        {
            g(b1);
            return;
        }
        if(b1.E > 0L)
        {
            long l = System.currentTimeMillis() - b1.E - (long)com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.G;
            if(l < 0L)
            {
                b1.setVisibility(8);
                a_com_xxx_sdk_d_d_static_fld.postDelayed(new e(this, b1), -l);
                return;
            } else
            {
                g(b1);
                return;
            }
        } else
        {
            g(b1);
            return;
        }
    }

    public static void g(int j)
    {
        f = j;
    }

    private void g(com.xxx.f.b b1)
    {
        if(a.i.getAndSet(false))
            a_com_xxx_c_b_fld.b(b1);
        removeMessages(97);
        a(98, f);
    }

    public final void handleMessage(Message message)
    {
        Object obj;
        obj = null;
        if(message.what != 98 || message.what != 99)
            obj = com.xxx.sdk.api.a.a();
        message.what;
        JVM INSTR tableswitch 93 99: default 72
    //                   93 925
    //                   94 905
    //                   95 718
    //                   96 799
    //                   97 799
    //                   98 78
    //                   99 757;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L6 _L7
_L1:
        super.handleMessage(message);
        return;
_L6:
        String s = (String)message.obj;
        boolean flag1;
        long l;
        Object obj1;
        String s1;
        if(message.arg1 == 1)
            flag1 = true;
        else
            flag1 = false;
        l = System.currentTimeMillis();
        obj1 = a.b;
        s1 = ((com.xxx.d.a) (obj1)).H;
        obj = com.xxx.sdk.e.e.a.e(a_android_content_Context_fld);
        if(s1.equals(""))
        {
            obj1.H = ((String) (obj));
            a(98, f);
        } else
        {
            String s2 = ((com.xxx.d.a) (obj1)).G;
            if(s2.equals(""))
            {
                obj1.G = s1;
                obj1.H = ((String) (obj));
                a(98, f);
            } else
            if(s != null && !b.f(s) && s.equals(obj))
            {
                if(com.xxx.sdk.c.c())
                {
                    obj1.H = ((String) (obj));
                    obj1.G = ((String) (obj));
                    obj1.a = l;
                    com.xxx.sdk.api.a.c(true);
                    a_com_xxx_c_b_fld.a(((String) (obj)), flag1);
                }
            } else
            if(com.xxx.e.b.i(s2) && com.xxx.e.b.i(((String) (obj))))
            {
                obj1.G = ((String) (obj));
                obj1.H = ((String) (obj));
                if(a.i.get())
                    sendEmptyMessageDelayed(97, f);
                else
                    a(98, f);
            } else
            if(!com.xxx.e.b.i(s2) && com.xxx.e.b.i(((String) (obj))))
            {
                obj1.G = ((String) (obj));
                obj1.H = ((String) (obj));
                obj1.startTime = l;
                a(98, f);
                com.xxx.sdk.api.a.C();
            } else
            if(!com.xxx.e.b.i(s2) && !com.xxx.e.b.i(((String) (obj))))
            {
                if(s2.equals(obj))
                    obj1.I = s2;
                obj1.G = ((String) (obj));
                obj1.H = ((String) (obj));
                a(98, f);
            } else
            if(com.xxx.e.b.i(s2) && !com.xxx.e.b.i(((String) (obj))))
            {
                obj1.H = ((String) (obj));
                obj1.G = ((String) (obj));
                boolean flag;
                if(!((String) (obj)).equals(((com.xxx.d.a) (obj1)).I) || ((String) (obj)).equals(((com.xxx.d.a) (obj1)).I) && l - ((com.xxx.d.a) (obj1)).startTime >= 30000L)
                    flag = true;
                else
                    flag = false;
                if(((com.xxx.d.a) (obj1)).startTime == 0L || flag)
                {
                    if(!a.i.get())
                    {
                        p p1 = com.xxx.sdk.b.a(a_android_content_Context_fld).a();
                        long l2 = ((com.xxx.d.a) (obj1)).a;
                        if(((com.xxx.d.a) (obj1)).a == 0L || l - l2 >= (long)p1.a_com_xxx_sdk_q_fld.D)
                        {
                            if(p1.a_java_util_List_fld.contains(obj))
                            {
                                a(98, f);
                            } else
                            {
                                obj1.a = l;
                                if(com.xxx.sdk.c.a(com/xxx/sdk/f/c, ((String) (obj))))
                                {
                                    obj1 = a_com_xxx_c_b_fld;
                                    com.xxx.sdk.api.a.c(true);
                                    ((com.xxx.c.b) (obj1)).a(((String) (obj)), false);
                                } else
                                {
                                    a(98, f);
                                }
                            }
                        } else
                        {
                            a(98, f);
                        }
                    }
                } else
                {
                    a(98, f);
                }
            } else
            {
                obj1.H = ((String) (obj));
                obj1.G = s1;
                a(98, f);
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(obj != null)
        {
            a_com_xxx_c_b_fld.a(((com.xxx.f.b) (obj)));
            a.i.set(true);
            a.e = System.currentTimeMillis();
        }
        a(98, f);
        continue; /* Loop/switch isn't completed */
_L7:
        if(System.currentTimeMillis() - a.e > 6000L)
            sendEmptyMessageDelayed(97, f);
        else
            sendEmptyMessageDelayed(99, f);
        continue; /* Loop/switch isn't completed */
_L5:
        a_com_xxx_c_b_fld.g();
        com.xxx.sdk.api.a.c(false);
        if(obj != null && ((com.xxx.f.b) (obj)).E > 0L)
        {
            long l1 = System.currentTimeMillis() - ((com.xxx.f.b) (obj)).E - (long)com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.G;
            if(l1 < 0L)
            {
                ((com.xxx.f.b) (obj)).setVisibility(8);
                a_com_xxx_sdk_d_d_static_fld.postDelayed(new e(this, ((com.xxx.f.b) (obj))), -l1);
            } else
            {
                g(((com.xxx.f.b) (obj)));
            }
        } else
        {
            g(((com.xxx.f.b) (obj)));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        a_com_xxx_c_b_fld.g();
        com.xxx.sdk.api.a.c(false);
        d(((com.xxx.f.b) (obj)));
        continue; /* Loop/switch isn't completed */
_L2:
        d(((com.xxx.f.b) (obj)));
        a(98, f);
        if(true) goto _L1; else goto _L8
_L8:
    }

    private static int RESTART = 93;
    private static d a_com_xxx_sdk_d_d_static_fld = null;
    private static int aR = 30000;
    private static int aS = 99;
    private static int aT = 97;
    private static int aU = 96;
    private static int aV = 6000;
    private static final int aW = 30000;
    public static int f = 0;
    private static int g = 98;
    private static int h = 95;
    private static int i = 94;
    private Context a_android_content_Context_fld;
    private com.xxx.c.b a_com_xxx_c_b_fld;

    static 
    {
        f = 200;
    }
}
