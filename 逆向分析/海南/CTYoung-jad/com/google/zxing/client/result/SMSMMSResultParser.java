// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, SMSParsedResult

final class SMSMMSResultParser extends ResultParser
{

    private SMSMMSResultParser()
    {
    }

    private static void addNumberVia(Vector vector, Vector vector1, String s)
    {
        int i = s.indexOf(';');
        if(i < 0)
        {
            vector.addElement(s);
            vector1.addElement(null);
            return;
        }
        vector.addElement(s.substring(0, i));
        vector = s.substring(i + 1);
        if(vector.startsWith("via="))
            vector = vector.substring(4);
        else
            vector = null;
        vector1.addElement(vector);
    }

    public static SMSParsedResult parse(Result result)
    {
        Object obj = result.getText();
        if(obj == null)
            return null;
        if(!((String) (obj)).startsWith("sms:") && !((String) (obj)).startsWith("SMS:") && !((String) (obj)).startsWith("mms:") && !((String) (obj)).startsWith("MMS:"))
            return null;
        Hashtable hashtable = parseNameValuePairs(((String) (obj)));
        String s1 = null;
        Vector vector = null;
        int j = 0;
        String s = vector;
        boolean flag = j;
        result = s1;
        if(hashtable != null)
        {
            s = vector;
            flag = j;
            result = s1;
            if(!hashtable.isEmpty())
            {
                result = (String)hashtable.get("subject");
                s = (String)hashtable.get("body");
                flag = true;
            }
        }
        j = ((String) (obj)).indexOf('?', 4);
        int i;
        if(j < 0 || !flag)
            s1 = ((String) (obj)).substring(4);
        else
            s1 = ((String) (obj)).substring(4, j);
        i = -1;
        vector = new Vector(1);
        obj = new Vector(1);
        do
        {
            j = s1.indexOf(',', i + 1);
            if(j > i)
            {
                addNumberVia(vector, ((Vector) (obj)), s1.substring(i + 1, j));
                i = j;
            } else
            {
                addNumberVia(vector, ((Vector) (obj)), s1.substring(i + 1));
                return new SMSParsedResult(toStringArray(vector), toStringArray(((Vector) (obj))), result, s);
            }
        } while(true);
    }
}
