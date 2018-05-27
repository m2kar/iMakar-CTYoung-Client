// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e;

import com.xxx.sdk.e.c.d;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.*;
import java.security.MessageDigest;
import java.util.*;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.e:
//            c

public final class b
{

    private b()
    {
    }

    public static void U()
    {
        if(1000L <= 0L)
            break MISSING_BLOCK_LABEL_14;
        Thread.sleep(1000L);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
    }

    private static Class a(Class class1)
    {
        class1 = class1.getGenericSuperclass();
        if(!(class1 instanceof ParameterizedType))
            return java/lang/Object;
        class1 = ((ParameterizedType)class1).getActualTypeArguments();
        if(class1.length <= 0)
            return java/lang/Object;
        if(!(class1[0] instanceof Class))
            return java/lang/Object;
        else
            return (Class)class1[0];
    }

    private static Object a(Object obj, Object obj1)
    {
        if(obj == null)
            return obj1;
        else
            return obj;
    }

    private static String a(String s, String s1, String s2)
    {
        if(s != null)
            return new String(s.getBytes(s1), s2);
        else
            return null;
    }

    public static String a(List list, String s)
    {
        if(a(list))
            return "";
        s = d(s);
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(list.get(0));
        for(int i = 1; i < list.size(); i++)
        {
            stringbuffer.append(s);
            stringbuffer.append(list.get(i));
        }

        return stringbuffer.toString();
    }

    private static String a(byte abyte0[])
    {
        int i;
        StringBuffer stringbuffer;
        i = 0;
        stringbuffer = new StringBuffer();
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(abyte0);
        abyte0 = messagedigest.digest();
_L1:
        if(i >= abyte0.length)
            break MISSING_BLOCK_LABEL_76;
        int j;
        j = abyte0[i] & 0xff;
        if(j >= 16)
            break MISSING_BLOCK_LABEL_55;
        stringbuffer.append(0);
        stringbuffer.append(Integer.toHexString(j));
        i++;
          goto _L1
        abyte0;
        abyte0.printStackTrace();
        return stringbuffer.toString();
    }

