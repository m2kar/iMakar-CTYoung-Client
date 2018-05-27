// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.decoding;

import android.os.*;
import android.util.Log;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.realtech_inc.andproject.chinanet.activity.MipcaActivityCapture;
import com.realtech_inc.andproject.chinanet.zxing.camera.CameraManager;
import com.realtech_inc.andproject.chinanet.zxing.camera.PlanarYUVLuminanceSource;
import java.util.Hashtable;

final class DecodeHandler extends Handler
{

    DecodeHandler(MipcaActivityCapture mipcaactivitycapture, Hashtable hashtable)
    {
        multiFormatReader.setHints(hashtable);
        activity = mipcaactivitycapture;
    }

    private void decode(byte abyte0[], int i, int j)
    {
        long l1;
        Bundle bundle;
        PlanarYUVLuminanceSource planaryuvluminancesource;
        l1 = System.currentTimeMillis();
        bundle = null;
        byte abyte1[] = new byte[abyte0.length];
        for(int k = 0; k < j; k++)
        {
            for(int l = 0; l < i; l++)
                abyte1[(l * j + j) - k - 1] = abyte0[k * i + l];

        }

        planaryuvluminancesource = CameraManager.get().buildLuminanceSource(abyte1, j, i);
        abyte0 = new BinaryBitmap(new HybridBinarizer(planaryuvluminancesource));
        abyte0 = multiFormatReader.decodeWithState(abyte0);
        multiFormatReader.reset();
_L1:
        if(abyte0 != null)
        {
            long l2 = System.currentTimeMillis();
            Log.d(TAG, (new StringBuilder()).append("Found barcode (").append(l2 - l1).append(" ms):\n").append(abyte0.toString()).toString());
            abyte0 = Message.obtain(activity.getHandler(), 0x7f08000a, abyte0);
            bundle = new Bundle();
            bundle.putParcelable("barcode_bitmap", planaryuvluminancesource.renderCroppedGreyscaleBitmap());
            abyte0.setData(bundle);
            abyte0.sendToTarget();
            return;
        } else
        {
            Message.obtain(activity.getHandler(), 0x7f080009).sendToTarget();
            return;
        }
        abyte0;
        multiFormatReader.reset();
        abyte0 = bundle;
          goto _L1
        abyte0;
        multiFormatReader.reset();
        throw abyte0;
    }

    public void handleMessage(Message message)
    {
        switch(message.what)
        {
        default:
            return;

        case 2131230728: 
            decode((byte[])(byte[])message.obj, message.arg1, message.arg2);
            return;

        case 2131230735: 
            Looper.myLooper().quit();
            break;
        }
    }

    private static final String TAG = com/realtech_inc/andproject/chinanet/zxing/decoding/DecodeHandler.getSimpleName();
    private final MipcaActivityCapture activity;
    private final MultiFormatReader multiFormatReader = new MultiFormatReader();

}
