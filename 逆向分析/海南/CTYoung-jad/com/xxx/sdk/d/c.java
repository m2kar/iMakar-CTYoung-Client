// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.xxx.c.i;
import com.xxx.c.k;
import com.xxx.e.b;
import com.xxx.sdk.a.e;
import com.xxx.sdk.a.f;
import com.xxx.sdk.b.d;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.p;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.d:
//            i

public final class c
{

    public c()
    {
    }

    public c(Context context)
    {
        a = context;
    }

    private int a(f f1)
    {
        byte byte0;
        String s;
        s = f1.az;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 44
    //                   3107: 74
    //                   116079: 102
    //                   291111836: 88;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_102;
_L5:
        switch(byte0)
        {
        default:
            return 0;

        case 0: // '\0'
            return d(f1);

        case 1: // '\001'
            return c(f1);

        case 2: // '\002'
            return b(f1);
        }
_L2:
        if(s.equals("ad"))
            byte0 = 0;
          goto _L5
_L4:
        if(s.equals("fetchOptAd"))
            byte0 = 1;
          goto _L5
        if(s.equals("url"))
            byte0 = 2;
          goto _L5
    }

    private static void a(Integer integer)
    {
        com.xxx.sdk.d.i.a().removeMessages(102);
        com.xxx.sdk.d.i.a().sendEmptyMessageDelayed(102, integer.intValue());
    }

    private static void a(HashMap hashmap, JSONObject jsonobject)
    {
        hashmap.put("optimizedAdShow", Boolean.valueOf(jsonobject.optBoolean("show")));
        if(jsonobject.has("imei"))
            hashmap.put("optimizedAdImei", jsonobject.optString("imei"));
        if(jsonobject.has("mac"))
            hashmap.put("optimizedAdMac", jsonobject.optString("mac"));
        hashmap.put("optimizedAdClick", Boolean.valueOf(jsonobject.optBoolean("click")));
        hashmap.put("optimized_platform_name", jsonobject.optString("platform"));
        hashmap.put("optimizedAdShowDuration", Integer.valueOf(jsonobject.optInt("showDuration")));
    }

