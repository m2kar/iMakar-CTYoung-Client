// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import com.xxx.sdk.a.e;
import com.xxx.sdk.*;
import org.json.*;

public final class d extends k
{

    public d()
    {
    }

    public final void load()
    {
        e e1;
        Object obj;
        obj = b(b.a().a().S);
        e1 = new e(b.a().getContext());
        if(obj != null && ((String) (obj)).length() > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        byte byte0;
        double d1;
        double d2;
        int i;
        int j;
        long l;
        JSONObject jsonobject;
        String s;
        try
        {
            obj = new JSONArray(((String) (obj)));
            l = System.currentTimeMillis();
        }
        catch(JSONException jsonexception)
        {
            return;
        }
        i = 0;
        j = 0;
_L11:
        if(i >= ((JSONArray) (obj)).length())
            continue; /* Loop/switch isn't completed */
        jsonobject = ((JSONArray) (obj)).optJSONObject(i);
        s = jsonobject.optString("cmd");
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 237
    //                   3107: 160
    //                   116079: 176;
           goto _L3 _L4 _L5
_L6:
        jsonobject.put("executeTime", l);
        e1.a(s, jsonobject.toString());
        i++;
        break; /* Loop/switch isn't completed */
_L4:
        if(s.equals("ad"))
            byte0 = 0;
          goto _L3
_L5:
        if(s.equals("url"))
            byte0 = 1;
          goto _L3
_L8:
        d1 = l;
        d2 = Math.random();
        l = (long)(d1 + ((double)j + (d2 * 5D + 5D) * 1000D));
        j = jsonobject.optInt("showDuration");
          goto _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 0: default 256
    //                   0 192;
           goto _L7 _L8
_L7:
        if(true) goto _L6; else goto _L9
_L9:
        if(true) goto _L11; else goto _L10
_L10:
        if(true) goto _L1; else goto _L12
_L12:
    }
}
