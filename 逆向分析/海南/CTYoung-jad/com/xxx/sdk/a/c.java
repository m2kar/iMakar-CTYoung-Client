// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.xxx.sdk.e.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.xxx.sdk.a:
//            a, d

public final class c
{

    public c()
    {
    }

    public c(Context context)
    {
        a_com_xxx_sdk_a_a_fld = new a(context);
    }

    public final d a(String s, String s1)
    {
        Object obj2;
        obj2 = null;
        if(b.f(s) || b.f(s1))
            return null;
        Object obj = a_com_xxx_sdk_a_a_fld.getReadableDatabase();
        Object obj1 = ((SQLiteDatabase) (obj)).query("sdk_caches", com.xxx.sdk.a.d.b, "module".concat("=? and ").concat("cache_key".concat("=? ")), (String[])b.toArray(new String[] {
            s, s1
        }), null, null, null);
        if(!((Cursor) (obj1)).moveToFirst())
            break MISSING_BLOCK_LABEL_176;
        s = new d();
        s.id = ((Cursor) (obj1)).getInt(0);
        s.an = ((Cursor) (obj1)).getString(1);
        s.ao = ((Cursor) (obj1)).getString(2);
        s.ap = ((Cursor) (obj1)).getString(3);
        s.status = ((Cursor) (obj1)).getInt(4);
        if(obj1 != null)
            ((Cursor) (obj1)).close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
        return s;
        if(obj1 != null)
            ((Cursor) (obj1)).close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
_L1:
        return null;
        obj;
        s = null;
        s1 = null;
_L4:
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", ((Throwable) (obj)));
        if(s != null)
            s.close();
        if(s1 != null)
            s1.close();
          goto _L1
        s;
        s1 = null;
        obj = obj2;
_L3:
        if(obj != null)
            ((Cursor) (obj)).close();
        if(s1 != null)
            s1.close();
        throw s;
        s;
        s1 = ((String) (obj));
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        s;
        s1 = ((String) (obj));
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj = s;
        s = ((String) (obj1));
        if(true) goto _L3; else goto _L2
_L2:
        s;
        s1 = ((String) (obj));
        obj = s;
        s = null;
          goto _L4
        Exception exception;
        exception;
        s = ((String) (obj1));
        s1 = ((String) (obj));
        obj = exception;
          goto _L4
    }

    public final List a(String s)
    {
        return a(s, new Integer[] {
            Integer.valueOf(1), Integer.valueOf(2)
        });
    }

    public final transient List a(String s, Integer ainteger[])
    {
        d d1;
        d1 = null;
        if(b.f(s) || b.a(ainteger))
            return null;
        Object obj = a_com_xxx_sdk_a_a_fld.getReadableDatabase();
        s = ((SQLiteDatabase) (obj)).query("sdk_caches", com.xxx.sdk.a.d.b, "module".concat("=? and ").concat("status".concat((new StringBuilder(" in (")).append(b.a(Arrays.asList(ainteger), ",")).append(") ").toString())), (String[])b.toArray(new String[] {
            s
        }), null, null, null);
        if(!s.moveToFirst())
            break MISSING_BLOCK_LABEL_228;
        ainteger = new ArrayList();
        boolean flag;
        do
        {
            d1 = new d();
            d1.id = s.getInt(0);
            d1.an = s.getString(1);
            d1.ao = s.getString(2);
            d1.ap = s.getString(3);
            d1.status = s.getInt(4);
            ainteger.add(d1);
            flag = s.moveToNext();
        } while(flag);
        if(s != null)
            s.close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
        return ainteger;
        if(s != null)
            s.close();
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
_L1:
        return null;
        obj;
        s = null;
        ainteger = null;
_L4:
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", ((Throwable) (obj)));
        if(s != null)
            s.close();
        if(ainteger != null)
            ainteger.close();
          goto _L1
        s;
        ainteger = null;
        obj = d1;
_L3:
        if(obj != null)
            ((Cursor) (obj)).close();
        if(ainteger != null)
            ainteger.close();
        throw s;
        s;
        ainteger = ((Integer []) (obj));
        obj = d1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        String s1 = s;
        ainteger = ((Integer []) (obj));
        s = exception;
        obj = s1;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        obj = s;
        s = ((String) (obj1));
        if(true) goto _L3; else goto _L2
_L2:
        s;
        ainteger = ((Integer []) (obj));
        obj = s;
        s = null;
          goto _L4
        obj1;
        ainteger = ((Integer []) (obj));
        obj = obj1;
          goto _L4
    }

