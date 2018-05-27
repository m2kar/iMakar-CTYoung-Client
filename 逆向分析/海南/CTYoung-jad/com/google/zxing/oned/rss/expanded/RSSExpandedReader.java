// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss.expanded;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.*;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.oned.rss.expanded:
//            ExpandedPair, BitArrayBuilder

public final class RSSExpandedReader extends AbstractRSSReader
{

    public RSSExpandedReader()
    {
        currentSequence = new int[LONGEST_SEQUENCE_SIZE];
    }

    private void adjustOddEvenCounts(int i)
        throws NotFoundException
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        int j;
        int k;
        int l;
        flag3 = false;
        j = count(oddCounts);
        k = count(evenCounts);
        l = (j + k) - i;
        if((j & 1) == 1)
            flag4 = true;
        else
            flag4 = false;
        if((k & 1) == 0)
            flag3 = true;
        i = 0;
        flag1 = false;
        if(j <= 13) goto _L2; else goto _L1
_L1:
        flag = true;
_L6:
        flag2 = false;
        boolean flag5 = false;
        if(k > 13)
        {
            flag1 = true;
        } else
        {
            flag1 = flag5;
            if(k < 4)
            {
                flag2 = true;
                flag1 = flag5;
            }
        }
        if(l == 1)
        {
            if(flag4)
            {
                if(flag3)
                    throw NotFoundException.getNotFoundInstance();
                flag = true;
            } else
            {
                if(!flag3)
                    throw NotFoundException.getNotFoundInstance();
                flag1 = true;
            }
        } else
        if(l == -1)
        {
            if(flag4)
            {
                if(flag3)
                    throw NotFoundException.getNotFoundInstance();
                i = 1;
            } else
            {
                if(!flag3)
                    throw NotFoundException.getNotFoundInstance();
                flag2 = true;
            }
        } else
        if(l == 0)
        {
            if(!flag4)
                continue; /* Loop/switch isn't completed */
            if(!flag3)
                throw NotFoundException.getNotFoundInstance();
            if(j < k)
            {
                i = 1;
                flag1 = true;
            } else
            {
                flag = true;
                flag2 = true;
            }
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
          goto _L3
_L2:
        flag = flag1;
        if(j < 4)
        {
            i = 1;
            flag = flag1;
        }
        continue; /* Loop/switch isn't completed */
        if(!flag3) goto _L3; else goto _L4
_L4:
        throw NotFoundException.getNotFoundInstance();
_L3:
        if(i != 0)
        {
            if(flag)
                throw NotFoundException.getNotFoundInstance();
            increment(oddCounts, oddRoundingErrors);
        }
        if(flag)
            decrement(oddCounts, oddRoundingErrors);
        if(flag2)
        {
            if(flag1)
                throw NotFoundException.getNotFoundInstance();
            increment(evenCounts, oddRoundingErrors);
        }
        if(flag1)
            decrement(evenCounts, evenRoundingErrors);
        return;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean checkChecksum()
    {
        boolean flag = false;
        ExpandedPair expandedpair = (ExpandedPair)pairs.elementAt(0);
        DataCharacter datacharacter = expandedpair.getLeftChar();
        int i = expandedpair.getRightChar().getChecksumPortion();
        int j = 2;
        for(int k = 1; k < pairs.size(); k++)
        {
            ExpandedPair expandedpair1 = (ExpandedPair)pairs.elementAt(k);
            int l = i + expandedpair1.getLeftChar().getChecksumPortion();
            int i1 = j + 1;
            j = i1;
            i = l;
            if(expandedpair1.getRightChar() != null)
            {
                i = l + expandedpair1.getRightChar().getChecksumPortion();
                j = i1 + 1;
            }
        }

        if((j - 4) * 211 + i % 211 == datacharacter.getValue())
            flag = true;
        return flag;
    }

    private boolean checkPairSequence(Vector vector, FinderPattern finderpattern)
        throws NotFoundException
    {
        int l = vector.size() + 1;
        if(l > currentSequence.length)
            throw NotFoundException.getNotFoundInstance();
        for(int i = 0; i < vector.size(); i++)
            currentSequence[i] = ((ExpandedPair)vector.elementAt(i)).getFinderPattern().getValue();

        currentSequence[l - 1] = finderpattern.getValue();
label0:
        for(int j = 0; j < FINDER_PATTERN_SEQUENCES.length; j++)
        {
            vector = FINDER_PATTERN_SEQUENCES[j];
            if(vector.length < l)
                continue;
            boolean flag1 = true;
            int k = 0;
            do
            {
label1:
                {
                    boolean flag = flag1;
                    if(k < l)
                    {
                        if(currentSequence[k] == vector[k])
                            break label1;
                        flag = false;
                    }
                    if(!flag)
                        continue label0;
                    return l == vector.length;
                }
                k++;
            } while(true);
        }

        throw NotFoundException.getNotFoundInstance();
    }

    private static Result constructResult(Vector vector)
        throws NotFoundException
    {
        String s = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(vector)).parseInformation();
        ResultPoint aresultpoint[] = ((ExpandedPair)vector.elementAt(0)).getFinderPattern().getResultPoints();
        ResultPoint aresultpoint1[] = ((ExpandedPair)vector.lastElement()).getFinderPattern().getResultPoints();
        vector = aresultpoint[0];
        ResultPoint resultpoint = aresultpoint[1];
        ResultPoint resultpoint1 = aresultpoint1[0];
        ResultPoint resultpoint2 = aresultpoint1[1];
        BarcodeFormat barcodeformat = BarcodeFormat.RSS_EXPANDED;
        return new Result(s, null, new ResultPoint[] {
            vector, resultpoint, resultpoint1, resultpoint2
        }, barcodeformat);
    }

