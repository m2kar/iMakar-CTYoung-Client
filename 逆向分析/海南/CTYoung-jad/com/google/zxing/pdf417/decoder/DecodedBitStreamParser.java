// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;

final class DecodedBitStreamParser
{

    private DecodedBitStreamParser()
    {
    }

    private static StringBuffer add(String s, String s1)
    {
        StringBuffer stringbuffer = new StringBuffer(5);
        StringBuffer stringbuffer1 = new StringBuffer(5);
        StringBuffer stringbuffer2 = new StringBuffer(s.length());
        for(int i = 0; i < s.length(); i++)
            stringbuffer2.append('0');

        int k = 0;
        for(int j = s.length() - 3; j > -1; j -= 3)
        {
            stringbuffer.setLength(0);
            stringbuffer.append(s.charAt(j));
            stringbuffer.append(s.charAt(j + 1));
            stringbuffer.append(s.charAt(j + 2));
            stringbuffer1.setLength(0);
            stringbuffer1.append(s1.charAt(j));
            stringbuffer1.append(s1.charAt(j + 1));
            stringbuffer1.append(s1.charAt(j + 2));
            int i1 = Integer.parseInt(stringbuffer.toString());
            int j1 = Integer.parseInt(stringbuffer1.toString());
            int l = (i1 + j1 + k) % 1000;
            k = (i1 + j1 + k) / 1000;
            stringbuffer2.setCharAt(j + 2, (char)(l % 10 + 48));
            stringbuffer2.setCharAt(j + 1, (char)((l / 10) % 10 + 48));
            stringbuffer2.setCharAt(j, (char)(l / 100 + 48));
        }

        return stringbuffer2;
    }

    private static int byteCompaction(int i, int ai[], int j, StringBuffer stringbuffer)
    {
        if(i == 901)
        {
            i = 0;
            long l1 = 0L;
            char ac[] = new char[6];
            int ai1[] = new int[6];
            int i1 = 0;
            int k = j;
            j = i;
            do
            {
                if(k >= ai[0] || i1 != 0)
                    break;
                i = k + 1;
                k = ai[k];
                boolean flag;
                int l;
                int j1;
                long l2;
                if(k < 900)
                {
                    ai1[j] = k;
                    j1 = j + 1;
                    l2 = 900L * l1 + (long)k;
                    l = i1;
                } else
                if(k == 900 || k == 901 || k == 902 || k == 924 || k == 928 || k == 923 || k == 922)
                {
                    i--;
                    l = 1;
                    j1 = j;
                    l2 = l1;
                } else
                {
                    j1 = j;
                    l = i1;
                    l2 = l1;
                }
                j = j1;
                i1 = l;
                l1 = l2;
                k = i;
                if(j1 % 5 == 0)
                {
                    j = j1;
                    i1 = l;
                    l1 = l2;
                    k = i;
                    if(j1 > 0)
                    {
                        j = 0;
                        l1 = l2;
                        for(; j < 6; j++)
                        {
                            ac[5 - j] = (char)(int)(l1 % 256L);
                            l1 >>= 8;
                        }

                        stringbuffer.append(ac);
                        j = 0;
                        i1 = l;
                        k = i;
                    }
                }
            } while(true);
            i = (j / 5) * 5;
            do
            {
                l = k;
                if(i >= j)
                    break;
                stringbuffer.append((char)ai1[i]);
                i++;
            } while(true);
        } else
        {
            l = j;
            if(i == 924)
            {
                i1 = 0;
                l1 = 0L;
                flag = false;
                do
                {
                    l = j;
                    if(j >= ai[0])
                        break;
                    l = j;
                    if(flag)
                        break;
                    i = j + 1;
                    j = ai[j];
                    if(j < 900)
                    {
                        l = i1 + 1;
                        l2 = 900L * l1 + (long)j;
                        j1 = ((flag) ? 1 : 0);
                    } else
                    if(j == 900 || j == 901 || j == 902 || j == 924 || j == 928 || j == 923 || j == 922)
                    {
                        i--;
                        j1 = 1;
                        l = i1;
                        l2 = l1;
                    } else
                    {
                        l = i1;
                        j1 = ((flag) ? 1 : 0);
                        l2 = l1;
                    }
                    i1 = l;
                    flag = j1;
                    l1 = l2;
                    j = i;
                    if(l % 5 == 0)
                    {
                        i1 = l;
                        flag = j1;
                        l1 = l2;
                        j = i;
                        if(l > 0)
                        {
                            ac = new char[6];
                            j = 0;
                            l1 = l2;
                            for(; j < 6; j++)
                            {
                                ac[5 - j] = (char)(int)(255L & l1);
                                l1 >>= 8;
                            }

                            stringbuffer.append(ac);
                            i1 = l;
                            flag = j1;
                            j = i;
                        }
                    }
                } while(true);
            }
        }
        return l;
    }

