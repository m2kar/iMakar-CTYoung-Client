// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, ITFReader

public final class ITFWriter extends UPCEANWriter
{

    public ITFWriter()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Hashtable hashtable)
        throws WriterException
    {
        if(barcodeformat != BarcodeFormat.ITF)
            throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeformat);
        else
            return super.encode(s, barcodeformat, i, j, hashtable);
    }

    public byte[] encode(String s)
    {
        int l = s.length();
        if(l > 80)
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + l);
        byte abyte0[] = new byte[l * 9 + 9];
        int j = appendPattern(abyte0, 0, new int[] {
            1, 1, 1, 1
        }, 1);
        for(int i = 0; i < l; i += 2)
        {
            int i1 = Character.digit(s.charAt(i), 10);
            int j1 = Character.digit(s.charAt(i + 1), 10);
            int ai[] = new int[18];
            for(int k = 0; k < 5; k++)
            {
                ai[k << 1] = ITFReader.PATTERNS[i1][k];
                ai[(k << 1) + 1] = ITFReader.PATTERNS[j1][k];
            }

            j += appendPattern(abyte0, j, ai, 1);
        }

        appendPattern(abyte0, j, new int[] {
            3, 1, 1
        }, 1);
        return abyte0;
    }
}
