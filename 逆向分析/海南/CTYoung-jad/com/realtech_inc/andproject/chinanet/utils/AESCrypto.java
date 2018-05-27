// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import java.security.SecureRandom;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class AESCrypto extends Activity
{

    public AESCrypto()
    {
    }

    private static void appendHex(StringBuffer stringbuffer, byte byte0)
    {
        stringbuffer.append("0123456789ABCDEF".charAt(byte0 >> 4 & 0xf)).append("0123456789ABCDEF".charAt(byte0 & 0xf));
    }

    public static String decrypt(String s, String s1)
        throws Exception
    {
        return new String(decrypt(getRawKey(s.getBytes()), toByte(s1)));
    }

    private static byte[] decrypt(byte abyte0[], byte abyte1[])
        throws Exception
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, abyte0);
        return cipher.doFinal(abyte1);
    }

    public static String encrypt(String s, String s1)
        throws Exception
    {
        return toHex(encrypt(getRawKey(s.getBytes()), s1.getBytes()));
    }

    private static byte[] encrypt(byte abyte0[], byte abyte1[])
        throws Exception
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, abyte0);
        return cipher.doFinal(abyte1);
    }

    public static String fromHex(String s)
    {
        return new String(toByte(s));
    }

    private static byte[] getRawKey(byte abyte0[])
        throws Exception
    {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecureRandom securerandom = SecureRandom.getInstance("SHA1PRNG");
        securerandom.setSeed(abyte0);
        keygenerator.init(128, securerandom);
        return keygenerator.generateKey().getEncoded();
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            bundle = encrypt("a", "\u6211\u662F\u4E00\u4E2A\u5C0F\u7537\u5B69");
            Log.i("\u52A0\u5BC6\u7ED3\u679C\u4E3A ", bundle);
            Log.i("\u89E3\u5BC6\u7ED3\u679C", decrypt("a", bundle));
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Bundle bundle)
        {
            bundle.printStackTrace();
        }
    }

    private static final String HEX = "0123456789ABCDEF";
}
