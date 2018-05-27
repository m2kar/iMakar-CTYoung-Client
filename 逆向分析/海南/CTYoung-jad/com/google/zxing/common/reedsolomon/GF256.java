// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common.reedsolomon;


// Referenced classes of package com.google.zxing.common.reedsolomon:
//            GF256Poly

public final class GF256
{

    private GF256(int i)
    {
        int j = 1;
        for(int k = 0; k < 256; k++)
        {
            expTable[k] = j;
            int l = j << 1;
            j = l;
            if(l >= 256)
                j = l ^ i;
        }

        for(i = 0; i < 255; i++)
            logTable[expTable[i]] = i;

    }

    static int addOrSubtract(int i, int j)
    {
        return i ^ j;
    }

    GF256Poly buildMonomial(int i, int j)
    {
        if(i < 0)
            throw new IllegalArgumentException();
        if(j == 0)
        {
            return zero;
        } else
        {
            int ai[] = new int[i + 1];
            ai[0] = j;
            return new GF256Poly(this, ai);
        }
    }

    int exp(int i)
    {
        return expTable[i];
    }

    GF256Poly getOne()
    {
        return one;
    }

    GF256Poly getZero()
    {
        return zero;
    }

    int inverse(int i)
    {
        if(i == 0)
            throw new ArithmeticException();
        else
            return expTable[255 - logTable[i]];
    }

    int log(int i)
    {
        if(i == 0)
            throw new IllegalArgumentException();
        else
            return logTable[i];
    }

    int multiply(int i, int j)
    {
        if(i == 0 || j == 0)
        {
            return 0;
        } else
        {
            i = logTable[i] + logTable[j];
            return expTable[(i & 0xff) + (i >>> 8)];
        }
    }

    public static final GF256 DATA_MATRIX_FIELD = new GF256(301);
    public static final GF256 QR_CODE_FIELD = new GF256(285);
    private final int expTable[] = new int[256];
    private final int logTable[] = new int[256];
    private final GF256Poly one = new GF256Poly(this, new int[] {
        1
    });
    private final GF256Poly zero = new GF256Poly(this, new int[] {
        0
    });

}