    private void findNextPair(BitArray bitarray, Vector vector, int i)
        throws NotFoundException
    {
        int ai[] = decodeFinderCounters;
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        int i1 = bitarray.getSize();
        int j;
        boolean flag1;
        if(i < 0)
            if(vector.isEmpty())
                i = 0;
            else
                i = ((ExpandedPair)vector.lastElement()).getFinderPattern().getStartEnd()[1];
        if(vector.size() % 2 != 0)
            flag1 = true;
        else
            flag1 = false;
        j = 0;
        do
        {
label0:
            {
label1:
                {
                    boolean flag;
                    int l;
                    if(i < i1)
                    {
                        int k;
                        boolean flag2;
                        if(!bitarray.get(i))
                            j = 1;
                        else
                            j = 0;
                        if(j != 0)
                            break label1;
                    }
                    flag2 = false;
                    k = i;
                    l = i;
                    i = k;
                    flag = j;
                    j = ((flag2) ? 1 : 0);
                    while(l < i1) 
                    {
                        if(bitarray.get(l) ^ flag)
                        {
                            ai[j] = ai[j] + 1;
                        } else
                        {
                            if(j == 3)
                            {
                                if(flag1)
                                    reverseCounters(ai);
                                if(isFinderPattern(ai))
                                {
                                    startEnd[0] = i;
                                    startEnd[1] = l;
                                    return;
                                }
                                if(flag1)
                                    reverseCounters(ai);
                                i += ai[0] + ai[1];
                                ai[0] = ai[2];
                                ai[1] = ai[3];
                                ai[2] = 0;
                                ai[3] = 0;
                                j--;
                            } else
                            {
                                j++;
                            }
                            ai[j] = 1;
                            if(!flag)
                                flag = true;
                            else
                                flag = false;
                        }
                        l++;
                    }
                    break label0;
                }
                i++;
                continue;
            }
            throw NotFoundException.getNotFoundInstance();
        } while(true);
    }

    private static int getNextSecondBar(BitArray bitarray, int i)
    {
        boolean flag;
        for(flag = bitarray.get(i); i < bitarray.size && bitarray.get(i) == flag; i++);
        if(!flag)
            flag = true;
        else
            flag = false;
        for(; i < bitarray.size && bitarray.get(i) == flag; i++);
        return i;
    }

    private static boolean isNotA1left(FinderPattern finderpattern, boolean flag, boolean flag1)
    {
        return finderpattern.getValue() != 0 || !flag || !flag1;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitarray, int i, boolean flag)
    {
        int j;
        int k;
        int l;
        if(flag)
        {
            for(j = startEnd[0] - 1; j >= 0 && !bitarray.get(j); j--);
            j++;
            l = startEnd[0] - j;
            k = startEnd[1];
        } else
        {
            l = startEnd[0];
            for(j = startEnd[1] + 1; bitarray.get(j) && j < bitarray.size; j++);
            k = j;
            int j1 = k - startEnd[1];
            j = l;
            l = j1;
        }
        bitarray = decodeFinderCounters;
        for(int i1 = bitarray.length - 1; i1 > 0; i1--)
            bitarray[i1] = bitarray[i1 - 1];

        bitarray[0] = l;
        try
        {
            l = parseFinderValue(bitarray, FINDER_PATTERNS);
        }
        // Misplaced declaration of an exception variable
        catch(BitArray bitarray)
        {
            return null;
        }
        return new FinderPattern(l, new int[] {
            j, k
        }, j, k, i);
    }

