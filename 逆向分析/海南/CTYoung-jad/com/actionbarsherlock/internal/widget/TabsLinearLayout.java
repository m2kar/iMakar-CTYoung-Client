// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.actionbarsherlock.internal.widget:
//            IcsLinearLayout

public class TabsLinearLayout extends IcsLinearLayout
{

    public TabsLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, R_styleable_LinearLayout);
        mUseLargestChild = context.getBoolean(0, false);
        context.recycle();
    }

    private void useLargestChildHorizontal()
    {
        int j1 = getChildCount();
        int i = 0;
        for(int j = 0; j < j1; j++)
            i = Math.max(getChildAt(j).getMeasuredWidth(), i);

        int l = 0;
        int k = 0;
        while(k < j1) 
        {
            View view = getChildAt(k);
            int i1 = l;
            if(view != null)
                if(view.getVisibility() == 8)
                {
                    i1 = l;
                } else
                {
                    android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                    if(layoutparams.weight > 0.0F)
                    {
                        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0x40000000));
                        l += i;
                    } else
                    {
                        l += view.getMeasuredWidth();
                    }
                    i1 = l + (layoutparams.leftMargin + layoutparams.rightMargin);
                }
            k++;
            l = i1;
        }
        setMeasuredDimension(l + (getPaddingLeft() + getPaddingRight()), getMeasuredHeight());
    }

    public boolean isMeasureWithLargestChildEnabled()
    {
        return mUseLargestChild;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if(getChildCount() > 2)
        {
            i = android.view.View.MeasureSpec.getMode(i);
            if(mUseLargestChild && i == 0 && getOrientation() == 0)
            {
                useLargestChildHorizontal();
                return;
            }
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean flag)
    {
        mUseLargestChild = flag;
    }

    private static final int LinearLayout_measureWithLargestChild = 0;
    private static final int R_styleable_LinearLayout[] = {
        0x10102d4
    };
    private boolean mUseLargestChild;

}
