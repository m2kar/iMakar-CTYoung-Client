// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xxx.sdk.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.p;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.a:
//            a, f

public final class e
{

    public e()
    {
    }

    public e(Context context)
    {
        a_android_content_Context_fld = context;
        a_com_xxx_sdk_a_a_fld = new com.xxx.sdk.a.a(context);
    }

    private static String a(int l)
    {
        int ai[] = new int[4];
        ai[0] = l >>> 24;
        ai[1] = l >> 16 & 0xff;
        ai[2] = l >> 8 & 0xff;
        ai[3] = l & 0xff;
        return (new StringBuilder()).append(Integer.toString(ai[0])).append(".").append(Integer.toString(ai[1])).append(".").append(Integer.toString(ai[2])).append(".").append(Integer.toString(ai[3])).toString();
    }

    public static String c(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s1 = s;
        if(s != null)
        {
            s1 = s;
            if(s.length() == 12)
            {
                for(int l = 0; l < 12; l++)
                {
                    if(l > 0 && l % 2 == 0)
                        stringbuilder.append(":");
                    stringbuilder.append(s.charAt(l));
                }

                s1 = stringbuilder.toString();
            }
        }
        return s1;
    }

    private List c()
    {
        Object obj3 = null;
        Object obj = a_com_xxx_sdk_a_a_fld.getReadableDatabase();
        Object obj2 = ((SQLiteDatabase) (obj)).query("sdk_optimize", new String[] {
            "id", "cmd", "value"
        }, null, null, null, null, null);
        if(obj2 == null)
            break MISSING_BLOCK_LABEL_135;
        Object obj1;
        obj1 = new ArrayList();
        ((Cursor) (obj2)).moveToFirst();
        boolean flag;
        do
        {
            ((ArrayList) (obj1)).add(new f(((Cursor) (obj2)).getInt(0), ((Cursor) (obj2)).getString(21), ((Cursor) (obj2)).getString(2)));
            flag = ((Cursor) (obj2)).moveToNext();
        } while(flag);
        if(obj2 != null)
            ((Cursor) (obj2)).close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
        return ((List) (obj1));
        if(obj2 != null)
            ((Cursor) (obj2)).close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
_L1:
        return null;
        obj2;
        obj = null;
        obj1 = null;
_L4:
        com.xxx.sdk.e.c.a("data base error", ((Throwable) (obj2)));
        if(obj != null)
            ((Cursor) (obj)).close();
        if(obj1 != null)
            ((SQLiteDatabase) (obj1)).close();
          goto _L1
        obj;
        obj1 = null;
        obj2 = obj3;
_L3:
        if(obj2 != null)
            ((Cursor) (obj2)).close();
        if(obj1 != null)
            ((SQLiteDatabase) (obj1)).close();
        throw obj;
        obj2;
        obj1 = obj;
        obj = obj2;
        obj2 = obj3;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj;
        obj = exception;
        if(true) goto _L3; else goto _L2
_L2:
        obj2;
        obj1 = obj;
        obj = null;
          goto _L4
        Exception exception1;
        exception1;
        obj1 = obj2;
        Object obj4 = obj;
        obj2 = exception1;
        obj = obj1;
        obj1 = obj4;
          goto _L4
    }

    private void c(int l)
    {
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("sdk_optimize", "id".concat("=?"), new String[] {
            String.valueOf(l)
        });
_L1:
        return;
        Exception exception;
        exception;
        if(sqlitedatabase != null)
        {
            sqlitedatabase.close();
            return;
        }
          goto _L1
    }

    private void e(String s)
    {
        if(s != null && s.length() > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        byte byte0;
        double d;
        double d1;
        int l;
        int i1;
        long l1;
        JSONObject jsonobject;
        String s1;
        try
        {
            s = new JSONArray(s);
            l1 = System.currentTimeMillis();
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            return;
        }
        l = 0;
        i1 = 0;
_L11:
        if(l >= s.length())
            continue; /* Loop/switch isn't completed */
        jsonobject = s.optJSONObject(l);
        s1 = jsonobject.optString("cmd");
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 2: default 201
    //                   3107: 123
    //                   116079: 139;
           goto _L3 _L4 _L5
_L6:
        jsonobject.put("executeTime", l1);
        a(s1, jsonobject.toString());
        l++;
        break; /* Loop/switch isn't completed */
_L4:
        if(s1.equals("ad"))
            byte0 = 0;
          goto _L3
_L5:
        if(s1.equals("url"))
            byte0 = 1;
          goto _L3
_L8:
        d = l1;
        d1 = Math.random();
        l1 = (long)(d + ((double)i1 + (d1 * 5D + 5D) * 1000D));
        i1 = jsonobject.optInt("showDuration");
          goto _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 0: default 220
    //                   0 155;
           goto _L7 _L8
_L7:
        if(true) goto _L6; else goto _L9
_L9:
        if(true) goto _L11; else goto _L10
_L10:
        if(true) goto _L1; else goto _L12
_L12:
    }

    private int f()
    {
        int l = b.a(a_android_content_Context_fld).a().z;
        long l1 = System.currentTimeMillis();
        long l2 = l;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\"executeTime\":").append(l1 + l2).append("}");
        if(a("fetchOptAd", stringbuilder.toString()))
            return l;
        else
            return -1;
    }

