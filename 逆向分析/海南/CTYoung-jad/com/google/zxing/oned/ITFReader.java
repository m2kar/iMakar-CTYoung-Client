// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class ITFReader extends OneDReader
{

    public ITFReader()
    {
        narrowLineWidth = -1;
    }

    private static int decodeDigit(int ai[])
        throws NotFoundException
    {
        int j = 107;
        int l = -1;
        int j1 = PATTERNS.length;
        for(int i = 0; i < j1;)
        {
            int i1 = patternMatchVariance(ai, PATTERNS[i], 204);
            int k = j;
            if(i1 < j)
            {
                k = i1;
                l = i;
            }
            i++;
            j = k;
        }

        if(l >= 0)
            return l;
        else
            throw NotFoundException.getNotFoundInstance();
    }

    private static void decodeMiddle(BitArray bitarray, int i, int j, StringBuffer stringbuffer)
        throws NotFoundException
    {
        int ai[] = new int[10];
        int ai1[] = new int[5];
        int ai2[] = new int[5];
        do
        {
label0:
            {
                if(i >= j)
                    break label0;
                recordPattern(bitarray, i, ai);
                for(int k = 0; k < 5; k++)
                {
                    int i1 = k << 1;
                    ai1[k] = ai[i1];
                    ai2[k] = ai[i1 + 1];
                }

                stringbuffer.append((char)(decodeDigit(ai1) + 48));
                stringbuffer.append((char)(decodeDigit(ai2) + 48));
                int l = 0;
                int j1 = i;
                do
                {
                    i = j1;
                    if(l >= ai.length)
                        break;
                    j1 += ai[l];
                    l++;
                } while(true);
            }
        } while(true);
    }

    private static int[] findGuardPattern(BitArray bitarray, int i, int ai[])
        throws NotFoundException
    {
        int i1 = ai.length;
        int ai1[] = new int[i1];
        int j1 = bitarray.getSize();
        boolean flag = false;
        boolean flag1 = false;
        int j = i;
        int k = i;
        i = j;
        j = ((flag1) ? 1 : 0);
        while(k < j1) 
        {
            if(bitarray.get(k) ^ flag)
            {
                ai1[j] = ai1[j] + 1;
            } else
            {
                if(j == i1 - 1)
                {
                    if(patternMatchVariance(ai1, ai, 204) < 107)
                        return (new int[] {
                            i, k
                        });
                    int l = i + (ai1[0] + ai1[1]);
                    for(i = 2; i < i1; i++)
                        ai1[i - 2] = ai1[i];

                    ai1[i1 - 2] = 0;
                    ai1[i1 - 1] = 0;
                    j--;
                    i = l;
                } else
                {
                    j++;
                }
                ai1[j] = 1;
                if(!flag)
                    flag = true;
                else
                    flag = false;
            }
            k++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(BitArray bitarray)
        throws NotFoundException
    {
        int j = bitarray.getSize();
        int i = 0;
        do
        {
            if(i >= j || bitarray.get(i))
                if(i == j)
                    throw NotFoundException.getNotFoundInstance();
                else
                    return i;
            i++;
        } while(true);
    }

    private void validateQuietZone(BitArray bitarray, int i)
        throws NotFoundException
    {
        int j = narrowLineWidth * 10;
        i--;
        do
        {
            if(j <= 0 || i < 0 || bitarray.get(i))
                if(j != 0)
                    throw NotFoundException.getNotFoundInstance();
                else
                    return;
            j--;
            i--;
        } while(true);
    }

    int[] decodeEnd(BitArray bitarray)
        throws NotFoundException
    {
        bitarray.reverse();
        int ai[];
        ai = findGuardPattern(bitarray, skipWhiteSpace(bitarray), END_PATTERN_REVERSED);
        validateQuietZone(bitarray, ai[0]);
        int i = ai[0];
        ai[0] = bitarray.getSize() - ai[1];
        ai[1] = bitarray.getSize() - i;
        bitarray.reverse();
        return ai;
        Exception exception;
        exception;
        bitarray.reverse();
        throw exception;
    }

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws FormatException, NotFoundException
    {
        int ai1[] = decodeStart(bitarray);
        int ai[] = decodeEnd(bitarray);
        Object obj = new StringBuffer(20);
        decodeMiddle(bitarray, ai1[1], ai[0], ((StringBuffer) (obj)));
        obj = ((StringBuffer) (obj)).toString();
        bitarray = null;
        if(hashtable != null)
            bitarray = (int[])(int[])hashtable.get(DecodeHintType.ALLOWED_LENGTHS);
        hashtable = bitarray;
        if(bitarray == null)
            hashtable = DEFAULT_ALLOWED_LENGTHS;
        int k = ((String) (obj)).length();
        boolean flag1 = false;
        int j = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if(j < hashtable.length)
                {
                    if(k != hashtable[j])
                        break label0;
                    flag = true;
                }
                if(!flag)
                {
                    throw FormatException.getFormatInstance();
                } else
                {
                    bitarray = new ResultPoint(ai1[1], i);
                    hashtable = new ResultPoint(ai[0], i);
                    BarcodeFormat barcodeformat = BarcodeFormat.ITF;
                    return new Result(((String) (obj)), null, new ResultPoint[] {
                        bitarray, hashtable
                    }, barcodeformat);
                }
            }
            j++;
        } while(true);
    }

    int[] decodeStart(BitArray bitarray)
        throws NotFoundException
    {
        int ai[] = findGuardPattern(bitarray, skipWhiteSpace(bitarray), START_PATTERN);
        narrowLineWidth = ai[1] - ai[0] >> 2;
        validateQuietZone(bitarray, ai[0]);
        return ai;
    }

    private static final int DEFAULT_ALLOWED_LENGTHS[] = {
        6, 10, 12, 14, 44
    };
    private static final int END_PATTERN_REVERSED[] = {
        1, 1, 3
    };
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;
    private static final int N = 1;
    static final int PATTERNS[][] = {
        {
            1, 1, 3, 3, 1
        }, {
            3, 1, 1, 1, 3
        }, {
            1, 3, 1, 1, 3
        }, {
            3, 3, 1, 1, 1
        }, {
            1, 1, 3, 1, 3
        }, {
            3, 1, 3, 1, 1
        }, {
            1, 3, 3, 1, 1
        }, {
            1, 1, 1, 3, 3
        }, {
            3, 1, 1, 3, 1
        }, {
            1, 3, 1, 3, 1
        }
    };
    private static final int START_PATTERN[] = {
        1, 1, 1, 1
    };
    private static final int W = 3;
    private int narrowLineWidth;

}
