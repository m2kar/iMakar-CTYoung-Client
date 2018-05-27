// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.xxx.sdk.e.c;
import java.io.File;

public abstract class b
{

    public b(Context context, String s)
    {
        a_android_database_sqlite_SQLiteDatabase_fld = null;
        m = false;
        mContext = context;
        mName = s;
    }

    private static void J()
    {
    }

    private void close()
    {
        this;
        JVM INSTR monitorenter ;
        if(m)
            throw new IllegalStateException("Closed during initialization");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if(a_android_database_sqlite_SQLiteDatabase_fld != null && a_android_database_sqlite_SQLiteDatabase_fld.isOpen())
        {
            a_android_database_sqlite_SQLiteDatabase_fld.close();
            a_android_database_sqlite_SQLiteDatabase_fld = null;
        }
        this;
        JVM INSTR monitorexit ;
    }

    private File getDatabasePath(String s)
    {
        s = new File(mContext.getApplicationInfo().dataDir.concat(File.separator).concat("databases").concat(File.separator).concat(s));
        if(!s.getParentFile().exists())
            s.getParentFile().mkdirs();
        return s;
    }

    protected void finalize()
    {
        super.finalize();
        close();
    }

    public final SQLiteDatabase getReadableDatabase()
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        if(a_android_database_sqlite_SQLiteDatabase_fld == null || !a_android_database_sqlite_SQLiteDatabase_fld.isOpen()) goto _L2; else goto _L1
_L1:
        Object obj = a_android_database_sqlite_SQLiteDatabase_fld;
_L3:
        this;
        JVM INSTR monitorexit ;
        return ((SQLiteDatabase) (obj));
_L2:
        if(m)
            throw new IllegalStateException("getReadableDatabase called recursively");
        break MISSING_BLOCK_LABEL_52;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj = getWritableDatabase();
          goto _L3
        SQLiteException sqliteexception;
        sqliteexception;
        if(mName == null)
            throw sqliteexception;
        c.a((new StringBuilder("Couldn't open ")).append(mName).append(" for writing (will try read-only):").toString(), sqliteexception);
        sqliteexception = ((SQLiteException) (obj1));
        m = true;
        sqliteexception = ((SQLiteException) (obj1));
        Object obj2 = getDatabasePath(mName).getPath();
        sqliteexception = ((SQLiteException) (obj1));
        obj1 = SQLiteDatabase.openDatabase(((String) (obj2)), null, 0);
        sqliteexception = ((SQLiteException) (obj1));
        if(((SQLiteDatabase) (obj1)).getVersion() == 5)
            break MISSING_BLOCK_LABEL_200;
        sqliteexception = ((SQLiteException) (obj1));
        throw new SQLiteException((new StringBuilder("Can't upgrade read-only database from version ")).append(((SQLiteDatabase) (obj1)).getVersion()).append(" to 5: ").append(((String) (obj2))).toString());
        obj1;
        m = false;
        if(sqliteexception == null)
            break MISSING_BLOCK_LABEL_198;
        if(sqliteexception != a_android_database_sqlite_SQLiteDatabase_fld)
            sqliteexception.close();
        throw obj1;
        sqliteexception = ((SQLiteException) (obj1));
        c.warn((new StringBuilder("Opened ")).append(mName).append(" in read-only mode").toString());
        sqliteexception = ((SQLiteException) (obj1));
        a_android_database_sqlite_SQLiteDatabase_fld = ((SQLiteDatabase) (obj1));
        sqliteexception = ((SQLiteException) (obj1));
        obj2 = a_android_database_sqlite_SQLiteDatabase_fld;
        m = false;
        sqliteexception = ((SQLiteException) (obj2));
        if(obj1 == null) goto _L3; else goto _L4
_L4:
        sqliteexception = ((SQLiteException) (obj2));
        if(obj1 == a_android_database_sqlite_SQLiteDatabase_fld) goto _L3; else goto _L5
_L5:
        ((SQLiteDatabase) (obj1)).close();
        sqliteexception = ((SQLiteException) (obj2));
          goto _L3
    }

    public final SQLiteDatabase getWritableDatabase()
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if(a_android_database_sqlite_SQLiteDatabase_fld == null || !a_android_database_sqlite_SQLiteDatabase_fld.isOpen() || a_android_database_sqlite_SQLiteDatabase_fld.isReadOnly()) goto _L2; else goto _L1
_L1:
        obj = a_android_database_sqlite_SQLiteDatabase_fld;
_L14:
        this;
        JVM INSTR monitorexit ;
        return ((SQLiteDatabase) (obj));
_L2:
        if(m)
            throw new IllegalStateException("getWritableDatabase called recursively");
        break MISSING_BLOCK_LABEL_62;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        m = true;
        if(mName != null) goto _L4; else goto _L3
_L3:
        SQLiteDatabase sqlitedatabase = SQLiteDatabase.create(null);
        obj = sqlitedatabase;
_L9:
        int i = ((SQLiteDatabase) (obj)).getVersion();
        if(i == 5) goto _L6; else goto _L5
_L5:
        ((SQLiteDatabase) (obj)).beginTransaction();
        if(i != 0) goto _L8; else goto _L7
_L7:
        onCreate(((SQLiteDatabase) (obj)));
        onUpgrade(((SQLiteDatabase) (obj)), 1, 5);
_L10:
        ((SQLiteDatabase) (obj)).setVersion(5);
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        ((SQLiteDatabase) (obj)).endTransaction();
_L6:
        m = false;
        sqlitedatabase = a_android_database_sqlite_SQLiteDatabase_fld;
        if(sqlitedatabase == null)
            break MISSING_BLOCK_LABEL_145;
        Object obj1;
        try
        {
            a_android_database_sqlite_SQLiteDatabase_fld.close();
        }
        catch(Exception exception) { }
        a_android_database_sqlite_SQLiteDatabase_fld = ((SQLiteDatabase) (obj));
        continue; /* Loop/switch isn't completed */
_L4:
        sqlitedatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(mName).getPath(), null);
        obj = sqlitedatabase;
          goto _L9
_L8:
        onUpgrade(((SQLiteDatabase) (obj)), i, 5);
          goto _L10
        obj1;
        c.a("\u6570\u636E\u5E93\u5347\u7EA7\u4E2D\u51FA\u73B0\u95EE\u9898", ((Throwable) (obj1)));
        ((SQLiteDatabase) (obj)).endTransaction();
          goto _L6
        obj1;
_L12:
        m = false;
        if(obj == null)
            break MISSING_BLOCK_LABEL_212;
        ((SQLiteDatabase) (obj)).close();
        throw obj1;
        obj1;
        ((SQLiteDatabase) (obj)).endTransaction();
        throw obj1;
        obj1;
        if(true) goto _L12; else goto _L11
_L11:
        if(true) goto _L14; else goto _L13
_L13:
    }

    public abstract void onCreate(SQLiteDatabase sqlitedatabase);

    public abstract void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j);

    private final int O;
    private final android.database.sqlite.SQLiteDatabase.CursorFactory a_android_database_sqlite_SQLiteDatabase_CursorFactory_fld;
    private SQLiteDatabase a_android_database_sqlite_SQLiteDatabase_fld;
    private boolean m;
    private final Context mContext;
    private final String mName;
}
