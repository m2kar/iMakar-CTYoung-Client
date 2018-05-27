// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            GeneralAppIdDecoder, AI01AndOtherAIs, AnyAIDecoder, AI013103decoder, 
//            AI01320xDecoder, AI01392xDecoder, AI01393xDecoder, AI013x0x1xDecoder

public abstract class AbstractExpandedDecoder
{

    AbstractExpandedDecoder(BitArray bitarray)
    {
        information = bitarray;
        generalDecoder = new GeneralAppIdDecoder(bitarray);
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitarray)
    {
        if(bitarray.get(1))
            return new AI01AndOtherAIs(bitarray);
        if(!bitarray.get(2))
            return new AnyAIDecoder(bitarray);
        switch(GeneralAppIdDecoder.extractNumericValueFromBitArray(bitarray, 1, 4))
        {
        default:
            switch(GeneralAppIdDecoder.extractNumericValueFromBitArray(bitarray, 1, 5))
            {
            default:
                switch(GeneralAppIdDecoder.extractNumericValueFromBitArray(bitarray, 1, 7))
                {
                default:
                    throw new IllegalStateException("unknown decoder: " + bitarray);

                case 56: // '8'
                    return new AI013x0x1xDecoder(bitarray, "310", "11");

                case 57: // '9'
                    return new AI013x0x1xDecoder(bitarray, "320", "11");

                case 58: // ':'
                    return new AI013x0x1xDecoder(bitarray, "310", "13");

                case 59: // ';'
                    return new AI013x0x1xDecoder(bitarray, "320", "13");

                case 60: // '<'
                    return new AI013x0x1xDecoder(bitarray, "310", "15");

                case 61: // '='
                    return new AI013x0x1xDecoder(bitarray, "320", "15");

                case 62: // '>'
                    return new AI013x0x1xDecoder(bitarray, "310", "17");

                case 63: // '?'
                    return new AI013x0x1xDecoder(bitarray, "320", "17");
                }

            case 12: // '\f'
                return new AI01392xDecoder(bitarray);

            case 13: // '\r'
                return new AI01393xDecoder(bitarray);
            }

        case 4: // '\004'
            return new AI013103decoder(bitarray);

        case 5: // '\005'
            return new AI01320xDecoder(bitarray);
        }
    }

    public abstract String parseInformation()
        throws NotFoundException;

    protected final GeneralAppIdDecoder generalDecoder;
    protected final BitArray information;
}
