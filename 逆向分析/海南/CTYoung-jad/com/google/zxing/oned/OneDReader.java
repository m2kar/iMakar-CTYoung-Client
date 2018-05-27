// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class OneDReader
    implements Reader
{

    public OneDReader()
    {
    }

    private Result doDecode(BinaryBitmap binarybitmap, Hashtable hashtable)
        throws NotFoundException
    {
        int j;
        int j1;
        int k1;
        Object obj;
        k1 = binarybitmap.getWidth();
        int i1 = binarybitmap.getHeight();
        obj = new BitArray(k1);
        int i;
        int l1;
        if(hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER))
            i = 1;
        else
            i = 0;
        if(i != 0)
            j = 8;
        else
            j = 5;
        l1 = Math.max(1, i1 >> j);
        if(i != 0)
            i = i1;
        else
            i = 15;
        j = 0;
_L1:
label0:
        {
            if(j < i)
            {
                j1 = j + 1 >> 1;
                int k;
                if((j & 1) == 0)
                    k = 1;
                else
                    k = 0;
                if(k != 0)
                    k = j1;
                else
                    k = -j1;
                j1 = (i1 >> 1) + l1 * k;
                if(j1 >= 0 && j1 < i1)
                    break label0;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        Object obj1 = binarybitmap.getBlackRow(j1, ((BitArray) (obj)));
        int l;
        obj = obj1;
        l = 0;
_L2:
        Object obj2;
        obj2 = obj;
        obj1 = hashtable;
        if(l < 2)
        {
            obj1 = hashtable;
            if(l == 1)
            {
                ((BitArray) (obj)).reverse();
                obj1 = hashtable;
                if(hashtable != null)
                {
                    obj1 = hashtable;
                    if(hashtable.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
                    {
                        obj1 = new Hashtable();
                        obj2 = hashtable.keys();
                        do
                        {
                            if(!((Enumeration) (obj2)).hasMoreElements())
                                break;
                            Object obj3 = ((Enumeration) (obj2)).nextElement();
                            if(!obj3.equals(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
                                ((Hashtable) (obj1)).put(obj3, hashtable.get(obj3));
                        } while(true);
                    }
                }
            }
            break MISSING_BLOCK_LABEL_311;
        }
        break MISSING_BLOCK_LABEL_295;
        obj1;
        obj1 = hashtable;
        obj2 = obj;
        j++;
        obj = obj2;
        hashtable = ((Hashtable) (obj1));
          goto _L1
        hashtable = decodeRow(j1, ((BitArray) (obj)), ((Hashtable) (obj1)));
        if(l != 1)
            break MISSING_BLOCK_LABEL_413;
        hashtable.putMetadata(ResultMetadataType.ORIENTATION, new Integer(180));
        ResultPoint aresultpoint[] = hashtable.getResultPoints();
        aresultpoint[0] = new ResultPoint((float)k1 - aresultpoint[0].getX() - 1.0F, aresultpoint[0].getY());
        aresultpoint[1] = new ResultPoint((float)k1 - aresultpoint[1].getX() - 1.0F, aresultpoint[1].getY());
        return hashtable;
        hashtable;
        l++;
        hashtable = ((Hashtable) (obj1));
          goto _L2
    }

    protected static int patternMatchVariance(int ai[], int ai1[], int i)
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

    protected static void recordPattern(BitArray bitarray, int i, int ai[])
        throws NotFoundException
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        j1 = ai.length;
        for(int j = 0; j < j1; j++)
            ai[j] = 0;

        k1 = bitarray.getSize();
        if(i >= k1)
            throw NotFoundException.getNotFoundInstance();
        if(!bitarray.get(i))
            k = 1;
        else
            k = 0;
        i1 = 0;
        l = k;
        k = i;
        i = i1;
        i1 = i;
        if(k >= k1) goto _L2; else goto _L1
_L1:
        if(!(bitarray.get(k) ^ l)) goto _L4; else goto _L3
_L3:
        ai[i] = ai[i] + 1;
        i1 = i;
_L6:
        k++;
        i = i1;
        break MISSING_BLOCK_LABEL_60;
_L4:
        i1 = i + 1;
        if(i1 != j1)
            break MISSING_BLOCK_LABEL_144;
_L2:
        if(i1 != j1 && (i1 != j1 - 1 || k != k1))
            throw NotFoundException.getNotFoundInstance();
        else
            return;
        ai[i1] = 1;
        if(l == 0)
            i = 1;
        else
            i = 0;
        l = i;
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected static void recordPatternInReverse(BitArray bitarray, int i, int ai[])
        throws NotFoundException
    {
        int j = ai.length;
        boolean flag = bitarray.get(i);
        do
        {
            if(i <= 0 || j < 0)
                break;
            int k = i - 1;
            i = k;
            if(bitarray.get(k) != flag)
            {
                j--;
                if(!flag)
                    flag = true;
                else
                    flag = false;
                i = k;
            }
        } while(true);
        if(j >= 0)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            recordPattern(bitarray, i + 1, ai);
            return;
        }
    }

    public Result decode(BinaryBitmap binarybitmap)
        throws NotFoundException, FormatException
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Hashtable hashtable)
        throws NotFoundException, FormatException
    {
        Result result = doDecode(binarybitmap, hashtable);
        binarybitmap = result;
_L2:
        return binarybitmap;
        Object obj;
        obj;
label0:
        {
            int i;
            int j;
            if(hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER))
                i = 1;
            else
                i = 0;
            if(i == 0 || !binarybitmap.isRotateSupported())
                break label0;
            binarybitmap = binarybitmap.rotateCounterClockwise();
            hashtable = doDecode(binarybitmap, hashtable);
            obj = hashtable.getResultMetadata();
            j = 270;
            i = j;
            if(obj != null)
            {
                i = j;
                if(((Hashtable) (obj)).containsKey(ResultMetadataType.ORIENTATION))
                    i = (((Integer)((Hashtable) (obj)).get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
            }
            hashtable.putMetadata(ResultMetadataType.ORIENTATION, new Integer(i));
            obj = hashtable.getResultPoints();
            j = binarybitmap.getHeight();
            i = 0;
            do
            {
                binarybitmap = hashtable;
                if(i >= obj.length)
                    break;
                obj[i] = new ResultPoint((float)j - obj[i].getY() - 1.0F, obj[i].getX());
                i++;
            } while(true);
        }
        if(true) goto _L2; else goto _L1
_L1:
        throw obj;
    }

    public abstract Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException, ChecksumException, FormatException;

    public void reset()
    {
    }

    protected static final int INTEGER_MATH_SHIFT = 8;
    protected static final int PATTERN_MATCH_RESULT_SCALE_FACTOR = 256;
}
