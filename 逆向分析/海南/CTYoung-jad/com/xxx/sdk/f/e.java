// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.f;

import com.xxx.sdk.a.d;
import com.xxx.sdk.b;
import com.xxx.sdk.b.f;
import com.xxx.sdk.b.g;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.f:
//            a, c, d, f

public class e extends com.xxx.sdk.f.a
{

    public e()
    {
        netSupports = 7;
        appCacheable = true;
        state = 0;
        cached = 0;
        reactivateExpires = 0x9a7ec800L;
    }

    private com.xxx.sdk.f.a b(Class class1)
    {
        Object obj = a.a(com.xxx.sdk.b.a().getContext());
        h h1 = new h();
        h1.a = i.app;
        if(2 == state && ((List) (obj)).contains(packageName))
        {
            h1.protocol = packageName;
        } else
        {
            h1.protocol = installer;
            h1.bb = remoteInstaller;
        }
        obj = E();
        if(class1.equals(com/xxx/sdk/f/c))
        {
            if(!com.xxx.sdk.e.b.f(bannerAd))
            {
                com.xxx.sdk.f.c c1 = new com.xxx.sdk.f.c();
                c1.id = id;
                c1.resource = new f();
                c1.resource.a = g.image;
                c1.resource.n = true;
                c1.resource.ba = bannerAd;
                c1.target = h1;
                c1.showUrl = a(showUrl, ((String) (obj)));
                c1.clickUrl = a(clickUrl, ((String) (obj)));
                return (com.xxx.sdk.f.a)class1.cast(c1);
            }
        } else
        if(class1.equals(com/xxx/sdk/f/d))
        {
            if(!com.xxx.sdk.e.b.f(floatingAd))
            {
                com.xxx.sdk.f.d d1 = new com.xxx.sdk.f.d();
                d1.id = id;
                d1.resource = new f();
                d1.resource.a = g.image;
                d1.resource.n = true;
                d1.resource.ba = floatingAd;
                d1.target = h1;
                d1.showUrl = a(showUrl, ((String) (obj)));
                d1.clickUrl = a(clickUrl, ((String) (obj)));
                return (com.xxx.sdk.f.a)class1.cast(d1);
            }
        } else
        if(class1.equals(com/xxx/sdk/f/f))
        {
            if(!com.xxx.sdk.e.b.f(bannerAd))
            {
                com.xxx.sdk.f.f f1 = new com.xxx.sdk.f.f();
                f1.id = id;
                f1.pushId = remoteInstaller.hashCode();
                f1.title = title;
                f1.icon = icon;
                f1.resource = new f();
                f1.resource.a = g.image;
                f1.resource.n = true;
                f1.resource.ba = bannerAd;
                f1.target = h1;
                f1.showUrl = a(showUrl, ((String) (obj)));
                f1.clickUrl = a(clickUrl, ((String) (obj)));
                return (com.xxx.sdk.f.a)class1.cast(f1);
            }
        } else
        if(class1.equals(com/xxx/sdk/f/e))
            return (com.xxx.sdk.f.a)class1.cast(this);
        return null;
    }

    public static e d(String s)
    {
        e e1;
        try
        {
            s = new JSONObject(s);
            e1 = new e();
            e1.id = s.optString("id");
            e1.title = s.optString("title");
            e1.icon = s.optString("icon");
            e1.inMarket = s.optBoolean("inMarket");
            e1.checksum = s.optString("checksum");
            e1.remoteInstaller = s.optString("remoteInstaller");
            e1.installer = s.optString("installer");
            e1.marketInstaller = s.optString("marketInstaller");
            e1.mode = s.optInt("mode", 0);
            e1.bannerAd = s.optString("bannerAd");
            e1.floatingAd = s.optString("floatingAd");
            e1.netSupports = s.optInt("netSupports", 7);
            e1.parsed = s.optBoolean("parsed");
            e1.cached = s.optInt("cached", 0);
            e1.packageName = s.optString("packageName");
            e1.cacheUrl = s.optString("cacheUrl");
            e1.showUrl = s.optString("showUrl");
            e1.clickUrl = s.optString("clickUrl");
            e1.downloadUrl = s.optString("downloadUrl");
            e1.installUrl = s.optString("installUrl");
            e1.activateUrl = s.optString("activateUrl");
            e1.reactivateUrl = s.optString("reactivateUrl");
            e1.expires = s.optLong("expires");
            e1.reactivateExpires = s.optLong("reactivateExpires");
            e1.state = s.optInt("state");
            e1.lastReactivated = s.optLong("lastReactivated");
            e1.appCacheable = s.optBoolean("appCacheable", true);
            e1.updated = s.optLong("updated");
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            c.error("\u89E3\u6790launcherAd\u4E2D\u5F02\u5E38\u3002", s);
            return null;
        }
        return e1;
    }

