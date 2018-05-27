// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.os.AsyncTask;
import java.io.File;

public final class b extends AsyncTask
{

    public b()
    {
    }

    private static transient Integer a(File afile[])
    {
        int i;
        int k;
        if(afile == null)
            break MISSING_BLOCK_LABEL_146;
        k = afile.length;
        i = 0;
_L3:
        if(i >= k) goto _L2; else goto _L1
_L1:
        File afile1[] = afile[i].listFiles();
        if(afile1 == null)
            continue; /* Loop/switch isn't completed */
        int l = afile1.length;
        int i1;
        long l1;
        File file;
        Exception exception;
        String s;
        for(int j = 0; j >= l; j++)
            continue; /* Loop/switch isn't completed */

        file = afile1[j];
        if(!file.isFile())
            break MISSING_BLOCK_LABEL_148;
        s = file.getName();
        i1 = s.indexOf("_");
        if(i1 <= 0)
            break MISSING_BLOCK_LABEL_148;
        l1 = Long.parseLong(s.substring(0, i1));
        if(l1 > 0L)
            break MISSING_BLOCK_LABEL_111;
        if(l1 > System.currentTimeMillis() + 0x57b12c00L)
            break MISSING_BLOCK_LABEL_148;
        try
        {
            if(System.currentTimeMillis() > l1)
                file.delete();
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_148;
        i++;
          goto _L3
_L2:
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((File[])aobj);
    }
}
