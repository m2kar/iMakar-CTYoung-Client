// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.*;
import android.view.*;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.Result;
import com.realtech_inc.andproject.chinanet.zxing.camera.CameraManager;
import com.realtech_inc.andproject.chinanet.zxing.decoding.CaptureActivityHandler;
import com.realtech_inc.andproject.chinanet.zxing.decoding.InactivityTimer;
import com.realtech_inc.andproject.chinanet.zxing.view.ViewfinderView;
import java.io.IOException;
import java.util.Vector;

public class MipcaActivityCapture extends Activity
    implements android.view.SurfaceHolder.Callback
{

    public MipcaActivityCapture()
    {
    }

    private void initBeepSound()
    {
        AssetFileDescriptor assetfiledescriptor;
        if(!playBeep || mediaPlayer != null)
            break MISSING_BLOCK_LABEL_100;
        setVolumeControlStream(3);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(beepListener);
        assetfiledescriptor = getResources().openRawResourceFd(0x7f040000);
        mediaPlayer.setDataSource(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getLength());
        assetfiledescriptor.close();
        mediaPlayer.setVolume(0.1F, 0.1F);
        mediaPlayer.prepare();
        return;
        IOException ioexception;
        ioexception;
        mediaPlayer = null;
        return;
    }

    private void initCamera(SurfaceHolder surfaceholder)
    {
        try
        {
            CameraManager.get().openDriver(surfaceholder);
        }
        // Misplaced declaration of an exception variable
        catch(SurfaceHolder surfaceholder)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch(SurfaceHolder surfaceholder)
        {
            return;
        }
        if(handler == null)
            handler = new CaptureActivityHandler(this, decodeFormats, characterSet);
    }

    private void playBeepSoundAndVibrate()
    {
        if(playBeep && mediaPlayer != null)
            mediaPlayer.start();
        if(vibrate)
            ((Vibrator)getSystemService("vibrator")).vibrate(200L);
    }

    public void drawViewfinder()
    {
        viewfinderView.drawViewfinder();
    }

    public Handler getHandler()
    {
        return handler;
    }

    public ViewfinderView getViewfinderView()
    {
        return viewfinderView;
    }

    public void handleDecode(Result result, Bitmap bitmap)
    {
        inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        result = result.getText();
        if(result.equals(""))
        {
            Toast.makeText(this, "\u626B\u63CF\u5931\u8D25!", 0).show();
        } else
        {
            bitmap = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("result", result);
            bitmap.putExtras(bundle);
            setResult(-1, bitmap);
        }
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030018);
        CameraManager.init(getApplication());
        viewfinderView = (ViewfinderView)findViewById(0x7f08004c);
        ((ImageView)findViewById(0x7f080068)).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                finish();
            }

            final MipcaActivityCapture this$0;

            
            {
                this$0 = MipcaActivityCapture.this;
                super();
            }
        }
);
        hasSurface = false;
        inactivityTimer = new InactivityTimer(this);
    }

    protected void onDestroy()
    {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        if(handler != null)
        {
            handler.quitSynchronously();
            handler = null;
        }
        CameraManager.get().closeDriver();
    }

    protected void onResume()
    {
        super.onResume();
        SurfaceHolder surfaceholder = ((SurfaceView)findViewById(0x7f08004b)).getHolder();
        if(hasSurface)
        {
            initCamera(surfaceholder);
        } else
        {
            surfaceholder.addCallback(this);
            surfaceholder.setType(3);
        }
        decodeFormats = null;
        characterSet = null;
        playBeep = true;
        if(((AudioManager)getSystemService("audio")).getRingerMode() != 2)
            playBeep = false;
        initBeepSound();
        vibrate = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if(!hasSurface)
        {
            hasSurface = true;
            initCamera(surfaceholder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        hasSurface = false;
    }

    private static final float BEEP_VOLUME = 0.1F;
    private static final long VIBRATE_DURATION = 200L;
    private final android.media.MediaPlayer.OnCompletionListener beepListener = new android.media.MediaPlayer.OnCompletionListener() {

        public void onCompletion(MediaPlayer mediaplayer)
        {
            mediaplayer.seekTo(0);
        }

        final MipcaActivityCapture this$0;

            
            {
                this$0 = MipcaActivityCapture.this;
                super();
            }
    }
;
    private String characterSet;
    private Vector decodeFormats;
    private CaptureActivityHandler handler;
    private boolean hasSurface;
    private InactivityTimer inactivityTimer;
    private MediaPlayer mediaPlayer;
    private boolean playBeep;
    private boolean vibrate;
    private ViewfinderView viewfinderView;
}
