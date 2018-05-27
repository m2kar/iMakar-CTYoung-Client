// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.e;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.xxx.e.k;
import com.xxx.sdk.a.i;
import com.xxx.sdk.a.j;
import com.xxx.sdk.b.e;
import com.xxx.sdk.c.a.d;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.d.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.e.e:
//            f, e, d, b

public final class a
{

    public a()
    {
    }

    public static String B()
    {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    private static String C()
    {
        Object obj = NetworkInterface.getNetworkInterfaces();
_L2:
        Enumeration enumeration;
        if(!((Enumeration) (obj)).hasMoreElements())
            break MISSING_BLOCK_LABEL_63;
        enumeration = ((NetworkInterface)((Enumeration) (obj)).nextElement()).getInetAddresses();
_L4:
        if(!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration.nextElement();
        if(inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        obj = inetaddress.getHostAddress().toString();
        return ((String) (obj));
        SocketException socketexception;
        socketexception;
        return "";
    }

    public static String D()
    {
        return cg;
    }

    private static int a(Context context)
    {
        if(bN != 0)
            return bN;
        if(a_android_content_pm_PackageManager_static_fld == null)
            a_android_content_pm_PackageManager_static_fld = context.getPackageManager();
        if(com.xxx.sdk.e.b.f(get("ro.yunos.version")))
        {
            context = Build.MANUFACTURER;
            int i1 = e.DEFAULT$14e1ffcc;
            bN = i1;
            return i1;
        } else
        {
            int j1 = e.ALIYUN$14e1ffcc;
            bN = j1;
            return j1;
        }
    }

    public static c a()
    {
        if(Environment.getExternalStorageState().equals("mounted"))
            return a(Environment.getExternalStorageDirectory().getPath());
        else
            return new c(-1L, -1L);
    }

    private static c a(String s)
    {
        s = new StatFs(s);
        long l1 = s.getBlockSize();
        long l2 = s.getAvailableBlocks();
        return new c(((long)s.getBlockCount() * l1) / 1024L, (l1 * l2) / 1024L);
    }

    public static f a(Context context)
    {
        f f1;
        Object obj = (TelephonyManager)context.getSystemService("phone");
        if(obj == null)
            return null;
        f1 = new f();
        ((TelephonyManager) (obj)).getSubscriberId();
        f1.bj = ((TelephonyManager) (obj)).getDeviceId();
        f1.cl = ((TelephonyManager) (obj)).getLine1Number();
        f1.cq = ((TelephonyManager) (obj)).getSimOperator();
        f1.b = com.xxx.sdk.e.e.e.a(context);
        obj = Locale.getDefault().getLanguage().toLowerCase();
        String s = Locale.getDefault().getCountry().toLowerCase();
        f1.cr = (new StringBuilder()).append(((String) (obj))).append("-").append(s).toString();
        f1.bA = "Android";
        f1.cm = android.os.Build.VERSION.RELEASE;
        obj = Build.CPU_ABI;
        f1.cs = d(context);
        if(!b(context, "android.permission.ACCESS_WIFI_STATE")) goto _L2; else goto _L1
_L1:
        boolean flag;
        Object obj1;
        obj1 = (WifiManager)context.getSystemService("wifi");
        if(obj1 == null)
            obj1 = null;
        else
            obj1 = ((WifiManager) (obj1)).getConnectionInfo();
        if(obj1 == null) goto _L2; else goto _L3
_L3:
        obj1 = ((WifiInfo) (obj1)).getMacAddress();
        if(com.xxx.sdk.e.b.f(((String) (obj1)))) goto _L2; else goto _L4
_L4:
        obj1 = ((String) (obj1)).toLowerCase().replaceAll(":", "").replaceAll("-", "");
_L5:
        f1.bh = ((String) (obj1));
        f1.ct = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if("sdk".equals(Build.MODEL) || "google_sdk".equals(Build.MODEL))
        {
            flag = true;
        } else
        {
label0:
            {
                if(!"goldfish".equals(m("ro.hardware")))
                {
                    context = (TelephonyManager)context.getSystemService("phone");
                    if(context == null || !"Android".equals(context.getSimOperator()) && !"Android".equals(context.getNetworkOperator()))
                        break label0;
                }
                flag = true;
            }
        }
_L6:
        if(flag)
        {
            f1.bz = "Simulator";
            f1.cp = "Simulator";
        } else
        {
            f1.bz = Build.MODEL;
            f1.cp = Build.MANUFACTURER;
        }
        return f1;
_L2:
        obj1 = null;
          goto _L5
        flag = false;
          goto _L6
    }

    private static String a(File file)
    {
        StringBuilder stringbuilder = new StringBuilder();
        file = new BufferedReader(new FileReader(file));
        stringbuilder.append(file.readLine());
        file.close();
        return stringbuilder.toString();
    }

    public static List a(Context context)
    {
        if(a_android_content_pm_PackageManager_static_fld == null)
            a_android_content_pm_PackageManager_static_fld = context.getPackageManager();
        context = new ArrayList();
        for(Iterator iterator = a_android_content_pm_PackageManager_static_fld.getInstalledPackages(0).iterator(); iterator.hasNext(); context.add(((PackageInfo)iterator.next()).packageName));
        return context;
    }

    public static Map a(Context context)
    {
        if(a_android_content_pm_PackageManager_static_fld == null)
            a_android_content_pm_PackageManager_static_fld = context.getPackageManager();
        context = new HashMap();
        Iterator iterator = a_android_content_pm_PackageManager_static_fld.getInstalledPackages(0).iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            PackageInfo packageinfo = (PackageInfo)iterator.next();
            if((packageinfo.applicationInfo.flags & 1) == 0)
                context.put(packageinfo.packageName, String.valueOf(packageinfo.versionCode));
        } while(true);
        return context;
    }

    public static void a(JSONObject jsonobject)
    {
        for(jsonobject = jsonobject.optString("ip"); com.xxx.sdk.e.b.f(jsonobject) || jsonobject.equalsIgnoreCase(cg);)
            return;

        cg = jsonobject;
        Object obj = new i(com.xxx.sdk.b.a().getContext());
        Object obj1 = ((i) (obj)).a("net_ip");
        if(obj1 != null)
        {
            obj1.updated = System.currentTimeMillis();
            obj1.value = jsonobject;
            ((i) (obj)).a(((j) (obj1)));
        }
        jsonobject = com.xxx.sdk.c.a.b.a();
        if(((com.xxx.sdk.c.a.b) (jsonobject)).i != null && ((com.xxx.sdk.c.a.b) (jsonobject)).i.size() > 0)
            for(jsonobject = ((com.xxx.sdk.c.a.b) (jsonobject)).i.iterator(); jsonobject.hasNext(); jsonobject.next());
        jsonobject = com.xxx.e.k.a();
        obj = com.xxx.e.k.a().iterator();
        obj1 = new HashSet();
        do
        {
            if(!((Iterator) (obj)).hasNext())
                break;
            d d1 = com.xxx.sdk.c.a.d.a((String)((Iterator) (obj)).next());
            if(d1 != null)
            {
                d1.bi = com.xxx.sdk.a.e.k();
                ((HashSet) (obj1)).add(com.xxx.sdk.c.a.d.a(d1));
            }
        } while(true);
        com.xxx.e.k.a(((HashSet) (obj1)));
        jsonobject.init(((k) (jsonobject)).bX);
    }

    private static boolean a(Context context, Class class1)
    {
        context = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff);
        if(context == null || context.size() == 0)
            return false;
        for(context = context.iterator(); context.hasNext();)
            if(((android.app.ActivityManager.RunningServiceInfo)context.next()).service.getClassName().equals(class1.getName()))
                return true;

        return false;
    }

    public static boolean a(Context context, String s)
    {
        return b(context).contains(s);
    }

    private static String[] a(File file, String s)
    {
        com.xxx.sdk.e.a.a.a a1;
        Object obj;
        try
        {
            a1 = new com.xxx.sdk.e.a.a.a(file);
            obj = a1.a().icon;
        }
        // Misplaced declaration of an exception variable
        catch(File file)
        {
            com.xxx.sdk.e.c.error("\u89E3\u6790\uFF21\uFF30\uFF2B\u4E2D\u5F02\u5E38\u3002", file);
            return null;
        }
        if(obj != null) goto _L2; else goto _L1
_L1:
        file = null;
_L3:
        obj = ((com.xxx.sdk.e.a.a.a.d) (file)).path.substring(((com.xxx.sdk.e.a.a.a.d) (file)).path.lastIndexOf("."));
        s = new File(s.concat(String.valueOf(((com.xxx.sdk.e.a.a.a.d) (file)).path.hashCode()).concat(((String) (obj)))));
        s.getParentFile().mkdirs();
        obj = new FileOutputStream(s);
        com.xxx.sdk.e.c.d.a(((com.xxx.sdk.e.a.a.a.d) (file)).data, ((java.io.OutputStream) (obj)));
        com.xxx.sdk.e.c.d.a(((java.io.Closeable) (obj)));
        obj = a1.a();
        file = ((com.xxx.sdk.e.a.a.a.a) (obj)).packageName;
        obj = ((com.xxx.sdk.e.a.a.a.a) (obj)).label;
        s = s.getCanonicalPath();
        com.xxx.sdk.e.c.d.a(a1);
        if(com.xxx.sdk.e.b.f(((String) (obj))) && com.xxx.sdk.e.b.f(s))
            return null;
        else
            return (new String[] {
                file, obj, s
            });
_L2:
        file = a1.a.getEntry(((String) (obj)));
        if(file != null)
            break MISSING_BLOCK_LABEL_174;
        file = null;
_L4:
        file = new com.xxx.sdk.e.a.a.a.d(((String) (obj)), file);
          goto _L3
        file = com.xxx.sdk.e.a.a.d.h.a(a1.a.getInputStream(file));
          goto _L4
    }

    public static String[] a(String s, String s1)
    {
        if(com.xxx.sdk.e.b.f(s))
            return null;
        else
            return a(new File(s), s1);
    }

    public static c b()
    {
        return a(Environment.getDataDirectory().getPath());
    }

    private static String b(Context context)
    {
        context = (WifiManager)context.getSystemService("wifi");
        if(context.isWifiEnabled())
        {
            int i1 = context.getConnectionInfo().getIpAddress();
            return (new StringBuilder()).append(i1 & 0xff).append(".").append(i1 >> 8 & 0xff).append(".").append(i1 >> 16 & 0xff).append(".").append(i1 >>> 24).toString();
        } else
        {
            return "";
        }
    }

    public static String b(Context context, String s)
    {
        if(com.xxx.sdk.e.b.f(s))
            return null;
        if(i(context))
            return (new StringBuilder("alimarket://details?id=")).append(s).toString();
        else
            return (new StringBuilder("market://details?id=")).append(s).toString();
    }

    public static List b(Context context)
    {
        if(com.xxx.sdk.e.b.a(v))
        {
            if(a_android_content_pm_PackageManager_static_fld == null)
                a_android_content_pm_PackageManager_static_fld = context.getPackageManager();
            d = new HashMap();
            v = new ArrayList();
            for(Iterator iterator = a_android_content_pm_PackageManager_static_fld.getInstalledPackages(0).iterator(); iterator.hasNext();)
            {
                Object obj1 = (PackageInfo)iterator.next();
                ApplicationInfo applicationinfo = ((PackageInfo) (obj1)).applicationInfo;
                obj1 = ((PackageInfo) (obj1)).packageName;
                if((applicationinfo.flags & 1) > 0)
                {
                    v.add(obj1);
                    d.put(obj1, Boolean.valueOf(true));
                } else
                {
                    d.put(obj1, Boolean.valueOf(false));
                }
            }

            Object obj = new Intent("android.intent.action.MAIN");
            ((Intent) (obj)).addCategory("android.intent.category.HOME");
            String s;
            for(obj = a_android_content_pm_PackageManager_static_fld.queryIntentActivities(((Intent) (obj)), 0x10000).iterator(); ((Iterator) (obj)).hasNext(); d.put(s, Boolean.valueOf(true)))
            {
                s = ((ResolveInfo)((Iterator) (obj)).next()).activityInfo.packageName;
                v.add(s);
            }

            obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).addCategory("android.intent.category.BROWSABLE");
            ((Intent) (obj)).setData(Uri.parse("http://"));
            String s1;
            for(obj = a_android_content_pm_PackageManager_static_fld.queryIntentActivities(((Intent) (obj)), 32).iterator(); ((Iterator) (obj)).hasNext(); d.put(s1, Boolean.valueOf(true)))
            {
                s1 = ((ResolveInfo)((Iterator) (obj)).next()).activityInfo.packageName;
                v.add(s1);
            }

        }
        d.put(context.getPackageName(), Boolean.valueOf(true));
        return v;
    }