    static DecoderResult decode(int ai[])
        throws FormatException
    {
        int i;
        int j;
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer(100);
        i = ai[1];
        j = 1 + 1;
_L7:
        if(j >= ai[0])
            break MISSING_BLOCK_LABEL_169;
        i;
        JVM INSTR lookupswitch 5: default 76
    //                   900: 107
    //                   901: 118
    //                   902: 130
    //                   913: 141
    //                   924: 153;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        i = textCompaction(ai, j - 1, stringbuffer);
_L8:
        if(i < ai.length)
        {
            j = ai[i];
            int k = i + 1;
            i = j;
            j = k;
        } else
        {
            throw FormatException.getFormatInstance();
        }
        if(true) goto _L7; else goto _L2
_L2:
        i = textCompaction(ai, j, stringbuffer);
          goto _L8
_L3:
        i = byteCompaction(i, ai, j, stringbuffer);
          goto _L8
_L4:
        i = numericCompaction(ai, j, stringbuffer);
          goto _L8
_L5:
        i = byteCompaction(i, ai, j, stringbuffer);
          goto _L8
_L6:
        i = byteCompaction(i, ai, j, stringbuffer);
          goto _L8
        return new DecoderResult(null, stringbuffer.toString(), null, null);
    }

    private static String decodeBase900toBase10(int ai[], int i)
    {
        StringBuffer stringbuffer = null;
        int j = 0;
        while(j < i) 
        {
            StringBuffer stringbuffer1 = multiply(EXP900[i - j - 1], ai[j]);
            if(stringbuffer == null)
                stringbuffer = stringbuffer1;
            else
                stringbuffer = add(stringbuffer.toString(), stringbuffer1.toString());
            j++;
        }
        Object obj = null;
        i = 0;
        do
        {
label0:
            {
                ai = ((int []) (obj));
                if(i < stringbuffer.length())
                {
                    if(stringbuffer.charAt(i) != '1')
                        break label0;
                    ai = stringbuffer.toString().substring(i + 1);
                }
                obj = ai;
                if(ai == null)
                    obj = stringbuffer.toString();
                return ((String) (obj));
            }
            i++;
        } while(true);
    }