    public final transient void a(d ad1[])
    {
        int i = 0;
        if(!b.a(ad1)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase2 = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.beginTransaction();
_L4:
        if(i > 0)
            break; /* Loop/switch isn't completed */
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.execSQL("delete sdk_caches WHERE id=?", new Object[] {
            Integer.valueOf(ad1[0].id)
        });
        i++;
        if(true) goto _L4; else goto _L3
_L3:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        if(sqlitedatabase2 != null)
        {
            sqlitedatabase2.endTransaction();
            sqlitedatabase2.close();
            return;
        }
          goto _L1
        ad1;
        sqlitedatabase1 = sqlitedatabase;
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", ad1);
        if(sqlitedatabase == null) goto _L1; else goto _L5
_L5:
        sqlitedatabase.endTransaction();
        sqlitedatabase.close();
        return;
        ad1;
        if(sqlitedatabase1 != null)
        {
            sqlitedatabase1.endTransaction();
            sqlitedatabase1.close();
        }
        throw ad1;
    }

    public final boolean a(String s, d d1)
    {
        if(!b.f(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj;
        obj = null;
        s = null;
        SQLiteDatabase sqlitedatabase = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitedatabase.beginTransaction();
        s = sqlitedatabase;
        obj = sqlitedatabase;
        SQLiteStatement sqlitestatement = sqlitedatabase.compileStatement("UPDATE sdk_caches SET status=?,cache_value=? WHERE module=? AND cache_key=?");
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindLong(1, 2L);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindString(2, d1.ao);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindString(3, d1.am);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindString(4, d1.an);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        int i = sqlitestatement.executeUpdateDelete();
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.clearBindings();
        if(i != 0)
            break MISSING_BLOCK_LABEL_265;
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement = sqlitedatabase.compileStatement("INSERT INTO sdk_caches(module,cache_key,cache_value,cache_raw,status) VALUES(?,?,?,?,?)");
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindString(1, d1.am);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindString(2, d1.an);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindString(3, d1.ao);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindNull(4);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.bindLong(5, 1L);
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.execute();
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitestatement.clearBindings();
        s = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitedatabase.setTransactionSuccessful();
        if(sqlitedatabase != null)
        {
            sqlitedatabase.endTransaction();
            sqlitedatabase.close();
        }
        return true;
        d1;
        obj = s;
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", d1);
        if(s == null) goto _L1; else goto _L3
_L3:
        s.endTransaction();
        s.close();
        return false;
        s;
        if(obj != null)
        {
            ((SQLiteDatabase) (obj)).endTransaction();
            ((SQLiteDatabase) (obj)).close();
        }
        throw s;
    }

    public final boolean a(String s, List list)
    {
        Object obj;
        if(b.f(s))
            return false;
        if(b.a(list))
            return true;
        obj = null;
        SQLiteDatabase sqlitedatabase = a_com_xxx_sdk_a_a_fld.getWritableDatabase();
        obj = sqlitedatabase;
        sqlitedatabase.beginTransaction();
        obj = sqlitedatabase;
        sqlitedatabase.execSQL("UPDATE sdk_caches SET status=? WHERE module=?", new Object[] {
            Integer.valueOf(0), s
        });
        obj = sqlitedatabase;
        s = sqlitedatabase.compileStatement("UPDATE sdk_caches SET status=? ,cache_value=? WHERE module=? AND cache_key=?");
        obj = sqlitedatabase;
        SQLiteStatement sqlitestatement = sqlitedatabase.compileStatement("INSERT INTO sdk_caches(module,cache_key,cache_value,cache_raw,status) VALUES(?,?,?,?,?)");
        int i = 0;
_L9:
        obj = sqlitedatabase;
        if(i >= list.size()) goto _L2; else goto _L1
_L1:
        obj = sqlitedatabase;
        d d1 = (d)list.get(i);
        obj = sqlitedatabase;
        s.bindLong(1, 2L);
        obj = sqlitedatabase;
        s.bindString(2, d1.ao);
        obj = sqlitedatabase;
        s.bindString(3, d1.am);
        obj = sqlitedatabase;
        s.bindString(4, d1.an);
        obj = sqlitedatabase;
        int j = s.executeUpdateDelete();
        obj = sqlitedatabase;
        s.clearBindings();
        if(j != 0) goto _L4; else goto _L3
_L3:
        obj = sqlitedatabase;
        sqlitestatement.bindString(1, d1.am);
        obj = sqlitedatabase;
        sqlitestatement.bindString(2, d1.an);
        obj = sqlitedatabase;
        sqlitestatement.bindString(3, d1.ao);
        obj = sqlitedatabase;
        sqlitestatement.bindNull(4);
        obj = sqlitedatabase;
        sqlitestatement.bindLong(5, 1L);
        obj = sqlitedatabase;
        sqlitestatement.execute();
        obj = sqlitedatabase;
        sqlitestatement.clearBindings();
          goto _L4
_L2:
        obj = sqlitedatabase;
        sqlitedatabase.setTransactionSuccessful();
        if(sqlitedatabase != null)
        {
            sqlitedatabase.endTransaction();
            sqlitedatabase.close();
        }
        return true;
        list;
        s = null;
_L7:
        com.xxx.sdk.e.c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", list);
        if(s != null)
        {
            s.endTransaction();
            s.close();
        }
        return false;
        s;
_L6:
        if(obj != null)
        {
            ((SQLiteDatabase) (obj)).endTransaction();
            ((SQLiteDatabase) (obj)).close();
        }
        throw s;
        list;
        obj = s;
        s = list;
        if(true) goto _L6; else goto _L5
_L5:
        list;
        s = sqlitedatabase;
        if(true) goto _L7; else goto _L4
_L4:
        i++;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private static int P = 0;
    private static int Q = 1;
    private static int R = 2;
    private static int S = 0;
    private static int T = 1;
    private static int U = 2;
    private static int V = 3;
    private static int W = 4;
    private static int X = 5;
    private static int Y = 6;
    private static int Z = 0;
    private static int aa = 1;
    private static int ab = 2;
    private static int ac = 3;
    private static int ad_int_static_fld = 4;
    private static String ad_java_lang_String_static_fld = "floating";
    private static int ae_int_static_fld = 5;
    private static String ae_java_lang_String_static_fld = "launcher";
    private static int af = 6;
    private static int ag = 1;
    private static int ah = 4;
    private Context a_android_content_Context_fld;
    private a a_com_xxx_sdk_a_a_fld;
}
