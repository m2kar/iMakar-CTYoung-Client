// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

public abstract class UPCEANWriter
    implements Writer
{

    public UPCEANWriter()
    {
    }

    protected static int appendPattern(byte abyte0[], int i, int ai[], int j)
    {
        if(j != 0 && j != 1)
            throw new IllegalArgumentException("startColor must be either 0 or 1, but got: " + j);
        byte byte0 = (byte)j;
        j = 0;
        boolean flag = false;
        int k = i;
        for(i = ((flag) ? 1 : 0); i < ai.length; i++)
        {
            for(int l = 0; l < ai[i]; l++)
            {
                abyte0[k] = byte0;
                k++;
                j++;
            }

            byte0 ^= 1;
        }

        return j;
    }

    private static BitMatrix renderResult(byte abyte0[], int i, int j)
    {
        int k = abyte0.length;
        int i1 = k + (UPCEANReader.START_END_PATTERN.length << 1);
        int j1 = Math.max(i, i1);
        int l = Math.max(1, j);
        i1 = j1 / i1;
        i = (j1 - k * i1) / 2;
        BitMatrix bitmatrix = new BitMatrix(j1, l);
        for(j = 0; j < k;)
        {
            if(abyte0[j] == 1)
                bitmatrix.setRegion(i, 0, i1, l);
            j++;
            i += i1;
        }

        return bitmatrix;
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j)
        throws WriterException
    {
        return encode(s, barcodeformat, i, j, null);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Hashtable hashtable)
        throws WriterException
    {
        if(s == null || s.length() == 0)
            throw new IllegalArgumentException("Found empty contents");
        if(i < 0 || j < 0)
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + j);
        else
            return renderResult(encode(s), i, j);
    }

    public abstract byte[] encode(String s);
}
