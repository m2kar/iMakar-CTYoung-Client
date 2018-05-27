// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.*;

// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            BitMatrixParser, DataBlock, DecodedBitStreamParser

public final class Decoder
{

    public Decoder()
    {
        rsDecoder = new ReedSolomonDecoder(GF256.DATA_MATRIX_FIELD);
    }

    private void correctErrors(byte abyte0[], int i)
        throws ChecksumException
    {
        int l = abyte0.length;
        int ai[] = new int[l];
        for(int j = 0; j < l; j++)
            ai[j] = abyte0[j] & 0xff;

        int k = abyte0.length;
        try
        {
            rsDecoder.decode(ai, k - i);
        }
        // Misplaced declaration of an exception variable
        catch(byte abyte0[])
        {
            throw ChecksumException.getChecksumInstance();
        }
        for(k = 0; k < i; k++)
            abyte0[k] = (byte)ai[k];

    }

    public DecoderResult decode(BitMatrix bitmatrix)
        throws FormatException, ChecksumException
    {
        BitMatrixParser bitmatrixparser = new BitMatrixParser(bitmatrix);
        bitmatrix = bitmatrixparser.readVersion(bitmatrix);
        bitmatrix = DataBlock.getDataBlocks(bitmatrixparser.readCodewords(), bitmatrix);
        int k = 0;
        for(int i = 0; i < bitmatrix.length; i++)
            k += bitmatrix[i].getNumDataCodewords();

        byte abyte0[] = new byte[k];
        int j = 0;
        for(int l = 0; l < bitmatrix.length; l++)
        {
            DataBlock datablock = bitmatrix[l];
            byte abyte1[] = datablock.getCodewords();
            int j1 = datablock.getNumDataCodewords();
            correctErrors(abyte1, j1);
            for(int i1 = 0; i1 < j1;)
            {
                abyte0[j] = abyte1[i1];
                i1++;
                j++;
            }

        }

        return DecodedBitStreamParser.decode(abyte0);
    }

    public DecoderResult decode(boolean aflag[][])
        throws FormatException, ChecksumException
    {
        int k = aflag.length;
        BitMatrix bitmatrix = new BitMatrix(k);
        for(int i = 0; i < k; i++)
        {
            for(int j = 0; j < k; j++)
                if(aflag[i][j])
                    bitmatrix.set(j, i);

        }

        return decode(bitmatrix);
    }

    private final ReedSolomonDecoder rsDecoder;
}
