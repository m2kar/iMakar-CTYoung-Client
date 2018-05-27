// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e;

import com.xxx.sdk.e.a.a.d.h;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

// Referenced classes of package com.xxx.sdk.e.a.a.e:
//            e, b

public final class d
{

    public d()
    {
    }

    private static void Z()
    {
        String s = j(i("https://android.googlesource.com/platform/frameworks/base/+/master/core/res/res/values/public.xml"));
        if(s != null)
        {
            SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
            ArrayList arraylist = new ArrayList();
            e e1 = new e(arraylist);
            saxparser.parse(new ByteArrayInputStream(s.getBytes(UTF_8)), e1);
            b b1;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); System.out.println(String.format("%s=%d", new Object[] {
    b1.c, b1.b
})))
                b1 = (b)iterator.next();

        }
    }

    private static void aa()
    {
        int k;
        int l;
        String as[];
        String s = j(i("https://android.googlesource.com/platform/frameworks/base/+/master/api/current.txt"));
        k = s.indexOf("R.style");
        as = s.substring(k, s.indexOf("}", k)).split("\n");
        l = as.length;
        k = 0;
_L9:
        if(k >= l) goto _L2; else goto _L1
_L1:
        String s2 = as[k].trim();
        if(!s2.startsWith("field public static final")) goto _L4; else goto _L3
_L3:
        if(!h.isEmpty(s2)) goto _L6; else goto _L5
_L5:
        String s1 = s2;
_L7:
        s1 = s1.replace("deprecated ", "").substring(30).replace("_", ".");
        System.out.println(s1);
_L4:
        k++;
        continue; /* Loop/switch isn't completed */
_L6:
        if(";".isEmpty())
        {
            s1 = "";
        } else
        {
            int i1 = s2.indexOf(";");
            s1 = s2;
            if(i1 != -1)
                s1 = s2.substring(0, i1);
        }
        if(true) goto _L7; else goto _L2
_L2:
        return;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private static void ab()
    {
        new d();
        String s = j(i("https://android.googlesource.com/platform/frameworks/base/+/master/core/res/res/values/public.xml"));
        if(s != null)
        {
            SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
            ArrayList arraylist = new ArrayList();
            e e1 = new e(arraylist);
            saxparser.parse(new ByteArrayInputStream(s.getBytes(UTF_8)), e1);
            b b1;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); System.out.println(String.format("%s=%d", new Object[] {
    b1.c, b1.b
})))
                b1 = (b)iterator.next();

        }
    }

    private static String i(String s)
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        String s1;
        s.setRequestMethod("GET");
        s.setReadTimeout(10000);
        s.setConnectTimeout(10000);
        s1 = new String(h.a(s.getInputStream()), UTF_8);
        s.disconnect();
        return s1;
        Exception exception;
        exception;
        s.disconnect();
        throw exception;
    }

    private static String j(String s)
    {
        s = Pattern.compile("<ol class=\"prettyprint\">(.*?)</ol>").matcher(s);
        if(s.find())
            return s.group(1).replace("</li>", "\n").replaceAll("<[^>]+>", "").replace("&lt;", "<").replace("&quot;", "\"").replace("&gt;", ">");
        else
            return null;
    }

    private static void w(String s)
    {
        SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
        ArrayList arraylist = new ArrayList();
        e e1 = new e(arraylist);
        saxparser.parse(new ByteArrayInputStream(s.getBytes(UTF_8)), e1);
        b b1;
        for(s = arraylist.iterator(); s.hasNext(); System.out.println(String.format("%s=%d", new Object[] {
    b1.c, b1.b
})))
            b1 = (b)s.next();

    }

    private static Charset UTF_8 = Charset.forName("UTF-8");

}
