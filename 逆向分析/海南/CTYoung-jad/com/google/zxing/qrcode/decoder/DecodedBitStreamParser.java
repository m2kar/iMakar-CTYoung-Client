// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.*;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            Mode, Version, ErrorCorrectionLevel

final class DecodedBitStreamParser
{

    private DecodedBitStreamParser()
    {
    }

    static DecoderResult decode(byte abyte0[], Version version, ErrorCorrectionLevel errorcorrectionlevel, Hashtable hashtable)
        throws FormatException
    {
        BitSource bitsource = new BitSource(abyte0);
        StringBuffer stringbuffer = new StringBuffer(50);
        CharacterSetECI characterseteci = null;
        boolean flag = false;
        Vector vector = new Vector(1);
        do
        {
            boolean flag1;
            Mode mode;
            CharacterSetECI characterseteci1;
            if(bitsource.available() < 4)
                mode = Mode.TERMINATOR;
            else
                try
                {
                    mode = Mode.forBits(bitsource.readBits(4));
                }
                // Misplaced declaration of an exception variable
                catch(byte abyte0[])
                {
                    throw FormatException.getFormatInstance();
                }
            characterseteci1 = characterseteci;
            flag1 = flag;
            if(!mode.equals(Mode.TERMINATOR))
                if(mode.equals(Mode.FNC1_FIRST_POSITION) || mode.equals(Mode.FNC1_SECOND_POSITION))
                {
                    flag1 = true;
                    characterseteci1 = characterseteci;
                } else
                if(mode.equals(Mode.STRUCTURED_APPEND))
                {
                    bitsource.readBits(16);
                    characterseteci1 = characterseteci;
                    flag1 = flag;
                } else
                if(mode.equals(Mode.ECI))
                {
                    characterseteci = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitsource));
                    characterseteci1 = characterseteci;
                    flag1 = flag;
                    if(characterseteci == null)
                        throw FormatException.getFormatInstance();
                } else
                {
                    int i = bitsource.readBits(mode.getCharacterCountBits(version));
                    if(mode.equals(Mode.NUMERIC))
                    {
                        decodeNumericSegment(bitsource, stringbuffer, i);
                        characterseteci1 = characterseteci;
                        flag1 = flag;
                    } else
                    if(mode.equals(Mode.ALPHANUMERIC))
                    {
                        decodeAlphanumericSegment(bitsource, stringbuffer, i, flag);
                        characterseteci1 = characterseteci;
                        flag1 = flag;
                    } else
                    if(mode.equals(Mode.BYTE))
                    {
                        decodeByteSegment(bitsource, stringbuffer, i, characterseteci, vector, hashtable);
                        characterseteci1 = characterseteci;
                        flag1 = flag;
                    } else
                    if(mode.equals(Mode.KANJI))
                    {
                        decodeKanjiSegment(bitsource, stringbuffer, i);
                        characterseteci1 = characterseteci;
                        flag1 = flag;
                    } else
                    {
                        throw FormatException.getFormatInstance();
                    }
                }
            characterseteci = characterseteci1;
            flag = flag1;
            if(mode.equals(Mode.TERMINATOR))
            {
                hashtable = stringbuffer.toString();
                version = vector;
                if(vector.isEmpty())
                    version = null;
                return new DecoderResult(abyte0, hashtable, version, errorcorrectionlevel);
            }
        } while(true);
    }

    private static void decodeAlphanumericSegment(BitSource bitsource, StringBuffer stringbuffer, int i, boolean flag)
        throws FormatException
    {
        int j = stringbuffer.length();
        for(; i > 1; i -= 2)
        {
            int k = bitsource.readBits(11);
            stringbuffer.append(toAlphaNumericChar(k / 45));
            stringbuffer.append(toAlphaNumericChar(k % 45));
        }

        if(i == 1)
            stringbuffer.append(toAlphaNumericChar(bitsource.readBits(6)));
        if(flag)
        {
            i = j;
            while(i < stringbuffer.length()) 
            {
                if(stringbuffer.charAt(i) == '%')
                    if(i < stringbuffer.length() - 1 && stringbuffer.charAt(i + 1) == '%')
                        stringbuffer.deleteCharAt(i + 1);
                    else
                        stringbuffer.setCharAt(i, '\035');
                i++;
            }
        }
    }

    private static void decodeByteSegment(BitSource bitsource, StringBuffer stringbuffer, int i, CharacterSetECI characterseteci, Vector vector, Hashtable hashtable)
        throws FormatException
    {
        byte abyte0[] = new byte[i];
        if(i << 3 > bitsource.available())
            throw FormatException.getFormatInstance();
        for(int j = 0; j < i; j++)
            abyte0[j] = (byte)bitsource.readBits(8);

        if(characterseteci == null)
            bitsource = StringUtils.guessEncoding(abyte0, hashtable);
        else
            bitsource = characterseteci.getEncodingName();
        try
        {
            stringbuffer.append(new String(abyte0, bitsource));
        }
        // Misplaced declaration of an exception variable
        catch(BitSource bitsource)
        {
            throw FormatException.getFormatInstance();
        }
        vector.addElement(abyte0);
    }

    private static void decodeKanjiSegment(BitSource bitsource, StringBuffer stringbuffer, int i)
        throws FormatException
    {
        byte abyte0[] = new byte[i * 2];
        int j = 0;
        while(i > 0) 
        {
            int k = bitsource.readBits(13);
            k = k / 192 << 8 | k % 192;
            if(k < 7936)
                k += 33088;
            else
                k += 49472;
            abyte0[j] = (byte)(k >> 8);
            abyte0[j + 1] = (byte)k;
            j += 2;
            i--;
        }
        try
        {
            stringbuffer.append(new String(abyte0, "SJIS"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch(BitSource bitsource)
        {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitsource, StringBuffer stringbuffer, int i)
        throws FormatException
    {
        for(; i >= 3; i -= 3)
        {
            int j = bitsource.readBits(10);
            if(j >= 1000)
                throw FormatException.getFormatInstance();
            stringbuffer.append(toAlphaNumericChar(j / 100));
            stringbuffer.append(toAlphaNumericChar((j / 10) % 10));
            stringbuffer.append(toAlphaNumericChar(j % 10));
        }

        if(i == 2)
        {
            i = bitsource.readBits(7);
            if(i >= 100)
                throw FormatException.getFormatInstance();
            stringbuffer.append(toAlphaNumericChar(i / 10));
            stringbuffer.append(toAlphaNumericChar(i % 10));
        } else
        if(i == 1)
        {
            i = bitsource.readBits(4);
            if(i >= 10)
            {
                throw FormatException.getFormatInstance();
            } else
            {
                stringbuffer.append(toAlphaNumericChar(i));
                return;
            }
        }
    }

    private static int parseECIValue(BitSource bitsource)
    {
        int i = bitsource.readBits(8);
        if((i & 0x80) == 0)
            return i & 0x7f;
        if((i & 0xc0) == 128)
            return (i & 0x3f) << 8 | bitsource.readBits(8);
        if((i & 0xe0) == 192)
            return (i & 0x1f) << 16 | bitsource.readBits(16);
        else
            throw new IllegalArgumentException("Bad ECI bits starting with byte " + i);
    }

    private static char toAlphaNumericChar(int i)
        throws FormatException
    {
        if(i >= ALPHANUMERIC_CHARS.length)
            throw FormatException.getFormatInstance();
        else
            return ALPHANUMERIC_CHARS[i];
    }

    private static final char ALPHANUMERIC_CHARS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', 
        '+', '-', '.', '/', ':'
    };

}
