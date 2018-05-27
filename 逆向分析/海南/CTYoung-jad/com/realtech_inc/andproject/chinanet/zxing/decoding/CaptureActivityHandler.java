// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import com.google.zxing.Result;
import com.realtech_inc.andproject.chinanet.activity.MipcaActivityCapture;
import com.realtech_inc.andproject.chinanet.zxing.camera.CameraManager;
import com.realtech_inc.andproject.chinanet.zxing.view.ViewfinderResultPointCallback;
import java.util.Vector;

// Referenced classes of package com.realtech_inc.andproject.chinanet.zxing.decoding:
//            DecodeThread

public final class CaptureActivityHandler extends Handler
{
    private static final class State extends Enum
    {

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/realtech_inc/andproject/chinanet/zxing/decoding/CaptureActivityHandler$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State DONE;
        public static final State PREVIEW;
        public static final State SUCCESS;

        static 
        {
            PREVIEW = new State("PREVIEW", 0);
            SUCCESS = new State("SUCCESS", 1);
            DONE = new State("DONE", 2);
            $VALUES = (new State[] {
                PREVIEW, SUCCESS, DONE
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    public CaptureActivityHandler(MipcaActivityCapture mipcaactivitycapture, Vector vector, String s)
    {
        activity = mipcaactivitycapture;
        decodeThread = new DecodeThread(mipcaactivitycapture, vector, s, new ViewfinderResultPointCallback(mipcaactivitycapture.getViewfinderView()));
        decodeThread.start();
        state = State.SUCCESS;
        CameraManager.get().startPreview();
        restartPreviewAndDecode();
    }

    private void restartPreviewAndDecode()
    {
        if(state == State.SUCCESS)
        {
            state = State.PREVIEW;
            CameraManager.get().requestPreviewFrame(decodeThread.getHandler(), 0x7f080008);
            CameraManager.get().requestAutoFocus(this, 0x7f080007);
            activity.drawViewfinder();
        }
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 2131230727 2131230737: default 64
    //                   2131230727 65
    //                   2131230728 64
    //                   2131230729 155
    //                   2131230730 99
    //                   2131230731 64
    //                   2131230732 64
    //                   2131230733 64
    //                   2131230734 210
    //                   2131230735 64
    //                   2131230736 85
    //                   2131230737 178;
           goto _L1 _L2 _L1 _L3 _L4 _L1 _L1 _L1 _L5 _L1 _L6 _L7
_L1:
        return;
_L2:
        if(state == State.PREVIEW)
        {
            CameraManager.get().requestAutoFocus(this, 0x7f080007);
            return;
        }
          goto _L1
_L6:
        Log.d(TAG, "Got restart preview message");
        restartPreviewAndDecode();
        return;
_L4:
        Log.d(TAG, "Got decode succeeded message");
        state = State.SUCCESS;
        Object obj = message.getData();
        if(obj == null)
            obj = null;
        else
            obj = (Bitmap)((Bundle) (obj)).getParcelable("barcode_bitmap");
        activity.handleDecode((Result)message.obj, ((Bitmap) (obj)));
        return;
_L3:
        state = State.PREVIEW;
        CameraManager.get().requestPreviewFrame(decodeThread.getHandler(), 0x7f080008);
        return;
_L7:
        Log.d(TAG, "Got return scan result message");
        activity.setResult(-1, (Intent)message.obj);
        activity.finish();
        return;
_L5:
        Log.d(TAG, "Got product query message");
        message = new Intent("android.intent.action.VIEW", Uri.parse((String)message.obj));
        message.addFlags(0x80000);
        activity.startActivity(message);
        return;
    }

    public void quitSynchronously()
    {
        state = State.DONE;
        CameraManager.get().stopPreview();
        Message.obtain(decodeThread.getHandler(), 0x7f08000f).sendToTarget();
        try
        {
            decodeThread.join();
        }
        catch(InterruptedException interruptedexception) { }
        removeMessages(0x7f08000a);
        removeMessages(0x7f080009);
    }

    private static final String TAG = com/realtech_inc/andproject/chinanet/zxing/decoding/CaptureActivityHandler.getSimpleName();
    private final MipcaActivityCapture activity;
    private final DecodeThread decodeThread;
    private State state;

}
