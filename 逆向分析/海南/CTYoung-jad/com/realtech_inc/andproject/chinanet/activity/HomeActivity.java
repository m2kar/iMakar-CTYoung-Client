// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.*;
import android.content.*;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import com.actionbarsherlock.app.*;
import com.actionbarsherlock.view.Menu;
import com.androidquery.AQuery;
import com.realtech_inc.andproject.chinanet.constant.Constant;
import com.realtech_inc.andproject.chinanet.fragment.HomeFragment;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;
import com.realtech_inc.andproject.chinanet.networks.LogoffManager;
import com.realtech_inc.andproject.chinanet.networks.UpdateManager;
import com.realtech_inc.andproject.chinanet.networks.interfaces.HttpRequestListener;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import com.xxx.flowerwindow.SDKManager;
import java.util.*;

// Referenced classes of package com.realtech_inc.andproject.chinanet.activity:
//            LogonActivity

public class HomeActivity extends SherlockFragmentActivity
    implements HttpRequestListener
{
    public class ConnectivityChangeReceiver extends BroadcastReceiver
    {

        public void onReceive(Context context1, Intent intent)
        {
            if(isFirst)
            {
                isFirst = false;
                return;
            } else
            {
                Toast.makeText(context1, "\u7F51\u7EDC\u8FDE\u63A5\u53D1\u751F\u53D8\u5316\uFF0C\u8BF7\u7A0D\u540E\u5C1D\u8BD5\u91CD\u65B0\u767B\u5F55", 1).show();
                backToLogonActivity();
                return;
            }
        }

        private boolean isFirst;
        final HomeActivity this$0;

        public ConnectivityChangeReceiver()
        {
            this$0 = HomeActivity.this;
            super();
            isFirst = true;
        }
    }

    public static class HomeAlertDialogFragment extends SherlockDialogFragment
    {

        public static HomeAlertDialogFragment newInstance(int i)
        {
            HomeAlertDialogFragment homealertdialogfragment = new HomeAlertDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            homealertdialogfragment.setArguments(bundle);
            return homealertdialogfragment;
        }

        public Dialog onCreateDialog(Bundle bundle)
        {
label0:
            {
label1:
                {
                    {
                        bundle = new android.app.AlertDialog.Builder(getActivity());
                        int i = getArguments().getInt("position");
                        switch(i)
                        {
                        default:
                            try
                            {
                                bundle.setTitle(getString(0x7f0a0010, new Object[] {
                                    getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName
                                }));
                            }
                            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                            {
                                bundle.setTitle(getString(0x7f0a0010, new Object[] {
                                    ""
                                }));
                            }
                            break;

                        case 1: // '\001'
                            break label1;

                        case 2: // '\002'
                            break label0;
                        }
                    }
                    if(i > 0)
                        bundle.setIcon(0x7f020074).setPositiveButton(0x7f0a0014, new android.content.DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                ((HomeActivity)getActivity()).doPositiveClick();
                            }

                            final HomeAlertDialogFragment this$0;

            
            {
                this$0 = HomeAlertDialogFragment.this;
                super();
            }
                        }
).setNegativeButton(0x7f0a0011, new android.content.DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                ((HomeActivity)getActivity()).doNegativeClick();
                            }

                            final HomeAlertDialogFragment this$0;

            
            {
                this$0 = HomeAlertDialogFragment.this;
                super();
            }
                        }
);
                    else
                        bundle.setNegativeButton(0x7f0a0014, new android.content.DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                ((HomeActivity)getActivity()).doNegativeClick();
                            }

                            final HomeAlertDialogFragment this$0;

            
            {
                this$0 = HomeAlertDialogFragment.this;
                super();
            }
                        }
);
                    return bundle.create();
                }
                HomeActivity.suicide = false;
                bundle.setTitle(0x7f0a0012);
                break MISSING_BLOCK_LABEL_83;
            }
            HomeActivity.suicide = false;
            bundle.setTitle(0x7f0a0013);
            break MISSING_BLOCK_LABEL_83;
        }

        public HomeAlertDialogFragment()
        {
        }
    }


    public HomeActivity()
    {
        handler = new Handler();
        runnable = new Runnable() {

            public void run()
            {
                long l2 = ((new Date()).getTime() - startTimeMillis) / 1000L;
                long l = l2 / 3600L;
                long l1 = (l2 % 3600L) / 60L;
                l2 %= 60L;
                TextView textview = tv_timer;
                StringBuilder stringbuilder = (new StringBuilder()).append("\u5DF2\u8054\u7F51");
                String s;
                if(l <= 9L)
                    s = "0";
                else
                    s = "";
                stringbuilder = stringbuilder.append(s).append(l).append(":");
                if(l1 <= 9L)
                    s = "0";
                else
                    s = "";
                stringbuilder = stringbuilder.append(s).append(l1).append(":");
                if(l2 <= 9L)
                    s = "0";
                else
                    s = "";
                textview.setText(stringbuilder.append(s).append(l2).toString());
                handler.postDelayed(this, 1000L);
            }

            final HomeActivity this$0;

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        }
;
    }

    private void backToLogonActivity()
    {
        SPM.setData("LastLogoffTimeMillis", Long.valueOf(System.currentTimeMillis()));
        Intent intent = new Intent();
        intent.setClass(this, com/realtech_inc/andproject/chinanet/activity/LogonActivity);
        intent.addFlags(0x4000000);
        startActivity(intent);
        finish();
    }

    private void doNegativeClick()
    {
        DebugLog.i(TAG, "Negative click!");
    }

    private void doPositiveClick()
    {
        DebugLog.i(TAG, "Positive click!");
        mLogoffManager.startLogoff(SPM.getData("LastLogoffUrl", Constant.URL_LOGOFF), SPM.getData("LastLogoffUuid", ""), SPM.getData("LastLogoffUserIp", ""), SPM.getData("LastLogoffAcName", ""));
    }

    private void execToast(final Toast toast, final int count)
    {
        (new Timer()).schedule(new TimerTask() {

            public void run()
            {
                toast.show();
                for(int i = count; i < 2;)
                {
                    i++;
                    execToast(toast, i);
                }

            }

            final HomeActivity this$0;
            final int val$count;
            final Toast val$toast;

            
            {
                this$0 = HomeActivity.this;
                toast = toast1;
                count = i;
                super();
            }
        }
, 3000L);
    }

    private String getIP()
    {
        String s = intToIP(((WifiManager)getSystemService("wifi")).getConnectionInfo().getIpAddress());
        DebugLog.d(TAG, (new StringBuilder()).append("getIP: ").append(s).toString());
        return s;
    }

    private void initNotificationBuilder()
    {
        Object obj = new Intent(this, com/realtech_inc/andproject/chinanet/activity/HomeActivity);
        ((Intent) (obj)).addFlags(0x20000000);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0);
        mNoticationBuilder = (new android.support.v4.app.NotificationCompat.Builder(this)).setSmallIcon(0x7f02008f).setContentTitle("\u95EA\u8BAF\u5BA2\u6237\u7AEF").setContentText("\u5DF2\u767B\u9646\u72B6\u6001").setContentIntent(((PendingIntent) (obj)));
    }

    private String intToIP(int i)
    {
        return (new StringBuilder()).append(i & 0xff).append(".").append(i >> 8 & 0xff).append(".").append(i >> 16 & 0xff).append(".").append(i >> 24 & 0xff).toString();
    }

    private boolean networkAvailable()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if(networkinfo != null)
        {
            boolean flag;
            boolean flag1;
            if(networkinfo.getType() == 1)
                flag = true;
            else
                flag = false;
            flag1 = networkinfo.isConnectedOrConnecting();
            DebugLog.d(TAG, (new StringBuilder()).append("isConnectedOrConnecting: ").append(flag1).toString());
            if(flag && flag1)
                return true;
        }
        return false;
    }

    private void setInitialFragment()
    {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(9999, HomeFragment.newInstance()).commit();
    }

    public static void showDialog()
    {
        HomeAlertDialogFragment.newInstance(clickedPosition).show(fragmentManager, "dialog");
    }

    private void showNotification()
    {
        Notification notification = mNoticationBuilder.build();
        notification.flags = notification.flags | 0x10;
        ((NotificationManager)getSystemService("notification")).notify(0x4d29643, notification);
    }

    private void updateNotificationBuilder()
    {
        Object obj = new Intent(this, com/realtech_inc/andproject/chinanet/activity/LogonActivity);
        ((Intent) (obj)).addFlags(0x20000000);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0);
        mNoticationBuilder.setContentText("\u8D26\u6237\u672A\u767B\u5F55").setContentIntent(((PendingIntent) (obj)));
    }

    protected void onCreate(Bundle bundle)
    {
        DebugLog.i(TAG, "onCreate start...");
        setTheme(THEME);
        super.onCreate(bundle);
        context = getApplicationContext();
        suicide = false;
        startTimeMillis = -1L;
        FrameLayout framelayout;
        try
        {
            startTimeMillis = getIntent().getExtras().getLong("startTimeMillis");
        }
        catch(Exception exception)
        {
            DebugLog.e(TAG, "Get 'startTimeMillis' Error: ", exception);
        }
        DebugLog.d(TAG, (new StringBuilder()).append("'startTimeMillis': ").append(startTimeMillis).toString());
        if(-1L == startTimeMillis)
            startTimeMillis = SPM.getData("LastLogonTimeMillis", Long.valueOf(-1L)).longValue();
        DebugLog.d(TAG, (new StringBuilder()).append("'startTimeMillis': ").append(startTimeMillis).toString());
        if(-1L == startTimeMillis || !networkAvailable())
        {
            Intent intent = new Intent();
            intent.setClass(this, com/realtech_inc/andproject/chinanet/activity/LogonActivity);
            intent.addFlags(0x4000000);
            startActivity(intent);
            finish();
        }
        initNotificationBuilder();
        mLogoffManager = LogoffManager.getInstance();
        mLogoffManager.setListener(this);
        mLogoffManager.setAq(new AQuery(this));
        framelayout = new FrameLayout(this);
        framelayout.setId(9999);
        setContentView(framelayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
        if(bundle == null)
            setInitialFragment();
        bundle = LayoutInflater.from(this).inflate(0x7f030015, null);
        tv_timer = (TextView)bundle.findViewById(0x7f080044);
        getSupportActionBar().setCustomView(bundle);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        runnable.run();
        ((ImageView)bundle.findViewById(0x7f080043)).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                doPositiveClick();
            }

            final HomeActivity this$0;

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        }
);
        connectivityChangeReceiver = new ConnectivityChangeReceiver();
        bundle = new IntentFilter();
        bundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(connectivityChangeReceiver, bundle);
        SDKManager.main(context);
        SDKManager.setAppId(context, "hmsW56DPBv4PzOOobn", "f59bd7d315a2343fab2a64985a07545a");
        DebugLog.i(TAG, "onCreate finished");
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    protected void onDestroy()
    {
        DebugLog.i(TAG, "onDestroy...");
        if(logoffalert != null && !logoffalert.equals(""))
        {
            Toast toast = Toast.makeText(context, logoffalert, 1);
            toast.show();
            if("WIFI\u5DF2\u65AD\u5F00\uFF0C\u8BF7\u91CD\u8FDE".equals(logoffalert))
                execToast(toast, 0);
        }
        super.onDestroy();
        unregisterReceiver(connectivityChangeReceiver);
        updateNotificationBuilder();
        showNotification();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if(i == 4)
        {
            if(System.currentTimeMillis() - exitTime > 2000L)
            {
                Toast.makeText(getApplicationContext(), "\u518D\u6309\u4E00\u6B21\u9000\u51FA\u7A0B\u5E8F", 0).show();
                exitTime = System.currentTimeMillis();
                return true;
            } else
            {
                suicide = true;
                mLogoffManager.startLogoff(SPM.getData("LastLogoffUrl", Constant.URL_LOGOFF), SPM.getData("LastLogoffUuid", ""), SPM.getData("LastLogoffUserIp", ""), SPM.getData("LastLogoffAcName", ""));
                return true;
            }
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        DebugLog.i(TAG, "onPause...");
        super.onPause();
        showNotification();
    }

    public void onResponseSuccess()
    {
        logoffalert = "\u4E0B\u7EBF\u6210\u529F";
        if(suicide)
        {
            finish();
            return;
        } else
        {
            backToLogonActivity();
            return;
        }
    }

    public void onResponseWithError(int i)
    {
        DebugLog.e(TAG, (new StringBuilder()).append("Logoff Failed! Error Code: ").append(i).toString());
        logoffalert = "\u975E\u6B63\u5E38\u9000\u51FA\uFF01";
        if(i == 0xc3501)
            logoffalert = (new StringBuilder()).append(logoffalert).append("\uFF08\u7F51\u7EDC\u8BF7\u6C42\u5931\u8D25\uFF0C\u8BF7\u68C0\u67E5\u7F51\u7EDC\uFF09").toString();
        else
        if(i == 0xc3503)
            logoffalert = (new StringBuilder()).append(logoffalert).append("\uFF08\u4E0B\u7EBF\u5931\u8D25\uFF09").toString();
        else
        if(i == 0xc35cc)
            logoffalert = (new StringBuilder()).append(logoffalert).append("WIFI\u5DF2\u65AD\u5F00\uFF0C\u8BF7\u91CD\u8FDE").toString();
        else
            logoffalert = (new StringBuilder()).append(logoffalert).append("\uFF08\u670D\u52A1\u7AEF\u9519\u8BEF\uFF09").toString();
        if(suicide)
        {
            finish();
            return;
        } else
        {
            backToLogonActivity();
            return;
        }
    }

    protected void onResume()
    {
        DebugLog.i(TAG, "onResume...");
        super.onResume();
        ((NotificationManager)getSystemService("notification")).cancel(0x4d29643);
        mLogoffManager.checkNet();
        UpdateManager updatemanager = UpdateManager.getInstance();
        updatemanager.init(this, new AQuery(this));
        updatemanager.checkUpdateLogon();
    }

    protected void onStart()
    {
        DebugLog.i(TAG, "onStart...");
        super.onStart();
    }

    protected void onStop()
    {
        DebugLog.i(TAG, "onStop...");
        super.onStop();
    }

    private static final int CONTENT_VIEW_ID = 9999;
    private static final SharedPrefsManager SPM = SharedPrefsManager.getInstance();
    private static final String TAG = com/realtech_inc/andproject/chinanet/activity/HomeActivity.getSimpleName();
    private static int THEME = 0x7f0b0027;
    public static int clickedPosition;
    private static FragmentManager fragmentManager;
    private static FragmentTransaction fragmentTransaction;
    private static boolean suicide;
    private ConnectivityChangeReceiver connectivityChangeReceiver;
    private Context context;
    private long exitTime;
    Handler handler;
    private String logoffalert;
    private LogoffManager mLogoffManager;
    private android.support.v4.app.NotificationCompat.Builder mNoticationBuilder;
    Runnable runnable;
    private long startTimeMillis;
    private TextView tv_timer;








/*
    static boolean access$502(boolean flag)
    {
        suicide = flag;
        return flag;
    }

*/

}