    private static void reverseCounters(int ai[])
    {
        int j = ai.length;
        for(int i = 0; i < j / 2; i++)
        {
            int k = ai[i];
            ai[i] = ai[j - i - 1];
            ai[j - i - 1] = k;
        }

    }

    DataCharacter decodeDataCharacter(BitArray bitarray, FinderPattern finderpattern, boolean flag, boolean flag1)
        throws NotFoundException
    {
        int ai[] = dataCharacterCounters;
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        ai[4] = 0;
        ai[5] = 0;
        ai[6] = 0;
        ai[7] = 0;
        float f;
        int k;
        int ai1[];
        float af[];
        float af1[];
        if(flag1)
        {
            recordPatternInReverse(bitarray, finderpattern.getStartEnd()[0], ai);
        } else
        {
            recordPattern(bitarray, finderpattern.getStartEnd()[1] + 1, ai);
            k = 0;
            i = ai.length - 1;
            while(k < i) 
            {
                l = ai[k];
                ai[k] = ai[i];
                ai[i] = l;
                k++;
                i--;
            }
        }
        f = (float)count(ai) / (float)17;
        bitarray = oddCounts;
        ai1 = evenCounts;
        af = oddRoundingErrors;
        af1 = evenRoundingErrors;
        k = 0;
        while(k < ai.length) 
        {
            float f1 = (1.0F * (float)ai[k]) / f;
            int l = (int)(0.5F + f1);
            int i;
            if(l < 1)
            {
                i = 1;
            } else
            {
                i = l;
                if(l > 8)
                    i = 8;
            }
            l = k >> 1;
            if((k & 1) == 0)
            {
                bitarray[l] = i;
                af[l] = f1 - (float)i;
            } else
            {
                ai1[l] = i;
                af1[l] = f1 - (float)i;
            }
            k++;
        }
        adjustOddEvenCounts(17);
        int i1 = finderpattern.getValue();
        int j;
        int l2;
        if(flag)
            j = 0;
        else
            j = 2;
        if(flag1)
            k = 0;
        else
            k = 1;
        l2 = (k + (i1 * 4 + j)) - 1;
        k = 0;
        j = 0;
        for(i1 = bitarray.length - 1; i1 >= 0;)
        {
            int j1 = j;
            if(isNotA1left(finderpattern, flag, flag1))
            {
                j1 = WEIGHTS[l2][i1 * 2];
                j1 = j + bitarray[i1] * j1;
            }
            k += bitarray[i1];
            i1--;
            j = j1;
        }

        i1 = 0;
        int i2 = 0;
        for(int k1 = ai1.length - 1; k1 >= 0;)
        {
            int k2 = i1;
            if(isNotA1left(finderpattern, flag, flag1))
            {
                k2 = WEIGHTS[l2][k1 * 2 + 1];
                k2 = i1 + ai1[k1] * k2;
            }
            i2 += ai1[k1];
            k1--;
            i1 = k2;
        }

        if((k & 1) != 0 || k > 13 || k < 4)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            k = (13 - k) / 2;
            int j2 = SYMBOL_WIDEST[k];
            int l1 = RSSUtils.getRSSvalue(bitarray, j2, true);
            j2 = RSSUtils.getRSSvalue(ai1, 9 - j2, false);
            return new DataCharacter(l1 * EVEN_TOTAL_SUBSET[k] + j2 + GSUM[k], j + i1);
        }
    }

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException
    {
        reset();
        decodeRow2pairs(i, bitarray);
        return constructResult(pairs);
    }

    Vector decodeRow2pairs(int i, BitArray bitarray)
        throws NotFoundException
    {
        ExpandedPair expandedpair;
        do
        {
            do
            {
                expandedpair = retrieveNextPair(bitarray, pairs, i);
                pairs.addElement(expandedpair);
            } while(!expandedpair.mayBeLast());
            if(checkChecksum())
                return pairs;
        } while(!expandedpair.mustBeLast());
        throw NotFoundException.getNotFoundInstance();
    }

    public void reset()
    {
        pairs.setSize(0);
    }

    ExpandedPair retrieveNextPair(BitArray bitarray, Vector vector, int i)
        throws NotFoundException
    {
        boolean flag;
        int j;
        boolean flag2;
        boolean flag3;
        if(vector.size() % 2 == 0)
            flag2 = true;
        else
            flag2 = false;
        flag = true;
        j = -1;
        do
        {
            findNextPair(bitarray, vector, j);
            FinderPattern finderpattern = parseFoundFinderPattern(bitarray, i, flag2);
            boolean flag1;
            if(finderpattern == null)
            {
                j = getNextSecondBar(bitarray, startEnd[0]);
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
            flag = flag1;
        } while(flag1);
        flag3 = checkPairSequence(vector, finderpattern);
        vector = decodeDataCharacter(bitarray, finderpattern, flag2, true);
        try
        {
            bitarray = decodeDataCharacter(bitarray, finderpattern, flag2, false);
        }
        // Misplaced declaration of an exception variable
        catch(BitArray bitarray)
        {
            if(flag3)
                bitarray = null;
            else
                throw bitarray;
        }
        return new ExpandedPair(vector, bitarray, finderpattern, flag3);
    }

    private static final int EVEN_TOTAL_SUBSET[] = {
        4, 20, 52, 104, 204
    };
    private static final int FINDER_PATTERNS[][];
    private static final int FINDER_PATTERN_SEQUENCES[][] = {
        {
            0, 0
        }, {
            0, 1, 1
        }, {
            0, 2, 1, 3
        }, {
            0, 4, 1, 3, 2
        }, {
            0, 4, 1, 3, 3, 5
        }, {
            0, 4, 1, 3, 4, 5, 5
        }, {
            0, 0, 1, 1, 2, 2, 3, 3
        }, {
            0, 0, 1, 1, 2, 2, 3, 4, 4
        }, {
            0, 0, 1, 1, 2, 2, 3, 4, 5, 5
        }, {
            0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 
            5
        }
    };
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int GSUM[] = {
        0, 348, 1388, 2948, 3988
    };
    private static final int LONGEST_SEQUENCE_SIZE = FINDER_PATTERN_SEQUENCES[FINDER_PATTERN_SEQUENCES.length - 1].length;
    private static final int MAX_PAIRS = 11;
    private static final int SYMBOL_WIDEST[] = {
        7, 5, 4, 3, 1
    };
    private static final int WEIGHTS[][];
    private final int currentSequence[];
    private final Vector pairs = new Vector(11);
    private final int startEnd[] = new int[2];

    static 
    {
        int ai[] = {
            1, 8, 4, 1
        };
        int ai1[] = {
            3, 6, 4, 1
        };
        int ai2[] = {
            3, 2, 8, 1
        };
        int ai3[] = {
            2, 6, 5, 1
        };
        int ai4[] = {
            2, 2, 9, 1
        };
        FINDER_PATTERNS = (new int[][] {
            ai, ai1, new int[] {
                3, 4, 6, 1
            }, ai2, ai3, ai4
        });
        ai = (new int[] {
            1, 3, 9, 27, 81, 32, 96, 77
        });
        ai1 = (new int[] {
            20, 60, 180, 118, 143, 7, 21, 63
        });
        ai2 = (new int[] {
            62, 186, 136, 197, 169, 85, 44, 132
        });
        ai3 = (new int[] {
            76, 17, 51, 153, 37, 111, 122, 155
        });
        ai4 = (new int[] {
            43, 129, 176, 106, 107, 110, 119, 146
        });
        int ai5[] = {
            161, 61, 183, 127, 170, 88, 53, 159
        };
        int ai6[] = {
            55, 165, 73, 8, 24, 72, 5, 15
        };
        WEIGHTS = (new int[][] {
            ai, ai1, new int[] {
                189, 145, 13, 39, 117, 140, 209, 205
            }, new int[] {
                193, 157, 49, 147, 19, 57, 171, 91
            }, ai2, new int[] {
                185, 133, 188, 142, 4, 12, 36, 108
            }, new int[] {
                113, 128, 173, 97, 80, 29, 87, 50
            }, new int[] {
                150, 28, 84, 41, 123, 158, 52, 156
            }, new int[] {
                46, 138, 203, 187, 139, 206, 196, 166
            }, ai3, 
            ai4, new int[] {
                16, 48, 144, 10, 30, 90, 59, 177
            }, new int[] {
                109, 116, 137, 200, 178, 112, 125, 164
            }, new int[] {
                70, 210, 208, 202, 184, 130, 179, 115
            }, new int[] {
                134, 191, 151, 31, 93, 68, 204, 190
            }, new int[] {
                148, 22, 66, 198, 172, 94, 71, 2
            }, new int[] {
                6, 18, 54, 162, 64, 192, 154, 40
            }, new int[] {
                120, 149, 25, 75, 14, 42, 126, 167
            }, new int[] {
                79, 26, 78, 23, 69, 207, 199, 175
            }, new int[] {
                103, 98, 83, 38, 114, 131, 182, 124
            }, 
            ai5, ai6, new int[] {
                45, 135, 194, 160, 58, 174, 100, 89
            }
        });
    }
}
