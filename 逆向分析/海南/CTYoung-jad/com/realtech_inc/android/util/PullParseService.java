// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.android.util;

import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.realtech_inc.android.util:
//            XmlParserResult

public class PullParseService
{

    public PullParseService()
    {
    }

    public static XmlParserResult parse(String s)
    {
        XmlPullParser xmlpullparser;
        xmlpullparser = Xml.newPullParser();
        s = new ByteArrayInputStream(s.getBytes());
        int i;
        xmlpullparser.setInput(s, "utf-8");
        i = xmlpullparser.getEventType();
        s = null;
_L2:
        if(i == 1)
            break; /* Loop/switch isn't completed */
        if(i != 2)
            break MISSING_BLOCK_LABEL_63;
        s = new XmlParserResult(xmlpullparser.getName());
        parserXmlTag(xmlpullparser, s);
        i = xmlpullparser.next();
        if(true) goto _L2; else goto _L1
_L1:
        return s;
        s;
_L7:
        s.printStackTrace();
_L3:
        return null;
        s;
_L5:
        s.printStackTrace();
          goto _L3
        s;
_L4:
        s.printStackTrace();
          goto _L3
        s;
          goto _L4
        s;
          goto _L5
        s;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static void parserXmlTag(XmlPullParser xmlpullparser, XmlParserResult xmlparserresult)
        throws XmlPullParserException, IOException
    {
        int i = xmlpullparser.next();
        while(i != 3) 
        {
            if(i == 4)
                xmlparserresult.setValue(xmlpullparser.getText());
            else
            if(i == 2)
                parserXmlTag(xmlpullparser, xmlparserresult.addSubElement(xmlpullparser.getName()));
            i = xmlpullparser.next();
        }
    }

    private static final String DEFALT_CHARSET = "utf-8";
}
