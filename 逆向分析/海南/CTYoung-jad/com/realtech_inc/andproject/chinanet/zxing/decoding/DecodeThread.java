// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.decoding;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.realtech_inc.andproject.chinanet.activity.MipcaActivityCapture;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.realtech_inc.andproject.chinanet.zxing.decoding:
//            DecodeFormatManager, DecodeHandler

final class DecodeThread extends Thread
{

    DecodeThread(MipcaActivityCapture mipcaactivitycapture, Vector vector, String s, ResultPointCallback resultpointcallback)
    {
label0:
        {
            super();
            activity = mipcaactivitycapture;
            handlerInitLatch = new CountDownLatch(1);
            hints = new Hashtable(3);
            if(vector != null)
            {
                mipcaactivitycapture = vector;
                if(!vector.isEmpty())
                    break label0;
            }
            mipcaactivitycapture = new Vector();
            mipcaactivitycapture.addAll(DecodeFormatManager.ONE_D_FORMATS);
            mipcaactivitycapture.addAll(DecodeFormatManager.QR_CODE_FORMATS);
            mipcaactivitycapture.addAll(DecodeFormatManager.DATA_MATRIX_FORMATS);
        }
        hints.put(DecodeHintType.POSSIBLE_FORMATS, mipcaactivitycapture);
        if(s != null)
            hints.put(DecodeHintType.CHARACTER_SET, s);
        hints.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultpointcallback);
    }

    Handler getHandler()
    {
        try
        {
            handlerInitLatch.await();
        }
        catch(InterruptedException interruptedexception) { }
        return handler;
    }

    public void run()
    {
        Looper.prepare();
        handler = new DecodeHandler(activity, hints);
        handlerInitLatch.countDown();
        Looper.loop();
    }

    public static final String BARCODE_BITMAP = "barcode_bitmap";
    private final MipcaActivityCapture activity;
    private Handler handler;
    private final CountDownLatch handlerInitLatch;
    private final Hashtable hints;
}