    public static List a(Object aobj[])
    {
        if(aobj != null && aobj.length != 0) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        int j = aobj.length;
        int i = 0;
        do
        {
            obj = arraylist;
            if(i >= j)
                continue;
            arraylist.add(aobj[i]);
            i++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static transient void a(File afile[])
    {
        if(!a(((Object []) (afile))))
        {
            int j = afile.length;
            int i = 0;
            while(i < j) 
            {
                File file = afile[i];
                if(file.exists())
                {
                    if(file.isDirectory())
                        a(file.listFiles());
                    file.delete();
                }
                i++;
            }
        }
    }

    public static boolean a(List list)
    {
        return list == null || list.isEmpty();
    }

    public static boolean a(Object aobj[])
    {
        return aobj == null || aobj.length == 0;
    }

    public static int b(int i)
    {
        int j = i;
        if(i > 0)
        {
            Random random = new Random();
            long l = System.currentTimeMillis();
            j = bb;
            bb = j + 1;
            random.setSeed(l + (long)j);
            j = random.nextInt(i);
        }
        return j;
    }

    private static Class b(Class class1)
    {
        class1 = class1.getGenericSuperclass();
        if(!(class1 instanceof ParameterizedType))
            return java/lang/Object;
        class1 = ((ParameterizedType)class1).getActualTypeArguments();
        if(class1.length <= 0)
            return java/lang/Object;
        if(!(class1[0] instanceof Class))
            return java/lang/Object;
        else
            return (Class)class1[0];
    }

    public static String b(Object obj)
    {
        Field afield[];
        if(obj != null)
            if((afield = obj.getClass().getFields()) != null && afield.length != 0)
            {
                JSONObject jsonobject = new JSONObject();
                int i = 0;
                while(i < afield.length) 
                {
                    if(!Modifier.isStatic(afield[i].getModifiers()))
                    {
                        String s = afield[i].getName();
                        try
                        {
                            jsonobject.put(s, afield[i].get(obj));
                        }
                        catch(Exception exception) { }
                    }
                    i++;
                }
                return jsonobject.toString();
            }
        return null;
    }

    private static String b(String s, String s1)
    {
        if(f(s))
            return s1;
        else
            return s;
    }

    public static transient void b(String as[])
    {
        if(!a(as))
        {
            int j = as.length;
            int i = 0;
            while(i < j) 
            {
                Object obj = as[i];
                if(!f(((String) (obj))))
                {
                    obj = new File(((String) (obj)));
                    if(((File) (obj)).exists())
                    {
                        if(((File) (obj)).isDirectory())
                            a(((File) (obj)).listFiles());
                        ((File) (obj)).delete();
                    }
                }
                i++;
            }
        }
    }

    public static boolean b(String s, String s1)
    {
        if(f(s1))
            return true;
        FileInputStream fileinputstream;
        fileinputstream = new FileInputStream(s);
        String s2 = a(com.xxx.sdk.e.c.d.a(fileinputstream));
        if(s1.equals(s2))
            break MISSING_BLOCK_LABEL_80;
        com.xxx.sdk.e.c.warn((new StringBuilder("\u4E0B\u8F7D\u6587\u4EF6\u6821\u9A8C\u4E0D\u5408\u6CD5\uFF0C\u671F\u671Bmd5\uFF1A")).append(s1).append(", \u5B9E\u9645md5:").append(s2).toString());
        com.xxx.sdk.e.c.d.a(fileinputstream);
        (new File(s)).delete();
        return false;
        try
        {
            com.xxx.sdk.e.c.d.a(fileinputstream);
        }
        // Misplaced declaration of an exception variable
        catch(String s1)
        {
            com.xxx.sdk.e.c.a("\u672A\u77E5\u9519\u8BEF", s1);
            (new File(s)).delete();
            return false;
        }
        return true;
    }

    private static Map c(Map map)
    {
        Object obj;
        if(map instanceof HashMap)
            obj = new HashMap();
        else
        if(map instanceof Hashtable)
            obj = new Hashtable();
        else
            throw new IllegalArgumentException("\u4E0D\u652F\u6301\u975EHashMap\u4EE5\u53CAHashtable\u5BF9\u8C61\uFF01");
        ((Map) (obj)).putAll(map);
        return ((Map) (obj));
    }

    public static boolean c(Map map)
    {
        return map == null || map.isEmpty();
    }

    public static String d(String s)
    {
        String s1 = s;
        if(f(s))
            s1 = "";
        return s1;
    }

    public static String e(String s)
    {
        int i;
        StringBuffer stringbuffer;
        i = 0;
        stringbuffer = new StringBuffer();
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(s.getBytes());
        s = messagedigest.digest();
_L1:
        if(i >= s.length)
            break MISSING_BLOCK_LABEL_79;
        int j;
        j = s[i] & 0xff;
        if(j >= 16)
            break MISSING_BLOCK_LABEL_58;
        stringbuffer.append(0);
        stringbuffer.append(Integer.toHexString(j));
        i++;
          goto _L1
        s;
        s.printStackTrace();
        return stringbuffer.toString();
    }

    public static boolean equals(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static String f(String s)
    {
        String s1;
        if(f(s))
        {
            s1 = "";
        } else
        {
            int i = s.lastIndexOf("?");
            s1 = s;
            if(i >= 0)
                return s.substring(0, i);
        }
        return s1;
    }

    public static boolean f(String s)
    {
        return s == null || "".equals(s.trim());
    }

    private static Object newInstance(Class class1)
    {
        try
        {
            class1 = ((Class) (class1.newInstance()));
        }
        // Misplaced declaration of an exception variable
        catch(Class class1)
        {
            throw new RuntimeException(class1);
        }
        return class1;
    }

    public static transient Object[] toArray(Object aobj[])
    {
        return aobj;
    }

    private static String bD = "";
    private static int bb = 1;
    private static Map e;

    static 
    {
        new HashMap();
    }
}