    private int b(f f1)
    {
        int j;
        int l;
        boolean flag;
        JSONArray jsonarray;
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(f1.value);
            f1 = jsonobject.optJSONArray("urls");
            jsonarray = jsonobject.optJSONArray("network");
        }
        // Misplaced declaration of an exception variable
        catch(f f1)
        {
            f1.printStackTrace();
            return 0;
        }
        if(jsonarray == null) goto _L2; else goto _L1
_L1:
        j = Integer.valueOf(com.xxx.sdk.e.e.a.d(a)).intValue();
_L12:
        l = 0;
_L13:
        if(l >= jsonarray.length())
            break MISSING_BLOCK_LABEL_183;
        if(jsonarray.optInt(l) != j) goto _L4; else goto _L3
_L3:
        flag = true;
_L11:
        if(f1 == null || !flag) goto _L6; else goto _L5
_L5:
        f1 = new i(a, k.a(f1));
        if(!((i) (f1)).e) goto _L8; else goto _L7
_L7:
        ((i) (f1)).handler.sendEmptyMessage(121);
        return 0;
_L2:
        if(!jsonobject.has("network")) goto _L10; else goto _L9
_L9:
        flag = com.xxx.sdk.b.d.check(jsonobject.optInt("network"));
          goto _L11
_L8:
        ((i) (f1)).handler.sendEmptyMessage(120);
        return 0;
_L10:
        flag = true;
          goto _L11
_L6:
        return 0;
        NumberFormatException numberformatexception;
        numberformatexception;
        j = 0;
          goto _L12
_L4:
        l++;
          goto _L13
        flag = false;
          goto _L11
    }

    private static int c(f f1)
    {
        f1 = f1.value;
        long l;
        long l1;
        l = (new JSONObject(f1)).optLong("executeTime");
        if(l <= System.currentTimeMillis())
            break MISSING_BLOCK_LABEL_37;
        l1 = System.currentTimeMillis();
        return (int)(l - l1);
        f1;
        (new com.xxx.sdk.c.d()).load();
        return 0;
    }

    private int d(f f1)
    {
        f1 = f1.value;
        Object obj;
        f1 = new JSONObject(f1);
        obj = f1.getString("type");
        long l = f1.optLong("executeTime");
        if(l > System.currentTimeMillis())
            return (int)(l - System.currentTimeMillis());
        if(!((String) (obj)).equals("banner"))
            break MISSING_BLOCK_LABEL_99;
        obj = com.xxx.c.d.a(a);
        HashMap hashmap = new HashMap();
        a(hashmap, f1);
        obj.b = hashmap;
        ((com.xxx.c.d) (obj)).f();
        return 0;
        try
        {
            if("floating".equals(obj))
            {
                com.xxx.c.f f2 = com.xxx.c.f.a(a);
                com.xxx.e.b.q(a);
                HashMap hashmap1 = new HashMap();
                a(hashmap1, f1);
                f2.b = hashmap1;
                f2.f();
            }
        }
        // Misplaced declaration of an exception variable
        catch(f f1)
        {
            f1.printStackTrace();
            return 0;
        }
        return 0;
    }

    protected final Integer a()
    {
        int j;
        int l;
        Object obj;
        Object obj1;
        String s;
        j = -1;
        l = 0;
        obj1 = new e(a);
        obj = ((e) (obj1)).a();
        if(obj == null)
        {
            l = com.xxx.sdk.b.a(((e) (obj1)).a_android_content_Context_fld).a().z;
            long l1 = System.currentTimeMillis();
            long l2 = l;
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append("{\"executeTime\":").append(l1 + l2).append("}");
            if(((e) (obj1)).a("fetchOptAd", ((StringBuilder) (obj)).toString()))
                j = l;
            if(j > 0)
                return Integer.valueOf(j);
            else
                return Integer.valueOf(3000);
        }
        s = ((f) (obj)).az;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 164
    //                   3107: 257
    //                   116079: 287
    //                   291111836: 272;
           goto _L1 _L2 _L3 _L4
_L1:
        j;
        JVM INSTR tableswitch 0 2: default 192
    //                   0 302
    //                   1 312
    //                   2 321;
           goto _L5 _L6 _L7 _L8
_L5:
        j = l;
_L10:
        if(j > 0)
            break; /* Loop/switch isn't completed */
        j = ((f) (obj)).id;
        obj = null;
        obj1 = ((e) (obj1)).a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        obj = obj1;
        try
        {
            ((SQLiteDatabase) (obj1)).delete("sdk_optimize", "id".concat("=?"), new String[] {
                String.valueOf(j)
            });
        }
        catch(Exception exception)
        {
            if(obj != null)
                ((SQLiteDatabase) (obj)).close();
        }
        return Integer.valueOf(3000);
_L2:
        if(s.equals("ad"))
            j = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        if(s.equals("fetchOptAd"))
            j = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        if(s.equals("url"))
            j = 2;
        continue; /* Loop/switch isn't completed */
_L6:
        j = d(((f) (obj)));
        continue; /* Loop/switch isn't completed */
_L7:
        j = c(((f) (obj)));
        continue; /* Loop/switch isn't completed */
_L8:
        j = b(((f) (obj)));
        if(true) goto _L10; else goto _L9
_L9:
        return Integer.valueOf(j);
        if(true) goto _L1; else goto _L11
_L11:
    }

    private static int DEFAULT_WAIT_TIME = 3000;
    private static int NULL = 0;
    private static int aD = 1;
    private static int aE = 2;
    private static int aF = 3;
    private static int aG = 256;
    private static int aH = 256;
    private static int aI = 257;
    private static int aJ = 258;
    private static int aK = 259;
    private static int aL = 260;
    private static int aM = 383;
    private static int aN = 384;
    private static int aO = 512;
    private static int aP = 513;
    private static int aQ = 514;
    private Context a;
}
