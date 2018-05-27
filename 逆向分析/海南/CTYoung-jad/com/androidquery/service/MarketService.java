// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.service;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.pm.*;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import java.util.Locale;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

public class MarketService
{
    private class Handler
        implements android.content.DialogInterface.OnClickListener, android.text.Html.TagHandler
    {

        private void cb(String s, JSONObject jsonobject, AjaxStatus ajaxstatus)
        {
            if(!completed)
            {
                completed = true;
                progress = 0;
                callback(s, jsonobject, ajaxstatus);
            }
        }

        public void detailCb(String s, String s1, AjaxStatus ajaxstatus)
        {
            if(s1 != null && s1.length() > 1000)
            {
                s = getQueryUrl();
                ajaxstatus = new AjaxCallback();
                ((AjaxCallback)((AjaxCallback)ajaxstatus.url(s)).type(org/json/JSONObject)).handler(this, "marketCb");
                ajaxstatus.param("html", s1);
                ((AQuery)aq.progress(progress)).ajax(ajaxstatus);
            }
        }

        public void handleTag(boolean flag, String s, Editable editable, XMLReader xmlreader)
        {
label0:
            {
                if("li".equals(s))
                {
                    if(!flag)
                        break label0;
                    editable.append("  ");
                    editable.append("\u2022");
                    editable.append("  ");
                }
                return;
            }
            editable.append("\n");
        }

        public void marketCb(String s, JSONObject jsonobject, AjaxStatus ajaxstatus)
        {
            if(!act.isFinishing())
                if(jsonobject != null)
                {
                    String s1 = jsonobject.optString("status");
                    if("1".equals(s1))
                    {
                        if(jsonobject.has("dialog"))
                            cb(s, jsonobject, ajaxstatus);
                        if(!fetch && jsonobject.optBoolean("fetch", false) && ajaxstatus.getSource() == 1)
                        {
                            fetch = true;
                            s = jsonobject.optString("marketUrl", null);
                            jsonobject = new AjaxCallback();
                            ((AjaxCallback)((AjaxCallback)jsonobject.url(s)).type(java/lang/String)).handler(this, "detailCb");
                            ((AQuery)aq.progress(progress)).ajax(jsonobject);
                            return;
                        }
                    } else
                    if("0".equals(s1))
                    {
                        ajaxstatus.invalidate();
                        return;
                    } else
                    {
                        cb(s, jsonobject, ajaxstatus);
                        return;
                    }
                } else
                {
                    cb(s, jsonobject, ajaxstatus);
                    return;
                }
        }

        public void onClick(DialogInterface dialoginterface, int i)
        {
            switch(i)
            {
            default:
                return;

            case -1: 
                MarketService.openUrl(act, rateUrl);
                return;

            case -2: 
                MarketService.openUrl(act, updateUrl);
                return;

            case -3: 
                MarketService.setSkipVersion(act, version);
                return;
            }
        }

        final MarketService this$0;

        private Handler()
        {
            this$0 = MarketService.this;
            super();
        }

    }


    public MarketService(Activity activity)
    {
        expire = 0xafc80L;
        level = 0;
        act = activity;
        aq = new AQuery(activity);
        handler = new Handler();
        locale = Locale.getDefault().toString();
        rateUrl = getMarketUrl();
        updateUrl = rateUrl;
    }

    private Drawable getAppIcon()
    {
        return getApplicationInfo().loadIcon(act.getPackageManager());
    }

    private String getAppId()
    {
        return getApplicationInfo().packageName;
    }

    private ApplicationInfo getApplicationInfo()
    {
        if(ai == null)
            ai = act.getApplicationInfo();
        return ai;
    }

    private String getHost()
    {
        return "https://androidquery.appspot.com";
    }

    private String getMarketUrl()
    {
        String s = getAppId();
        return (new StringBuilder()).append("market://details?id=").append(s).toString();
    }

    private PackageInfo getPackageInfo()
    {
        if(pi == null)
            try
            {
                pi = act.getPackageManager().getPackageInfo(getAppId(), 0);
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception.printStackTrace();
            }
        return pi;
    }

    private String getQueryUrl()
    {
        String s = getAppId();
        String s1 = (new StringBuilder()).append(getHost()).append("/api/market?app=").append(s).append("&locale=").append(locale).append("&version=").append(getVersion()).append("&code=").append(getVersionCode()).append("&aq=").append("0.25.9").toString();
        s = s1;
        if(force)
            s = (new StringBuilder()).append(s1).append("&force=true").toString();
        return s;
    }

    private static String getSkipVersion(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("aqs.skip", null);
    }

    private String getVersion()
    {
        return getPackageInfo().versionName;
    }

    private int getVersionCode()
    {
        return getPackageInfo().versionCode;
    }

    private boolean isActive()
    {
        return !act.isFinishing();
    }

    private static boolean openUrl(Activity activity, String s)
    {
        if(s == null)
            return false;
        try
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        // Misplaced declaration of an exception variable
        catch(Activity activity)
        {
            return false;
        }
        return true;
    }

