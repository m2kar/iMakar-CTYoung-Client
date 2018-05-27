// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Hashtable;

public final class StringUtils
{

    private StringUtils()
    {
    }

    public static String guessEncoding(byte abyte0[], Hashtable hashtable)
    {
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int l3;
        if(hashtable != null)
        {
            hashtable = (String)hashtable.get(DecodeHintType.CHARACTER_SET);
            if(hashtable != null)
                return hashtable;
        }
        if(abyte0.length > 3 && abyte0[0] == -17 && abyte0[1] == -69 && abyte0[2] == -65)
            return "UTF-8";
        l3 = abyte0.length;
        k2 = 1;
        l = 1;
        i = 1;
        j = 0;
        i1 = 0;
        j2 = 0;
        l2 = 0;
        i3 = 0;
        i2 = 0;
        j1 = 0;
_L6:
        int k3;
        if(j1 >= l3 || k2 == 0 && l == 0 && i == 0)
            break MISSING_BLOCK_LABEL_583;
        k3 = abyte0[j1] & 0xff;
        if(k3 < 128 || k3 > 191) goto _L2; else goto _L1
_L1:
        int k;
        int k1;
        int l1;
        k1 = i;
        l1 = i3;
        k = j;
        if(j > 0)
        {
            k = j - 1;
            l1 = i3;
            k1 = i;
        }
_L4:
label0:
        {
            if(k3 != 194)
            {
                i3 = l2;
                if(k3 != 195)
                    break label0;
            }
            i3 = l2;
            if(j1 >= l3 - 1)
                break label0;
            i = abyte0[j1 + 1] & 0xff;
            i3 = l2;
            if(i > 191)
                break label0;
            if(k3 != 194 || i < 160)
            {
                i3 = l2;
                if(k3 != 195)
                    break label0;
                i3 = l2;
                if(i < 128)
                    break label0;
            }
            i3 = 1;
        }
        int j3;
label1:
        {
            l2 = k2;
            if(k3 >= 127)
            {
                l2 = k2;
                if(k3 <= 159)
                    l2 = 0;
            }
            j3 = j2;
            if(k3 >= 161)
            {
                j3 = j2;
                if(k3 <= 223)
                {
                    j3 = j2;
                    if(i2 == 0)
                        j3 = j2 + 1;
                }
            }
            i = l;
            if(i2 != 0)
                break label1;
            if((k3 < 240 || k3 > 255) && k3 != 128)
            {
                i = l;
                if(k3 != 160)
                    break label1;
            }
            i = 0;
        }
        if(k3 >= 129 && k3 <= 159 || k3 >= 224 && k3 <= 239)
        {
            if(i2 != 0)
            {
                j = 0;
            } else
            {
                j = 1;
                if(j1 >= abyte0.length - 1)
                {
                    i = 0;
                } else
                {
                    l = abyte0[j1 + 1] & 0xff;
                    if(l < 64 || l > 252)
                        i = 0;
                    else
                        i1++;
                }
            }
        } else
        {
            j = 0;
        }
        j1++;
        k2 = l2;
        l = i;
        i = k1;
        i2 = j;
        j2 = j3;
        l2 = i3;
        i3 = l1;
        j = k;
        continue; /* Loop/switch isn't completed */
_L2:
        if(j > 0)
            i = 0;
        k1 = i;
        l1 = i3;
        k = j;
        if(k3 >= 192)
        {
            k1 = i;
            l1 = i3;
            k = j;
            if(k3 <= 253)
            {
                j3 = 1;
                i3 = k3;
                do
                {
                    k1 = i;
                    l1 = j3;
                    k = j;
                    if((i3 & 0x40) == 0)
                        break;
                    j++;
                    i3 <<= 1;
                } while(true);
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(j > 0)
            i = 0;
        if(l != 0 && ASSUME_SHIFT_JIS)
            return "SJIS";
        if(i != 0 && i3 != 0)
            return "UTF-8";
        if(l != 0 && (i1 >= 3 || j2 * 20 > l3))
            return "SJIS";
        if(l2 == 0 && k2 != 0)
            return "ISO8859_1";
        return PLATFORM_DEFAULT_ENCODING;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = System.getProperty("file.encoding");
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF-8";

    static 
    {
        boolean flag;
        if("SJIS".equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || "EUC_JP".equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING))
            flag = true;
        else
            flag = false;
        ASSUME_SHIFT_JIS = flag;
    }
}
