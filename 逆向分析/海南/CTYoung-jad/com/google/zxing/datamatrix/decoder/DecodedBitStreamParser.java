// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

final class DecodedBitStreamParser
{

    private DecodedBitStreamParser()
    {
    }

    static DecoderResult decode(byte abyte0[])
        throws FormatException
    {
        int i;
        Object obj;
        Vector vector;
        Object obj1;
        StringBuffer stringbuffer;
        obj = new BitSource(abyte0);
        obj1 = new StringBuffer(100);
        stringbuffer = new StringBuffer(0);
        vector = new Vector(1);
        i = 1;
_L2:
        if(i != 1)
            break; /* Loop/switch isn't completed */
        i = decodeAsciiSegment(((BitSource) (obj)), ((StringBuffer) (obj1)), stringbuffer);
_L9:
        if(i == 0 || ((BitSource) (obj)).available() <= 0)
        {
            if(stringbuffer.length() > 0)
                ((StringBuffer) (obj1)).append(stringbuffer.toString());
            obj1 = ((StringBuffer) (obj1)).toString();
            obj = vector;
            if(vector.isEmpty())
                obj = null;
            return new DecoderResult(abyte0, ((String) (obj1)), ((Vector) (obj)), null);
        }
        if(true) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 2 6: default 152
    //                   2 156
    //                   3 167
    //                   4 176
    //                   5 185
    //                   6 194;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_194;
_L3:
        throw FormatException.getFormatInstance();
_L4:
        decodeC40Segment(((BitSource) (obj)), ((StringBuffer) (obj1)));
_L10:
        i = 1;
          goto _L9
_L5:
        decodeTextSegment(((BitSource) (obj)), ((StringBuffer) (obj1)));
          goto _L10
_L6:
        decodeAnsiX12Segment(((BitSource) (obj)), ((StringBuffer) (obj1)));
          goto _L10
_L7:
        decodeEdifactSegment(((BitSource) (obj)), ((StringBuffer) (obj1)));
          goto _L10
        decodeBase256Segment(((BitSource) (obj)), ((StringBuffer) (obj1)), vector);
          goto _L10
    }

