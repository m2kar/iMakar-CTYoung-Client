// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.io.IOException;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2.serialization:
//            PropertyInfo, SoapSerializationEnvelope

public interface Marshal
{

    public abstract Object readInstance(XmlPullParser xmlpullparser, String s, String s1, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException;

    public abstract void register(SoapSerializationEnvelope soapserializationenvelope);

    public abstract void writeInstance(XmlSerializer xmlserializer, Object obj)
        throws IOException;
}
