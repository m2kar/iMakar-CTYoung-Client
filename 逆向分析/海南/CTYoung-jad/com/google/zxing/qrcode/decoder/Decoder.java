// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.*;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            BitMatrixParser, FormatInformation, DataBlock, DecodedBitStreamParser

public final class Decoder
{

    public Decoder()
    {
        rsDecoder = new ReedSolomonDecoder(GF256.QR_CODE_FIELD);
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
        throws ChecksumException, FormatException, NotFoundException
    {
        return decode(bitmatrix, null);
    }

    public DecoderResult decode(BitMatrix bitmatrix, Hashtable hashtable)
        throws FormatException, ChecksumException
    {
        BitMatrixParser bitmatrixparser = new BitMatrixParser(bitmatrix);
        bitmatrix = bitmatrixparser.readVersion();
        ErrorCorrectionLevel errorcorrectionlevel = bitmatrixparser.readFormatInformation().getErrorCorrectionLevel();
        DataBlock adatablock[] = DataBlock.getDataBlocks(bitmatrixparser.readCodewords(), bitmatrix, errorcorrectionlevel);
        int k = 0;
        for(int i = 0; i < adatablock.length; i++)
            k += adatablock[i].getNumDataCodewords();

        byte abyte0[] = new byte[k];
        int j = 0;
        for(int l = 0; l < adatablock.length; l++)
        {
            DataBlock datablock = adatablock[l];
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

        return DecodedBitStreamParser.decode(abyte0, bitmatrix, errorcorrectionlevel, hashtable);
    }

    public DecoderResult decode(boolean aflag[][])
        throws ChecksumException, FormatException, NotFoundException
    {
        return decode(aflag, null);
    }

    public DecoderResult decode(boolean aflag[][], Hashtable hashtable)
        throws ChecksumException, FormatException, NotFoundException
    {
        int k = aflag.length;
        BitMatrix bitmatrix = new BitMatrix(k);
        for(int i = 0; i < k; i++)
        {
            for(int j = 0; j < k; j++)
                if(aflag[i][j])
                    bitmatrix.set(j, i);

        }

        return decode(bitmatrix, hashtable);
    }

    private final ReedSolomonDecoder rsDecoder;
}
