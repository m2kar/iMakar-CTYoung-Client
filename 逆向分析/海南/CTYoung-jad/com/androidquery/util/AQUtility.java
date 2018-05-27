// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.*;
import android.util.*;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.androidquery.AQuery;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.*;

// Referenced classes of package com.androidquery.util:
//            Common, Progress

public class AQUtility
{

    public AQUtility()
    {
    }

    public static void apply(android.content.SharedPreferences.Editor editor)
    {
        if(AQuery.SDK_INT >= 9)
        {
            invokeHandler(editor, "apply", false, true, null, (Object[])null);
            return;
        } else
        {
            editor.commit();
            return;
        }
    }

    public static void cleanCache(File file, long l, long l1)
    {
        file = file.listFiles();
        if(file == null)
            return;
        Arrays.sort(file, new Common());
        if(testCleanNeeded(file, l))
            cleanCache(((File []) (file)), l1);
        file = getTempDir();
        if(file != null)
            try
            {
                if(file.exists())
                {
                    cleanCache(file.listFiles(), 0L);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch(File file)
            {
                report(file);
            }
        return;
    }

    private static void cleanCache(File afile[], long l)
    {
        long l1 = 0L;
        int j = 0;
        int i = 0;
        while(i < afile.length) 
        {
            File file = afile[i];
            int k = j;
            long l2 = l1;
            if(file.isFile())
            {
                l2 = l1 + file.length();
                if(l2 < l)
                {
                    k = j;
                } else
                {
                    file.delete();
                    k = j + 1;
                }
            }
            i++;
            j = k;
            l1 = l2;
        }
        debug("deleted", Integer.valueOf(j));
    }

    public static void cleanCacheAsync(Context context1)
    {
        cleanCacheAsync(context1, 0x2dc6c0L, 0x1e8480L);
    }

    public static void cleanCacheAsync(Context context1, long l, long l1)
    {
        try
        {
            context1 = getCacheDir(context1);
            context1 = (new Common()).method(2, new Object[] {
                context1, Long.valueOf(l), Long.valueOf(l1)
            });
            getFileStoreExecutor().schedule(context1, 0L, TimeUnit.MILLISECONDS);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Context context1)
        {
            report(context1);
        }
    }

    public static void close(Closeable closeable)
    {
        if(closeable == null)
            break MISSING_BLOCK_LABEL_10;
        closeable.close();
        return;
        closeable;
    }

    public static void copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        copy(inputstream, outputstream, 0, null);
    }

    public static void copy(InputStream inputstream, OutputStream outputstream, int i, Progress progress)
        throws IOException
    {
        if(progress != null)
        {
            progress.reset();
            progress.setBytes(i);
        }
        byte abyte0[] = new byte[4096];
        do
        {
            i = inputstream.read(abyte0);
            if(i == -1)
                break;
            outputstream.write(abyte0, 0, i);
            if(progress != null)
                progress.increment(i);
        } while(true);
        if(progress != null)
            progress.done();
    }

    public static void debug(Object obj)
    {
        if(debug)
            Log.w("AQuery", (new StringBuilder()).append(obj).append("").toString());
    }

    public static void debug(Object obj, Object obj1)
    {
        if(debug)
            Log.w("AQuery", (new StringBuilder()).append(obj).append(":").append(obj1).toString());
    }

    public static void debug(Throwable throwable)
    {
        if(debug)
            Log.w("AQuery", Log.getStackTraceString(throwable));
    }

    public static void debugNotify()
    {
        if(!debug || wait == null)
            return;
        synchronized(wait)
        {
            wait.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void debugWait(long l)
    {
        if(!debug)
            return;
        if(wait == null)
            wait = new Object();
        Object obj = wait;
        obj;
        JVM INSTR monitorenter ;
        wait.wait(l);
_L1:
        return;
        Object obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
          goto _L1
    }

    public static int dip2pixel(Context context1, float f)
    {
        return (int)TypedValue.applyDimension(1, f, context1.getResources().getDisplayMetrics());
    }

    public static void ensureUIThread()
    {
        if(!isUIThread())
            report(new IllegalStateException("Not UI Thread"));
    }

    public static File getCacheDir(Context context1)
    {
        if(cacheDir == null)
        {
            cacheDir = new File(context1.getCacheDir(), "aquery");
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static File getCacheDir(Context context1, int i)
    {
        if(i == 1)
        {
            if(pcacheDir != null)
            {
                return pcacheDir;
            } else
            {
                pcacheDir = new File(getCacheDir(context1), "persistent");
                pcacheDir.mkdirs();
                return pcacheDir;
            }
        } else
        {
            return getCacheDir(context1);
        }
    }

    public static File getCacheFile(File file, String s)
    {
        if(s == null)
            return null;
        if(s.startsWith(File.separator))
            return new File(s);
        else
            return makeCacheFile(file, getCacheFileName(s));
    }

    private static String getCacheFileName(String s)
    {
        return getMD5Hex(s);
    }

    public static Context getContext()
    {
        if(context == null)
        {
            warn("warn", "getContext with null");
            debug(new IllegalStateException());
        }
        return context;
    }

    public static File getExistedCacheByUrl(File file, String s)
    {
label0:
        {
            s = getCacheFile(file, s);
            if(s != null)
            {
                file = s;
                if(s.exists())
                    break label0;
            }
            file = null;
        }
        return file;
    }

    public static File getExistedCacheByUrlSetAccess(File file, String s)
    {
        file = getExistedCacheByUrl(file, s);
        if(file != null)
            lastAccess(file);
        return file;
    }

    private static ScheduledExecutorService getFileStoreExecutor()
    {
        if(storeExe == null)
            storeExe = Executors.newSingleThreadScheduledExecutor();
        return storeExe;
    }

    public static Handler getHandler()
    {
        if(handler == null)
            handler = new Handler(Looper.getMainLooper());
        return handler;
    }

    private static byte[] getMD5(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch(byte abyte0[])
        {
            report(abyte0);
            return null;
        }
        return abyte0;
    }

    private static String getMD5Hex(String s)
    {
        return (new BigInteger(getMD5(s.getBytes()))).abs().toString(36);
    }

    public static File getTempDir()
    {
        File file;
label0:
        {
            File file1 = new File(Environment.getExternalStorageDirectory(), "aquery/temp");
            file1.mkdirs();
            if(file1.exists())
            {
                file = file1;
                if(file1.canWrite())
                    break label0;
            }
            file = null;
        }
        return file;
    }

    public static transient Object invokeHandler(Object obj, String s, boolean flag, boolean flag1, Class aclass[], Class aclass1[], Object aobj[])
    {
        try
        {
            obj = invokeMethod(obj, s, flag, aclass, aclass1, aobj);
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            if(flag1)
                report(((Throwable) (obj)));
            else
                debug(((Throwable) (obj)));
            return null;
        }
        return obj;
    }

    public static transient Object invokeHandler(Object obj, String s, boolean flag, boolean flag1, Class aclass[], Object aobj[])
    {
        return invokeHandler(obj, s, flag, flag1, aclass, null, aobj);
    }

    private static transient Object invokeMethod(Object obj, String s, boolean flag, Class aclass[], Class aclass1[], Object aobj[])
        throws Exception
    {
        if(obj != null && s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Class aclass2[];
        aclass2 = aclass;
        if(aclass != null)
            break MISSING_BLOCK_LABEL_23;
        aclass2 = new Class[0];
        aclass = ((Class []) (obj.getClass().getMethod(s, aclass2).invoke(obj, aobj)));
        return aclass;
        aclass;
        if(!flag) goto _L1; else goto _L3
_L3:
        if(aclass1 != null)
            break MISSING_BLOCK_LABEL_73;
        return obj.getClass().getMethod(s, new Class[0]).invoke(obj, new Object[0]);
        obj = obj.getClass().getMethod(s, aclass1).invoke(obj, aobj);
        return obj;
        obj;
        return null;
    }

    public static boolean isDebug()
    {
        return debug;
    }

    public static boolean isUIThread()
    {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private static void lastAccess(File file)
    {
        file.setLastModified(System.currentTimeMillis());
    }

    private static File makeCacheFile(File file, String s)
    {
        return new File(file, s);
    }

    public static float pixel2dip(Context context1, float f)
    {
        return f / ((float)context1.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static void post(Object obj, String s)
    {
        post(obj, s, new Class[0], new Object[0]);
    }

    public static transient void post(Object obj, String s, Class aclass[], Object aobj[])
    {
        post(new Runnable(obj, s, aclass, aobj) {

            public void run()
            {
                AQUtility.invokeHandler(handler, method, false, true, sig, params);
            }

            final Object val$handler;
            final String val$method;
            final Object val$params[];
            final Class val$sig[];

            
            {
                handler = obj;
                method = s;
                sig = aclass;
                params = aobj;
                super();
            }
        }
);
    }

    public static void post(Runnable runnable)
    {
        getHandler().post(runnable);
    }

    public static void postAsync(Object obj, String s)
    {
        postAsync(obj, s, new Class[0], new Object[0]);
    }

    public static transient void postAsync(Object obj, String s, Class aclass[], Object aobj[])
    {
        postAsync(new Runnable(obj, s, aclass, aobj) {

            public void run()
            {
                AQUtility.invokeHandler(handler, method, false, true, sig, params);
            }

            final Object val$handler;
            final String val$method;
            final Object val$params[];
            final Class val$sig[];

            
            {
                handler = obj;
                method = s;
                sig = aclass;
                params = aobj;
                super();
            }
        }
);
    }

    public static void postAsync(Runnable runnable)
    {
        (new AsyncTask(runnable) {

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient String doInBackground(Void avoid[])
            {
                try
                {
                    run.run();
                }
                // Misplaced declaration of an exception variable
                catch(Void avoid[])
                {
                    AQUtility.report(avoid);
                }
                return null;
            }

            final Runnable val$run;

            
            {
                run = runnable;
                super();
            }
        }
).execute(new Void[0]);
    }

    public static void postDelayed(Runnable runnable, long l)
    {
        getHandler().postDelayed(runnable, l);
    }

    public static void removePost(Runnable runnable)
    {
        getHandler().removeCallbacks(runnable);
    }

    public static void report(Throwable throwable)
    {
        if(throwable != null)
            try
            {
                warn("reporting", Log.getStackTraceString(throwable));
                if(eh != null)
                {
                    eh.uncaughtException(Thread.currentThread(), throwable);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch(Throwable throwable)
            {
                throwable.printStackTrace();
                return;
            }
    }

    private static void setAlpha(View view, float f)
    {
        if(f == 1.0F)
        {
            view.clearAnimation();
            return;
        } else
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(f, f);
            alphaanimation.setDuration(0L);
            alphaanimation.setFillAfter(true);
            view.startAnimation(alphaanimation);
            return;
        }
    }

    public static void setCacheDir(File file)
    {
        cacheDir = file;
        if(cacheDir != null)
            cacheDir.mkdirs();
    }

    public static void setContext(Application application)
    {
        context = application.getApplicationContext();
    }

    public static void setDebug(boolean flag)
    {
        debug = flag;
    }

    public static void setExceptionHandler(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        eh = uncaughtexceptionhandler;
    }

    public static void store(File file, byte abyte0[])
    {
        if(file == null)
            break MISSING_BLOCK_LABEL_9;
        write(file, abyte0);
        return;
        file;
        report(file);
        return;
    }

    public static void storeAsync(File file, byte abyte0[], long l)
    {
        getFileStoreExecutor().schedule((new Common()).method(1, new Object[] {
            file, abyte0
        }), l, TimeUnit.MILLISECONDS);
    }

    private static boolean testCleanNeeded(File afile[], long l)
    {
        long l1 = 0L;
        int j = afile.length;
        for(int i = 0; i < j; i++)
        {
            l1 += afile[i].length();
            if(l1 > l)
                return true;
        }

        return false;
    }

    public static void time(String s)
    {
        times.put(s, Long.valueOf(System.currentTimeMillis()));
    }

    public static long timeEnd(String s, long l)
    {
        Long long1 = (Long)times.get(s);
        if(long1 != null) goto _L2; else goto _L1
_L1:
        long l1 = 0L;
_L4:
        return l1;
_L2:
        long l2;
        l2 = System.currentTimeMillis() - long1.longValue();
        if(l == 0L)
            break; /* Loop/switch isn't completed */
        l1 = l2;
        if(l2 <= l) goto _L4; else goto _L3
_L3:
        debug(s, Long.valueOf(l2));
        return l2;
    }

    public static byte[] toBytes(InputStream inputstream)
    {
        byte abyte0[];
        ByteArrayOutputStream bytearrayoutputstream;
        abyte0 = null;
        bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte1[];
        copy(inputstream, bytearrayoutputstream);
        abyte1 = bytearrayoutputstream.toByteArray();
        abyte0 = abyte1;
_L2:
        close(inputstream);
        return abyte0;
        IOException ioexception;
        ioexception;
        report(ioexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static void transparent(View view, boolean flag)
    {
        float f = 1.0F;
        if(flag)
            f = 0.5F;
        setAlpha(view, f);
    }

    public static void warn(Object obj, Object obj1)
    {
        Log.w("AQuery", (new StringBuilder()).append(obj).append(":").append(obj1).toString());
    }

    public static void write(File file, byte abyte0[])
    {
        boolean flag = file.exists();
        if(flag)
            break MISSING_BLOCK_LABEL_14;
        file.createNewFile();
_L1:
        Exception exception;
        try
        {
            file = new FileOutputStream(file);
            file.write(abyte0);
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(File file)
        {
            report(file);
        }
        break MISSING_BLOCK_LABEL_53;
        exception;
        debug("file create fail", file);
        report(exception);
          goto _L1
    }

    private static final int IO_BUFFER_SIZE = 4096;
    private static File cacheDir;
    private static Context context;
    private static boolean debug = false;
    private static Thread.UncaughtExceptionHandler eh;
    private static Handler handler;
    private static File pcacheDir;
    private static ScheduledExecutorService storeExe;
    private static Map times = new HashMap();
    private static Object wait;

}
