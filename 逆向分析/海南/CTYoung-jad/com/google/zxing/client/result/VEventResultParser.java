// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, VCardResultParser, CalendarParsedResult

final class VEventResultParser extends ResultParser
{

    private VEventResultParser()
    {
    }

    public static CalendarParsedResult parse(Result result)
    {
        String s3 = result.getText();
        if(s3 == null)
            return null;
        if(s3.indexOf("BEGIN:VEVENT") < 0)
            return null;
        result = VCardResultParser.matchSingleVCardPrefixedField("SUMMARY", s3, true);
        String s = VCardResultParser.matchSingleVCardPrefixedField("DTSTART", s3, true);
        String s1 = VCardResultParser.matchSingleVCardPrefixedField("DTEND", s3, true);
        String s2 = VCardResultParser.matchSingleVCardPrefixedField("LOCATION", s3, true);
        s3 = VCardResultParser.matchSingleVCardPrefixedField("DESCRIPTION", s3, true);
        try
        {
            result = new CalendarParsedResult(result, s, s1, s2, null, s3);
        }
        // Misplaced declaration of an exception variable
        catch(Result result)
        {
            return null;
        }
        return result;
    }
}
