// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

abstract class DataMask
{
    private static class DataMask000 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            return (i + j & 1) == 0;
        }

        private DataMask000()
        {
        }

    }

    private static class DataMask001 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            return (i & 1) == 0;
        }

        private DataMask001()
        {
        }

    }

    private static class DataMask010 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            return j % 3 == 0;
        }

        private DataMask010()
        {
        }

    }

    private static class DataMask011 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            return (i + j) % 3 == 0;
        }

        private DataMask011()
        {
        }

    }

    private static class DataMask100 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            return ((i >>> 1) + j / 3 & 1) == 0;
        }

        private DataMask100()
        {
        }

    }

    private static class DataMask101 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            i *= j;
            return (i & 1) + i % 3 == 0;
        }

        private DataMask101()
        {
        }

    }

    private static class DataMask110 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            i *= j;
            return ((i & 1) + i % 3 & 1) == 0;
        }

        private DataMask110()
        {
        }

    }

    private static class DataMask111 extends DataMask
    {

        boolean isMasked(int i, int j)
        {
            return ((i + j & 1) + (i * j) % 3 & 1) == 0;
        }

        private DataMask111()
        {
        }

    }


    private DataMask()
    {
    }


    static DataMask forReference(int i)
    {
        if(i < 0 || i > 7)
            throw new IllegalArgumentException();
        else
            return DATA_MASKS[i];
    }

    abstract boolean isMasked(int i, int j);

    final void unmaskBitMatrix(BitMatrix bitmatrix, int i)
    {
        for(int j = 0; j < i; j++)
        {
            for(int k = 0; k < i; k++)
                if(isMasked(j, k))
                    bitmatrix.flip(k, j);

        }

    }

    private static final DataMask DATA_MASKS[] = {
        new DataMask000(), new DataMask001(), new DataMask010(), new DataMask011(), new DataMask100(), new DataMask101(), new DataMask110(), new DataMask111()
    };

}
