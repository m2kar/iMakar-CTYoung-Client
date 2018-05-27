// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

final class UPCEANExtensionSupport
{

    UPCEANExtensionSupport()
    {
    }

    private static int determineCheckDigit(int i)
        throws NotFoundException
    {
        for(int j = 0; j < 10; j++)
            if(i == CHECK_DIGIT_ENCODINGS[j])
                return j;

        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(String s)
    {
        int l = s.length();
        int k = 0;
        for(int i = l - 2; i >= 0; i -= 2)
            k += s.charAt(i) - 48;

        k *= 3;
        for(int j = l - 1; j >= 0; j -= 2)
            k += s.charAt(j) - 48;

        return (k * 3) % 10;
    }

    private static Integer parseExtension2String(String s)
    {
        return Integer.valueOf(s);
    }

    private static String parseExtension5String(String s)
    {
        String s1 = null;
        s.charAt(0);
        JVM INSTR lookupswitch 3: default 40
    //                   48: 86
    //                   53: 92
    //                   57: 98;
           goto _L1 _L2 _L3 _L4
_L1:
        s1 = "";
_L5:
        int i = Integer.parseInt(s.substring(1));
        return s1 + i / 100 + '.' + i % 100;
_L2:
        s1 = "\u62E2";
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = "$";
        if(true) goto _L5; else goto _L4
_L4:
        if("99991".equals(s))
            return "0.00";
        if("99990".equals(s))
            return "Used";
        if(true) goto _L5; else goto _L6
_L6:
    }

    private static Hashtable parseExtensionString(String s)
    {
        s.length();
        JVM INSTR tableswitch 2 5: default 36
    //                   2 38
    //                   3 36
    //                   4 36
    //                   5 71;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        return null;
_L2:
        Object obj;
        ResultMetadataType resultmetadatatype = ResultMetadataType.ISSUE_NUMBER;
        obj = parseExtension2String(s);
        s = resultmetadatatype;
_L4:
        if(obj != null)
        {
            Hashtable hashtable = new Hashtable(1);
            hashtable.put(s, obj);
            return hashtable;
        }
        if(true) goto _L1; else goto _L3
_L3:
        obj = ResultMetadataType.SUGGESTED_PRICE;
        String s1 = parseExtension5String(s);
        s = ((String) (obj));
        obj = s1;
          goto _L4
    }

    int decodeMiddle(BitArray bitarray, int ai[], StringBuffer stringbuffer)
        throws NotFoundException
    {
        int ai1[] = decodeMiddleCounters;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int l1 = bitarray.getSize();
        int i = ai[1];
        int j1 = 0;
        int k;
        for(int i1 = 0; i1 < 5 && i < l1; i = k)
        {
            int i2 = UPCEANReader.decodeDigit(bitarray, ai1, i, UPCEANReader.L_AND_G_PATTERNS);
            stringbuffer.append((char)(i2 % 10 + 48));
            for(int j = 0; j < ai1.length; j++)
                i += ai1[j];

            int k1 = j1;
            if(i2 >= 10)
                k1 = j1 | 1 << 4 - i1;
            k = i;
            if(i1 != 4)
            {
                k = i;
                do
                {
                    i = k;
                    if(k >= l1)
                        break;
                    i = k;
                    if(bitarray.get(k))
                        break;
                    k++;
                } while(true);
                do
                {
                    k = i;
                    if(i >= l1)
                        break;
                    k = i;
                    if(!bitarray.get(i))
                        break;
                    i++;
                } while(true);
            }
            i1++;
            j1 = k1;
        }

        if(stringbuffer.length() != 5)
            throw NotFoundException.getNotFoundInstance();
        int l = determineCheckDigit(j1);
        if(extensionChecksum(stringbuffer.toString()) != l)
            throw NotFoundException.getNotFoundInstance();
        else
            return i;
    }

    Result decodeRow(int i, BitArray bitarray, int j)
        throws NotFoundException
    {
        int ai[] = UPCEANReader.findGuardPattern(bitarray, j, false, EXTENSION_START_PATTERN);
        Object obj = decodeRowStringBuffer;
        ((StringBuffer) (obj)).setLength(0);
        j = decodeMiddle(bitarray, ai, ((StringBuffer) (obj)));
        obj = ((StringBuffer) (obj)).toString();
        bitarray = parseExtensionString(((String) (obj)));
        ResultPoint resultpoint = new ResultPoint((float)(ai[0] + ai[1]) / 2.0F, i);
        ResultPoint resultpoint1 = new ResultPoint(j, i);
        BarcodeFormat barcodeformat = BarcodeFormat.UPC_EAN_EXTENSION;
        obj = new Result(((String) (obj)), null, new ResultPoint[] {
            resultpoint, resultpoint1
        }, barcodeformat);
        if(bitarray != null)
            ((Result) (obj)).putAllMetadata(bitarray);
        return ((Result) (obj));
    }

    private static final int CHECK_DIGIT_ENCODINGS[] = {
        24, 20, 18, 17, 12, 6, 3, 10, 9, 5
    };
    private static final int EXTENSION_START_PATTERN[] = {
        1, 1, 2
    };
    private final int decodeMiddleCounters[] = new int[4];
    private final StringBuffer decodeRowStringBuffer = new StringBuffer();

}
