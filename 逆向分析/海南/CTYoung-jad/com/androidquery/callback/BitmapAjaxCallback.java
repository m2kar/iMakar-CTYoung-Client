// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.callback;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.ExifInterface;
import android.view.View;
import android.view.animation.*;
import android.widget.ImageView;
import com.androidquery.auth.AccountHandle;
import com.androidquery.util.*;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.*;
import org.apache.http.HttpHost;

// Referenced classes of package com.androidquery.callback:
//            AbstractAjaxCallback, ImageOptions, AjaxStatus

public class BitmapAjaxCallback extends AbstractAjaxCallback
{

    public BitmapAjaxCallback()
    {
        targetDim = true;
        anchor = 3.402823E+038F;
        ((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)type(android/graphics/Bitmap)).memCache(true)).fileCache(true)).url("");
    }

    private void addQueue(String s, ImageView imageview)
    {
        WeakHashMap weakhashmap = (WeakHashMap)queueMap.get(s);
        if(weakhashmap == null)
        {
            if(queueMap.containsKey(s))
            {
                weakhashmap = new WeakHashMap();
                weakhashmap.put(imageview, this);
                queueMap.put(s, weakhashmap);
                return;
            } else
            {
                queueMap.put(s, null);
                return;
            }
        } else
        {
            weakhashmap.put(imageview, this);
            return;
        }
    }

    public static void async(Activity activity, Context context, ImageView imageview, String s, Object obj, AccountHandle accounthandle, ImageOptions imageoptions, HttpHost httphost, 
            String s1)
    {
        async(activity, context, imageview, s, imageoptions.memCache, imageoptions.fileCache, imageoptions.targetWidth, imageoptions.fallback, imageoptions.preset, imageoptions.animation, imageoptions.ratio, imageoptions.anchor, obj, accounthandle, imageoptions.policy, imageoptions.round, httphost, s1);
    }

    public static void async(Activity activity, Context context, ImageView imageview, String s, boolean flag, boolean flag1, int i, int j, 
            Bitmap bitmap1, int k, float f, float f1, Object obj, AccountHandle accounthandle, int l, 
            int i1, HttpHost httphost, String s1)
    {
        Object obj1 = null;
        if(flag)
            obj1 = memGet(s, i, i1);
        if(obj1 != null)
        {
            imageview.setTag(0x40ff0001, s);
            Common.showProgress(obj, s, false);
            setBmAnimate(imageview, ((Bitmap) (obj1)), bitmap1, j, k, f, f1, 4);
            return;
        }
        obj1 = new BitmapAjaxCallback();
        ((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback) (obj1)).url(s)).imageView(imageview).memCache(flag)).fileCache(flag1)).targetWidth(i).fallback(j).preset(bitmap1).animation(k).ratio(f).anchor(f1).progress(obj)).auth(accounthandle)).policy(l)).round(i1).networkUrl(s1);
        if(httphost != null)
            ((BitmapAjaxCallback) (obj1)).proxy(httphost.getHostName(), httphost.getPort());
        if(activity != null)
        {
            ((BitmapAjaxCallback) (obj1)).async(activity);
            return;
        } else
        {
            ((BitmapAjaxCallback) (obj1)).async(context);
            return;
        }
    }

    private Bitmap bmGet(String s, byte abyte0[])
    {
        return getResizedImage(s, abyte0, targetWidth, targetDim, round, rotate);
    }

    private void checkCb(BitmapAjaxCallback bitmapajaxcallback, String s, ImageView imageview, Bitmap bitmap1, AjaxStatus ajaxstatus)
    {
        if(imageview == null || bitmapajaxcallback == null)
            return;
        if(s.equals(imageview.getTag(0x40ff0001)))
            if(imageview instanceof ImageView)
                bitmapajaxcallback.callback(s, imageview, bitmap1, ajaxstatus);
            else
                bitmapajaxcallback.setBitmap(s, imageview, bitmap1, false);
        bitmapajaxcallback.showProgress(false);
    }

    public static void clearCache()
    {
        bigCache = null;
        smallCache = null;
        invalidCache = null;
    }

    protected static void clearTasks()
    {
        queueMap.clear();
    }

    private static Bitmap decode(String s, byte abyte0[], android.graphics.BitmapFactory.Options options, boolean flag)
    {
        Bitmap bitmap1 = null;
        if(s == null) goto _L2; else goto _L1
_L1:
        bitmap1 = decodeFile(s, options, flag);
_L4:
        if(bitmap1 == null && options != null && !options.inJustDecodeBounds)
            AQUtility.debug("decode image failed", s);
        return bitmap1;
_L2:
        if(abyte0 != null)
            bitmap1 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static Bitmap decodeFile(String s, android.graphics.BitmapFactory.Options options, boolean flag)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj4 = null;
        obj2 = null;
        obj1 = options;
        if(options == null)
            obj1 = new android.graphics.BitmapFactory.Options();
        obj1.inInputShareable = true;
        obj1.inPurgeable = true;
        options = null;
        obj3 = null;
        Object obj = new FileInputStream(s);
        options = obj4;
        obj1 = BitmapFactory.decodeFileDescriptor(((FileInputStream) (obj)).getFD(), null, ((android.graphics.BitmapFactory.Options) (obj1)));
        options = ((android.graphics.BitmapFactory.Options) (obj1));
        if(obj1 == null)
            break MISSING_BLOCK_LABEL_90;
        options = ((android.graphics.BitmapFactory.Options) (obj1));
        if(!flag)
            break MISSING_BLOCK_LABEL_90;
        options = ((android.graphics.BitmapFactory.Options) (obj1));
        s = rotate(s, ((Bitmap) (obj1)));
        options = s;
        AQUtility.close(((java.io.Closeable) (obj)));
        return options;
        obj;
        obj1 = obj2;
        s = obj3;
_L4:
        options = s;
        AQUtility.report(((Throwable) (obj)));
        AQUtility.close(s);
        return ((Bitmap) (obj1));
        s;
_L2:
        AQUtility.close(options);
        throw s;
        s;
        options = ((android.graphics.BitmapFactory.Options) (obj));
        if(true) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        ioexception;
        s = ((String) (obj));
        obj = ioexception;
        ioexception = options;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean fadeIn(int i, int j)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = flag1;
        i;
        JVM INSTR tableswitch -3 -1: default 32
    //                   -3 36
    //                   -2 43
    //                   -1 34;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if(j == 3) goto _L4; else goto _L3
_L3:
        if(j == 1)
            return true;
        if(true) goto _L1; else goto _L5
_L5:
    }

    private static Bitmap filter(View view, Bitmap bitmap1, int i)
    {
        Bitmap bitmap2 = bitmap1;
        if(bitmap1 != null)
        {
            bitmap2 = bitmap1;
            if(bitmap1.getWidth() == 1)
            {
                bitmap2 = bitmap1;
                if(bitmap1.getHeight() == 1)
                {
                    bitmap2 = bitmap1;
                    if(bitmap1 != empty)
                        bitmap2 = null;
                }
            }
        }
        if(bitmap2 != null)
        {
            view.setVisibility(0);
        } else
        {
            if(i == -2)
            {
                view.setVisibility(8);
                return bitmap2;
            }
            if(i == -1)
            {
                view.setVisibility(4);
                return bitmap2;
            }
        }
        return bitmap2;
    }

    private static Map getBCache()
    {
        if(bigCache == null)
            bigCache = Collections.synchronizedMap(new BitmapCache(BIG_MAX, BIG_PIXELS, BIG_TPIXELS));
        return bigCache;
    }

    public static Bitmap getEmptyBitmap()
    {
        return empty;
    }

    private Bitmap getFallback()
    {
        Bitmap bitmap1 = null;
        View view = (View)v.get();
        if(view != null)
        {
            String s = Integer.toString(fallback);
            Bitmap bitmap2 = memGet(s);
            bitmap1 = bitmap2;
            if(bitmap2 == null)
            {
                Bitmap bitmap3 = BitmapFactory.decodeResource(view.getResources(), fallback);
                bitmap1 = bitmap3;
                if(bitmap3 != null)
                {
                    memPut(s, bitmap3);
                    bitmap1 = bitmap3;
                }
            }
        }
        return bitmap1;
    }

    private static Map getICache()
    {
        if(invalidCache == null)
            invalidCache = Collections.synchronizedMap(new BitmapCache(100, BIG_PIXELS, 0x3d090));
        return invalidCache;
    }

    private static String getKey(String s, int i, int j)
    {
        String s1 = s;
        if(i > 0)
            s1 = (new StringBuilder()).append(s).append("#").append(i).toString();
        s = s1;
        if(j > 0)
            s = (new StringBuilder()).append(s1).append("#").append(j).toString();
        return s;
    }

    public static Bitmap getMemoryCached(Context context, int i)
    {
        String s = Integer.toString(i);
        Bitmap bitmap1 = memGet(s, 0, 0);
        Object obj = bitmap1;
        if(bitmap1 == null)
        {
            context = BitmapFactory.decodeResource(context.getResources(), i);
            obj = context;
            if(context != null)
            {
                memPut(s, 0, 0, context, false);
                obj = context;
            }
        }
        return ((Bitmap) (obj));
    }

    public static Bitmap getMemoryCached(String s, int i)
    {
        return memGet(s, i, 0);
    }

    public static Bitmap getResizedImage(String s, byte abyte0[], int i, boolean flag, int j)
    {
        return getResizedImage(s, abyte0, i, flag, j, false);
    }

    public static Bitmap getResizedImage(String s, byte abyte0[], int i, boolean flag, int j, boolean flag1)
    {
        if(s == null && abyte0 == null)
        {
            abyte0 = null;
        } else
        {
            android.graphics.BitmapFactory.Options options = null;
            if(i > 0)
            {
                options = new android.graphics.BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                decode(s, abyte0, options, flag1);
                int l = options.outWidth;
                int k = l;
                if(!flag)
                    k = Math.max(l, options.outHeight);
                i = sampleSize(k, i);
                options = new android.graphics.BitmapFactory.Options();
                options.inSampleSize = i;
            }
            Object obj = null;
            try
            {
                s = decode(s, abyte0, options, flag1);
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                clearCache();
                AQUtility.report(s);
                s = obj;
            }
            abyte0 = s;
            if(j > 0)
                return getRoundedCornerBitmap(s, j);
        }
        return abyte0;
    }

    private static Matrix getRotateMatrix(int i)
    {
        Matrix matrix = new Matrix();
        switch(i)
        {
        default:
            return matrix;

        case 2: // '\002'
            matrix.setScale(-1F, 1.0F);
            return matrix;

        case 3: // '\003'
            matrix.setRotate(180F);
            return matrix;

        case 4: // '\004'
            matrix.setRotate(180F);
            matrix.postScale(-1F, 1.0F);
            return matrix;

        case 5: // '\005'
            matrix.setRotate(90F);
            matrix.postScale(-1F, 1.0F);
            return matrix;

        case 6: // '\006'
            matrix.setRotate(90F);
            return matrix;

        case 7: // '\007'
            matrix.setRotate(-90F);
            matrix.postScale(-1F, 1.0F);
            return matrix;

        case 8: // '\b'
            matrix.setRotate(-90F);
            break;
        }
        return matrix;
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap bitmap1, int i)
    {
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight());
        RectF rectf = new RectF(rect);
        float f = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff424242);
        canvas.drawRoundRect(rectf, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap1, rect, rect, paint);
        return bitmap2;
    }

    private static Map getSCache()
    {
        if(smallCache == null)
            smallCache = Collections.synchronizedMap(new BitmapCache(SMALL_MAX, SMALL_PIXELS, 0x3d090));
        return smallCache;
    }

    public static boolean isMemoryCached(String s)
    {
        return getBCache().containsKey(s) || getSCache().containsKey(s) || getICache().containsKey(s);
    }

    private static Drawable makeDrawable(ImageView imageview, Bitmap bitmap1, float f, float f1)
    {
        if(f > 0.0F)
            return new RatioDrawable(imageview.getResources(), bitmap1, imageview, f, f1);
        else
            return new BitmapDrawable(imageview.getResources(), bitmap1);
    }

    private static Bitmap memGet(String s, int i, int j)
    {
        String s1 = getKey(s, i, j);
        Object obj = (Bitmap)getBCache().get(s1);
        s = ((String) (obj));
        if(obj == null)
            s = (Bitmap)getSCache().get(s1);
        obj = s;
        if(s == null)
        {
            s = (Bitmap)getICache().get(s1);
            obj = s;
            if(s != null)
            {
                obj = s;
                if(getLastStatus() == 200)
                {
                    invalidCache = null;
                    obj = null;
                }
            }
        }
        return ((Bitmap) (obj));
    }

    private static void memPut(String s, int i, int j, Bitmap bitmap1, boolean flag)
    {
        if(bitmap1 != null)
        {
            int k = bitmap1.getWidth();
            int l = bitmap1.getHeight();
            Map map;
            if(flag)
                map = getICache();
            else
            if(k * l <= SMALL_PIXELS)
                map = getSCache();
            else
                map = getBCache();
            if(i > 0 || j > 0)
            {
                map.put(getKey(s, i, j), bitmap1);
                if(!map.containsKey(s))
                {
                    map.put(s, null);
                    return;
                }
            } else
            {
                map.put(s, bitmap1);
                return;
            }
        }
    }

    private void presetBitmap(String s, ImageView imageview)
    {
label0:
        {
            if(!s.equals(imageview.getTag(0x40ff0001)) || preset != null)
            {
                imageview.setTag(0x40ff0001, s);
                if(preset == null || cacheAvailable(imageview.getContext()))
                    break label0;
                setBitmap(s, imageview, preset, true);
            }
            return;
        }
        setBitmap(s, imageview, null, true);
    }

    private static Bitmap rotate(String s, Bitmap bitmap1)
    {
        if(bitmap1 != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        int i;
        Bitmap bitmap2;
        bitmap2 = bitmap1;
        i = 1;
        int j = (new ExifInterface(s)).getAttributeInt("Orientation", 1);
        i = j;
_L5:
        s = bitmap2;
        if(i > 0)
        {
            s = getRotateMatrix(i);
            Bitmap bitmap3 = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getWidth(), bitmap1.getHeight(), s, true);
            AQUtility.debug("before", (new StringBuilder()).append(bitmap1.getWidth()).append(":").append(bitmap1.getHeight()).toString());
            AQUtility.debug("after", (new StringBuilder()).append(bitmap3.getWidth()).append(":").append(bitmap3.getHeight()).toString());
            s = bitmap3;
            if(bitmap1 != bitmap3)
            {
                bitmap1.recycle();
                return bitmap3;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
        s;
        AQUtility.debug(s);
          goto _L5
    }

    private static int sampleSize(int i, int j)
    {
        int k = 1;
        boolean flag = false;
        int l = i;
        i = ((flag) ? 1 : 0);
        do
        {
            if(i >= 10 || l < j * 2)
                return k;
            l /= 2;
            k *= 2;
            i++;
        } while(true);
    }

    private void setBitmap(String s, ImageView imageview, Bitmap bitmap1, boolean flag)
    {
        if(bitmap1 == null)
        {
            imageview.setImageDrawable(null);
        } else
        {
            if(flag)
            {
                imageview.setImageDrawable(makeDrawable(imageview, bitmap1, ratio, anchor));
                return;
            }
            if(status != null)
            {
                setBmAnimate(imageview, bitmap1, preset, fallback, animation, ratio, anchor, status.getSource());
                return;
            }
        }
    }

    private static void setBmAnimate(ImageView imageview, Bitmap bitmap1, Bitmap bitmap2, int i, int j, float f, float f1, int k)
    {
        bitmap1 = filter(imageview, bitmap1, i);
        if(bitmap1 == null)
        {
            imageview.setImageBitmap(null);
            return;
        }
        Drawable drawable = makeDrawable(imageview, bitmap1, f, f1);
        bitmap1 = null;
        if(fadeIn(j, k))
        {
            if(bitmap2 == null)
            {
                bitmap1 = new AlphaAnimation(0.0F, 1.0F);
                bitmap1.setInterpolator(new DecelerateInterpolator());
                bitmap1.setDuration(300L);
                bitmap2 = drawable;
            } else
            {
                bitmap2 = new TransitionDrawable(new Drawable[] {
                    makeDrawable(imageview, bitmap2, f, f1), drawable
                });
                bitmap2.setCrossFadeEnabled(true);
                bitmap2.startTransition(300);
            }
        } else
        {
            bitmap2 = drawable;
            if(j > 0)
            {
                bitmap1 = AnimationUtils.loadAnimation(imageview.getContext(), j);
                bitmap2 = drawable;
            }
        }
        imageview.setImageDrawable(bitmap2);
        if(bitmap1 != null)
        {
            bitmap1.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            imageview.startAnimation(bitmap1);
            return;
        } else
        {
            imageview.setAnimation(null);
            return;
        }
    }

    public static void setCacheLimit(int i)
    {
        BIG_MAX = i;
        clearCache();
    }

    public static void setDelayWrite(boolean flag)
    {
        DELAY_WRITE = flag;
    }

    public static void setIconCacheLimit(int i)
    {
        SMALL_MAX = i;
        clearCache();
    }

    public static void setMaxPixelLimit(int i)
    {
        BIG_TPIXELS = i;
        clearCache();
    }

    public static void setPixelLimit(int i)
    {
        BIG_PIXELS = i;
        clearCache();
    }

    public static void setSmallPixel(int i)
    {
        SMALL_PIXELS = i;
        clearCache();
    }

    protected File accessFile(File file1, String s)
    {
        if(imageFile != null && imageFile.exists())
            return imageFile;
        else
            return super.accessFile(file1, s);
    }

    public BitmapAjaxCallback anchor(float f)
    {
        anchor = f;
        return this;
    }

    public BitmapAjaxCallback animation(int i)
    {
        animation = i;
        return this;
    }

    public void async(Context context)
    {
        context = getUrl();
        ImageView imageview = (ImageView)v.get();
        if(context == null)
        {
            showProgress(false);
            setBitmap(context, imageview, null, false);
            return;
        }
        Bitmap bitmap1 = memGet(context);
        if(bitmap1 != null)
        {
            imageview.setTag(0x40ff0001, context);
            status = (new AjaxStatus()).source(4).done();
            callback(context, bitmap1, status);
            return;
        }
        presetBitmap(context, imageview);
        if(!queueMap.containsKey(context))
        {
            addQueue(context, imageview);
            super.async(imageview.getContext());
            return;
        } else
        {
            showProgress(true);
            addQueue(context, imageview);
            return;
        }
    }

    public BitmapAjaxCallback bitmap(Bitmap bitmap1)
    {
        bm = bitmap1;
        return this;
    }

    public final void callback(String s, Bitmap bitmap1, AjaxStatus ajaxstatus)
    {
        ImageView imageview = (ImageView)v.get();
        WeakHashMap weakhashmap = (WeakHashMap)queueMap.remove(s);
        if(weakhashmap == null || !weakhashmap.containsKey(imageview))
            checkCb(this, s, imageview, bitmap1, ajaxstatus);
        if(weakhashmap != null)
        {
            ImageView imageview1;
            BitmapAjaxCallback bitmapajaxcallback;
            for(Iterator iterator = weakhashmap.keySet().iterator(); iterator.hasNext(); checkCb(bitmapajaxcallback, s, imageview1, bitmap1, ajaxstatus))
            {
                imageview1 = (ImageView)iterator.next();
                bitmapajaxcallback = (BitmapAjaxCallback)weakhashmap.get(imageview1);
                bitmapajaxcallback.status = ajaxstatus;
            }

        }
    }

    protected void callback(String s, ImageView imageview, Bitmap bitmap1, AjaxStatus ajaxstatus)
    {
        setBitmap(s, imageview, bitmap1, false);
    }

    public volatile void callback(String s, Object obj, AjaxStatus ajaxstatus)
    {
        callback(s, (Bitmap)obj, ajaxstatus);
    }

    public BitmapAjaxCallback fallback(int i)
    {
        fallback = i;
        return this;
    }

    public BitmapAjaxCallback file(File file1)
    {
        imageFile = file1;
        return this;
    }

    protected Bitmap fileGet(String s, File file1, AjaxStatus ajaxstatus)
    {
        return bmGet(file1.getAbsolutePath(), null);
    }

    protected volatile Object fileGet(String s, File file1, AjaxStatus ajaxstatus)
    {
        return fileGet(s, file1, ajaxstatus);
    }

    public BitmapAjaxCallback imageView(ImageView imageview)
    {
        v = new WeakReference(imageview);
        return this;
    }

    protected boolean isStreamingContent()
    {
        return !DELAY_WRITE;
    }

    protected Bitmap memGet(String s)
    {
        if(bm != null)
            return bm;
        if(!memCache)
            return null;
        else
            return memGet(s, targetWidth, round);
    }

    protected volatile Object memGet(String s)
    {
        return memGet(s);
    }

    protected void memPut(String s, Bitmap bitmap1)
    {
        memPut(s, targetWidth, round, bitmap1, invalid);
    }

    protected volatile void memPut(String s, Object obj)
    {
        memPut(s, (Bitmap)obj);
    }

    public BitmapAjaxCallback preset(Bitmap bitmap1)
    {
        preset = bitmap1;
        return this;
    }

    public BitmapAjaxCallback ratio(float f)
    {
        ratio = f;
        return this;
    }

    public BitmapAjaxCallback rotate(boolean flag)
    {
        rotate = flag;
        return this;
    }

    public BitmapAjaxCallback round(int i)
    {
        round = i;
        return this;
    }

    protected void skip(String s, Bitmap bitmap1, AjaxStatus ajaxstatus)
    {
        queueMap.remove(s);
    }

    protected volatile void skip(String s, Object obj, AjaxStatus ajaxstatus)
    {
        skip(s, (Bitmap)obj, ajaxstatus);
    }

    public BitmapAjaxCallback targetWidth(int i)
    {
        targetWidth = i;
        return this;
    }

    public Bitmap transform(String s, byte abyte0[], AjaxStatus ajaxstatus)
    {
        s = null;
        File file1 = ajaxstatus.getFile();
        if(file1 != null)
            s = file1.getAbsolutePath();
        s = bmGet(s, abyte0);
        abyte0 = s;
        if(s != null) goto _L2; else goto _L1
_L1:
        if(fallback <= 0) goto _L4; else goto _L3
_L3:
        s = getFallback();
_L6:
        abyte0 = s;
        if(ajaxstatus.getCode() != 200)
        {
            invalid = true;
            abyte0 = s;
        }
_L2:
        return abyte0;
_L4:
        if(fallback == -2 || fallback == -1)
            s = dummy;
        else
        if(fallback == -3)
            s = preset;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public volatile Object transform(String s, byte abyte0[], AjaxStatus ajaxstatus)
    {
        return transform(s, abyte0, ajaxstatus);
    }

    private static int BIG_MAX = 0;
    private static int BIG_PIXELS = 0;
    private static int BIG_TPIXELS = 0;
    private static boolean DELAY_WRITE = false;
    private static final int FADE_DUR = 300;
    private static int SMALL_MAX = 20;
    private static int SMALL_PIXELS = 2500;
    private static Map bigCache;
    private static Bitmap dummy;
    private static Bitmap empty;
    private static Map invalidCache;
    private static HashMap queueMap = new HashMap();
    private static Map smallCache;
    private float anchor;
    private int animation;
    private Bitmap bm;
    private int fallback;
    private File imageFile;
    private boolean invalid;
    private Bitmap preset;
    private float ratio;
    private boolean rotate;
    private int round;
    private boolean targetDim;
    private int targetWidth;
    private WeakReference v;

    static 
    {
        BIG_MAX = 20;
        BIG_PIXELS = 0x27100;
        BIG_TPIXELS = 0xf4240;
        DELAY_WRITE = false;
        empty = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ALPHA_8);
        dummy = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ALPHA_8);
    }
}
