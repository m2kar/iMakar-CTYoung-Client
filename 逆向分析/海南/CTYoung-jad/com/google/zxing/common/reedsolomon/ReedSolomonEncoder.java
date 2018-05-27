// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common.reedsolomon;

import java.util.Vector;

// Referenced classes of package com.google.zxing.common.reedsolomon:
//            GF256, GF256Poly

public final class ReedSolomonEncoder
{

    public ReedSolomonEncoder(GF256 gf256)
    {
        if(!GF256.QR_CODE_FIELD.equals(gf256))
        {
            throw new IllegalArgumentException("Only QR Code is supported at this time");
        } else
        {
            field = gf256;
            cachedGenerators = new Vector();
            cachedGenerators.addElement(new GF256Poly(gf256, new int[] {
                1
            }));
            return;
        }
    }

    private GF256Poly buildGenerator(int i)
    {
        if(i >= cachedGenerators.size())
        {
            GF256Poly gf256poly = (GF256Poly)cachedGenerators.elementAt(cachedGenerators.size() - 1);
            for(int j = cachedGenerators.size(); j <= i; j++)
            {
                gf256poly = gf256poly.multiply(new GF256Poly(field, new int[] {
                    1, field.exp(j - 1)
                }));
                cachedGenerators.addElement(gf256poly);
            }

        }
        return (GF256Poly)cachedGenerators.elementAt(i);
    }

    public void encode(int ai[], int i)
    {
        if(i == 0)
            throw new IllegalArgumentException("No error correction bytes");
        int j = ai.length - i;
        if(j <= 0)
            throw new IllegalArgumentException("No data bytes provided");
        GF256Poly gf256poly = buildGenerator(i);
        int ai2[] = new int[j];
        System.arraycopy(ai, 0, ai2, 0, j);
        int ai1[] = (new GF256Poly(field, ai2)).multiplyByMonomial(i, 1).divide(gf256poly)[1].getCoefficients();
        int k = i - ai1.length;
        for(i = 0; i < k; i++)
            ai[j + i] = 0;

        System.arraycopy(ai1, 0, ai, j + k, ai1.length);
    }

    private final Vector cachedGenerators;
    private final GF256 field;
}
