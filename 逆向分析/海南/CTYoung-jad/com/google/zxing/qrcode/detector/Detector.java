// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.detector;

import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.qrcode.detector:
//            FinderPatternFinder, AlignmentPatternFinder, FinderPatternInfo, FinderPattern, 
//            AlignmentPattern

public class Detector
{

    public Detector(BitMatrix bitmatrix)
    {
        image = bitmatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        float f = sizeOfBlackWhiteBlackRunBothWays((int)resultpoint.getX(), (int)resultpoint.getY(), (int)resultpoint1.getX(), (int)resultpoint1.getY());
        float f1 = sizeOfBlackWhiteBlackRunBothWays((int)resultpoint1.getX(), (int)resultpoint1.getY(), (int)resultpoint.getX(), (int)resultpoint.getY());
        if(Float.isNaN(f))
            return f1 / 7F;
        if(Float.isNaN(f1))
            return f / 7F;
        else
            return (f + f1) / 14F;
    }

    protected static int computeDimension(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, float f)
        throws NotFoundException
    {
        int i = (round(ResultPoint.distance(resultpoint, resultpoint1) / f) + round(ResultPoint.distance(resultpoint, resultpoint2) / f) >> 1) + 7;
        switch(i & 3)
        {
        case 1: // '\001'
        default:
            return i;

        case 0: // '\0'
            return i + 1;

        case 2: // '\002'
            return i - 1;

        case 3: // '\003'
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static int round(float f)
    {
        return (int)(0.5F + f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitmatrix, PerspectiveTransform perspectivetransform, int i)
        throws NotFoundException
    {
        return GridSampler.getInstance().sampleGrid(bitmatrix, i, perspectivetransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte0;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        boolean flag;
        if(Math.abs(l - j) > Math.abs(k - i))
            flag = true;
        else
            flag = false;
        j1 = i;
        i1 = j;
        l1 = k;
        k1 = l;
        if(flag)
        {
            k1 = k;
            l1 = l;
            i1 = i;
            j1 = j;
        }
        i3 = Math.abs(l1 - j1);
        j3 = Math.abs(k1 - i1);
        l = -i3 >> 1;
        if(i1 < k1)
            byte0 = 1;
        else
            byte0 = -1;
        if(j1 < l1)
            i2 = 1;
        else
            i2 = -1;
        j2 = 0;
        i = j1;
        j = i1;
_L6:
        if(i == l1)
            break MISSING_BLOCK_LABEL_275;
        if(flag)
            k2 = j;
        else
            k2 = i;
        if(flag)
            l2 = i;
        else
            l2 = j;
        if(j2 != 1) goto _L2; else goto _L1
_L1:
        k = j2;
        if(image.get(k2, l2))
            k = j2 + 1;
_L4:
        if(k == 3)
        {
            k = i - j1;
            j -= i1;
            i = k;
            if(i2 < 0)
                i = k + 1;
            return (float)Math.sqrt(i * i + j * j);
        }
        break; /* Loop/switch isn't completed */
_L2:
        k = j2;
        if(!image.get(k2, l2))
            k = j2 + 1;
        if(true) goto _L4; else goto _L3
_L3:
        j2 = l + j3;
        l = j2;
        k2 = j;
        if(j2 <= 0)
            break MISSING_BLOCK_LABEL_313;
        if(j != k1)
            break MISSING_BLOCK_LABEL_300;
        i = l1 - j1;
        j = k1 - i1;
        return (float)Math.sqrt(i * i + j * j);
        k2 = j + byte0;
        l = j2 - i3;
        i += i2;
        j2 = k;
        j = k2;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i, int j, int k, int l)
    {
        float f1 = sizeOfBlackWhiteBlackRun(i, j, k, l);
        float f = 1.0F;
        int i1 = i - (k - i);
        if(i1 < 0)
        {
            f = (float)i / (float)(i - i1);
            k = 0;
        } else
        {
            k = i1;
            if(i1 > image.getWidth())
            {
                f = (float)(image.getWidth() - i) / (float)(i1 - i);
                k = image.getWidth();
            }
        }
        i1 = (int)((float)j - (float)(l - j) * f);
        f = 1.0F;
        if(i1 < 0)
        {
            f = (float)j / (float)(j - i1);
            l = 0;
        } else
        {
            l = i1;
            if(i1 > image.getHeight())
            {
                f = (float)(image.getHeight() - j) / (float)(i1 - j);
                l = image.getHeight();
            }
        }
        return f1 + sizeOfBlackWhiteBlackRun(i, j, (int)((float)i + (float)(k - i) * f), l);
    }

    protected float calculateModuleSize(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2)
    {
        return (calculateModuleSizeOneWay(resultpoint, resultpoint1) + calculateModuleSizeOneWay(resultpoint, resultpoint2)) / 2.0F;
    }

    public PerspectiveTransform createTransform(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i)
    {
        float f = (float)i - 3.5F;
        float f1;
        float f2;
        float f3;
        float f4;
        if(resultpoint3 != null)
        {
            f3 = resultpoint3.getX();
            f4 = resultpoint3.getY();
            f2 = f - 3F;
            f1 = f2;
        } else
        {
            f3 = (resultpoint1.getX() - resultpoint.getX()) + resultpoint2.getX();
            f4 = (resultpoint1.getY() - resultpoint.getY()) + resultpoint2.getY();
            f2 = f;
            f1 = f;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5F, 3.5F, f, 3.5F, f1, f2, 3.5F, f, resultpoint.getX(), resultpoint.getY(), resultpoint1.getX(), resultpoint1.getY(), f3, f4, resultpoint2.getX(), resultpoint2.getY());
    }

    public DetectorResult detect()
        throws NotFoundException, FormatException
    {
        return detect(null);
    }

    public DetectorResult detect(Hashtable hashtable)
        throws NotFoundException, FormatException
    {
        ResultPointCallback resultpointcallback;
        if(hashtable == null)
            resultpointcallback = null;
        else
            resultpointcallback = (ResultPointCallback)hashtable.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        resultPointCallback = resultpointcallback;
        return processFinderPatternInfo((new FinderPatternFinder(image, resultPointCallback)).find(hashtable));
    }

    protected AlignmentPattern findAlignmentInRegion(float f, int i, int j, float f1)
        throws NotFoundException
    {
        int l = (int)(f1 * f);
        int k = Math.max(0, i - l);
        i = Math.min(image.getWidth() - 1, i + l);
        if((float)(i - k) < f * 3F)
            throw NotFoundException.getNotFoundInstance();
        int i1 = Math.max(0, j - l);
        j = Math.min(image.getHeight() - 1, j + l);
        if((float)(j - i1) < f * 3F)
            throw NotFoundException.getNotFoundInstance();
        else
            return (new AlignmentPatternFinder(image, k, i1, i - k, j - i1, f, resultPointCallback)).find();
    }

    protected BitMatrix getImage()
    {
        return image;
    }

    protected ResultPointCallback getResultPointCallback()
    {
        return resultPointCallback;
    }

    protected DetectorResult processFinderPatternInfo(FinderPatternInfo finderpatterninfo)
        throws NotFoundException, FormatException
    {
        float f;
        int i;
        int j;
        Object obj;
        FinderPattern finderpattern;
        FinderPattern finderpattern1;
        FinderPattern finderpattern2;
        Version version;
        finderpattern = finderpatterninfo.getTopLeft();
        finderpattern1 = finderpatterninfo.getTopRight();
        finderpattern2 = finderpatterninfo.getBottomLeft();
        f = calculateModuleSize(finderpattern, finderpattern1, finderpattern2);
        if(f < 1.0F)
            throw NotFoundException.getNotFoundInstance();
        j = computeDimension(finderpattern, finderpattern1, finderpattern2, f);
        version = Version.getProvisionalVersionForDimension(j);
        i = version.getDimensionForVersion();
        obj = null;
        finderpatterninfo = obj;
        if(version.getAlignmentPatternCenters().length <= 0) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        float f1 = finderpattern1.getX();
        float f3 = finderpattern.getX();
        float f4 = finderpattern2.getX();
        float f5 = finderpattern1.getY();
        float f6 = finderpattern.getY();
        float f7 = finderpattern2.getY();
        float f8 = 1.0F - 3F / (float)(i - 7);
        k = (int)(finderpattern.getX() + (((f1 - f3) + f4) - finderpattern.getX()) * f8);
        l = (int)(finderpattern.getY() + (((f5 - f6) + f7) - finderpattern.getY()) * f8);
        i = 4;
_L5:
        finderpatterninfo = obj;
        if(i > 16) goto _L2; else goto _L3
_L3:
        float f2 = i;
        finderpatterninfo = findAlignmentInRegion(f, k, l, f2);
_L2:
        PerspectiveTransform perspectivetransform = createTransform(finderpattern, finderpattern1, finderpattern2, finderpatterninfo, j);
        BitMatrix bitmatrix = sampleGrid(image, perspectivetransform, j);
        if(finderpatterninfo == null)
        {
            finderpatterninfo = new ResultPoint[3];
            finderpatterninfo[0] = finderpattern2;
            finderpatterninfo[1] = finderpattern;
            finderpatterninfo[2] = finderpattern1;
        } else
        {
            ResultPoint aresultpoint[] = new ResultPoint[4];
            aresultpoint[0] = finderpattern2;
            aresultpoint[1] = finderpattern;
            aresultpoint[2] = finderpattern1;
            aresultpoint[3] = finderpatterninfo;
            finderpatterninfo = aresultpoint;
        }
        return new DetectorResult(bitmatrix, finderpatterninfo);
        finderpatterninfo;
        i <<= 1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;
}
