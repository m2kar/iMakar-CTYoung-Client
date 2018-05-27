// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            Version

public final class Mode
{

    private Mode(int ai[], int i, String s)
    {
        characterCountBitsForVersions = ai;
        bits = i;
        name = s;
    }

    public static Mode forBits(int i)
    {
        switch(i)
        {
        case 6: // '\006'
        default:
            throw new IllegalArgumentException();

        case 0: // '\0'
            return TERMINATOR;

        case 1: // '\001'
            return NUMERIC;

        case 2: // '\002'
            return ALPHANUMERIC;

        case 3: // '\003'
            return STRUCTURED_APPEND;

        case 4: // '\004'
            return BYTE;

        case 5: // '\005'
            return FNC1_FIRST_POSITION;

        case 7: // '\007'
            return ECI;

        case 8: // '\b'
            return KANJI;

        case 9: // '\t'
            return FNC1_SECOND_POSITION;
        }
    }

    public int getBits()
    {
        return bits;
    }

    public int getCharacterCountBits(Version version)
    {
        if(characterCountBitsForVersions == null)
            throw new IllegalArgumentException("Character count doesn't apply to this mode");
        int i = version.getVersionNumber();
        if(i <= 9)
            i = 0;
        else
        if(i <= 26)
            i = 1;
        else
            i = 2;
        return characterCountBitsForVersions[i];
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return name;
    }

    public static final Mode ALPHANUMERIC = new Mode(new int[] {
        9, 11, 13
    }, 2, "ALPHANUMERIC");
    public static final Mode BYTE = new Mode(new int[] {
        8, 16, 16
    }, 4, "BYTE");
    public static final Mode ECI = new Mode(null, 7, "ECI");
    public static final Mode FNC1_FIRST_POSITION = new Mode(null, 5, "FNC1_FIRST_POSITION");
    public static final Mode FNC1_SECOND_POSITION = new Mode(null, 9, "FNC1_SECOND_POSITION");
    public static final Mode KANJI = new Mode(new int[] {
        8, 10, 12
    }, 8, "KANJI");
    public static final Mode NUMERIC = new Mode(new int[] {
        10, 12, 14
    }, 1, "NUMERIC");
    public static final Mode STRUCTURED_APPEND = new Mode(new int[] {
        0, 0, 0
    }, 3, "STRUCTURED_APPEND");
    public static final Mode TERMINATOR = new Mode(new int[] {
        0, 0, 0
    }, 0, "TERMINATOR");
    private final int bits;
    private final int characterCountBitsForVersions[];
    private final String name;

}
