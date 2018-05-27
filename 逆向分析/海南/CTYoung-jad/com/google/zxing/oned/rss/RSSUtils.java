// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss;


public final class RSSUtils
{

    private RSSUtils()
    {
    }

    static int combins(int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if(i - j > j)
        {
            k = j;
            l = i - j;
        } else
        {
            k = i - j;
            l = j;
        }
        j = 1;
        j1 = 1;
        i1 = i;
        i = j1;
        do
        {
            j1 = i;
            k1 = j;
            if(i1 <= l)
                break;
            k1 = j * i1;
            j1 = i;
            j = k1;
            if(i <= k)
            {
                j = k1 / i;
                j1 = i + 1;
            }
            i1--;
            i = j1;
        } while(true);
        for(; j1 <= k; j1++)
            k1 /= j1;

        return k1;
    }

    static int[] elements(int ai[], int i, int j)
    {
        int ai1[] = new int[ai.length + 2];
        int k1 = j << 1;
        ai1[0] = 1;
        j = 10;
        int j1 = 1;
        for(int k = 1; k < k1 - 2;)
        {
            ai1[k] = ai[k - 1] - ai1[k - 1];
            ai1[k + 1] = ai[k] - ai1[k];
            j1 += ai1[k] + ai1[k + 1];
            int i1 = j;
            if(ai1[k] < j)
                i1 = ai1[k];
            k += 2;
            j = i1;
        }

        ai1[k1 - 1] = i - j1;
        i = j;
        if(ai1[k1 - 1] < j)
            i = ai1[k1 - 1];
        if(i > 1)
            for(j = 0; j < k1; j += 2)
            {
                ai1[j] = ai1[j] + (i - 1);
                int l = j + 1;
                ai1[l] = ai1[l] - (i - 1);
            }

        return ai1;
    }

    public static int getRSSvalue(int ai[], int i, boolean flag)
    {
        int l2 = ai.length;
        int j = 0;
        for(int l = 0; l < l2; l++)
            j += ai[l];

        int i2 = 0;
        int i1 = 0;
        int k1 = 0;
        int l1 = j;
        do
        {
            if(k1 >= l2 - 1)
                break;
            int j2 = 1;
            int k = i1 | 1 << k1;
            while(j2 < ai[k1]) 
            {
                int j1 = combins(l1 - j2 - 1, l2 - k1 - 2);
                i1 = j1;
                if(flag)
                {
                    i1 = j1;
                    if(k == 0)
                    {
                        i1 = j1;
                        if(l1 - j2 - (l2 - k1 - 1) >= l2 - k1 - 1)
                            i1 = j1 - combins(l1 - j2 - (l2 - k1), l2 - k1 - 2);
                    }
                }
                if(l2 - k1 - 1 > 1)
                {
                    int k2 = 0;
                    for(j1 = l1 - j2 - (l2 - k1 - 2); j1 > i; j1--)
                        k2 += combins(l1 - j2 - j1 - 1, l2 - k1 - 3);

                    j1 = i1 - (l2 - 1 - k1) * k2;
                } else
                {
                    j1 = i1;
                    if(l1 - j2 > i)
                        j1 = i1 - 1;
                }
                i2 += j1;
                j2++;
                k &= ~(1 << k1);
            }
            l1 -= j2;
            k1++;
            i1 = k;
        } while(true);
        return i2;
    }

    static int[] getRSSwidths(int i, int j, int k, int l, boolean flag)
    {
        int l1;
        int i2;
        int ai[];
        ai = new int[k];
        boolean flag1 = false;
        i2 = 0;
        l1 = j;
        j = ((flag1) ? 1 : 0);
_L9:
        if(i2 >= k - 1) goto _L2; else goto _L1
_L1:
        int j2;
        int k2;
        j |= 1 << i2;
        j2 = 1;
        k2 = i;
        i = j;
_L7:
        int i1 = combins(l1 - j2 - 1, k - i2 - 2);
        j = i1;
        if(flag)
        {
            j = i1;
            if(i == 0)
            {
                j = i1;
                if(l1 - j2 - (k - i2 - 1) >= k - i2 - 1)
                    j = i1 - combins(l1 - j2 - (k - i2), k - i2 - 2);
            }
        }
        if(k - i2 - 1 <= 1) goto _L4; else goto _L3
_L3:
        int k1;
        int l2 = 0;
        for(int j1 = l1 - j2 - (k - i2 - 2); j1 > l; j1--)
            l2 += combins(l1 - j2 - j1 - 1, k - i2 - 3);

        k1 = j - (k - 1 - i2) * l2;
_L6:
        k2 -= k1;
        if(k2 >= 0)
            break; /* Loop/switch isn't completed */
        k1 = k2 + k1;
        l1 -= j2;
        ai[i2] = j2;
        i2++;
        j = i;
        i = k1;
        continue; /* Loop/switch isn't completed */
_L4:
        k1 = j;
        if(l1 - j2 > l)
            k1 = j - 1;
        if(true) goto _L6; else goto _L5
_L5:
        j2++;
        i &= ~(1 << i2);
        if(true) goto _L7; else goto _L2
_L2:
        ai[i2] = l1;
        return ai;
        if(true) goto _L9; else goto _L8
_L8:
    }
}
