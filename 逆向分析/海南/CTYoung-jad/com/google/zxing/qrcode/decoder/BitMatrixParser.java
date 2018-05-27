// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            FormatInformation, DataMask, Version

final class BitMatrixParser
{

    BitMatrixParser(BitMatrix bitmatrix)
        throws FormatException
    {
        int i = bitmatrix.getHeight();
        if(i < 21 || (i & 3) != 1)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            bitMatrix = bitmatrix;
            return;
        }
    }

    private int copyBit(int i, int j, int k)
    {
        if(bitMatrix.get(i, j))
            return k << 1 | 1;
        else
            return k << 1;
    }

    byte[] readCodewords()
        throws FormatException
    {
        int i;
        int j;
        int k;
        int l;
        boolean flag;
        int j2;
        Version version;
        Object obj;
        byte abyte0[];
        obj = readFormatInformation();
        version = readVersion();
        obj = DataMask.forReference(((FormatInformation) (obj)).getDataMask());
        j2 = bitMatrix.getHeight();
        ((DataMask) (obj)).unmaskBitMatrix(bitMatrix, j2);
        obj = version.buildFunctionPattern();
        flag = true;
        abyte0 = new byte[version.getTotalCodewords()];
        i = 0;
        k = 0;
        l = 0;
        j = j2 - 1;
_L6:
        if(j <= 0) goto _L2; else goto _L1
_L1:
        int k1;
        k1 = j;
        if(j == 6)
            k1 = j - 1;
        j = 0;
_L5:
        if(j >= j2) goto _L4; else goto _L3
_L3:
        int i1;
        int j1;
        int l1;
        int i2;
        if(flag)
            l1 = j2 - 1 - j;
        else
            l1 = j;
        i2 = 0;
        if(i2 >= 2)
            continue; /* Loop/switch isn't completed */
        j1 = l;
        i1 = k;
        if(((BitMatrix) (obj)).get(k1 - i2, l1))
            break MISSING_BLOCK_LABEL_268;
        l++;
        i1 = k << 1;
        k = i1;
        if(bitMatrix.get(k1 - i2, l1))
            k = i1 | 1;
        j1 = l;
        i1 = k;
        if(l != 8)
            break MISSING_BLOCK_LABEL_268;
        l = i + 1;
        abyte0[i] = (byte)k;
        i1 = 0;
        k = 0;
        i = l;
        l = i1;
_L7:
        i2++;
        if(true)
            break MISSING_BLOCK_LABEL_115;
        j++;
          goto _L5
_L4:
        flag ^= true;
        j = k1 - 2;
          goto _L6
_L2:
        if(i != version.getTotalCodewords())
            throw FormatException.getFormatInstance();
        else
            return abyte0;
        l = j1;
        k = i1;
          goto _L7
    }

    FormatInformation readFormatInformation()
        throws FormatException
    {
        if(parsedFormatInfo != null)
            return parsedFormatInfo;
        int l = 0;
        for(int i = 0; i < 6; i++)
            l = copyBit(i, 8, l);

        l = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, l)));
        for(int j = 5; j >= 0; j--)
            l = copyBit(8, j, l);

        int k1 = bitMatrix.getHeight();
        int k = 0;
        for(int i1 = k1 - 1; i1 >= k1 - 8; i1--)
            k = copyBit(i1, 8, k);

        for(int j1 = k1 - 7; j1 < k1; j1++)
            k = copyBit(8, j1, k);

        parsedFormatInfo = FormatInformation.decodeFormatInformation(l, k);
        if(parsedFormatInfo != null)
            return parsedFormatInfo;
        else
            throw FormatException.getFormatInstance();
    }

    Version readVersion()
        throws FormatException
    {
        if(parsedVersion != null)
            return parsedVersion;
        int k1 = bitMatrix.getHeight();
        int i = k1 - 17 >> 2;
        if(i <= 6)
            return Version.getVersionForNumber(i);
        int l = 0;
        int l1 = k1 - 11;
        for(int j = 5; j >= 0; j--)
        {
            for(int i1 = k1 - 9; i1 >= l1; i1--)
                l = copyBit(i1, j, l);

        }

        parsedVersion = Version.decodeVersionInformation(l);
        if(parsedVersion != null && parsedVersion.getDimensionForVersion() == k1)
            return parsedVersion;
        l = 0;
        for(int k = 5; k >= 0; k--)
        {
            for(int j1 = k1 - 9; j1 >= l1; j1--)
                l = copyBit(k, j1, l);

        }

        parsedVersion = Version.decodeVersionInformation(l);
        if(parsedVersion != null && parsedVersion.getDimensionForVersion() == k1)
            return parsedVersion;
        else
            throw FormatException.getFormatInstance();
    }

    private final BitMatrix bitMatrix;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;
}
