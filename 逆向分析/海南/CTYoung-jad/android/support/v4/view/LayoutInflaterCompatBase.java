// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            LayoutInflaterFactory

class LayoutInflaterCompatBase
{
    static class FactoryWrapper
        implements android.view.LayoutInflater.Factory
    {

        public View onCreateView(String s, Context context, AttributeSet attributeset)
        {
            return mDelegateFactory.onCreateView(null, s, context, attributeset);
        }

        public String toString()
        {
            return (new StringBuilder()).append(getClass().getName()).append("{").append(mDelegateFactory).append("}").toString();
        }

        final LayoutInflaterFactory mDelegateFactory;

        FactoryWrapper(LayoutInflaterFactory layoutinflaterfactory)
        {
            mDelegateFactory = layoutinflaterfactory;
        }
    }


    LayoutInflaterCompatBase()
    {
    }

    static void setFactory(LayoutInflater layoutinflater, LayoutInflaterFactory layoutinflaterfactory)
    {
        if(layoutinflaterfactory != null)
            layoutinflaterfactory = new FactoryWrapper(layoutinflaterfactory);
        else
            layoutinflaterfactory = null;
        layoutinflater.setFactory(layoutinflaterfactory);
    }
}
