// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;
import java.util.*;

// Referenced classes of package com.xxx.sdk.a:
//            a, h

public final class g
{

    public g()
    {
    }

    public g(Context context)
    {
        a_com_xxx_sdk_a_a_fld = new a(context);
    }

    private transient void a(String as[])
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        if(!com.xxx.sdk.e.b.a(as)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SQLiteDatabase sqlitedatabase2 = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.delete("sdk_track_record", "id".concat((new StringBuilder(" in (")).append(com.xxx.sdk.e.b.a(com.xxx.sdk.e.b.a(as), ",")).append(")").toString()), null);
        if(sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
            return;
        }
          goto _L1
        as;
        sqlitedatabase1 = sqlitedatabase;
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", as);
        if(sqlitedatabase == null) goto _L1; else goto _L3
_L3:
        sqlitedatabase.close();
        return;
        as;
        if(sqlitedatabase1 != null)
            sqlitedatabase1.close();
        throw as;
    }

    private static String b(int j)
    {
        switch(j)
        {
        default:
            return (new StringBuilder("ScreenOrientation:")).append(Integer.toHexString(j)).toString();

        case 3: // '\003'
            return "behind";

        case 10: // '\n'
            return "fullSensor";

        case 13: // '\r'
            return "fullUser";

        case 0: // '\0'
            return "landscape";

        case 14: // '\016'
            return "locked";

        case 5: // '\005'
            return "nosensor";

        case 1: // '\001'
            return "portrait";

        case 8: // '\b'
            return "reverseLandscape";

        case 9: // '\t'
            return "reversePortrait";

        case 4: // '\004'
            return "sensor";

        case 6: // '\006'
            return "sensorLandscape";

        case 7: // '\007'
            return "sensorPortrait";

        case -1: 
            return "unspecified";

        case 2: // '\002'
            return "user";

        case 11: // '\013'
            return "userLandscape";

        case 12: // '\f'
            return "userPortrait";
        }
    }

    private static String c(int j)
    {
        switch(j)
        {
        default:
            return (new StringBuilder("LaunchMode:")).append(Integer.toHexString(j)).toString();

        case 0: // '\0'
            return "standard";

        case 1: // '\001'
            return "singleTop";

        case 2: // '\002'
            return "singleTask";

        case 3: // '\003'
            return "singleInstance";
        }
    }

