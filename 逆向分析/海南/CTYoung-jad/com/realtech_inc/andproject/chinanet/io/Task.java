// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.io;

import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.realtech_inc.andproject.chinanet.io:
//            AbsHttpRequest

public class Task extends Thread
{

    public Task(AbsHttpRequest abshttprequest, HashMap hashmap)
    {
        absHttpRequest = abshttprequest;
        hm = hashmap;
    }

    public void run()
    {
        try
        {
            HttpResponse httpresponse = absHttpRequest.execute(hm);
            if(httpresponse.getStatusLine().getStatusCode() == 200)
            {
                byte abyte0[] = EntityUtils.toByteArray(httpresponse.getEntity());
                DebugLog.i("inPage", new String(abyte0, "UTF-8"));
                absHttpRequest.onResponse(abyte0, hm);
            }
            return;
        }
        catch(Exception exception)
        {
            absHttpRequest.HandlerException(exception);
        }
    }

    private final AbsHttpRequest absHttpRequest;
    private final HashMap hm;
}
