// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, AddressBookParsedResult

final class VCardResultParser extends ResultParser
{

    private VCardResultParser()
    {
    }

    private static String decodeQuotedPrintable(String s, String s1)
    {
        int i;
        int k;
        StringBuffer stringbuffer;
        ByteArrayOutputStream bytearrayoutputstream;
        k = s.length();
        stringbuffer = new StringBuffer(k);
        bytearrayoutputstream = new ByteArrayOutputStream();
        i = 0;
_L8:
        if(i >= k) goto _L2; else goto _L1
_L1:
        char c;
        int j;
        c = s.charAt(i);
        j = i;
        c;
        JVM INSTR lookupswitch 3: default 84
    //                   10: 103
    //                   13: 103
    //                   61: 112;
           goto _L3 _L4 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        maybeAppendFragment(bytearrayoutputstream, s1, stringbuffer);
        stringbuffer.append(c);
        j = i;
_L6:
        i = j + 1;
        continue; /* Loop/switch isn't completed */
_L5:
        j = i;
        if(i < k - 2)
        {
            char c1 = s.charAt(i + 1);
            j = i;
            if(c1 != '\r')
            {
                j = i;
                if(c1 != '\n')
                {
                    char c2 = s.charAt(i + 2);
                    try
                    {
                        bytearrayoutputstream.write(toHexValue(c1) * 16 + toHexValue(c2));
                    }
                    catch(IllegalArgumentException illegalargumentexception) { }
                    j = i + 2;
                }
            }
        }
        if(true) goto _L6; else goto _L2
_L2:
        maybeAppendFragment(bytearrayoutputstream, s1, stringbuffer);
        return stringbuffer.toString();
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static String formatAddress(String s)
    {
        if(s == null)
            return null;
        int j = s.length();
        StringBuffer stringbuffer = new StringBuffer(j);
        int i = 0;
        while(i < j) 
        {
            char c = s.charAt(i);
            if(c == ';')
                stringbuffer.append(' ');
            else
                stringbuffer.append(c);
            i++;
        }
        return stringbuffer.toString().trim();
    }

    private static void formatNames(String as[])
    {
        if(as != null)
        {
            for(int i = 0; i < as.length; i++)
            {
                Object obj = as[i];
                String as1[] = new String[5];
                int k = 0;
                int j = 0;
                do
                {
                    int l = ((String) (obj)).indexOf(';', k);
                    if(l <= 0)
                        break;
                    as1[j] = ((String) (obj)).substring(k, l);
                    j++;
                    k = l + 1;
                } while(true);
                as1[j] = ((String) (obj)).substring(k);
                obj = new StringBuffer(100);
                maybeAppendComponent(as1, 3, ((StringBuffer) (obj)));
                maybeAppendComponent(as1, 1, ((StringBuffer) (obj)));
                maybeAppendComponent(as1, 2, ((StringBuffer) (obj)));
                maybeAppendComponent(as1, 0, ((StringBuffer) (obj)));
                maybeAppendComponent(as1, 4, ((StringBuffer) (obj)));
                as[i] = ((StringBuffer) (obj)).toString().trim();
            }

        }
    }

    private static boolean isLikeVCardDate(String s)
    {
        while(s == null || isStringOfDigits(s, 8) || s.length() == 10 && s.charAt(4) == '-' && s.charAt(7) == '-' && isSubstringOfDigits(s, 0, 4) && isSubstringOfDigits(s, 5, 2) && isSubstringOfDigits(s, 8, 2)) 
            return true;
        return false;
    }

    static String matchSingleVCardPrefixedField(String s, String s1, boolean flag)
    {
        s = matchVCardPrefixedField(s, s1, flag);
        if(s == null)
            return null;
        else
            return s[0];
    }

    private static String[] matchVCardPrefixedField(String s, String s1, boolean flag)
    {
        Object obj1 = null;
        int i = 0;
        int j1 = s1.length();
        do
        {
label0:
            {
                if(i < j1)
                {
                    i = s1.indexOf(s, i);
                    if(i >= 0)
                        break label0;
                }
                int j;
                boolean flag1;
                int k;
                int l;
                int i1;
                Object obj;
                String s2;
                String s3;
                String s4;
                if(obj1 == null || ((Vector) (obj1)).isEmpty())
                    return null;
                else
                    return toStringArray(((Vector) (obj1)));
            }
            if(i > 0 && s1.charAt(i - 1) != '\n')
            {
                i++;
                continue;
            }
            j = i + s.length();
            if(s1.charAt(j) != ':')
            {
                i = j;
                if(s1.charAt(j) != ';')
                    continue;
            }
            l = j;
            for(k = j; s1.charAt(k) != ':'; k++);
            flag1 = false;
            i = 0;
            s2 = null;
            obj = null;
            if(k > l)
            {
                j = l + 1;
label1:
                do
                {
label2:
                    {
                        flag1 = i;
                        s2 = ((String) (obj));
                        if(j > k)
                            break label1;
                        if(s1.charAt(j) != ';')
                        {
                            i1 = l;
                            flag1 = i;
                            s2 = ((String) (obj));
                            if(s1.charAt(j) != ':')
                                break label2;
                        }
                        s3 = s1.substring(l + 1, j);
                        l = s3.indexOf('=');
                        flag1 = i;
                        s2 = ((String) (obj));
                        if(l >= 0)
                        {
                            s4 = s3.substring(0, l);
                            s3 = s3.substring(l + 1);
                            if(s4.equalsIgnoreCase("ENCODING"))
                            {
                                flag1 = i;
                                s2 = ((String) (obj));
                                if(s3.equalsIgnoreCase("QUOTED-PRINTABLE"))
                                {
                                    flag1 = true;
                                    s2 = ((String) (obj));
                                }
                            } else
                            {
                                flag1 = i;
                                s2 = ((String) (obj));
                                if(s4.equalsIgnoreCase("CHARSET"))
                                {
                                    s2 = s3;
                                    flag1 = i;
                                }
                            }
                        }
                        i1 = j;
                    }
                    j++;
                    l = i1;
                    i = ((flag1) ? 1 : 0);
                    obj = s2;
                } while(true);
            }
            j = k + 1;
            i = j;
            do
            {
                k = s1.indexOf('\n', i);
                if(k < 0)
                    break;
                if(k < s1.length() - 1 && (s1.charAt(k + 1) == ' ' || s1.charAt(k + 1) == '\t'))
                {
                    i = k + 2;
                    continue;
                }
                if(!flag1 || s1.charAt(k - 1) != '=' && s1.charAt(k - 2) != '=')
                    break;
                i = k + 1;
            } while(true);
            if(k < 0)
                i = j1;
            else
            if(k > j)
            {
                obj = obj1;
                if(obj1 == null)
                    obj = new Vector(1);
                i = k;
                if(s1.charAt(k - 1) == '\r')
                    i = k - 1;
                s3 = s1.substring(j, i);
                obj1 = s3;
                if(flag)
                    obj1 = s3.trim();
                if(flag1)
                    s2 = decodeQuotedPrintable(((String) (obj1)), s2);
                else
                    s2 = stripContinuationCRLF(((String) (obj1)));
                ((Vector) (obj)).addElement(s2);
                i++;
                obj1 = obj;
            } else
            {
                i = k + 1;
            }
        } while(true);
    }

    private static void maybeAppendComponent(String as[], int i, StringBuffer stringbuffer)
    {
        if(as[i] != null)
        {
            stringbuffer.append(' ');
            stringbuffer.append(as[i]);
        }
    }

    private static void maybeAppendFragment(ByteArrayOutputStream bytearrayoutputstream, String s, StringBuffer stringbuffer)
    {
        if(bytearrayoutputstream.size() > 0)
        {
            byte abyte0[] = bytearrayoutputstream.toByteArray();
            if(s == null)
                s = new String(abyte0);
            else
                try
                {
                    s = new String(abyte0, s);
                }
                // Misplaced declaration of an exception variable
                catch(String s)
                {
                    s = new String(abyte0);
                }
            bytearrayoutputstream.reset();
            stringbuffer.append(s);
        }
    }

    public static AddressBookParsedResult parse(Result result)
    {
        String s2 = result.getText();
        if(s2 == null || !s2.startsWith("BEGIN:VCARD"))
            return null;
        String as[] = matchVCardPrefixedField("FN", s2, true);
        result = as;
        if(as == null)
        {
            result = matchVCardPrefixedField("N", s2, true);
            formatNames(result);
        }
        String as1[] = matchVCardPrefixedField("TEL", s2, true);
        String as2[] = matchVCardPrefixedField("EMAIL", s2, true);
        String s3 = matchSingleVCardPrefixedField("NOTE", s2, false);
        String as3[] = matchVCardPrefixedField("ADR", s2, true);
        if(as3 != null)
        {
            for(int i = 0; i < as3.length; i++)
                as3[i] = formatAddress(as3[i]);

        }
        String s4 = matchSingleVCardPrefixedField("ORG", s2, true);
        String s1 = matchSingleVCardPrefixedField("BDAY", s2, true);
        String s = s1;
        if(!isLikeVCardDate(s1))
            s = null;
        return new AddressBookParsedResult(result, null, as1, as2, s3, as3, s4, s, matchSingleVCardPrefixedField("TITLE", s2, true), matchSingleVCardPrefixedField("URL", s2, true));
    }

    private static String stripContinuationCRLF(String s)
    {
        boolean flag;
        int i;
        int j;
        StringBuffer stringbuffer;
        j = s.length();
        stringbuffer = new StringBuffer(j);
        flag = false;
        i = 0;
_L5:
        if(i >= j) goto _L2; else goto _L1
_L1:
        if(!flag) goto _L4; else goto _L3
_L3:
        flag = false;
_L7:
        i++;
          goto _L5
_L4:
        char c = s.charAt(i);
        boolean flag1 = false;
        flag = flag1;
        switch(c)
        {
        case 11: // '\013'
        case 12: // '\f'
        default:
            stringbuffer.append(c);
            flag = flag1;
            break;

        case 10: // '\n'
            flag = true;
            break;

        case 13: // '\r'
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        return stringbuffer.toString();
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static int toHexValue(char c)
    {
        if(c >= '0' && c <= '9')
            return c - 48;
        if(c >= 'A' && c <= 'F')
            return (c - 65) + 10;
        if(c >= 'a' && c <= 'f')
            return (c - 97) + 10;
        else
            throw new IllegalArgumentException();
    }
}