    private static String d(int j)
    {
        ArrayList arraylist = new ArrayList();
        if((j & 0x1000) == 0) goto _L2; else goto _L1
_L1:
        arraylist.add("density");
_L4:
        return h.a(arraylist, "|");
_L2:
        if((0x40000000 & j) != 0)
            arraylist.add("fontScale");
        else
        if((j & 0x10) != 0)
            arraylist.add("keyboard");
        else
        if((j & 0x20) != 0)
            arraylist.add("keyboardHidden");
        else
        if((j & 0x2000) != 0)
            arraylist.add("direction");
        else
        if((j & 4) != 0)
            arraylist.add("locale");
        else
        if((j & 1) != 0)
            arraylist.add("mcc");
        else
        if((j & 2) != 0)
            arraylist.add("mnc");
        else
        if((j & 0x40) != 0)
            arraylist.add("navigation");
        else
        if((j & 0x80) != 0)
            arraylist.add("orientation");
        else
        if((j & 0x100) != 0)
            arraylist.add("screenLayout");
        else
        if((j & 0x400) != 0)
            arraylist.add("screenSize");
        else
        if((j & 0x800) != 0)
            arraylist.add("smallestScreenSize");
        else
        if((j & 8) != 0)
            arraylist.add("touchscreen");
        else
        if((j & 0x200) != 0)
            arraylist.add("uiMode");
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String e(int j)
    {
        int k;
        ArrayList arraylist;
        k = j & 0xf0;
        j &= 0xf;
        arraylist = new ArrayList(2);
        k;
        JVM INSTR lookupswitch 4: default 64
    //                   0: 90
    //                   16: 185
    //                   32: 173
    //                   48: 161;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_90;
_L1:
        arraylist.add((new StringBuilder("WindowInputModeAdjust:")).append(Integer.toHexString(k)).toString());
_L13:
        j;
        JVM INSTR tableswitch 0 5: default 128
    //                   0 154
    //                   1 233
    //                   2 221
    //                   3 197
    //                   4 245
    //                   5 209;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L7:
        break; /* Loop/switch isn't completed */
_L6:
        arraylist.add((new StringBuilder("WindowInputModeState:")).append(Integer.toHexString(j)).toString());
_L14:
        return h.a(arraylist, "|");
_L5:
        arraylist.add("adjustNothing");
          goto _L13
_L4:
        arraylist.add("adjustPan");
          goto _L13
_L3:
        arraylist.add("adjustResize");
          goto _L13
_L10:
        arraylist.add("stateAlwaysHidden");
          goto _L14
_L12:
        arraylist.add("stateAlwaysVisible");
          goto _L14
_L9:
        arraylist.add("stateHidden");
          goto _L14
_L8:
        arraylist.add("stateUnchanged");
          goto _L14
_L11:
        arraylist.add("stateVisible");
          goto _L14
    }

    private static String f(int j)
    {
        int k;
        ArrayList arraylist;
        arraylist = new ArrayList(3);
        if((j & 0x10) != 0)
        {
            j ^= 0x10;
            arraylist.add("system");
        }
        k = j;
        if((j & 0x20) != 0)
        {
            k = j ^ 0x20;
            arraylist.add("development");
        }
        k;
        JVM INSTR tableswitch 0 3: default 84
    //                   0 117
    //                   1 129
    //                   2 141
    //                   3 153;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        arraylist.add((new StringBuilder("ProtectionLevel:")).append(Integer.toHexString(k)).toString());
_L7:
        return h.a(arraylist, "|");
_L2:
        arraylist.add("normal");
        continue; /* Loop/switch isn't completed */
_L3:
        arraylist.add("dangerous");
        continue; /* Loop/switch isn't completed */
_L4:
        arraylist.add("signature");
        continue; /* Loop/switch isn't completed */
_L5:
        arraylist.add("signatureOrSystem");
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static String g(int j)
    {
        switch(j)
        {
        default:
            return (new StringBuilder("installLocation:")).append(Integer.toHexString(j)).toString();

        case 0: // '\0'
            return "auto";

        case 1: // '\001'
            return "internalOnly";

        case 2: // '\002'
            return "preferExternal";
        }
    }

    public final void a(List list)
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        if(!com.xxx.sdk.e.b.a(list)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SQLiteDatabase sqlitedatabase2 = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.beginTransaction();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        list = list.iterator();
_L4:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if(!list.hasNext())
            break; /* Loop/switch isn't completed */
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        com.xxx.sdk.a.h h1 = (com.xxx.sdk.a.h)list.next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ContentValues contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("url", h1.url);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("url_params", h1.aF);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("head_params", h1.aG);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("create_date", Long.valueOf(System.currentTimeMillis()));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if(com.xxx.sdk.e.b.f(h1.aH))
            break MISSING_BLOCK_LABEL_205;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("http_method", h1.aH);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.insert("sdk_track_record", null, contentvalues);
        if(true) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
        list;
        sqlitedatabase1 = sqlitedatabase;
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", list);
        if(sqlitedatabase != null)
        {
            sqlitedatabase.endTransaction();
            sqlitedatabase.close();
            return;
        }
        if(true) goto _L1; else goto _L5
_L5:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        if(sqlitedatabase2 == null) goto _L1; else goto _L6
_L6:
        sqlitedatabase2.endTransaction();
        sqlitedatabase2.close();
        return;
        list;
        if(sqlitedatabase1 != null)
        {
            sqlitedatabase1.endTransaction();
            sqlitedatabase1.close();
        }
        throw list;
    }

    public final List d()
    {
        Object obj2 = null;
        Object obj = a_com_xxx_sdk_a_a_fld.getReadableDatabase();
        Object obj1 = ((SQLiteDatabase) (obj)).query("sdk_track_record", com.xxx.sdk.a.h.b, null, null, null, null, "create_date".concat(" asc limit ").concat("3"));
        if(!((Cursor) (obj1)).moveToFirst())
            break MISSING_BLOCK_LABEL_181;
        obj2 = new ArrayList();
        boolean flag;
        do
        {
            com.xxx.sdk.a.h h1 = new com.xxx.sdk.a.h();
            h1.id = ((Cursor) (obj1)).getLong(0);
            h1.url = ((Cursor) (obj1)).getString(1);
            h1.aF = ((Cursor) (obj1)).getString(2);
            h1.aG = ((Cursor) (obj1)).getString(3);
            h1.aH = ((Cursor) (obj1)).getString(4);
            h1.i = ((Cursor) (obj1)).getLong(5);
            ((List) (obj2)).add(h1);
            flag = ((Cursor) (obj1)).moveToNext();
        } while(flag);
        if(obj1 != null)
            ((Cursor) (obj1)).close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
        return ((List) (obj2));
        if(obj1 != null)
            ((Cursor) (obj1)).close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
_L1:
        return null;
        obj2;
        obj = null;
        obj1 = null;
_L4:
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", ((Throwable) (obj2)));
        if(obj != null)
            ((Cursor) (obj)).close();
        if(obj1 != null)
            ((SQLiteDatabase) (obj1)).close();
          goto _L1
        obj;
        obj1 = null;
_L3:
        if(obj1 != null)
            ((Cursor) (obj1)).close();
        if(obj2 != null)
            ((SQLiteDatabase) (obj2)).close();
        throw obj;
        Exception exception;
        exception;
        obj1 = null;
        obj2 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj1;
        obj1 = obj;
        obj = exception;
        if(true) goto _L3; else goto _L2
_L2:
        obj2;
        obj1 = obj;
        obj = null;
          goto _L4
        obj2;
        Object obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L4
    }

    public final int i()
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase2 = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        int j = sqlitedatabase2.delete("sdk_track_record", null, null);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        com.xxx.sdk.e.c.verbose((new StringBuilder("deleteAll :\u3000")).append(j).toString());
        if(sqlitedatabase2 != null)
            sqlitedatabase2.close();
        return j;
        Exception exception1;
        exception1;
        sqlitedatabase1 = sqlitedatabase;
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", exception1);
        if(sqlitedatabase != null)
            sqlitedatabase.close();
        return 0;
        Exception exception;
        exception;
        if(sqlitedatabase1 != null)
            sqlitedatabase1.close();
        throw exception;
    }

    private Context a_android_content_Context_fld;
    public a a_com_xxx_sdk_a_a_fld;
}
