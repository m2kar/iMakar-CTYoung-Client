// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class Code93Reader extends OneDReader
{

    public Code93Reader()
    {
    }

    private static void checkChecksums(StringBuffer stringbuffer)
        throws ChecksumException
    {
        int i = stringbuffer.length();
        checkOneChecksum(stringbuffer, i - 2, 20);
        checkOneChecksum(stringbuffer, i - 1, 15);
    }

    private static void checkOneChecksum(StringBuffer stringbuffer, int i, int j)
        throws ChecksumException
    {
        int k = 1;
        int i1 = 0;
        for(int l = i - 1; l >= 0; l--)
        {
            i1 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(stringbuffer.charAt(l)) * k;
            int j1 = k + 1;
            k = j1;
            if(j1 > j)
                k = 1;
        }

        if(stringbuffer.charAt(i) != ALPHABET[i1 % 47])
            throw ChecksumException.getChecksumInstance();
        else
            return;
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
            break MISSING_BLOCK_LABEL_261;
        c1 = stringbuffer.charAt(i);
        if(c1 < 'a' || c1 > 'd')
            break MISSING_BLOCK_LABEL_251;
        c2 = stringbuffer.charAt(i + 1);
        c = '\0';
        c1;
        JVM INSTR tableswitch 97 100: default 84
    //                   97 130
    //                   98 158
    //                   99 210
    //                   100 102;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        stringbuffer1.append(c);
        i++;
_L6:
        i++;
        continue; /* Loop/switch isn't completed */
_L5:
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
_L4:
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
                int ai[] = new int[6];
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
                            if(toPattern(ai) == ASTERISK_ENCODING)
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

    private static int toPattern(int ai[])
    {
        int j2 = ai.length;
        int i1 = 0;
        for(int i = 0; i < j2; i++)
            i1 += ai[i];

        int j = 0;
        int j1 = 0;
        do
        {
            int k1;
label0:
            {
                int k = j;
                if(j1 < j2)
                {
                    int l1 = ((ai[j1] << 8) * 9) / i1;
                    k = l1 >> 8;
                    k1 = k;
                    if((l1 & 0xff) > 127)
                        k1 = k + 1;
                    if(k1 >= 1 && k1 <= 4)
                        break label0;
                    k = -1;
                }
                return k;
            }
            int l;
            if((j1 & 1) == 0)
            {
                int i2 = 0;
                do
                {
                    l = j;
                    if(i2 >= k1)
                        break;
                    j = j << 1 | 1;
                    i2++;
                } while(true);
            } else
            {
                l = j << k1;
            }
            j1++;
            j = l;
        } while(true);
    }

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException, ChecksumException, FormatException
    {
        hashtable = findAsteriskPattern(bitarray);
        int k = hashtable[1];
        int j1;
        for(j1 = bitarray.getSize(); k < j1 && !bitarray.get(k); k++);
        Object obj = new StringBuffer(20);
        int ai[] = new int[6];
        char c;
        int j;
        int l;
        do
        {
            l = k;
            recordPattern(bitarray, l, ai);
            j = toPattern(ai);
            if(j < 0)
                throw NotFoundException.getNotFoundInstance();
            c = patternToChar(j);
            ((StringBuffer) (obj)).append(c);
            k = 0;
            j = l;
            do
            {
                int i1 = j;
                j = i1;
                if(k >= ai.length)
                    break;
                j = i1 + ai[k];
                k++;
            } while(true);
            for(; j < j1 && !bitarray.get(j); j++);
            k = j;
        } while(c != '*');
        ((StringBuffer) (obj)).deleteCharAt(((StringBuffer) (obj)).length() - 1);
        if(j == j1 || !bitarray.get(j))
            throw NotFoundException.getNotFoundInstance();
        if(((StringBuffer) (obj)).length() < 2)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            checkChecksums(((StringBuffer) (obj)));
            ((StringBuffer) (obj)).setLength(((StringBuffer) (obj)).length() - 2);
            bitarray = decodeExtended(((StringBuffer) (obj)));
            float f = (float)(hashtable[1] + hashtable[0]) / 2.0F;
            float f1 = (float)(j + l) / 2.0F;
            hashtable = new ResultPoint(f, i);
            obj = new ResultPoint(f1, i);
            BarcodeFormat barcodeformat = BarcodeFormat.CODE_93;
            return new Result(bitarray, null, new ResultPoint[] {
                hashtable, obj
            }, barcodeformat);
        }
    }

    private static final char ALPHABET[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    private static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[47];
    private static final int CHARACTER_ENCODINGS[] = {
        276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 
        424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 
        282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 
        406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 
        366, 374, 430, 294, 474, 470, 306, 350
    };

}
