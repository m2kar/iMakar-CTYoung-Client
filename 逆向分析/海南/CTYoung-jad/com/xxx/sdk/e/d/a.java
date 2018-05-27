// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.d;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
{

    public a()
    {
    }

    private static SecretKeySpec a(String s)
    {
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        s = s.getBytes("UTF-8");
        messagedigest.update(s, 0, s.length);
        return new SecretKeySpec(messagedigest.digest(), "AES");
    }

    private static byte[] a(SecretKeySpec secretkeyspec, byte abyte0[], byte abyte1[])
    {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretkeyspec, new IvParameterSpec(abyte0));
        return cipher.doFinal(abyte1);
    }

    private static void ae()
    {
    }

    private static void af()
    {
    }

    private static String b(byte abyte0[])
    {
        char ac[] = new char[16];
        char[] _tmp = ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'A';
        ac[11] = 'B';
        ac[12] = 'C';
        ac[13] = 'D';
        ac[14] = 'E';
        ac[15] = 'F';
        char ac1[] = new char[abyte0.length << 1];
        for(int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac1[i << 1] = ac[j >>> 4];
            ac1[(i << 1) + 1] = ac[j & 0xf];
        }

        return new String(ac1);
    }

    private static byte[] b(SecretKeySpec secretkeyspec, byte abyte0[], byte abyte1[])
    {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretkeyspec, new IvParameterSpec(abyte0));
        return cipher.doFinal(abyte1);
    }

    private static String f(String s, String s1)
    {
        try
        {
            s = a(s);
            byte abyte0[] = e;
            s1 = s1.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, s, new IvParameterSpec(abyte0));
            s = Base64.encodeToString(cipher.doFinal(s1), 2);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new GeneralSecurityException(s);
        }
        return s;
    }

    private static String g(String s, String s1)
    {
        try
        {
            s = a(s);
            s1 = Base64.decode(s1, 2);
            byte abyte0[] = e;
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, s, new IvParameterSpec(abyte0));
            s = new String(cipher.doFinal(s1), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new GeneralSecurityException(s);
        }
        return s;
    }

    private static final String TAG = "AESCrypt";
    private static final String bZ = "AES/CBC/PKCS7Padding";
    private static final String ca = "UTF-8";
    private static final String cb = "SHA-256";
    private static final byte e[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0
    };
    private static boolean x;

}