    private static void decodeAnsiX12Segment(BitSource bitsource, StringBuffer stringbuffer)
        throws FormatException
    {
        int ai[] = new int[3];
_L5:
        if(bitsource.available() != 8) goto _L2; else goto _L1
_L1:
        int i;
        return;
_L2:
        if((i = bitsource.readBits(8)) == 254) goto _L1; else goto _L3
_L3:
        parseTwoBytes(i, bitsource.readBits(8), ai);
        i = 0;
        while(i < 3) 
        {
            int j = ai[i];
            if(j == 0)
                stringbuffer.append('\r');
            else
            if(j == 1)
                stringbuffer.append('*');
            else
            if(j == 2)
                stringbuffer.append('>');
            else
            if(j == 3)
                stringbuffer.append(' ');
            else
            if(j < 14)
                stringbuffer.append((char)(j + 44));
            else
            if(j < 40)
                stringbuffer.append((char)(j + 51));
            else
                throw FormatException.getFormatInstance();
            i++;
        }
        if(bitsource.available() <= 0)
            return;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static int decodeAsciiSegment(BitSource bitsource, StringBuffer stringbuffer, StringBuffer stringbuffer1)
        throws FormatException
    {
        boolean flag = false;
_L2:
        int j;
        int k;
        k = bitsource.readBits(8);
        if(k == 0)
            throw FormatException.getFormatInstance();
        if(k <= 128)
        {
            int i = k;
            if(flag)
                i = k + 128;
            stringbuffer.append((char)(i - 1));
            return 1;
        }
        if(k == 129)
            return 0;
        if(k > 229)
            break; /* Loop/switch isn't completed */
        j = k - 130;
        if(j < 10)
            stringbuffer.append('0');
        stringbuffer.append(j);
        j = ((flag) ? 1 : 0);
_L3:
        flag = j;
        if(bitsource.available() <= 0)
            return 1;
        if(true) goto _L2; else goto _L1
_L1:
        if(k == 230)
            return 2;
        if(k == 231)
            return 6;
        j = ((flag) ? 1 : 0);
        if(k != 232)
        {
            j = ((flag) ? 1 : 0);
            if(k != 233)
            {
                j = ((flag) ? 1 : 0);
                if(k != 234)
                    if(k == 235)
                        j = 1;
                    else
                    if(k == 236)
                    {
                        stringbuffer.append("[)>\03605\035");
                        stringbuffer1.insert(0, "\036\004");
                        j = ((flag) ? 1 : 0);
                    } else
                    if(k == 237)
                    {
                        stringbuffer.append("[)>\03606\035");
                        stringbuffer1.insert(0, "\036\004");
                        j = ((flag) ? 1 : 0);
                    } else
                    {
                        if(k == 238)
                            return 4;
                        if(k == 239)
                            return 3;
                        if(k == 240)
                            return 5;
                        j = ((flag) ? 1 : 0);
                        if(k != 241)
                        {
                            j = ((flag) ? 1 : 0);
                            if(k >= 242)
                                throw FormatException.getFormatInstance();
                        }
                    }
            }
        }
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    private static void decodeBase256Segment(BitSource bitsource, StringBuffer stringbuffer, Vector vector)
        throws FormatException
    {
        int i = bitsource.readBits(8);
        if(i != 0) goto _L2; else goto _L1
_L1:
        i = bitsource.available() / 8;
_L6:
        int j;
        byte abyte0[];
        abyte0 = new byte[i];
        j = 0;
_L4:
        if(j >= i)
            break; /* Loop/switch isn't completed */
        if(bitsource.available() < 8)
            throw FormatException.getFormatInstance();
        abyte0[j] = unrandomize255State(bitsource.readBits(8), j);
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        if(i >= 250)
            i = (i - 249) * 250 + bitsource.readBits(8);
        continue; /* Loop/switch isn't completed */
        if(true) goto _L4; else goto _L3
_L3:
        vector.addElement(abyte0);
        try
        {
            stringbuffer.append(new String(abyte0, "ISO8859_1"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch(BitSource bitsource)
        {
            throw new RuntimeException("Platform does not support required encoding: " + bitsource);
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static void decodeC40Segment(BitSource bitsource, StringBuffer stringbuffer)
        throws FormatException
    {
        boolean flag;
        int ai[];
        flag = false;
        ai = new int[3];
_L13:
        if(bitsource.available() != 8) goto _L2; else goto _L1
_L1:
        int i;
        return;
_L2:
        if((i = bitsource.readBits(8)) == 254) goto _L1; else goto _L3
_L3:
        int j;
        parseTwoBytes(i, bitsource.readBits(8), ai);
        i = 0;
        j = 0;
_L10:
        int k;
        if(j >= 3)
            continue; /* Loop/switch isn't completed */
        k = ai[j];
        i;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 96
    //                   1 155
    //                   2 188
    //                   3 263;
           goto _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_263;
_L6:
        break; /* Loop/switch isn't completed */
_L4:
        throw FormatException.getFormatInstance();
_L5:
        if(k < 3)
            i = k + 1;
        else
        if(flag)
        {
            stringbuffer.append((char)(C40_BASIC_SET_CHARS[k] + 128));
            flag = false;
        } else
        {
            stringbuffer.append(C40_BASIC_SET_CHARS[k]);
        }
_L11:
        j++;
        if(true) goto _L10; else goto _L9
_L9:
        if(flag)
        {
            stringbuffer.append((char)(k + 128));
            flag = false;
        } else
        {
            stringbuffer.append(k);
        }
        i = 0;
          goto _L11
_L7:
        if(k < 27)
        {
            if(flag)
            {
                stringbuffer.append((char)(C40_SHIFT2_SET_CHARS[k] + 128));
                flag = false;
            } else
            {
                stringbuffer.append(C40_SHIFT2_SET_CHARS[k]);
            }
        } else
        {
            if(k == 27)
                throw FormatException.getFormatInstance();
            if(k == 30)
                flag = true;
            else
                throw FormatException.getFormatInstance();
        }
        i = 0;
          goto _L11
        if(flag)
        {
            stringbuffer.append((char)(k + 224));
            flag = false;
        } else
        {
            stringbuffer.append((char)(k + 96));
        }
        i = 0;
          goto _L11
        if(bitsource.available() > 0) goto _L13; else goto _L12
_L12:
    }

    private static void decodeEdifactSegment(BitSource bitsource, StringBuffer stringbuffer)
    {
        boolean flag = false;
        do
        {
            if(bitsource.available() <= 16)
                return;
            for(int i = 0; i < 4; i++)
            {
                int k = bitsource.readBits(6);
                if(k == 11111)
                    flag = true;
                if(flag)
                    continue;
                int j = k;
                if((k & 0x20) == 0)
                    j = k | 0x40;
                stringbuffer.append(j);
            }

        } while(!flag && bitsource.available() > 0);
    }

    private static void decodeTextSegment(BitSource bitsource, StringBuffer stringbuffer)
        throws FormatException
    {
        boolean flag;
        int ai[];
        flag = false;
        ai = new int[3];
_L13:
        if(bitsource.available() != 8) goto _L2; else goto _L1
_L1:
        int i;
        return;
_L2:
        if((i = bitsource.readBits(8)) == 254) goto _L1; else goto _L3
_L3:
        int j;
        parseTwoBytes(i, bitsource.readBits(8), ai);
        i = 0;
        j = 0;
_L10:
        int k;
        if(j >= 3)
            continue; /* Loop/switch isn't completed */
        k = ai[j];
        i;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 96
    //                   1 155
    //                   2 188
    //                   3 263;
           goto _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_263;
_L6:
        break; /* Loop/switch isn't completed */
_L4:
        throw FormatException.getFormatInstance();
_L5:
        if(k < 3)
            i = k + 1;
        else
        if(flag)
        {
            stringbuffer.append((char)(TEXT_BASIC_SET_CHARS[k] + 128));
            flag = false;
        } else
        {
            stringbuffer.append(TEXT_BASIC_SET_CHARS[k]);
        }
_L11:
        j++;
        if(true) goto _L10; else goto _L9
_L9:
        if(flag)
        {
            stringbuffer.append((char)(k + 128));
            flag = false;
        } else
        {
            stringbuffer.append(k);
        }
        i = 0;
          goto _L11
_L7:
        if(k < 27)
        {
            if(flag)
            {
                stringbuffer.append((char)(C40_SHIFT2_SET_CHARS[k] + 128));
                flag = false;
            } else
            {
                stringbuffer.append(C40_SHIFT2_SET_CHARS[k]);
            }
        } else
        {
            if(k == 27)
                throw FormatException.getFormatInstance();
            if(k == 30)
                flag = true;
            else
                throw FormatException.getFormatInstance();
        }
        i = 0;
          goto _L11
        if(flag)
        {
            stringbuffer.append((char)(TEXT_SHIFT3_SET_CHARS[k] + 128));
            flag = false;
        } else
        {
            stringbuffer.append(TEXT_SHIFT3_SET_CHARS[k]);
        }
        i = 0;
          goto _L11
        if(bitsource.available() > 0) goto _L13; else goto _L12
_L12:
    }

    private static void parseTwoBytes(int i, int j, int ai[])
    {
        i = ((i << 8) + j) - 1;
        j = i / 1600;
        ai[0] = j;
        i -= j * 1600;
        j = i / 40;
        ai[1] = j;
        ai[2] = i - j * 40;
    }

    private static byte unrandomize255State(int i, int j)
    {
        i -= (j * 149) % 255 + 1;
        if(i < 0)
            i += 256;
        return (byte)i;
    }

    private static final int ANSIX12_ENCODE = 4;
    private static final int ASCII_ENCODE = 1;
    private static final int BASE256_ENCODE = 6;
    private static final char C40_BASIC_SET_CHARS[] = {
        '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
        '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
        'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private static final int C40_ENCODE = 2;
    private static final char C40_SHIFT2_SET_CHARS[] = {
        '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', 
        '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', 
        '?', '@', '[', '\\', ']', '^', '_'
    };
    private static final int EDIFACT_ENCODE = 5;
    private static final int PAD_ENCODE = 0;
    private static final char TEXT_BASIC_SET_CHARS[] = {
        '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private static final int TEXT_ENCODE = 3;
    private static final char TEXT_SHIFT3_SET_CHARS[] = {
        '\'', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', 
        '~', '\177'
    };

}
