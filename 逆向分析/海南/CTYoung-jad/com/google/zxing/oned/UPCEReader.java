// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

public final class UPCEReader extends UPCEANReader
{

    public UPCEReader()
    {
    }

    public static String convertUPCEtoUPCA(String s)
    {
        char c;
        char ac[];
        StringBuffer stringbuffer;
        ac = new char[6];
        s.getChars(1, 7, ac, 0);
        stringbuffer = new StringBuffer(12);
        stringbuffer.append(s.charAt(0));
        c = ac[5];
        c;
        JVM INSTR tableswitch 48 52: default 72
    //                   48 109
    //                   49 109
    //                   50 109
    //                   51 141
    //                   52 167;
           goto _L1 _L2 _L2 _L2 _L3 _L4
_L1:
        stringbuffer.append(ac, 0, 5);
        stringbuffer.append("0000");
        stringbuffer.append(c);
_L6:
        stringbuffer.append(s.charAt(7));
        return stringbuffer.toString();
_L2:
        stringbuffer.append(ac, 0, 2);
        stringbuffer.append(c);
        stringbuffer.append("0000");
        stringbuffer.append(ac, 2, 3);
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuffer.append(ac, 0, 3);
        stringbuffer.append("00000");
        stringbuffer.append(ac, 3, 2);
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append(ac, 0, 4);
        stringbuffer.append("00000");
        stringbuffer.append(ac[4]);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static void determineNumSysAndCheckDigit(StringBuffer stringbuffer, int i)
        throws NotFoundException
    {
        for(int j = 0; j <= 1; j++)
        {
            for(int k = 0; k < 10; k++)
                if(i == NUMSYS_AND_CHECK_DIGIT_PATTERNS[j][k])
                {
                    stringbuffer.insert(0, (char)(j + 48));
                    stringbuffer.append((char)(k + 48));
                    return;
                }

        }

        throw NotFoundException.getNotFoundInstance();
    }

    protected boolean checkChecksum(String s)
        throws FormatException, ChecksumException
    {
        return super.checkChecksum(convertUPCEtoUPCA(s));
    }

    protected int[] decodeEnd(BitArray bitarray, int i)
        throws NotFoundException
    {
        return findGuardPattern(bitarray, i, true, MIDDLE_END_PATTERN);
    }

    protected int decodeMiddle(BitArray bitarray, int ai[], StringBuffer stringbuffer)
        throws NotFoundException
    {
        int ai1[] = decodeMiddleCounters;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int j1 = bitarray.getSize();
        int k = ai[1];
        int j = 0;
        for(int i = 0; i < 6 && k < j1;)
        {
            int k1 = decodeDigit(bitarray, ai1, k, L_AND_G_PATTERNS);
            stringbuffer.append((char)(k1 % 10 + 48));
            for(int l = 0; l < ai1.length; l++)
                k += ai1[l];

            int i1 = j;
            if(k1 >= 10)
                i1 = j | 1 << 5 - i;
            i++;
            j = i1;
        }

        determineNumSysAndCheckDigit(stringbuffer, j);
        return k;
    }

    BarcodeFormat getBarcodeFormat()
    {
        return BarcodeFormat.UPC_E;
    }

    private static final int MIDDLE_END_PATTERN[] = {
        1, 1, 1, 1, 1, 1
    };
    private static final int NUMSYS_AND_CHECK_DIGIT_PATTERNS[][];
    private final int decodeMiddleCounters[] = new int[4];

    static 
    {
        int ai[] = {
            7, 11, 13, 14, 19, 25, 28, 21, 22, 26
        };
        NUMSYS_AND_CHECK_DIGIT_PATTERNS = (new int[][] {
            new int[] {
                56, 52, 50, 49, 44, 38, 35, 42, 41, 37
            }, ai
        });
    }
}
