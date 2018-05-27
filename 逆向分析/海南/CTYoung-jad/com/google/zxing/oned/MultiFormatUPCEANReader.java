// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader, EAN13Reader, EAN8Reader, UPCEReader, 
//            UPCAReader, UPCEANReader

public final class MultiFormatUPCEANReader extends OneDReader
{

    public MultiFormatUPCEANReader(Hashtable hashtable)
    {
        if(hashtable == null)
            hashtable = null;
        else
            hashtable = (Vector)hashtable.get(DecodeHintType.POSSIBLE_FORMATS);
        readers = new Vector();
        if(hashtable == null) goto _L2; else goto _L1
_L1:
        if(!hashtable.contains(BarcodeFormat.EAN_13)) goto _L4; else goto _L3
_L3:
        readers.addElement(new EAN13Reader());
_L6:
        if(hashtable.contains(BarcodeFormat.EAN_8))
            readers.addElement(new EAN8Reader());
        if(hashtable.contains(BarcodeFormat.UPC_E))
            readers.addElement(new UPCEReader());
_L2:
        if(readers.isEmpty())
        {
            readers.addElement(new EAN13Reader());
            readers.addElement(new EAN8Reader());
            readers.addElement(new UPCEReader());
        }
        return;
_L4:
        if(hashtable.contains(BarcodeFormat.UPC_A))
            readers.addElement(new UPCAReader());
        if(true) goto _L6; else goto _L5
_L5:
    }

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException
    {
        int j;
        int k;
        int ai[];
        ai = UPCEANReader.findStartGuardPattern(bitarray);
        k = readers.size();
        j = 0;
_L2:
        Object obj;
        if(j >= k)
            break; /* Loop/switch isn't completed */
        obj = (UPCEANReader)readers.elementAt(j);
        obj = ((UPCEANReader) (obj)).decodeRow(i, bitarray, ai, hashtable);
        bitarray = ((BitArray) (obj));
        ReaderException readerexception;
        if(BarcodeFormat.EAN_13.equals(bitarray.getBarcodeFormat()) && bitarray.getText().charAt(0) == '0')
            i = 1;
        else
            i = 0;
        if(hashtable == null)
            hashtable = null;
        else
            hashtable = (Vector)hashtable.get(DecodeHintType.POSSIBLE_FORMATS);
        if(hashtable == null || hashtable.contains(BarcodeFormat.UPC_A))
            j = 1;
        else
            j = 0;
        hashtable = bitarray;
        if(i != 0)
        {
            hashtable = bitarray;
            if(j != 0)
                hashtable = new Result(bitarray.getText().substring(1), null, bitarray.getResultPoints(), BarcodeFormat.UPC_A);
        }
        return hashtable;
        readerexception;
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        throw NotFoundException.getNotFoundInstance();
    }

    public void reset()
    {
        int j = readers.size();
        for(int i = 0; i < j; i++)
            ((Reader)readers.elementAt(i)).reset();

    }

    private final Vector readers;
}
