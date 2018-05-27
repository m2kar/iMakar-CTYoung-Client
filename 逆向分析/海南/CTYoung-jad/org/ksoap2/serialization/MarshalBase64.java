// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.io.IOException;
import org.kobjects.base64.Base64;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2.serialization:
//            Marshal, SoapSerializationEnvelope, PropertyInfo

public class MarshalBase64
    implements Marshal
{

    public MarshalBase64()
    {
    }

    public Object readInstance(XmlPullParser xmlpullparser, String s, String s1, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException
    {
        return Base64.decode(xmlpullparser.nextText());
    }

    public void register(SoapSerializationEnvelope soapserializationenvelope)
    {
        soapserializationenvelope.addMapping(soapserializationenvelope.xsd, "base64Binary", BYTE_ARRAY_CLASS, this);
        soapserializationenvelope.addMapping("http://schemas.xmlsoap.org/soap/encoding/", "base64", BYTE_ARRAY_CLASS, this);
    }

    public void writeInstance(XmlSerializer xmlserializer, Object obj)
        throws IOException
    {
        xmlserializer.text(Base64.encode((byte[])(byte[])obj));
    }

    public static Class BYTE_ARRAY_CLASS = (new byte[0]).getClass();

}