    public static void b(Context context, Uri uri)
    {
        if(context == null || uri == null)
        {
            return;
        } else
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            intent.addFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
    }

    private static boolean b(Context context)
    {
        context = ((LocationManager)context.getSystemService("location")).getProviders(true);
        return context != null && context.size() > 0;
    }

    public static boolean b(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    private static String c(Context context)
    {
        if(b(context, "android.permission.ACCESS_WIFI_STATE"))
        {
            context = (WifiManager)context.getSystemService("wifi");
            if(context == null)
                context = null;
            else
                context = context.getConnectionInfo();
            if(context != null)
            {
                context = context.getMacAddress();
                if(!com.xxx.sdk.e.b.f(context))
                    return context.toLowerCase().replaceAll(":", "").replaceAll("-", "");
            }
        }
        return null;
    }

    public static String c(Context context, String s)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(s, 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            context.printStackTrace();
            return "";
        }
        return context;
    }

    public static void c(Context context, String s)
    {
        if(context == null)
        {
            return;
        } else
        {
            context.getSharedPreferences("client", 0).edit().putString("ua", s).commit();
            return;
        }
    }

    private static boolean c(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        context = (TelephonyManager)context.getSystemService("phone");
        return connectivitymanager.getActiveNetworkInfo() != null && connectivitymanager.getActiveNetworkInfo().getState() == android.net.NetworkInfo.State.CONNECTED || context.getNetworkType() == 3;
    }

