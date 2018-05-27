// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.multi.qrcode;

import com.google.zxing.*;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;
import java.util.Vector;

public final class QRCodeMultiReader extends QRCodeReader
    implements MultipleBarcodeReader
{

    public QRCodeMultiReader()
    {
    }

    public Result[] decodeMultiple(BinaryBitmap binarybitmap)
        throws NotFoundException
    {
        return decodeMultiple(binarybitmap, null);
    }

    public Result[] decodeMultiple(BinaryBitmap binarybitmap, Hashtable hashtable)
        throws NotFoundException
    {
        Vector vector = new Vector();
        binarybitmap = (new MultiDetector(binarybitmap.getBlackMatrix())).detectMulti(hashtable);
        int i = 0;
        while(i < binarybitmap.length) 
        {
            try
            {
                hashtable = getDecoder().decode(binarybitmap[i].getBits());
                com.google.zxing.ResultPoint aresultpoint[] = binarybitmap[i].getPoints();
                Result result = new Result(hashtable.getText(), hashtable.getRawBytes(), aresultpoint, BarcodeFormat.QR_CODE);
                if(hashtable.getByteSegments() != null)
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, hashtable.getByteSegments());
                if(hashtable.getECLevel() != null)
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, hashtable.getECLevel().toString());
                vector.addElement(result);
            }
            // Misplaced declaration of an exception variable
            catch(Hashtable hashtable) { }
            i++;
        }
        if(!vector.isEmpty()) goto _L2; else goto _L1
_L1:
        binarybitmap = EMPTY_RESULT_ARRAY;
_L4:
        return binarybitmap;
_L2:
        hashtable = new Result[vector.size()];
        i = 0;
        do
        {
            binarybitmap = hashtable;
            if(i >= vector.size())
                continue;
            hashtable[i] = (Result)vector.elementAt(i);
            i++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final Result EMPTY_RESULT_ARRAY[] = new Result[0];

}
