// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.b;

import android.util.Base64;
import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class f
{

    public f()
    {
    }

    f(int i, InputStream inputstream, Map map, Map map1)
    {
label0:
        {
            super();
            statusCode = i;
            a = inputstream;
            n = Collections.unmodifiableMap(map1);
            if(android.os.Build.VERSION.SDK_INT >= 9)
                break label0;
            inputstream = new HashMap(map.size());
            map = map.entrySet().iterator();
            do
            {
                if(!map.hasNext())
                    break;
                map1 = (java.util.Map.Entry)map.next();
                if(map1.getKey() == null)
                {
                    inputstream.put(map1.getKey(), map1.getValue());
                    continue;
                }
                String s = (String)map1.getKey();
                int k = s.length();
                StringBuilder stringbuilder = new StringBuilder(k);
                for(i = 0; i < k; i++)
                {
                    char c;
label1:
                    {
                        char c1 = s.charAt(i);
                        if(i != 0)
                        {
                            c = c1;
                            if(s.charAt(i - 1) != '-')
                                break label1;
                        }
                        c = Character.toUpperCase(c1);
                    }
                    stringbuilder.append(c);
                }

                inputstream.put(stringbuilder.toString(), map1.getValue());
            } while(true);
            o = Collections.unmodifiableMap(inputstream);
            return;
        }
        o = Collections.unmodifiableMap(map);
    }

    private String A()
    {
        String s = l("Content-Type");
        int i;
        if(s != null)
            if((i = s.indexOf('=')) != -1)
                return s.substring(i + 1).trim();
        return null;
    }

    private InputStream a()
    {
        return a;
    }

    public static String a(String s, byte abyte0[])
    {
        try
        {
            Object obj = new DESKeySpec(s.getBytes());
            obj = SecretKeyFactory.getInstance("DES").generateSecret(((java.security.spec.KeySpec) (obj)));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, ((java.security.Key) (obj)), new IvParameterSpec(s.getBytes()));
            s = new String(Base64.encode(cipher.doFinal(abyte0), 0));
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new Exception(s);
        }
        return s;
    }

    public static byte[] a(String s, byte abyte0[])
    {
        try
        {
            new SecureRandom();
            Object obj = new DESKeySpec(s.getBytes());
            obj = SecretKeyFactory.getInstance("DES").generateSecret(((java.security.spec.KeySpec) (obj)));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, ((java.security.Key) (obj)), new IvParameterSpec(s.getBytes()));
            s = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new Exception(s);
        }
        return s;
    }

    private static String e(String s, String s1)
    {
        try
        {
            s = new String(a(s, Base64.decode(s1.getBytes(), 0)));
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            return "";
        }
        return s;
    }

    private static String encode(String s, String s1)
    {
        return a(s, s1.getBytes());
    }

    private String getContentType()
    {
        String s1 = l("Content-Type");
        String s;
        if(s1 == null)
        {
            s = null;
        } else
        {
            int i = s1.indexOf(';');
            s = s1;
            if(i != -1)
                return s1.substring(0, i).trim();
        }
        return s;
    }

    private Map getHeaders()
    {
        return o;
    }

    private int getStatusCode()
    {
        return statusCode;
    }

    private Map j()
    {
        return n;
    }

    private String l(String s)
    {
        s = (List)o.get(s);
        if(s == null || s.isEmpty())
            return null;
        else
            return (String)s.get(0);
    }

    final void a(File file)
    {
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        byte abyte0[] = new byte[1024];
        InputStream inputstream = a;
        do
        {
            int i = inputstream.read(abyte0);
            if(i != -1)
            {
                fileoutputstream.write(abyte0, 0, i);
            } else
            {
                a = new FileInputStream(file);
                return;
            }
        } while(true);
    }

    public final void a(StringBuilder stringbuilder)
    {
        Object obj = null;
        char ac[] = l("Content-Type");
        if(ac != null)
        {
            int k = ac.indexOf('=');
            if(k != -1)
                obj = ac.substring(k + 1).trim();
        }
        ac = ((char []) (obj));
        if(obj == null)
            ac = "UTF-8";
        obj = new InputStreamReader(a, ac);
        ac = new char[64];
        do
        {
            int i = ((InputStreamReader) (obj)).read(ac);
            if(i != -1)
                stringbuilder.append(ac, 0, i);
            else
                return;
        } while(true);
    }

    private static String bV = "DES/CBC/PKCS5Padding";
    InputStream a;
    private final Map n;
    private final Map o;
    public final int statusCode;
}
