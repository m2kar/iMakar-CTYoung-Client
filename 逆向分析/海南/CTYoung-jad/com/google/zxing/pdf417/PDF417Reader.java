// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.pdf417;

import com.google.zxing.*;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.pdf417.decoder.Decoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.Hashtable;

public final class PDF417Reader
    implements Reader
{

    public PDF417Reader()
    {
    }

    public Result decode(BinaryBitmap binarybitmap)
        throws NotFoundException, FormatException
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Hashtable hashtable)
        throws NotFoundException, FormatException
    {
        if(hashtable != null && hashtable.containsKey(DecodeHintType.PURE_BARCODE))
        {
            binarybitmap = QRCodeReader.extractPureBits(binarybitmap.getBlackMatrix());
            binarybitmap = decoder.decode(binarybitmap);
            hashtable = NO_POINTS;
        } else
        {
            hashtable = (new Detector(binarybitmap)).detect();
            binarybitmap = decoder.decode(hashtable.getBits());
            hashtable = hashtable.getPoints();
        }
        return new Result(binarybitmap.getText(), binarybitmap.getRawBytes(), hashtable, BarcodeFormat.PDF417);
    }

    public void reset()
    {
    }

    private static final ResultPoint NO_POINTS[] = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

}
