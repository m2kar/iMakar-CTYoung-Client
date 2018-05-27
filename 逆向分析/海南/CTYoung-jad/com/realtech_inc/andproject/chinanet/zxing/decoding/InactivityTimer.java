// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.decoding;

import android.app.Activity;
import java.util.concurrent.*;

// Referenced classes of package com.realtech_inc.andproject.chinanet.zxing.decoding:
//            FinishListener

public final class InactivityTimer
{
    private static final class DaemonThreadFactory
        implements ThreadFactory
    {

        public Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable);
            runnable.setDaemon(true);
            return runnable;
        }

        private DaemonThreadFactory()
        {
        }

    }


    public InactivityTimer(Activity activity1)
    {
        inactivityFuture = null;
        activity = activity1;
        onActivity();
    }

    private void cancel()
    {
        if(inactivityFuture != null)
        {
            inactivityFuture.cancel(true);
            inactivityFuture = null;
        }
    }

    public void onActivity()
    {
        cancel();
        inactivityFuture = inactivityTimer.schedule(new FinishListener(activity), 300L, TimeUnit.SECONDS);
    }

    public void shutdown()
    {
        cancel();
        inactivityTimer.shutdown();
    }

    private static final int INACTIVITY_DELAY_SECONDS = 300;
    private final Activity activity;
    private ScheduledFuture inactivityFuture;
    private final ScheduledExecutorService inactivityTimer = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory());
}
