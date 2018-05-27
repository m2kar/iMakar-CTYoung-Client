// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader, UPCEANExtensionSupport, EANManufacturerOrgSupport

public abstract class UPCEANReader extends OneDReader
{

    protected UPCEANReader()
    {
    }

    private static boolean checkStandardUPCEANChecksum(String s)
        throws FormatException
    {
        int l = s.length();
        if(l != 0)
        {
            int k = 0;
            for(int i = l - 2; i >= 0; i -= 2)
            {
                int j1 = s.charAt(i) - 48;
                if(j1 < 0 || j1 > 9)
                    throw FormatException.getFormatInstance();
                k += j1;
            }

            k *= 3;
            for(int j = l - 1; j >= 0; j -= 2)
            {
                int i1 = s.charAt(j) - 48;
                if(i1 < 0 || i1 > 9)
                    throw FormatException.getFormatInstance();
                k += i1;
            }

            if(k % 10 == 0)
                return true;
        }
        return false;
    }

    static int decodeDigit(BitArray bitarray, int ai[], int i, int ai1[][])
        throws NotFoundException
    {
        recordPattern(bitarray, i, ai);
        int j = 107;
        int l = -1;
        int j1 = ai1.length;
        for(i = 0; i < j1;)
        {
            int i1 = patternMatchVariance(ai, ai1[i], 179);
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

    static int[] findGuardPattern(BitArray bitarray, int i, boolean flag, int ai[])
        throws NotFoundException
    {
        int i1 = ai.length;
        int ai1[] = new int[i1];
        int j1 = bitarray.getSize();
        boolean flag2 = false;
        do
        {
label0:
            {
label1:
                {
                    int j;
                    int k;
                    if(i < j1)
                    {
                        boolean flag1;
                        if(!bitarray.get(i))
                            flag2 = true;
                        else
                            flag2 = false;
                        if(flag != flag2)
                            break label1;
                    }
                    flag1 = false;
                    j = i;
                    k = i;
                    i = j;
                    j = ((flag1) ? 1 : 0);
                    while(k < j1) 
                    {
                        if(bitarray.get(k) ^ flag2)
                        {
                            ai1[j] = ai1[j] + 1;
                            flag = flag2;
                        } else
                        {
                            if(j == i1 - 1)
                            {
                                if(patternMatchVariance(ai1, ai, 179) < 107)
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
                            if(!flag2)
                                flag = true;
                            else
                                flag = false;
                        }
                        k++;
                        flag2 = flag;
                    }
                    break label0;
                }
                i++;
                continue;
            }
            throw NotFoundException.getNotFoundInstance();
        } while(true);
    }

    static int[] findStartGuardPattern(BitArray bitarray)
        throws NotFoundException
    {
        boolean flag = false;
        int ai[] = null;
        int i = 0;
        do
        {
            if(flag)
                break;
            int ai1[] = findGuardPattern(bitarray, i, false, START_END_PATTERN);
            int k = ai1[0];
            int j = ai1[1];
            int l = k - (j - k);
            i = j;
            ai = ai1;
            if(l >= 0)
            {
                flag = bitarray.isRange(l, k, false);
                i = j;
                ai = ai1;
            }
        } while(true);
        return ai;
    }

    boolean checkChecksum(String s)
        throws ChecksumException, FormatException
    {
        return checkStandardUPCEANChecksum(s);
    }

    int[] decodeEnd(BitArray bitarray, int i)
        throws NotFoundException
    {
        return findGuardPattern(bitarray, i, false, START_END_PATTERN);
    }

    protected abstract int decodeMiddle(BitArray bitarray, int ai[], StringBuffer stringbuffer)
        throws NotFoundException;

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException, ChecksumException, FormatException
    {
        return decodeRow(i, bitarray, findStartGuardPattern(bitarray), hashtable);
    }

    public Result decodeRow(int i, BitArray bitarray, int ai[], Hashtable hashtable)
        throws NotFoundException, ChecksumException, FormatException
    {
        int j;
        int k;
        int ai1[];
        Object obj;
        if(hashtable == null)
            hashtable = null;
        else
            hashtable = (ResultPointCallback)hashtable.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if(hashtable != null)
            hashtable.foundPossibleResultPoint(new ResultPoint((float)(ai[0] + ai[1]) / 2.0F, i));
        obj = decodeRowStringBuffer;
        ((StringBuffer) (obj)).setLength(0);
        j = decodeMiddle(bitarray, ai, ((StringBuffer) (obj)));
        if(hashtable != null)
            hashtable.foundPossibleResultPoint(new ResultPoint(j, i));
        ai1 = decodeEnd(bitarray, j);
        if(hashtable != null)
            hashtable.foundPossibleResultPoint(new ResultPoint((float)(ai1[0] + ai1[1]) / 2.0F, i));
        j = ai1[1];
        k = j + (j - ai1[0]);
        if(k >= bitarray.getSize() || !bitarray.isRange(j, k, false))
            throw NotFoundException.getNotFoundInstance();
        hashtable = ((StringBuffer) (obj)).toString();
        if(!checkChecksum(hashtable))
            throw ChecksumException.getChecksumInstance();
        float f = (float)(ai[1] + ai[0]) / 2.0F;
        float f1 = (float)(ai1[1] + ai1[0]) / 2.0F;
        obj = getBarcodeFormat();
        ai = new Result(hashtable, null, new ResultPoint[] {
            new ResultPoint(f, i), new ResultPoint(f1, i)
        }, ((BarcodeFormat) (obj)));
        try
        {
            bitarray = extensionReader.decodeRow(i, bitarray, ai1[1]);
            ai.putAllMetadata(bitarray.getResultMetadata());
            ai.addResultPoints(bitarray.getResultPoints());
        }
        // Misplaced declaration of an exception variable
        catch(BitArray bitarray) { }
        if(BarcodeFormat.EAN_13.equals(obj) || BarcodeFormat.UPC_A.equals(obj))
        {
            bitarray = eanManSupport.lookupCountryIdentifier(hashtable);
            if(bitarray != null)
                ai.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, bitarray);
        }
        return ai;
    }

    abstract BarcodeFormat getBarcodeFormat();

    static final int L_AND_G_PATTERNS[][];
    static final int L_PATTERNS[][] = {
        {
            3, 2, 1, 1
        }, {
            2, 2, 2, 1
        }, {
            2, 1, 2, 2
        }, {
            1, 4, 1, 1
        }, {
            1, 1, 3, 2
        }, {
            1, 2, 3, 1
        }, {
            1, 1, 1, 4
        }, {
            1, 3, 1, 2
        }, {
            1, 2, 1, 3
        }, {
            3, 1, 1, 2
        }
    };
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 179;
    static final int MIDDLE_PATTERN[] = {
        1, 1, 1, 1, 1
    };
    static final int START_END_PATTERN[] = {
        1, 1, 1
    };
    private final StringBuffer decodeRowStringBuffer = new StringBuffer(20);
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();

    static 
    {
        L_AND_G_PATTERNS = new int[20][];
        for(int i = 0; i < 10; i++)
            L_AND_G_PATTERNS[i] = L_PATTERNS[i];

        for(int j = 10; j < 20; j++)
        {
            int ai[] = L_PATTERNS[j - 10];
            int ai1[] = new int[ai.length];
            for(int k = 0; k < ai.length; k++)
                ai1[k] = ai[ai.length - k - 1];

            L_AND_G_PATTERNS[j] = ai1;
        }

    }
}
