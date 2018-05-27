// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import android.graphics.Bitmap;
import java.util.*;

public class BitmapCache extends LinkedHashMap
{

    public BitmapCache(int i, int j, int k)
    {
        super(8, 0.75F, true);
        maxCount = i;
        maxPixels = j;
        maxTotalPixels = k;
    }

    private int pixels(Bitmap bitmap)
    {
        if(bitmap == null)
            return 0;
        else
            return bitmap.getWidth() * bitmap.getHeight();
    }

    private void shrink()
    {
        if(pixels > maxTotalPixels)
        {
            Iterator iterator = keySet().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                iterator.next();
                iterator.remove();
            } while(pixels > maxTotalPixels);
        }
    }

    public void clear()
    {
        super.clear();
        pixels = 0;
    }

    public Bitmap put(String s, Bitmap bitmap)
    {
        String s1 = null;
        int i = pixels(bitmap);
        if(i <= maxPixels)
        {
            pixels = pixels + i;
            s = (Bitmap)super.put(s, bitmap);
            s1 = s;
            if(s != null)
            {
                pixels = pixels - pixels(s);
                s1 = s;
            }
        }
        return s1;
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public Bitmap remove(Object obj)
    {
        obj = (Bitmap)super.remove(obj);
        if(obj != null)
            pixels = pixels - pixels(((Bitmap) (obj)));
        return ((Bitmap) (obj));
    }

    public volatile Object remove(Object obj)
    {
        return remove(obj);
    }

    public boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        if(pixels > maxTotalPixels || size() > maxCount)
            remove(entry.getKey());
        shrink();
        return false;
    }

    private static final long serialVersionUID = 1L;
    private int maxCount;
    private int maxPixels;
    private int maxTotalPixels;
    private int pixels;
}
