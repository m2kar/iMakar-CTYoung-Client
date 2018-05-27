// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class Code39Reader extends OneDReader
{

    public Code39Reader()
    {
        usingCheckDigit = false;
        extendedMode = false;
    }

    public Code39Reader(boolean flag)
    {
        usingCheckDigit = flag;
        extendedMode = false;
    }

    public Code39Reader(boolean flag, boolean flag1)
    {
        usingCheckDigit = flag;
        extendedMode = flag1;
    }

    private static String decodeExtended(StringBuffer stringbuffer)
        throws FormatException
    {
        int i;
        int j;
        StringBuffer stringbuffer1;
        j = stringbuffer.length();
        stringbuffer1 = new StringBuffer(j);
        i = 0;
_L8:
        char c;
        char c1;
        char c2;
        if(i >= j)
            break MISSING_BLOCK_LABEL_285;
        c1 = stringbuffer.charAt(i);
        if(c1 != '+' && c1 != '$' && c1 != '%' && c1 != '/')
            break MISSING_BLOCK_LABEL_275;
        c2 = stringbuffer.charAt(i + 1);
        c = '\0';
        c1;
        JVM INSTR lookupswitch 4: default 108
    //                   36: 154
    //                   37: 182
    //                   43: 126
    //                   47: 234;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        stringbuffer1.append(c);
        i++;
_L6:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        if(c2 >= 'A' && c2 <= 'Z')
            c = (char)(c2 + 32);
        else
            throw FormatException.getFormatInstance();
          goto _L1
_L2:
        if(c2 >= 'A' && c2 <= 'Z')
            c = (char)(c2 - 64);
        else
            throw FormatException.getFormatInstance();
          goto _L1
_L3:
        if(c2 >= 'A' && c2 <= 'E')
            c = (char)(c2 - 38);
        else
        if(c2 >= 'F' && c2 <= 'W')
            c = (char)(c2 - 11);
        else
            throw FormatException.getFormatInstance();
          goto _L1
_L5:
        if(c2 >= 'A' && c2 <= 'O')
            c = (char)(c2 - 32);
        else
        if(c2 == 'Z')
            c = ':';
        else
            throw FormatException.getFormatInstance();
          goto _L1
        stringbuffer1.append(c1);
          goto _L6
        return stringbuffer1.toString();
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static int[] findAsteriskPattern(BitArray bitarray)
        throws NotFoundException
    {
        int i1 = bitarray.getSize();
        int i = 0;
        do
        {
            if(i >= i1 || bitarray.get(i))
            {
                boolean flag1 = false;
                int ai[] = new int[9];
                int j = i;
                boolean flag = false;
                int j1 = ai.length;
                int k = i;
                i = j;
                j = ((flag1) ? 1 : 0);
                while(k < i1) 
                {
                    if(bitarray.get(k) ^ flag)
                    {
                        ai[j] = ai[j] + 1;
                    } else
                    {
                        if(j == j1 - 1)
                        {
                            if(toNarrowWidePattern(ai) == ASTERISK_ENCODING && bitarray.isRange(Math.max(0, i - (k - i) / 2), i, false))
                                return (new int[] {
                                    i, k
                                });
                            int l = i + (ai[0] + ai[1]);
                            for(i = 2; i < j1; i++)
                                ai[i - 2] = ai[i];

                            ai[j1 - 2] = 0;
                            ai[j1 - 1] = 0;
                            j--;
                            i = l;
                        } else
                        {
                            j++;
                        }
                        ai[j] = 1;
                        if(!flag)
                            flag = true;
                        else
                            flag = false;
                    }
                    k++;
                }
            } else
            {
                i++;
                continue;
            }
            throw NotFoundException.getNotFoundInstance();
        } while(true);
    }

    private static char patternToChar(int i)
        throws NotFoundException
    {
        for(int j = 0; j < CHARACTER_ENCODINGS.length; j++)
            if(CHARACTER_ENCODINGS[j] == i)
                return ALPHABET[j];

        throw NotFoundException.getNotFoundInstance();
    }

    private static int toNarrowWidePattern(int ai[])
    {
        int k3 = ai.length;
        int l = 0;
        int k;
        do
        {
            int i = 0x7fffffff;
            for(int j = 0; j < k3;)
            {
                int k1 = ai[j];
                int i1 = i;
                if(k1 < i)
                {
                    i1 = i;
                    if(k1 > l)
                        i1 = k1;
                }
                j++;
                i = i1;
            }

            l = i;
            k = 0;
            int j1 = 0;
            i = 0;
            for(int l1 = 0; l1 < k3;)
            {
                int l3 = ai[l1];
                int j3 = i;
                int l2 = j1;
                int j2 = k;
                if(ai[l1] > l)
                {
                    j3 = i | 1 << k3 - 1 - l1;
                    j2 = k + 1;
                    l2 = j1 + l3;
                }
                l1++;
                i = j3;
                j1 = l2;
                k = j2;
            }

            if(k != 3)
                continue;
            boolean flag = false;
            int i2 = k;
            k = ((flag) ? 1 : 0);
            do
            {
                int k2;
label0:
                {
                    k2 = i;
                    if(k < k3)
                    {
                        k2 = i;
                        if(i2 > 0)
                        {
                            int i3 = ai[k];
                            k2 = i2;
                            if(ai[k] <= l)
                                break label0;
                            k2 = i2 - 1;
                            if(i3 << 1 < j1)
                                break label0;
                            k2 = -1;
                        }
                    }
                    return k2;
                }
                k++;
                i2 = k2;
            } while(true);
        } while(k > 3);
        return -1;
    }

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException, ChecksumException, FormatException
    {
        hashtable = findAsteriskPattern(bitarray);
        int k = hashtable[1];
        int j2;
        for(j2 = bitarray.getSize(); k < j2 && !bitarray.get(k); k++);
        Object obj = new StringBuffer(20);
        int ai[] = new int[9];
        char c;
        int j;
        int j1;
        do
        {
            j1 = k;
            recordPattern(bitarray, j1, ai);
            j = toNarrowWidePattern(ai);
            if(j < 0)
                throw NotFoundException.getNotFoundInstance();
            c = patternToChar(j);
            ((StringBuffer) (obj)).append(c);
            k = 0;
            j = j1;
            do
            {
                int k1 = j;
                j = k1;
                if(k >= ai.length)
                    break;
                j = k1 + ai[k];
                k++;
            } while(true);
            for(; j < j2 && !bitarray.get(j); j++);
            k = j;
        } while(c != '*');
        ((StringBuffer) (obj)).deleteCharAt(((StringBuffer) (obj)).length() - 1);
        int l1 = 0;
        for(int l = 0; l < ai.length; l++)
            l1 += ai[l];

        if(j != j2 && (j - j1 - l1) / 2 < l1)
            throw NotFoundException.getNotFoundInstance();
        if(usingCheckDigit)
        {
            int k2 = ((StringBuffer) (obj)).length() - 1;
            int i2 = 0;
            for(int i1 = 0; i1 < k2; i1++)
                i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(((StringBuffer) (obj)).charAt(i1));

            if(((StringBuffer) (obj)).charAt(k2) != ALPHABET[i2 % 43])
                throw ChecksumException.getChecksumInstance();
            ((StringBuffer) (obj)).deleteCharAt(k2);
        }
        if(((StringBuffer) (obj)).length() == 0)
            throw NotFoundException.getNotFoundInstance();
        float f;
        float f1;
        BarcodeFormat barcodeformat;
        if(extendedMode)
            bitarray = decodeExtended(((StringBuffer) (obj)));
        else
            bitarray = ((StringBuffer) (obj)).toString();
        f = (float)(hashtable[1] + hashtable[0]) / 2.0F;
        f1 = (float)(j + j1) / 2.0F;
        hashtable = new ResultPoint(f, i);
        obj = new ResultPoint(f1, i);
        barcodeformat = BarcodeFormat.CODE_39;
        return new Result(bitarray, null, new ResultPoint[] {
            hashtable, obj
        }, barcodeformat);
    }

    private static final char ALPHABET[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[39];
    static final int CHARACTER_ENCODINGS[] = {
        52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 
        265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 
        259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 
        385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 
        168, 162, 138, 42
    };
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

}
