// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.multi;

import com.google.zxing.*;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.multi:
//            MultipleBarcodeReader

public final class GenericMultipleBarcodeReader
    implements MultipleBarcodeReader
{

    public GenericMultipleBarcodeReader(Reader reader)
    {
        _flddelegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binarybitmap, Hashtable hashtable, Vector vector, int i, int j)
    {
        int k;
        Result result;
        boolean flag;
        boolean flag1;
        try
        {
            result = _flddelegate.decode(binarybitmap, hashtable);
        }
        // Misplaced declaration of an exception variable
        catch(BinaryBitmap binarybitmap)
        {
            return;
        }
        flag1 = false;
        k = 0;
_L10:
        flag = flag1;
        if(k >= vector.size()) goto _L2; else goto _L1
_L1:
        if(!((Result)vector.elementAt(k)).getText().equals(result.getText())) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        if(!flag) goto _L6; else goto _L5
_L5:
        return;
_L4:
        k++;
        continue; /* Loop/switch isn't completed */
_L6:
        ResultPoint aresultpoint[];
        vector.addElement(translateResultPoints(result, i, j));
        aresultpoint = result.getResultPoints();
        if(aresultpoint == null || aresultpoint.length == 0) goto _L5; else goto _L7
_L7:
        float f;
        int i1;
        int j1;
        i1 = binarybitmap.getWidth();
        j1 = binarybitmap.getHeight();
        float f7 = i1;
        float f4 = j1;
        float f3 = 0.0F;
        f = 0.0F;
        for(int l = 0; l < aresultpoint.length;)
        {
            ResultPoint resultpoint = aresultpoint[l];
            float f6 = resultpoint.getX();
            float f1 = resultpoint.getY();
            float f2 = f7;
            if(f6 < f7)
                f2 = f6;
            float f5 = f4;
            if(f1 < f4)
                f5 = f1;
            f4 = f3;
            if(f6 > f3)
                f4 = f6;
            f6 = f;
            if(f1 > f)
                f6 = f1;
            l++;
            f3 = f4;
            f = f6;
            f7 = f2;
            f4 = f5;
        }

        if(f7 > 100F)
            doDecodeMultiple(binarybitmap.crop(0, 0, (int)f7, j1), hashtable, vector, i, j);
        if(f4 > 100F)
            doDecodeMultiple(binarybitmap.crop(0, 0, i1, (int)f4), hashtable, vector, i, j);
        if(f3 < (float)(i1 - 100))
            doDecodeMultiple(binarybitmap.crop((int)f3, 0, i1 - (int)f3, j1), hashtable, vector, i + (int)f3, j);
        if(f >= (float)(j1 - 100)) goto _L5; else goto _L8
_L8:
        doDecodeMultiple(binarybitmap.crop(0, (int)f, i1, j1 - (int)f), hashtable, vector, i, j + (int)f);
        return;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private static Result translateResultPoints(Result result, int i, int j)
    {
        ResultPoint aresultpoint[] = result.getResultPoints();
        ResultPoint aresultpoint1[] = new ResultPoint[aresultpoint.length];
        for(int k = 0; k < aresultpoint.length; k++)
        {
            ResultPoint resultpoint = aresultpoint[k];
            aresultpoint1[k] = new ResultPoint(resultpoint.getX() + (float)i, resultpoint.getY() + (float)j);
        }

        return new Result(result.getText(), result.getRawBytes(), aresultpoint1, result.getBarcodeFormat());
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
        doDecodeMultiple(binarybitmap, hashtable, vector, 0, 0);
        if(vector.isEmpty())
            throw NotFoundException.getNotFoundInstance();
        int j = vector.size();
        binarybitmap = new Result[j];
        for(int i = 0; i < j; i++)
            binarybitmap[i] = (Result)vector.elementAt(i);

        return binarybitmap;
    }

    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader _flddelegate;
}
