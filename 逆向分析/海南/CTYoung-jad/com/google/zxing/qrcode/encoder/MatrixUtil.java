// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

// Referenced classes of package com.google.zxing.qrcode.encoder:
//            ByteMatrix, MaskUtil, QRCode

public final class MatrixUtil
{

    private MatrixUtil()
    {
    }

    public static void buildMatrix(BitArray bitarray, ErrorCorrectionLevel errorcorrectionlevel, int i, int j, ByteMatrix bytematrix)
        throws WriterException
    {
        clearMatrix(bytematrix);
        embedBasicPatterns(i, bytematrix);
        embedTypeInfo(errorcorrectionlevel, j, bytematrix);
        maybeEmbedVersionInfo(i, bytematrix);
        embedDataBits(bitarray, j, bytematrix);
    }

    public static int calculateBCHCode(int i, int j)
    {
        int k = findMSBSet(j);
        for(i <<= k - 1; findMSBSet(i) >= k; i ^= j << findMSBSet(i) - k);
        return i;
    }

    public static void clearMatrix(ByteMatrix bytematrix)
    {
        bytematrix.clear((byte)-1);
    }

    public static void embedBasicPatterns(int i, ByteMatrix bytematrix)
        throws WriterException
    {
        embedPositionDetectionPatternsAndSeparators(bytematrix);
        embedDarkDotAtLeftBottomCorner(bytematrix);
        maybeEmbedPositionAdjustmentPatterns(i, bytematrix);
        embedTimingPatterns(bytematrix);
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix bytematrix)
        throws WriterException
    {
        if(bytematrix.get(8, bytematrix.getHeight() - 8) == 0)
        {
            throw new WriterException();
        } else
        {
            bytematrix.set(8, bytematrix.getHeight() - 8, 1);
            return;
        }
    }

    public static void embedDataBits(BitArray bitarray, int i, ByteMatrix bytematrix)
        throws WriterException
    {
        int l1 = 0;
        int l = -1;
        int k = bytematrix.getWidth() - 1;
        int j = bytematrix.getHeight() - 1;
        while(k > 0) 
        {
            int k1 = l1;
            int i1 = k;
            int j1 = j;
            if(k == 6)
            {
                i1 = k - 1;
                j1 = j;
                k1 = l1;
            }
            while(j1 >= 0 && j1 < bytematrix.getHeight()) 
            {
                k = 0;
                j = k1;
                while(k < 2) 
                {
                    k1 = i1 - k;
                    if(isEmpty(bytematrix.get(k1, j1)))
                    {
                        boolean flag;
                        boolean flag1;
                        if(j < bitarray.getSize())
                        {
                            flag = bitarray.get(j);
                            j++;
                        } else
                        {
                            flag = false;
                        }
                        flag1 = flag;
                        if(i != -1)
                        {
                            flag1 = flag;
                            if(MaskUtil.getDataMaskBit(i, k1, j1))
                                if(!flag)
                                    flag1 = true;
                                else
                                    flag1 = false;
                        }
                        bytematrix.set(k1, j1, flag1);
                    }
                    k++;
                }
                j1 += l;
                k1 = j;
            }
            l = -l;
            j = j1 + l;
            k = i1 - 2;
            l1 = k1;
        }
        if(l1 != bitarray.getSize())
            throw new WriterException("Not all bits consumed: " + l1 + '/' + bitarray.getSize());
        else
            return;
    }

    private static void embedHorizontalSeparationPattern(int i, int j, ByteMatrix bytematrix)
        throws WriterException
    {
        if(HORIZONTAL_SEPARATION_PATTERN[0].length != 8 || HORIZONTAL_SEPARATION_PATTERN.length != 1)
            throw new WriterException("Bad horizontal separation pattern");
        for(int k = 0; k < 8; k++)
        {
            if(!isEmpty(bytematrix.get(i + k, j)))
                throw new WriterException();
            bytematrix.set(i + k, j, HORIZONTAL_SEPARATION_PATTERN[0][k]);
        }

    }

