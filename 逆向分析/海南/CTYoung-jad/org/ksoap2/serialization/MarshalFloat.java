// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.io.IOException;
import java.math.BigDecimal;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2.serialization:
//            Marshal, SoapSerializationEnvelope, PropertyInfo

public class MarshalFloat
    implements Marshal
{

    public MarshalFloat()
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public Object readInstance(XmlPullParser xmlpullparser, String s, String s1, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException
    {
        xmlpullparser = xmlpullparser.nextText();
        if(s1.equals("float"))
            return new Float(xmlpullparser);
        if(s1.equals("double"))
            return new Double(xmlpullparser);
        if(s1.equals("decimal"))
            return new BigDecimal(xmlpullparser);
        else
            throw new RuntimeException("float, double, or decimal expected");
    }

    public void register(SoapSerializationEnvelope soapserializationenvelope)
    {
        String s = soapserializationenvelope.xsd;
        Class class1;
        if(class$java$lang$Float == null)
        {
            class1 = _mthclass$("java.lang.Float");
            class$java$lang$Float = class1;
        } else
        {
            class1 = class$java$lang$Float;
        }
        soapserializationenvelope.addMapping(s, "float", class1, this);
        s = soapserializationenvelope.xsd;
        if(class$java$lang$Double == null)
        {
            class1 = _mthclass$("java.lang.Double");
            class$java$lang$Double = class1;
        } else
        {
            class1 = class$java$lang$Double;
        }
        soapserializationenvelope.addMapping(s, "double", class1, this);
        s = soapserializationenvelope.xsd;
        if(class$java$math$BigDecimal == null)
        {
            class1 = _mthclass$("java.math.BigDecimal");
            class$java$math$BigDecimal = class1;
        } else
        {
            class1 = class$java$math$BigDecimal;
        }
        soapserializationenvelope.addMapping(s, "decimal", class1, this);
    }

    public void writeInstance(XmlSerializer xmlserializer, Object obj)
        throws IOException
    {
        xmlserializer.text(obj.toString());
    }

    static Class class$java$lang$Double;
    static Class class$java$lang$Float;
    static Class class$java$math$BigDecimal;
}
