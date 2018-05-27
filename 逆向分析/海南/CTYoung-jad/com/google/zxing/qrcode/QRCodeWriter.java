// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Hashtable;

public final class QRCodeWriter
    implements Writer
{

    public QRCodeWriter()
    {
    }

    private static BitMatrix renderResult(QRCode qrcode, int i, int j)
    {
        qrcode = qrcode.getMatrix();
        int l1 = qrcode.getWidth();
        int i2 = qrcode.getHeight();
        int i1 = l1 + 8;
        int k1 = i2 + 8;
        int k = Math.max(i, i1);
        j = Math.max(j, k1);
        int j2 = Math.min(k / i1, j / k1);
        k1 = (k - l1 * j2) / 2;
        i = (j - i2 * j2) / 2;
        BitMatrix bitmatrix = new BitMatrix(k, j);
        for(j = 0; j < i2;)
        {
            int j1 = 0;
            for(int l = k1; j1 < l1; l += j2)
            {
                if(qrcode.get(j1, j) == 1)
                    bitmatrix.setRegion(l, i, j2, j2);
                j1++;
            }

            j++;
            i += j2;
        }

        return bitmatrix;
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j)
        throws WriterException
    {
        return encode(s, barcodeformat, i, j, null);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Hashtable hashtable)
        throws WriterException
    {
        if(s == null || s.length() == 0)
            throw new IllegalArgumentException("Found empty contents");
        if(barcodeformat != BarcodeFormat.QR_CODE)
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeformat);
        if(i < 0 || j < 0)
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + j);
        Object obj = ErrorCorrectionLevel.L;
        barcodeformat = ((BarcodeFormat) (obj));
        if(hashtable != null)
        {
            ErrorCorrectionLevel errorcorrectionlevel = (ErrorCorrectionLevel)hashtable.get(EncodeHintType.ERROR_CORRECTION);
            barcodeformat = ((BarcodeFormat) (obj));
            if(errorcorrectionlevel != null)
                barcodeformat = errorcorrectionlevel;
        }
        obj = new QRCode();
        Encoder.encode(s, barcodeformat, hashtable, ((QRCode) (obj)));
        return renderResult(((QRCode) (obj)), i, j);
    }

    private static final int QUIET_ZONE_SIZE = 4;
}
