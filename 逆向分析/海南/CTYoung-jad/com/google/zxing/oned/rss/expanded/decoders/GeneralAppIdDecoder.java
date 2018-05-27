// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            CurrentParsingState, DecodedChar, DecodedNumeric, BlockParsedResult, 
//            DecodedInformation, FieldParser

final class GeneralAppIdDecoder
{

    GeneralAppIdDecoder(BitArray bitarray)
    {
        information = bitarray;
    }

    private DecodedChar decodeAlphanumeric(int i)
    {
        int j = extractNumericValueFromBitArray(i, 5);
        if(j == 15)
            return new DecodedChar(i + 5, '$');
        if(j >= 5 && j < 15)
            return new DecodedChar(i + 5, (char)((j + 48) - 5));
        j = extractNumericValueFromBitArray(i, 6);
        if(j >= 32 && j < 58)
            return new DecodedChar(i + 6, (char)(j + 33));
        switch(j)
        {
        default:
            throw new RuntimeException("Decoding invalid alphanumeric value: " + j);

        case 58: // ':'
            return new DecodedChar(i + 6, '*');

        case 59: // ';'
            return new DecodedChar(i + 6, ',');

        case 60: // '<'
            return new DecodedChar(i + 6, '-');

        case 61: // '='
            return new DecodedChar(i + 6, '.');

        case 62: // '>'
            return new DecodedChar(i + 6, '/');
        }
    }

    private DecodedChar decodeIsoIec646(int i)
    {
        int j = extractNumericValueFromBitArray(i, 5);
        if(j == 15)
            return new DecodedChar(i + 5, '$');
        if(j >= 5 && j < 15)
            return new DecodedChar(i + 5, (char)((j + 48) - 5));
        j = extractNumericValueFromBitArray(i, 7);
        if(j >= 64 && j < 90)
            return new DecodedChar(i + 7, (char)(j + 1));
        if(j >= 90 && j < 116)
            return new DecodedChar(i + 7, (char)(j + 7));
        j = extractNumericValueFromBitArray(i, 8);
        switch(j)
        {
        default:
            throw new RuntimeException("Decoding invalid ISO/IEC 646 value: " + j);

        case 232: 
            return new DecodedChar(i + 8, '!');

        case 233: 
            return new DecodedChar(i + 8, '"');

        case 234: 
            return new DecodedChar(i + 8, '%');

        case 235: 
            return new DecodedChar(i + 8, '&');

        case 236: 
            return new DecodedChar(i + 8, '\'');

        case 237: 
            return new DecodedChar(i + 8, '(');

        case 238: 
            return new DecodedChar(i + 8, ')');

        case 239: 
            return new DecodedChar(i + 8, '*');

        case 240: 
            return new DecodedChar(i + 8, '+');

        case 241: 
            return new DecodedChar(i + 8, ',');

        case 242: 
            return new DecodedChar(i + 8, '-');

        case 243: 
            return new DecodedChar(i + 8, '.');

        case 244: 
            return new DecodedChar(i + 8, '/');

        case 245: 
            return new DecodedChar(i + 8, ':');

        case 246: 
            return new DecodedChar(i + 8, ';');

        case 247: 
            return new DecodedChar(i + 8, '<');

        case 248: 
            return new DecodedChar(i + 8, '=');

        case 249: 
            return new DecodedChar(i + 8, '>');

        case 250: 
            return new DecodedChar(i + 8, '?');

        case 251: 
            return new DecodedChar(i + 8, '_');

        case 252: 
            return new DecodedChar(i + 8, ' ');
        }
    }

    private DecodedNumeric decodeNumeric(int i)
    {
        if(i + 7 > information.size)
        {
            i = extractNumericValueFromBitArray(i, 4);
            if(i == 0)
                return new DecodedNumeric(information.size, 10, 10);
            else
                return new DecodedNumeric(information.size, i - 1, 10);
        } else
        {
            int j = extractNumericValueFromBitArray(i, 7);
            return new DecodedNumeric(i + 7, (j - 8) / 11, (j - 8) % 11);
        }
    }

