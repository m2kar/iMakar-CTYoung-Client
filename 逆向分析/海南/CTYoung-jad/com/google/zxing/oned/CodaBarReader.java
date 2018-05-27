// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class CodaBarReader extends OneDReader
{

    public CodaBarReader()
    {
    }

    private static boolean arrayContains(char ac[], char c)
    {
        if(ac != null)
        {
            for(int i = 0; i < ac.length; i++)
                if(ac[i] == c)
                    return true;

        }
        return false;
    }

    private static int[] findAsteriskPattern(BitArray bitarray)
        throws NotFoundException
    {
        int i;
        int i1;
        i1 = bitarray.getSize();
        i = 0;
_L8:
        if(i < i1 && !bitarray.get(i)) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        boolean flag;
        int j1;
        int ai[];
        boolean flag1 = false;
        ai = new int[7];
        j = i;
        flag = false;
        j1 = ai.length;
        k = i;
        i = j;
        j = ((flag1) ? 1 : 0);
_L4:
        if(k >= i1)
            break MISSING_BLOCK_LABEL_227;
        if(!(bitarray.get(k) ^ flag))
            break; /* Loop/switch isn't completed */
        ai[j] = ai[j] + 1;
_L5:
        k++;
        if(true) goto _L4; else goto _L3
_L2:
        i++;
        continue; /* Loop/switch isn't completed */
_L3:
        if(j != j1 - 1)
            break MISSING_BLOCK_LABEL_220;
        if(arrayContains(STARTEND_ENCODING, toNarrowWidePattern(ai)) && bitarray.isRange(Math.max(0, i - (k - i) / 2), i, false))
            return (new int[] {
                i, k
            });
        break MISSING_BLOCK_LABEL_145;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        int l = i + (ai[0] + ai[1]);
        for(i = 2; i < j1; i++)
            ai[i - 2] = ai[i];

        ai[j1 - 2] = 0;
        ai[j1 - 1] = 0;
        j--;
        i = l;
_L6:
        ai[j] = 1;
        flag ^= true;
          goto _L5
        j++;
          goto _L6
        throw NotFoundException.getNotFoundInstance();
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static char toNarrowWidePattern(int ai[])
    {
        int j2 = ai.length;
        int i = 0;
        int j = 0x7fffffff;
        int l = 0;
        int k;
        do
        {
            k = i;
            if(l >= j2)
                break;
            k = j;
            if(ai[l] < j)
                k = ai[l];
            j = i;
            if(ai[l] > i)
                j = ai[l];
            l++;
            i = j;
            j = k;
        } while(true);
        do
        {
            int i1 = 0;
            i = 0;
            for(int k1 = 0; k1 < j2;)
            {
                int i2 = i;
                int l1 = i1;
                if(ai[k1] > k)
                {
                    i2 = i | 1 << j2 - 1 - k1;
                    l1 = i1 + 1;
                }
                k1++;
                i = i2;
                i1 = l1;
            }

            if(i1 == 2 || i1 == 3)
            {
                for(int j1 = 0; j1 < CHARACTER_ENCODINGS.length; j1++)
                    if(CHARACTER_ENCODINGS[j1] == i)
                        return ALPHABET[j1];

            }
            i = k - 1;
            k = i;
        } while(i > j);
        return '!';
    }

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException
    {
        hashtable = findAsteriskPattern(bitarray);
        hashtable[1] = 0;
        int k = hashtable[1];
        int j2;
        for(j2 = bitarray.getSize(); k < j2 && !bitarray.get(k); k++);
        Object obj = new StringBuffer();
        int j;
        int j1;
        int ai[];
        do
        {
            j1 = k;
            ai = new int[7];
            int[] _tmp = ai;
            ai[0] = 0;
            ai[1] = 0;
            ai[2] = 0;
            ai[3] = 0;
            ai[4] = 0;
            ai[5] = 0;
            ai[6] = 0;
            recordPattern(bitarray, j1, ai);
            char c = toNarrowWidePattern(ai);
            if(c == '!')
                throw NotFoundException.getNotFoundInstance();
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
        } while(j < j2);
        int l1 = 0;
        for(int l = 0; l < ai.length; l++)
            l1 += ai[l];

        if(j != j2 && (j - j1 - l1) / 2 < l1)
            throw NotFoundException.getNotFoundInstance();
        if(((StringBuffer) (obj)).length() < 2)
            throw NotFoundException.getNotFoundInstance();
        char c1 = ((StringBuffer) (obj)).charAt(0);
        if(!arrayContains(STARTEND_ENCODING, c1))
            throw NotFoundException.getNotFoundInstance();
        int i2;
        for(int i1 = 1; i1 < ((StringBuffer) (obj)).length(); i1 = i2 + 1)
        {
            i2 = i1;
            if(((StringBuffer) (obj)).charAt(i1) != c1)
                continue;
            i2 = i1;
            if(i1 + 1 != ((StringBuffer) (obj)).length())
            {
                ((StringBuffer) (obj)).delete(i1 + 1, ((StringBuffer) (obj)).length() - 1);
                i2 = ((StringBuffer) (obj)).length();
            }
        }

        if(((StringBuffer) (obj)).length() > 6)
        {
            ((StringBuffer) (obj)).deleteCharAt(((StringBuffer) (obj)).length() - 1);
            ((StringBuffer) (obj)).deleteCharAt(0);
            float f = (float)(hashtable[1] + hashtable[0]) / 2.0F;
            float f1 = (float)(j + j1) / 2.0F;
            bitarray = ((StringBuffer) (obj)).toString();
            hashtable = new ResultPoint(f, i);
            obj = new ResultPoint(f1, i);
            BarcodeFormat barcodeformat = BarcodeFormat.CODABAR;
            return new Result(bitarray, null, new ResultPoint[] {
                hashtable, obj
            }, barcodeformat);
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static final char ALPHABET[] = "0123456789-$:/.+ABCDTN".toCharArray();
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCDTN";
    private static final int CHARACTER_ENCODINGS[] = {
        3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 
        12, 24, 37, 81, 84, 21, 26, 41, 11, 14, 
        26, 41
    };
    private static final char STARTEND_ENCODING[] = {
        'E', '*', 'A', 'B', 'C', 'D', 'T', 'N'
    };
    private static final int minCharacterLength = 6;

}
