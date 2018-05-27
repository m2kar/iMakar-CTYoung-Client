// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.adapter;

import android.content.Context;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.ImageView;

// Referenced classes of package com.realtech_inc.andproject.chinanet.adapter:
//            DrawerOptions

public class DrawerOptionAdapter extends BaseAdapter
{

    public DrawerOptionAdapter(Context context, int i, DrawerOptions draweroptions)
    {
        mContext = context;
        mResource = Integer.valueOf(i);
        mDatas = draweroptions;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount()
    {
        return DrawerOptions.TITLES.length;
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if(view == null || view.getTag() == null)
        {
            viewgroup = mDatas.getNewHolder();
            view = mInflater.inflate(mResource.intValue(), null);
            viewgroup.imageView = (ImageView)view.findViewById(0x7f080075);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (DrawerOptions.ViewHolder)view.getTag();
        }
        ((DrawerOptions.ViewHolder) (viewgroup)).imageView.setImageResource(DrawerOptions.RESID[i]);
        return view;
    }

    private final Context mContext;
    private final DrawerOptions mDatas;
    private final LayoutInflater mInflater;
    private final Integer mResource;
}