    private static void decodeTextCompaction(int ai[], int ai1[], int i, StringBuffer stringbuffer)
    {
        int k;
        boolean flag1;
        int i1;
        k = 0;
        flag1 = false;
        i1 = 0;
_L8:
        boolean flag;
        int j1;
        if(i1 >= i)
            break MISSING_BLOCK_LABEL_735;
        j1 = ai[i1];
        flag = false;
        k;
        JVM INSTR tableswitch 0 4: default 60
    //                   0 101
    //                   1 257
    //                   2 413
    //                   3 588
    //                   4 680;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_680;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        char c;
        int j;
        int l;
        j = k;
        l = ((flag1) ? 1 : 0);
        c = flag;
_L9:
        if(c != 0)
            stringbuffer.append(c);
        i1++;
        flag1 = l;
        k = j;
        if(true) goto _L8; else goto _L7
_L7:
        if(j1 < 26)
        {
            c = (char)(j1 + 65);
            l = ((flag1) ? 1 : 0);
            j = k;
        } else
        if(j1 == 26)
        {
            c = ' ';
            l = ((flag1) ? 1 : 0);
            j = k;
        } else
        if(j1 == 27)
        {
            j = 1;
            c = flag;
            l = ((flag1) ? 1 : 0);
        } else
        if(j1 == 28)
        {
            j = 2;
            c = flag;
            l = ((flag1) ? 1 : 0);
        } else
        if(j1 == 29)
        {
            j = 4;
            c = flag;
            l = k;
        } else
        {
            c = flag;
            l = ((flag1) ? 1 : 0);
            j = k;
            if(j1 == 913)
            {
                stringbuffer.append((char)ai1[i1]);
                c = flag;
                l = ((flag1) ? 1 : 0);
                j = k;
            }
        }
          goto _L9
_L3:
        if(j1 < 26)
        {
            c = (char)(j1 + 97);
            l = ((flag1) ? 1 : 0);
            j = k;
        } else
        if(j1 == 26)
        {
            c = ' ';
            l = ((flag1) ? 1 : 0);
            j = k;
        } else
        if(j1 == 28)
        {
            j = 0;
            c = flag;
            l = ((flag1) ? 1 : 0);
        } else
        if(j1 == 28)
        {
            j = 2;
            c = flag;
            l = ((flag1) ? 1 : 0);
        } else
        if(j1 == 29)
        {
            j = 4;
            c = flag;
            l = k;
        } else
        {
            c = flag;
            l = ((flag1) ? 1 : 0);
            j = k;
            if(j1 == 913)
            {
                stringbuffer.append((char)ai1[i1]);
                c = flag;
                l = ((flag1) ? 1 : 0);
                j = k;
            }
        }
          goto _L9
_L4:
        if(j1 < 25)
        {
            c = MIXED_CHARS[j1];
            l = ((flag1) ? 1 : 0);
            j = k;
        } else
        if(j1 == 25)
        {
            j = 3;
            c = flag;
            l = ((flag1) ? 1 : 0);
        } else
        if(j1 == 26)
        {
            c = ' ';
            l = ((flag1) ? 1 : 0);
            j = k;
        } else
        {
            c = flag;
            l = ((flag1) ? 1 : 0);
            j = k;
            if(j1 != 27)
                if(j1 == 28)
                {
                    j = 0;
                    c = flag;
                    l = ((flag1) ? 1 : 0);
                } else
                if(j1 == 29)
                {
                    j = 4;
                    c = flag;
                    l = k;
                } else
                {
                    c = flag;
                    l = ((flag1) ? 1 : 0);
                    j = k;
                    if(j1 == 913)
                    {
                        stringbuffer.append((char)ai1[i1]);
                        c = flag;
                        l = ((flag1) ? 1 : 0);
                        j = k;
                    }
                }
        }
          goto _L9
_L5:
        if(j1 < 29)
        {
            c = PUNCT_CHARS[j1];
            l = ((flag1) ? 1 : 0);
            j = k;
        } else
        if(j1 == 29)
        {
            j = 0;
            c = flag;
            l = ((flag1) ? 1 : 0);
        } else
        {
            c = flag;
            l = ((flag1) ? 1 : 0);
            j = k;
            if(j1 == 913)
            {
                stringbuffer.append((char)ai1[i1]);
                c = flag;
                l = ((flag1) ? 1 : 0);
                j = k;
            }
        }
          goto _L9
        j = ((flag1) ? 1 : 0);
        if(j1 < 29)
        {
            c = PUNCT_CHARS[j1];
            l = ((flag1) ? 1 : 0);
        } else
        {
            c = flag;
            l = ((flag1) ? 1 : 0);
            if(j1 == 29)
            {
                j = 0;
                c = flag;
                l = ((flag1) ? 1 : 0);
            }
        }
          goto _L9
    }

