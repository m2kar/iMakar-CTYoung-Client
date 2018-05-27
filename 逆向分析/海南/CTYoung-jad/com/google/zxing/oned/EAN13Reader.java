// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

public final class EAN13Reader extends UPCEANReader
{

    public EAN13Reader()
    {
    }

    private static void determineFirstDigit(StringBuffer stringbuffer, int i)
        throws NotFoundException
    {
        for(int j = 0; j < 10; j++)
            if(i == FIRST_DIGIT_ENCODINGS[j])
            {
                stringbuffer.insert(0, (char)(j + 48));
                return;
            }

        throw NotFoundException.getNotFoundInstance();
    }

    protected int decodeMiddle(BitArray bitarray, int ai[], StringBuffer stringbuffer)
        throws NotFoundException
    {
        int ai1[] = decodeMiddleCounters;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int l1 = bitarray.getSize();
        int l = ai[1];
        int k = 0;
        for(int i = 0; i < 6 && l < l1;)
        {
            int i2 = decodeDigit(bitarray, ai1, l, L_AND_G_PATTERNS);
            stringbuffer.append((char)(i2 % 10 + 48));
            for(int j1 = 0; j1 < ai1.length; j1++)
                l += ai1[j1];

            int k1 = k;
            if(i2 >= 10)
                k1 = k | 1 << 5 - i;
            i++;
            k = k1;
        }

        determineFirstDigit(stringbuffer, k);
        k = findGuardPattern(bitarray, l, true, MIDDLE_PATTERN)[1];
        for(int j = 0; j < 6 && k < l1; j++)
        {
            stringbuffer.append((char)(decodeDigit(bitarray, ai1, k, L_PATTERNS) + 48));
            for(int i1 = 0; i1 < ai1.length; i1++)
                k += ai1[i1];

        }

        return k;
    }

    BarcodeFormat getBarcodeFormat()
    {
        return BarcodeFormat.EAN_13;
    }

    static final int FIRST_DIGIT_ENCODINGS[] = {
        0, 11, 13, 14, 19, 25, 28, 21, 22, 26
    };
    private final int decodeMiddleCounters[] = new int[4];

}
