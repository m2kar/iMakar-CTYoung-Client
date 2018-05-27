// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.datamatrix;

import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;

public final class DataMatrixReader
    implements Reader
{

    public DataMatrixReader()
    {
    }

    private static BitMatrix extractPureBits(BitMatrix bitmatrix)
        throws NotFoundException
    {
        int j1 = bitmatrix.getHeight();
        int k1 = bitmatrix.getWidth();
        int k = Math.min(j1, k1);
        int ai[] = bitmatrix.getTopLeftOnBit();
        if(ai == null)
            throw NotFoundException.getNotFoundInstance();
        int i = ai[0];
        int l1;
        for(l1 = ai[1]; i < k && l1 < k && bitmatrix.get(i, l1); i++);
        if(i == k)
            throw NotFoundException.getNotFoundInstance();
        int i1 = i - ai[0];
        for(k = k1 - 1; k >= 0 && !bitmatrix.get(k, l1); k--);
        if(k < 0)
            throw NotFoundException.getNotFoundInstance();
        k++;
        if((k - i) % i1 != 0)
            throw NotFoundException.getNotFoundInstance();
        int i2 = (k - i) / i1 + 2;
        int j2 = i - (i1 >> 1);
        l1 = (l1 + i1) - (i1 >> 1);
        if((i2 - 1) * i1 + j2 >= k1 || (i2 - 1) * i1 + l1 >= j1)
            throw NotFoundException.getNotFoundInstance();
        BitMatrix bitmatrix1 = new BitMatrix(i2);
        for(int j = 0; j < i2; j++)
        {
            for(int l = 0; l < i2; l++)
                if(bitmatrix.get(l * i1 + j2, l1 + j * i1))
                    bitmatrix1.set(l, j);

        }

        return bitmatrix1;
    }

    public Result decode(BinaryBitmap binarybitmap)
        throws NotFoundException, ChecksumException, FormatException
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Hashtable hashtable)
        throws NotFoundException, ChecksumException, FormatException
    {
        if(hashtable != null && hashtable.containsKey(DecodeHintType.PURE_BARCODE))
        {
            binarybitmap = extractPureBits(binarybitmap.getBlackMatrix());
            binarybitmap = decoder.decode(binarybitmap);
            hashtable = NO_POINTS;
        } else
        {
            hashtable = (new Detector(binarybitmap.getBlackMatrix())).detect();
            binarybitmap = decoder.decode(hashtable.getBits());
            hashtable = hashtable.getPoints();
        }
        hashtable = new Result(binarybitmap.getText(), binarybitmap.getRawBytes(), hashtable, BarcodeFormat.DATA_MATRIX);
        if(binarybitmap.getByteSegments() != null)
            hashtable.putMetadata(ResultMetadataType.BYTE_SEGMENTS, binarybitmap.getByteSegments());
        if(binarybitmap.getECLevel() != null)
            hashtable.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, binarybitmap.getECLevel().toString());
        return hashtable;
    }

    public void reset()
    {
    }

    private static final ResultPoint NO_POINTS[] = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

}
