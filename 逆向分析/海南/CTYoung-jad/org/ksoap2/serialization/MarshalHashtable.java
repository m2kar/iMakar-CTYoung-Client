// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2.serialization:
//            Marshal, PropertyInfo, SoapSerializationEnvelope, SoapObject

public class MarshalHashtable
    implements Marshal
{
    class ItemSoapObject extends SoapObject
    {

        public void setProperty(int i, Object obj)
        {
            if(resolvedIndex == -1)
            {
                super.setProperty(i, obj);
                resolvedIndex = i;
                return;
            }
            Object obj1;
            if(resolvedIndex == 0)
                obj1 = getProperty(0);
            else
                obj1 = getProperty(1);
            if(i == 0)
            {
                h.put(obj, obj1);
                return;
            } else
            {
                h.put(obj1, obj);
                return;
            }
        }

        Hashtable h;
        int resolvedIndex;
        private final MarshalHashtable this$0;

        ItemSoapObject(Hashtable hashtable)
        {
            super(null, null);
            this$0 = MarshalHashtable.this;
            resolvedIndex = -1;
            h = hashtable;
            addProperty("key", null);
            addProperty("value", null);
        }
    }


    public MarshalHashtable()
    {
    }

    public Object readInstance(XmlPullParser xmlpullparser, String s, String s1, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException
    {
        s = new Hashtable();
        s1 = xmlpullparser.getName();
        for(; xmlpullparser.nextTag() != 3; xmlpullparser.require(3, null, "item"))
        {
            propertyinfo = new ItemSoapObject(s);
            xmlpullparser.require(2, null, "item");
            xmlpullparser.nextTag();
            Object obj = envelope.read(xmlpullparser, propertyinfo, 0, null, null, PropertyInfo.OBJECT_TYPE);
            xmlpullparser.nextTag();
            if(obj != null)
                propertyinfo.setProperty(0, obj);
            obj = envelope.read(xmlpullparser, propertyinfo, 1, null, null, PropertyInfo.OBJECT_TYPE);
            xmlpullparser.nextTag();
            if(obj != null)
                propertyinfo.setProperty(1, obj);
        }

        xmlpullparser.require(3, null, s1);
        return s;
    }

    public void register(SoapSerializationEnvelope soapserializationenvelope)
    {
        envelope = soapserializationenvelope;
        soapserializationenvelope.addMapping("http://xml.apache.org/xml-soap", "Map", HASHTABLE_CLASS, this);
    }

    public void writeInstance(XmlSerializer xmlserializer, Object obj)
        throws IOException
    {
        obj = (Hashtable)obj;
        SoapObject soapobject = new SoapObject(null, null);
        soapobject.addProperty("key", null);
        soapobject.addProperty("value", null);
        for(Enumeration enumeration = ((Hashtable) (obj)).keys(); enumeration.hasMoreElements(); xmlserializer.endTag("", "item"))
        {
            xmlserializer.startTag("", "item");
            Object obj1 = enumeration.nextElement();
            soapobject.setProperty(0, obj1);
            soapobject.setProperty(1, ((Hashtable) (obj)).get(obj1));
            envelope.writeObjectBodyWithAttributes(xmlserializer, soapobject);
        }

    }

    public static final Class HASHTABLE_CLASS = (new Hashtable()).getClass();
    public static final String NAME = "Map";
    public static final String NAMESPACE = "http://xml.apache.org/xml-soap";
    SoapSerializationEnvelope envelope;

}
