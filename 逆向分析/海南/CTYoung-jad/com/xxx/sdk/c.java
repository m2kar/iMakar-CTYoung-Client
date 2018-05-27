// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import android.os.Message;
import com.xxx.sdk.d.a;
import com.xxx.sdk.d.d;
import com.xxx.sdk.d.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.sdk:
//            b, p

public final class c
{

    public c()
    {
    }

    private static int a(Class class1)
    {
        return class1 != com/xxx/sdk/f/c ? 1 : 0;
    }

    public static Stack a(List list)
    {
        if(list == null || list.size() <= 0)
            return null;
        ArrayList arraylist = new ArrayList(list);
        Stack stack = new Stack();
        for(int j = 1; j < arraylist.size(); j++)
        {
            int l = ((Integer)arraylist.get(j)).intValue();
            arraylist.set(j, Integer.valueOf(((Integer)arraylist.get(j - 1)).intValue() + l));
        }

        int k = ((Integer)arraylist.get(arraylist.size() - 1)).intValue();
        int i1 = 0;
label0:
        do
        {
            if(i1 < list.size() && k > 0)
            {
                int k1 = (int)Math.round(Math.random() * (double)k);
                int j1 = 0;
                do
                {
label1:
                    {
                        if(j1 < arraylist.size())
                        {
                            if(((Integer)arraylist.get(j1)).intValue() <= 0 || k1 > ((Integer)arraylist.get(j1)).intValue())
                                break label1;
                            k1 = ((Integer)list.get(j1)).intValue();
                            stack.push(Integer.valueOf(j1));
                            arraylist.set(j1, Integer.valueOf(0));
                            for(j1++; j1 < arraylist.size(); j1++)
                                arraylist.set(j1, Integer.valueOf(((Integer)arraylist.get(j1)).intValue() - k1));

                            k -= k1;
                        }
                        i1++;
                        continue label0;
                    }
                    j1++;
                } while(true);
            }
            Collections.reverse(stack);
            return stack;
        } while(true);
    }

    public static boolean a(com.xxx.sdk.f.a a1, Class class1, String s, boolean flag)
    {
        if(a1 == null)
        {
            a.set(false);
            if(!flag)
            {
                a(class1, s, true);
                return true;
            }
        }
        return false;
    }

    public static boolean a(Class class1, String s)
    {
        boolean flag = false;
        boolean flag1 = false;
        com/xxx/sdk/c;
        JVM INSTR monitorenter ;
        boolean flag2 = c();
        if(flag2) goto _L2; else goto _L1
_L1:
        com/xxx/sdk/c;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        int j;
        int k;
        p p1;
        k = a(class1);
        p1 = com.xxx.sdk.b.a().a();
        j = p1.A + p1.B;
        if(j <= 0)
            break MISSING_BLOCK_LABEL_118;
        j = (p1.A * 100) / j;
_L4:
        if((int)(Math.random() * 100D) >= j ? k != 1 : k == 1)
            flag = true;
        flag1 = flag;
        if(flag) goto _L1; else goto _L3
_L3:
        a.set(false);
        a(class1, s, false);
        flag1 = flag;
          goto _L1
        class1;
        throw class1;
        j = 60;
          goto _L4
    }

    private static boolean a(Class class1, String s, boolean flag)
    {
        Object obj;
        if(a(class1) == 0)
        {
            obj = i.a();
            class1 = ((a) (obj)).obtainMessage(88);
            ((a) (obj)).removeMessages(88);
        } else
        {
            obj = d.a();
            ((a) (obj)).removeMessages(98);
            class1 = ((a) (obj)).obtainMessage(98);
        }
        class1.obj = s;
        if(flag)
            class1.arg1 = 1;
        ((a) (obj)).sendMessage(class1);
        return true;
    }

    public static boolean c()
    {
        return a.compareAndSet(false, true);
    }

    private static void v()
    {
        a.set(true);
    }

    private static void w()
    {
        a.set(false);
    }

    public static void x()
    {
        a.set(false);
    }

    private static AtomicBoolean a = new AtomicBoolean(false);
    private static final int p = 0;
    private static final int q = 1;

}
