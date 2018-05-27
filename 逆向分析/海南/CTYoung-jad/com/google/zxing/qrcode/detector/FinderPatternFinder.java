// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.detector;

import com.google.zxing.*;
import com.google.zxing.common.*;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.google.zxing.qrcode.detector:
//            FinderPattern, FinderPatternInfo

public class FinderPatternFinder
{
    private static class CenterComparator
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            if(((FinderPattern)obj1).getCount() != ((FinderPattern)obj).getCount())
                return ((FinderPattern)obj1).getCount() - ((FinderPattern)obj).getCount();
            float f = Math.abs(((FinderPattern)obj1).getEstimatedModuleSize() - average);
            float f1 = Math.abs(((FinderPattern)obj).getEstimatedModuleSize() - average);
            if(f < f1)
                return 1;
            return f != f1 ? -1 : 0;
        }

        private final float average;

        public CenterComparator(float f)
        {
            average = f;
        }
    }

    private static class FurthestFromAverageComparator
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            float f = Math.abs(((FinderPattern)obj1).getEstimatedModuleSize() - average);
            float f1 = Math.abs(((FinderPattern)obj).getEstimatedModuleSize() - average);
            if(f < f1)
                return -1;
            return f != f1 ? 1 : 0;
        }

        private final float average;

        public FurthestFromAverageComparator(float f)
        {
            average = f;
        }
    }


    public FinderPatternFinder(BitMatrix bitmatrix)
    {
        this(bitmatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitmatrix, ResultPointCallback resultpointcallback)
    {
        image = bitmatrix;
        possibleCenters = new Vector();
        crossCheckStateCount = new int[5];
        resultPointCallback = resultpointcallback;
    }

    private static float centerFromEnd(int ai[], int i)
    {
        return (float)(i - ai[4] - ai[3]) - (float)ai[2] / 2.0F;
    }

    private float crossCheckHorizontal(int i, int j, int k, int l)
    {
        BitMatrix bitmatrix = image;
        int k1 = bitmatrix.getWidth();
        int ai[] = getCrossCheckStateCount();
        int i1;
        for(i1 = i; i1 >= 0 && bitmatrix.get(i1, j); i1--)
            ai[2] = ai[2] + 1;

        int j1 = i1;
        if(i1 < 0)
            return (0.0F / 0.0F);
        for(; j1 >= 0 && !bitmatrix.get(j1, j) && ai[1] <= k; j1--)
            ai[1] = ai[1] + 1;

        if(j1 < 0 || ai[1] > k)
            return (0.0F / 0.0F);
        for(; j1 >= 0 && bitmatrix.get(j1, j) && ai[0] <= k; j1--)
            ai[0] = ai[0] + 1;

        if(ai[0] > k)
            return (0.0F / 0.0F);
        for(i++; i < k1 && bitmatrix.get(i, j); i++)
            ai[2] = ai[2] + 1;

        i1 = i;
        if(i == k1)
            return (0.0F / 0.0F);
        for(; i1 < k1 && !bitmatrix.get(i1, j) && ai[3] < k; i1++)
            ai[3] = ai[3] + 1;

        if(i1 == k1 || ai[3] >= k)
            return (0.0F / 0.0F);
        for(; i1 < k1 && bitmatrix.get(i1, j) && ai[4] < k; i1++)
            ai[4] = ai[4] + 1;

        if(ai[4] >= k)
            return (0.0F / 0.0F);
        if(Math.abs((ai[0] + ai[1] + ai[2] + ai[3] + ai[4]) - l) * 5 >= l)
            return (0.0F / 0.0F);
        if(foundPatternCross(ai))
            return centerFromEnd(ai, i1);
        else
            return (0.0F / 0.0F);
    }

    private float crossCheckVertical(int i, int j, int k, int l)
    {
        BitMatrix bitmatrix = image;
        int k1 = bitmatrix.getHeight();
        int ai[] = getCrossCheckStateCount();
        int i1;
        for(i1 = i; i1 >= 0 && bitmatrix.get(j, i1); i1--)
            ai[2] = ai[2] + 1;

        int j1 = i1;
        if(i1 < 0)
            return (0.0F / 0.0F);
        for(; j1 >= 0 && !bitmatrix.get(j, j1) && ai[1] <= k; j1--)
            ai[1] = ai[1] + 1;

        if(j1 < 0 || ai[1] > k)
            return (0.0F / 0.0F);
        for(; j1 >= 0 && bitmatrix.get(j, j1) && ai[0] <= k; j1--)
            ai[0] = ai[0] + 1;

        if(ai[0] > k)
            return (0.0F / 0.0F);
        for(i++; i < k1 && bitmatrix.get(j, i); i++)
            ai[2] = ai[2] + 1;

        i1 = i;
        if(i == k1)
            return (0.0F / 0.0F);
        for(; i1 < k1 && !bitmatrix.get(j, i1) && ai[3] < k; i1++)
            ai[3] = ai[3] + 1;

        if(i1 == k1 || ai[3] >= k)
            return (0.0F / 0.0F);
        for(; i1 < k1 && bitmatrix.get(j, i1) && ai[4] < k; i1++)
            ai[4] = ai[4] + 1;

        if(ai[4] >= k)
            return (0.0F / 0.0F);
        if(Math.abs((ai[0] + ai[1] + ai[2] + ai[3] + ai[4]) - l) * 5 >= l * 2)
            return (0.0F / 0.0F);
        if(foundPatternCross(ai))
            return centerFromEnd(ai, i1);
        else
            return (0.0F / 0.0F);
    }

    private int findRowSkip()
    {
        FinderPattern finderpattern;
        FinderPattern finderpattern2;
        int j = possibleCenters.size();
        if(j > 1)
        {
            finderpattern = null;
            int i = 0;
            while(i < j) 
            {
label0:
                {
                    finderpattern2 = (FinderPattern)possibleCenters.elementAt(i);
                    FinderPattern finderpattern1 = finderpattern;
                    if(finderpattern2.getCount() >= 2)
                    {
                        if(finderpattern != null)
                            break label0;
                        finderpattern1 = finderpattern2;
                    }
                    i++;
                    finderpattern = finderpattern1;
                }
            }
        }
        return 0;
        hasSkipped = true;
        return (int)(Math.abs(finderpattern.getX() - finderpattern2.getX()) - Math.abs(finderpattern.getY() - finderpattern2.getY())) / 2;
    }

    protected static boolean foundPatternCross(int ai[])
    {
        int i;
        int k;
        boolean flag;
        flag = true;
        k = 0;
        i = 0;
_L7:
        if(i >= 5) goto _L2; else goto _L1
_L1:
        int l = ai[i];
        if(l != 0) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        k += l;
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if(k < 7) goto _L3; else goto _L5
_L5:
        int j = (k << 8) / 7;
        k = j / 2;
        if(Math.abs(j - (ai[0] << 8)) >= k || Math.abs(j - (ai[1] << 8)) >= k || Math.abs(j * 3 - (ai[2] << 8)) >= k * 3 || Math.abs(j - (ai[3] << 8)) >= k || Math.abs(j - (ai[4] << 8)) >= k)
            flag = false;
        return flag;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private int[] getCrossCheckStateCount()
    {
        crossCheckStateCount[0] = 0;
        crossCheckStateCount[1] = 0;
        crossCheckStateCount[2] = 0;
        crossCheckStateCount[3] = 0;
        crossCheckStateCount[4] = 0;
        return crossCheckStateCount;
    }

    private boolean haveMultiplyConfirmedCenters()
    {
        int k = 0;
        float f = 0.0F;
        int i1 = possibleCenters.size();
        for(int i = 0; i < i1;)
        {
            FinderPattern finderpattern = (FinderPattern)possibleCenters.elementAt(i);
            int l = k;
            float f1 = f;
            if(finderpattern.getCount() >= 2)
            {
                l = k + 1;
                f1 = f + finderpattern.getEstimatedModuleSize();
            }
            i++;
            k = l;
            f = f1;
        }

        if(k >= 3)
        {
            float f3 = f / (float)i1;
            float f2 = 0.0F;
            for(int j = 0; j < i1; j++)
                f2 += Math.abs(((FinderPattern)possibleCenters.elementAt(j)).getEstimatedModuleSize() - f3);

            if(f2 <= 0.05F * f)
                return true;
        }
        return false;
    }

    private FinderPattern[] selectBestPatterns()
        throws NotFoundException
    {
        int l = possibleCenters.size();
        if(l < 3)
            throw NotFoundException.getNotFoundInstance();
        if(l > 3)
        {
            float f2 = 0.0F;
            float f = 0.0F;
            for(int i = 0; i < l; i++)
            {
                float f3 = ((FinderPattern)possibleCenters.elementAt(i)).getEstimatedModuleSize();
                f2 += f3;
                f += f3 * f3;
            }

            f2 /= l;
            f = (float)Math.sqrt(f / (float)l - f2 * f2);
            Collections.insertionSort(possibleCenters, new FurthestFromAverageComparator(f2));
            f = Math.max(0.2F * f2, f);
            int i1;
            for(int j = 0; j < possibleCenters.size() && possibleCenters.size() > 3; j = i1 + 1)
            {
                i1 = j;
                if(Math.abs(((FinderPattern)possibleCenters.elementAt(j)).getEstimatedModuleSize() - f2) > f)
                {
                    possibleCenters.removeElementAt(j);
                    i1 = j - 1;
                }
            }

        }
        if(possibleCenters.size() > 3)
        {
            float f1 = 0.0F;
            for(int k = 0; k < possibleCenters.size(); k++)
                f1 += ((FinderPattern)possibleCenters.elementAt(k)).getEstimatedModuleSize();

            f1 /= possibleCenters.size();
            Collections.insertionSort(possibleCenters, new CenterComparator(f1));
            possibleCenters.setSize(3);
        }
        return (new FinderPattern[] {
            (FinderPattern)possibleCenters.elementAt(0), (FinderPattern)possibleCenters.elementAt(1), (FinderPattern)possibleCenters.elementAt(2)
        });
    }

    FinderPatternInfo find(Hashtable hashtable)
        throws NotFoundException
    {
        int i;
        int i1;
        int k1;
        int l1;
        boolean flag;
        if(hashtable != null && hashtable.containsKey(DecodeHintType.TRY_HARDER))
            i = 1;
        else
            i = 0;
        k1 = image.getHeight();
        l1 = image.getWidth();
        i1 = (k1 * 3) / 228;
        if(i1 < 3 || i != 0)
            i1 = 3;
        flag = false;
        hashtable = new int[5];
        for(int l = i1 - 1; l < k1 && !flag;)
        {
            hashtable[0] = 0;
            hashtable[1] = 0;
            hashtable[2] = 0;
            hashtable[3] = 0;
            hashtable[4] = 0;
            i = 0;
            int j = 0;
            while(j < l1) 
            {
                if(image.get(j, l))
                {
                    int j1 = i;
                    if((i & 1) == 1)
                        j1 = i + 1;
                    hashtable[j1] = hashtable[j1] + 1;
                    i = j1;
                } else
                if((i & 1) == 0)
                {
                    if(i == 4)
                    {
                        if(foundPatternCross(hashtable))
                        {
                            if(handlePossibleCenter(hashtable, l, j))
                            {
                                byte byte0 = 2;
                                boolean flag1;
                                if(hasSkipped)
                                {
                                    flag1 = haveMultiplyConfirmedCenters();
                                    i1 = l;
                                } else
                                {
                                    i = findRowSkip();
                                    flag1 = flag;
                                    i1 = l;
                                    if(i > hashtable[2])
                                    {
                                        i1 = l + (i - hashtable[2] - 2);
                                        j = l1 - 1;
                                        flag1 = flag;
                                    }
                                }
                                i = 0;
                                hashtable[0] = 0;
                                hashtable[1] = 0;
                                hashtable[2] = 0;
                                hashtable[3] = 0;
                                hashtable[4] = 0;
                                flag = flag1;
                                l = i1;
                                i1 = byte0;
                            } else
                            {
                                hashtable[0] = hashtable[2];
                                hashtable[1] = hashtable[3];
                                hashtable[2] = hashtable[4];
                                hashtable[3] = 1;
                                hashtable[4] = 0;
                                i = 3;
                            }
                        } else
                        {
                            hashtable[0] = hashtable[2];
                            hashtable[1] = hashtable[3];
                            hashtable[2] = hashtable[4];
                            hashtable[3] = 1;
                            hashtable[4] = 0;
                            i = 3;
                        }
                    } else
                    {
                        i++;
                        hashtable[i] = hashtable[i] + 1;
                    }
                } else
                {
                    hashtable[i] = hashtable[i] + 1;
                }
                j++;
            }
            boolean flag2 = flag;
            i = i1;
            if(foundPatternCross(hashtable))
            {
                flag2 = flag;
                i = i1;
                if(handlePossibleCenter(hashtable, l, l1))
                {
                    int k = hashtable[0];
                    flag2 = flag;
                    i = k;
                    if(hasSkipped)
                    {
                        flag2 = haveMultiplyConfirmedCenters();
                        i = k;
                    }
                }
            }
            l += i;
            flag = flag2;
            i1 = i;
        }

        hashtable = selectBestPatterns();
        ResultPoint.orderBestPatterns(hashtable);
        return new FinderPatternInfo(hashtable);
    }

    protected BitMatrix getImage()
    {
        return image;
    }

    protected Vector getPossibleCenters()
    {
        return possibleCenters;
    }

    protected boolean handlePossibleCenter(int ai[], int i, int j)
    {
        int k = ai[0] + ai[1] + ai[2] + ai[3] + ai[4];
        float f1 = centerFromEnd(ai, j);
        float f = crossCheckVertical(i, (int)f1, ai[2], k);
        if(!Float.isNaN(f))
        {
            f1 = crossCheckHorizontal((int)f1, (int)f, ai[2], k);
            if(!Float.isNaN(f1))
            {
                float f2 = (float)k / 7F;
                k = 0;
                int l = possibleCenters.size();
                i = 0;
                do
                {
label0:
                    {
                        j = k;
                        if(i < l)
                        {
                            ai = (FinderPattern)possibleCenters.elementAt(i);
                            if(!ai.aboutEquals(f2, f, f1))
                                break label0;
                            ai.incrementCount();
                            j = 1;
                        }
                        if(j == 0)
                        {
                            ai = new FinderPattern(f1, f, f2);
                            possibleCenters.addElement(ai);
                            if(resultPointCallback != null)
                                resultPointCallback.foundPossibleResultPoint(ai);
                        }
                        return true;
                    }
                    i++;
                } while(true);
            }
        }
        return false;
    }

    private static final int CENTER_QUORUM = 2;
    private static final int INTEGER_MATH_SHIFT = 8;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int crossCheckStateCount[];
    private boolean hasSkipped;
    private final BitMatrix image;
    private final Vector possibleCenters;
    private final ResultPointCallback resultPointCallback;
}
