// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.io;

import android.os.Bundle;
import com.realtech_inc.andproject.chinanet.activity.BaseActivity;
import com.realtech_inc.andproject.chinanet.utils.DefaultConsts;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

// Referenced classes of package com.realtech_inc.andproject.chinanet.io:
//            AbsHttpRequest, HTTP_Type, Task

public class HttpPostTestAction extends AbsHttpRequest
{

    public HttpPostTestAction(BaseActivity baseactivity, HTTP_Type http_type)
    {
        super(baseactivity, HTTP_Type.GET);
    }

    void onResponse(byte abyte0[], HashMap hashmap)
    {
        hashmap = null;
        try
        {
            abyte0 = new String(abyte0, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch(byte abyte0[])
        {
            abyte0.printStackTrace();
            abyte0 = hashmap;
        }
        hashmap = new Bundle();
        hashmap.putString(DefaultConsts.CONTEXT_S, abyte0);
        updateUI(100, hashmap);
    }

    public void start(Bundle bundle)
    {
        if(bundle != null)
            (new HashMap()).put(DefaultConsts.PHONE_S, bundle.getString(DefaultConsts.PHONE_S));
        request(new Task(this, null));
    }
}
