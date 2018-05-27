// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.*;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.util.*;

public final class Detector
{
    private static class ResultPointsAndTransitions
    {

        public ResultPoint getFrom()
        {
            return from;
        }

        public ResultPoint getTo()
        {
            return to;
        }

        public int getTransitions()
        {
            return transitions;
        }

        public String toString()
        {
            return from + "/" + to + '/' + transitions;
        }

        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint resultpoint, ResultPoint resultpoint1, int i)
        {
            from = resultpoint;
            to = resultpoint1;
            transitions = i;
        }

    }

    private static class ResultPointsAndTransitionsComparator
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            return ((ResultPointsAndTransitions)obj).getTransitions() - ((ResultPointsAndTransitions)obj1).getTransitions();
        }

        private ResultPointsAndTransitionsComparator()
        {
        }

    }


    public Detector(BitMatrix bitmatrix)
    {
        image = bitmatrix;
        rectangleDetector = new WhiteRectangleDetector(bitmatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i)
    {
        ResultPoint resultpoint4;
        float f = (float)distance(resultpoint, resultpoint1) / (float)i;
        int j = distance(resultpoint2, resultpoint3);
        float f1 = (resultpoint3.getX() - resultpoint2.getX()) / (float)j;
        float f2 = (resultpoint3.getY() - resultpoint2.getY()) / (float)j;
        resultpoint4 = new ResultPoint(resultpoint3.getX() + f * f1, resultpoint3.getY() + f * f2);
        f = (float)distance(resultpoint, resultpoint1) / (float)i;
        i = distance(resultpoint1, resultpoint3);
        f1 = (resultpoint3.getX() - resultpoint1.getX()) / (float)i;
        f2 = (resultpoint3.getY() - resultpoint1.getY()) / (float)i;
        resultpoint = new ResultPoint(resultpoint3.getX() + f * f1, resultpoint3.getY() + f * f2);
        if(isValid(resultpoint4)) goto _L2; else goto _L1
_L1:
        if(!isValid(resultpoint)) goto _L4; else goto _L3
_L3:
        return resultpoint;
_L4:
        return null;
_L2:
        if(!isValid(resultpoint))
            return resultpoint4;
        if(Math.abs(transitionsBetween(resultpoint2, resultpoint4).getTransitions() - transitionsBetween(resultpoint1, resultpoint4).getTransitions()) <= Math.abs(transitionsBetween(resultpoint2, resultpoint).getTransitions() - transitionsBetween(resultpoint1, resultpoint).getTransitions()))
            return resultpoint4;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private static int distance(ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        return round((float)Math.sqrt((resultpoint.getX() - resultpoint1.getX()) * (resultpoint.getX() - resultpoint1.getX()) + (resultpoint.getY() - resultpoint1.getY()) * (resultpoint.getY() - resultpoint1.getY())));
    }

    private static void increment(Hashtable hashtable, ResultPoint resultpoint)
    {
        Integer integer = (Integer)hashtable.get(resultpoint);
        if(integer == null)
            integer = INTEGERS[1];
        else
            integer = INTEGERS[integer.intValue() + 1];
        hashtable.put(resultpoint, integer);
    }

    private boolean isValid(ResultPoint resultpoint)
    {
        return resultpoint.getX() >= 0.0F && resultpoint.getX() < (float)image.width && resultpoint.getY() > 0.0F && resultpoint.getY() < (float)image.height;
    }

    private static int round(float f)
    {
        return (int)(0.5F + f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitmatrix, ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i)
        throws NotFoundException
    {
        return GridSampler.getInstance().sampleGrid(bitmatrix, i, 0.5F, 0.5F, (float)i - 0.5F, 0.5F, (float)i - 0.5F, (float)i - 0.5F, 0.5F, (float)i - 0.5F, resultpoint.getX(), resultpoint.getY(), resultpoint3.getX(), resultpoint3.getY(), resultpoint2.getX(), resultpoint2.getY(), resultpoint1.getX(), resultpoint1.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        int k1 = (int)resultpoint.getX();
        int l1 = (int)resultpoint.getY();
        int k = (int)resultpoint1.getX();
        int l = (int)resultpoint1.getY();
        int i;
        int j;
        boolean flag;
        int i1;
        int j1;
        int i2;
        boolean flag1;
        int k2;
        int l2;
        boolean flag2;
        BitMatrix bitmatrix;
        if(Math.abs(l - l1) > Math.abs(k - k1))
            flag = true;
        else
            flag = false;
        j = k1;
        i = l1;
        j1 = k;
        i1 = l;
        if(flag)
        {
            j = l1;
            i = k1;
            i1 = k;
            j1 = l;
        }
        k2 = Math.abs(j1 - j);
        l2 = Math.abs(i1 - i);
        i2 = -k2 >> 1;
        if(i < i1)
            k1 = 1;
        else
            k1 = -1;
        if(j < j1)
            l1 = 1;
        else
            l1 = -1;
        flag1 = false;
        bitmatrix = image;
        if(flag)
            k = i;
        else
            k = j;
        if(flag)
            l = j;
        else
            l = i;
        flag2 = bitmatrix.get(k, l);
        k = j;
        j = i;
        i = k;
        k = ((flag1) ? 1 : 0);
        do
        {
            int j2;
            boolean flag3;
label0:
            {
label1:
                {
                    l = k;
                    if(i != j1)
                    {
                        BitMatrix bitmatrix1 = image;
                        boolean flag4;
                        if(flag)
                            l = j;
                        else
                            l = i;
                        if(flag)
                            j2 = i;
                        else
                            j2 = j;
                        flag4 = bitmatrix1.get(l, j2);
                        flag3 = flag2;
                        l = k;
                        if(flag4 != flag2)
                        {
                            l = k + 1;
                            flag3 = flag4;
                        }
                        i2 += l2;
                        k = i2;
                        j2 = j;
                        if(i2 <= 0)
                            break label0;
                        if(j != i1)
                            break label1;
                    }
                    return new ResultPointsAndTransitions(resultpoint, resultpoint1, l);
                }
                j2 = j + k1;
                k = i2 - k2;
            }
            i += l1;
            i2 = k;
            flag2 = flag3;
            k = l;
            j = j2;
        } while(true);
    }

    public DetectorResult detect()
        throws NotFoundException
    {
        ResultPoint aresultpoint[] = rectangleDetector.detect();
        ResultPoint resultpoint2 = aresultpoint[0];
        ResultPoint resultpoint3 = aresultpoint[1];
        ResultPoint resultpoint4 = aresultpoint[2];
        ResultPoint resultpoint5 = aresultpoint[3];
        Object obj1 = new Vector(4);
        ((Vector) (obj1)).addElement(transitionsBetween(resultpoint2, resultpoint3));
        ((Vector) (obj1)).addElement(transitionsBetween(resultpoint2, resultpoint4));
        ((Vector) (obj1)).addElement(transitionsBetween(resultpoint3, resultpoint5));
        ((Vector) (obj1)).addElement(transitionsBetween(resultpoint4, resultpoint5));
        Collections.insertionSort(((Vector) (obj1)), new ResultPointsAndTransitionsComparator());
        Object obj = (ResultPointsAndTransitions)((Vector) (obj1)).elementAt(0);
        obj1 = (ResultPointsAndTransitions)((Vector) (obj1)).elementAt(1);
        Hashtable hashtable = new Hashtable();
        increment(hashtable, ((ResultPointsAndTransitions) (obj)).getFrom());
        increment(hashtable, ((ResultPointsAndTransitions) (obj)).getTo());
        increment(hashtable, ((ResultPointsAndTransitions) (obj1)).getFrom());
        increment(hashtable, ((ResultPointsAndTransitions) (obj1)).getTo());
        obj1 = null;
        ResultPoint resultpoint1 = null;
        ResultPoint resultpoint = null;
        for(Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements();)
        {
            obj = (ResultPoint)enumeration.nextElement();
            if(((Integer)hashtable.get(obj)).intValue() == 2)
                resultpoint1 = ((ResultPoint) (obj));
            else
            if(obj1 == null)
                obj1 = obj;
            else
                resultpoint = ((ResultPoint) (obj));
        }

        if(obj1 == null || resultpoint1 == null || resultpoint == null)
            throw NotFoundException.getNotFoundInstance();
        obj = new ResultPoint[3];
        obj[0] = ((ResultPoint) (obj1));
        obj[1] = resultpoint1;
        obj[2] = resultpoint;
        ResultPoint.orderBestPatterns(((ResultPoint []) (obj)));
        resultpoint1 = obj[0];
        ResultPoint resultpoint6 = obj[1];
        ResultPoint resultpoint7 = obj[2];
        int i;
        int j;
        if(!hashtable.containsKey(resultpoint2))
            obj = resultpoint2;
        else
        if(!hashtable.containsKey(resultpoint3))
            obj = resultpoint3;
        else
        if(!hashtable.containsKey(resultpoint4))
            obj = resultpoint4;
        else
            obj = resultpoint5;
        j = Math.min(transitionsBetween(resultpoint7, ((ResultPoint) (obj))).getTransitions(), transitionsBetween(resultpoint1, ((ResultPoint) (obj))).getTransitions());
        i = j;
        if((j & 1) == 1)
            i = j + 1;
        resultpoint = correctTopRight(resultpoint6, resultpoint1, resultpoint7, ((ResultPoint) (obj)), i + 2);
        obj1 = resultpoint;
        if(resultpoint == null)
            obj1 = obj;
        j = Math.max(transitionsBetween(resultpoint7, ((ResultPoint) (obj1))).getTransitions(), transitionsBetween(resultpoint1, ((ResultPoint) (obj1))).getTransitions()) + 1;
        i = j;
        if((j & 1) == 1)
            i = j + 1;
        return new DetectorResult(sampleGrid(image, resultpoint7, resultpoint6, resultpoint1, ((ResultPoint) (obj1)), i), new ResultPoint[] {
            resultpoint7, resultpoint6, resultpoint1, obj1
        });
    }

    private static final Integer INTEGERS[] = {
        new Integer(0), new Integer(1), new Integer(2), new Integer(3), new Integer(4)
    };
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

}