    private static void embedPositionAdjustmentPattern(int i, int j, ByteMatrix bytematrix)
        throws WriterException
    {
        if(POSITION_ADJUSTMENT_PATTERN[0].length != 5 || POSITION_ADJUSTMENT_PATTERN.length != 5)
            throw new WriterException("Bad position adjustment");
        for(int k = 0; k < 5; k++)
        {
            for(int l = 0; l < 5; l++)
            {
                if(!isEmpty(bytematrix.get(i + l, j + k)))
                    throw new WriterException();
                bytematrix.set(i + l, j + k, POSITION_ADJUSTMENT_PATTERN[k][l]);
            }

        }

    }

    private static void embedPositionDetectionPattern(int i, int j, ByteMatrix bytematrix)
        throws WriterException
    {
        if(POSITION_DETECTION_PATTERN[0].length != 7 || POSITION_DETECTION_PATTERN.length != 7)
            throw new WriterException("Bad position detection pattern");
        for(int k = 0; k < 7; k++)
        {
            for(int l = 0; l < 7; l++)
            {
                if(!isEmpty(bytematrix.get(i + l, j + k)))
                    throw new WriterException();
                bytematrix.set(i + l, j + k, POSITION_DETECTION_PATTERN[k][l]);
            }

        }

    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix bytematrix)
        throws WriterException
    {
        int i = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, bytematrix);
        embedPositionDetectionPattern(bytematrix.getWidth() - i, 0, bytematrix);
        embedPositionDetectionPattern(0, bytematrix.getWidth() - i, bytematrix);
        i = HORIZONTAL_SEPARATION_PATTERN[0].length;
        embedHorizontalSeparationPattern(0, i - 1, bytematrix);
        embedHorizontalSeparationPattern(bytematrix.getWidth() - i, i - 1, bytematrix);
        embedHorizontalSeparationPattern(0, bytematrix.getWidth() - i, bytematrix);
        i = VERTICAL_SEPARATION_PATTERN.length;
        embedVerticalSeparationPattern(i, 0, bytematrix);
        embedVerticalSeparationPattern(bytematrix.getHeight() - i - 1, 0, bytematrix);
        embedVerticalSeparationPattern(i, bytematrix.getHeight() - i, bytematrix);
    }

    private static void embedTimingPatterns(ByteMatrix bytematrix)
        throws WriterException
    {
        for(int i = 8; i < bytematrix.getWidth() - 8; i++)
        {
            int j = (i + 1) % 2;
            if(!isValidValue(bytematrix.get(i, 6)))
                throw new WriterException();
            if(isEmpty(bytematrix.get(i, 6)))
                bytematrix.set(i, 6, j);
            if(!isValidValue(bytematrix.get(6, i)))
                throw new WriterException();
            if(isEmpty(bytematrix.get(6, i)))
                bytematrix.set(6, i, j);
        }

    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorcorrectionlevel, int i, ByteMatrix bytematrix)
        throws WriterException
    {
        BitArray bitarray = new BitArray();
        makeTypeInfoBits(errorcorrectionlevel, i, bitarray);
        i = 0;
        while(i < bitarray.getSize()) 
        {
            boolean flag = bitarray.get(bitarray.getSize() - 1 - i);
            bytematrix.set(TYPE_INFO_COORDINATES[i][0], TYPE_INFO_COORDINATES[i][1], flag);
            if(i < 8)
                bytematrix.set(bytematrix.getWidth() - i - 1, 8, flag);
            else
                bytematrix.set(8, (bytematrix.getHeight() - 7) + (i - 8), flag);
            i++;
        }
    }

    private static void embedVerticalSeparationPattern(int i, int j, ByteMatrix bytematrix)
        throws WriterException
    {
        if(VERTICAL_SEPARATION_PATTERN[0].length != 1 || VERTICAL_SEPARATION_PATTERN.length != 7)
            throw new WriterException("Bad vertical separation pattern");
        for(int k = 0; k < 7; k++)
        {
            if(!isEmpty(bytematrix.get(i, j + k)))
                throw new WriterException();
            bytematrix.set(i, j + k, VERTICAL_SEPARATION_PATTERN[k][0]);
        }

    }

    public static int findMSBSet(int i)
    {
        boolean flag = false;
        int j = i;
        for(i = ((flag) ? 1 : 0); j != 0; i++)
            j >>>= 1;

        return i;
    }

    private static boolean isEmpty(int i)
    {
        return i == -1;
    }

    private static boolean isValidValue(int i)
    {
        return i == -1 || i == 0 || i == 1;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorcorrectionlevel, int i, BitArray bitarray)
        throws WriterException
    {
        if(!QRCode.isValidMaskPattern(i))
            throw new WriterException("Invalid mask pattern");
        i = errorcorrectionlevel.getBits() << 3 | i;
        bitarray.appendBits(i, 5);
        bitarray.appendBits(calculateBCHCode(i, 1335), 10);
        errorcorrectionlevel = new BitArray();
        errorcorrectionlevel.appendBits(21522, 15);
        bitarray.xor(errorcorrectionlevel);
        if(bitarray.getSize() != 15)
            throw new WriterException("should not happen but we got: " + bitarray.getSize());
        else
            return;
    }

    public static void makeVersionInfoBits(int i, BitArray bitarray)
        throws WriterException
    {
        bitarray.appendBits(i, 6);
        bitarray.appendBits(calculateBCHCode(i, 7973), 12);
        if(bitarray.getSize() != 18)
            throw new WriterException("should not happen but we got: " + bitarray.getSize());
        else
            return;
    }

    private static void maybeEmbedPositionAdjustmentPatterns(int i, ByteMatrix bytematrix)
        throws WriterException
    {
        if(i >= 2) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i--;
        int ai[] = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[i];
        int k = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[i].length;
        i = 0;
        do
        {
            if(i >= k)
                continue;
            int j = 0;
            do
            {
                if(j >= k)
                    break;
                int l = ai[i];
                int i1 = ai[j];
                if(i1 != -1 && l != -1 && isEmpty(bytematrix.get(i1, l)))
                    embedPositionAdjustmentPattern(i1 - 2, l - 2, bytematrix);
                j++;
            } while(true);
            i++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void maybeEmbedVersionInfo(int i, ByteMatrix bytematrix)
        throws WriterException
    {
        if(i >= 7)
        {
            BitArray bitarray = new BitArray();
            makeVersionInfoBits(i, bitarray);
            int j = 17;
            i = 0;
            while(i < 6) 
            {
                for(int k = 0; k < 3; k++)
                {
                    boolean flag = bitarray.get(j);
                    j--;
                    bytematrix.set(i, (bytematrix.getHeight() - 11) + k, flag);
                    bytematrix.set((bytematrix.getHeight() - 11) + k, i, flag);
                }

                i++;
            }
        }
    }

    private static final int HORIZONTAL_SEPARATION_PATTERN[][] = {
        {
            0, 0, 0, 0, 0, 0, 0, 0
        }
    };
    private static final int POSITION_ADJUSTMENT_PATTERN[][];
    private static final int POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[][];
    private static final int POSITION_DETECTION_PATTERN[][];
    private static final int TYPE_INFO_COORDINATES[][] = {
        {
            8, 0
        }, {
            8, 1
        }, {
            8, 2
        }, {
            8, 3
        }, {
            8, 4
        }, {
            8, 5
        }, {
            8, 7
        }, {
            8, 8
        }, {
            7, 8
        }, {
            5, 8
        }, {
            4, 8
        }, {
            3, 8
        }, {
            2, 8
        }, {
            1, 8
        }, {
            0, 8
        }
    };
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int VERTICAL_SEPARATION_PATTERN[][] = {
        {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }
    };

    static 
    {
        int ai[] = {
            1, 0, 0, 0, 0, 0, 1
        };
        int ai1[] = {
            1, 0, 0, 0, 0, 0, 1
        };
        POSITION_DETECTION_PATTERN = (new int[][] {
            new int[] {
                1, 1, 1, 1, 1, 1, 1
            }, ai, new int[] {
                1, 0, 1, 1, 1, 0, 1
            }, new int[] {
                1, 0, 1, 1, 1, 0, 1
            }, new int[] {
                1, 0, 1, 1, 1, 0, 1
            }, ai1, new int[] {
                1, 1, 1, 1, 1, 1, 1
            }
        });
        ai = (new int[] {
            1, 1, 1, 1, 1
        });
        ai1 = (new int[] {
            1, 0, 1, 0, 1
        });
        int ai2[] = {
            1, 1, 1, 1, 1
        };
        POSITION_ADJUSTMENT_PATTERN = (new int[][] {
            ai, new int[] {
                1, 0, 0, 0, 1
            }, ai1, new int[] {
                1, 0, 0, 0, 1
            }, ai2
        });
        ai = (new int[] {
            -1, -1, -1, -1, -1, -1, -1
        });
        ai1 = (new int[] {
            6, 18, -1, -1, -1, -1, -1
        });
        ai2 = (new int[] {
            6, 22, -1, -1, -1, -1, -1
        });
        int ai3[] = {
            6, 26, -1, -1, -1, -1, -1
        };
        int ai4[] = {
            6, 30, -1, -1, -1, -1, -1
        };
        int ai5[] = {
            6, 34, -1, -1, -1, -1, -1
        };
        int ai6[] = {
            6, 22, 38, -1, -1, -1, -1
        };
        int ai7[] = {
            6, 24, 42, -1, -1, -1, -1
        };
        int ai8[] = {
            6, 26, 46, -1, -1, -1, -1
        };
        int ai9[] = {
            6, 30, 54, -1, -1, -1, -1
        };
        int ai10[] = {
            6, 32, 58, -1, -1, -1, -1
        };
        int ai11[] = {
            6, 34, 62, -1, -1, -1, -1
        };
        int ai12[] = {
            6, 26, 46, 66, -1, -1, -1
        };
        int ai13[] = {
            6, 26, 48, 70, -1, -1, -1
        };
        int ai14[] = {
            6, 26, 50, 74, -1, -1, -1
        };
        int ai15[] = {
            6, 30, 54, 78, -1, -1, -1
        };
        int ai16[] = {
            6, 30, 56, 82, -1, -1, -1
        };
        int ai17[] = {
            6, 30, 58, 86, -1, -1, -1
        };
        int ai18[] = {
            6, 34, 62, 90, -1, -1, -1
        };
        int ai19[] = {
            6, 28, 50, 72, 94, -1, -1
        };
        int ai20[] = {
            6, 26, 50, 74, 98, -1, -1
        };
        int ai21[] = {
            6, 28, 54, 80, 106, -1, -1
        };
        int ai22[] = {
            6, 32, 58, 84, 110, -1, -1
        };
        int ai23[] = {
            6, 30, 58, 86, 114, -1, -1
        };
        int ai24[] = {
            6, 34, 62, 90, 118, -1, -1
        };
        int ai25[] = {
            6, 26, 50, 74, 98, 122, -1
        };
        int ai26[] = {
            6, 30, 54, 78, 102, 126, -1
        };
        int ai27[] = {
            6, 26, 52, 78, 104, 130, -1
        };
        int ai28[] = {
            6, 30, 56, 82, 108, 134, -1
        };
        int ai29[] = {
            6, 34, 60, 86, 112, 138, -1
        };
        int ai30[] = {
            6, 34, 62, 90, 118, 146, -1
        };
        int ai31[] = {
            6, 30, 54, 78, 102, 126, 150
        };
        int ai32[] = {
            6, 24, 50, 76, 102, 128, 154
        };
        int ai33[] = {
            6, 28, 54, 80, 106, 132, 158
        };
        int ai34[] = {
            6, 32, 58, 84, 110, 136, 162
        };
        int ai35[] = {
            6, 26, 54, 82, 110, 138, 166
        };
        int ai36[] = {
            6, 30, 58, 86, 114, 142, 170
        };
        POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = (new int[][] {
            ai, ai1, ai2, ai3, ai4, ai5, ai6, ai7, ai8, new int[] {
                6, 28, 50, -1, -1, -1, -1
            }, 
            ai9, ai10, ai11, ai12, ai13, ai14, ai15, ai16, ai17, ai18, 
            ai19, ai20, new int[] {
                6, 30, 54, 78, 102, -1, -1
            }, ai21, ai22, ai23, ai24, ai25, ai26, ai27, 
            ai28, ai29, new int[] {
                6, 30, 58, 86, 114, 142, -1
            }, ai30, ai31, ai32, ai33, ai34, ai35, ai36
        });
    }
}
