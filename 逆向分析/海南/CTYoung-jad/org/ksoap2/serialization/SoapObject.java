// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package org.ksoap2.serialization:
//            AttributeContainer, KvmSerializable, PropertyInfo, NullSoapObject, 
//            AttributeInfo

public class SoapObject extends AttributeContainer
    implements KvmSerializable
{

    public SoapObject()
    {
        this("", "");
    }

    public SoapObject(String s, String s1)
    {
        properties = new Vector();
        namespace = s;
        name = s1;
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

    private Integer propertyIndex(String s)
    {
        if(s != null)
        {
            for(int i = 0; i < properties.size(); i++)
                if(s.equals(((PropertyInfo)properties.elementAt(i)).getName()))
                    return new Integer(i);

        }
        return null;
    }

    public SoapObject addProperty(String s, Object obj)
    {
        PropertyInfo propertyinfo = new PropertyInfo();
        propertyinfo.name = s;
        if(obj == null)
            s = PropertyInfo.OBJECT_CLASS;
        else
            s = obj.getClass();
        propertyinfo.type = s;
        propertyinfo.value = obj;
        return addProperty(propertyinfo);
    }

    public SoapObject addProperty(PropertyInfo propertyinfo)
    {
        properties.addElement(propertyinfo);
        return this;
    }

    public SoapObject addPropertyIfValue(String s, Object obj)
    {
        SoapObject soapobject = this;
        if(obj != null)
            soapobject = addProperty(s, obj);
        return soapobject;
    }

    public SoapObject addPropertyIfValue(PropertyInfo propertyinfo)
    {
        if(propertyinfo.value != null)
            properties.addElement(propertyinfo);
        return this;
    }

    public SoapObject addPropertyIfValue(PropertyInfo propertyinfo, Object obj)
    {
        SoapObject soapobject = this;
        if(obj != null)
        {
            propertyinfo.setValue(obj);
            soapobject = addProperty(propertyinfo);
        }
        return soapobject;
    }

    public SoapObject addSoapObject(SoapObject soapobject)
    {
        properties.addElement(soapobject);
        return this;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof SoapObject) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j;
        if(name.equals(((SoapObject) (obj = (SoapObject)obj)).name) && namespace.equals(((SoapObject) (obj)).namespace) && (j = properties.size()) == ((SoapObject) (obj)).properties.size())
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if(i >= j)
                        break label1;
                    if(!((SoapObject) (obj)).isPropertyEqual(properties.elementAt(i), i))
                        break label0;
                    i++;
                }
            } while(true);
        }
        if(true) goto _L1; else goto _L3
