// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode;

import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.detector.Detector;
import java.util.Hashtable;

public class QRCodeReader
    implements Reader
{

    public QRCodeReader()
    {
    }

    public static BitMatrix extractPureBits(BitMatrix bitmatrix)
        throws NotFoundException
    {
        int k1 = bitmatrix.getHeight();
        int l1 = bitmatrix.getWidth();
        int i1 = Math.min(k1, l1);
        int ai[] = bitmatrix.getTopLeftOnBit();
        if(ai == null)
            throw NotFoundException.getNotFoundInstance();
        int k = ai[0];
        int i;
        for(i = ai[1]; k < i1 && i < i1 && bitmatrix.get(k, i); i++)
            k++;

        if(k == i1 || i == i1)
            throw NotFoundException.getNotFoundInstance();
        int j1 = k - ai[0];
        if(j1 == 0)
            throw NotFoundException.getNotFoundInstance();
        for(i1 = l1 - 1; i1 > k && !bitmatrix.get(i1, i); i1--);
        if(i1 <= k)
            throw NotFoundException.getNotFoundInstance();
        i1++;
        if((i1 - k) % j1 != 0)
            throw NotFoundException.getNotFoundInstance();
        int i2 = (i1 - k) / j1 + 1;
        int j2;
        if(j1 == 1)
            i1 = 1;
        else
            i1 = j1 >> 1;
        j2 = k - i1;
        i1 = i - i1;
        if((i2 - 1) * j1 + j2 >= l1 || (i2 - 1) * j1 + i1 >= k1)
            throw NotFoundException.getNotFoundInstance();
        BitMatrix bitmatrix1 = new BitMatrix(i2);
        for(int j = 0; j < i2; j++)
        {
            for(int l = 0; l < i2; l++)
                if(bitmatrix.get(l * j1 + j2, i1 + j * j1))
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
            binarybitmap = decoder.decode(binarybitmap, hashtable);
            hashtable = NO_POINTS;
        } else
        {
            DetectorResult detectorresult = (new Detector(binarybitmap.getBlackMatrix())).detect(hashtable);
            binarybitmap = decoder.decode(detectorresult.getBits(), hashtable);
            hashtable = detectorresult.getPoints();
        }
        hashtable = new Result(binarybitmap.getText(), binarybitmap.getRawBytes(), hashtable, BarcodeFormat.QR_CODE);
        if(binarybitmap.getByteSegments() != null)
            hashtable.putMetadata(ResultMetadataType.BYTE_SEGMENTS, binarybitmap.getByteSegments());
        if(binarybitmap.getECLevel() != null)
            hashtable.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, binarybitmap.getECLevel().toString());
        return hashtable;
    }

    protected Decoder getDecoder()
    {
        return decoder;
    }

    public void reset()
    {
    }

    private static final ResultPoint NO_POINTS[] = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

}
