// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.detector.*;
import java.util.Hashtable;
import java.util.Vector;

final class MultiFinderPatternFinder extends FinderPatternFinder
{
    private static class ModuleSizeComparator
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            float f = ((FinderPattern)obj1).getEstimatedModuleSize() - ((FinderPattern)obj).getEstimatedModuleSize();
            if((double)f < 0.0D)
                return -1;
            return (double)f <= 0.0D ? 0 : 1;
        }

        private ModuleSizeComparator()
        {
        }

    }


    MultiFinderPatternFinder(BitMatrix bitmatrix)
    {
        super(bitmatrix);
    }

    MultiFinderPatternFinder(BitMatrix bitmatrix, ResultPointCallback resultpointcallback)
    {
        super(bitmatrix, resultpointcallback);
    }

    private FinderPattern[][] selectBestPatterns()
        throws NotFoundException
    {
        int i1;
        Vector vector;
        vector = getPossibleCenters();
        i1 = vector.size();
        if(i1 < 3)
            throw NotFoundException.getNotFoundInstance();
        if(i1 != 3) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new FinderPattern[1][];
        obj[0] = (new FinderPattern[] {
            (FinderPattern)vector.elementAt(0), (FinderPattern)vector.elementAt(1), (FinderPattern)vector.elementAt(2)
        });
_L17:
        return ((FinderPattern [][]) (obj));
_L2:
        int i;
        Vector vector1;
        Collections.insertionSort(vector, new ModuleSizeComparator());
        vector1 = new Vector();
        i = 0;
_L4:
        if(i >= i1 - 2)
            break MISSING_BLOCK_LABEL_498;
        obj = (FinderPattern)vector.elementAt(i);
        if(obj != null)
            break; /* Loop/switch isn't completed */
_L6:
        i++;
        if(true) goto _L4; else goto _L3
_L3:
        int k = i + 1;
_L9:
        if(k >= i1 - 1) goto _L6; else goto _L5
_L5:
        FinderPattern finderpattern = (FinderPattern)vector.elementAt(k);
        if(finderpattern != null) goto _L8; else goto _L7
_L7:
        k++;
          goto _L9
_L8:
        float f = (((FinderPattern) (obj)).getEstimatedModuleSize() - finderpattern.getEstimatedModuleSize()) / Math.min(((FinderPattern) (obj)).getEstimatedModuleSize(), finderpattern.getEstimatedModuleSize());
        if(Math.abs(((FinderPattern) (obj)).getEstimatedModuleSize() - finderpattern.getEstimatedModuleSize()) > 0.5F && f >= 0.05F) goto _L6; else goto _L10
_L10:
        int l = k + 1;
_L14:
        if(l >= i1) goto _L7; else goto _L11
_L11:
        Object obj1 = (FinderPattern)vector.elementAt(l);
        if(obj1 != null) goto _L13; else goto _L12
_L12:
        l++;
          goto _L14
_L13:
        f = (finderpattern.getEstimatedModuleSize() - ((FinderPattern) (obj1)).getEstimatedModuleSize()) / Math.min(finderpattern.getEstimatedModuleSize(), ((FinderPattern) (obj1)).getEstimatedModuleSize());
        if(Math.abs(finderpattern.getEstimatedModuleSize() - ((FinderPattern) (obj1)).getEstimatedModuleSize()) > 0.5F && f >= 0.05F) goto _L7; else goto _L15
_L15:
        FinderPattern afinderpattern1[] = new FinderPattern[3];
        afinderpattern1[0] = ((FinderPattern) (obj));
        afinderpattern1[1] = finderpattern;
        afinderpattern1[2] = ((FinderPattern) (obj1));
        ResultPoint.orderBestPatterns(afinderpattern1);
        obj1 = new FinderPatternInfo(afinderpattern1);
        float f2 = ResultPoint.distance(((FinderPatternInfo) (obj1)).getTopLeft(), ((FinderPatternInfo) (obj1)).getBottomLeft());
        float f1 = ResultPoint.distance(((FinderPatternInfo) (obj1)).getTopRight(), ((FinderPatternInfo) (obj1)).getBottomLeft());
        float f3 = ResultPoint.distance(((FinderPatternInfo) (obj1)).getTopLeft(), ((FinderPatternInfo) (obj1)).getTopRight());
        float f4 = (f2 + f3) / ((FinderPattern) (obj)).getEstimatedModuleSize() / 2.0F;
        if(f4 <= 180F && f4 >= 9F && Math.abs((f2 - f3) / Math.min(f2, f3)) < 0.1F)
        {
            f2 = (float)Math.sqrt(f2 * f2 + f3 * f3);
            if(Math.abs((f1 - f2) / Math.min(f1, f2)) < 0.1F)
                vector1.addElement(afinderpattern1);
        }
          goto _L12
label0:
        {
            if(vector1.isEmpty())
                break label0;
            FinderPattern afinderpattern[][] = new FinderPattern[vector1.size()][];
            int j = 0;
            do
            {
                obj = afinderpattern;
                if(j >= vector1.size())
                    break;
                afinderpattern[j] = (FinderPattern[])(FinderPattern[])vector1.elementAt(j);
                j++;
            } while(true);
        }
        if(true) goto _L17; else goto _L16
_L16:
        throw NotFoundException.getNotFoundInstance();
    }

    public FinderPatternInfo[] findMulti(Hashtable hashtable)
        throws NotFoundException
    {
        Vector vector;
        int i;
        int k1;
        int i2;
        int j2;
        int ai[];
        if(hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER))
            i = 1;
        else
            i = 0;
        hashtable = getImage();
        i2 = hashtable.getHeight();
        j2 = hashtable.getWidth();
        k1 = (int)(((float)i2 / 228F) * 3F);
        if(k1 < 3 || i != 0)
            k1 = 3;
        ai = new int[5];
        for(int l1 = k1 - 1; l1 < i2; l1 += k1)
        {
            ai[0] = 0;
            ai[1] = 0;
            ai[2] = 0;
            ai[3] = 0;
            ai[4] = 0;
            int l = 0;
            i = 0;
            while(i < j2) 
            {
                if(hashtable.get(i, l1))
                {
                    int i1 = l;
                    if((l & 1) == 1)
                        i1 = l + 1;
                    ai[i1] = ai[i1] + 1;
                    l = i1;
                } else
                if((l & 1) == 0)
                {
                    if(l == 4)
                    {
                        if(foundPatternCross(ai))
                        {
                            int j1 = i;
                            if(!handlePossibleCenter(ai, l1, i))
                            {
                                do
                                {
                                    l = i + 1;
                                    if(l >= j2)
                                        break;
                                    i = l;
                                } while(!hashtable.get(l, l1));
                                j1 = l - 1;
                            }
                            l = 0;
                            ai[0] = 0;
                            ai[1] = 0;
                            ai[2] = 0;
                            ai[3] = 0;
                            ai[4] = 0;
                            i = j1;
                        } else
                        {
                            ai[0] = ai[2];
                            ai[1] = ai[3];
                            ai[2] = ai[4];
                            ai[3] = 1;
                            ai[4] = 0;
                            l = 3;
                        }
                    } else
                    {
                        l++;
                        ai[l] = ai[l] + 1;
                    }
                } else
                {
                    ai[l] = ai[l] + 1;
                }
                i++;
            }
            if(foundPatternCross(ai))
                handlePossibleCenter(ai, l1, j2);
        }

        hashtable = selectBestPatterns();
        vector = new Vector();
        for(int j = 0; j < hashtable.length; j++)
        {
            ResultPoint aresultpoint[] = hashtable[j];
            ResultPoint.orderBestPatterns(aresultpoint);
            vector.addElement(new FinderPatternInfo(aresultpoint));
        }

        if(!vector.isEmpty()) goto _L2; else goto _L1
_L1:
        hashtable = EMPTY_RESULT_ARRAY;
_L4:
        return hashtable;
_L2:
        FinderPatternInfo afinderpatterninfo[] = new FinderPatternInfo[vector.size()];
        int k = 0;
        do
        {
            hashtable = afinderpatterninfo;
            if(k >= vector.size())
                continue;
            afinderpatterninfo[k] = (FinderPatternInfo)vector.elementAt(k);
            k++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final float DIFF_MODSIZE_CUTOFF = 0.5F;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05F;
    private static final FinderPatternInfo EMPTY_RESULT_ARRAY[] = new FinderPatternInfo[0];
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180F;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9F;

}
