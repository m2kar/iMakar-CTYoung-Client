// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, UPCEANReader

public final class EAN8Writer extends UPCEANWriter
{

    public EAN8Writer()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Hashtable hashtable)
        throws WriterException
    {
        if(barcodeformat != BarcodeFormat.EAN_8)
            throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeformat);
        else
            return super.encode(s, barcodeformat, i, j, hashtable);
    }

    public byte[] encode(String s)
    {
        if(s.length() != 8)
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + s.length());
        byte abyte0[] = new byte[67];
        int k = 0 + appendPattern(abyte0, 0, UPCEANReader.START_END_PATTERN, 1);
        for(int i = 0; i <= 3; i++)
        {
            int l = Integer.parseInt(s.substring(i, i + 1));
            k += appendPattern(abyte0, k, UPCEANReader.L_PATTERNS[l], 0);
        }

        k += appendPattern(abyte0, k, UPCEANReader.MIDDLE_PATTERN, 0);
        for(int j = 4; j <= 7; j++)
        {
            int i1 = Integer.parseInt(s.substring(j, j + 1));
            k += appendPattern(abyte0, k, UPCEANReader.L_PATTERNS[i1], 1);
        }

        appendPattern(abyte0, k, UPCEANReader.START_END_PATTERN, 1);
        return abyte0;
    }

    private static final int codeWidth = 67;
}
