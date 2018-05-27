// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2;

import java.io.IOException;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.*;

public class SoapFault extends IOException
{

    public SoapFault()
    {
        version = 110;
    }

    public SoapFault(int i)
    {
        version = i;
    }

    public String getMessage()
    {
        return faultstring;
    }

    public void parse(XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        xmlpullparser.require(2, "http://schemas.xmlsoap.org/soap/envelope/", "Fault");
_L2:
        String s;
label0:
        {
            if(xmlpullparser.nextTag() == 2)
            {
                s = xmlpullparser.getName();
                if(!s.equals("detail"))
                    break label0;
                detail = new Node();
                detail.parse(xmlpullparser);
                if(!xmlpullparser.getNamespace().equals("http://schemas.xmlsoap.org/soap/envelope/") || !xmlpullparser.getName().equals("Fault"))
                    continue; /* Loop/switch isn't completed */
            }
            xmlpullparser.require(3, "http://schemas.xmlsoap.org/soap/envelope/", "Fault");
            xmlpullparser.nextTag();
            return;
        }
        if(!s.equals("faultcode"))
            break; /* Loop/switch isn't completed */
        faultcode = xmlpullparser.nextText();
_L3:
        xmlpullparser.require(3, null, s);
        if(true) goto _L2; else goto _L1
_L1:
        if(s.equals("faultstring"))
            faultstring = xmlpullparser.nextText();
        else
        if(s.equals("faultactor"))
            faultactor = xmlpullparser.nextText();
        else
            throw new RuntimeException("unexpected tag:" + s);
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public String toString()
    {
        return "SoapFault - faultcode: '" + faultcode + "' faultstring: '" + faultstring + "' faultactor: '" + faultactor + "' detail: " + detail;
    }

    public void write(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Fault");
        xmlserializer.startTag(null, "faultcode");
        xmlserializer.text("" + faultcode);
        xmlserializer.endTag(null, "faultcode");
        xmlserializer.startTag(null, "faultstring");
        xmlserializer.text("" + faultstring);
        xmlserializer.endTag(null, "faultstring");
        xmlserializer.startTag(null, "detail");
        if(detail != null)
            detail.write(xmlserializer);
        xmlserializer.endTag(null, "detail");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Fault");
    }

    private static final long serialVersionUID = 0xf6d39L;
    public Node detail;
    public String faultactor;
    public String faultcode;
    public String faultstring;
    public int version;
}