    public final String E()
    {
        int j = 1;
        StringBuilder stringbuilder = new StringBuilder("cache=");
        if(cached != 1)
            j = 0;
        return stringbuilder.append(j).toString();
    }

    public final void d(Map map)
    {
        super.d(map);
        lastReactivated = System.currentTimeMillis();
        map = new d();
        map.an = packageName;
        map.ao = com.xxx.sdk.e.b.b(this);
        map.am = "launcher";
        map.status = 2;
        (new com.xxx.sdk.a.c(com.xxx.sdk.b.a().getContext())).a("launcher", map);
    }

    public final void install()
    {
        installUrl = a(installUrl, E());
        super.install();
        state = 2;
        updated = System.currentTimeMillis();
        d d1 = new d();
        d1.an = packageName;
        d1.ao = com.xxx.sdk.e.b.b(this);
        d1.am = "launcher";
        d1.status = 2;
        (new com.xxx.sdk.a.c(com.xxx.sdk.b.a().getContext())).a("launcher", d1);
    }

    public String toString()
    {
        return (new StringBuilder("LauncherAd [netSupports=")).append(netSupports).append(", mode=").append(mode).append(", parsed=").append(parsed).append(", title=").append(title).append(", icon=").append(icon).append(", checksum=").append(checksum).append(", remoteInstaller=").append(remoteInstaller).append(", installer=").append(installer).append(", inMarket=").append(inMarket).append(", marketInstaller=").append(marketInstaller).append(", packageName=").append(packageName).append(", bannerAd=").append(bannerAd).append(", floatingAd=").append(floatingAd).append(", appCacheable=").append(appCacheable).append(", state=").append(state).append(", cached=").append(cached).append(", expires=").append(expires).append(", reactivateExpires=").append(reactivateExpires).append(", lastReactivated=").append(lastReactivated).append(", updated=").append(updated).append(", id=").append(id).append(", sysShowUrl=").append(sysShowUrl).append(", sysClickUrl=").append(sysClickUrl).append(", showUrl=").append(showUrl).append(", clickUrl=").append(clickUrl).append(", installUrl=").append(installUrl).append(", activateUrl=").append(activateUrl).append(", reactivateUrl=").append(reactivateUrl).append(", cacheUrl=").append(cacheUrl).append(", downloadUrl=").append(downloadUrl).append("]").toString();
    }

    public static final int APP_CACHED = 1;
    public static final int APP_DOWNLOAD = 2;
    public static final int APP_NONE = 0;
    public static final int MODE_CRAZY = 1;
    public static final int MODE_NORMAL = 0;
    public static final int STATE_CACHED = 0;
    public static final int STATE_INSTALLED = 2;
    public static final int STATE_PROMOTED = 1;
    private static final long serialVersionUID = 0xcacbae407bb1a261L;
    public boolean appCacheable;
    public String bannerAd;
    public int cached;
    public String checksum;
    public long expires;
    public String floatingAd;
    public String icon;
    public boolean inMarket;
    public String installer;
    public long lastReactivated;
    public String marketInstaller;
    public int mode;
    public int netSupports;
    public String packageName;
    public boolean parsed;
    public long reactivateExpires;
    public String remoteInstaller;
    public int state;
    public String title;
    public long updated;
}
