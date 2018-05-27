// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Crypto
{

    public MD5Crypto()
    {
    }

    public static String md5(String s)
    {
        int j;
        StringBuilder stringbuilder;
        try
        {
            s = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new RuntimeException("Huh, MD5 should be supported?", s);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new RuntimeException("Huh, UTF-8 should be supported?", s);
        }
        stringbuilder = new StringBuilder(s.length * 2);
        j = s.length;
        for(int i = 0; i < j; i++)
        {
            byte byte0 = s[i];
            if((byte0 & 0xff) < 16)
                stringbuilder.append("0");
            stringbuilder.append(Integer.toHexString(byte0 & 0xff));
        }

        return stringbuilder.toString();
    }
}
