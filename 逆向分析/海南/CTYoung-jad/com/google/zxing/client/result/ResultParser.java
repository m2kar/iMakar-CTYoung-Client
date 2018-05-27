// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.client.result:
//            BookmarkDoCoMoResultParser, AddressBookDoCoMoResultParser, EmailDoCoMoResultParser, AddressBookAUResultParser, 
//            VCardResultParser, BizcardResultParser, VEventResultParser, EmailAddressResultParser, 
//            TelResultParser, SMSMMSResultParser, SMSTOMMSTOResultParser, GeoResultParser, 
//            WifiResultParser, URLTOResultParser, URIResultParser, ISBNResultParser, 
//            ProductResultParser, ExpandedProductResultParser, TextParsedResult, ParsedResult

public abstract class ResultParser
{

    public ResultParser()
    {
    }

    private static void appendKeyValue(String s, int i, int j, Hashtable hashtable)
    {
        int k = s.indexOf('=', i);
        if(k >= 0)
            hashtable.put(s.substring(i, k), urlDecode(s.substring(k + 1, j)));
    }

    private static int findFirstEscape(char ac[])
    {
        int j = ac.length;
        for(int i = 0; i < j; i++)
        {
            char c = ac[i];
            if(c == '+' || c == '%')
                return i;
        }

        return -1;
    }

    protected static boolean isStringOfDigits(String s, int i)
    {
_L2:
        return false;
        if(s == null || i != s.length()) goto _L2; else goto _L1
_L1:
        int j = 0;
label0:
        do
        {
label1:
            {
                if(j >= i)
                    break label1;
                char c = s.charAt(j);
                if(c < '0' || c > '9')
                    break label0;
                j++;
            }
        } while(true);
        if(true) goto _L2; else goto _L3
_L3:
        return true;
    }

    protected static boolean isSubstringOfDigits(String s, int i, int j)
    {
        if(s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int k = s.length();
        j = i + j;
        if(k >= j)
label0:
            do
            {
label1:
                {
                    if(i >= j)
                        break label1;
                    char c = s.charAt(i);
                    if(c < '0' || c > '9')
                        break label0;
                    i++;
                }
            } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    static String[] matchPrefixedField(String s, String s1, char c, boolean flag)
    {
        int i;
        int l;
        Vector vector;
        vector = null;
        i = 0;
        l = s1.length();
_L2:
label0:
        {
            if(i < l)
            {
                i = s1.indexOf(s, i);
                if(i >= 0)
                    break label0;
            }
            boolean flag1;
            int j;
            int k;
            Object obj;
            String s2;
            if(vector == null || vector.isEmpty())
                return null;
            else
                return toStringArray(vector);
        }
        k = i + s.length();
        flag1 = false;
        obj = vector;
        i = k;
        do
        {
            j = i;
            i = j;
            vector = ((Vector) (obj));
            if(flag1)
                continue;
            i = s1.indexOf(c, j);
            if(i < 0)
            {
                i = s1.length();
                flag1 = true;
            } else
            if(s1.charAt(i - 1) == '\\')
            {
                i++;
            } else
            {
                vector = ((Vector) (obj));
                if(obj == null)
                    vector = new Vector(3);
                s2 = unescapeBackslash(s1.substring(k, i));
                obj = s2;
                if(flag)
                    obj = s2.trim();
                vector.addElement(obj);
                i++;
                flag1 = true;
                obj = vector;
            }
        } while(true);
        if(true) goto _L2; else goto _L1
_L1:
    }

    static String matchSinglePrefixedField(String s, String s1, char c, boolean flag)
    {
        s = matchPrefixedField(s, s1, c, flag);
        if(s == null)
            return null;
        else
            return s[0];
    }

    protected static void maybeAppend(String s, StringBuffer stringbuffer)
    {
        if(s != null)
        {
            stringbuffer.append('\n');
            stringbuffer.append(s);
        }
    }

    protected static void maybeAppend(String as[], StringBuffer stringbuffer)
    {
        if(as != null)
        {
            for(int i = 0; i < as.length; i++)
            {
                stringbuffer.append('\n');
                stringbuffer.append(as[i]);
            }

        }
    }

    protected static String[] maybeWrap(String s)
    {
        if(s == null)
            return null;
        else
            return (new String[] {
                s
            });
    }

    private static int parseHexDigit(char c)
    {
        if(c >= 'a')
        {
            if(c <= 'f')
                return (c - 97) + 10;
        } else
        if(c >= 'A')
        {
            if(c <= 'F')
                return (c - 65) + 10;
        } else
        if(c >= '0' && c <= '9')
            return c - 48;
        return -1;
    }

    static Hashtable parseNameValuePairs(String s)
    {
        int i = s.indexOf('?');
        if(i < 0)
            return null;
        Hashtable hashtable = new Hashtable(3);
        i++;
        do
        {
            int j = s.indexOf('&', i);
            if(j >= 0)
            {
                appendKeyValue(s, i, j, hashtable);
                i = j + 1;
            } else
            {
                appendKeyValue(s, i, s.length(), hashtable);
                return hashtable;
            }
        } while(true);
    }

    public static ParsedResult parseResult(Result result)
    {
        Object obj = BookmarkDoCoMoResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = AddressBookDoCoMoResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = EmailDoCoMoResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = AddressBookAUResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = VCardResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = BizcardResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = VEventResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = EmailAddressResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = TelResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = SMSMMSResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = SMSTOMMSTOResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = GeoResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = WifiResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = URLTOResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = URIResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = ISBNResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = ProductResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        obj = ExpandedProductResultParser.parse(result);
        if(obj != null)
            return ((ParsedResult) (obj));
        else
            return new TextParsedResult(result.getText(), null);
    }

    static String[] toStringArray(Vector vector)
    {
        int j = vector.size();
        String as[] = new String[j];
        for(int i = 0; i < j; i++)
            as[i] = (String)vector.elementAt(i);

        return as;
    }

    protected static String unescapeBackslash(String s)
    {
        Object obj = s;
        if(s != null)
        {
            int i = s.indexOf('\\');
            obj = s;
            if(i >= 0)
            {
                int j = s.length();
                obj = new StringBuffer(j - 1);
                ((StringBuffer) (obj)).append(s.toCharArray(), 0, i);
                boolean flag = false;
                while(i < j) 
                {
                    char c = s.charAt(i);
                    if(flag || c != '\\')
                    {
                        ((StringBuffer) (obj)).append(c);
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    i++;
                }
                obj = ((StringBuffer) (obj)).toString();
            }
        }
        return ((String) (obj));
    }

    private static String urlDecode(String s)
    {
        if(s == null)
        {
            s = null;
        } else
        {
            char ac[] = s.toCharArray();
            int i = findFirstEscape(ac);
            if(i >= 0)
            {
                int j = ac.length;
                s = new StringBuffer(j - 2);
                s.append(ac, 0, i);
                while(i < j) 
                {
                    char c = ac[i];
                    if(c == '+')
                        s.append(' ');
                    else
                    if(c == '%')
                    {
                        if(i >= j - 2)
                        {
                            s.append('%');
                        } else
                        {
                            i++;
                            int k = parseHexDigit(ac[i]);
                            i++;
                            int l = parseHexDigit(ac[i]);
                            if(k < 0 || l < 0)
                            {
                                s.append('%');
                                s.append(ac[i - 1]);
                                s.append(ac[i]);
                            }
                            s.append((char)((k << 4) + l));
                        }
                    } else
                    {
                        s.append(c);
                    }
                    i++;
                }
                return s.toString();
            }
        }
        return s;
    }
}
