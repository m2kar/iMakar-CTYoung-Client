// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery;

import android.app.Activity;
import android.content.Context;
import android.view.View;

// Referenced classes of package com.androidquery:
//            AbstractAQuery

public class AQuery extends AbstractAQuery
{

    public AQuery(Activity activity)
    {
        super(activity);
    }

    public AQuery(Activity activity, View view)
    {
        super(activity, view);
    }

    public AQuery(Context context)
    {
        super(context);
    }

    public AQuery(View view)
    {
        super(view);
    }
}
