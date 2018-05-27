// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, Code128Reader

public final class Code128Writer extends UPCEANWriter
{

    public Code128Writer()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Hashtable hashtable)
        throws WriterException
    {
        if(barcodeformat != BarcodeFormat.CODE_128)
            throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeformat);
        else
            return super.encode(s, barcodeformat, i, j, hashtable);
    }

    public byte[] encode(String s)
    {
        int k1 = s.length();
        if(k1 > 80)
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + k1);
        int l = 35;
        for(int i = 0; i < k1; i++)
        {
            int ai[] = Code128Reader.CODE_PATTERNS[s.charAt(i) - 32];
            for(int i1 = 0; i1 < ai.length; i1++)
                l += ai[i1];

        }

        byte abyte0[] = new byte[l];
        l = appendPattern(abyte0, 0, Code128Reader.CODE_PATTERNS[104], 1);
        int j1 = 104;
        for(int j = 0; j < k1; j++)
        {
            j1 += (s.charAt(j) - 32) * (j + 1);
            l += appendPattern(abyte0, l, Code128Reader.CODE_PATTERNS[s.charAt(j) - 32], 1);
        }

        int k = l + appendPattern(abyte0, l, Code128Reader.CODE_PATTERNS[j1 % 103], 1);
        appendPattern(abyte0, k, Code128Reader.CODE_PATTERNS[106], 1);
        return abyte0;
    }
}