    private static StringBuffer multiply(String s, int i)
    {
        StringBuffer stringbuffer = new StringBuffer(s.length());
        for(int j = 0; j < s.length(); j++)
            stringbuffer.append('0');

        int l = i / 100;
        int i1 = i / 10;
        for(int k = 0; k < i % 10; k++)
            stringbuffer = add(stringbuffer.toString(), s);

        for(i = 0; i < i1 % 10; i++)
            stringbuffer = add(stringbuffer.toString(), (s + '0').substring(1));

        for(i = 0; i < l; i++)
            stringbuffer = add(stringbuffer.toString(), (s + "00").substring(2));

        return stringbuffer;
    }

    private static int numericCompaction(int ai[], int i, StringBuffer stringbuffer)
    {
        int j = 0;
        boolean flag1 = false;
        int ai1[] = new int[15];
        int l = i;
        do
        {
            if(l >= ai[0] || flag1)
                break;
            i = l + 1;
            l = ai[l];
            boolean flag = flag1;
            if(i == ai[0])
                flag = true;
            int k;
            if(l < 900)
            {
                ai1[j] = l;
                k = j + 1;
            } else
            if(l == 900 || l == 901 || l == 924 || l == 928 || l == 923 || l == 922)
            {
                i--;
                flag = true;
                k = j;
            } else
            {
                k = j;
            }
            if(k % 15 != 0 && l != 902)
            {
                j = k;
                flag1 = flag;
                l = i;
                if(!flag)
                    continue;
            }
            stringbuffer.append(decodeBase900toBase10(ai1, k));
            j = 0;
            flag1 = flag;
            l = i;
        } while(true);
        return l;
    }

    private static int textCompaction(int ai[], int i, StringBuffer stringbuffer)
    {
        int ai1[] = new int[ai[0] << 1];
        int ai2[] = new int[ai[0] << 1];
        int j = 0;
label0:
        do
        {
            for(boolean flag = false; i < ai[0] && !flag;)
            {
                int k = i + 1;
                i = ai[i];
                if(i < 900)
                {
                    ai1[j] = i / 30;
                    ai1[j + 1] = i % 30;
                    j += 2;
                    i = k;
                } else
                {
                    switch(i)
                    {
                    default:
                        i = k;
                        break;

                    case 900: 
                        i = k - 1;
                        flag = true;
                        break;

                    case 901: 
                        i = k - 1;
                        flag = true;
                        break;

                    case 902: 
                        i = k - 1;
                        flag = true;
                        break;

                    case 913: 
                        ai1[j] = 913;
                        ai2[j] = i;
                        j++;
                        i = k;
                        break;

                    case 924: 
                        i = k - 1;
                        flag = true;
                        break;
                    }
                    continue label0;
                }
            }

            decodeTextCompaction(ai1, ai2, j, stringbuffer);
            return i;
        } while(true);
    }

    private static final int AL = 28;
    private static final int ALPHA = 0;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final String EXP900[] = {
        "000000000000000000000000000000000000000000001", "000000000000000000000000000000000000000000900", "000000000000000000000000000000000000000810000", "000000000000000000000000000000000000729000000", "000000000000000000000000000000000656100000000", "000000000000000000000000000000590490000000000", "000000000000000000000000000531441000000000000", "000000000000000000000000478296900000000000000", "000000000000000000000430467210000000000000000", "000000000000000000387420489000000000000000000", 
        "000000000000000348678440100000000000000000000", "000000000000313810596090000000000000000000000", "000000000282429536481000000000000000000000000", "000000254186582832900000000000000000000000000", "000228767924549610000000000000000000000000000", "205891132094649000000000000000000000000000000"
    };
    private static final int LL = 27;
    private static final int LOWER = 1;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int MIXED = 2;
    private static final char MIXED_CHARS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '&', '\r', '\t', ',', ':', '#', '-', '.', '$', '/', 
        '+', '%', '*', '=', '^'
    };
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int PUNCT = 3;
    private static final char PUNCT_CHARS[] = {
        ';', '<', '>', '@', '[', '\\', '}', '_', '`', '~', 
        '!', '\r', '\t', ',', ':', '\n', '-', '.', '$', '/', 
        '"', '|', '*', '(', ')', '?', '{', '}', '\''
    };
    private static final int PUNCT_SHIFT = 4;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

}
