// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, ExpandedProductParsedResult

final class ExpandedProductResultParser extends ResultParser
{

    private ExpandedProductResultParser()
    {
    }

    private static String findAIvalue(int i, String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if(s.charAt(i) != '(')
            return "ERROR";
        s = s.substring(i + 1);
        i = 0;
        do
        {
            if(i >= s.length())
                break;
            char c = s.charAt(i);
            switch(c)
            {
            case 42: // '*'
            case 43: // '+'
            case 44: // ','
            case 45: // '-'
            case 46: // '.'
            case 47: // '/'
            default:
                return "ERROR";

            case 48: // '0'
            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
                stringbuffer.append(c);
                i++;
                break;

            case 41: // ')'
                return stringbuffer.toString();
            }
        } while(true);
        return stringbuffer.toString();
    }

    private static String findValue(int i, String s)
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        s = s.substring(i);
        i = 0;
_L8:
        if(i >= s.length()) goto _L2; else goto _L1
_L1:
        char c = s.charAt(i);
        if(c != '(') goto _L4; else goto _L3
_L3:
        if(!"ERROR".equals(findAIvalue(i, s))) goto _L2; else goto _L5
_L5:
        stringbuffer.append('(');
_L6:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append(c);
        if(true) goto _L6; else goto _L2
_L2:
        return stringbuffer.toString();
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static ExpandedProductParsedResult parse(Result result)
    {
        Object obj = result.getBarcodeFormat();
        if(!BarcodeFormat.RSS_EXPANDED.equals(obj))
            return null;
        String s4 = result.getText();
        if(s4 == null)
            return null;
        Object obj8 = "-";
        Object obj7 = "-";
        Object obj6 = "-";
        Object obj5 = "-";
        Object obj4 = "-";
        Object obj3 = "-";
        Object obj2 = "-";
        Object obj1 = "-";
        String s1 = "-";
        String s2 = "-";
        obj = "-";
        String s = "-";
        String s3 = "-";
        Hashtable hashtable = new Hashtable();
        for(int i = 0; i < s4.length();)
        {
            String s5 = findAIvalue(i, s4);
            if("ERROR".equals(s5))
                return null;
            i += s5.length() + 2;
            result = findValue(i, s4);
            i += result.length();
            if("00".equals(s5))
                obj7 = result;
            else
            if("01".equals(s5))
                obj8 = result;
            else
            if("10".equals(s5))
                obj6 = result;
            else
            if("11".equals(s5))
                obj5 = result;
            else
            if("13".equals(s5))
                obj4 = result;
            else
            if("15".equals(s5))
                obj3 = result;
            else
            if("17".equals(s5))
                obj2 = result;
            else
            if("3100".equals(s5) || "3101".equals(s5) || "3102".equals(s5) || "3103".equals(s5) || "3104".equals(s5) || "3105".equals(s5) || "3106".equals(s5) || "3107".equals(s5) || "3108".equals(s5) || "3109".equals(s5))
            {
                s1 = "KG";
                s2 = s5.substring(3);
                obj1 = result;
            } else
            if("3200".equals(s5) || "3201".equals(s5) || "3202".equals(s5) || "3203".equals(s5) || "3204".equals(s5) || "3205".equals(s5) || "3206".equals(s5) || "3207".equals(s5) || "3208".equals(s5) || "3209".equals(s5))
            {
                s1 = "LB";
                s2 = s5.substring(3);
                obj1 = result;
            } else
            if("3920".equals(s5) || "3921".equals(s5) || "3922".equals(s5) || "3923".equals(s5))
            {
                s = s5.substring(3);
                obj = result;
            } else
            if("3930".equals(s5) || "3931".equals(s5) || "3932".equals(s5) || "3933".equals(s5))
            {
                if(result.length() < 4)
                    return null;
                obj = result.substring(3);
                s3 = result.substring(0, 3);
                s = s5.substring(3);
            } else
            {
                hashtable.put(s5, result);
            }
        }

        return new ExpandedProductParsedResult(((String) (obj8)), ((String) (obj7)), ((String) (obj6)), ((String) (obj5)), ((String) (obj4)), ((String) (obj3)), ((String) (obj2)), ((String) (obj1)), s1, s2, ((String) (obj)), s, s3, hashtable);
    }
}
