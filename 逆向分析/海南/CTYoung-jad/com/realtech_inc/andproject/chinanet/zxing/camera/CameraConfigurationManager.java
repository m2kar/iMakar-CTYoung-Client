// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

// Referenced classes of package com.realtech_inc.andproject.chinanet.zxing.camera:
//            CameraManager

final class CameraConfigurationManager
{

    CameraConfigurationManager(Context context1)
    {
        context = context1;
    }

    private static int findBestMotZoomValue(CharSequence charsequence, int i)
    {
        int k = 0;
        charsequence = COMMA_PATTERN.split(charsequence);
        int j1 = charsequence.length;
        int j = 0;
        while(j < j1) 
        {
            String s = charsequence[j].trim();
            double d;
            int l;
            int i1;
            try
            {
                d = Double.parseDouble(s);
            }
            // Misplaced declaration of an exception variable
            catch(CharSequence charsequence)
            {
                return i;
            }
            i1 = (int)(10D * d);
            l = k;
            if(Math.abs((double)i - d) < (double)Math.abs(i - k))
                l = i1;
            j++;
            k = l;
        }
        return k;
    }

    private static Point findBestPreviewSizeValue(CharSequence charsequence, Point point)
    {
        int i;
        int j;
        int k;
        int l;
        int i2;
        j = 0;
        i = 0;
        l = 0x7fffffff;
        charsequence = COMMA_PATTERN.split(charsequence);
        i2 = charsequence.length;
        k = 0;
_L5:
        int i1;
        int j1;
        j1 = j;
        i1 = i;
        if(k >= i2) goto _L2; else goto _L1
_L1:
        String s;
        s = charsequence[k].trim();
        i1 = s.indexOf('x');
        if(i1 >= 0) goto _L4; else goto _L3
_L3:
        Log.w(TAG, (new StringBuilder()).append("Bad preview-size: ").append(s).toString());
        j1 = l;
_L6:
        k++;
        l = j1;
          goto _L5
_L4:
        int k1;
        k1 = Integer.parseInt(s.substring(0, i1));
        i1 = Integer.parseInt(s.substring(i1 + 1));
        int l1;
        l1 = Math.abs(k1 - point.x) + Math.abs(i1 - point.y);
        if(l1 != 0)
            break MISSING_BLOCK_LABEL_220;
        j1 = k1;
_L2:
        NumberFormatException numberformatexception;
        if(j1 > 0 && i1 > 0)
            return new Point(j1, i1);
        else
            return null;
        numberformatexception;
        Log.w(TAG, (new StringBuilder()).append("Bad preview-size: ").append(s).toString());
        j1 = l;
          goto _L6
        j1 = l;
        if(l1 < l)
        {
            j = k1;
            i = i1;
            j1 = l1;
        }
          goto _L6
    }

    private static Point getCameraResolution(android.hardware.Camera.Parameters parameters, Point point)
    {
        String s = parameters.get("preview-size-values");
        Object obj = s;
        if(s == null)
            obj = parameters.get("preview-size-value");
        parameters = null;
        if(obj != null)
        {
            Log.d(TAG, (new StringBuilder()).append("preview-size-values parameter: ").append(((String) (obj))).toString());
            parameters = findBestPreviewSizeValue(((CharSequence) (obj)), point);
        }
        obj = parameters;
        if(parameters == null)
            obj = new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        return ((Point) (obj));
    }

    public static int getDesiredSharpness()
    {
        return 30;
    }

    private void setFlash(android.hardware.Camera.Parameters parameters)
    {
        if(Build.MODEL.contains("Behold II") && CameraManager.SDK_INT == 3)
            parameters.set("flash-value", 1);
        else
            parameters.set("flash-value", 2);
        parameters.set("flash-mode", "off");
    }

