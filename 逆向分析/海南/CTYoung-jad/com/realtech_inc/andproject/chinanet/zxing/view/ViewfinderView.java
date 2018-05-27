// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.realtech_inc.andproject.chinanet.zxing.camera.CameraManager;
import java.util.*;

public final class ViewfinderView extends View
{

    public ViewfinderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        density = context.getResources().getDisplayMetrics().density;
        ScreenRate = (int)(20F * density);
        paint = new Paint();
        context = getResources();
        maskColor = context.getColor(0x7f060020);
        resultColor = context.getColor(0x7f060015);
        resultPointColor = context.getColor(0x7f060014);
        possibleResultPoints = new HashSet(5);
    }

    public void addPossibleResultPoint(ResultPoint resultpoint)
    {
        possibleResultPoints.add(resultpoint);
    }

    public void drawResultBitmap(Bitmap bitmap)
    {
        resultBitmap = bitmap;
        invalidate();
    }

    public void drawViewfinder()
    {
        resultBitmap = null;
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        Rect rect = CameraManager.get().getFramingRect();
        if(rect == null)
            return;
        if(!isFirst)
        {
            isFirst = true;
            slideTop = rect.top;
            slideBottom = rect.bottom;
        }
        int j = canvas.getWidth();
        int k = canvas.getHeight();
        Object obj = paint;
        int i;
        if(resultBitmap != null)
            i = resultColor;
        else
            i = maskColor;
        ((Paint) (obj)).setColor(i);
        canvas.drawRect(0.0F, 0.0F, j, rect.top, paint);
        canvas.drawRect(0.0F, rect.top, rect.left, rect.bottom + 1, paint);
        canvas.drawRect(rect.right + 1, rect.top, j, rect.bottom + 1, paint);
        canvas.drawRect(0.0F, rect.bottom + 1, j, k, paint);
        if(resultBitmap != null)
        {
            paint.setAlpha(255);
            canvas.drawBitmap(resultBitmap, rect.left, rect.top, paint);
            return;
        }
        paint.setColor(0xff00ff00);
        canvas.drawRect(rect.left, rect.top, rect.left + ScreenRate, rect.top + 10, paint);
        canvas.drawRect(rect.left, rect.top, rect.left + 10, rect.top + ScreenRate, paint);
        canvas.drawRect(rect.right - ScreenRate, rect.top, rect.right, rect.top + 10, paint);
        canvas.drawRect(rect.right - 10, rect.top, rect.right, rect.top + ScreenRate, paint);
        canvas.drawRect(rect.left, rect.bottom - 10, rect.left + ScreenRate, rect.bottom, paint);
        canvas.drawRect(rect.left, rect.bottom - ScreenRate, rect.left + 10, rect.bottom, paint);
        canvas.drawRect(rect.right - ScreenRate, rect.bottom - 10, rect.right, rect.bottom, paint);
        canvas.drawRect(rect.right - 10, rect.bottom - ScreenRate, rect.right, rect.bottom, paint);
        slideTop = slideTop + 5;
        if(slideTop >= rect.bottom)
            slideTop = rect.top;
        canvas.drawRect(rect.left + 5, slideTop - 3, rect.right - 5, slideTop + 3, paint);
        paint.setColor(-1);
        paint.setTextSize(16F * density);
        paint.setAlpha(64);
        paint.setTypeface(Typeface.create("System", 1));
        canvas.drawText(getResources().getString(0x7f0a0026), rect.left, (float)rect.bottom + 30F * density, paint);
        Object obj1 = possibleResultPoints;
        obj = lastPossibleResultPoints;
        if(((Collection) (obj1)).isEmpty())
        {
            lastPossibleResultPoints = null;
        } else
        {
            possibleResultPoints = new HashSet(5);
            lastPossibleResultPoints = ((Collection) (obj1));
            paint.setAlpha(255);
            paint.setColor(resultPointColor);
            obj1 = ((Collection) (obj1)).iterator();
            while(((Iterator) (obj1)).hasNext()) 
            {
                ResultPoint resultpoint = (ResultPoint)((Iterator) (obj1)).next();
                canvas.drawCircle((float)rect.left + resultpoint.getX(), (float)rect.top + resultpoint.getY(), 6F, paint);
            }
        }
        if(obj != null)
        {
            paint.setAlpha(127);
            paint.setColor(resultPointColor);
            for(obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); canvas.drawCircle((float)rect.left + ((ResultPoint) (obj1)).getX(), (float)rect.top + ((ResultPoint) (obj1)).getY(), 3F, paint))
                obj1 = (ResultPoint)((Iterator) (obj)).next();

        }
        postInvalidateDelayed(10L, rect.left, rect.top, rect.right, rect.bottom);
    }

    private static final long ANIMATION_DELAY = 10L;
    private static final int CORNER_WIDTH = 10;
    private static final int MIDDLE_LINE_PADDING = 5;
    private static final int MIDDLE_LINE_WIDTH = 6;
    private static final int OPAQUE = 255;
    private static final int SPEEN_DISTANCE = 5;
    private static final String TAG = "log";
    private static final int TEXT_PADDING_TOP = 30;
    private static final int TEXT_SIZE = 16;
    private static float density;
    private int ScreenRate;
    boolean isFirst;
    private Collection lastPossibleResultPoints;
    private final int maskColor;
    private Paint paint;
    private Collection possibleResultPoints;
    private Bitmap resultBitmap;
    private final int resultColor;
    private final int resultPointColor;
    private int slideBottom;
    private int slideTop;
}
