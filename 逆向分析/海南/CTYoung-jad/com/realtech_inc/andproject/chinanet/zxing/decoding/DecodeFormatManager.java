// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.decoding;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import java.util.*;
import java.util.regex.Pattern;

final class DecodeFormatManager
{

    private DecodeFormatManager()
    {
    }

    static Vector parseDecodeFormats(Intent intent)
    {
        List list = null;
        String s = intent.getStringExtra("SCAN_FORMATS");
        if(s != null)
            list = Arrays.asList(COMMA_PATTERN.split(s));
        return parseDecodeFormats(((Iterable) (list)), intent.getStringExtra("SCAN_MODE"));
    }

    static Vector parseDecodeFormats(Uri uri)
    {
        List list1 = uri.getQueryParameters("SCAN_FORMATS");
        List list = list1;
        if(list1 != null)
        {
            list = list1;
            if(list1.size() == 1)
            {
                list = list1;
                if(list1.get(0) != null)
                    list = Arrays.asList(COMMA_PATTERN.split((CharSequence)list1.get(0)));
            }
        }
        return parseDecodeFormats(((Iterable) (list)), uri.getQueryParameter("SCAN_MODE"));
    }

    private static Vector parseDecodeFormats(Iterable iterable, String s)
    {
        if(iterable == null) goto _L2; else goto _L1
_L1:
        Vector vector = new Vector();
        Iterator iterator = iterable.iterator();
_L4:
        iterable = vector;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        vector.add(BarcodeFormat.valueOf((String)iterator.next()));
        if(true) goto _L4; else goto _L3
        iterable;
_L2:
        if(s == null)
            break MISSING_BLOCK_LABEL_109;
        if(!"PRODUCT_MODE".equals(s))
            break MISSING_BLOCK_LABEL_70;
        iterable = PRODUCT_FORMATS;
_L3:
        return iterable;
        if("QR_CODE_MODE".equals(s))
            return QR_CODE_FORMATS;
        if("DATA_MATRIX_MODE".equals(s))
            return DATA_MATRIX_FORMATS;
        if("ONE_D_MODE".equals(s))
            return ONE_D_FORMATS;
        return null;
    }

    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    static final Vector DATA_MATRIX_FORMATS;
    static final Vector ONE_D_FORMATS;
    static final Vector PRODUCT_FORMATS;
    static final Vector QR_CODE_FORMATS;

    static 
    {
        PRODUCT_FORMATS = new Vector(5);
        PRODUCT_FORMATS.add(BarcodeFormat.UPC_A);
        PRODUCT_FORMATS.add(BarcodeFormat.UPC_E);
        PRODUCT_FORMATS.add(BarcodeFormat.EAN_13);
        PRODUCT_FORMATS.add(BarcodeFormat.EAN_8);
        PRODUCT_FORMATS.add(BarcodeFormat.RSS14);
        ONE_D_FORMATS = new Vector(PRODUCT_FORMATS.size() + 4);
        ONE_D_FORMATS.addAll(PRODUCT_FORMATS);
        ONE_D_FORMATS.add(BarcodeFormat.CODE_39);
        ONE_D_FORMATS.add(BarcodeFormat.CODE_93);
        ONE_D_FORMATS.add(BarcodeFormat.CODE_128);
        ONE_D_FORMATS.add(BarcodeFormat.ITF);
        QR_CODE_FORMATS = new Vector(1);
        QR_CODE_FORMATS.add(BarcodeFormat.QR_CODE);
        DATA_MATRIX_FORMATS = new Vector(1);
        DATA_MATRIX_FORMATS.add(BarcodeFormat.DATA_MATRIX);
    }
}
