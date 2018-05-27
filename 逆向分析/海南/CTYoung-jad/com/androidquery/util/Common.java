// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.androidquery.AQuery;
import com.androidquery.callback.BitmapAjaxCallback;
import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.androidquery.util:
//            AQUtility

public class Common
    implements Comparator, Runnable, android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.AbsListView.OnScrollListener, android.widget.AdapterView.OnItemSelectedListener, TextWatcher
{

    public Common()
    {
        scrollState = 0;
        galleryListen = false;
    }

    private void checkScrolledBottom(AbsListView abslistview, int i)
    {
        int j = abslistview.getCount();
        int k = abslistview.getLastVisiblePosition();
        if(i == 0 && j == k + 1)
        {
            if(k != lastBottom)
            {
                lastBottom = k;
                invoke(new Object[] {
                    abslistview, Integer.valueOf(i)
                });
            }
            return;
        } else
        {
            lastBottom = -1;
            return;
        }
    }

    private transient Object invoke(Object aobj[])
    {
        if(method != null)
        {
            if(params != null)
                aobj = params;
            Object obj1 = handler;
            Object obj = obj1;
            if(obj1 == null)
                obj = this;
            return AQUtility.invokeHandler(obj, method, fallback, true, sig, aobj);
        }
        if(methodId == 0) goto _L2; else goto _L1
_L1:
        methodId;
        JVM INSTR tableswitch 1 2: default 84
    //                   1 125
    //                   2 86;
           goto _L2 _L3 _L4
_L2:
        return null;
_L4:
        AQUtility.cleanCache((File)params[0], ((Long)params[1]).longValue(), ((Long)params[2]).longValue());
        continue; /* Loop/switch isn't completed */
_L3:
        AQUtility.store((File)params[0], (byte[])(byte[])params[1]);
        if(true) goto _L2; else goto _L5
_L5:
    }

    private void onScrollStateChanged(ExpandableListView expandablelistview, int i)
    {
        expandablelistview.setTag(0x40ff0004, Integer.valueOf(i));
        if(i != 0) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        ExpandableListAdapter expandablelistadapter;
        j = expandablelistview.getFirstVisiblePosition();
        k = expandablelistview.getLastVisiblePosition();
        expandablelistadapter = expandablelistview.getExpandableListAdapter();
        i = 0;
_L4:
        while(i <= k - j) 
        {
            long l1 = expandablelistview.getExpandableListPosition(i + j);
            int l = ExpandableListView.getPackedPositionGroup(l1);
            int i1 = ExpandableListView.getPackedPositionChild(l1);
            if(l >= 0)
            {
                View view = expandablelistview.getChildAt(i);
                Long long1 = (Long)view.getTag(0x40ff0004);
                if(long1 != null && long1.longValue() == l1)
                {
                    if(i1 == -1)
                    {
                        expandablelistadapter.getGroupView(l, expandablelistview.isGroupExpanded(l), view, expandablelistview);
                    } else
                    {
                        boolean flag;
                        if(i1 == expandablelistadapter.getChildrenCount(l) - 1)
                            flag = true;
                        else
                            flag = false;
                        expandablelistadapter.getChildView(l, i1, flag, view, expandablelistview);
                    }
                    view.setTag(0x40ff0004, null);
                }
            }
            i++;
        }
_L2:
        return;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void onScrollStateChanged2(AbsListView abslistview, int i)
    {
        abslistview.setTag(0x40ff0004, Integer.valueOf(i));
        if(i == 0)
        {
            int j = abslistview.getFirstVisiblePosition();
            int k = abslistview.getLastVisiblePosition();
            ListAdapter listadapter = (ListAdapter)abslistview.getAdapter();
            for(i = 0; i <= k - j; i++)
            {
                long l = i + j;
                View view = abslistview.getChildAt(i);
                if((Number)view.getTag(0x40ff0004) != null)
                {
                    listadapter.getView((int)l, view, abslistview);
                    view.setTag(0x40ff0004, null);
                }
            }

        }
    }

    public static boolean shouldDelay(int i, int j, View view, ViewGroup viewgroup, String s)
    {
        if(s == null || BitmapAjaxCallback.isMemoryCached(s))
            return false;
        s = (AbsListView)viewgroup;
        if((android.widget.AbsListView.OnScrollListener)viewgroup.getTag(0x40ff0002) == null)
        {
            Common common = new Common();
            s.setOnScrollListener(common);
            viewgroup.setTag(0x40ff0002, common);
        }
        s = (Integer)s.getTag(0x40ff0004);
        if(s == null || s.intValue() == 0 || s.intValue() == 1)
            return false;
        long l = j;
        if(viewgroup instanceof ExpandableListView)
            l = ExpandableListView.getPackedPositionForChild(i, j);
        view.setTag(0x40ff0004, Long.valueOf(l));
        return true;
    }

    public static boolean shouldDelay(int i, View view, ViewGroup viewgroup, String s)
    {
        if(viewgroup instanceof Gallery)
            return shouldDelayGallery(i, view, viewgroup, s);
        else
            return shouldDelay(-2, i, view, viewgroup, s);
    }

    public static boolean shouldDelay(View view, ViewGroup viewgroup, String s, float f, boolean flag)
    {
        return shouldDelay(-1, view, viewgroup, s);
    }

    private static boolean shouldDelayGallery(int i, View view, ViewGroup viewgroup, String s)
    {
        if(s == null || BitmapAjaxCallback.isMemoryCached(s))
            return false;
        Gallery gallery = (Gallery)viewgroup;
        s = (Integer)gallery.getTag(0x40ff0004);
        viewgroup = s;
        if(s == null)
        {
            viewgroup = Integer.valueOf(0);
            gallery.setTag(0x40ff0004, Integer.valueOf(0));
            gallery.setCallbackDuringFling(false);
            (new Common()).listen(gallery);
        }
        int j = gallery.getFirstVisiblePosition();
        j = (gallery.getLastVisiblePosition() - j) / 2 + 1;
        int l = viewgroup.intValue() - j;
        int i1 = viewgroup.intValue() + j;
        int k = l;
        j = i1;
        if(l < 0)
        {
            j = i1 - l;
            k = 0;
        }
        if(i >= k && i <= j)
        {
            view.setTag(0x40ff0004, Integer.valueOf(i));
            return false;
        } else
        {
            view.setTag(0x40ff0004, null);
            return true;
        }
    }

    public static void showProgress(Object obj, String s, boolean flag)
    {
        if(obj == null) goto _L2; else goto _L1
_L1:
        if(!(obj instanceof View)) goto _L4; else goto _L3
_L3:
        ProgressBar progressbar;
        View view;
        view = (View)obj;
        progressbar = null;
        if(obj instanceof ProgressBar)
            progressbar = (ProgressBar)obj;
        if(!flag) goto _L6; else goto _L5
_L5:
        view.setTag(0x40ff0001, s);
        view.setVisibility(0);
        if(progressbar != null)
        {
            progressbar.setProgress(0);
            progressbar.setMax(100);
        }
_L2:
        return;
_L6:
        obj = view.getTag(0x40ff0001);
        if(obj == null || obj.equals(s))
        {
            view.setTag(0x40ff0001, null);
            if(progressbar == null || progressbar.isIndeterminate())
            {
                view.setVisibility(8);
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

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public int compare(File file, File file1)
    {
        long l = file.lastModified();
        long l1 = file1.lastModified();
        if(l1 > l)
            return 1;
        return l1 != l ? -1 : 0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    public Common forward(Object obj, String s, boolean flag, Class aclass[])
    {
        handler = obj;
        method = s;
        fallback = flag;
        sig = aclass;
        return this;
    }

    public void forward(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        osl = onscrolllistener;
    }

    public int getScrollState()
    {
        return scrollState;
    }

    public void listen(Gallery gallery)
    {
        galleryListener = gallery.getOnItemSelectedListener();
        galleryListen = true;
        gallery.setOnItemSelectedListener(this);
    }

    public transient Common method(int i, Object aobj[])
    {
        methodId = i;
        params = aobj;
        return this;
    }

    public void onClick(View view)
    {
        invoke(new Object[] {
            view
        });
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        invoke(new Object[] {
            adapterview, view, Integer.valueOf(i), Long.valueOf(l)
        });
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        invoke(new Object[] {
            adapterview, view, Integer.valueOf(i), Long.valueOf(l)
        });
        if(galleryListener != null)
            galleryListener.onItemSelected(adapterview, view, i, l);
        if(galleryListen && ((Integer)adapterview.getTag(0x40ff0004)).intValue() != i)
        {
            view = adapterview.getAdapter();
            adapterview.setTag(0x40ff0004, Integer.valueOf(i));
            int j = adapterview.getChildCount();
            int k = adapterview.getFirstVisiblePosition();
            i = 0;
            while(i < j) 
            {
                View view1 = adapterview.getChildAt(i);
                int i1 = k + i;
                Integer integer = (Integer)view1.getTag(0x40ff0004);
                if(integer == null || integer.intValue() != i1)
                    view.getView(i1, view1, adapterview);
                i++;
            }
        }
    }

    public boolean onLongClick(View view)
    {
        boolean flag = false;
        view = ((View) (invoke(new Object[] {
            view
        })));
        if(view instanceof Boolean)
            flag = ((Boolean)view).booleanValue();
        return flag;
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        if(galleryListener != null)
            galleryListener.onNothingSelected(adapterview);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        checkScrolledBottom(abslistview, scrollState);
        if(osl != null)
            osl.onScroll(abslistview, i, j, k);
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        scrollState = i;
        checkScrolledBottom(abslistview, i);
        if(abslistview instanceof ExpandableListView)
            onScrollStateChanged((ExpandableListView)abslistview, i);
        else
            onScrollStateChanged2(abslistview, i);
        if(osl != null)
            osl.onScrollStateChanged(abslistview, i);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        invoke(new Object[] {
            charsequence, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
        });
    }

    public void run()
    {
        invoke(new Object[0]);
    }

    protected static final int CLEAN_CACHE = 2;
    protected static final int STORE_FILE = 1;
    private boolean fallback;
    private boolean galleryListen;
    private android.widget.AdapterView.OnItemSelectedListener galleryListener;
    private Object handler;
    private int lastBottom;
    private String method;
    private int methodId;
    private android.widget.AbsListView.OnScrollListener osl;
    private Object params[];
    private int scrollState;
    private Class sig[];
}
