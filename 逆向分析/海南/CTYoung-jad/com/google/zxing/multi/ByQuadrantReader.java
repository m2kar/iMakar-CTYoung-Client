// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.multi;

import com.google.zxing.*;
import java.util.Hashtable;

public final class ByQuadrantReader
    implements Reader
{

    public ByQuadrantReader(Reader reader)
    {
        _flddelegate = reader;
    }

    public Result decode(BinaryBitmap binarybitmap)
        throws NotFoundException, ChecksumException, FormatException
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Hashtable hashtable)
        throws NotFoundException, ChecksumException, FormatException
    {
        int j = binarybitmap.getWidth();
        int i = binarybitmap.getHeight();
        j /= 2;
        i /= 2;
        Object obj = binarybitmap.crop(0, 0, j, i);
        try
        {
            obj = _flddelegate.decode(((BinaryBitmap) (obj)), hashtable);
        }
        catch(NotFoundException notfoundexception)
        {
            Object obj1 = binarybitmap.crop(j, 0, j, i);
            try
            {
                obj1 = _flddelegate.decode(((BinaryBitmap) (obj1)), hashtable);
            }
            catch(NotFoundException notfoundexception1)
            {
                Object obj2 = binarybitmap.crop(0, i, j, i);
                try
                {
                    obj2 = _flddelegate.decode(((BinaryBitmap) (obj2)), hashtable);
                }
                catch(NotFoundException notfoundexception2)
                {
                    Object obj3 = binarybitmap.crop(j, i, j, i);
                    try
                    {
                        obj3 = _flddelegate.decode(((BinaryBitmap) (obj3)), hashtable);
                    }
                    catch(NotFoundException notfoundexception3)
                    {
                        binarybitmap = binarybitmap.crop(j / 2, i / 2, j, i);
                        return _flddelegate.decode(binarybitmap, hashtable);
                    }
                    return ((Result) (obj3));
                }
                return ((Result) (obj2));
            }
            return ((Result) (obj1));
        }
        return ((Result) (obj));
    }

    public void reset()
    {
        _flddelegate.reset();
    }

    private final Reader _flddelegate;
}
