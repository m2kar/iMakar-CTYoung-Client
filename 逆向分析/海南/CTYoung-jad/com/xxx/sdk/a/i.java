// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;

// Referenced classes of package com.xxx.sdk.a:
//            a, j

public final class i
{

    public i()
    {
    }

    public i(Context context)
    {
        a_com_xxx_sdk_a_a_fld = null;
        a_com_xxx_sdk_a_a_fld = new a(context);
    }

    public final j a(String s)
    {
        Object obj = null;
        if(!b.f(s)) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        SQLiteDatabase sqlitedatabase = a_com_xxx_sdk_a_a_fld.getReadableDatabase();
        s = sqlitedatabase.query("sdk_vars", com.xxx.sdk.a.j.b, "name".concat("=?"), (String[])b.toArray(new String[] {
            s
        }), null, null, null);
        if(!s.moveToFirst())
            break; /* Loop/switch isn't completed */
        obj = new j(s.getInt(0), s.getString(1), s.getString(2), s.getLong(3));
        if(s != null)
            s.close();
        s = ((String) (obj));
        if(sqlitedatabase != null)
        {
            sqlitedatabase.close();
            return ((j) (obj));
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(s != null)
            s.close();
        if(sqlitedatabase != null)
            sqlitedatabase.close();
_L5:
        return null;
        obj;
        s = null;
        sqlitedatabase = null;
_L8:
        c.a("\u6570\u636E\u5E93\u67E5\u8BE2\u4E2D\u5F02\u5E38", ((Throwable) (obj)));
        if(s != null)
            s.close();
        if(sqlitedatabase != null)
            sqlitedatabase.close();
          goto _L5
        s;
        sqlitedatabase = null;
_L7:
        if(obj != null)
            ((Cursor) (obj)).close();
        if(sqlitedatabase != null)
            sqlitedatabase.close();
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj = s;
        s = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj = s;
        s = exception;
        if(true) goto _L7; else goto _L6
_L6:
        obj;
        s = null;
          goto _L8
        obj;
          goto _L8
    }

    public final boolean a(j j1)
    {
        Object obj = null;
        Object obj1 = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        obj = obj1;
        ContentValues contentvalues = new ContentValues();
        obj = obj1;
        contentvalues.put("value", j1.value);
        obj = obj1;
        contentvalues.put("updated", Long.valueOf(j1.updated));
        obj = obj1;
        ((SQLiteDatabase) (obj1)).update("sdk_vars", contentvalues, "id".concat("=?"), (String[])b.toArray(new String[] {
            String.valueOf(j1.id)
        }));
        if(obj1 != null)
            ((SQLiteDatabase) (obj1)).close();
        return true;
        obj;
        j1 = null;
_L4:
        c.error("SdkVars\u66F4\u65B0\u4E2D\u5F02\u5E38.", ((Throwable) (obj)));
        if(j1 != null)
            j1.close();
        return false;
        j1;
_L2:
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
        throw j1;
        obj1;
        obj = j1;
        j1 = ((j) (obj1));
        if(true) goto _L2; else goto _L1
_L1:
        obj;
        j1 = ((j) (obj1));
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String aI = "settings";
    private static String aJ = "floating_ad";
    private static String aK = "launcher_ad";
    private static String aL = "session_time";
    private static String aM = "collect_fixedtime";
    private static String aN = "collect_lasttime";
    private static String aO = "net_ip";
    private static String aP = "resources.arsc";
    private static String aQ = "AndroidManifest.xml";
    private static String aR = "classes.dex";
    private static String aS = "res/";
    private static String aT = "assets/";
    private static String aU = "lib/";
    private static String aV = "META-INF/";
    private static String aW = "";
    private static int ai = 0x1010000;
    private static int aj = 0x1030000;
    private static int ak = 0x1031000;
    private Context a_android_content_Context_fld;
    private a a_com_xxx_sdk_a_a_fld;
}
