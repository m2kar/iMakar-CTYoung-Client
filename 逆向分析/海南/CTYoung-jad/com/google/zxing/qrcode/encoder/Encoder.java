// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.*;
import com.google.zxing.common.reedsolomon.GF256;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.*;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.qrcode.encoder:
//            MaskUtil, MatrixUtil, QRCode, ByteMatrix, 
//            BlockPair

public final class Encoder
{

    private Encoder()
    {
    }

    static void append8BitBytes(String s, BitArray bitarray, String s1)
        throws WriterException
    {
        int i;
        try
        {
            s = s.getBytes(s1);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new WriterException(s.toString());
        }
        for(i = 0; i < s.length; i++)
            bitarray.appendBits(s[i], 8);

    }

    static void appendAlphanumericBytes(String s, BitArray bitarray)
        throws WriterException
    {
        int j = s.length();
        for(int i = 0; i < j;)
        {
            int k = getAlphanumericCode(s.charAt(i));
            if(k == -1)
                throw new WriterException();
            if(i + 1 < j)
            {
                int l = getAlphanumericCode(s.charAt(i + 1));
                if(l == -1)
                    throw new WriterException();
                bitarray.appendBits(k * 45 + l, 11);
                i += 2;
            } else
            {
                bitarray.appendBits(k, 6);
                i++;
            }
        }

    }