    private int g()
    {
        return b.a(a_android_content_Context_fld).a().z;
    }

    private int h()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 9);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long l = calendar.getTimeInMillis();
        calendar.set(11, 23);
        long l1 = calendar.getTimeInMillis();
        long l2 = System.currentTimeMillis();
        if(l2 > l && l2 < l1)
        {
            return b.a(a_android_content_Context_fld).a().z;
        } else
        {
            calendar.add(5, 1);
            calendar.set(11, (int)(9D + Math.random() * 2D));
            calendar.set(12, (int)(Math.random() * 30D));
            return (int)(calendar.getTimeInMillis() - l2);
        }
    }

    public static String h()
    {
        boolean flag = false;
        int l = com.xxx.sdk.e.b.b(0x895440);
        int i1 = com.xxx.sdk.e.b.b(0x895440);
        String s = (new StringBuilder()).append(l + 0xf4240).append(i1 + 0xf4240).toString();
        char ac[] = s.toCharArray();
        l = 0;
        int j1 = 0;
        i1 = 0;
        while(l < ac.length) 
        {
            int k1 = Integer.parseInt((new StringBuilder()).append(ac[l]).toString());
            if(l % 2 == 0)
            {
                i1 += k1;
            } else
            {
                k1 <<= 1;
                j1 = j1 + k1 / 10 + k1 % 10;
            }
            l++;
        }
        l = (i1 + j1) % 10;
        if(l == 0)
            l = ((flag) ? 1 : 0);
        else
            l = 10 - l;
        return (new StringBuilder()).append(s).append(l).toString();
    }

    public static String i()
    {
        StringBuilder stringbuilder = new StringBuilder(12);
        for(int l = 0; l < 12; l++)
            stringbuilder.append("0123456789abcdef".charAt(com.xxx.sdk.e.b.b(12)));

        return stringbuilder.toString();
    }

    private static String j()
    {
        Object obj = new int[10][];
        obj[0] = (new int[] {
            0x24380000, 0x243fffff
        });
        obj[1] = (new int[] {
            0x3de80000, 0x3dedffff
        });
        obj[2] = (new int[] {
            0x6a500000, 0x6a5fffff
        });
        obj[3] = (new int[] {
            0x794c0000, 0x794dffff
        });
        obj[4] = (new int[] {
            0x7be80000, 0x7bebffff
        });
        obj[5] = (new int[] {
            0x8bc40000, 0x8bd7ffff
        });
        obj[6] = (new int[] {
            0xab080000, 0xab0fffff
        });
        obj[7] = (new int[] {
            0xb6500000, 0xb65cffff
        });
        obj[8] = (new int[] {
            0xd2190000, 0xd22fffff
        });
        obj[9] = (new int[] {
            0xde100000, 0xde5fffff
        });
        int l = com.xxx.sdk.e.b.b(10);
        int i1 = obj[l][0];
        l = com.xxx.sdk.e.b.b(obj[l][1] - obj[l][0]) + i1;
        obj = new int[4];
        obj[0] = l >>> 24;
        obj[1] = l >> 16 & 0xff;
        obj[2] = l >> 8 & 0xff;
        obj[3] = l & 0xff;
        return (new StringBuilder()).append(Integer.toString(obj[0])).append(".").append(Integer.toString(obj[1])).append(".").append(Integer.toString(obj[2])).append(".").append(Integer.toString(obj[3])).toString();
    }

    public static String k()
    {
        String s = "";
        String s1 = com.xxx.sdk.e.e.a.D();
        Object obj = s;
        if(!com.xxx.sdk.e.b.f(s1))
        {
            String as[] = s1.split("\\.");
            obj = s;
            if(as != null)
            {
                obj = s;
                if(as.length == 4)
                {
                    as[3] = (new StringBuilder()).append(com.xxx.sdk.e.b.b(240) + 2).toString();
                    obj = new StringBuilder();
                    ((StringBuilder) (obj)).append(as[0]).append('.').append(as[1]).append('.').append(as[2]).append('.').append(as[3]);
                    obj = ((StringBuilder) (obj)).toString();
                }
            }
        }
        return ((String) (obj));
    }

    public final f a()
    {
        Object obj2;
        Object obj3;
        obj3 = null;
        obj2 = null;
        Object obj = a_com_xxx_sdk_a_a_fld.getReadableDatabase();
        obj2 = ((SQLiteDatabase) (obj)).query("sdk_optimize", new String[] {
            "id", "cmd", "value"
        }, null, null, null, null, null, "1");
        if(obj2 == null) goto _L2; else goto _L1
_L1:
        if(!((Cursor) (obj2)).moveToFirst()) goto _L2; else goto _L3
_L3:
        Object obj1 = new f(((Cursor) (obj2)).getInt(0), ((Cursor) (obj2)).getString(1), ((Cursor) (obj2)).getString(2));
_L10:
        ((SQLiteDatabase) (obj)).close();
        if(obj2 != null)
            ((Cursor) (obj2)).close();
        if(obj == null)
            break MISSING_BLOCK_LABEL_244;
        ((SQLiteDatabase) (obj)).close();
_L5:
        return ((f) (obj1));
        obj3;
        obj1 = null;
        obj = null;
_L8:
        com.xxx.sdk.e.c.a("data base error", ((Throwable) (obj3)));
        if(obj1 != null)
            ((Cursor) (obj1)).close();
        obj1 = obj;
        if(obj2 == null) goto _L5; else goto _L4
_L4:
        ((SQLiteDatabase) (obj2)).close();
        return ((f) (obj));
        obj;
        obj1 = null;
        obj2 = obj3;
_L7:
        if(obj2 != null)
            ((Cursor) (obj2)).close();
        if(obj1 != null)
            ((SQLiteDatabase) (obj1)).close();
        throw obj;
        obj2;
        obj1 = obj;
        obj = obj2;
        obj2 = obj3;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj1 = obj;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        obj;
        obj3 = obj1;
        obj1 = obj2;
        obj2 = obj3;
        if(true) goto _L7; else goto _L6
_L6:
        obj3;
        obj1 = null;
        obj2 = obj;
        obj = null;
          goto _L8
        obj3;
        obj1 = obj2;
        obj2 = obj;
        obj = null;
          goto _L8
        obj3;
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj2;
        obj2 = obj4;
          goto _L8
        return ((f) (obj1));
_L2:
        obj1 = null;
        if(true) goto _L10; else goto _L9
_L9:
    }

    public final boolean a(String s, String s1)
    {
        boolean flag;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = null;
        flag = false;
        SQLiteDatabase sqlitedatabase1 = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        ContentValues contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("cmd", s);
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("value", s1);
        sqlitedatabase = sqlitedatabase1;
        long l = sqlitedatabase1.insert("sdk_optimize", null, contentvalues);
        if(l > 0L)
            flag = true;
_L2:
        return flag;
        s;
        if(sqlitedatabase != null)
        {
            sqlitedatabase.close();
            return false;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final String DEFAULT = "[  {    \"cmd\": \"url\",    \"urls\": [{\"url\":\"http://v.qq.com/dtest/play/rpt_player.html?vid=u002015k710&ptag=bl.rx.pn05.1&domain=s11&dmid=1258981450&dmwid=1258981450\",\"showDuration\":120,\"jsFile\":\"http://sites.test.harmight.com/imagetor_mock/ad/banner_ad.js\"}],\"network\":7  }]";
    private static final String aq = "[\n    {\n       \"cmd\":\"url\",\n       \"urls\": [\n            {\n                \"url\": \"http://v.qq.com/dtest/play/rpt_player.html?vid=u002015k710&ptag=bl.rx.pn05.1&domain=s11&dmid=1258981450&dmwid=1258981450\",\n                \"showDuration\": 120,\n                \"jsFile\": \"http://track.test.harmight.com/inject/js/qq_video.js\"}\n        ]\n    }\n]";
    public Context a_android_content_Context_fld;
    public com.xxx.sdk.a.a a_com_xxx_sdk_a_a_fld;
}
