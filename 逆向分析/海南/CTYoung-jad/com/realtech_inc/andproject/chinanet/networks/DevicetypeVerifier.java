// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.networks;

import com.realtech_inc.andproject.chinanet.constant.Constant;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import com.realtech_inc.android.util.PullParseService;
import com.realtech_inc.android.util.XmlParserResult;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.realtech_inc.andproject.chinanet.networks:
//            BaseNetworkAsyncTask

public class DevicetypeVerifier
{
    private class verifyModelTask extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            as = new ArrayList();
            as.add(new BasicNameValuePair("deviceTAC", DevicetypeVerifier.SPM.getData("DeviceTAC", "")));
            DebugLog.d(DevicetypeVerifier.TAG, (new StringBuilder()).append("Start HTTP POST Request With URL: '").append(url).append("' And Params: ").append(as.toString()).toString());
            return doHttpPost(url, as);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            DebugLog.d(DevicetypeVerifier.TAG, (new StringBuilder()).append("verifyModelTask: ").append(s).toString());
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        protected void onPreExecute()
        {
            if(DevicetypeVerifier.verityTimes == 0)
            {
                cancel(true);
                DebugLog.w(DevicetypeVerifier.TAG, "Cancled In verifyModleTask.onPreExecute()");
            }
            url = Constant.URL_CHECKMODEL;
            DebugLog.d(DevicetypeVerifier.TAG, (new StringBuilder()).append("Remain ").append(DevicetypeVerifier.verityTimes).append(" time(s) Verification").toString());
        }

        final DevicetypeVerifier this$0;
        private String url;

        private verifyModelTask()
        {
            this$0 = DevicetypeVerifier.this;
            super();
        }

    }

    private class verifySizeTask extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            as = new ArrayList();
            as.add(new BasicNameValuePair("deviceSize", DevicetypeVerifier.SPM.getData("ScreenInchSize", "0.00000000")));
            DebugLog.d(DevicetypeVerifier.TAG, (new StringBuilder()).append("Start HTTP POST Request With URL: '").append(url).append("' And Params: ").append(as.toString()).toString());
            return doHttpPost(url, as);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            DebugLog.d(DevicetypeVerifier.TAG, (new StringBuilder()).append("verifySizeTask: ").append(s).toString());
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        protected void onPreExecute()
        {
            if(DevicetypeVerifier.verityTimes == 0)
            {
                cancel(true);
                DebugLog.w(DevicetypeVerifier.TAG, "Cancled In verifySizeTask.onPreExecute()");
            }
            url = Constant.URL_CHECKSIZE;
            DebugLog.i(DevicetypeVerifier.TAG, "Remain 1 time Verification");
        }

        final DevicetypeVerifier this$0;
        private String url;

        private verifySizeTask()
        {
            this$0 = DevicetypeVerifier.this;
            super();
        }

    }


    private DevicetypeVerifier()
    {
    }

    public static DevicetypeVerifier getInstance()
    {
        com/realtech_inc/andproject/chinanet/networks/DevicetypeVerifier;
        JVM INSTR monitorenter ;
        DevicetypeVerifier devicetypeverifier;
        if(mInstance == null)
        {
            verityTimes = 0;
            mInstance = new DevicetypeVerifier();
        }
        devicetypeverifier = mInstance;
        com/realtech_inc/andproject/chinanet/networks/DevicetypeVerifier;
        JVM INSTR monitorexit ;
        return devicetypeverifier;
        Exception exception;
        exception;
        throw exception;
    }

    public void startVerify(com.realtech_inc.andproject.chinanet.constant.Constant.CheckPattern checkpattern)
    {
        this;
        JVM INSTR monitorenter ;
        DebugLog.i(TAG, "--------------startVerify-------------");
        if(!checkpattern.equals(com.realtech_inc.andproject.chinanet.constant.Constant.CheckPattern.BOTH)) goto _L2; else goto _L1
_L1:
        verityTimes = 2;
        (new verifyModelTask()).execute(new String[0]);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        verityTimes = 1;
        if(!checkpattern.equals(com.realtech_inc.andproject.chinanet.constant.Constant.CheckPattern.MODEL))
            break MISSING_BLOCK_LABEL_83;
        (new verifyModelTask()).execute(new String[0]);
          goto _L3
        checkpattern;
        throw checkpattern;
        (new verifySizeTask()).execute(new String[0]);
          goto _L3
    }

    private static final SharedPrefsManager SPM = SharedPrefsManager.getInstance();
    private static final String TAG = com/realtech_inc/andproject/chinanet/networks/DevicetypeVerifier.getSimpleName();
    private static DevicetypeVerifier mInstance;
    private static int verityTimes;




/*
    static int access$210()
    {
        int i = verityTimes;
        verityTimes = i - 1;
        return i;
    }

*/


}
