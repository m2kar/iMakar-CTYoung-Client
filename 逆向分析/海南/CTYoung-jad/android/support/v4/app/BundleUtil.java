// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.app;

import android.os.Bundle;
import java.util.Arrays;

class BundleUtil
{

    BundleUtil()
    {
    }

    public static Bundle[] getBundleArrayFromBundle(Bundle bundle, String s)
    {
        Object aobj[] = bundle.getParcelableArray(s);
        if((aobj instanceof Bundle[]) || aobj == null)
        {
            return (Bundle[])(Bundle[])aobj;
        } else
        {
            aobj = (Bundle[])Arrays.copyOf(aobj, aobj.length, [Landroid/os/Bundle;);
            bundle.putParcelableArray(s, ((android.os.Parcelable []) (aobj)));
            return ((Bundle []) (aobj));
        }
    }
}
