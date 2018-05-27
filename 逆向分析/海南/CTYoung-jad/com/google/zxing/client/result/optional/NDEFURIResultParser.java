// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result.optional;

import com.google.zxing.Result;
import com.google.zxing.client.result.URIParsedResult;

// Referenced classes of package com.google.zxing.client.result.optional:
//            AbstractNDEFResultParser, NDEFRecord

final class NDEFURIResultParser extends AbstractNDEFResultParser
{

    NDEFURIResultParser()
    {
    }

    static String decodeURIPayload(byte abyte0[])
    {
        int i = abyte0[0] & 0xff;
        String s = null;
        if(i < URI_PREFIXES.length)
            s = URI_PREFIXES[i];
        abyte0 = bytesToString(abyte0, 1, abyte0.length - 1, "UTF8");
        if(s == null)
            return abyte0;
        else
            return s + abyte0;
    }

    public static URIParsedResult parse(Result result)
    {
        result = result.getRawBytes();
        if(result != null)
            if((result = NDEFRecord.readRecord(result, 0)) != null && result.isMessageBegin() && result.isMessageEnd() && result.getType().equals("U"))
                return new URIParsedResult(decodeURIPayload(result.getPayload()), null);
        return null;
    }

    private static final String URI_PREFIXES[] = {
        null, "http://www.", "https://www.", "http://", "https://", "tel:", "mailto:", "ftp://anonymous:anonymous@", "ftp://ftp.", "ftps://", 
        "sftp://", "smb://", "nfs://", "ftp://", "dav://", "news:", "telnet://", "imap:", "rtsp://", "urn:", 
        "pop:", "sip:", "sips:", "tftp:", "btspp://", "btl2cap://", "btgoep://", "tcpobex://", "irdaobex://", "file://", 
        "urn:epc:id:", "urn:epc:tag:", "urn:epc:pat:", "urn:epc:raw:", "urn:epc:", "urn:nfc:"
    };

}
