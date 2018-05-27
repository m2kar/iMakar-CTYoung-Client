// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.networks;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.XmlDom;
import com.realtech_inc.andproject.chinanet.activity.LogonActivity;
import com.realtech_inc.andproject.chinanet.constant.Constant;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;
import java.io.*;
import java.net.*;
import java.util.HashMap;

// Referenced classes of package com.realtech_inc.andproject.chinanet.networks:
//            LogoffManager

public class UpdateManager
{
    private class downloadApkThread extends Thread
    {

        public void run()
        {
            if(!Environment.getExternalStorageState().equals("mounted")) goto _L2; else goto _L1
_L1:
            int j;
            Object obj;
            Object obj2;
            obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").toString();
            mSavePath = (new StringBuilder()).append(((String) (obj))).append("download").toString();
            obj = (HttpURLConnection)(new URL((String)mHashMap.get("url"))).openConnection();
            ((HttpURLConnection) (obj)).connect();
            j = ((HttpURLConnection) (obj)).getContentLength();
            obj = ((HttpURLConnection) (obj)).getInputStream();
            obj2 = new File(mSavePath);
            if(!((File) (obj2)).exists())
                ((File) (obj2)).mkdir();
            obj2 = new FileOutputStream(new File(mSavePath, (String)mHashMap.get("name")));
            int i = 0;
            byte abyte0[] = new byte[1024];
_L6:
            int k = ((InputStream) (obj)).read(abyte0);
            i += k;
            progress = (int)(((float)i / (float)j) * 100F);
            mHandler.sendEmptyMessage(1);
            if(k > 0) goto _L4; else goto _L3
_L3:
            mHandler.sendEmptyMessage(2);
_L5:
            ((FileOutputStream) (obj2)).close();
            ((InputStream) (obj)).close();
_L2:
            mDownloadDialog.dismiss();
            return;
_L4:
            boolean flag;
            ((FileOutputStream) (obj2)).write(abyte0, 0, k);
            flag = cancelUpdate;
            if(!flag) goto _L6; else goto _L5
            Object obj1;
            obj1;
            ((MalformedURLException) (obj1)).printStackTrace();
              goto _L2
            obj1;
            ((IOException) (obj1)).printStackTrace();
              goto _L2
        }

        final UpdateManager this$0;

        private downloadApkThread()
        {
            this$0 = UpdateManager.this;
            super();
        }

    }


    public UpdateManager()
    {
        cancelUpdate = false;
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                switch(message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    mProgress.setProgress(progress);
                    return;

                case 2: // '\002'
                    installApk();
                    break;
                }
            }

            final UpdateManager this$0;

            
            {
                this$0 = UpdateManager.this;
                super();
            }
        }
