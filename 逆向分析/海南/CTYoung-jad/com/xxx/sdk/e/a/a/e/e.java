// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e;

import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package com.xxx.sdk.e.a.a.e:
//            b, d

final class e extends DefaultHandler
{

    e(List list)
    {
        s = list;
        super();
    }

    public final void startElement(String s1, String s2, String s3, Attributes attributes)
    {
        if(s3.equals("public"))
            if((s1 = attributes.getValue("type")) != null && s1.equals("attr") && (s2 = attributes.getValue("id")) != null)
            {
                s3 = attributes.getValue("name");
                s1 = s2;
                if(s2.startsWith("0x"))
                    s1 = s2.substring(2);
                int i = Integer.parseInt(s1, 16);
                s.add(new b(Integer.valueOf(i), s3));
                return;
            }
    }

    private d a;
    private List s;
}
