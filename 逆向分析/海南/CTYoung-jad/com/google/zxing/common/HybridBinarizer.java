// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common;

import com.google.zxing.*;
import java.lang.reflect.Array;

// Referenced classes of package com.google.zxing.common:
//            GlobalHistogramBinarizer, BitMatrix

public final class HybridBinarizer extends GlobalHistogramBinarizer
{

    public HybridBinarizer(LuminanceSource luminancesource)
    {
        super(luminancesource);
        matrix = null;
    }

    private void binarizeEntireImage()
        throws NotFoundException
    {
label0:
        {
            if(matrix == null)
            {
                LuminanceSource luminancesource = getLuminanceSource();
                if(luminancesource.getWidth() < 40 || luminancesource.getHeight() < 40)
                    break label0;
                byte abyte0[] = luminancesource.getMatrix();
                int l = luminancesource.getWidth();
                int i1 = luminancesource.getHeight();
                int j = l >> 3;
                int i = j;
                if((l & 7) != 0)
                    i = j + 1;
                int k = i1 >> 3;
                j = k;
                if((i1 & 7) != 0)
                    j = k + 1;
                int ai[][] = calculateBlackPoints(abyte0, i, j, l, i1);
                matrix = new BitMatrix(l, i1);
                calculateThresholdForBlock(abyte0, i, j, l, i1, ai, matrix);
            }
            return;
        }
        matrix = super.getBlackMatrix();
    }

    private static int[][] calculateBlackPoints(byte abyte0[], int i, int j, int k, int l)
    {
        int ai[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            j, i
        });
        for(int k1 = 0; k1 < j; k1++)
        {
            int i1 = k1 << 3;
            int l1 = i1;
            if(i1 + 8 >= l)
                l1 = l - 8;
            int i2 = 0;
            while(i2 < i) 
            {
                int j2 = i2 << 3;
                int j1 = j2;
                if(j2 + 8 >= k)
                    j1 = k - 8;
                int k3 = 0;
                int j3 = 255;
                int i3 = 0;
                for(int k2 = 0; k2 < 8; k2++)
                {
                    for(int l2 = 0; l2 < 8;)
                    {
                        int l3 = abyte0[(l1 + k2) * k + j1 + l2] & 0xff;
                        int i4 = k3 + l3;
                        k3 = j3;
                        if(l3 < j3)
                            k3 = l3;
                        j3 = i3;
                        if(l3 > i3)
                            j3 = l3;
                        l2++;
                        i3 = j3;
                        j3 = k3;
                        k3 = i4;
                    }

                }

                if(i3 - j3 > 24)
                    j1 = k3 >> 6;
                else
                if(i3 == 0)
                    j1 = 1;
                else
                    j1 = j3 >> 1;
                ai[k1][i2] = j1;
                i2++;
            }
        }

        return ai;
    }

    private static void calculateThresholdForBlock(byte abyte0[], int i, int j, int k, int l, int ai[][], BitMatrix bitmatrix)
    {
        for(int i1 = 0; i1 < j; i1++)
        {
            int j1 = i1 << 3;
            int i2 = j1;
            if(j1 + 8 >= l)
                i2 = l - 8;
            for(int k1 = 0; k1 < i; k1++)
            {
                int l1 = k1 << 3;
                int j2 = l1;
                if(l1 + 8 >= k)
                    j2 = k - 8;
                int k2;
                int i3;
                if(k1 > 1)
                    l1 = k1;
                else
                    l1 = 2;
                if(l1 < i - 2)
                    k2 = l1;
                else
                    k2 = i - 3;
                if(i1 > 1)
                    l1 = i1;
                else
                    l1 = 2;
                if(l1 >= j - 2)
                    l1 = j - 3;
                i3 = 0;
                for(int l2 = -2; l2 <= 2; l2++)
                {
                    int ai1[] = ai[l1 + l2];
                    i3 = i3 + ai1[k2 - 2] + ai1[k2 - 1] + ai1[k2] + ai1[k2 + 1] + ai1[k2 + 2];
                }

                threshold8x8Block(abyte0, j2, i2, i3 / 25, k, bitmatrix);
            }

        }

    }

    private static void threshold8x8Block(byte abyte0[], int i, int j, int k, int l, BitMatrix bitmatrix)
    {
        for(int i1 = 0; i1 < 8; i1++)
        {
            for(int j1 = 0; j1 < 8; j1++)
                if((abyte0[(j + i1) * l + i + j1] & 0xff) < k)
                    bitmatrix.set(i + j1, j + i1);

        }

    }

    public Binarizer createBinarizer(LuminanceSource luminancesource)
    {
        return new HybridBinarizer(luminancesource);
    }

    public BitMatrix getBlackMatrix()
        throws NotFoundException
    {
        binarizeEntireImage();
        return matrix;
    }

    private static final int MINIMUM_DIMENSION = 40;
    private BitMatrix matrix;
}
