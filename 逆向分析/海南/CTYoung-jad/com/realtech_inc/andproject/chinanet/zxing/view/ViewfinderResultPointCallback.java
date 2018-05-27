// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

// Referenced classes of package com.realtech_inc.andproject.chinanet.zxing.view:
//            ViewfinderView

public final class ViewfinderResultPointCallback
    implements ResultPointCallback
{

    public ViewfinderResultPointCallback(ViewfinderView viewfinderview)
    {
        viewfinderView = viewfinderview;
    }

    public void foundPossibleResultPoint(ResultPoint resultpoint)
    {
        viewfinderView.addPossibleResultPoint(resultpoint);
    }

    private final ViewfinderView viewfinderView;
}
