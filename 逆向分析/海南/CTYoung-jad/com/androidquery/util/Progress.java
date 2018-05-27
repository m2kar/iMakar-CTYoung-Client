// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import android.app.*;
import android.view.View;
import android.widget.ProgressBar;
import com.androidquery.AQuery;

// Referenced classes of package com.androidquery.util:
//            AQUtility

public class Progress
    implements Runnable
{

    public Progress(Object obj)
    {
        if(obj instanceof ProgressBar)
        {
            pb = (ProgressBar)obj;
        } else
        {
            if(obj instanceof ProgressDialog)
            {
                pd = (ProgressDialog)obj;
                return;
            }
            if(obj instanceof Activity)
            {
                act = (Activity)obj;
                return;
            }
            if(obj instanceof View)
            {
                view = (View)obj;
                return;
            }
        }
    }

    private void dismiss(String s)
    {
        if(pd != null)
            (new AQuery(pd.getContext())).dismiss(pd);
        if(act != null)
        {
            act.setProgressBarIndeterminateVisibility(false);
            act.setProgressBarVisibility(false);
        }
        if(pb != null)
        {
            pb.setTag(0x40ff0001, s);
            pb.setVisibility(0);
        }
        ProgressBar progressbar = pb;
        Object obj = progressbar;
        if(progressbar == null)
            obj = view;
        if(obj != null)
        {
            Object obj1 = ((View) (obj)).getTag(0x40ff0001);
            if(obj1 == null || obj1.equals(s))
            {
                ((View) (obj)).setTag(0x40ff0001, null);
                if(pb != null && pb.isIndeterminate())
                    ((View) (obj)).setVisibility(8);
            }
        }
    }

    private void showProgress(Object obj, String s, boolean flag)
    {
        if(obj == null) goto _L2; else goto _L1
_L1:
        if(!(obj instanceof View)) goto _L4; else goto _L3
_L3:
        ProgressBar progressbar;
        View view1;
        view1 = (View)obj;
        progressbar = null;
        if(obj instanceof ProgressBar)
            progressbar = (ProgressBar)obj;
        if(!flag) goto _L6; else goto _L5
_L5:
        view1.setTag(0x40ff0001, s);
        view1.setVisibility(0);
        if(progressbar != null)
        {
            progressbar.setProgress(0);
            progressbar.setMax(100);
        }
_L2:
        return;
_L6:
        obj = view1.getTag(0x40ff0001);
        if(obj == null || obj.equals(s))
        {
            view1.setTag(0x40ff0001, null);
            if(progressbar != null && progressbar.isIndeterminate())
            {
                view1.setVisibility(8);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(obj instanceof Dialog)
        {
            obj = (Dialog)obj;
            s = new AQuery(((Dialog) (obj)).getContext());
            if(flag)
            {
                s.show(((Dialog) (obj)));
                return;
            } else
            {
                s.dismiss(((Dialog) (obj)));
                return;
            }
        }
        if(obj instanceof Activity)
        {
            obj = (Activity)obj;
            ((Activity) (obj)).setProgressBarIndeterminateVisibility(flag);
            ((Activity) (obj)).setProgressBarVisibility(flag);
            if(flag)
            {
                ((Activity) (obj)).setProgress(0);
                return;
            }
        }
        if(true) goto _L2; else goto _L7
_L7:
    }

    public void done()
    {
        if(pb != null)
            pb.setProgress(pb.getMax());
        if(pd != null)
            pd.setProgress(pd.getMax());
        if(act != null)
            act.setProgress(9999);
    }

    public void hide(String s)
    {
        if(AQUtility.isUIThread())
        {
            dismiss(s);
            return;
        } else
        {
            url = s;
            AQUtility.post(this);
            return;
        }
    }

    public void increment(int i)
    {
        boolean flag = true;
        int j;
        if(pb != null)
        {
            Object obj = pb;
            if(unknown)
                j = 1;
            else
                j = i;
            ((ProgressBar) (obj)).incrementProgressBy(j);
        }
        if(pd != null)
        {
            obj = pd;
            if(unknown)
                j = ((flag) ? 1 : 0);
            else
                j = i;
            ((ProgressDialog) (obj)).incrementProgressBy(j);
        }
        if(act != null)
        {
            if(unknown)
            {
                i = current;
                current = i + 1;
            } else
            {
                current = current + i;
                i = (current * 10000) / bytes;
            }
            j = i;
            if(i > 9999)
                j = 9999;
            act.setProgress(j);
        }
    }

    public void reset()
    {
        if(pb != null)
        {
            pb.setProgress(0);
            pb.setMax(10000);
        }
        if(pd != null)
        {
            pd.setProgress(0);
            pd.setMax(10000);
        }
        if(act != null)
            act.setProgress(0);
        unknown = false;
        current = 0;
        bytes = 10000;
    }

    public void run()
    {
        dismiss(url);
    }

    public void setBytes(int i)
    {
        int j = i;
        if(i <= 0)
        {
            unknown = true;
            j = 10000;
        }
        bytes = j;
        if(pb != null)
        {
            pb.setProgress(0);
            pb.setMax(j);
        }
        if(pd != null)
        {
            pd.setProgress(0);
            pd.setMax(j);
        }
    }

    public void show(String s)
    {
        reset();
        if(pd != null)
            (new AQuery(pd.getContext())).show(pd);
        if(act != null)
        {
            act.setProgressBarIndeterminateVisibility(true);
            act.setProgressBarVisibility(true);
        }
        if(pb != null)
        {
            pb.setTag(0x40ff0001, s);
            pb.setVisibility(0);
        }
        if(view != null)
        {
            view.setTag(0x40ff0001, s);
            view.setVisibility(0);
        }
    }

    private Activity act;
    private int bytes;
    private int current;
    private ProgressBar pb;
    private ProgressDialog pd;
    private boolean unknown;
    private String url;
    private View view;
}
