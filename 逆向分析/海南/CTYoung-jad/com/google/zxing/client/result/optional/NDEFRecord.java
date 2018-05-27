// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result.optional;


// Referenced classes of package com.google.zxing.client.result.optional:
//            AbstractNDEFResultParser

final class NDEFRecord
{

    private NDEFRecord(int i, String s, byte abyte0[], int j)
    {
        header = i;
        type = s;
        payload = abyte0;
        totalRecordLength = j;
    }

    static NDEFRecord readRecord(byte abyte0[], int i)
    {
        int j = abyte0[i] & 0xff;
        if(((j ^ 0x11) & 0x3f) != 0)
        {
            return null;
        } else
        {
            int k = abyte0[i + 1] & 0xff;
            int l = abyte0[i + 2] & 0xff;
            String s = AbstractNDEFResultParser.bytesToString(abyte0, i + 3, k, "US-ASCII");
            byte abyte1[] = new byte[l];
            System.arraycopy(abyte0, i + 3 + k, abyte1, 0, l);
            return new NDEFRecord(j, s, abyte1, k + 3 + l);
        }
    }

    byte[] getPayload()
    {
        return payload;
    }

    int getTotalRecordLength()
    {
        return totalRecordLength;
    }

    String getType()
    {
        return type;
    }

    boolean isMessageBegin()
    {
        return (header & 0x80) != 0;
    }

    boolean isMessageEnd()
    {
        return (header & 0x40) != 0;
    }

    public static final String ACTION_WELL_KNOWN_TYPE = "act";
    public static final String SMART_POSTER_WELL_KNOWN_TYPE = "Sp";
    private static final int SUPPORTED_HEADER = 17;
    private static final int SUPPORTED_HEADER_MASK = 63;
    public static final String TEXT_WELL_KNOWN_TYPE = "T";
    public static final String URI_WELL_KNOWN_TYPE = "U";
    private final int header;
    private final byte payload[];
    private final int totalRecordLength;
    private final String type;
}
