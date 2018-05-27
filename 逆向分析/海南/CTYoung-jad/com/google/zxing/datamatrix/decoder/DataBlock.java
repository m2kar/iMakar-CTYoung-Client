// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.datamatrix.decoder;


// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            Version

final class DataBlock
{

    private DataBlock(int i, byte abyte0[])
    {
        numDataCodewords = i;
        codewords = abyte0;
    }

    static DataBlock[] getDataBlocks(byte abyte0[], Version version)
    {
        Version.ECBlocks ecblocks = version.getECBlocks();
        int i1 = 0;
        Version.ECB aecb[] = ecblocks.getECBlocks();
        for(int i = 0; i < aecb.length; i++)
            i1 += aecb[i].getCount();

        DataBlock adatablock[] = new DataBlock[i1];
        i1 = 0;
        for(int j = 0; j < aecb.length; j++)
        {
            Version.ECB ecb = aecb[j];
            for(int j1 = 0; j1 < ecb.getCount();)
            {
                int i2 = ecb.getDataCodewords();
                adatablock[i1] = new DataBlock(i2, new byte[ecblocks.getECCodewords() + i2]);
                j1++;
                i1++;
            }

        }

        int i3 = adatablock[0].codewords.length - ecblocks.getECCodewords();
        int k = 0;
        for(int k1 = 0; k1 < i3 - 1; k1++)
        {
            for(int j2 = 0; j2 < i1;)
            {
                adatablock[j2].codewords[k1] = abyte0[k];
                j2++;
                k++;
            }

        }

        int l1;
        boolean flag;
        int k2;
        if(version.getVersionNumber() == 24)
            flag = true;
        else
            flag = false;
        if(flag)
            l1 = 8;
        else
            l1 = i1;
        for(k2 = 0; k2 < l1;)
        {
            adatablock[k2].codewords[i3 - 1] = abyte0[k];
            k2++;
            k++;
        }

        int k3 = adatablock[0].codewords.length;
        k2 = i3;
        l1 = k;
        for(int l = k2; l < k3; l++)
        {
            int l2 = 0;
            while(l2 < i1) 
            {
                int j3;
                if(flag && l2 > 7)
                    j3 = l - 1;
                else
                    j3 = l;
                adatablock[l2].codewords[j3] = abyte0[l1];
                l2++;
                l1++;
            }
        }

        if(l1 != abyte0.length)
            throw new IllegalArgumentException();
        else
            return adatablock;
    }

    byte[] getCodewords()
    {
        return codewords;
    }

    int getNumDataCodewords()
    {
        return numDataCodewords;
    }

    private final byte codewords[];
    private final int numDataCodewords;
}
