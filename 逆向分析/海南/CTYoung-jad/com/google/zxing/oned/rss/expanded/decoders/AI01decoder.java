// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            AbstractExpandedDecoder, GeneralAppIdDecoder

abstract class AI01decoder extends AbstractExpandedDecoder
{

    AI01decoder(BitArray bitarray)
    {
        super(bitarray);
    }

    private static void appendCheckDigit(StringBuffer stringbuffer, int i)
    {
        int l = 0;
        for(int j = 0; j < 13; j++)
        {
            int j1 = stringbuffer.charAt(j + i) - 48;
            int i1 = j1;
            if((j & 1) == 0)
                i1 = j1 * 3;
            l += i1;
        }

        int k = 10 - l % 10;
        i = k;
        if(k == 10)
            i = 0;
        stringbuffer.append(i);
    }

    protected void encodeCompressedGtin(StringBuffer stringbuffer, int i)
    {
        stringbuffer.append("(01)");
        int j = stringbuffer.length();
        stringbuffer.append('9');
        encodeCompressedGtinWithoutAI(stringbuffer, i, j);
    }

    protected void encodeCompressedGtinWithoutAI(StringBuffer stringbuffer, int i, int j)
    {
        for(int k = 0; k < 4; k++)
        {
            int l = generalDecoder.extractNumericValueFromBitArray(k * 10 + i, 10);
            if(l / 100 == 0)
                stringbuffer.append('0');
            if(l / 10 == 0)
                stringbuffer.append('0');
            stringbuffer.append(l);
        }

        appendCheckDigit(stringbuffer, j);
    }

    protected static final int gtinSize = 40;
}
