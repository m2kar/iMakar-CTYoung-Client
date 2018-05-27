// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.c.d;
import com.xxx.sdk.j;
import java.io.IOException;

// Referenced classes of package com.xxx.sdk.a:
//            b

public class a extends com.xxx.sdk.a.b
{

    public a(Context context)
    {
        super(context, j.a().L);
    }

    private static void a(SQLiteDatabase sqlitedatabase, String s)
    {
        String as[];
        s = com/xxx/sdk/a/a.getClassLoader().getResourceAsStream(s);
        as = d.a(s).replaceAll("[ \t]*--.*[\r\n]+", "").replaceAll("[ \t]*[\r\n]+", "").split(";");
        int i = 0;
_L2:
        if(i < as.length)
        {
            if(!b.f(as[i]))
                sqlitedatabase.execSQL(as[i]);
            break MISSING_BLOCK_LABEL_74;
        } else
        {
            try
            {
                d.a(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch(SQLiteDatabase sqlitedatabase)
            {
                c.a("\u5347\u7EA7\u6570\u636E\u5E93\u4E2D\u5F02\u5E38", sqlitedatabase);
            }
            return;
        }
        i++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        a(sqlitedatabase, "database.sql");
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int k)
    {
        for(; i < 5; i++)
            a(sqlitedatabase, (new StringBuilder("database-")).append(i).append(".sql").toString());

    }

    private static int N = 5;
}
