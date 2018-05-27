// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.speech.tts;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

class TextToSpeechICS
{

    TextToSpeechICS()
    {
    }

    static TextToSpeech construct(Context context, android.speech.tts.TextToSpeech.OnInitListener oninitlistener, String s)
    {
        if(android.os.Build.VERSION.SDK_INT < 14)
        {
            if(s == null)
            {
                return new TextToSpeech(context, oninitlistener);
            } else
            {
                Log.w("android.support.v4.speech.tts", "Can't specify tts engine on this device");
                return new TextToSpeech(context, oninitlistener);
            }
        } else
        {
            return new TextToSpeech(context, oninitlistener, s);
        }
    }

    private static final String TAG = "android.support.v4.speech.tts";
}