_L3:
        return attributesAreEqual(((AttributeContainer) (obj)));
    }

    public String getName()
    {
        return name;
    }

    public String getNamespace()
    {
        return namespace;
    }

    public Object getPrimitiveProperty(String s)
    {
        Object obj = propertyIndex(s);
        if(obj != null)
        {
            PropertyInfo propertyinfo = (PropertyInfo)properties.elementAt(((Integer) (obj)).intValue());
            Object obj1 = propertyinfo.getType();
            if(class$org$ksoap2$serialization$SoapObject == null)
            {
                obj = _mthclass$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = ((Class) (obj));
            } else
            {
                obj = class$org$ksoap2$serialization$SoapObject;
            }
            if(obj1 != obj && propertyinfo.getValue() != null)
                return propertyinfo.getValue();
            propertyinfo = new PropertyInfo();
            if(class$java$lang$String == null)
            {
                obj = _mthclass$("java.lang.String");
                class$java$lang$String = ((Class) (obj));
            } else
            {
                obj = class$java$lang$String;
            }
            propertyinfo.setType(obj);
            propertyinfo.setValue("");
            propertyinfo.setName(s);
            return propertyinfo.getValue();
        } else
        {
            throw new RuntimeException("illegal property: " + s);
        }
    }

    public String getPrimitivePropertyAsString(String s)
    {
        Object obj = propertyIndex(s);
        if(obj != null)
        {
            obj = (PropertyInfo)properties.elementAt(((Integer) (obj)).intValue());
            Object obj1 = ((PropertyInfo) (obj)).getType();
            if(class$org$ksoap2$serialization$SoapObject == null)
            {
                s = _mthclass$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = s;
            } else
            {
                s = class$org$ksoap2$serialization$SoapObject;
            }
            if(obj1 != s && ((PropertyInfo) (obj)).getValue() != null)
                return ((PropertyInfo) (obj)).getValue().toString();
            else
                return "";
        } else
        {
            throw new RuntimeException("illegal property: " + s);
        }
    }

    public Object getPrimitivePropertySafely(String s)
    {
        Object obj = propertyIndex(s);
        if(obj != null)
        {
            PropertyInfo propertyinfo = (PropertyInfo)properties.elementAt(((Integer) (obj)).intValue());
            Object obj1 = propertyinfo.getType();
            if(class$org$ksoap2$serialization$SoapObject == null)
            {
                obj = _mthclass$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = ((Class) (obj));
            } else
            {
                obj = class$org$ksoap2$serialization$SoapObject;
            }
            if(obj1 != obj && propertyinfo.getValue() != null)
                return propertyinfo.getValue().toString();
            propertyinfo = new PropertyInfo();
            if(class$java$lang$String == null)
            {
                obj = _mthclass$("java.lang.String");
                class$java$lang$String = ((Class) (obj));
            } else
            {
                obj = class$java$lang$String;
            }
            propertyinfo.setType(obj);
            propertyinfo.setValue("");
            propertyinfo.setName(s);
            return propertyinfo.getValue();
        } else
        {
            return new NullSoapObject();
        }
    }

    public String getPrimitivePropertySafelyAsString(String s)
    {
        s = propertyIndex(s);
        if(s != null)
        {
            PropertyInfo propertyinfo = (PropertyInfo)properties.elementAt(s.intValue());
            Object obj = propertyinfo.getType();
            if(class$org$ksoap2$serialization$SoapObject == null)
            {
                s = _mthclass$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = s;
            } else
            {
                s = class$org$ksoap2$serialization$SoapObject;
            }
            if(obj != s && propertyinfo.getValue() != null)
                return propertyinfo.getValue().toString();
            else
                return "";
        } else
        {
            return "";
        }
    }

    public Object getProperty(int i)
    {
        Object obj = properties.elementAt(i);
        if(obj instanceof PropertyInfo)
            return ((PropertyInfo)obj).getValue();
        else
            return (SoapObject)obj;
    }

    public Object getProperty(String s)
    {
        Integer integer = propertyIndex(s);
        if(integer != null)
            return getProperty(integer.intValue());
        else
            throw new RuntimeException("illegal property: " + s);
    }

    public String getPropertyAsString(int i)
    {
        return ((PropertyInfo)properties.elementAt(i)).getValue().toString();
    }

    public String getPropertyAsString(String s)
    {
        Integer integer = propertyIndex(s);
        if(integer != null)
            return getProperty(integer.intValue()).toString();
        else
            throw new RuntimeException("illegal property: " + s);
    }

    public int getPropertyCount()
    {
        return properties.size();
    }

    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyinfo)
    {
        getPropertyInfo(i, propertyinfo);
    }

    public void getPropertyInfo(int i, PropertyInfo propertyinfo)
    {
        Object obj = properties.elementAt(i);
        if(obj instanceof PropertyInfo)
        {
            obj = (PropertyInfo)obj;
            propertyinfo.name = ((PropertyInfo) (obj)).name;
            propertyinfo.namespace = ((PropertyInfo) (obj)).namespace;
            propertyinfo.flags = ((PropertyInfo) (obj)).flags;
            propertyinfo.type = ((PropertyInfo) (obj)).type;
            propertyinfo.elementType = ((PropertyInfo) (obj)).elementType;
            propertyinfo.value = ((PropertyInfo) (obj)).value;
            propertyinfo.multiRef = ((PropertyInfo) (obj)).multiRef;
            return;
        } else
        {
            propertyinfo.name = null;
            propertyinfo.namespace = null;
            propertyinfo.flags = 0;
            propertyinfo.type = null;
            propertyinfo.elementType = null;
            propertyinfo.value = obj;
            propertyinfo.multiRef = false;
            return;
        }
    }

    public Object getPropertySafely(String s)
    {
        s = propertyIndex(s);
        if(s != null)
            return getProperty(s.intValue());
        else
            return new NullSoapObject();
    }

    public Object getPropertySafely(String s, Object obj)
    {
        s = propertyIndex(s);
        if(s != null)
            obj = getProperty(s.intValue());
        return obj;
    }

    public String getPropertySafelyAsString(String s)
    {
        s = propertyIndex(s);
        if(s != null)
        {
            s = ((String) (getProperty(s.intValue())));
            if(s == null)
                return "";
            else
                return s.toString();
        } else
        {
            return "";
        }
    }

    public String getPropertySafelyAsString(String s, Object obj)
    {
        s = propertyIndex(s);
        if(s != null)
        {
            s = ((String) (getProperty(s.intValue())));
            if(s != null)
                return s.toString();
            else
                return "";
        }
        if(obj != null)
            return obj.toString();
        else
            return "";
    }

    public boolean hasProperty(String s)
    {
        return propertyIndex(s) != null;
    }

    public boolean isPropertyEqual(Object obj, int i)
    {
        if(i < getPropertyCount()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj1;
        obj1 = properties.elementAt(i);
        if(!(obj instanceof PropertyInfo) || !(obj1 instanceof PropertyInfo))
            continue; /* Loop/switch isn't completed */
        obj = (PropertyInfo)obj;
        obj1 = (PropertyInfo)obj1;
        if(!((PropertyInfo) (obj)).getName().equals(((PropertyInfo) (obj1)).getName()) || !((PropertyInfo) (obj)).getValue().equals(((PropertyInfo) (obj1)).getValue())) goto _L1; else goto _L3
_L3:
        return true;
        if(!(obj instanceof SoapObject) || !(obj1 instanceof SoapObject)) goto _L1; else goto _L4
_L4:
        return ((SoapObject)obj).equals((SoapObject)obj1);
    }

    public SoapObject newInstance()
    {
        SoapObject soapobject = new SoapObject(namespace, name);
        int i = 0;
        while(i < properties.size()) 
        {
            Object obj = properties.elementAt(i);
            if(obj instanceof PropertyInfo)
                soapobject.addProperty((PropertyInfo)((PropertyInfo)properties.elementAt(i)).clone());
            else
            if(obj instanceof SoapObject)
                soapobject.addSoapObject(((SoapObject)obj).newInstance());
            i++;
        }
        for(int j = 0; j < getAttributeCount(); j++)
        {
            AttributeInfo attributeinfo = new AttributeInfo();
            getAttributeInfo(j, attributeinfo);
            soapobject.addAttribute(attributeinfo);
        }

        return soapobject;
    }

    public void setProperty(int i, Object obj)
    {
        Object obj1 = properties.elementAt(i);
        if(obj1 instanceof PropertyInfo)
            ((PropertyInfo)obj1).setValue(obj);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("" + name + "{");
        int i = 0;
        while(i < getPropertyCount()) 
        {
            Object obj = properties.elementAt(i);
            if(obj instanceof PropertyInfo)
                stringbuffer.append("").append(((PropertyInfo)obj).getName()).append("=").append(getProperty(i)).append("; ");
            else
                stringbuffer.append(((SoapObject)obj).toString());
            i++;
        }
        stringbuffer.append("}");
        return stringbuffer.toString();
    }

    private static final String EMPTY_STRING = "";
    static Class class$java$lang$String;
    static Class class$org$ksoap2$serialization$SoapObject;
    protected String name;
    protected String namespace;
    protected Vector properties;
}
