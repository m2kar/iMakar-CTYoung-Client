// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader
{

    protected AbstractRSSReader()
    {
        oddCounts = new int[dataCharacterCounters.length / 2];
        evenCounts = new int[dataCharacterCounters.length / 2];
    }

    protected static int count(int ai[])
    {
        int j = 0;
        for(int i = 0; i < ai.length; i++)
            j += ai[i];

        return j;
    }

    protected static void decrement(int ai[], float af[])
    {
        int j = 0;
        float f = af[0];
        for(int i = 1; i < ai.length;)
        {
            float f1 = f;
            if(af[i] < f)
            {
                f1 = af[i];
                j = i;
            }
            i++;
            f = f1;
        }

        ai[j] = ai[j] - 1;
    }

    protected static void increment(int ai[], float af[])
    {
        int j = 0;
        float f = af[0];
        for(int i = 1; i < ai.length;)
        {
            float f1 = f;
            if(af[i] > f)
            {
                f1 = af[i];
                j = i;
            }
            i++;
            f = f1;
        }

        ai[j] = ai[j] + 1;
    }

    protected static boolean isFinderPattern(int ai[])
    {
        int i = ai[0] + ai[1];
        int k = ai[2];
        int i1 = ai[3];
        float f = (float)i / (float)(k + i + i1);
        if(f >= 0.7916667F && f <= 0.8928571F)
        {
            int j = 0x7fffffff;
            int k1 = 0x80000000;
            for(int l = 0; l < ai.length;)
            {
                int l1 = ai[l];
                int j1 = k1;
                if(l1 > k1)
                    j1 = l1;
                int i2 = j;
                if(l1 < j)
                    i2 = l1;
                l++;
                k1 = j1;
                j = i2;
            }

            return k1 < j * 10;
        } else
        {
            return false;
        }
    }

    protected static int parseFinderValue(int ai[], int ai1[][])
        throws NotFoundException
    {
        for(int i = 0; i < ai1.length; i++)
            if(patternMatchVariance(ai, ai1[i], 102) < 51)
                return i;

        throw NotFoundException.getNotFoundInstance();
    }

    private static final int MAX_AVG_VARIANCE = 51;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.8928571F;
    private static final int MAX_INDIVIDUAL_VARIANCE = 102;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667F;
    protected final int dataCharacterCounters[] = new int[8];
    protected final int decodeFinderCounters[] = new int[4];
    protected final int evenCounts[];
    protected final float evenRoundingErrors[] = new float[4];
    protected final int oddCounts[];
    protected final float oddRoundingErrors[] = new float[4];
}
