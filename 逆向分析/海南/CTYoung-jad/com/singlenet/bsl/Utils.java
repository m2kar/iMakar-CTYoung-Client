// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.singlenet.bsl;


public class Utils
{

    public Utils()
    {
    }

    private static void appendHex(StringBuffer stringbuffer, byte byte0)
    {
        stringbuffer.append("0123456789ABCDEF".charAt(byte0 >> 4 & 0xf)).append("0123456789ABCDEF".charAt(byte0 & 0xf));
    }

    public static byte[] intToBytes(int i)
    {
        byte byte0 = (byte)(i & 0xff);
        byte byte1 = (byte)(i >> 8 & 0xff);
        byte byte2 = (byte)(i >> 16 & 0xff);
        return (new byte[] {
            (byte)(i >> 24 & 0xff), byte2, byte1, byte0
        });
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
}
