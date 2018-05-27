// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e;

import android.content.Context;
import android.os.*;
import android.util.Log;
import com.xxx.sdk.e.c.d;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.j;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.xxx.sdk.e:
//            d

public final class c
{

    public c()
    {
    }

    private static String a(StackTraceElement stacktraceelement)
    {
        return (new StringBuilder("[ threadID-")).append(Thread.currentThread().getId()).append(": ").append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).append(": ").append(stacktraceelement.getLineNumber()).append(" ]").toString();
    }

    private static void a(String s, String s1, Throwable throwable)
    {
        if(!h || c == null)
            return;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        FileWriter filewriter;
        String s2;
        s2 = (new SimpleDateFormat("yyyyMMdd HH:mm:ss")).format(new Date());
        filewriter = new FileWriter(c, true);
        filewriter.append((new StringBuilder()).append(s2).append("\t").toString());
        filewriter.append((new StringBuilder("Thread:")).append(Thread.currentThread().getName()).toString());
        filewriter.append((new StringBuilder("[")).append(s).append("]").toString());
        filewriter.append(s1);
        if(throwable == null) goto _L2; else goto _L1
_L1:
        filewriter.append(",");
        s = new StringWriter(2048);
        s1 = new PrintWriter(s);
        throwable.printStackTrace(s1);
        filewriter.append(s.getBuffer().toString());
        s1.close();
_L3:
        filewriter.flush();
_L4:
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        filewriter.append("\r\n");
          goto _L3
        s;
        s = filewriter;
_L5:
        d.a(s);
          goto _L4
        s;
        s = null;
          goto _L5
    }

    public static void a(String s, Throwable throwable)
    {
        if(bd <= 4)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.e(TAG, (new StringBuilder()).append(a(stacktraceelement)).append(s).toString(), throwable);
            a("W", s, throwable);
        }
    }

    private static File b()
    {
        File file;
        String s = com.xxx.sdk.e.e.a.B().concat(File.separator).concat(j.a().M).concat(File.separator).concat("logs").concat(File.separator);
        file = new File(s.concat("app.log"));
        if(!file.exists())
            break MISSING_BLOCK_LABEL_130;
        String s1 = (new SimpleDateFormat("yyyyMMdd_HH:mm:ss")).format(new Date());
        file.renameTo(new File(s.concat("app").concat("_").concat(s1).concat(".log")));
        file = new File(s.concat("app.log"));
_L1:
        file.createNewFile();
        return file;
        try
        {
            file.getParentFile().mkdirs();
        }
        catch(IOException ioexception)
        {
            return null;
        }
          goto _L1
    }

    private static void b(Context context, String s)
    {
        if(bd <= 1)
        {
            if(handler == null)
                handler = new com.xxx.sdk.e.d(Looper.getMainLooper(), context);
            context = handler.obtainMessage(0);
            context.obj = s;
            handler.sendMessage(context);
        }
    }

    public static void debug(String s)
    {
        if(bd <= 2)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.d(TAG, (new StringBuilder()).append(a(stacktraceelement)).append(s).toString());
            a("D", s, null);
        }
    }

    public static void error(String s)
    {
        if(bd <= 5)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.e(TAG, (new StringBuilder()).append(a(stacktraceelement)).append(s).toString());
            a("E", s, null);
        }
    }

    public static void error(String s, Throwable throwable)
    {
        if(bd <= 5)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.e(TAG, (new StringBuilder()).append(a(stacktraceelement)).append(s).toString(), throwable);
            a("E", s, throwable);
        }
    }

    public static void info(String s)
    {
        if(bd <= 3)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.i(TAG, (new StringBuilder()).append(a(stacktraceelement)).append(s).toString());
            a("I", s, null);
        }
    }

    public static void verbose(String s)
    {
        if(bd <= 1)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.v(TAG, (new StringBuilder()).append(a(stacktraceelement)).append(s).toString());
            a("V", s, null);
        }
    }

    public static void warn(String s)
    {
        if(bd <= 4)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.w(TAG, (new StringBuilder()).append(a(stacktraceelement)).append(s).toString());
            a("W", s, null);
        }
    }

    private static int DEBUG = 2;
    private static int ERROR = 5;
    private static int INFO = 3;
    private static String TAG;
    private static int VERBOSE = 1;
    private static int WARN = 4;
    private static Object a = new Object();
    private static int bc = 6;
    private static int bd;
    private static File c;
    private static boolean h;
    private static Handler handler;
    private static boolean p;

    static 
    {
        j j1 = j.a();
        bd = j1.r;
        TAG = j1.M;
        boolean flag = j1.h;
        h = flag;
        if(flag)
            c = b();
        else
            c = null;
    }
}
