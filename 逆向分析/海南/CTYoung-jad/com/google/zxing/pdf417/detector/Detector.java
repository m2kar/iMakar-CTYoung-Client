// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.pdf417.detector;

import com.google.zxing.*;
import com.google.zxing.common.*;
import java.util.Hashtable;

public final class Detector
{

    public Detector(BinaryBitmap binarybitmap)
    {
        image = binarybitmap;
    }

    private static int computeDimension(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, float f)
    {
        return (((round(ResultPoint.distance(resultpoint, resultpoint1) / f) + round(ResultPoint.distance(resultpoint2, resultpoint3) / f) >> 1) + 8) / 17) * 17;
    }

    private static float computeModuleWidth(ResultPoint aresultpoint[])
    {
        return ((ResultPoint.distance(aresultpoint[0], aresultpoint[4]) + ResultPoint.distance(aresultpoint[1], aresultpoint[5])) / 34F + (ResultPoint.distance(aresultpoint[6], aresultpoint[2]) + ResultPoint.distance(aresultpoint[7], aresultpoint[3])) / 36F) / 2.0F;
    }

    private static void correctCodeWordVertices(ResultPoint aresultpoint[], boolean flag)
    {
        float f;
        float f2 = aresultpoint[4].getY() - aresultpoint[6].getY();
        f = f2;
        if(flag)
            f = -f2;
        if(f <= 2.0F) goto _L2; else goto _L1
_L1:
        f = aresultpoint[4].getX();
        float f3 = aresultpoint[0].getX();
        float f8 = aresultpoint[6].getX();
        float f12 = aresultpoint[0].getX();
        f = ((f - f3) * (aresultpoint[6].getY() - aresultpoint[0].getY())) / (f8 - f12);
        aresultpoint[4] = new ResultPoint(aresultpoint[4].getX(), aresultpoint[4].getY() + f);
_L8:
        float f4 = aresultpoint[7].getY() - aresultpoint[5].getY();
        f = f4;
        if(flag)
            f = -f4;
        if(f <= 2.0F) goto _L4; else goto _L3
_L3:
        f = aresultpoint[5].getX();
        float f5 = aresultpoint[1].getX();
        float f9 = aresultpoint[7].getX();
        float f13 = aresultpoint[1].getX();
        f = ((f - f5) * (aresultpoint[7].getY() - aresultpoint[1].getY())) / (f9 - f13);
        aresultpoint[5] = new ResultPoint(aresultpoint[5].getX(), aresultpoint[5].getY() + f);
_L6:
        return;
_L2:
        if(-f > 2.0F)
        {
            f = aresultpoint[2].getX();
            float f6 = aresultpoint[6].getX();
            float f10 = aresultpoint[2].getX();
            float f14 = aresultpoint[4].getX();
            f = ((f - f6) * (aresultpoint[2].getY() - aresultpoint[4].getY())) / (f10 - f14);
            aresultpoint[6] = new ResultPoint(aresultpoint[6].getX(), aresultpoint[6].getY() - f);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(-f <= 2.0F) goto _L6; else goto _L5
_L5:
        float f1 = aresultpoint[3].getX();
        float f7 = aresultpoint[7].getX();
        float f11 = aresultpoint[3].getX();
        float f15 = aresultpoint[5].getX();
        f1 = ((f1 - f7) * (aresultpoint[3].getY() - aresultpoint[5].getY())) / (f11 - f15);
        aresultpoint[7] = new ResultPoint(aresultpoint[7].getX(), aresultpoint[7].getY() - f1);
        return;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static int[] findGuardPattern(BitMatrix bitmatrix, int i, int j, int k, boolean flag, int ai[])
    {
        int l1 = ai.length;
        int ai1[] = new int[l1];
        int i1 = 0;
        int l = i;
        int j1 = i;
        while(j1 < i + k) 
        {
            if(bitmatrix.get(j1, j) ^ flag)
            {
                ai1[i1] = ai1[i1] + 1;
            } else
            {
                if(i1 == l1 - 1)
                {
                    if(patternMatchVariance(ai1, ai, 204) < 107)
                        return (new int[] {
                            l, j1
                        });
                    int k1 = l + (ai1[0] + ai1[1]);
                    for(l = 2; l < l1; l++)
                        ai1[l - 2] = ai1[l];

                    ai1[l1 - 2] = 0;
                    ai1[l1 - 1] = 0;
                    i1--;
                    l = k1;
                } else
                {
                    i1++;
                }
                ai1[i1] = 1;
                if(!flag)
                    flag = true;
                else
                    flag = false;
            }
            j1++;
        }
        return null;
    }

    private static ResultPoint[] findVertices(BitMatrix bitmatrix)
    {
        int i;
        boolean flag;
        int k;
        int l;
        ResultPoint aresultpoint[];
        l = bitmatrix.getHeight();
        k = bitmatrix.getWidth();
        aresultpoint = new ResultPoint[8];
        flag = false;
        i = 0;
_L17:
        int j = ((flag) ? 1 : 0);
        if(i >= l) goto _L2; else goto _L1
_L1:
        int ai[] = findGuardPattern(bitmatrix, 0, i, k, false, START_PATTERN);
        if(ai == null) goto _L4; else goto _L3
_L3:
        aresultpoint[0] = new ResultPoint(ai[0], i);
        aresultpoint[4] = new ResultPoint(ai[1], i);
        j = 1;
_L2:
        i = j;
        if(!j) goto _L6; else goto _L5
_L5:
        flag = false;
        j = l - 1;
_L18:
        i = ((flag) ? 1 : 0);
        if(j <= 0) goto _L6; else goto _L7
_L7:
        ai = findGuardPattern(bitmatrix, 0, j, k, false, START_PATTERN);
        if(ai == null) goto _L9; else goto _L8
_L8:
        aresultpoint[1] = new ResultPoint(ai[0], j);
        aresultpoint[5] = new ResultPoint(ai[1], j);
        i = 1;
_L6:
        j = i;
        if(i == 0) goto _L11; else goto _L10
_L10:
        flag = false;
        i = 0;
_L19:
        j = ((flag) ? 1 : 0);
        if(i >= l) goto _L11; else goto _L12
_L12:
        ai = findGuardPattern(bitmatrix, 0, i, k, false, STOP_PATTERN);
        if(ai == null) goto _L14; else goto _L13
_L13:
        aresultpoint[2] = new ResultPoint(ai[1], i);
        aresultpoint[6] = new ResultPoint(ai[0], i);
        j = 1;
_L11:
        i = j;
        if(j == 0) goto _L16; else goto _L15
_L15:
        flag = false;
        j = l - 1;
_L20:
        i = ((flag) ? 1 : 0);
        if(j > 0)
        {
            int ai1[] = findGuardPattern(bitmatrix, 0, j, k, false, STOP_PATTERN);
            if(ai1 == null)
                break MISSING_BLOCK_LABEL_345;
            aresultpoint[3] = new ResultPoint(ai1[1], j);
            aresultpoint[7] = new ResultPoint(ai1[0], j);
            i = 1;
        }
_L16:
        if(i != 0)
            return aresultpoint;
        else
            return null;
_L4:
        i++;
          goto _L17
_L9:
        j--;
          goto _L18
_L14:
        i++;
          goto _L19
        j--;
          goto _L20
    }

    private static ResultPoint[] findVertices180(BitMatrix bitmatrix)
    {
        int i;
        boolean flag;
        int k;
        int l;
        ResultPoint aresultpoint[];
        k = bitmatrix.getHeight();
        l = bitmatrix.getWidth() >> 1;
        aresultpoint = new ResultPoint[8];
        flag = false;
        i = k - 1;
_L17:
        int j = ((flag) ? 1 : 0);
        if(i <= 0) goto _L2; else goto _L1
_L1:
        int ai[] = findGuardPattern(bitmatrix, l, i, l, true, START_PATTERN_REVERSE);
        if(ai == null) goto _L4; else goto _L3
_L3:
        aresultpoint[0] = new ResultPoint(ai[1], i);
        aresultpoint[4] = new ResultPoint(ai[0], i);
        j = 1;
_L2:
        i = j;
        if(!j) goto _L6; else goto _L5
_L5:
        flag = false;
        j = 0;
_L18:
        i = ((flag) ? 1 : 0);
        if(j >= k) goto _L6; else goto _L7
_L7:
        ai = findGuardPattern(bitmatrix, l, j, l, true, START_PATTERN_REVERSE);
        if(ai == null) goto _L9; else goto _L8
_L8:
        aresultpoint[1] = new ResultPoint(ai[1], j);
        aresultpoint[5] = new ResultPoint(ai[0], j);
        i = 1;
_L6:
        j = i;
        if(i == 0) goto _L11; else goto _L10
_L10:
        flag = false;
        i = k - 1;
_L19:
        j = ((flag) ? 1 : 0);
        if(i <= 0) goto _L11; else goto _L12
_L12:
        ai = findGuardPattern(bitmatrix, 0, i, l, false, STOP_PATTERN_REVERSE);
        if(ai == null) goto _L14; else goto _L13
_L13:
        aresultpoint[2] = new ResultPoint(ai[0], i);
        aresultpoint[6] = new ResultPoint(ai[1], i);
        j = 1;
_L11:
        i = j;
        if(j == 0) goto _L16; else goto _L15
_L15:
        flag = false;
        j = 0;
_L20:
        i = ((flag) ? 1 : 0);
        if(j < k)
        {
            int ai1[] = findGuardPattern(bitmatrix, 0, j, l, false, STOP_PATTERN_REVERSE);
            if(ai1 == null)
                break MISSING_BLOCK_LABEL_349;
            aresultpoint[3] = new ResultPoint(ai1[0], j);
            aresultpoint[7] = new ResultPoint(ai1[1], j);
            i = 1;
        }
_L16:
        if(i != 0)
            return aresultpoint;
        else
            return null;
_L4:
        i--;
          goto _L17
_L9:
        j++;
          goto _L18
_L14:
        i--;
          goto _L19
        j++;
          goto _L20
    }

    private static int patternMatchVariance(int ai[], int ai1[], int i)
    {
        int j;
        int i1;
        int k1;
        k1 = ai.length;
        j = 0;
        i1 = 0;
        for(int k = 0; k < k1; k++)
        {
            j += ai[k];
            i1 += ai1[k];
        }

        if(j >= i1) goto _L2; else goto _L1
_L1:
        return 0x7fffffff;
_L2:
        int l1 = (j << 8) / i1;
        i1 = 0;
        int l = 0;
        do
        {
label0:
            {
                if(l >= k1)
                    break label0;
                int j1 = ai[l] << 8;
                int i2 = ai1[l] * l1;
                if(j1 > i2)
                    j1 -= i2;
                else
                    j1 = i2 - j1;
                if(j1 > i * l1 >> 8)
                    continue; /* Loop/switch isn't completed */
                i1 += j1;
                l++;
            }
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return i1 / j;
    }

    private static int round(float f)
    {
        return (int)(0.5F + f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitmatrix, ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i)
        throws NotFoundException
    {
        return GridSampler.getInstance().sampleGrid(bitmatrix, i, 0.0F, 0.0F, i, 0.0F, i, i, 0.0F, i, resultpoint.getX(), resultpoint.getY(), resultpoint2.getX(), resultpoint2.getY(), resultpoint3.getX(), resultpoint3.getY(), resultpoint1.getX(), resultpoint1.getY());
    }

    public DetectorResult detect()
        throws NotFoundException
    {
        return detect(null);
    }

    public DetectorResult detect(Hashtable hashtable)
        throws NotFoundException
    {
        BitMatrix bitmatrix = image.getBlackMatrix();
        hashtable = findVertices(bitmatrix);
        if(hashtable == null)
        {
            ResultPoint aresultpoint[] = findVertices180(bitmatrix);
            hashtable = aresultpoint;
            if(aresultpoint != null)
            {
                correctCodeWordVertices(aresultpoint, true);
                hashtable = aresultpoint;
            }
        } else
        {
            correctCodeWordVertices(hashtable, false);
        }
        if(hashtable == null)
            throw NotFoundException.getNotFoundInstance();
        float f = computeModuleWidth(hashtable);
        if(f < 1.0F)
            throw NotFoundException.getNotFoundInstance();
        int i = computeDimension(hashtable[4], hashtable[6], hashtable[5], hashtable[7], f);
        if(i < 1)
            throw NotFoundException.getNotFoundInstance();
        else
            return new DetectorResult(sampleGrid(bitmatrix, hashtable[4], hashtable[5], hashtable[6], hashtable[7], i), new ResultPoint[] {
                hashtable[4], hashtable[5], hashtable[6], hashtable[7]
            });
    }

    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;
    private static final int SKEW_THRESHOLD = 2;
    private static final int START_PATTERN[] = {
        8, 1, 1, 1, 1, 1, 1, 3
    };
    private static final int START_PATTERN_REVERSE[] = {
        3, 1, 1, 1, 1, 1, 1, 8
    };
    private static final int STOP_PATTERN[] = {
        7, 1, 1, 3, 1, 1, 1, 2, 1
    };
    private static final int STOP_PATTERN_REVERSE[] = {
        1, 2, 1, 1, 1, 3, 1, 1, 7
    };
    private final BinaryBitmap image;

}
