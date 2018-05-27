// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.d;

import android.util.Base64;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public final class c
{

    public c()
    {
    }

    public c(long l, long l1)
    {
        u = String.valueOf(l);
        v = String.valueOf(l1);
    }

    private static byte[] a(byte abyte0[], String s)
    {
        Object obj = new PKCS8EncodedKeySpec(Base64.decode(s, 0));
        s = KeyFactory.getInstance("RSA");
        obj = s.generatePrivate(((java.security.spec.KeySpec) (obj)));
        s = Cipher.getInstance(s.getAlgorithm());
        s.init(2, ((Key) (obj)));
        return s.doFinal(abyte0);
    }

    private static byte[] b(byte abyte0[], String s)
    {
        Object obj = new X509EncodedKeySpec(Base64.decode(s, 0));
        s = KeyFactory.getInstance("RSA");
        obj = s.generatePublic(((java.security.spec.KeySpec) (obj)));
        s = Cipher.getInstance(s.getAlgorithm());
        s.init(2, ((Key) (obj)));
        return s.doFinal(abyte0);
    }

    private static String c(Map map)
    {
        return Base64.encodeToString(((Key)map.get("RSAPrivateKey")).getEncoded(), 0);
    }

    private static byte[] c(byte abyte0[], String s)
    {
        Object obj = new X509EncodedKeySpec(Base64.decode(s, 0));
        s = KeyFactory.getInstance("RSA");
        obj = s.generatePublic(((java.security.spec.KeySpec) (obj)));
        s = Cipher.getInstance(s.getAlgorithm());
        s.init(1, ((Key) (obj)));
        return s.doFinal(abyte0);
    }

    private static String d(Map map)
    {
        return Base64.encodeToString(((Key)map.get("RSAPublicKey")).getEncoded(), 0);
    }

    private static byte[] d(byte abyte0[], String s)
    {
        Object obj = new PKCS8EncodedKeySpec(Base64.decode(s, 0));
        s = KeyFactory.getInstance("RSA");
        obj = s.generatePrivate(((java.security.spec.KeySpec) (obj)));
        s = Cipher.getInstance(s.getAlgorithm());
        s.init(1, ((Key) (obj)));
        return s.doFinal(abyte0);
    }

    private static Map k()
    {
        Object obj = KeyPairGenerator.getInstance("RSA");
        ((KeyPairGenerator) (obj)).initialize(512);
        Object obj1 = ((KeyPairGenerator) (obj)).generateKeyPair();
        obj = (RSAPublicKey)((KeyPair) (obj1)).getPublic();
        obj1 = (RSAPrivateKey)((KeyPair) (obj1)).getPrivate();
        HashMap hashmap = new HashMap(2);
        hashmap.put("RSAPublicKey", obj);
        hashmap.put("RSAPrivateKey", obj1);
        return hashmap;
    }

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static String cc = "RSA";
    private static String cd = "MD5withRSA";
    private static final String ce = "RSAPrivateKey";
    public final String u;
    public final String v;
}
