// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import android.database.sqlite.SQLiteDatabase;
import com.xxx.sdk.a.a;
import com.xxx.sdk.a.g;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.k;
import java.util.List;

// Referenced classes of package com.xxx.sdk.c:
//            g

public final class h
    implements Runnable
{

    public h(com.xxx.sdk.c.g g1)
    {
        b = g1;
        super();
    }

    public final void run()
    {
        Object obj;
        b.k = System.currentTimeMillis();
        obj = b.a.d();
        if(!com.xxx.sdk.e.b.a(((List) (obj)))) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String as[];
        as = new String[((List) (obj)).size()];
        for(int i = 0; i < ((List) (obj)).size(); i++)
        {
            com.xxx.sdk.a.h h1 = (com.xxx.sdk.a.h)((List) (obj)).get(i);
            String s = k.a(h1.url, h1.aF);
            com.xxx.sdk.c.g g1 = b;
            com.xxx.sdk.c.g.c(s);
            as[i] = String.valueOf(h1.id);
        }

        obj = b.a;
        if(com.xxx.sdk.e.b.a(as))
            continue; /* Loop/switch isn't completed */
        SQLiteDatabase sqlitedatabase = ((g) (obj)).a.getWritableDatabase();
        obj = sqlitedatabase;
        sqlitedatabase.delete("sdk_track_record", "id".concat((new StringBuilder(" in (")).append(com.xxx.sdk.e.b.a(com.xxx.sdk.e.b.a(as), ",")).append(")").toString()), null);
        if(sqlitedatabase != null)
        {
            sqlitedatabase.close();
            return;
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception1;
        exception1;
        sqlitedatabase = null;
_L7:
        obj = sqlitedatabase;
        c.a("\u67E5\u8BE2\u6570\u636E\u5E93\u5F02\u5E38\u3002", exception1);
        if(sqlitedatabase == null) goto _L1; else goto _L4
_L4:
        sqlitedatabase.close();
        return;
        Exception exception;
        exception;
        obj = null;
_L6:
        if(obj != null)
            ((SQLiteDatabase) (obj)).close();
        throw exception;
        exception;
        if(true) goto _L6; else goto _L5
_L5:
        exception1;
          goto _L7
    }

    private com.xxx.sdk.c.g b;
}
