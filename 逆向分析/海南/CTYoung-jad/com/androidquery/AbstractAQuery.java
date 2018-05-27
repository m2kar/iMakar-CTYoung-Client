// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spanned;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.*;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.callback.ImageOptions;
import com.androidquery.callback.Transformer;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.Constants;
import com.androidquery.util.WebImage;
import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.channels.FileChannel;
import java.util.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;

public abstract class AbstractAQuery
    implements Constants
{

    public AbstractAQuery(Activity activity)
    {
        act = activity;
    }

    public AbstractAQuery(Activity activity, View view1)
    {
        root = view1;
        view = view1;
        act = activity;
    }

    public AbstractAQuery(Context context1)
    {
        context = context1;
    }

    public AbstractAQuery(View view1)
    {
        root = view1;
        view = view1;
    }

    private View findView(int i)
    {
        View view1 = null;
        if(root != null)
            view1 = root.findViewById(i);
        else
        if(act != null)
            return act.findViewById(i);
        return view1;
    }

    private View findView(String s)
    {
        Object obj = null;
        View view1;
        if(root != null)
        {
            view1 = root.findViewWithTag(s);
        } else
        {
            view1 = obj;
            if(act != null)
            {
                View view2 = ((ViewGroup)act.findViewById(0x1020002)).getChildAt(0);
                view1 = obj;
                if(view2 != null)
                    return view2.findViewWithTag(s);
            }
        }
        return view1;
    }

    private transient View findView(int ai[])
    {
        View view1 = findView(ai[0]);
        for(int i = 1; i < ai.length && view1 != null; i++)
            view1 = view1.findViewById(ai[i]);

        return view1;
    }

    private Constructor getConstructor()
    {
        if(constructor == null)
            try
            {
                constructor = getClass().getConstructor(new Class[] {
                    android/view/View
                });
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        return constructor;
    }

    private AbstractAQuery self()
    {
        return this;
    }

    private Common setScrollListener()
    {
        AbsListView abslistview = (AbsListView)view;
        Common common1 = (Common)abslistview.getTag(0x40ff0002);
        Common common = common1;
        if(common1 == null)
        {
            common = new Common();
            abslistview.setOnScrollListener(common);
            abslistview.setTag(0x40ff0002, common);
            AQUtility.debug("set scroll listenr");
        }
        return common;
    }

    private void size(boolean flag, int i, boolean flag1)
    {
        if(view != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            Context context1 = getContext();
            int j = i;
            if(i > 0)
            {
                j = i;
                if(flag1)
                    j = AQUtility.dip2pixel(context1, i);
            }
            if(flag)
                layoutparams.width = j;
            else
                layoutparams.height = j;
            view.setLayoutParams(layoutparams);
        }
    }

    public AbstractAQuery adapter(Adapter adapter1)
    {
        if(view instanceof AdapterView)
            ((AdapterView)view).setAdapter(adapter1);
        return self();
    }

    public AbstractAQuery adapter(ExpandableListAdapter expandablelistadapter)
    {
        if(view instanceof ExpandableListView)
            ((ExpandableListView)view).setAdapter(expandablelistadapter);
        return self();
    }

    public AbstractAQuery ajax(AjaxCallback ajaxcallback)
    {
        return invoke(ajaxcallback);
    }

    public AbstractAQuery ajax(String s, Class class1, long l, AjaxCallback ajaxcallback)
    {
        ((AjaxCallback)((AjaxCallback)((AjaxCallback)ajaxcallback.type(class1)).url(s)).fileCache(true)).expire(l);
        return ajax(ajaxcallback);
    }

    public AbstractAQuery ajax(String s, Class class1, long l, Object obj, String s1)
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ((AjaxCallback)((AjaxCallback)((AjaxCallback)ajaxcallback.type(class1)).weakHandler(obj, s1)).fileCache(true)).expire(l);
        return ajax(s, class1, ajaxcallback);
    }

    public AbstractAQuery ajax(String s, Class class1, AjaxCallback ajaxcallback)
    {
        ((AjaxCallback)ajaxcallback.type(class1)).url(s);
        return ajax(ajaxcallback);
    }

    public AbstractAQuery ajax(String s, Class class1, Object obj, String s1)
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ((AjaxCallback)ajaxcallback.type(class1)).weakHandler(obj, s1);
        return ajax(s, class1, ajaxcallback);
    }

    public AbstractAQuery ajax(String s, Map map, Class class1, AjaxCallback ajaxcallback)
    {
        ((AjaxCallback)((AjaxCallback)ajaxcallback.type(class1)).url(s)).params(map);
        return ajax(ajaxcallback);
    }

    public AbstractAQuery ajax(String s, Map map, Class class1, Object obj, String s1)
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ((AjaxCallback)ajaxcallback.type(class1)).weakHandler(obj, s1);
        return ajax(s, map, class1, ajaxcallback);
    }

    public AbstractAQuery ajaxCancel()
    {
        AjaxCallback.cancel();
        return self();
    }

    public AbstractAQuery animate(int i)
    {
        return animate(i, null);
    }

    public AbstractAQuery animate(int i, android.view.animation.Animation.AnimationListener animationlistener)
    {
        Animation animation = AnimationUtils.loadAnimation(getContext(), i);
        animation.setAnimationListener(animationlistener);
        return animate(animation);
    }

    public AbstractAQuery animate(Animation animation)
    {
        if(view != null && animation != null)
            view.startAnimation(animation);
        return self();
    }

    public AbstractAQuery auth(AccountHandle accounthandle)
    {
        ah = accounthandle;
        return self();
    }

    public AbstractAQuery background(int i)
    {
        if(view != null)
            if(i != 0)
                view.setBackgroundResource(i);
            else
                view.setBackgroundDrawable(null);
        return self();
    }

    public AbstractAQuery backgroundColor(int i)
    {
        if(view != null)
            view.setBackgroundColor(i);
        return self();
    }

    public AbstractAQuery cache(String s, long l)
    {
        return ajax(s, [B, l, null, null);
    }

    public AbstractAQuery checked(boolean flag)
    {
        if(view instanceof CompoundButton)
            ((CompoundButton)view).setChecked(flag);
        return self();
    }

    public AbstractAQuery clear()
    {
        if(view == null) goto _L2; else goto _L1
_L1:
        if(!(view instanceof ImageView)) goto _L4; else goto _L3
_L3:
        ImageView imageview = (ImageView)view;
        imageview.setImageBitmap(null);
        imageview.setTag(0x40ff0001, null);
_L2:
        return self();
_L4:
        if(view instanceof WebView)
        {
            WebView webview = (WebView)view;
            webview.stopLoading();
            webview.clearView();
            webview.setTag(0x40ff0001, null);
        } else
        if(view instanceof TextView)
            ((TextView)view).setText("");
        if(true) goto _L2; else goto _L5
_L5:
    }

    public AbstractAQuery click()
    {
        if(view != null)
            view.performClick();
        return self();
    }

    public AbstractAQuery clickable(boolean flag)
    {
        if(view != null)
            view.setClickable(flag);
        return self();
    }

    public AbstractAQuery clicked(android.view.View.OnClickListener onclicklistener)
    {
        if(view != null)
            view.setOnClickListener(onclicklistener);
        return self();
    }

    public AbstractAQuery clicked(Object obj, String s)
    {
        return clicked(((android.view.View.OnClickListener) ((new Common()).forward(obj, s, true, ON_CLICK_SIG))));
    }

    protected AbstractAQuery create(View view1)
    {
        View view2 = null;
        try
        {
            view1 = (AbstractAQuery)getConstructor().newInstance(new Object[] {
                view1
            });
        }
        // Misplaced declaration of an exception variable
        catch(View view1)
        {
            view1.printStackTrace();
            return view2;
        }
        view2 = view1;
        view1.act = act;
        return view1;
    }

    public AbstractAQuery dataChanged()
    {
        if(view instanceof AdapterView)
        {
            Adapter adapter1 = ((AdapterView)view).getAdapter();
            if(adapter1 instanceof BaseAdapter)
                ((BaseAdapter)adapter1).notifyDataSetChanged();
        }
        return self();
    }

    public AbstractAQuery delete(String s, Class class1, AjaxCallback ajaxcallback)
    {
        ((AjaxCallback)((AjaxCallback)ajaxcallback.url(s)).type(class1)).method(2);
        return ajax(ajaxcallback);
    }

    public AbstractAQuery delete(String s, Class class1, Object obj, String s1)
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ajaxcallback.weakHandler(obj, s1);
        return delete(s, class1, ajaxcallback);
    }

    public AbstractAQuery dismiss()
    {
        Iterator iterator = dialogs.keySet().iterator();
        while(iterator.hasNext()) 
        {
            Dialog dialog = (Dialog)iterator.next();
            try
            {
                dialog.dismiss();
            }
            catch(Exception exception) { }
            iterator.remove();
        }
        return self();
    }

    public AbstractAQuery dismiss(Dialog dialog)
    {
        if(dialog != null)
            try
            {
                dialogs.remove(dialog);
                dialog.dismiss();
            }
            // Misplaced declaration of an exception variable
            catch(Dialog dialog) { }
        return self();
    }

    public AbstractAQuery download(String s, File file, AjaxCallback ajaxcallback)
    {
        ((AjaxCallback)((AjaxCallback)ajaxcallback.url(s)).type(java/io/File)).targetFile(file);
        return ajax(ajaxcallback);
    }

    public AbstractAQuery download(String s, File file, Object obj, String s1)
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ajaxcallback.weakHandler(obj, s1);
        return download(s, file, ajaxcallback);
    }

    public AbstractAQuery enabled(boolean flag)
    {
        if(view != null)
            view.setEnabled(flag);
        return self();
    }

    public AbstractAQuery expand(int i, boolean flag)
    {
        if(view instanceof ExpandableListView)
        {
            ExpandableListView expandablelistview = (ExpandableListView)view;
            if(flag)
                expandablelistview.expandGroup(i);
            else
                expandablelistview.collapseGroup(i);
        }
        return self();
    }

    public AbstractAQuery expand(boolean flag)
    {
        if(view instanceof ExpandableListView)
        {
            ExpandableListView expandablelistview = (ExpandableListView)view;
            ExpandableListAdapter expandablelistadapter = expandablelistview.getExpandableListAdapter();
            if(expandablelistadapter != null)
            {
                int j = expandablelistadapter.getGroupCount();
                int i = 0;
                while(i < j) 
                {
                    if(flag)
                        expandablelistview.expandGroup(i);
                    else
                        expandablelistview.collapseGroup(i);
                    i++;
                }
            }
        }
        return self();
    }

    public AbstractAQuery find(int i)
    {
        return create(findView(i));
    }

    public Button getButton()
    {
        return (Button)view;
    }

    public File getCachedFile(String s)
    {
        File file1 = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(getContext(), 1), s);
        File file = file1;
        if(file1 == null)
            file = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(getContext(), 0), s);
        return file;
    }

    public Bitmap getCachedImage(int i)
    {
        return BitmapAjaxCallback.getMemoryCached(getContext(), i);
    }

    public Bitmap getCachedImage(String s)
    {
        return getCachedImage(s, 0);
    }

    public Bitmap getCachedImage(String s, int i)
    {
        Bitmap bitmap1 = BitmapAjaxCallback.getMemoryCached(s, i);
        Bitmap bitmap = bitmap1;
        if(bitmap1 == null)
        {
            s = getCachedFile(s);
            bitmap = bitmap1;
            if(s != null)
                bitmap = BitmapAjaxCallback.getResizedImage(s.getAbsolutePath(), null, i, true, 0);
        }
        return bitmap;
    }

    public CheckBox getCheckBox()
    {
        return (CheckBox)view;
    }

    public Context getContext()
    {
        if(act != null)
            return act;
        if(root != null)
            return root.getContext();
        else
            return context;
    }

    public EditText getEditText()
    {
        return (EditText)view;
    }

    public Editable getEditable()
    {
        Editable editable = null;
        if(view instanceof EditText)
            editable = ((EditText)view).getEditableText();
        return editable;
    }

    public ExpandableListView getExpandableListView()
    {
        return (ExpandableListView)view;
    }

    public Gallery getGallery()
    {
        return (Gallery)view;
    }

    public GridView getGridView()
    {
        return (GridView)view;
    }

    public ImageView getImageView()
    {
        return (ImageView)view;
    }

    public ListView getListView()
    {
        return (ListView)view;
    }

    public ProgressBar getProgressBar()
    {
        return (ProgressBar)view;
    }

    public RatingBar getRatingBar()
    {
        return (RatingBar)view;
    }

    public SeekBar getSeekBar()
    {
        return (SeekBar)view;
    }

    public Object getSelectedItem()
    {
        Object obj = null;
        if(view instanceof AdapterView)
            obj = ((AdapterView)view).getSelectedItem();
        return obj;
    }

    public int getSelectedItemPosition()
    {
        int i = -1;
        if(view instanceof AdapterView)
            i = ((AdapterView)view).getSelectedItemPosition();
        return i;
    }

    public Spinner getSpinner()
    {
        return (Spinner)view;
    }

    public Object getTag()
    {
        Object obj = null;
        if(view != null)
            obj = view.getTag();
        return obj;
    }

    public Object getTag(int i)
    {
        Object obj = null;
        if(view != null)
            obj = view.getTag(i);
        return obj;
    }

    public CharSequence getText()
    {
        CharSequence charsequence = null;
        if(view instanceof TextView)
            charsequence = ((TextView)view).getText();
        return charsequence;
    }

    public TextView getTextView()
    {
        return (TextView)view;
    }

    public View getView()
    {
        return view;
    }

    public WebView getWebView()
    {
        return (WebView)view;
    }

    public AbstractAQuery gone()
    {
        return visibility(8);
    }

    public AbstractAQuery hardwareAccelerated11()
    {
        if(act != null)
            act.getWindow().setFlags(0x1000000, 0x1000000);
        return self();
    }

    public AbstractAQuery height(int i)
    {
        size(false, i, true);
        return self();
    }

    public AbstractAQuery height(int i, boolean flag)
    {
        size(false, i, flag);
        return self();
    }

    public AbstractAQuery id(int i)
    {
        return id(findView(i));
    }

    public AbstractAQuery id(View view1)
    {
        view = view1;
        reset();
        return self();
    }

    public AbstractAQuery id(String s)
    {
        return id(findView(s));
    }

    public transient AbstractAQuery id(int ai[])
    {
        return id(findView(ai));
    }

    public AbstractAQuery image(int i)
    {
        if(view instanceof ImageView)
        {
            ImageView imageview = (ImageView)view;
            imageview.setTag(0x40ff0001, null);
            if(i == 0)
                imageview.setImageBitmap(null);
            else
                imageview.setImageResource(i);
        }
        return self();
    }

    public AbstractAQuery image(Bitmap bitmap)
    {
        if(view instanceof ImageView)
        {
            ImageView imageview = (ImageView)view;
            imageview.setTag(0x40ff0001, null);
            imageview.setImageBitmap(bitmap);
        }
        return self();
    }

    public AbstractAQuery image(Bitmap bitmap, float f)
    {
        BitmapAjaxCallback bitmapajaxcallback = new BitmapAjaxCallback();
        bitmapajaxcallback.ratio(f).bitmap(bitmap);
        return image(bitmapajaxcallback);
    }

    public AbstractAQuery image(Drawable drawable)
    {
        if(view instanceof ImageView)
        {
            ImageView imageview = (ImageView)view;
            imageview.setTag(0x40ff0001, null);
            imageview.setImageDrawable(drawable);
        }
        return self();
    }

    public AbstractAQuery image(BitmapAjaxCallback bitmapajaxcallback)
    {
        if(view instanceof ImageView)
        {
            bitmapajaxcallback.imageView((ImageView)view);
            invoke(bitmapajaxcallback);
        }
        return self();
    }

    public AbstractAQuery image(File file, int i)
    {
        return image(file, true, i, null);
    }

    public AbstractAQuery image(File file, boolean flag, int i, BitmapAjaxCallback bitmapajaxcallback)
    {
        BitmapAjaxCallback bitmapajaxcallback1 = bitmapajaxcallback;
        if(bitmapajaxcallback == null)
            bitmapajaxcallback1 = new BitmapAjaxCallback();
        bitmapajaxcallback1.file(file);
        bitmapajaxcallback = null;
        if(file != null)
            bitmapajaxcallback = file.getAbsolutePath();
        return image(((String) (bitmapajaxcallback)), flag, true, i, 0, bitmapajaxcallback1);
    }

    public AbstractAQuery image(String s)
    {
        return image(s, true, true, 0, 0);
    }

    public AbstractAQuery image(String s, ImageOptions imageoptions)
    {
        return image(s, imageoptions, ((String) (null)));
    }

    protected AbstractAQuery image(String s, ImageOptions imageoptions, String s1)
    {
        if(view instanceof ImageView)
        {
            BitmapAjaxCallback.async(act, getContext(), (ImageView)view, s, progress, ah, imageoptions, proxy, s1);
            reset();
        }
        return self();
    }

    public AbstractAQuery image(String s, boolean flag, boolean flag1)
    {
        return image(s, flag, flag1, 0, 0);
    }

    public AbstractAQuery image(String s, boolean flag, boolean flag1, int i, int j)
    {
        return image(s, flag, flag1, i, j, null, 0);
    }

    public AbstractAQuery image(String s, boolean flag, boolean flag1, int i, int j, Bitmap bitmap, int k)
    {
        return image(s, flag, flag1, i, j, bitmap, k, 0.0F);
    }

    public AbstractAQuery image(String s, boolean flag, boolean flag1, int i, int j, Bitmap bitmap, int k, 
            float f)
    {
        return image(s, flag, flag1, i, j, bitmap, k, f, 0, null);
    }

    protected AbstractAQuery image(String s, boolean flag, boolean flag1, int i, int j, Bitmap bitmap, int k, 
            float f, int l, String s1)
    {
        if(view instanceof ImageView)
        {
            BitmapAjaxCallback.async(act, getContext(), (ImageView)view, s, flag, flag1, i, j, bitmap, k, f, 3.402823E+038F, progress, ah, policy.intValue(), l, proxy, s1);
            reset();
        }
        return self();
    }

    public AbstractAQuery image(String s, boolean flag, boolean flag1, int i, int j, BitmapAjaxCallback bitmapajaxcallback)
    {
        ((BitmapAjaxCallback)((BitmapAjaxCallback)bitmapajaxcallback.targetWidth(i).fallback(j).url(s)).memCache(flag)).fileCache(flag1);
        return image(bitmapajaxcallback);
    }

    public View inflate(View view1, int i, ViewGroup viewgroup)
    {
        if(view1 != null)
        {
            Integer integer = (Integer)view1.getTag(0x40ff0003);
            if(integer != null && integer.intValue() == i)
                return view1;
        }
        if(act != null)
            view1 = act.getLayoutInflater();
        else
            view1 = (LayoutInflater)getContext().getSystemService("layout_inflater");
        view1 = view1.inflate(i, viewgroup, false);
        view1.setTag(0x40ff0003, Integer.valueOf(i));
        return view1;
    }

    public AbstractAQuery invalidate(String s)
    {
        s = getCachedFile(s);
        if(s != null)
            s.delete();
        return self();
    }

    public AbstractAQuery invisible()
    {
        return visibility(4);
    }

    protected AbstractAQuery invoke(AbstractAjaxCallback abstractajaxcallback)
    {
        if(ah != null)
            abstractajaxcallback.auth(ah);
        if(progress != null)
            abstractajaxcallback.progress(progress);
        if(trans != null)
            abstractajaxcallback.transformer(trans);
        if(policy != null)
            abstractajaxcallback.policy(policy.intValue());
        if(proxy != null)
            abstractajaxcallback.proxy(proxy.getHostName(), proxy.getPort());
        if(act != null)
            abstractajaxcallback.async(act);
        else
            abstractajaxcallback.async(getContext());
        reset();
        return self();
    }

    public transient Object invoke(String s, Class aclass[], Object aobj[])
    {
        View view1 = view;
        Object obj = view1;
        if(view1 == null)
            obj = act;
        return AQUtility.invokeHandler(obj, s, false, false, aclass, aobj);
    }

    public boolean isChecked()
    {
        boolean flag = false;
        if(view instanceof CompoundButton)
            flag = ((CompoundButton)view).isChecked();
        return flag;
    }

    public boolean isExist()
    {
        return view != null;
    }

    public AbstractAQuery itemClicked(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        if(view instanceof AdapterView)
            ((AdapterView)view).setOnItemClickListener(onitemclicklistener);
        return self();
    }

    public AbstractAQuery itemClicked(Object obj, String s)
    {
        return itemClicked(((android.widget.AdapterView.OnItemClickListener) ((new Common()).forward(obj, s, true, ON_ITEM_SIG))));
    }

    public AbstractAQuery itemSelected(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
    {
        if(view instanceof AdapterView)
            ((AdapterView)view).setOnItemSelectedListener(onitemselectedlistener);
        return self();
    }

    public AbstractAQuery itemSelected(Object obj, String s)
    {
        return itemSelected(((android.widget.AdapterView.OnItemSelectedListener) ((new Common()).forward(obj, s, true, ON_ITEM_SIG))));
    }

    public AbstractAQuery longClick()
    {
        if(view != null)
            view.performLongClick();
        return self();
    }

    public AbstractAQuery longClicked(android.view.View.OnLongClickListener onlongclicklistener)
    {
        if(view != null)
            view.setOnLongClickListener(onlongclicklistener);
        return self();
    }

    public AbstractAQuery longClicked(Object obj, String s)
    {
        return longClicked(((android.view.View.OnLongClickListener) ((new Common()).forward(obj, s, true, ON_CLICK_SIG))));
    }

    public File makeSharedFile(String s, String s1)
    {
        FileOutputStream fileoutputstream = null;
        s = getCachedFile(s);
        if(s == null) goto _L2; else goto _L1
_L1:
        Object obj = AQUtility.getTempDir();
        if(obj == null) goto _L2; else goto _L3
_L3:
        s1 = new File(((File) (obj)), s1);
        FileChannel filechannel;
        s1.createNewFile();
        s = new FileInputStream(s);
        fileoutputstream = new FileOutputStream(s1);
        obj = s.getChannel();
        filechannel = fileoutputstream.getChannel();
        ((FileChannel) (obj)).transferTo(0L, ((FileChannel) (obj)).size(), filechannel);
        AQUtility.close(s);
        AQUtility.close(fileoutputstream);
        AQUtility.close(((java.io.Closeable) (obj)));
        AQUtility.close(filechannel);
        return s1;
        Exception exception;
        exception;
        try
        {
            AQUtility.close(s);
            AQUtility.close(fileoutputstream);
            AQUtility.close(((java.io.Closeable) (obj)));
            AQUtility.close(filechannel);
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch(String s) { }
_L4:
        AQUtility.debug(s);
        return s1;
        s;
        s1 = fileoutputstream;
        if(true) goto _L4; else goto _L2
_L2:
        return null;
    }

    public AbstractAQuery margin(float f, float f1, float f2, float f3)
    {
        if(view != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            if(layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
            {
                Context context1 = getContext();
                int i = AQUtility.dip2pixel(context1, f);
                int j = AQUtility.dip2pixel(context1, f1);
                int k = AQUtility.dip2pixel(context1, f2);
                int l = AQUtility.dip2pixel(context1, f3);
                ((android.view.ViewGroup.MarginLayoutParams)layoutparams).setMargins(i, j, k, l);
                view.setLayoutParams(layoutparams);
            }
        }
        return self();
    }

    public AbstractAQuery overridePendingTransition5(int i, int j)
    {
        if(act != null)
            AQUtility.invokeHandler(act, "overridePendingTransition", false, false, PENDING_TRANSITION_SIG, new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
        return self();
    }

    public AbstractAQuery parent(int i)
    {
        Object obj;
        Object obj1;
        obj = view;
        obj1 = null;
_L7:
        View view1 = obj1;
        if(obj == null) goto _L2; else goto _L1
_L1:
        if(((View) (obj)).getId() != i) goto _L4; else goto _L3
_L3:
        view1 = ((View) (obj));
_L2:
        return create(view1);
_L4:
        obj = ((View) (obj)).getParent();
        view1 = obj1;
        if(!(obj instanceof View)) goto _L2; else goto _L5
_L5:
        obj = (View)obj;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public AbstractAQuery policy(int i)
    {
        policy = Integer.valueOf(i);
        return self();
    }

    public AbstractAQuery progress(int i)
    {
        progress = findView(i);
        return self();
    }

    public AbstractAQuery progress(Dialog dialog)
    {
        progress = dialog;
        return self();
    }

    public AbstractAQuery progress(Object obj)
    {
        progress = obj;
        return self();
    }

    public AbstractAQuery proxy(String s, int i)
    {
        proxy = new HttpHost(s, i);
        return self();
    }

    public AbstractAQuery put(String s, String s1, HttpEntity httpentity, Class class1, AjaxCallback ajaxcallback)
    {
        ((AjaxCallback)((AjaxCallback)((AjaxCallback)((AjaxCallback)ajaxcallback.url(s)).type(class1)).method(3)).header("Content-Type", s1)).param("%entity", httpentity);
        return ajax(ajaxcallback);
    }

    public AbstractAQuery rating(float f)
    {
        if(view instanceof RatingBar)
            ((RatingBar)view).setRating(f);
        return self();
    }

    public AbstractAQuery recycle(View view1)
    {
        root = view1;
        view = view1;
        reset();
        context = null;
        return self();
    }

    protected void reset()
    {
        ah = null;
        progress = null;
        trans = null;
        policy = Integer.valueOf(0);
        proxy = null;
    }

    public AbstractAQuery scrolled(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        if(view instanceof AbsListView)
            setScrollListener().forward(onscrolllistener);
        return self();
    }

    public AbstractAQuery scrolledBottom(Object obj, String s)
    {
        if(view instanceof AbsListView)
            setScrollListener().forward(obj, s, true, ON_SCROLLED_STATE_SIG);
        return self();
    }

    public AbstractAQuery setLayerType11(int i, Paint paint)
    {
        if(view != null)
            AQUtility.invokeHandler(view, "setLayerType", false, false, LAYER_TYPE_SIG, new Object[] {
                Integer.valueOf(i), paint
            });
        return self();
    }

    public AbstractAQuery setOverScrollMode9(int i)
    {
        if(view instanceof AbsListView)
            AQUtility.invokeHandler(view, "setOverScrollMode", false, false, OVER_SCROLL_SIG, new Object[] {
                Integer.valueOf(i)
            });
        return self();
    }

    public AbstractAQuery setSelection(int i)
    {
        if(view instanceof AdapterView)
            ((AdapterView)view).setSelection(i);
        return self();
    }

    public boolean shouldDelay(int i, int j, boolean flag, View view1, ViewGroup viewgroup, String s)
    {
        return Common.shouldDelay(i, j, view1, viewgroup, s);
    }

    public boolean shouldDelay(int i, View view1, ViewGroup viewgroup, String s)
    {
        if(viewgroup instanceof ExpandableListView)
            throw new IllegalArgumentException("Please use the other shouldDelay methods for expandable list.");
        else
            return Common.shouldDelay(i, view1, viewgroup, s);
    }

    public boolean shouldDelay(int i, boolean flag, View view1, ViewGroup viewgroup, String s)
    {
        return Common.shouldDelay(i, -1, view1, viewgroup, s);
    }

    public boolean shouldDelay(View view1, ViewGroup viewgroup, String s, float f)
    {
        return Common.shouldDelay(view1, viewgroup, s, f, true);
    }

    public boolean shouldDelay(View view1, ViewGroup viewgroup, String s, float f, boolean flag)
    {
        return Common.shouldDelay(view1, viewgroup, s, f, flag);
    }

    public AbstractAQuery show(Dialog dialog)
    {
        if(dialog != null)
            try
            {
                dialog.show();
                dialogs.put(dialog, null);
            }
            // Misplaced declaration of an exception variable
            catch(Dialog dialog) { }
        return self();
    }

    public AbstractAQuery sync(AjaxCallback ajaxcallback)
    {
        ajax(ajaxcallback);
        ajaxcallback.block();
        return self();
    }

    public AbstractAQuery tag(int i, Object obj)
    {
        if(view != null)
            view.setTag(i, obj);
        return self();
    }

    public AbstractAQuery tag(Object obj)
    {
        if(view != null)
            view.setTag(obj);
        return self();
    }

    public AbstractAQuery text(int i)
    {
        if(view instanceof TextView)
            ((TextView)view).setText(i);
        return self();
    }

    public transient AbstractAQuery text(int i, Object aobj[])
    {
        Context context1 = getContext();
        if(context1 != null)
            text(((CharSequence) (context1.getString(i, aobj))));
        return self();
    }

    public AbstractAQuery text(Spanned spanned)
    {
        if(view instanceof TextView)
            ((TextView)view).setText(spanned);
        return self();
    }

    public AbstractAQuery text(CharSequence charsequence)
    {
        if(view instanceof TextView)
            ((TextView)view).setText(charsequence);
        return self();
    }

    public AbstractAQuery text(CharSequence charsequence, boolean flag)
    {
        if(flag && (charsequence == null || charsequence.length() == 0))
            return gone();
        else
            return text(charsequence);
    }

    public AbstractAQuery textChanged(Object obj, String s)
    {
        if(view instanceof TextView)
            ((TextView)view).addTextChangedListener((new Common()).forward(obj, s, true, TEXT_CHANGE_SIG));
        return self();
    }

    public AbstractAQuery textColor(int i)
    {
        if(view instanceof TextView)
            ((TextView)view).setTextColor(i);
        return self();
    }

    public AbstractAQuery textSize(float f)
    {
        if(view instanceof TextView)
            ((TextView)view).setTextSize(f);
        return self();
    }

    public AbstractAQuery transformer(Transformer transformer1)
    {
        trans = transformer1;
        return self();
    }

    public AbstractAQuery transparent(boolean flag)
    {
        if(view != null)
            AQUtility.transparent(view, flag);
        return self();
    }

    public AbstractAQuery typeface(Typeface typeface1)
    {
        if(view instanceof TextView)
            ((TextView)view).setTypeface(typeface1);
        return self();
    }

    public AbstractAQuery visibility(int i)
    {
        if(view != null && view.getVisibility() != i)
            view.setVisibility(i);
        return self();
    }

    public AbstractAQuery visible()
    {
        return visibility(0);
    }

    public AbstractAQuery webImage(String s)
    {
        return webImage(s, true, false, 0xff000000);
    }

    public AbstractAQuery webImage(String s, boolean flag, boolean flag1, int i)
    {
        if(view instanceof WebView)
        {
            setLayerType11(1, null);
            (new WebImage((WebView)view, s, progress, flag, flag1, i)).load();
            progress = null;
        }
        return self();
    }

    public AbstractAQuery width(int i)
    {
        size(true, i, true);
        return self();
    }

    public AbstractAQuery width(int i, boolean flag)
    {
        size(true, i, flag);
        return self();
    }

    private static Class LAYER_TYPE_SIG[];
    private static final Class ON_CLICK_SIG[] = {
        android/view/View
    };
    private static Class ON_ITEM_SIG[];
    private static Class ON_SCROLLED_STATE_SIG[];
    private static final Class OVER_SCROLL_SIG[];
    private static Class PENDING_TRANSITION_SIG[];
    private static final Class TEXT_CHANGE_SIG[];
    private static WeakHashMap dialogs = new WeakHashMap();
    private Activity act;
    protected AccountHandle ah;
    private Constructor constructor;
    private Context context;
    private Integer policy;
    protected Object progress;
    private HttpHost proxy;
    private View root;
    private Transformer trans;
    protected View view;

    static 
    {
        ON_ITEM_SIG = (new Class[] {
            android/widget/AdapterView, android/view/View, Integer.TYPE, Long.TYPE
        });
        ON_SCROLLED_STATE_SIG = (new Class[] {
            android/widget/AbsListView, Integer.TYPE
        });
        TEXT_CHANGE_SIG = (new Class[] {
            java/lang/CharSequence, Integer.TYPE, Integer.TYPE, Integer.TYPE
        });
        PENDING_TRANSITION_SIG = (new Class[] {
            Integer.TYPE, Integer.TYPE
        });
        OVER_SCROLL_SIG = (new Class[] {
            Integer.TYPE
        });
        LAYER_TYPE_SIG = (new Class[] {
            Integer.TYPE, android/graphics/Paint
        });
    }
}