    private boolean outdated(String s, int i)
    {
        if(!s.equals(getSkipVersion(act)))
        {
            String s1 = getVersion();
            int j = getVersionCode();
            if(!s1.equals(s) && j <= i)
                return requireUpdate(s1, s, level);
        }
        return false;
    }

    private static String patchBody(String s)
    {
        return (new StringBuilder()).append("<small>").append(s).append("</small>").toString();
    }

    private boolean requireUpdate(String s, String s1, int i)
    {
        if(!s.equals(s1)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s = s.split("\\.");
        s1 = s1.split("\\.");
        if(s.length < 3 || s1.length < 3)
            return true;
          goto _L3
_L5:
        if(!s[s.length - 1].equals(s1[s1.length - 1]))
            return true;
_L6:
        if(!s[s.length - 2].equals(s1[s1.length - 2]))
            return true;
_L7:
        boolean flag;
        try
        {
            flag = s[s.length - 3].equals(s1[s1.length - 3]);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            AQUtility.report(s);
            return true;
        }
        if(!flag)
            return true;
        continue; /* Loop/switch isn't completed */
_L3:
        i;
        JVM INSTR tableswitch 0 2: default 140
    //                   0 41
    //                   1 61
    //                   2 81;
           goto _L4 _L5 _L6 _L7
_L4:
        return true;
        if(true) goto _L1; else goto _L8
_L8:
    }

    private static void setSkipVersion(Context context, String s)
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("aqs.skip", s).commit();
    }

    protected void callback(String s, JSONObject jsonobject, AjaxStatus ajaxstatus)
    {
        if(jsonobject != null)
        {
            s = jsonobject.optString("version", "0");
            int i = jsonobject.optInt("code", 0);
            AQUtility.debug("version", (new StringBuilder()).append(getVersion()).append("->").append(s).append(":").append(getVersionCode()).append("->").append(i).toString());
            AQUtility.debug("outdated", Boolean.valueOf(outdated(s, i)));
            if(force || outdated(s, i))
            {
                showUpdateDialog(jsonobject);
                return;
            }
        }
    }

    public void checkVersion()
    {
        Object obj = getQueryUrl();
        AjaxCallback ajaxcallback = new AjaxCallback();
        obj = (AjaxCallback)((AjaxCallback)((AjaxCallback)ajaxcallback.url(((String) (obj)))).type(org/json/JSONObject)).handler(handler, "marketCb");
        boolean flag;
        if(!force)
            flag = true;
        else
            flag = false;
        ((AjaxCallback)((AjaxCallback) (obj)).fileCache(flag)).expire(expire);
        ((AQuery)aq.progress(progress)).ajax(ajaxcallback);
    }

    public MarketService expire(long l)
    {
        expire = l;
        return this;
    }

    public MarketService force(boolean flag)
    {
        force = flag;
        return this;
    }

    public MarketService level(int i)
    {
        level = i;
        return this;
    }

    public MarketService locale(String s)
    {
        locale = s;
        return this;
    }

    public MarketService progress(int i)
    {
        progress = i;
        return this;
    }

    public MarketService rateUrl(String s)
    {
        rateUrl = s;
        return this;
    }

    protected void showUpdateDialog(JSONObject jsonobject)
    {
        while(jsonobject == null || version != null || !isActive()) 
            return;
        Object obj = jsonobject.optJSONObject("dialog");
        String s1 = ((JSONObject) (obj)).optString("update", "Update");
        String s2 = ((JSONObject) (obj)).optString("skip", "Skip");
        String s3 = ((JSONObject) (obj)).optString("rate", "Rate");
        String s = ((JSONObject) (obj)).optString("wbody", "");
        obj = ((JSONObject) (obj)).optString("title", "Update Available");
        AQUtility.debug("wbody", s);
        version = jsonobject.optString("version", null);
        jsonobject = getAppIcon();
        jsonobject = (new android.app.AlertDialog.Builder(act)).setIcon(jsonobject).setTitle(((CharSequence) (obj))).setPositiveButton(s3, handler).setNeutralButton(s2, handler).setNegativeButton(s1, handler).create();
        jsonobject.setMessage(Html.fromHtml(patchBody(s), null, handler));
        aq.show(jsonobject);
    }

    public MarketService updateUrl(String s)
    {
        updateUrl = s;
        return this;
    }

    private static final String BULLET = "\u2022";
    public static final int MAJOR = 2;
    public static final int MINOR = 1;
    public static final int REVISION = 0;
    private static final String SKIP_VERSION = "aqs.skip";
    private static ApplicationInfo ai;
    private static PackageInfo pi;
    private Activity act;
    private AQuery aq;
    private boolean completed;
    private long expire;
    private boolean fetch;
    private boolean force;
    private Handler handler;
    private int level;
    private String locale;
    private int progress;
    private String rateUrl;
    private String updateUrl;
    private String version;






/*
    static boolean access$202(MarketService marketservice, boolean flag)
    {
        marketservice.fetch = flag;
        return flag;
    }

*/



/*
    static int access$302(MarketService marketservice, int i)
    {
        marketservice.progress = i;
        return i;
    }

*/




/*
    static boolean access$502(MarketService marketservice, boolean flag)
    {
        marketservice.completed = flag;
        return flag;
    }

*/




}
