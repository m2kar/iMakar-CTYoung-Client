// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, EAN13Reader, UPCEANReader

public final class EAN13Writer extends UPCEANWriter
{

    public EAN13Writer()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Hashtable hashtable)
        throws WriterException
    {
        if(barcodeformat != BarcodeFormat.EAN_13)
            throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeformat);
        else
            return super.encode(s, barcodeformat, i, j, hashtable);
    }

    public byte[] encode(String s)
    {
        if(s.length() != 13)
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + s.length());
        int i = Integer.parseInt(s.substring(0, 1));
        int l1 = EAN13Reader.FIRST_DIGIT_ENCODINGS[i];
        byte abyte0[] = new byte[95];
        int l = 0 + appendPattern(abyte0, 0, UPCEANReader.START_END_PATTERN, 1);
        for(int j = 1; j <= 6; j++)
        {
            int k1 = Integer.parseInt(s.substring(j, j + 1));
            int i1 = k1;
            if((l1 >> 6 - j & 1) == 1)
                i1 = k1 + 10;
            l += appendPattern(abyte0, l, UPCEANReader.L_AND_G_PATTERNS[i1], 0);
        }

        l += appendPattern(abyte0, l, UPCEANReader.MIDDLE_PATTERN, 0);
        for(int k = 7; k <= 12; k++)
        {
            int j1 = Integer.parseInt(s.substring(k, k + 1));
            l += appendPattern(abyte0, l, UPCEANReader.L_PATTERNS[j1], 1);
        }

        appendPattern(abyte0, l, UPCEANReader.START_END_PATTERN, 1);
        return abyte0;
    }

    private static final int codeWidth = 95;
}