    public static String d(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if(context != null)
        {
            context = context.getActiveNetworkInfo();
            if(context != null && context.isConnected())
            {
                if(context.getType() == 1)
                    return "2";
                if(context.getType() == 0)
                {
                    String s = context.getSubtypeName();
                    switch(context.getSubtype())
                    {
                    default:
                        if(s.equalsIgnoreCase("TD-SCDMA") || s.equalsIgnoreCase("WCDMA") || s.equalsIgnoreCase("CDMA2000"))
                            return "5";
                        break;

                    case 1: // '\001'
                    case 2: // '\002'
                    case 4: // '\004'
                    case 7: // '\007'
                    case 11: // '\013'
                        return "4";

                    case 3: // '\003'
                    case 5: // '\005'
                    case 6: // '\006'
                    case 8: // '\b'
                    case 9: // '\t'
                    case 10: // '\n'
                    case 12: // '\f'
                    case 14: // '\016'
                    case 15: // '\017'
                        return "5";

                    case 13: // '\r'
                        return "6";
                    }
                }
            }
        }
        return "0";
    }

    public static boolean d(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
        if(context != null)
            return context.isConnected();
        else
            return false;
    }

    public static String e(Context context)
    {
        if(context == null)
        {
            cf = "";
            return "";
        }
        if(System.currentTimeMillis() - D < 200L)
            return cf;
        D = System.currentTimeMillis();
        if(a_android_app_ActivityManager_static_fld == null)
            a_android_app_ActivityManager_static_fld = (ActivityManager)context.getSystemService("activity");
        int i1 = a(context);
        if(i1 == e.ALIYUN$14e1ffcc)
        {
            context = ((android.app.ActivityManager.RunningAppProcessInfo)a_android_app_ActivityManager_static_fld.getRunningAppProcesses().get(0)).processName;
            if(context != null && context.contains(":"))
            {
                return context.split(":")[0];
            } else
            {
                cf = context;
                return context;
            }
        }
        if(i1 == e.DEFAULT$14e1ffcc)
        {
            if(android.os.Build.VERSION.SDK_INT > 20)
                context = f(context);
            else
                context = ((android.app.ActivityManager.RunningTaskInfo)a_android_app_ActivityManager_static_fld.getRunningTasks(1).get(0)).topActivity.getPackageName();
            cf = context;
            return context;
        } else
        {
            cf = "";
            return "";
        }
    }

