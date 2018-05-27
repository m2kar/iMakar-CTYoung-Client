// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned;

import com.google.zxing.*;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class Code128Reader extends OneDReader
{

    public Code128Reader()
    {
    }

    private static int decodeCode(BitArray bitarray, int ai[], int i)
        throws NotFoundException
    {
        recordPattern(bitarray, i, ai);
        int j = 64;
        int l = -1;
        for(i = 0; i < CODE_PATTERNS.length;)
        {
            int i1 = patternMatchVariance(ai, CODE_PATTERNS[i], 179);
            int k = j;
            if(i1 < j)
            {
                k = i1;
                l = i;
            }
            i++;
            j = k;
        }

        if(l >= 0)
            return l;
        else
            throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findStartPattern(BitArray bitarray)
        throws NotFoundException
    {
        int i2 = bitarray.getSize();
        int i = 0;
        do
        {
            if(i >= i2 || bitarray.get(i))
            {
                int i1 = 0;
                int ai[] = new int[6];
                int j = i;
                boolean flag = false;
                int j2 = ai.length;
                int l = i;
                i = j;
                while(l < i2) 
                {
                    int k;
                    if(bitarray.get(l) ^ flag)
                    {
                        ai[i1] = ai[i1] + 1;
                        k = i1;
                    } else
                    {
                        if(i1 == j2 - 1)
                        {
                            int j1 = 64;
                            byte byte0 = -1;
                            for(k = 103; k <= 105;)
                            {
                                int l1 = patternMatchVariance(ai, CODE_PATTERNS[k], 179);
                                int k1 = j1;
                                if(l1 < j1)
                                {
                                    k1 = l1;
                                    byte0 = k;
                                }
                                k++;
                                j1 = k1;
                            }

                            if(byte0 >= 0 && bitarray.isRange(Math.max(0, i - (l - i) / 2), i, false))
                                return (new int[] {
                                    i, l, byte0
                                });
                            k = i + (ai[0] + ai[1]);
                            for(i = 2; i < j2; i++)
                                ai[i - 2] = ai[i];

                            ai[j2 - 2] = 0;
                            ai[j2 - 1] = 0;
                            i1--;
                            i = k;
                            k = i1;
                        } else
                        {
                            k = i1 + 1;
                        }
                        ai[k] = 1;
                        if(!flag)
                            flag = true;
                        else
                            flag = false;
                    }
                    l++;
                    i1 = k;
                }
            } else
            {
                i++;
                continue;
            }
            throw NotFoundException.getNotFoundInstance();
        } while(true);
    }

    public Result decodeRow(int i, BitArray bitarray, Hashtable hashtable)
        throws NotFoundException, FormatException, ChecksumException
    {
        int j3;
        hashtable = findStartPattern(bitarray);
        j3 = hashtable[2];
        j3;
        JVM INSTR tableswitch 103 105: default 40
    //                   103 44
    //                   104 202
    //                   105 209;
           goto _L1 _L2 _L3 _L4
_L1:
        throw FormatException.getFormatInstance();
_L2:
        byte byte1 = 101;
_L27:
        int i1;
        int j1;
        int k1;
        boolean flag2;
        boolean flag4;
        int l2;
        int i3;
        int k3;
        Object obj;
        int ai[];
        flag4 = false;
        flag2 = false;
        obj = new StringBuffer(20);
        i3 = hashtable[0];
        i1 = hashtable[1];
        ai = new int[6];
        k3 = 0;
        k1 = 0;
        l2 = 0;
        j1 = 1;
_L14:
        boolean flag5 = flag2;
        if(flag4) goto _L6; else goto _L5
_L5:
        int l;
        boolean flag3;
        int l1;
        int i2;
        int j2;
        int k2;
        int l3;
        flag2 = false;
        flag3 = k1;
        l3 = decodeCode(bitarray, ai, i1);
        l = j1;
        if(l3 != 106)
            l = 1;
        i2 = j3;
        l1 = l2;
        if(l3 != 106)
        {
            l1 = l2 + 1;
            i2 = j3 + l1 * l3;
        }
        j2 = i1;
        int j = 0;
        k2 = i1;
        for(; j < ai.length; j++)
            k2 += ai[j];

          goto _L7
_L3:
        byte1 = 100;
        continue; /* Loop/switch isn't completed */
_L4:
        byte1 = 99;
        continue; /* Loop/switch isn't completed */
_L7:
        l3;
        JVM INSTR tableswitch 103 105: default 244
    //                   103 442
    //                   104 442
    //                   105 442;
           goto _L8 _L9 _L9 _L9
_L8:
        byte1;
        JVM INSTR tableswitch 99 101: default 272
    //                   99 913
    //                   100 697
    //                   101 446;
           goto _L10 _L11 _L12 _L13
_L10:
        byte byte0;
        boolean flag;
        boolean flag1;
        flag1 = flag2;
        flag = flag4;
        byte0 = byte1;
_L17:
        j3 = i2;
        k1 = l3;
        byte1 = byte0;
        flag4 = flag;
        flag2 = flag1;
        j1 = l;
        k3 = ((flag3) ? 1 : 0);
        i3 = j2;
        l2 = l1;
        i1 = k2;
        if(flag5)
        {
            switch(byte0)
            {
            default:
                j3 = i2;
                k1 = l3;
                byte1 = byte0;
                flag4 = flag;
                flag2 = flag1;
                j1 = l;
                k3 = ((flag3) ? 1 : 0);
                i3 = j2;
                l2 = l1;
                i1 = k2;
                break;

            case 99: // 'c'
                byte1 = 100;
                j3 = i2;
                k1 = l3;
                flag4 = flag;
                flag2 = flag1;
                j1 = l;
                k3 = ((flag3) ? 1 : 0);
                i3 = j2;
                l2 = l1;
                i1 = k2;
                break;

            case 101: // 'e'
                byte1 = 99;
                j3 = i2;
                k1 = l3;
                flag4 = flag;
                flag2 = flag1;
                j1 = l;
                k3 = ((flag3) ? 1 : 0);
                i3 = j2;
                l2 = l1;
                i1 = k2;
                break;

            case 100: // 'd'
                byte1 = 101;
                j3 = i2;
                k1 = l3;
                flag4 = flag;
                flag2 = flag1;
                j1 = l;
                k3 = ((flag3) ? 1 : 0);
                i3 = j2;
                l2 = l1;
                i1 = k2;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L14
_L9:
        throw FormatException.getFormatInstance();
_L13:
        if(l3 >= 64) goto _L16; else goto _L15
_L15:
        ((StringBuffer) (obj)).append((char)(l3 + 32));
        byte0 = byte1;
        flag = flag4;
        flag1 = flag2;
          goto _L17
_L16:
        if(l3 >= 96) goto _L19; else goto _L18
_L18:
        ((StringBuffer) (obj)).append((char)(l3 - 64));
        byte0 = byte1;
        flag = flag4;
        flag1 = flag2;
          goto _L17
_L19:
        i1 = l;
        if(l3 != 106)
            i1 = 0;
        byte0 = byte1;
        flag = flag4;
        flag1 = flag2;
        l = i1;
        switch(l3)
        {
        case 103: // 'g'
        case 104: // 'h'
        case 105: // 'i'
        default:
            byte0 = byte1;
            flag = flag4;
            flag1 = flag2;
            l = i1;
            break;

        case 98: // 'b'
            flag1 = true;
            byte0 = 100;
            flag = flag4;
            l = i1;
            break;

        case 100: // 'd'
            byte0 = 100;
            flag = flag4;
            flag1 = flag2;
            l = i1;
            break;

        case 99: // 'c'
            byte0 = 99;
            flag = flag4;
            flag1 = flag2;
            l = i1;
            break;

        case 106: // 'j'
            flag = true;
            byte0 = byte1;
            flag1 = flag2;
            l = i1;
            break;

        case 96: // '`'
        case 97: // 'a'
        case 101: // 'e'
        case 102: // 'f'
            break;
        }
        if(true) goto _L17; else goto _L20
_L20:
_L12:
        if(l3 >= 96) goto _L22; else goto _L21
_L21:
        ((StringBuffer) (obj)).append((char)(l3 + 32));
        byte0 = byte1;
        flag = flag4;
        flag1 = flag2;
          goto _L17
_L22:
        i1 = l;
        if(l3 != 106)
            i1 = 0;
        byte0 = byte1;
        flag = flag4;
        flag1 = flag2;
        l = i1;
        switch(l3)
        {
        case 103: // 'g'
        case 104: // 'h'
        case 105: // 'i'
        default:
            byte0 = byte1;
            flag = flag4;
            flag1 = flag2;
            l = i1;
            break;

        case 98: // 'b'
            flag1 = true;
            byte0 = 99;
            flag = flag4;
            l = i1;
            break;

        case 101: // 'e'
            byte0 = 101;
            flag = flag4;
            flag1 = flag2;
            l = i1;
            break;

        case 99: // 'c'
            byte0 = 99;
            flag = flag4;
            flag1 = flag2;
            l = i1;
            break;

        case 106: // 'j'
            flag = true;
            byte0 = byte1;
            flag1 = flag2;
            l = i1;
            break;

        case 96: // '`'
        case 97: // 'a'
        case 100: // 'd'
        case 102: // 'f'
            break;
        }
        if(true) goto _L17; else goto _L23
_L23:
_L11:
        if(l3 < 100)
        {
            if(l3 < 10)
                ((StringBuffer) (obj)).append('0');
            ((StringBuffer) (obj)).append(l3);
            byte0 = byte1;
            flag = flag4;
            flag1 = flag2;
        } else
        {
            i1 = l;
            if(l3 != 106)
                i1 = 0;
            byte0 = byte1;
            flag = flag4;
            flag1 = flag2;
            l = i1;
            switch(l3)
            {
            case 103: // 'g'
            case 104: // 'h'
            case 105: // 'i'
            default:
                byte0 = byte1;
                flag = flag4;
                flag1 = flag2;
                l = i1;
                break;

            case 100: // 'd'
                byte0 = 100;
                flag = flag4;
                flag1 = flag2;
                l = i1;
                break;

            case 101: // 'e'
                byte0 = 101;
                flag = flag4;
                flag1 = flag2;
                l = i1;
                break;

            case 106: // 'j'
                flag = true;
                byte0 = byte1;
                flag1 = flag2;
                l = i1;
                break;

            case 102: // 'f'
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L17
        if(true) goto _L17; else goto _L24
_L24:
        if(true) goto _L14; else goto _L25
_L25:
_L6:
        int k;
        for(k = bitarray.getSize(); i1 < k && bitarray.get(i1); i1++);
        if(!bitarray.isRange(i1, Math.min(k, (i1 - i3) / 2 + i1), false))
            throw NotFoundException.getNotFoundInstance();
        if((j3 - l2 * k3) % 103 != k3)
            throw ChecksumException.getChecksumInstance();
        k = ((StringBuffer) (obj)).length();
        if(k > 0 && j1 != 0)
            if(byte1 == 99)
                ((StringBuffer) (obj)).delete(k - 2, k);
            else
                ((StringBuffer) (obj)).delete(k - 1, k);
        bitarray = ((StringBuffer) (obj)).toString();
        if(bitarray.length() == 0)
            throw FormatException.getFormatInstance();
        float f = (float)(hashtable[1] + hashtable[0]) / 2.0F;
        float f1 = (float)(i1 + i3) / 2.0F;
        hashtable = new ResultPoint(f, i);
        obj = new ResultPoint(f1, i);
        BarcodeFormat barcodeformat = BarcodeFormat.CODE_128;
        return new Result(bitarray, null, new ResultPoint[] {
            hashtable, obj
        }, barcodeformat);
        if(true) goto _L27; else goto _L26
_L26:
    }

    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int CODE_PATTERNS[][];
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final int MAX_AVG_VARIANCE = 64;
    private static final int MAX_INDIVIDUAL_VARIANCE = 179;

    static 
    {
        int ai[] = {
            2, 1, 2, 2, 2, 2
        };
        int ai1[] = {
            2, 2, 2, 1, 2, 2
        };
        int ai2[] = {
            1, 2, 1, 2, 2, 3
        };
        int ai3[] = {
            1, 2, 1, 3, 2, 2
        };
        int ai4[] = {
            1, 2, 2, 2, 1, 3
        };
        int ai5[] = {
            1, 2, 2, 3, 1, 2
        };
        int ai6[] = {
            1, 3, 2, 2, 1, 2
        };
        int ai7[] = {
            2, 2, 1, 2, 1, 3
        };
        int ai8[] = {
            2, 3, 1, 2, 1, 2
        };
        int ai9[] = {
            1, 2, 2, 1, 3, 2
        };
        int ai10[] = {
            1, 2, 2, 2, 3, 1
        };
        int ai11[] = {
            1, 1, 3, 2, 2, 2
        };
        int ai12[] = {
            1, 2, 3, 1, 2, 2
        };
        int ai13[] = {
            1, 2, 3, 2, 2, 1
        };
        int ai14[] = {
            2, 2, 3, 2, 1, 1
        };
        int ai15[] = {
            2, 2, 1, 2, 3, 1
        };
        int ai16[] = {
            2, 1, 3, 2, 1, 2
        };
        int ai17[] = {
            2, 2, 3, 1, 1, 2
        };
        int ai18[] = {
            3, 1, 2, 1, 3, 1
        };
        int ai19[] = {
            3, 1, 1, 2, 2, 2
        };
        int ai20[] = {
            3, 2, 1, 1, 2, 2
        };
        int ai21[] = {
            3, 2, 1, 2, 2, 1
        };
        int ai22[] = {
            3, 2, 2, 1, 1, 2
        };
        int ai23[] = {
            3, 2, 2, 2, 1, 1
        };
        int ai24[] = {
            2, 1, 2, 1, 2, 3
        };
        int ai25[] = {
            2, 1, 2, 3, 2, 1
        };
        int ai26[] = {
            2, 3, 2, 1, 2, 1
        };
        int ai27[] = {
            1, 1, 1, 3, 2, 3
        };
        int ai28[] = {
            1, 3, 1, 1, 2, 3
        };
        int ai29[] = {
            1, 3, 1, 3, 2, 1
        };
        int ai30[] = {
            1, 1, 2, 3, 1, 3
        };
        int ai31[] = {
            1, 3, 2, 1, 1, 3
        };
        int ai32[] = {
            2, 1, 1, 3, 1, 3
        };
        int ai33[] = {
            2, 3, 1, 1, 1, 3
        };
        int ai34[] = {
            2, 3, 1, 3, 1, 1
        };
        int ai35[] = {
            1, 1, 2, 1, 3, 3
        };
        int ai36[] = {
            1, 1, 2, 3, 3, 1
        };
        int ai37[] = {
            1, 3, 2, 1, 3, 1
        };
        int ai38[] = {
            1, 1, 3, 1, 2, 3
        };
        int ai39[] = {
            1, 1, 3, 3, 2, 1
        };
        int ai40[] = {
            1, 3, 3, 1, 2, 1
        };
        int ai41[] = {
            3, 1, 3, 1, 2, 1
        };
        int ai42[] = {
            2, 1, 1, 3, 3, 1
        };
        int ai43[] = {
            2, 3, 1, 1, 3, 1
        };
        int ai44[] = {
            2, 1, 3, 1, 1, 3
        };
        int ai45[] = {
            2, 1, 3, 3, 1, 1
        };
        int ai46[] = {
            2, 1, 3, 1, 3, 1
        };
        int ai47[] = {
            3, 1, 1, 1, 2, 3
        };
        int ai48[] = {
            3, 1, 1, 3, 2, 1
        };
        int ai49[] = {
            3, 3, 1, 1, 2, 1
        };
        int ai50[] = {
            3, 1, 2, 1, 1, 3
        };
        int ai51[] = {
            3, 1, 2, 3, 1, 1
        };
        int ai52[] = {
            2, 2, 1, 4, 1, 1
        };
        int ai53[] = {
            4, 3, 1, 1, 1, 1
        };
        int ai54[] = {
            1, 1, 1, 2, 2, 4
        };
        int ai55[] = {
            1, 1, 1, 4, 2, 2
        };
        int ai56[] = {
            1, 2, 1, 1, 2, 4
        };
        int ai57[] = {
            1, 4, 1, 1, 2, 2
        };
        int ai58[] = {
            1, 4, 1, 2, 2, 1
        };
        int ai59[] = {
            1, 1, 2, 2, 1, 4
        };
        int ai60[] = {
            1, 1, 2, 4, 1, 2
        };
        int ai61[] = {
            1, 2, 2, 1, 1, 4
        };
        int ai62[] = {
            1, 2, 2, 4, 1, 1
        };
        int ai63[] = {
            1, 4, 2, 1, 1, 2
        };
        int ai64[] = {
            1, 4, 2, 2, 1, 1
        };
        int ai65[] = {
            2, 4, 1, 2, 1, 1
        };
        int ai66[] = {
            2, 2, 1, 1, 1, 4
        };
        int ai67[] = {
            2, 4, 1, 1, 1, 2
        };
        int ai68[] = {
            1, 3, 4, 1, 1, 1
        };
        int ai69[] = {
            1, 1, 1, 2, 4, 2
        };
        int ai70[] = {
            1, 2, 1, 1, 4, 2
        };
        int ai71[] = {
            1, 2, 1, 2, 4, 1
        };
        int ai72[] = {
            1, 1, 4, 2, 1, 2
        };
        int ai73[] = {
            1, 2, 4, 1, 1, 2
        };
        int ai74[] = {
            4, 1, 1, 2, 1, 2
        };
        int ai75[] = {
            4, 2, 1, 1, 1, 2
        };
        int ai76[] = {
            2, 1, 2, 1, 4, 1
        };
        int ai77[] = {
            2, 1, 4, 1, 2, 1
        };
        int ai78[] = {
            4, 1, 2, 1, 2, 1
        };
        int ai79[] = {
            1, 1, 1, 1, 4, 3
        };
        int ai80[] = {
            1, 3, 1, 1, 4, 1
        };
        int ai81[] = {
            1, 1, 4, 1, 1, 3
        };
        int ai82[] = {
            1, 1, 4, 3, 1, 1
        };
        int ai83[] = {
            4, 1, 1, 1, 1, 3
        };
        int ai84[] = {
            1, 1, 3, 1, 4, 1
        };
        int ai85[] = {
            1, 1, 4, 1, 3, 1
        };
        int ai86[] = {
            3, 1, 1, 1, 4, 1
        };
        int ai87[] = {
            4, 1, 1, 1, 3, 1
        };
        int ai88[] = {
            2, 1, 1, 2, 1, 4
        };
        int ai89[] = {
            2, 1, 1, 2, 3, 2
        };
        int ai90[] = {
            2, 3, 3, 1, 1, 1, 2
        };
        CODE_PATTERNS = (new int[][] {
            ai, ai1, new int[] {
                2, 2, 2, 2, 2, 1
            }, ai2, ai3, new int[] {
                1, 3, 1, 2, 2, 2
            }, ai4, ai5, ai6, ai7, 
            new int[] {
                2, 2, 1, 3, 1, 2
            }, ai8, new int[] {
                1, 1, 2, 2, 3, 2
            }, ai9, ai10, ai11, ai12, ai13, ai14, new int[] {
                2, 2, 1, 1, 3, 2
            }, 
            ai15, ai16, ai17, ai18, ai19, ai20, ai21, new int[] {
                3, 1, 2, 2, 1, 2
            }, ai22, ai23, 
            ai24, ai25, ai26, ai27, ai28, ai29, ai30, ai31, new int[] {
                1, 3, 2, 3, 1, 1
            }, ai32, 
            ai33, ai34, ai35, ai36, ai37, ai38, ai39, ai40, ai41, ai42, 
            ai43, ai44, ai45, ai46, ai47, ai48, ai49, ai50, ai51, new int[] {
                3, 3, 2, 1, 1, 1
            }, 
            new int[] {
                3, 1, 4, 1, 1, 1
            }, ai52, ai53, ai54, ai55, ai56, new int[] {
                1, 2, 1, 4, 2, 1
            }, ai57, ai58, ai59, 
            ai60, ai61, ai62, ai63, ai64, ai65, ai66, new int[] {
                4, 1, 3, 1, 1, 1
            }, ai67, ai68, 
            ai69, ai70, ai71, ai72, ai73, new int[] {
                1, 2, 4, 2, 1, 1
            }, ai74, ai75, new int[] {
                4, 2, 1, 2, 1, 1
            }, ai76, 
            ai77, ai78, ai79, new int[] {
                1, 1, 1, 3, 4, 1
            }, ai80, ai81, ai82, ai83, new int[] {
                4, 1, 1, 3, 1, 1
            }, ai84, 
            ai85, ai86, ai87, new int[] {
                2, 1, 1, 4, 1, 2
            }, ai88, ai89, ai90
        });
    }
}
