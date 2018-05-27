// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2;

import java.io.IOException;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2:
//            SoapFault

public class SoapFault12 extends SoapFault
{

    public SoapFault12()
    {
        version = 120;
    }

    public SoapFault12(int i)
    {
        version = i;
    }

    private void parseSelf(XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        xmlpullparser.require(2, "http://www.w3.org/2003/05/soap-envelope", "Fault");
        while(xmlpullparser.nextTag() == 2) 
        {
            String s = xmlpullparser.getName();
            xmlpullparser.nextTag();
            if(s.equals("Code"))
            {
                Code = new Node();
                Code.parse(xmlpullparser);
            } else
            if(s.equals("Reason"))
            {
                Reason = new Node();
                Reason.parse(xmlpullparser);
            } else
            if(s.equals("Node"))
            {
                Node = new Node();
                Node.parse(xmlpullparser);
            } else
            if(s.equals("Role"))
            {
                Role = new Node();
                Role.parse(xmlpullparser);
            } else
            if(s.equals("Detail"))
            {
                Detail = new Node();
                Detail.parse(xmlpullparser);
            } else
            {
                throw new RuntimeException("unexpected tag:" + s);
            }
            xmlpullparser.require(3, "http://www.w3.org/2003/05/soap-envelope", s);
        }
        xmlpullparser.require(3, "http://www.w3.org/2003/05/soap-envelope", "Fault");
        xmlpullparser.nextTag();
    }

    public String getMessage()
    {
        return Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
    }

    public void parse(XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        parseSelf(xmlpullparser);
        faultcode = Code.getElement("http://www.w3.org/2003/05/soap-envelope", "Value").getText(0);
        faultstring = Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
        detail = Detail;
        faultactor = null;
    }

    public String toString()
    {
        String s = Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
        String s1 = Code.getElement("http://www.w3.org/2003/05/soap-envelope", "Value").getText(0);
        return "Code: " + s1 + ", Reason: " + s;
    }

    public void write(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Fault");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Code");
        Code.write(xmlserializer);
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Code");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Reason");
        Reason.write(xmlserializer);
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Reason");
        if(Node != null)
        {
            xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Node");
            Node.write(xmlserializer);
            xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Node");
        }
        if(Role != null)
        {
            xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Role");
            Role.write(xmlserializer);
            xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Role");
        }
        if(Detail != null)
        {
            xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Detail");
            Detail.write(xmlserializer);
            xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Detail");
        }
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Fault");
    }

    private static final long serialVersionUID = 0xf7121L;
    public Node Code;
    public Node Detail;
    public Node Node;
    public Node Reason;
    public Node Role;
}
