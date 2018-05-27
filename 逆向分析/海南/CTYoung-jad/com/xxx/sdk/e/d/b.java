// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.d;

import android.util.Base64;
import com.xxx.sdk.e.b.f;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class b
{

    public b()
    {
    }

    private static String a(String s, byte abyte0[])
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

    private static byte[] a(String s, byte abyte0[])
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
            s = new String(f.a(s, Base64.decode(s1.getBytes(), 0)));
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
        return f.a(s, s1.getBytes());
    }

    private static String bV = "DES/CBC/PKCS5Padding";
}
