// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import java.io.PrintStream;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils
{

    public AESUtils()
    {
    }

    public static String aes128Decrypt(String s, String s1, String s2)
        throws Exception
    {
        s1 = initkey(s1);
        return new String(decrypt(hexStringToByte(s), s1, s2), "UTF-8");
    }

    public static String aes128Encrypt(String s, String s1, String s2)
        throws Exception
    {
        s1 = initkey(s1);
        return bytesToHexString(encrypt(s.getBytes(), s1, s2));
    }

    public static final String bytesToHexString(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        for(int i = 0; i < abyte0.length; i++)
        {
            String s = Integer.toHexString(abyte0[i] & 0xff);
            if(s.length() < 2)
                stringbuffer.append(0);
            stringbuffer.append(s.toUpperCase());
        }

        return stringbuffer.toString();
    }

    public static byte[] decrypt(byte abyte0[], byte abyte1[], String s)
        throws Exception
    {
        abyte1 = toKey(abyte1);
        if(s.contains("PKCS7Padding"))
        {
            s = Cipher.getInstance(s, "BC");
            s.init(2, abyte1, IV);
            return s.doFinal(abyte0);
        } else
        {
            s = Cipher.getInstance(s);
            s.init(2, abyte1, IV);
            return s.doFinal(abyte0);
        }
    }

    public static byte[] encrypt(byte abyte0[], byte abyte1[], String s)
        throws Exception
    {
        abyte1 = toKey(abyte1);
        System.out.println("PKCS5Padding:");
        s = Cipher.getInstance(s);
        s.init(1, abyte1, IV);
        return s.doFinal(abyte0);
    }

    public static byte[] hexStringToByte(String s)
    {
        int j = s.length() / 2;
        byte abyte0[] = new byte[j];
        s = s.toCharArray();
        for(int i = 0; i < j; i++)
        {
            int k = i * 2;
            abyte0[i] = (byte)(toByte(s[k]) << 4 | toByte(s[k + 1]));
        }

        return abyte0;
    }

    public static byte[] initkey(String s)
        throws Exception
    {
        MessageDigest messagedigest = MessageDigest.getInstance("md5");
        messagedigest.update(s.getBytes("UTF-8"));
        return messagedigest.digest();
    }

    private static byte toByte(char c)
    {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    public static Key toKey(byte abyte0[])
        throws Exception
    {
        return new SecretKeySpec(abyte0, "AES");
    }

    private static IvParameterSpec IV;
    public static final String KEY_ALGORITHM = "AES";
    private static byte iv[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0
    };

    static 
    {
        IV = new IvParameterSpec(iv);
    }
}