    private void setZoom(android.hardware.Camera.Parameters parameters)
    {
        String s = parameters.get("zoom-supported");
        if(s == null || Boolean.parseBoolean(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        j = 27;
        s = parameters.get("max-zoom");
        i = j;
        if(s == null)
            break MISSING_BLOCK_LABEL_72;
        double d = Double.parseDouble(s);
        int k = (int)(10D * d);
        i = j;
        if(27 > k)
            i = k;
_L3:
        Object obj;
        obj = parameters.get("taking-picture-zoom-max");
        j = i;
        if(obj == null)
            break MISSING_BLOCK_LABEL_111;
        int l = Integer.parseInt(((String) (obj)));
        j = i;
        if(i > l)
            j = l;
_L4:
        String s1;
        String s2;
        s1 = parameters.get("mot-zoom-values");
        i = j;
        if(s1 != null)
            i = findBestMotZoomValue(s1, j);
        s2 = parameters.get("mot-zoom-step");
        j = i;
        if(s2 == null)
            break MISSING_BLOCK_LABEL_189;
        l = (int)(10D * Double.parseDouble(s2.trim()));
        j = i;
        if(l > 1)
            j = i - i % l;
_L5:
        if(s != null || s1 != null)
            parameters.set("zoom", String.valueOf((double)j / 10D));
        if(obj != null)
        {
            parameters.set("taking-picture-zoom", j);
            return;
        }
          goto _L1
        obj;
        Log.w(TAG, (new StringBuilder()).append("Bad max-zoom: ").append(s).toString());
        i = j;
          goto _L3
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.w(TAG, (new StringBuilder()).append("Bad taking-picture-zoom-max: ").append(((String) (obj))).toString());
        j = i;
          goto _L4
        NumberFormatException numberformatexception1;
        numberformatexception1;
        j = i;
          goto _L5
    }

    Point getCameraResolution()
    {
        return cameraResolution;
    }

    int getPreviewFormat()
    {
        return previewFormat;
    }

    String getPreviewFormatString()
    {
        return previewFormatString;
    }

    Point getScreenResolution()
    {
        return screenResolution;
    }

    void initFromCameraParameters(Camera camera)
    {
        camera = camera.getParameters();
        previewFormat = camera.getPreviewFormat();
        previewFormatString = camera.get("preview-format");
        Log.d(TAG, (new StringBuilder()).append("Default preview format: ").append(previewFormat).append('/').append(previewFormatString).toString());
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        screenResolution = new Point(display.getWidth(), display.getHeight());
        Log.d(TAG, (new StringBuilder()).append("Screen resolution: ").append(screenResolution).toString());
        cameraResolution = getCameraResolution(camera, screenResolution);
        Log.d(TAG, (new StringBuilder()).append("Camera resolution: ").append(screenResolution).toString());
    }

    void setDesiredCameraParameters(Camera camera)
    {
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        Log.d(TAG, (new StringBuilder()).append("Setting preview size: ").append(cameraResolution).toString());
        parameters.setPreviewSize(cameraResolution.x, cameraResolution.y);
        setFlash(parameters);
        setZoom(parameters);
        setDisplayOrientation(camera, 90);
        camera.setParameters(parameters);
    }

    protected void setDisplayOrientation(Camera camera, int i)
    {
        Method method;
        try
        {
            method = camera.getClass().getMethod("setDisplayOrientation", new Class[] {
                Integer.TYPE
            });
        }
        // Misplaced declaration of an exception variable
        catch(Camera camera)
        {
            return;
        }
        if(method == null)
            break MISSING_BLOCK_LABEL_42;
        method.invoke(camera, new Object[] {
            Integer.valueOf(i)
        });
    }

    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    private static final int DESIRED_SHARPNESS = 30;
    private static final String TAG = com/realtech_inc/andproject/chinanet/zxing/camera/CameraConfigurationManager.getSimpleName();
    private static final int TEN_DESIRED_ZOOM = 27;
    private Point cameraResolution;
    private final Context context;
    private int previewFormat;
    private String previewFormatString;
    private Point screenResolution;

}
