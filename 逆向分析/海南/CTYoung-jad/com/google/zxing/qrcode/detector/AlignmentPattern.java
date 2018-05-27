// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern extends ResultPoint
{

    AlignmentPattern(float f, float f1, float f2)
    {
        super(f, f1);
        estimatedModuleSize = f2;
    }

    boolean aboutEquals(float f, float f1, float f2)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if(Math.abs(f1 - getY()) > f)
                break label0;
            flag = flag1;
            if(Math.abs(f2 - getX()) > f)
                break label0;
            f = Math.abs(f - estimatedModuleSize);
            if(f > 1.0F)
            {
                flag = flag1;
                if(f / estimatedModuleSize > 1.0F)
                    break label0;
            }
            flag = true;
        }
        return flag;
    }

    private final float estimatedModuleSize;
}
