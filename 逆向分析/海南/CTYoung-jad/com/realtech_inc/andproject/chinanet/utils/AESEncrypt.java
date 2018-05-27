// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.util.Base64;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncrypt
{

    public AESEncrypt()
    {
    }

    private static void appendHex(StringBuffer stringbuffer, byte byte0)
    {
        stringbuffer.append("0123456789ABCDEF".charAt(byte0 >> 4 & 0xf)).append("0123456789ABCDEF".charAt(byte0 & 0xf));
    }

    public static String encrypt(String s, String s1, boolean flag)
        throws Exception
    {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        keygenerator.init(128, new SecureRandom(s.getBytes()));
        s = encrypt(keygenerator.generateKey().getEncoded(), s1.getBytes());
        if(flag)
            return toHex(s);
        else
            return new String(Base64.encode(s, 0));
    }

    public static String encrypt(byte abyte0[], String s, boolean flag)
        throws Exception
    {
        abyte0 = encrypt(abyte0, s.getBytes());
        if(flag)
            return toHex(abyte0);
        else
            return new String(Base64.encode(abyte0, 0));
    }

    private static byte[] encrypt(byte abyte0[], byte abyte1[])
        throws Exception
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte abyte2[] = new byte[16];
        byte[] _tmp = abyte2;
        abyte2[0] = 0;
        abyte2[1] = 0;
        abyte2[2] = 0;
        abyte2[3] = 0;
        abyte2[4] = 0;
        abyte2[5] = 0;
        abyte2[6] = 0;
        abyte2[7] = 0;
        abyte2[8] = 0;
        abyte2[9] = 0;
        abyte2[10] = 0;
        abyte2[11] = 0;
        abyte2[12] = 0;
        abyte2[13] = 0;
        abyte2[14] = 0;
        abyte2[15] = 0;
        System.out.println((new StringBuilder()).append("bytes to string: ").append(toHex(abyte2)).toString());
        cipher.init(1, abyte0, new IvParameterSpec(abyte2));
        return cipher.doFinal(abyte1);
    }

    public static void main(String args[])
        throws Exception
    {
        args = encrypt(md5("leil"), "123", true);
        System.out.println((new StringBuilder()).append("123:").append(args).toString());
    }

    private static byte[] md5(String s)
        throws Exception
    {
        MessageDigest messagedigest = MessageDigest.getInstance("md5");
        messagedigest.update(s.getBytes("UTF-8"));
        return messagedigest.digest();
    }

    public static byte[] toByte(String s)
    {
        int j = s.length() / 2;
        byte abyte0[] = new byte[j];
        for(int i = 0; i < j; i++)
            abyte0[i] = Integer.valueOf(s.substring(i * 2, i * 2 + 2), 16).byteValue();

        return abyte0;
    }

    public static String toHex(String s)
    {
        return toHex(s.getBytes());
    }

    public static String toHex(byte abyte0[])
    {
        if(abyte0 == null)
            return "";
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        for(int i = 0; i < abyte0.length; i++)
            appendHex(stringbuffer, abyte0[i]);

        return stringbuffer.toString();
    }

    private static final String HEX = "0123456789ABCDEF";
    private static final String TAG = com/realtech_inc/andproject/chinanet/utils/AESEncrypt.getSimpleName();

}
