// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.*;
import android.content.*;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.*;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.*;
import com.androidquery.AQuery;
import com.realtech_inc.andproject.chinanet.constant.Constant;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;
import com.realtech_inc.andproject.chinanet.networks.DevicetypeVerifier;
import com.realtech_inc.andproject.chinanet.networks.LogonManager;
import com.realtech_inc.andproject.chinanet.networks.interfaces.HttpRequestListener;
import com.realtech_inc.andproject.chinanet.utils.*;
import com.singlenet.bsl.AppClient;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.realtech_inc.andproject.chinanet.activity:
//            HomeActivity, AccountManagerActivity, MipcaActivityCapture

public class LogonActivity extends Activity
    implements HttpRequestListener
{
    public class MyCheckBoxChangeListener
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if(compoundbutton.isChecked())
            {
                if(!"".equals(et_password.getText().toString().trim()))
                    LogonActivity.SPM.setData("LastLogonPswd", et_password.getText().toString());
                return;
            } else
            {
                LogonActivity.SPM.removeData("LastLogonPswd");
                return;
            }
        }

        final LogonActivity this$0;

        public MyCheckBoxChangeListener()
        {
            this$0 = LogonActivity.this;
            super();
        }
    }

    public class SmsDeliveredReceiver extends BroadcastReceiver
    {

        public void onReceive(Context context1, Intent intent)
        {
            DebugLog.i(LogonActivity.TAG, "BroadcastReceiver2 Takeover");
            if("DELIVERED_SMS_ACTION".equals(intent.getAction()))
            {
                Toast.makeText(context, getResources().getString(0x7f0a0027), 0).show();
                promptForUser(context.getResources().getString(0x7f0a0041), false);
            }
        }

        final LogonActivity this$0;

        public SmsDeliveredReceiver()
        {
            this$0 = LogonActivity.this;
            super();
        }
    }

    public class SmsReceivedReceiver extends BroadcastReceiver
    {

        public void onReceive(Context context1, Intent intent)
        {
            DebugLog.i(TAG, (new StringBuilder()).append("Intent Recieved: ").append(intent.getAction()).toString());
            if(intent.getAction() == "android.provider.Telephony.SMS_RECEIVED") goto _L2; else goto _L1
_L1:
            DebugLog.d(TAG, (new StringBuilder()).append("Unexpected Intent: ").append(intent.getAction()).toString());
_L4:
            return;
_L2:
            context1 = intent.getExtras();
            if(context1 == null)
            {
                DebugLog.e(TAG, "getExtras() Return null!");
                return;
            }
            context1 = ((Context) ((Object[])(Object[])context1.get("pdus")));
            if(context1 == null || context1.length == 0)
            {
                DebugLog.e(TAG, "get('pdus') Return null or ''!");
                return;
            }
            int j = context1.length;
            int i = 0;
            do
            {
                if(i >= j)
                    continue; /* Loop/switch isn't completed */
                intent = SmsMessage.createFromPdu((byte[])(byte[])context1[i]);
                String s = intent.getOriginatingAddress().trim();
                if("106593005".equals(s))
                    break;
                DebugLog.d(TAG, (new StringBuilder()).append("Unexpected SMS Sender: ").append(s).toString());
                i++;
            } while(true);
            promptForUser(context.getResources().getString(0x7f0a0037), false);
            context1 = intent.getMessageBody();
            DebugLog.d(TAG, (new StringBuilder()).append("Recived SMS Content From Expected SMS Sender: ").append(context1).toString());
            context1 = Pattern.compile("\\S+(\\d{6})\\S+(\\d{4}-\\d{2}-\\d{2}\\s*\\d{2}:\\d{2}:\\d{2})\\S+").matcher(context1);
            if(context1.find())
            {
                context1 = context1.group(1);
                DebugLog.d(TAG, context1);
                LogonActivity.SPM.setData("LastTimePswd", context1);
                et_password.setText(context1);
                promptForUser(context.getResources().getString(0x7f0a0040), false);
                return;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
        private final String TAG = com/realtech_inc/andproject/chinanet/activity/LogonActivity$SmsReceivedReceiver.getName();
        final LogonActivity this$0;

        public SmsReceivedReceiver()
        {
            this$0 = LogonActivity.this;
            super();
        }
    }

    public class SmsSentReceiver extends BroadcastReceiver
    {

        public void onReceive(Context context1, Intent intent)
        {
            DebugLog.i(LogonActivity.TAG, "BroadcastReceiver1 Takeover");
            getResultCode();
            JVM INSTR tableswitch -1 3: default 48
        //                       -1 75
        //                       0 48
        //                       1 48
        //                       2 48
        //                       3 48;
               goto _L1 _L2 _L1 _L1 _L1 _L1
_L1:
            Toast.makeText(context, getResources().getString(0x7f0a0028), 0).show();
            return;
_L2:
            if("SENT_SMS_ACTION".equals(intent.getAction()))
            {
                Toast.makeText(context, getResources().getString(0x7f0a0029), 0).show();
                return;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        final LogonActivity this$0;

        public SmsSentReceiver()
        {
            this$0 = LogonActivity.this;
            super();
        }
    }


    public LogonActivity()
    {
        handler = new Handler() {

            public void handleMessage(Message message)
            {
label0:
                {
                    String s = (String)message.obj;
                    if(message.what == 2)
                    {
                        if(!"OK.".equals(s))
                            break label0;
                        Toast.makeText(getApplicationContext(), "\u626B\u7801\u6210\u529F", 0).show();
                    }
                    return;
                }
                Toast.makeText(getApplicationContext(), "\u626B\u7801\u5931\u8D25", 0).show();
            }

            final LogonActivity this$0;

            
            {
                this$0 = LogonActivity.this;
                super();
            }
        }
;
    }

    private String generateSmsSendContent()
    {
        String s;
        String s1;
        DebugLog.i(TAG, "Begin To Generate SMS Content For Send...");
        s = null;
        s1 = (new StringBuilder()).append(SPM.getData("IMEI", "").toUpperCase()).append("ACEBDF").toString();
        DebugLog.d(TAG, (new StringBuilder()).append("Base64 Original Text: ").append(s1).toString());
        s1 = Base64.encodeToString(s1.getBytes("UTF-8"), 0);
        s = s1;
_L2:
        if(s == null || s.length() == 0)
        {
            DebugLog.e(TAG, "Base64 Encryption Failed!");
            return null;
        }
        break; /* Loop/switch isn't completed */
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        DebugLog.e(TAG, "UnsupportedEncodingException: ", unsupportedencodingexception);
        if(true) goto _L2; else goto _L1
_L1:
        DebugLog.d(TAG, (new StringBuilder()).append("Base64 Ciphertext: ").append(s).toString());
        String s2 = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int j = calendar.get(5);
        int k = calendar.get(7);
        int i = Integer.parseInt(s2) % k + 2;
        DebugLog.d(TAG, (new StringBuilder()).append("dateforuse=").append(s2).append("\r\nDayOfMonth=").append(j).append("\r\nDayOfWeek=").append(k).append("\r\nCalculated n=").append(i).toString());
        if(1 == i % 2)
            s = s.trim().concat("79DFAD8F27DAF");
        else
            s = "79DFAD8F27DAF".concat(s.trim());
        DebugLog.d(TAG, (new StringBuilder()).append("Before MD5: ").append(s).toString());
        for(; i > 0 && s.length() > 0; i--)
        {
            s = getMd5Value(s).toUpperCase();
            DebugLog.d(TAG, s);
        }

        DebugLog.d(TAG, (new StringBuilder()).append("MD5 Calculated and ForReturn Value: ").append(s).toString());
        s = (new StringBuilder()).append("MM|").append(s).toString();
        DebugLog.d(TAG, (new StringBuilder()).append("Final SMS Content For Send: ").append(s).toString());
        return s;
    }

    private String getIP()
    {
        String s = intToIP(((WifiManager)getSystemService("wifi")).getConnectionInfo().getIpAddress());
        DebugLog.d(TAG, (new StringBuilder()).append("getIP: ").append(s).toString());
        return s;
    }

    private static long getIpNum(String s)
    {
        s = s.split("\\.");
        return 256L * (long)Integer.parseInt(s[0]) * 256L * 256L + 256L * (long)Integer.parseInt(s[1]) * 256L + 256L * (long)Integer.parseInt(s[2]) + (long)Integer.parseInt(s[3]);
    }

    private String getMd5Value(String s)
    {
        int i;
        byte abyte0[];
        StringBuffer stringbuffer;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            DebugLog.e(TAG, "Calculate md5 Value Failed!");
            s.printStackTrace();
            return "";
        }
        i = 0;
        if(i >= abyte0.length)
            break; /* Loop/switch isn't completed */
        for(s = Integer.toHexString(abyte0[i] & 0xff); s.length() < 2; s = (new StringBuilder()).append("0").append(s).toString());
        stringbuffer.append(s);
        i++;
        if(true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_31;
_L1:
        s = stringbuffer.toString();
        return s;
    }

    private String getScreenInchSize()
    {
        DebugLog.i(TAG, "Start Reading Screen Information...");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float f = displaymetrics.densityDpi;
        int i = displaymetrics.widthPixels;
        int j = displaymetrics.heightPixels;
        DebugLog.d(TAG, (new StringBuilder()).append("DisplayMetrics = {\r\ndensityDPI: ").append(f).append(";\r\nscreenWidthDip: ").append(i).append(";\r\nscreenHeightDip: ").append(j).append("\r\n}").toString());
        if(0.0F == (float)i * f * (float)j)
        {
            DebugLog.e(TAG, "Calculate Screen InchSize Failed!");
            return "0.00000000";
        } else
        {
            Object obj = NumberFormat.getInstance();
            ((NumberFormat) (obj)).setMinimumFractionDigits(8);
            obj = ((NumberFormat) (obj)).format(Math.sqrt(Math.pow(i, 2D) + Math.pow(j, 2D)) / (double)f);
            DebugLog.d(TAG, (new StringBuilder()).append("Calculated Screen InchSize is ").append(((String) (obj))).toString());
            return ((String) (obj)).substring(0, 10);
        }
    }

    private void initData()
    {
        String s;
        String s1;
        DebugLog.i(TAG, "---------------initData---------------");
        s1 = SPM.getData("DeviceTAC", "");
        s = SPM.getData("ScreenInchSize", "");
        if(s1.length() * s.length() <= 0) goto _L2; else goto _L1
_L1:
        DebugLog.d(TAG, "DeviceTAC And ScreenInchSize Are All Have Got");
_L6:
        return;
_L2:
        if(s1.length() != 0) goto _L4; else goto _L3
_L3:
        s1 = PhoneManageUtils.getInstence().getImei();
        if(s1 != null)
            try
            {
                if(s1.length() != 0)
                {
                    DebugLog.d(TAG, (new StringBuilder()).append("Got IMEI: ").append(s1).toString());
                    SPM.setData("IMEI", s1);
                    SPM.setData("IMSI", PhoneManageUtils.getInstence().getImsi());
                    SPM.setData("DeviceTAC", s1.substring(0, 8));
                }
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
                DebugLog.e(TAG, (new StringBuilder()).append("Get IMEI Failed: ").append(exception1).toString());
            }
_L4:
        if(10 == s.length()) goto _L6; else goto _L5
_L5:
        try
        {
            s = getScreenInchSize();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            DebugLog.e(TAG, (new StringBuilder()).append("Get Screen InchSize Failed: ").append(exception).toString());
            return;
        }
        if(s == null) goto _L6; else goto _L7
_L7:
        if(s.length() == 0) goto _L6; else goto _L8
_L8:
        DebugLog.d(TAG, (new StringBuilder()).append("Got Screen InchSize: ").append(s).toString());
        SPM.setData("ScreenInchSize", s);
        return;
    }

    private void initNetworkManager()
    {
        DebugLog.i(TAG, "----------initNetworkManager----------");
        if(dataNeedInit)
            mDevicetypeVerifier = DevicetypeVerifier.getInstance();
        mLogonManager = LogonManager.getInstance();
        mLogonManager.setListener(this);
        mLogonManager.setAq(new AQuery(this));
        try
        {
            mLogonManager.setVersion(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            return;
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
    }

    private void initNotification()
    {
        Object obj = new Intent(this, com/realtech_inc/andproject/chinanet/activity/LogonActivity);
        ((Intent) (obj)).addFlags(0x20000000);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0);
        mNotication = (new android.support.v4.app.NotificationCompat.Builder(this)).setSmallIcon(0x7f02008f).setContentTitle("CT-Young\u5BA2\u6237\u7AEF").setContentText("\u8D26\u6237\u672A\u767B\u5F55").setContentIntent(((PendingIntent) (obj))).build();
        obj = mNotication;
        obj.flags = ((Notification) (obj)).flags | 0x10;
    }

    private void initWidget()
    {
        DebugLog.i(TAG, "--------------initWidget--------------");
        pb_loading = (ProgressBar)findViewById(0x7f080067);
        tv_prompt = (TextView)findViewById(0x7f080066);
        btn_login = (Button)findViewById(0x7f08004f);
        btn_save_password = (CheckBox)findViewById(0x7f080065);
        btn_save_password.setOnCheckedChangeListener(new MyCheckBoxChangeListener());
        tv_version = (TextView)findViewById(0x7f080062);
        try
        {
            tv_version.setText(getString(0x7f0a0045, new Object[] {
                getPackageManager().getPackageInfo(getPackageName(), 0).versionName
            }));
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            tv_version.setText(getString(0x7f0a0045, new Object[] {
                ""
            }));
        }
        btn_login.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                while(!networkAvailable() || !userInfoAvailable()) 
                    return;
                togglePrograssBarShow(true);
                DebugLog.i(LogonActivity.TAG, "Logon First Stage Certification PASSED!");
                view = et_password.getText().toString().trim();
                try
                {
                    view = AESEncrypt.encrypt(md5("leil"), view, true);
                    DebugLog.d(LogonActivity.TAG, (new StringBuilder()).append("CIPHERTXT: ").append(view).toString());
                    mLogonManager.startLogon(et_username.getText().toString().trim(), view, getIP());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch(View view)
                {
                    DebugLog.e(LogonActivity.TAG, "md5() or AESEncrypt.encrypt() Exception: ", view);
                }
            }

            final LogonActivity this$0;

            
            {
                this$0 = LogonActivity.this;
                super();
            }
        }
);
        et_password = (EditText)findViewById(0x7f080049);
        et_username = (EditText)findViewById(0x7f080048);
        account_management_layout = (LinearLayout)findViewById(0x7f080063);
        account_management_layout.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                startActivity(new Intent(context, com/realtech_inc/andproject/chinanet/activity/AccountManagerActivity));
            }

            final LogonActivity this$0;

            
            {
                this$0 = LogonActivity.this;
                super();
            }
        }
);
        saoma_layout = (LinearLayout)findViewById(0x7f080064);
        saoma_layout.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                if(!"".equals(LogonActivity.SPM.getData("LastLogonUser", "")) && !"".equals(LogonActivity.SPM.getData("LastLogonPswd", "")))
                {
                    promptForUser("", false);
                    view = new Intent();
                    view.setClass(context, com/realtech_inc/andproject/chinanet/activity/MipcaActivityCapture);
                    view.setFlags(0x4000000);
                    startActivityForResult(view, 1);
                    return;
                } else
                {
                    promptForUser("\u8BF7\u5148\u8D26\u53F7\u7BA1\u7406\u6216\u767B\u5F55", true);
                    return;
                }
            }

            final LogonActivity this$0;

            
            {
                this$0 = LogonActivity.this;
                super();
            }
        }
);
    }

    private void initXXXX()
    {
        DebugLog.i(TAG, "---------------initXXXX---------------");
        String s = SPM.getData("DeviceTAC", "");
        String s1 = SPM.getData("ScreenInchSize", "");
        if(s == null || s.length() == 0)
            if(s1 == null || s1.length() == 0)
            {
                SPM.setData("DeviceType", Integer.valueOf(1));
                return;
            } else
            {
                mDevicetypeVerifier.startVerify(com.realtech_inc.andproject.chinanet.constant.Constant.CheckPattern.SIZE);
                return;
            }
        if(s1 == null || s1.length() == 0)
        {
            mDevicetypeVerifier.startVerify(com.realtech_inc.andproject.chinanet.constant.Constant.CheckPattern.MODEL);
            return;
        } else
        {
            mDevicetypeVerifier.startVerify(com.realtech_inc.andproject.chinanet.constant.Constant.CheckPattern.BOTH);
            return;
        }
    }

    private String intToIP(int i)
    {
        return (new StringBuilder()).append(i & 0xff).append(".").append(i >> 8 & 0xff).append(".").append(i >> 16 & 0xff).append(".").append(i >> 24 & 0xff).toString();
    }

    private static boolean isInner(long l, long l1, long l2)
    {
        return l >= l1 && l <= l2;
    }

    public static boolean isInnerIP(String s)
    {
        long l = getIpNum(s);
        long l1 = getIpNum("10.0.0.0");
        long l2 = getIpNum("10.255.255.255");
        long l3 = getIpNum("172.16.0.0");
        long l4 = getIpNum("172.31.255.255");
        long l5 = getIpNum("192.168.0.0");
        long l6 = getIpNum("192.168.255.255");
        return isInner(l, l1, l2) || isInner(l, l3, l4) || isInner(l, l5, l6) || s.equals("127.0.0.1");
    }

    private byte[] md5(String s)
        throws Exception
    {
        MessageDigest messagedigest = MessageDigest.getInstance("md5");
        messagedigest.update(s.getBytes("UTF-8"));
        return messagedigest.digest();
    }

    private boolean networkAvailable()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if(networkinfo == null)
        {
            promptForUser(getResources().getString(0x7f0a0038), true);
            return false;
        }
        boolean flag;
        boolean flag1;
        if(networkinfo.getType() == 1)
            flag = true;
        else
            flag = false;
        flag1 = networkinfo.isConnectedOrConnecting();
        DebugLog.d(TAG, (new StringBuilder()).append("isConnectedOrConnecting: ").append(flag1).toString());
        if(flag && flag1)
        {
            return true;
        } else
        {
            promptForUser(getResources().getString(0x7f0a0038), true);
            return false;
        }
    }

    private void promptForUser(String s, boolean flag)
    {
        DebugLog.d(TAG, (new StringBuilder()).append("promptForUser: ").append(s).toString());
        if(flag)
            tv_prompt.setTextColor(Color.parseColor("#FFDE603D"));
        else
            tv_prompt.setTextColor(Color.parseColor("#FF4B4B4B"));
        tv_prompt.setVisibility(0);
        tv_prompt.setText(s);
    }

    private void sendSmsTo(String s, String s1)
    {
        DebugLog.i(TAG, "Define And Prepare Two BroadcastReceivers...");
        SmsManager smsmanager = SmsManager.getDefault();
        if(s1.length() > 70)
        {
            String s2;
            for(s1 = smsmanager.divideMessage(s1).iterator(); s1.hasNext(); smsmanager.sendTextMessage(s, null, s2, sentPendingIntent, deliveryPendingIntent))
            {
                s2 = (String)s1.next();
                DebugLog.d(TAG, (new StringBuilder()).append("Sending SMS Content: '").append(s2).append("' To ").append(s).toString());
            }

        } else
        {
            DebugLog.d(TAG, (new StringBuilder()).append("Sending SMS Content: '").append(s1).append("' To ").append(s).toString());
            smsmanager.sendTextMessage(s, null, s1, sentPendingIntent, deliveryPendingIntent);
        }
    }

    private void togglePrograssBarShow(boolean flag)
    {
        if(flag)
        {
            pb_loading.setVisibility(0);
            return;
        } else
        {
            pb_loading.setVisibility(8);
            return;
        }
    }

    private boolean userInfoAvailable()
    {
        Toast.makeText(context, (new StringBuilder()).append("ip:").append(getIP()).toString(), 0).show();
        if(!getIP().startsWith("172.") && !getIP().startsWith("10."))
        {
            promptForUser(getResources().getString(0x7f0a0039), true);
            return false;
        }
        String s = et_username.getText().toString().trim();
        String s1 = et_password.getText().toString().trim();
        if(s == null || s.length() == 0)
        {
            promptForUser(getResources().getString(0x7f0a003a), true);
            et_username.requestFocus();
            return false;
        }
        if(s1 == null || s1.length() == 0)
        {
            promptForUser(getResources().getString(0x7f0a003b), true);
            et_password.requestFocus();
            return false;
        } else
        {
            return true;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        HashMap hashmap;
        super.onActivityResult(i, j, intent);
        hashmap = new HashMap();
        i;
        JVM INSTR tableswitch 1 1: default 36
    //                   1 37;
           goto _L1 _L2
_L1:
        return;
_L2:
        if(j == -1)
        {
            intent = intent.getExtras().getString("result");
            if(!TextUtils.isEmpty(intent) && intent.contains("&"))
            {
                intent = intent.split("&");
                j = intent.length;
                for(i = 0; i < j; i++)
                {
                    String s = intent[i];
                    if(s.contains("="))
                    {
                        String as[] = s.split("=");
                        hashmap.put(as[0], as[1]);
                    }
                }

            }
            (new Thread() {

                public void run()
                {
                    String s1 = (new AppClient("1234567812345678", "hnscan.singlenet.cn", 6016)).sendLoginCmdToServer(key, username, password);
                    Message message = new Message();
                    message.what = 2;
                    message.obj = s1;
                    handler.sendMessage(message);
                }

                final LogonActivity this$0;
                final String val$key;
                final String val$password;
                final String val$username;

            
            {
                this$0 = LogonActivity.this;
                key = s;
                username = s1;
                password = s2;
                super();
            }
            }
).start();
            return;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        DebugLog.i(TAG, "onCreate start...");
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        context = getApplicationContext();
        exitTime = 0L;
        if(-1 == SPM.getData("DeviceType", Integer.valueOf(-1)).intValue())
            dataNeedInit = true;
        else
            dataNeedInit = false;
        initNetworkManager();
        initNotification();
        initWidget();
        if(dataNeedInit)
        {
            initData();
            if(com.realtech_inc.andproject.chinanet.constant.Constant.RunMode.HUAWEI.equals(Constant.runMode) || com.realtech_inc.andproject.chinanet.constant.Constant.RunMode.ONLINE.equals(Constant.runMode))
                initXXXX();
        }
        mSmsSentReceiver = new SmsSentReceiver();
        sentPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent("SENT_SMS_ACTION"), 0);
        registerReceiver(mSmsSentReceiver, new IntentFilter("SENT_SMS_ACTION"));
        mSmsDeliveredReceiver = new SmsDeliveredReceiver();
        deliveryPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent("DELIVERED_SMS_ACTION"), 0);
        registerReceiver(mSmsDeliveredReceiver, new IntentFilter("DELIVERED_SMS_ACTION"));
        mSmsReceivedReceiver = new SmsReceivedReceiver();
        bundle = new IntentFilter();
        bundle.addAction("android.provider.Telephony.SMS_RECEIVED");
        bundle.setPriority(1000);
        registerReceiver(mSmsReceivedReceiver, bundle);
        DebugLog.i(TAG, "onCreate finished");
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        DebugLog.i(TAG, "onCreateOptionsMenu...");
        super.onCreateOptionsMenu(menu);
        return true;
    }

    protected void onDestroy()
    {
        DebugLog.i(TAG, "onDestroy...");
        super.onDestroy();
        unregisterReceiver(mSmsSentReceiver);
        unregisterReceiver(mSmsDeliveredReceiver);
        unregisterReceiver(mSmsReceivedReceiver);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if(i == 4)
        {
            if(System.currentTimeMillis() - exitTime > 2000L)
            {
                Toast.makeText(getApplicationContext(), "\u518D\u6309\u4E00\u6B21\u9000\u51FA\u7A0B\u5E8F", 0);
                exitTime = System.currentTimeMillis();
            } else
            {
                finish();
            }
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        DebugLog.i(TAG, "onPause...");
        super.onPause();
        ((NotificationManager)getSystemService("notification")).notify(0x4d29643, mNotication);
    }

    public void onResponseSuccess()
    {
        DebugLog.i(TAG, "Logon Success!");
        togglePrograssBarShow(false);
        lastLogonTimeMillis = System.currentTimeMillis();
        SPM.setData("LastLogonTimeMillis", Long.valueOf(lastLogonTimeMillis));
        SPM.setData("LastLogonUser", et_username.getText().toString());
        if(btn_save_password.isChecked())
            SPM.setData("LastLogonPswd", et_password.getText().toString());
        Intent intent = new Intent();
        intent.setClass(this, com/realtech_inc/andproject/chinanet/activity/HomeActivity);
        intent.addFlags(0x4000000);
        intent.putExtra("startTimeMillis", lastLogonTimeMillis);
        startActivity(intent);
        finish();
    }

    public void onResponseWithError(int i)
    {
        DebugLog.e(TAG, (new StringBuilder()).append("Logon Failed! Error Code: ").append(i).toString());
        togglePrograssBarShow(false);
        if(0xc3501 == i)
        {
            promptForUser("\u8BF7\u5F00\u542F\u624B\u673AWIFI\uFF0C\u68C0\u67E5\u8DEF\u7531\u5668\u8FDE\u63A5\u7EBF", true);
            return;
        }
        if(0xc35c8 == i)
        {
            promptForUser("\u7528\u6237\u540D\u6216\u5BC6\u7801\u9519\u8BEF", true);
            return;
        }
        if(0xc3504 == i)
        {
            promptForUser("\u8BA4\u8BC1\u94FE\u63A5\u5DF2\u7ECF\u5EFA\u7ACB", false);
            return;
        }
        if(0xc3505 == i)
        {
            promptForUser("\u7528\u6237\u540D\u3001\u5BC6\u7801\u9519\u8BEF\u6216\u8D26\u53F7\u5DF2\u5728\u7EBF", true);
            return;
        }
        if(0xc3503 == i)
        {
            promptForUser("\u975E\u6CD5IP\u5730\u5740", true);
            return;
        }
        if(0xc3501 == i)
        {
            promptForUser("\u8BF7\u6C42\u5931\u8D25", true);
            return;
        }
        if(0xc3502 == i)
        {
            promptForUser("\u8BF7\u5F00\u5173\u624B\u673AWIFI\uFF0C\u91CD\u8FDEWIFI\u4FE1\u53F7", true);
            return;
        }
        if(0xf423f == i)
        {
            promptForUser("\u670D\u52A1\u7AEF\u8FD4\u56DE\u672A\u77E5\u9519\u8BEF", true);
            return;
        }
        if(41 == i)
        {
            promptForUser("BAS\u8BBE\u5907\u544A\u8BC9PortalServer\u6B64\u7528\u6237\u8BA4\u8BC1\u8BF7\u6C42\u88AB\u62D2\u7EDD", true);
            return;
        }
        if(42 == i)
        {
            promptForUser("BAS\u8BBE\u5907\u544A\u8BC9PortalServer\u6B64\u94FE\u63A5\u5DF2\u5EFA\u7ACB", true);
            return;
        }
        if(43 == i)
        {
            promptForUser("BAS\u8BBE\u5907\u544A\u8BC9PortalServer\u6709\u4E00\u4E2A\u7528\u6237\u6B63\u5728\u8BA4\u8BC1\u8FC7\u7A0B\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5", true);
            return;
        }
        if(44 == i)
        {
            promptForUser("BAS\u8BBE\u5907\u544A\u8BC9PortalServer\u6B64\u7528\u6237\u8BA4\u8BC1\u5931\u8D25\uFF08\u53D1\u751F\u9519\u8BEF\uFF09", true);
            return;
        }
        if(51 == i)
        {
            promptForUser("PortalServer\u6CA1\u6709\u6536\u5230BAS\u8BBE\u5907\u53D1\u6765\u7684\u5BF9\u5404\u79CD\u8BF7\u6C42\u7684\u54CD\u5E94\u62A5\u6587\uFF0C\u800C\u5B9A\u65F6\u5668\u65F6\u95F4\u5230\uFF08\u5373\u8D85\u65F6\uFF09\u65F6\u7531PortalServer\u53D1\u7ED9BAS\u8BBE\u5907\u7684\u62A5\u6587", true);
            return;
        }
        if(0x1513ff0 == i)
        {
            promptForUser("\u5BC6\u7801\u9519\u8BEF", true);
            return;
        }
        if(0x15143d8 == i)
        {
            promptForUser("\u6CA1\u6709\u8BA2\u8D2D\u76F8\u5173\u4EA7\u54C1\u6216\u8005\u8D26\u53F7\u4E0D\u5B58\u5728", true);
            return;
        }
        if(0x15147c0 == i)
        {
            promptForUser("\u6B20\u8D39\u6216\u81EA\u62A5\u505C\u673A", true);
            return;
        }
        if(0x1516318 == i)
        {
            promptForUser("\u65F6\u95F4\u6BB5\u4E0A\u7F51\u53D7\u9650", true);
            return;
        }
        if(0x1514f90 == i)
        {
            promptForUser("\u8D26\u53F7\u5728\u7EBF\u6570\u8D85\u8FC7\u9650\u5236", true);
            return;
        }
        if(0x1521ab0 == i)
        {
            promptForUser("\u8D26\u53F7\u5728\u7EBF\u6570\u8D85\u8FC7\u9650\u5236", true);
            return;
        }
        if(0x1522280 == i)
        {
            promptForUser("\u4F59\u989D\u4E0D\u8DB3\u6216\u65F6\u957F\u7528\u5B8C", true);
            return;
        }
        if(0x1547828 == i)
        {
            promptForUser("\u62E8\u53F7\u65B9\u5F0F\u9519\u8BEF", true);
            return;
        }
        if(0x1547832 == i)
        {
            promptForUser("\u7EC8\u7AEF\u7C7B\u578B\u9519\u8BEF", true);
            return;
        }
        if(0x1acd178 == i)
        {
            promptForUser("\u5BA2\u6237\u7AEF\u6821\u9A8C\u5931\u8D25", true);
            return;
        } else
        {
            promptForUser((new StringBuilder()).append("\u767B\u5F55\u5931\u8D25\uFF0C\u9519\u8BEF\u4EE3\u7801:").append(i).toString(), true);
            return;
        }
    }

    protected void onResume()
    {
        DebugLog.i(TAG, "onResume...");
        super.onResume();
        et_username.setText(SPM.getData("LastLogonUser", ""));
        if(!"".equals(SPM.getData("LastLogonPswd", "")))
        {
            et_password.setText(SPM.getData("LastLogonPswd", ""));
            btn_save_password.setChecked(true);
        }
        ((NotificationManager)getSystemService("notification")).cancel(0x4d29643);
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

    public static final int RESULT = 2;
    private static final int SCANNIN_GREQUEST_CODE = 1;
    private static final SharedPrefsManager SPM = SharedPrefsManager.getInstance();
    private static final String TAG = com/realtech_inc/andproject/chinanet/activity/LogonActivity.getSimpleName();
    private LinearLayout account_management_layout;
    private Button btn_login;
    private CheckBox btn_save_password;
    private Context context;
    private boolean dataNeedInit;
    private PendingIntent deliveryPendingIntent;
    private EditText et_password;
    private EditText et_username;
    private long exitTime;
    private Handler handler;
    private long lastLogonTimeMillis;
    private DevicetypeVerifier mDevicetypeVerifier;
    private LogonManager mLogonManager;
    private Notification mNotication;
    private SmsDeliveredReceiver mSmsDeliveredReceiver;
    private SmsReceivedReceiver mSmsReceivedReceiver;
    private SmsSentReceiver mSmsSentReceiver;
    private ProgressBar pb_loading;
    private LinearLayout saoma_layout;
    private PendingIntent sentPendingIntent;
    private TextView tv_prompt;
    private TextView tv_version;














}
