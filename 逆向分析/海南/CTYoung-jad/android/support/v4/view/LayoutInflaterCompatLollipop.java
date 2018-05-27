// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.view;

import android.view.LayoutInflater;

// Referenced classes of package android.support.v4.view:
//            LayoutInflaterFactory

class LayoutInflaterCompatLollipop
{

    LayoutInflaterCompatLollipop()
    {
    }

    static void setFactory(LayoutInflater layoutinflater, LayoutInflaterFactory layoutinflaterfactory)
    {
        if(layoutinflaterfactory != null)
            layoutinflaterfactory = new LayoutInflaterCompatHC.FactoryWrapperHC(layoutinflaterfactory);
        else
            layoutinflaterfactory = null;
        layoutinflater.setFactory2(layoutinflaterfactory);
    }
}
