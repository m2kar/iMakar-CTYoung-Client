// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.io.IOException;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2.serialization:
//            Marshal, SoapSerializationEnvelope, PropertyInfo, AttributeContainer, 
//            AttributeInfo

class DM
    implements Marshal
{

    DM()
    {
    }

    public Object readInstance(XmlPullParser xmlpullparser, String s, String s1, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException
    {
        s = xmlpullparser.nextText();
        xmlpullparser = s;
        switch(s1.charAt(0))
        {
        default:
            throw new RuntimeException();

        case 105: // 'i'
            xmlpullparser = new Integer(Integer.parseInt(s));
            // fall through

        case 115: // 's'
            return xmlpullparser;

        case 108: // 'l'
            return new Long(Long.parseLong(s));

        case 98: // 'b'
            return new Boolean(SoapEnvelope.stringToBoolean(s));
        }
    }

    public void register(SoapSerializationEnvelope soapserializationenvelope)
    {
        soapserializationenvelope.addMapping(soapserializationenvelope.xsd, "int", PropertyInfo.INTEGER_CLASS, this);
        soapserializationenvelope.addMapping(soapserializationenvelope.xsd, "long", PropertyInfo.LONG_CLASS, this);
        soapserializationenvelope.addMapping(soapserializationenvelope.xsd, "string", PropertyInfo.STRING_CLASS, this);
        soapserializationenvelope.addMapping(soapserializationenvelope.xsd, "boolean", PropertyInfo.BOOLEAN_CLASS, this);
    }

    public void writeInstance(XmlSerializer xmlserializer, Object obj)
        throws IOException
    {
        if(obj instanceof AttributeContainer)
        {
            AttributeContainer attributecontainer = (AttributeContainer)obj;
            int j = attributecontainer.getAttributeCount();
            for(int i = 0; i < j; i++)
            {
                AttributeInfo attributeinfo = new AttributeInfo();
                attributecontainer.getAttributeInfo(i, attributeinfo);
                xmlserializer.attribute(attributeinfo.getNamespace(), attributeinfo.getName(), attributeinfo.getValue().toString());
            }

        }
        xmlserializer.text(obj.toString());
    }
}