    static int extractNumericValueFromBitArray(BitArray bitarray, int i, int j)
    {
        if(j > 32)
            throw new IllegalArgumentException("extractNumberValueFromBitArray can't handle more than 32 bits");
        int l = 0;
        for(int k = 0; k < j;)
        {
            int i1 = l;
            if(bitarray.get(i + k))
                i1 = l | 1 << j - k - 1;
            k++;
            l = i1;
        }

        return l;
    }

    private boolean isAlphaOr646ToNumericLatch(int i)
    {
        if(i + 3 <= information.size) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = i;
label0:
        do
        {
label1:
            {
                if(j >= i + 3)
                    break label1;
                if(information.get(j))
                    break label0;
                j++;
            }
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i)
    {
        if(i + 1 <= information.size) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = 0;
_L6:
        if(j >= 5 || j + i >= information.size)
            break MISSING_BLOCK_LABEL_75;
        if(j != 2) goto _L4; else goto _L3
_L3:
        if(!information.get(i + 2)) goto _L1; else goto _L5
_L5:
        j++;
          goto _L6
_L4:
        if(!information.get(i + j)) goto _L5; else goto _L7
_L7:
        return false;
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i)
    {
        if(i + 1 <= information.size) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if(j >= 4 || j + i >= information.size)
                    break label1;
                if(information.get(i + j))
                    break label0;
                j++;
            }
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private boolean isStillAlpha(int i)
    {
        boolean flag = true;
        if(i + 5 <= information.size)
        {
            int j = extractNumericValueFromBitArray(i, 5);
            if(j >= 5 && j < 16)
                return true;
            if(i + 6 <= information.size)
            {
                i = extractNumericValueFromBitArray(i, 6);
                if(i < 16 || i >= 63)
                    flag = false;
                return flag;
            }
        }
        return false;
    }

    private boolean isStillIsoIec646(int i)
    {
        boolean flag = true;
        if(i + 5 <= information.size)
        {
            int j = extractNumericValueFromBitArray(i, 5);
            if(j >= 5 && j < 16)
                return true;
            if(i + 7 <= information.size)
            {
                int k = extractNumericValueFromBitArray(i, 7);
                if(k >= 64 && k < 116)
                    return true;
                if(i + 8 <= information.size)
                {
                    i = extractNumericValueFromBitArray(i, 8);
                    if(i < 232 || i >= 253)
                        flag = false;
                    return flag;
                }
            }
        }
        return false;
    }

    private boolean isStillNumeric(int i)
    {
        if(i + 7 <= information.size) goto _L2; else goto _L1
_L1:
        if(i + 4 > information.size) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        int j = i;
label0:
        do
        {
label1:
            {
                if(j >= i + 3)
                    break label1;
                if(information.get(j))
                    break label0;
                j++;
            }
        } while(true);
        if(true) goto _L3; else goto _L5
_L5:
        return information.get(i + 3);
    }

    private BlockParsedResult parseAlphaBlock()
    {
        DecodedChar decodedchar;
        for(; isStillAlpha(current.position); buffer.append(decodedchar.getValue()))
        {
            decodedchar = decodeAlphanumeric(current.position);
            current.position = decodedchar.getNewPosition();
            if(decodedchar.isFNC1())
                return new BlockParsedResult(new DecodedInformation(current.position, buffer.toString()), true);
        }

        if(!isAlphaOr646ToNumericLatch(current.position)) goto _L2; else goto _L1
_L1:
        CurrentParsingState currentparsingstate = current;
        currentparsingstate.position = currentparsingstate.position + 3;
        current.setNumeric();
_L4:
        return new BlockParsedResult(false);
_L2:
        if(isAlphaTo646ToAlphaLatch(current.position))
        {
            if(current.position + 5 < information.size)
            {
                CurrentParsingState currentparsingstate1 = current;
                currentparsingstate1.position = currentparsingstate1.position + 5;
            } else
            {
                current.position = information.size;
            }
            current.setIsoIec646();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private DecodedInformation parseBlocks()
    {
        do
        {
            int i = current.position;
            boolean flag;
            boolean flag1;
            BlockParsedResult blockparsedresult;
            if(current.isAlpha())
            {
                blockparsedresult = parseAlphaBlock();
                flag1 = blockparsedresult.isFinished();
            } else
            if(current.isIsoIec646())
            {
                blockparsedresult = parseIsoIec646Block();
                flag1 = blockparsedresult.isFinished();
            } else
            {
                blockparsedresult = parseNumericBlock();
                flag1 = blockparsedresult.isFinished();
            }
            if(i != current.position)
                flag = true;
            else
                flag = false;
            while(!flag && !flag1 || flag1) 
                return blockparsedresult.getDecodedInformation();
        } while(true);
    }

    private BlockParsedResult parseIsoIec646Block()
    {
        DecodedChar decodedchar;
        for(; isStillIsoIec646(current.position); buffer.append(decodedchar.getValue()))
        {
            decodedchar = decodeIsoIec646(current.position);
            current.position = decodedchar.getNewPosition();
            if(decodedchar.isFNC1())
                return new BlockParsedResult(new DecodedInformation(current.position, buffer.toString()), true);
        }

        if(!isAlphaOr646ToNumericLatch(current.position)) goto _L2; else goto _L1
_L1:
        CurrentParsingState currentparsingstate = current;
        currentparsingstate.position = currentparsingstate.position + 3;
        current.setNumeric();
_L4:
        return new BlockParsedResult(false);
_L2:
        if(isAlphaTo646ToAlphaLatch(current.position))
        {
            if(current.position + 5 < information.size)
            {
                CurrentParsingState currentparsingstate1 = current;
                currentparsingstate1.position = currentparsingstate1.position + 5;
            } else
            {
                current.position = information.size;
            }
            current.setAlpha();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private BlockParsedResult parseNumericBlock()
    {
        Object obj;
        for(; isStillNumeric(current.position); buffer.append(((DecodedNumeric) (obj)).getSecondDigit()))
        {
            obj = decodeNumeric(current.position);
            current.position = ((DecodedNumeric) (obj)).getNewPosition();
            if(((DecodedNumeric) (obj)).isFirstDigitFNC1())
            {
                if(((DecodedNumeric) (obj)).isSecondDigitFNC1())
                    obj = new DecodedInformation(current.position, buffer.toString());
                else
                    obj = new DecodedInformation(current.position, buffer.toString(), ((DecodedNumeric) (obj)).getSecondDigit());
                return new BlockParsedResult(((DecodedInformation) (obj)), true);
            }
            buffer.append(((DecodedNumeric) (obj)).getFirstDigit());
            if(((DecodedNumeric) (obj)).isSecondDigitFNC1())
                return new BlockParsedResult(new DecodedInformation(current.position, buffer.toString()), true);
        }

        if(isNumericToAlphaNumericLatch(current.position))
        {
            current.setAlpha();
            CurrentParsingState currentparsingstate = current;
            currentparsingstate.position = currentparsingstate.position + 4;
        }
        return new BlockParsedResult(false);
    }

    String decodeAllCodes(StringBuffer stringbuffer, int i)
        throws NotFoundException
    {
        String s = null;
        do
        {
            DecodedInformation decodedinformation = decodeGeneralPurposeField(i, s);
            stringbuffer.append(FieldParser.parseFieldsInGeneralPurpose(decodedinformation.getNewString()));
            if(decodedinformation.isRemaining())
                s = String.valueOf(decodedinformation.getRemainingValue());
            else
                s = null;
            if(i == decodedinformation.getNewPosition())
                return stringbuffer.toString();
            i = decodedinformation.getNewPosition();
        } while(true);
    }

    DecodedInformation decodeGeneralPurposeField(int i, String s)
    {
        buffer.setLength(0);
        if(s != null)
            buffer.append(s);
        current.position = i;
        s = parseBlocks();
        if(s != null && s.isRemaining())
            return new DecodedInformation(current.position, buffer.toString(), s.getRemainingValue());
        else
            return new DecodedInformation(current.position, buffer.toString());
    }

    int extractNumericValueFromBitArray(int i, int j)
    {
        return extractNumericValueFromBitArray(information, i, j);
    }

    private final StringBuffer buffer = new StringBuffer();
    private final CurrentParsingState current = new CurrentParsingState();
    private final BitArray information;
}
