// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss.expanded.decoders;


final class CurrentParsingState
{

    CurrentParsingState()
    {
        position = 0;
        encoding = 1;
    }

    boolean isAlpha()
    {
        return encoding == 2;
    }

    boolean isIsoIec646()
    {
        return encoding == 4;
    }

    boolean isNumeric()
    {
        return encoding == 1;
    }

    void setAlpha()
    {
        encoding = 2;
    }

    void setIsoIec646()
    {
        encoding = 4;
    }

    void setNumeric()
    {
        encoding = 1;
    }

    private static final int ALPHA = 2;
    private static final int ISO_IEC_646 = 4;
    private static final int NUMERIC = 1;
    private int encoding;
    int position;
}