;
    }

    private void downloadApk()
    {
        (new downloadApkThread()).start();
    }

    public static UpdateManager getInstance()
    {
        if(mInstance == null)
            mInstance = new UpdateManager();
        return mInstance;
    }

    private int getVersionCode(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            context.printStackTrace();
            return 0;
        }
        return i;
    }

    private void installApk()
    {
        logoff();
        File file = new File(mSavePath, (String)mHashMap.get("name"));
        if(!file.exists())
        {
            return;
        } else
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse((new StringBuilder()).append("file://").append(file.toString()).toString()), "application/vnd.android.package-archive");
            mContext.startActivity(intent);
            ((Activity)mContext).finish();
            return;
        }
    }

    private void logoff()
    {
        LogoffManager.getInstance().startLogoffForUpdate(SPM.getData("LastLogoffUrl", Constant.URL_LOGOFF), SPM.getData("LastLogoffUuid", ""), SPM.getData("LastLogoffUserIp", ""));
    }

    private void showDownloadDialog()
    {
        RelativeLayout relativelayout = (RelativeLayout)LayoutInflater.from(mContext).inflate(0x7f030027, null);
        mDownloadDialog = (new android.app.AlertDialog.Builder(mContext)).create();
        mDownloadDialog.setCancelable(false);
        mDownloadDialog.show();
        mDownloadDialog.getWindow().setContentView(relativelayout);
        mProgress = (ProgressBar)relativelayout.findViewById(0x7f080079);
        ((Button)relativelayout.findViewById(0x7f080072)).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                mDownloadDialog.dismiss();
                cancelUpdate = true;
                logoff();
                System.exit(0);
            }

            final UpdateManager this$0;

            
            {
                this$0 = UpdateManager.this;
                super();
            }
        }
);
        downloadApk();
    }

    private void showNoticeDialog()
    {
        Object obj = (RelativeLayout)LayoutInflater.from(mContext).inflate(0x7f030022, null);
        final android.app.AlertDialog noticeDialog = (new android.app.AlertDialog.Builder(mContext)).create();
        noticeDialog.setCancelable(false);
        noticeDialog.show();
        noticeDialog.getWindow().setContentView(((View) (obj)));
        ((TextView)((RelativeLayout) (obj)).findViewById(0x7f08006e)).setText(0x7f0a002e);
        ((TextView)((RelativeLayout) (obj)).findViewById(0x7f080071)).setText(0x7f0a002b);
        Button button = (Button)((RelativeLayout) (obj)).findViewById(0x7f080072);
        button.setText(0x7f0a002f);
        obj = (Button)((RelativeLayout) (obj)).findViewById(0x7f080074);
        ((Button) (obj)).setText(0x7f0a002c);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                noticeDialog.dismiss();
                showDownloadDialog();
            }

            final UpdateManager this$0;
            final Dialog val$noticeDialog;

            
            {
                this$0 = UpdateManager.this;
                noticeDialog = dialog;
                super();
            }
        }
);
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                noticeDialog.dismiss();
                logoff();
                System.exit(0);
            }

            final UpdateManager this$0;
            final Dialog val$noticeDialog;

            
            {
                this$0 = UpdateManager.this;
                noticeDialog = dialog;
                super();
            }
        }
);
    }

    public void checkUpdate()
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ajaxcallback.timeout(5000);
        ((AjaxCallback)((AjaxCallback)ajaxcallback.url("http://hainup.singlenet.cn/android/hainan/chinanet/version.xml")).type(com/androidquery/util/XmlDom)).weakHandler(this, "checkVersionCallback");
        aQuery.ajax(ajaxcallback);
    }

    public void checkUpdateLogon()
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ajaxcallback.timeout(5000);
        ((AjaxCallback)((AjaxCallback)ajaxcallback.url("http://hainup.singlenet.cn/android/hainan/chinanet/version.xml")).type(com/androidquery/util/XmlDom)).weakHandler(this, "checkVersionCallbackLogon");
        aQuery.ajax(ajaxcallback);
    }

    public void checkVersionCallback(String s, XmlDom xmldom, AjaxStatus ajaxstatus)
    {
        mHashMap = new HashMap();
        int i = getVersionCode(mContext);
        if(xmldom != null)
        {
            mHashMap.put("version", xmldom.text("version"));
            mHashMap.put("url", xmldom.text("url"));
            mHashMap.put("name", xmldom.text("name"));
        }
        if(!mHashMap.isEmpty())
        {
            if(Integer.valueOf((String)mHashMap.get("version")).intValue() > i)
            {
                showNoticeDialog();
                return;
            } else
            {
                Toast.makeText(mContext, 0x7f0a002d, 1).show();
                s = new Intent(mContext, com/realtech_inc/andproject/chinanet/activity/LogonActivity);
                s.addFlags(0x4000000);
                mContext.startActivity(s);
                ((Activity)mContext).finish();
                return;
            }
        } else
        {
            s = new Intent(mContext, com/realtech_inc/andproject/chinanet/activity/LogonActivity);
            s.addFlags(0x4000000);
            mContext.startActivity(s);
            ((Activity)mContext).finish();
            return;
        }
    }

    public void checkVersionCallbackLogon(String s, XmlDom xmldom, AjaxStatus ajaxstatus)
    {
        mHashMap = new HashMap();
        int i = getVersionCode(mContext);
        if(xmldom != null)
        {
            mHashMap.put("version", xmldom.text("version"));
            mHashMap.put("url", xmldom.text("url"));
            mHashMap.put("name", xmldom.text("name"));
        }
        if(!mHashMap.isEmpty() && Integer.valueOf((String)mHashMap.get("version")).intValue() > i)
            showNoticeDialog();
    }

    public void init(Context context, AQuery aquery)
    {
        mContext = context;
        aQuery = aquery;
    }

    private static final int DOWNLOAD = 1;
    private static final int DOWNLOAD_FINISH = 2;
    private static final SharedPrefsManager SPM = SharedPrefsManager.getInstance();
    private static UpdateManager mInstance;
    private AQuery aQuery;
    private boolean cancelUpdate;
    private Context mContext;
    private Dialog mDownloadDialog;
    private Handler mHandler;
    HashMap mHashMap;
    private ProgressBar mProgress;
    private String mSavePath;
    private int progress;




/*
    static int access$002(UpdateManager updatemanager, int i)
    {
        updatemanager.progress = i;
        return i;
    }

*/








/*
    static boolean access$602(UpdateManager updatemanager, boolean flag)
    {
        updatemanager.cancelUpdate = flag;
        return flag;
    }

*/



/*
    static String access$802(UpdateManager updatemanager, String s)
    {
        updatemanager.mSavePath = s;
        return s;
    }

*/

}
