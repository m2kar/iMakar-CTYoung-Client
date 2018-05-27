// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class SMSParsedResult extends ParsedResult
{

    public SMSParsedResult(String s, String s1, String s2, String s3)
    {
        super(ParsedResultType.SMS);
        numbers = (new String[] {
            s
        });
        vias = (new String[] {
            s1
        });
        subject = s2;
        body = s3;
    }

    public SMSParsedResult(String as[], String as1[], String s, String s1)
    {
        super(ParsedResultType.SMS);
        numbers = as;
        vias = as1;
        subject = s;
        body = s1;
    }

    public String getBody()
    {
        return body;
    }

    public String getDisplayResult()
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        maybeAppend(numbers, stringbuffer);
        maybeAppend(subject, stringbuffer);
        maybeAppend(body, stringbuffer);
        return stringbuffer.toString();
    }

    public String[] getNumbers()
    {
        return numbers;
    }

    public String getSMSURI()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("sms:");
        boolean flag1 = true;
        int i = 0;
        while(i < numbers.length) 
        {
            if(flag1)
                flag1 = false;
            else
                stringbuffer.append(',');
            stringbuffer.append(numbers[i]);
            if(vias[i] != null)
            {
                stringbuffer.append(";via=");
                stringbuffer.append(vias[i]);
            }
            i++;
        }
        boolean flag;
        if(body != null)
            flag = true;
        else
            flag = false;
        if(subject != null)
            flag1 = true;
        else
            flag1 = false;
        if(flag || flag1)
        {
            stringbuffer.append('?');
            if(flag)
            {
                stringbuffer.append("body=");
                stringbuffer.append(body);
            }
            if(flag1)
            {
                if(flag)
                    stringbuffer.append('&');
                stringbuffer.append("subject=");
                stringbuffer.append(subject);
            }
        }
        return stringbuffer.toString();
    }

    public String getSubject()
    {
        return subject;
    }

    public String[] getVias()
    {
        return vias;
    }

    private final String body;
    private final String numbers[];
    private final String subject;
    private final String vias[];
}