    private static boolean e(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(0);
        if(context != null)
            return context.isConnected();
        else
            return false;
    }

    private static String f(Context context)
    {
        obj1.cj = j(k1);
        if(((com.xxx.sdk.e.e.d) (obj1)).cj != null && !((com.xxx.sdk.e.e.d) (obj1)).cj.equals("null"))
            break MISSING_BLOCK_LABEL_246;
        e.put(String.valueOf(k1), Integer.valueOf(k1));
        obj1 = context;
        context = ((Context) (obj));
        obj = obj1;
        break MISSING_BLOCK_LABEL_121;
        e.put(((com.xxx.sdk.e.e.d) (obj1)).cj, Integer.valueOf(k1));
        if(!d.containsKey(((com.xxx.sdk.e.e.d) (obj1)).cj))
            break MISSING_BLOCK_LABEL_497;
        if(((Boolean)d.get(((com.xxx.sdk.e.e.d) (obj1)).cj)).booleanValue())
            break MISSING_BLOCK_LABEL_475;
        obj1.bQ = 0;
        obj1.ci = String.format("/proc/%d/oom_score_adj", new Object[] {
            Integer.valueOf(k1)
        });
        obj1.ch = String.format("/proc/%d/oom_score", new Object[] {
            Integer.valueOf(k1)
        });
        obj1.y = (new File(((com.xxx.sdk.e.e.d) (obj1)).ci)).canRead();
        String s1;
        NumberFormatException numberformatexception;
        if(e.containsKey(((com.xxx.sdk.e.e.d) (obj1)).cj))
            k1 = ((Integer)e.get(((com.xxx.sdk.e.e.d) (obj1)).cj)).intValue();
        else
            k1 = -1;
        if(((com.xxx.sdk.e.e.d) (obj1)).pid != k1)
        {
            e.put(((com.xxx.sdk.e.e.d) (obj1)).cj, Integer.valueOf(((com.xxx.sdk.e.e.d) (obj1)).pid));
            g.remove(Integer.valueOf(k1));
        }
        if(!((com.xxx.sdk.e.e.d) (obj1)).y)
            break MISSING_BLOCK_LABEL_536;
        k1 = Integer.parseInt(o(((com.xxx.sdk.e.e.d) (obj1)).ci));
        if(k1 != 0)
        {
            obj1 = context;
            context = ((Context) (obj));
            obj = obj1;
            break MISSING_BLOCK_LABEL_121;
        }
        break MISSING_BLOCK_LABEL_536;
        obj1.bQ = 1;
        s1 = ((com.xxx.sdk.e.e.d) (obj1)).cj;
        obj = context;
        context = s1;
        break MISSING_BLOCK_LABEL_121;
        obj1 = context;
        context = ((Context) (obj));
        obj = obj1;
        break MISSING_BLOCK_LABEL_121;
        if(!o(String.format("/proc/%d/cgroup", new Object[] {
    Integer.valueOf(((com.xxx.sdk.e.e.d) (obj1)).pid)
})).split("\n")[0].endsWith("bg_non_interactive"))
            break MISSING_BLOCK_LABEL_590;
        obj1 = context;
        context = ((Context) (obj));
        obj = obj1;
        break MISSING_BLOCK_LABEL_121;
        k1 = Integer.parseInt(o(((com.xxx.sdk.e.e.d) (obj1)).ch));
        if(k1 >= i1)
            break MISSING_BLOCK_LABEL_619;
        obj1 = ((com.xxx.sdk.e.e.d) (obj1)).cj;
        i1 = k1;
        context = ((Context) (obj1));
        Context context1 = context;
        context = ((Context) (obj));
        obj = context1;
        break MISSING_BLOCK_LABEL_121;
        ioexception;
_L2:
        Context context2 = context;
        context = ((Context) (obj));
        obj = context2;
        break MISSING_BLOCK_LABEL_121;
        Object obj = null;
        if(d == null)
            b(context);
        String as[] = (new File("/proc")).list();
        int l1 = as.length;
        int i1 = 0x7fffffff;
        int j1 = 0;
        context = null;
        while(j1 < l1) 
        {
            String s = as[j1];
            if(g.containsKey(s))
            {
                {
                    Object obj1 = (com.xxx.sdk.e.e.d)g.get(s);
                    if(((com.xxx.sdk.e.e.d) (obj1)).pid >= 0 && ((com.xxx.sdk.e.e.d) (obj1)).bQ == 0)
                        break MISSING_BLOCK_LABEL_366;
                    int k1;
                    IOException ioexception;
                    if(obj == null && ((com.xxx.sdk.e.e.d) (obj1)).bQ == 1)
                    {
                        obj1 = ((com.xxx.sdk.e.e.d) (obj1)).cj;
                        obj = context;
                        context = ((Context) (obj1));
                    } else
                    {
                        Context context3 = context;
                        context = ((Context) (obj));
                        obj = context3;
                    }
                }
                j1++;
                obj1 = obj;
                obj = context;
                context = ((Context) (obj1));
            } else
            {
                obj1 = new com.xxx.sdk.e.e.d();
                g.put(s, obj1);
                try
                {
                    k1 = Integer.parseInt(s);
                    obj1.pid = k1;
                }
                // Misplaced declaration of an exception variable
                catch(NumberFormatException numberformatexception)
                {
                    obj1.pid = -1;
                    obj1 = context;
                    context = ((Context) (obj));
                    obj = obj1;
                    break MISSING_BLOCK_LABEL_121;
                }
label0:
                {
                    if(k1 > 0)
                        break label0;
                    obj1 = context;
                    context = ((Context) (obj));
                    obj = obj1;
                }
                break MISSING_BLOCK_LABEL_121;
            }
        }
        if(context == null)
            return ((String) (obj));
        else
            return context;
        context2;
        i1 = k1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean f(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if(context != null)
        {
            context = context.getActiveNetworkInfo();
            if(context != null && context.isAvailable())
                return context.isConnected();
        }
        return false;
    }

    public static String g(Context context)
    {
        if(!com.xxx.sdk.e.b.f(cg))
            return cg;
        if(context == null)
            return cg;
        context = (new i(context)).a("net_ip").value;
        cg = context;
        if(com.xxx.sdk.e.b.f(context))
            return "";
        else
            return cg;
    }

    private static boolean g(Context context)
    {
label0:
        {
            if("sdk".equals(Build.MODEL) || "google_sdk".equals(Build.MODEL))
                return true;
            if(!"goldfish".equals(m("ro.hardware")))
            {
                context = (TelephonyManager)context.getSystemService("phone");
                if(context == null || !"Android".equals(context.getSimOperator()) && !"Android".equals(context.getNetworkOperator()))
                    break label0;
            }
            return true;
        }
        return false;
    }

    private static String get(String s)
    {
        try
        {
            Class class1 = Class.forName("android.os.SystemProperties");
            s = (String)class1.getDeclaredMethod("get", new Class[] {
                java/lang/String
            }).invoke(class1.newInstance(), new Object[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            com.xxx.sdk.e.c.error("get systemProperties error", s);
            return "";
        }
        return s;
    }

    private static String getLang()
    {
        String s = Locale.getDefault().getLanguage().toLowerCase();
        String s1 = Locale.getDefault().getCountry().toLowerCase();
        return (new StringBuilder()).append(s).append("-").append(s1).toString();
    }

    public static String h(Context context)
    {
        if(context == null)
            return "";
        SharedPreferences sharedpreferences = context.getSharedPreferences("client", 0);
        if(sharedpreferences.contains("ua"))
        {
            return sharedpreferences.getString("ua", "");
        } else
        {
            (new com.xxx.sdk.e.e.b(Looper.getMainLooper(), context)).sendEmptyMessage(0);
            return "";
        }
    }

    public static boolean h(Context context)
    {
        boolean flag1 = false;
        if(android.os.Build.VERSION.SDK_INT <= 20) goto _L2; else goto _L1
_L1:
        boolean flag;
        if(d == null)
            b(context);
        flag = flag1;
        if(e.containsKey(context.getPackageName()))
        {
            int i1 = ((Integer)e.get(context.getPackageName())).intValue();
            context = new File((new StringBuilder("/proc")).append(i1).append("/").toString());
            if(context.exists() && context.isDirectory())
                flag = true;
            else
                flag = false;
        }
_L4:
        return flag;
_L2:
        Iterator iterator = ((ActivityManager)context.getSystemService("activity")).getRunningTasks(50).iterator();
        do
        {
            flag = flag1;
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
            if(((android.app.ActivityManager.RunningTaskInfo)iterator.next()).topActivity.getPackageName().equals(context.getPackageName()))
                return true;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String i(int i1)
    {
        return (new StringBuilder()).append(i1 & 0xff).append(".").append(i1 >> 8 & 0xff).append(".").append(i1 >> 16 & 0xff).append(".").append(i1 >>> 24).toString();
    }

    public static boolean i(Context context)
    {
        return a(context) == e.ALIYUN$14e1ffcc;
    }

    private static String j(int i1)
    {
        String s;
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        try
        {
            s = String.format("/proc/%d/cmdline", new Object[] {
                Integer.valueOf(i1)
            });
            stringbuilder = new StringBuilder();
            bufferedreader = new BufferedReader(new FileReader(s));
            stringbuilder.append(bufferedreader.readLine());
            s = bufferedreader.readLine();
        }
        catch(IOException ioexception)
        {
            return null;
        }
        if(s == null)
            break MISSING_BLOCK_LABEL_79;
        stringbuilder.append('\n').append(s);
        s = bufferedreader.readLine();
        break MISSING_BLOCK_LABEL_56;
        bufferedreader.close();
        s = stringbuilder.toString().trim();
        return s;
    }

    public static boolean k()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static boolean l()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static String m(String s)
    {
        try
        {
            Class class1 = Class.forName("android.os.SystemProperties");
            s = (String)class1.getMethod("get", new Class[] {
                java/lang/String
            }).invoke(class1.newInstance(), new Object[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            return "";
        }
        return s;
    }

    private static String n(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
        stringbuilder.append(bufferedreader.readLine());
        for(s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
            stringbuilder.append('\n').append(s);

        bufferedreader.close();
        return stringbuilder.toString();
    }

    private static String o(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
        stringbuilder.append(bufferedreader.readLine());
        for(s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
            stringbuilder.append('\n').append(s);

        bufferedreader.close();
        return stringbuilder.toString();
    }

    public static String p(String s)
    {
        try
        {
            s = new com.xxx.sdk.e.a.a.a(s);
            com.xxx.sdk.e.a.a.a.a a1 = s.a();
            com.xxx.sdk.e.c.d.a(s);
            s = a1.packageName;
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            com.xxx.sdk.e.c.error("\u89E3\u6790\uFF21\uFF30\uFF2B\u4E2D\u5F02\u5E38\u3002", s);
            return null;
        }
        return s;
    }

    public static long r()
    {
        return 110L;
    }

    public static void x(String s)
    {
        try
        {
            a(new JSONObject(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            return;
        }
    }

    private static long D = 0L;
    private static ActivityManager a_android_app_ActivityManager_static_fld = null;
    private static PackageManager a_android_content_pm_PackageManager_static_fld = null;
    private static int bN = 0;
    private static String cf = "";
    private static String cg = "";
    private static HashMap d = new HashMap();
    private static HashMap e = new HashMap(500);
    private static HashMap f;
    private static HashMap g = new HashMap(500);
    private static List v = null;

    static 
    {
        new HashMap(500);
    }
}
