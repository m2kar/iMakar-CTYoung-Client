// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;

// Referenced classes of package com.realtech_inc.andproject.chinanet.zxing.camera:
//            CameraConfigurationManager, PreviewCallback, AutoFocusCallback, PlanarYUVLuminanceSource, 
//            FlashlightManager

public final class CameraManager
{

    private CameraManager(Context context1)
    {
        context = context1;
        configManager = new CameraConfigurationManager(context1);
        boolean flag;
        if(Integer.parseInt(android.os.Build.VERSION.SDK) > 3)
            flag = true;
        else
            flag = false;
        useOneShotPreviewCallback = flag;
        previewCallback = new PreviewCallback(configManager, useOneShotPreviewCallback);
    }

    public static CameraManager get()
    {
        return cameraManager;
    }

    public static void init(Context context1)
    {
        if(cameraManager == null)
            cameraManager = new CameraManager(context1);
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte abyte0[], int i, int j)
    {
        Rect rect = getFramingRectInPreview();
        int k = configManager.getPreviewFormat();
        String s = configManager.getPreviewFormatString();
        switch(k)
        {
        default:
            if("yuv420p".equals(s))
                return new PlanarYUVLuminanceSource(abyte0, i, j, rect.left, rect.top, rect.width(), rect.height());
            else
                throw new IllegalArgumentException((new StringBuilder()).append("Unsupported picture format: ").append(k).append('/').append(s).toString());

        case 16: // '\020'
        case 17: // '\021'
            return new PlanarYUVLuminanceSource(abyte0, i, j, rect.left, rect.top, rect.width(), rect.height());
        }
    }

    public void closeDriver()
    {
        if(camera != null)
        {
            FlashlightManager.disableFlashlight();
            camera.release();
            camera = null;
        }
    }

    public Context getContext()
    {
        return context;
    }

    public Rect getFramingRect()
    {
        Point point = configManager.getScreenResolution();
        if(framingRect == null)
        {
            if(camera == null)
                return null;
            int j = (point.x * 3) / 4;
            int i;
            int k;
            int l;
            if(j < 480)
            {
                i = 480;
            } else
            {
                i = j;
                if(j > 960)
                    i = 960;
            }
            k = (point.y * 3) / 4;
            if(k < 480)
            {
                j = 480;
            } else
            {
                j = k;
                if(k > 720)
                    j = 720;
            }
            k = (point.x - i) / 2;
            l = (point.y - j) / 2;
            framingRect = new Rect(k, l, k + i, l + j);
            Log.d(TAG, (new StringBuilder()).append("Calculated framing rect: ").append(framingRect).toString());
        }
        return framingRect;
    }

    public Rect getFramingRectInPreview()
    {
        if(framingRectInPreview == null)
        {
            Rect rect = new Rect(getFramingRect());
            Point point = configManager.getCameraResolution();
            Point point1 = configManager.getScreenResolution();
            rect.left = (rect.left * point.y) / point1.x;
            rect.right = (rect.right * point.y) / point1.x;
            rect.top = (rect.top * point.x) / point1.y;
            rect.bottom = (rect.bottom * point.x) / point1.y;
            framingRectInPreview = rect;
        }
        return framingRectInPreview;
    }

    public void openDriver(SurfaceHolder surfaceholder)
        throws IOException
    {
        if(camera == null)
        {
            camera = Camera.open();
            if(camera == null)
                throw new IOException();
            camera.setPreviewDisplay(surfaceholder);
            if(!initialized)
            {
                initialized = true;
                configManager.initFromCameraParameters(camera);
            }
            configManager.setDesiredCameraParameters(camera);
            FlashlightManager.enableFlashlight();
        }
    }

    public void requestAutoFocus(Handler handler, int i)
    {
        if(camera != null && previewing)
        {
            autoFocusCallback.setHandler(handler, i);
            camera.autoFocus(autoFocusCallback);
        }
    }

    public void requestPreviewFrame(Handler handler, int i)
    {
label0:
        {
            if(camera != null && previewing)
            {
                previewCallback.setHandler(handler, i);
                if(!useOneShotPreviewCallback)
                    break label0;
                camera.setOneShotPreviewCallback(previewCallback);
            }
            return;
        }
        camera.setPreviewCallback(previewCallback);
    }

    public void startPreview()
    {
        if(camera != null && !previewing)
        {
            camera.startPreview();
            previewing = true;
        }
    }

    public void stopPreview()
    {
        if(camera != null && previewing)
        {
            if(!useOneShotPreviewCallback)
                camera.setPreviewCallback(null);
            camera.stopPreview();
            previewCallback.setHandler(null, 0);
            autoFocusCallback.setHandler(null, 0);
            previewing = false;
        }
    }

    private static final int MAX_FRAME_HEIGHT = 720;
    private static final int MAX_FRAME_WIDTH = 960;
    private static final int MIN_FRAME_HEIGHT = 480;
    private static final int MIN_FRAME_WIDTH = 480;
    static final int SDK_INT;
    private static final String TAG = com/realtech_inc/andproject/chinanet/zxing/camera/CameraManager.getSimpleName();
    private static CameraManager cameraManager;
    private final AutoFocusCallback autoFocusCallback = new AutoFocusCallback();
    private Camera camera;
    private final CameraConfigurationManager configManager;
    private final Context context;
    private Rect framingRect;
    private Rect framingRectInPreview;
    private boolean initialized;
    private final PreviewCallback previewCallback;
    private boolean previewing;
    private final boolean useOneShotPreviewCallback;

    static 
    {
        int i;
        try
        {
            i = Integer.parseInt(android.os.Build.VERSION.SDK);
        }
        catch(NumberFormatException numberformatexception)
        {
            i = 10000;
        }
        SDK_INT = i;
    }
}
