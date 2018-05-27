// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.b;

import com.xxx.sdk.e.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.xxx.sdk.b:
//            i

public final class h
{

    public h()
    {
        a = i.browser;
    }

    private static h a()
    {
        return new h();
    }

    private h a(i j)
    {
        a = j;
        return this;
    }

    private h a(String s)
    {
        protocol = s;
        return this;
    }

    public static h b(String s)
    {
        if(com.xxx.sdk.e.b.f(s))
            return null;
        h h1 = new h();
        if(s.endsWith(".apk"))
        {
            h1.a = i.app;
            Matcher matcher = b.matcher(s);
            if(matcher.find())
            {
                h1.protocol = matcher.group(0);
                return h1;
            }
        }
        h1.a = i.browser;
        h1.protocol = s;
        return h1;
    }

    public final String toString()
    {
        return (new StringBuilder("Target [method=")).append(a).append(", protocol=").append(protocol).append(", more=").append(bb).append("]").toString();
    }

    private static Pattern b = Pattern.compile("^http(s)?://([a-zA-z_$]+[a-zA-z_$0-9]*[.])+apk$");
    public i a;
    public String bb;
    public String protocol;

}