    static void appendBytes(String s, Mode mode, BitArray bitarray, String s1)
        throws WriterException
    {
        if(mode.equals(Mode.NUMERIC))
        {
            appendNumericBytes(s, bitarray);
            return;
        }
        if(mode.equals(Mode.ALPHANUMERIC))
        {
            appendAlphanumericBytes(s, bitarray);
            return;
        }
        if(mode.equals(Mode.BYTE))
        {
            append8BitBytes(s, bitarray, s1);
            return;
        }
        if(mode.equals(Mode.KANJI))
        {
            appendKanjiBytes(s, bitarray);
            return;
        } else
        {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(ECI eci, BitArray bitarray)
    {
        bitarray.appendBits(Mode.ECI.getBits(), 4);
        bitarray.appendBits(eci.getValue(), 8);
    }

    static void appendKanjiBytes(String s, BitArray bitarray)
        throws WriterException
    {
        int i;
        int j;
        byte byte0;
        int l;
        int k;
        try
        {
            s = s.getBytes("Shift_JIS");
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new WriterException(s.toString());
        }
        k = s.length;
        j = 0;
_L7:
        if(j >= k) goto _L2; else goto _L1
_L1:
        l = (s[j] & 0xff) << 8 | s[j + 1] & 0xff;
        byte0 = -1;
        if(l < 33088 || l > 40956) goto _L4; else goto _L3
_L3:
        i = l - 33088;
_L6:
        if(i == -1)
            throw new WriterException("Invalid byte sequence");
        break; /* Loop/switch isn't completed */
_L4:
        i = byte0;
        if(l >= 57408)
        {
            i = byte0;
            if(l <= 60351)
                i = l - 49472;
        }
        if(true) goto _L6; else goto _L5
_L5:
        bitarray.appendBits((i >> 8) * 192 + (i & 0xff), 13);
        j += 2;
          goto _L7
_L2:
    }

    static void appendLengthInfo(int i, int j, Mode mode, BitArray bitarray)
        throws WriterException
    {
        j = mode.getCharacterCountBits(Version.getVersionForNumber(j));
        if(i > (1 << j) - 1)
        {
            throw new WriterException(i + "is bigger than" + ((1 << j) - 1));
        } else
        {
            bitarray.appendBits(i, j);
            return;
        }
    }

    static void appendModeInfo(Mode mode, BitArray bitarray)
    {
        bitarray.appendBits(mode.getBits(), 4);
    }

    static void appendNumericBytes(String s, BitArray bitarray)
    {
        int j = s.length();
        for(int i = 0; i < j;)
        {
            int k = s.charAt(i) - 48;
            if(i + 2 < j)
            {
                bitarray.appendBits(k * 100 + (s.charAt(i + 1) - 48) * 10 + (s.charAt(i + 2) - 48), 10);
                i += 3;
            } else
            if(i + 1 < j)
            {
                bitarray.appendBits(k * 10 + (s.charAt(i + 1) - 48), 7);
                i += 2;
            } else
            {
                bitarray.appendBits(k, 4);
                i++;
            }
        }

    }

    private static int calculateMaskPenalty(ByteMatrix bytematrix)
    {
        return 0 + MaskUtil.applyMaskPenaltyRule1(bytematrix) + MaskUtil.applyMaskPenaltyRule2(bytematrix) + MaskUtil.applyMaskPenaltyRule3(bytematrix) + MaskUtil.applyMaskPenaltyRule4(bytematrix);
    }

    private static int chooseMaskPattern(BitArray bitarray, ErrorCorrectionLevel errorcorrectionlevel, int i, ByteMatrix bytematrix)
        throws WriterException
    {
        int k = 0x7fffffff;
        int i1 = -1;
        for(int j = 0; j < 8;)
        {
            MatrixUtil.buildMatrix(bitarray, errorcorrectionlevel, i, j, bytematrix);
            int j1 = calculateMaskPenalty(bytematrix);
            int l = k;
            if(j1 < k)
            {
                l = j1;
                i1 = j;
            }
            j++;
            k = l;
        }

        return i1;
    }

    public static Mode chooseMode(String s)
    {
        return chooseMode(s, null);
    }

    public static Mode chooseMode(String s, String s1)
    {
        if("Shift_JIS".equals(s1))
            if(isOnlyDoubleByteKanji(s))
                return Mode.KANJI;
            else
                return Mode.BYTE;
        boolean flag = false;
        boolean flag1 = false;
        int i = 0;
        while(i < s.length()) 
        {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9')
                flag = true;
            else
            if(getAlphanumericCode(c) != -1)
                flag1 = true;
            else
                return Mode.BYTE;
            i++;
        }
        if(flag1)
            return Mode.ALPHANUMERIC;
        if(flag)
            return Mode.NUMERIC;
        else
            return Mode.BYTE;
    }

    public static void encode(String s, ErrorCorrectionLevel errorcorrectionlevel, QRCode qrcode)
        throws WriterException
    {
        encode(s, errorcorrectionlevel, null, qrcode);
    }

    public static void encode(String s, ErrorCorrectionLevel errorcorrectionlevel, Hashtable hashtable, QRCode qrcode)
        throws WriterException
    {
        int i;
        Object obj;
        BitArray bitarray;
        if(hashtable == null)
            hashtable = null;
        else
            hashtable = (String)hashtable.get(EncodeHintType.CHARACTER_SET);
        obj = hashtable;
        if(hashtable == null)
            obj = "UTF-8";
        hashtable = chooseMode(s, ((String) (obj)));
        bitarray = new BitArray();
        appendBytes(s, hashtable, bitarray, ((String) (obj)));
        initQRCode(bitarray.getSizeInBytes(), errorcorrectionlevel, hashtable, qrcode);
        errorcorrectionlevel = new BitArray();
        if(hashtable == Mode.BYTE && !"UTF-8".equals(obj))
        {
            obj = CharacterSetECI.getCharacterSetECIByName(((String) (obj)));
            if(obj != null)
                appendECI(((ECI) (obj)), errorcorrectionlevel);
        }
        appendModeInfo(hashtable, errorcorrectionlevel);
        if(hashtable.equals(Mode.BYTE))
            i = bitarray.getSizeInBytes();
        else
            i = s.length();
        appendLengthInfo(i, qrcode.getVersion(), hashtable, errorcorrectionlevel);
        errorcorrectionlevel.appendBitArray(bitarray);
        terminateBits(qrcode.getNumDataBytes(), errorcorrectionlevel);
        s = new BitArray();
        interleaveWithECBytes(errorcorrectionlevel, qrcode.getNumTotalBytes(), qrcode.getNumDataBytes(), qrcode.getNumRSBlocks(), s);
        errorcorrectionlevel = new ByteMatrix(qrcode.getMatrixWidth(), qrcode.getMatrixWidth());
        qrcode.setMaskPattern(chooseMaskPattern(s, qrcode.getECLevel(), qrcode.getVersion(), errorcorrectionlevel));
        MatrixUtil.buildMatrix(s, qrcode.getECLevel(), qrcode.getVersion(), qrcode.getMaskPattern(), errorcorrectionlevel);
        qrcode.setMatrix(errorcorrectionlevel);
        if(!qrcode.isValid())
            throw new WriterException("Invalid QR code: " + qrcode.toString());
        else
            return;
    }

    static byte[] generateECBytes(byte abyte0[], int i)
    {
        int l = abyte0.length;
        int ai[] = new int[l + i];
        for(int j = 0; j < l; j++)
            ai[j] = abyte0[j] & 0xff;

        (new ReedSolomonEncoder(GF256.QR_CODE_FIELD)).encode(ai, i);
        abyte0 = new byte[i];
        for(int k = 0; k < i; k++)
            abyte0[k] = (byte)ai[l + k];

        return abyte0;
    }

    static int getAlphanumericCode(int i)
    {
        if(i < ALPHANUMERIC_TABLE.length)
            return ALPHANUMERIC_TABLE[i];
        else
            return -1;
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i, int j, int k, int l, int ai[], int ai1[])
        throws WriterException
    {
        if(l >= k)
            throw new WriterException("Block ID too large");
        int i1 = i % k;
        int j1 = k - i1;
        int k1 = i / k;
        j /= k;
        int l1 = j + 1;
        int i2 = k1 - j;
        k1 = (k1 + 1) - l1;
        if(i2 != k1)
            throw new WriterException("EC bytes mismatch");
        if(k != j1 + i1)
            throw new WriterException("RS blocks mismatch");
        if(i != (j + i2) * j1 + (l1 + k1) * i1)
            throw new WriterException("Total bytes mismatch");
        if(l < j1)
        {
            ai[0] = j;
            ai1[0] = i2;
            return;
        } else
        {
            ai[0] = l1;
            ai1[0] = k1;
            return;
        }
    }

    private static void initQRCode(int i, ErrorCorrectionLevel errorcorrectionlevel, Mode mode, QRCode qrcode)
        throws WriterException
    {
        qrcode.setECLevel(errorcorrectionlevel);
        qrcode.setMode(mode);
        for(int j = 1; j <= 40; j++)
        {
            mode = Version.getVersionForNumber(j);
            int k = mode.getTotalCodewords();
            com.google.zxing.qrcode.decoder.Version.ECBlocks ecblocks = mode.getECBlocksForLevel(errorcorrectionlevel);
            int l = ecblocks.getTotalECCodewords();
            int i1 = ecblocks.getNumBlocks();
            int j1 = k - l;
            if(j1 >= i + 3)
            {
                qrcode.setVersion(j);
                qrcode.setNumTotalBytes(k);
                qrcode.setNumDataBytes(j1);
                qrcode.setNumRSBlocks(i1);
                qrcode.setNumECBytes(l);
                qrcode.setMatrixWidth(mode.getDimensionForVersion());
                return;
            }
        }

        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    static void interleaveWithECBytes(BitArray bitarray, int i, int j, int k, BitArray bitarray1)
        throws WriterException
    {
        if(bitarray.getSizeInBytes() != j)
            throw new WriterException("Number of bits and data bytes does not match");
        int k1 = 0;
        int i1 = 0;
        int l = 0;
        Vector vector = new Vector(k);
        for(int j1 = 0; j1 < k; j1++)
        {
            int ai[] = new int[1];
            int ai1[] = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i, j, k, j1, ai, ai1);
            int l1 = ai[0];
            byte abyte0[] = new byte[l1];
            bitarray.toBytes(k1 * 8, abyte0, 0, l1);
            ai1 = generateECBytes(abyte0, ai1[0]);
            vector.addElement(new BlockPair(abyte0, ai1));
            i1 = Math.max(i1, l1);
            l = Math.max(l, ai1.length);
            k1 += ai[0];
        }

        if(j != k1)
            throw new WriterException("Data bytes does not match offset");
        for(j = 0; j < i1; j++)
            for(k = 0; k < vector.size(); k++)
            {
                bitarray = ((BlockPair)vector.elementAt(k)).getDataBytes();
                if(j < bitarray.length)
                    bitarray1.appendBits(bitarray[j], 8);
            }


        for(j = 0; j < l; j++)
            for(k = 0; k < vector.size(); k++)
            {
                bitarray = ((BlockPair)vector.elementAt(k)).getErrorCorrectionBytes();
                if(j < bitarray.length)
                    bitarray1.appendBits(bitarray[j], 8);
            }


        if(i != bitarray1.getSizeInBytes())
            throw new WriterException("Interleaving error: " + i + " and " + bitarray1.getSizeInBytes() + " differ.");
        else
            return;
    }

    private static boolean isOnlyDoubleByteKanji(String s)
    {
        int j;
        try
        {
            s = s.getBytes("Shift_JIS");
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            return false;
        }
        j = s.length;
        if(j % 2 == 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if(i >= j)
                    break label1;
                int k = s[i] & 0xff;
                if((k < 129 || k > 159) && (k < 224 || k > 235))
                    break label0;
                i += 2;
            }
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    static void terminateBits(int i, BitArray bitarray)
        throws WriterException
    {
        int l = i << 3;
        if(bitarray.getSize() > l)
            throw new WriterException("data bits cannot fit in the QR Code" + bitarray.getSize() + " > " + l);
        for(int j = 0; j < 4 && bitarray.getSize() < l; j++)
            bitarray.appendBit(false);

        int k = bitarray.getSize() & 7;
        if(k > 0)
            for(; k < 8; k++)
                bitarray.appendBit(false);

        int i1 = bitarray.getSizeInBytes();
        k = 0;
        while(k < i - i1) 
        {
            char c;
            if((k & 1) == 0)
                c = '\354';
            else
                c = '\021';
            bitarray.appendBits(c, 8);
            k++;
        }
        if(bitarray.getSize() != l)
            throw new WriterException("Bits size does not equal capacity");
        else
            return;
    }

    private static final int ALPHANUMERIC_TABLE[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, 
        -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 
        2, 3, 4, 5, 6, 7, 8, 9, 44, -1, 
        -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 
        35, -1, -1, -1, -1, -1
    };
    static final String DEFAULT_BYTE_MODE_ENCODING = "UTF-8";

}
