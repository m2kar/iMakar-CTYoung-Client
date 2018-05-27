// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.encoder;


// Referenced classes of package com.google.zxing.qrcode.encoder:
//            ByteMatrix, QRCode

public final class MaskUtil
{

    private MaskUtil()
    {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix bytematrix)
    {
        return applyMaskPenaltyRule1Internal(bytematrix, true) + applyMaskPenaltyRule1Internal(bytematrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix bytematrix, boolean flag)
    {
        int j1 = 0;
        byte byte0 = -1;
        int k;
        int l;
        int i1;
        if(flag)
            k = bytematrix.getHeight();
        else
            k = bytematrix.getWidth();
        if(flag)
            l = bytematrix.getWidth();
        else
            l = bytematrix.getHeight();
        bytematrix = bytematrix.getArray();
        i1 = 0;
        do
        {
            int l1 = 0;
            if(i1 >= k)
                break;
            int k1 = 0;
            while(k1 < l) 
            {
                int i;
                int j;
                int i2;
                if(flag)
                    i = bytematrix[i1][k1];
                else
                    i = bytematrix[k1][i1];
                if(i == byte0)
                {
                    l1++;
                    if(l1 == 5)
                    {
                        j = j1 + 3;
                        i2 = byte0;
                        i = l1;
                    } else
                    {
                        i = l1;
                        j = j1;
                        i2 = byte0;
                        if(l1 > 5)
                        {
                            j = j1 + 1;
                            i = l1;
                            i2 = byte0;
                        }
                    }
                } else
                {
                    j = 1;
                    i2 = i;
                    i = j;
                    j = j1;
                }
                k1++;
                l1 = i;
                j1 = j;
                byte0 = i2;
            }
            i1++;
        } while(true);
        return j1;
    }

    public static int applyMaskPenaltyRule2(ByteMatrix bytematrix)
    {
        int j = 0;
        byte abyte0[][] = bytematrix.getArray();
        int i1 = bytematrix.getWidth();
        int j1 = bytematrix.getHeight();
        for(int i = 0; i < j1 - 1; i++)
        {
            for(int k = 0; k < i1 - 1;)
            {
                byte byte0 = abyte0[i][k];
                int l = j;
                if(byte0 == abyte0[i][k + 1])
                {
                    l = j;
                    if(byte0 == abyte0[i + 1][k])
                    {
                        l = j;
                        if(byte0 == abyte0[i + 1][k + 1])
                            l = j + 3;
                    }
                }
                k++;
                j = l;
            }

        }

        return j;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix bytematrix)
    {
        int i = 0;
        byte abyte0[][] = bytematrix.getArray();
        int i1 = bytematrix.getWidth();
        int j1 = bytematrix.getHeight();
        int k = 0;
        do
        {
            if(k >= j1)
                break;
            for(int l = 0; l < i1; l++)
            {
                int j;
label0:
                {
                    j = i;
                    if(l + 6 >= i1)
                        break label0;
                    j = i;
                    if(abyte0[k][l] != 1)
                        break label0;
                    j = i;
                    if(abyte0[k][l + 1] != 0)
                        break label0;
                    j = i;
                    if(abyte0[k][l + 2] != 1)
                        break label0;
                    j = i;
                    if(abyte0[k][l + 3] != 1)
                        break label0;
                    j = i;
                    if(abyte0[k][l + 4] != 1)
                        break label0;
                    j = i;
                    if(abyte0[k][l + 5] != 0)
                        break label0;
                    j = i;
                    if(abyte0[k][l + 6] != 1)
                        break label0;
                    if(l + 10 >= i1 || abyte0[k][l + 7] != 0 || abyte0[k][l + 8] != 0 || abyte0[k][l + 9] != 0 || abyte0[k][l + 10] != 0)
                    {
                        j = i;
                        if(l - 4 < 0)
                            break label0;
                        j = i;
                        if(abyte0[k][l - 1] != 0)
                            break label0;
                        j = i;
                        if(abyte0[k][l - 2] != 0)
                            break label0;
                        j = i;
                        if(abyte0[k][l - 3] != 0)
                            break label0;
                        j = i;
                        if(abyte0[k][l - 4] != 0)
                            break label0;
                    }
                    j = i + 40;
                }
                i = j;
                if(k + 6 >= j1)
                    continue;
                i = j;
                if(abyte0[k][l] != 1)
                    continue;
                i = j;
                if(abyte0[k + 1][l] != 0)
                    continue;
                i = j;
                if(abyte0[k + 2][l] != 1)
                    continue;
                i = j;
                if(abyte0[k + 3][l] != 1)
                    continue;
                i = j;
                if(abyte0[k + 4][l] != 1)
                    continue;
                i = j;
                if(abyte0[k + 5][l] != 0)
                    continue;
                i = j;
                if(abyte0[k + 6][l] != 1)
                    continue;
                if(k + 10 >= j1 || abyte0[k + 7][l] != 0 || abyte0[k + 8][l] != 0 || abyte0[k + 9][l] != 0 || abyte0[k + 10][l] != 0)
                {
                    i = j;
                    if(k - 4 < 0)
                        continue;
                    i = j;
                    if(abyte0[k - 1][l] != 0)
                        continue;
                    i = j;
                    if(abyte0[k - 2][l] != 0)
                        continue;
                    i = j;
                    if(abyte0[k - 3][l] != 0)
                        continue;
                    i = j;
                    if(abyte0[k - 4][l] != 0)
                        continue;
                }
                i = j + 40;
            }

            k++;
        } while(true);
        return i;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix bytematrix)
    {
        int k = 0;
        byte abyte0[][] = bytematrix.getArray();
        int k1 = bytematrix.getWidth();
        int l1 = bytematrix.getHeight();
        for(int i = 0; i < l1; i++)
        {
            for(int l = 0; l < k1;)
            {
                int j1 = k;
                if(abyte0[i][l] == 1)
                    j1 = k + 1;
                l++;
                k = j1;
            }

        }

        int j = bytematrix.getHeight();
        int i1 = bytematrix.getWidth();
        return (Math.abs((int)(100D * ((double)k / (double)(j * i1)) - 50D)) / 5) * 10;
    }

    public static boolean getDataMaskBit(int i, int j, int k)
    {
        if(!QRCode.isValidMaskPattern(i))
            throw new IllegalArgumentException("Invalid mask pattern");
        i;
        JVM INSTR tableswitch 0 7: default 64
    //                   0 91
    //                   1 103
    //                   2 110
    //                   3 117
    //                   4 126
    //                   5 139
    //                   6 154
    //                   7 171;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break MISSING_BLOCK_LABEL_171;
_L1:
        throw new IllegalArgumentException("Invalid mask pattern: " + i);
_L2:
        i = k + j & 1;
_L10:
        return i == 0;
_L3:
        i = k & 1;
          goto _L10
_L4:
        i = j % 3;
          goto _L10
_L5:
        i = (k + j) % 3;
          goto _L10
_L6:
        i = (k >>> 1) + j / 3 & 1;
          goto _L10
_L7:
        i = k * j;
        i = (i & 1) + i % 3;
          goto _L10
_L8:
        i = k * j;
        i = (i & 1) + i % 3 & 1;
          goto _L10
        i = (k * j) % 3 + (k + j & 1) & 1;
          goto _L10
    }
}
