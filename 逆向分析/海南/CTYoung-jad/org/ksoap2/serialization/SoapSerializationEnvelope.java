// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.serialization;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.*;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2.serialization:
//            DM, PropertyInfo, Marshal, HasAttributes, 
//            AttributeInfo, SoapPrimitive, SoapObject, KvmSerializable, 
//            FwdRef

public class SoapSerializationEnvelope extends SoapEnvelope
{

    public SoapSerializationEnvelope(int i)
    {
        super(i);
        properties = new Hashtable();
        idMap = new Hashtable();
        qNameToClass = new Hashtable();
        classToQName = new Hashtable();
        addAdornments = true;
        addMapping(enc, "Array", PropertyInfo.VECTOR_CLASS);
        DEFAULT_MARSHAL.register(this);
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

    private int getIndex(String s, int i, int j)
    {
        if(s != null) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        if(s.length() - i < 3) goto _L1; else goto _L3
_L3:
        i = Integer.parseInt(s.substring(i + 1, s.length() - 1));
        return i;
        s;
        return j;
    }

    private void writeAttributes(XmlSerializer xmlserializer, HasAttributes hasattributes)
        throws IOException
    {
        int j = hasattributes.getAttributeCount();
        int i = 0;
        while(i < j) 
        {
            Object obj = new AttributeInfo();
            hasattributes.getAttributeInfo(i, ((AttributeInfo) (obj)));
            String s = ((AttributeInfo) (obj)).getNamespace();
            String s1 = ((AttributeInfo) (obj)).getName();
            if(((AttributeInfo) (obj)).getValue() != null)
                obj = ((AttributeInfo) (obj)).getValue().toString();
            else
                obj = "";
            xmlserializer.attribute(s, s1, ((String) (obj)));
            i++;
        }
    }

    public void addMapping(String s, String s1, Class class1)
    {
        addMapping(s, s1, class1, null);
    }

    public void addMapping(String s, String s1, Class class1, Marshal marshal)
    {
        Hashtable hashtable = qNameToClass;
        SoapPrimitive soapprimitive = new SoapPrimitive(s, s1, null);
        Object obj;
        if(marshal == null)
            obj = class1;
        else
            obj = marshal;
        hashtable.put(soapprimitive, obj);
        classToQName.put(class1.getName(), ((Object) (new Object[] {
            s, s1, null, marshal
        })));
    }

    public void addTemplate(SoapObject soapobject)
    {
        qNameToClass.put(new SoapPrimitive(soapobject.namespace, soapobject.name, null), soapobject);
    }

    public Object[] getInfo(Object obj, Object obj1)
    {
        Object obj2;
        obj2 = obj;
        if(obj == null)
            if((obj1 instanceof SoapObject) || (obj1 instanceof SoapPrimitive))
                obj2 = obj1;
            else
                obj2 = obj1.getClass();
        if(!(obj2 instanceof SoapObject)) goto _L2; else goto _L1
_L1:
        obj1 = (SoapObject)obj2;
        obj = ((Object) (new Object[4]));
        obj[0] = ((SoapObject) (obj1)).getNamespace();
        obj[1] = ((SoapObject) (obj1)).getName();
        obj[2] = null;
        obj[3] = null;
_L4:
        return ((Object []) (obj));
_L2:
        if(obj2 instanceof SoapPrimitive)
        {
            obj = (SoapPrimitive)obj2;
            return (new Object[] {
                ((SoapPrimitive) (obj)).getNamespace(), ((SoapPrimitive) (obj)).getName(), null, DEFAULT_MARSHAL
            });
        }
        if(!(obj2 instanceof Class) || obj2 == PropertyInfo.OBJECT_CLASS)
            break; /* Loop/switch isn't completed */
        obj1 = ((Object) ((Object[])(Object[])classToQName.get(((Class)obj2).getName())));
        obj = obj1;
        if(obj1 != null) goto _L4; else goto _L3
_L3:
        return (new Object[] {
            xsd, "anyType", null, null
        });
    }

    public Object getResponse()
        throws SoapFault
    {
        KvmSerializable kvmserializable;
        if(bodyIn instanceof SoapFault)
            throw (SoapFault)bodyIn;
        kvmserializable = (KvmSerializable)bodyIn;
        if(kvmserializable.getPropertyCount() != 0) goto _L2; else goto _L1
_L1:
        Vector vector = null;
_L4:
        return vector;
_L2:
        if(kvmserializable.getPropertyCount() == 1)
            return kvmserializable.getProperty(0);
        Vector vector1 = new Vector();
        int i = 0;
        do
        {
            vector = vector1;
            if(i >= kvmserializable.getPropertyCount())
                continue;
            vector1.add(kvmserializable.getProperty(i));
            i++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isAddAdornments()
    {
        return addAdornments;
    }

    public void parseBody(XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        bodyIn = null;
        xmlpullparser.nextTag();
        if(xmlpullparser.getEventType() == 2 && xmlpullparser.getNamespace().equals(env) && xmlpullparser.getName().equals("Fault"))
        {
            Object obj;
            if(version < 120)
                obj = new SoapFault(version);
            else
                obj = new SoapFault12(version);
            ((SoapFault) (obj)).parse(xmlpullparser);
            bodyIn = obj;
        } else
        {
            while(xmlpullparser.getEventType() == 2) 
            {
                String s = xmlpullparser.getAttributeValue(enc, "root");
                Object obj1 = read(xmlpullparser, null, -1, xmlpullparser.getNamespace(), xmlpullparser.getName(), PropertyInfo.OBJECT_TYPE);
                if("1".equals(s) || bodyIn == null)
                    bodyIn = obj1;
                xmlpullparser.nextTag();
            }
        }
    }

    public Object read(XmlPullParser xmlpullparser, Object obj, int i, String s, String s1, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException
    {
        String s2;
        String s5;
        s5 = xmlpullparser.getName();
        s2 = xmlpullparser.getAttributeValue(null, "href");
        if(s2 == null) goto _L2; else goto _L1
_L1:
label0:
        {
            if(obj == null)
                throw new RuntimeException("href at root level?!?");
            propertyinfo = s2.substring(1);
            s1 = ((String) (idMap.get(propertyinfo)));
            if(s1 != null)
            {
                s = s1;
                if(!(s1 instanceof FwdRef))
                    break label0;
            }
            s = new FwdRef();
            s.next = (FwdRef)s1;
            s.obj = obj;
            s.index = i;
            idMap.put(propertyinfo, s);
            s = null;
        }
        xmlpullparser.nextTag();
        xmlpullparser.require(3, null, s5);
        obj = s;
_L8:
        xmlpullparser.require(3, null, s5);
        return obj;
_L2:
        String s3 = xmlpullparser.getAttributeValue(xsi, "nil");
        String s6 = xmlpullparser.getAttributeValue(null, "id");
        obj = s3;
        if(s3 == null)
            obj = xmlpullparser.getAttributeValue(xsi, "null");
        if(obj != null && SoapEnvelope.stringToBoolean(((String) (obj))))
        {
            s = null;
            xmlpullparser.nextTag();
            xmlpullparser.require(3, null, s5);
        } else
        {
            String s7 = xmlpullparser.getAttributeValue(xsi, "type");
            String s4;
            if(s7 != null)
            {
                i = s7.indexOf(':');
                s4 = s7.substring(i + 1);
                if(i == -1)
                    obj = "";
                else
                    obj = s7.substring(0, i);
                obj = xmlpullparser.getNamespace(((String) (obj)));
            } else
            {
                obj = s;
                s4 = s1;
                if(s1 == null)
                {
                    obj = s;
                    s4 = s1;
                    if(s == null)
                        if(xmlpullparser.getAttributeValue(enc, "arrayType") != null)
                        {
                            obj = enc;
                            s4 = "Array";
                        } else
                        {
                            s = ((String) (getInfo(propertyinfo.type, null)));
                            obj = (String)s[0];
                            s4 = (String)s[1];
                        }
                }
            }
            if(s7 == null)
                implicitTypes = true;
            s1 = ((String) (readInstance(xmlpullparser, ((String) (obj)), s4, propertyinfo)));
            s = s1;
            if(s1 == null)
                s = ((String) (readUnknown(xmlpullparser, ((String) (obj)), s4)));
        }
        obj = s;
        if(s6 == null)
            continue; /* Loop/switch isn't completed */
        obj = idMap.get(s6);
        if(!(obj instanceof FwdRef)) goto _L4; else goto _L3
_L3:
        obj = (FwdRef)obj;
        do
        {
            if(((FwdRef) (obj)).obj instanceof KvmSerializable)
                ((KvmSerializable)((FwdRef) (obj)).obj).setProperty(((FwdRef) (obj)).index, s);
            else
                ((Vector)((FwdRef) (obj)).obj).setElementAt(s, ((FwdRef) (obj)).index);
            s1 = ((FwdRef) (obj)).next;
            obj = s1;
        } while(s1 != null);
_L6:
        idMap.put(s6, s);
        obj = s;
        continue; /* Loop/switch isn't completed */
_L4:
        if(obj == null) goto _L6; else goto _L5
_L5:
        throw new RuntimeException("double ID");
        if(true) goto _L8; else goto _L7
_L7:
    }

    public Object readInstance(XmlPullParser xmlpullparser, String s, String s1, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException
    {
        Object obj = qNameToClass.get(new SoapPrimitive(s, s1, null));
        if(obj == null)
            return null;
        if(obj instanceof Marshal)
            return ((Marshal)obj).readInstance(xmlpullparser, s, s1, propertyinfo);
        if(obj instanceof SoapObject)
        {
            s = ((SoapObject)obj).newInstance();
        } else
        {
            Class class1;
            if(class$org$ksoap2$serialization$SoapObject == null)
            {
                class1 = _mthclass$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = class1;
            } else
            {
                class1 = class$org$ksoap2$serialization$SoapObject;
            }
            if(obj == class1)
                s = new SoapObject(s, s1);
            else
                try
                {
                    s = ((String) (((Class)obj).newInstance()));
                }
                // Misplaced declaration of an exception variable
                catch(XmlPullParser xmlpullparser)
                {
                    throw new RuntimeException(xmlpullparser.toString());
                }
        }
        if(s instanceof SoapObject)
        {
            readSerializable(xmlpullparser, (SoapObject)s);
            return s;
        }
        if(s instanceof KvmSerializable)
        {
            readSerializable(xmlpullparser, (KvmSerializable)s);
            return s;
        }
        if(s instanceof Vector)
        {
            readVector(xmlpullparser, (Vector)s, propertyinfo.elementType);
            return s;
        } else
        {
            throw new RuntimeException("no deserializer for " + s.getClass());
        }
    }

    protected void readSerializable(XmlPullParser xmlpullparser, KvmSerializable kvmserializable)
        throws IOException, XmlPullParserException
    {
label0:
        do
        {
            String s;
label1:
            {
                if(xmlpullparser.nextTag() == 3)
                    break label0;
                s = xmlpullparser.getName();
                if(implicitTypes && (kvmserializable instanceof SoapObject))
                    break label1;
                PropertyInfo propertyinfo = new PropertyInfo();
                int j = kvmserializable.getPropertyCount();
                boolean flag = false;
                boolean flag1;
                for(int i = 0; i < j && !flag; flag = flag1)
                {
label2:
                    {
                        propertyinfo.clear();
                        kvmserializable.getPropertyInfo(i, properties, propertyinfo);
                        if(!s.equals(propertyinfo.name) || propertyinfo.namespace != null)
                        {
                            flag1 = flag;
                            if(!s.equals(propertyinfo.name))
                                break label2;
                            flag1 = flag;
                            if(!xmlpullparser.getNamespace().equals(propertyinfo.namespace))
                                break label2;
                        }
                        flag1 = true;
                        kvmserializable.setProperty(i, read(xmlpullparser, kvmserializable, i, null, null, propertyinfo));
                    }
                    i++;
                }

                if(!flag)
                    if(avoidExceptionForUnknownProperty)
                        while(xmlpullparser.next() != 3 || !s.equals(xmlpullparser.getName())) ;
                    else
                        throw new RuntimeException("Unknown Property: " + s);
                continue;
            }
            ((SoapObject)kvmserializable).addProperty(xmlpullparser.getName(), read(xmlpullparser, kvmserializable, kvmserializable.getPropertyCount(), ((SoapObject)kvmserializable).getNamespace(), s, PropertyInfo.OBJECT_TYPE));
        } while(true);
        xmlpullparser.require(3, null, null);
    }

    protected void readSerializable(XmlPullParser xmlpullparser, SoapObject soapobject)
        throws IOException, XmlPullParserException
    {
        for(int i = 0; i < xmlpullparser.getAttributeCount(); i++)
            soapobject.addAttribute(xmlpullparser.getAttributeName(i), xmlpullparser.getAttributeValue(i));

        readSerializable(xmlpullparser, ((KvmSerializable) (soapobject)));
    }

    protected Object readUnknown(XmlPullParser xmlpullparser, String s, String s1)
        throws IOException, XmlPullParserException
    {
        String s2 = xmlpullparser.getName();
        String s3 = xmlpullparser.getNamespace();
        Vector vector = new Vector();
        for(int i = 0; i < xmlpullparser.getAttributeCount(); i++)
        {
            AttributeInfo attributeinfo = new AttributeInfo();
            attributeinfo.setName(xmlpullparser.getAttributeName(i));
            attributeinfo.setValue(xmlpullparser.getAttributeValue(i));
            attributeinfo.setNamespace(xmlpullparser.getAttributeNamespace(i));
            attributeinfo.setType(xmlpullparser.getAttributeType(i));
            vector.addElement(attributeinfo);
        }

        xmlpullparser.next();
        Object obj = null;
        SoapPrimitive soapprimitive = null;
        Object obj1;
        if(xmlpullparser.getEventType() == 4)
        {
            obj1 = xmlpullparser.getText();
            soapprimitive = new SoapPrimitive(s, s1, obj1);
            obj = soapprimitive;
            for(int j = 0; j < vector.size(); j++)
                soapprimitive.addAttribute((AttributeInfo)vector.elementAt(j));

            xmlpullparser.next();
        } else
        {
            obj1 = soapprimitive;
            if(xmlpullparser.getEventType() == 3)
            {
                obj = new SoapObject(s, s1);
                for(int k = 0; k < vector.size(); k++)
                    ((SoapObject) (obj)).addAttribute((AttributeInfo)vector.elementAt(k));

                obj1 = soapprimitive;
            }
        }
        if(xmlpullparser.getEventType() == 2)
        {
            if(obj1 != null && ((String) (obj1)).trim().length() != 0)
                throw new RuntimeException("Malformed input: Mixed content");
            obj = new SoapObject(s, s1);
            for(int l = 0; l < vector.size(); l++)
                ((SoapObject) (obj)).addAttribute((AttributeInfo)vector.elementAt(l));

            for(; xmlpullparser.getEventType() != 3; xmlpullparser.nextTag())
                ((SoapObject) (obj)).addProperty(xmlpullparser.getName(), read(xmlpullparser, obj, ((SoapObject) (obj)).getPropertyCount(), null, null, PropertyInfo.OBJECT_TYPE));

        }
        xmlpullparser.require(3, s3, s2);
        return obj;
    }

    protected void readVector(XmlPullParser xmlpullparser, Vector vector, PropertyInfo propertyinfo)
        throws IOException, XmlPullParserException
    {
        String s = null;
        String s1 = null;
        int i = vector.size();
        int k = 1;
        String s3 = xmlpullparser.getAttributeValue(enc, "arrayType");
        int j = k;
        if(s3 != null)
        {
            i = s3.indexOf(':');
            j = s3.indexOf("[", i);
            Object obj = s3.substring(i + 1, j);
            int l;
            String s2;
            if(i == -1)
                s = "";
            else
                s = s3.substring(0, i);
            s2 = xmlpullparser.getNamespace(s);
            l = getIndex(s3, j, -1);
            s = s2;
            s1 = ((String) (obj));
            j = k;
            i = l;
            if(l != -1)
            {
                vector.setSize(l);
                j = 0;
                i = l;
                s1 = ((String) (obj));
                s = s2;
            }
        }
        obj = propertyinfo;
        if(propertyinfo == null)
            obj = PropertyInfo.OBJECT_TYPE;
        xmlpullparser.nextTag();
        l = getIndex(xmlpullparser.getAttributeValue(enc, "offset"), 0, 0);
        while(xmlpullparser.getEventType() != 3) 
        {
            l = getIndex(xmlpullparser.getAttributeValue(enc, "position"), 0, l);
            k = i;
            if(j != 0)
            {
                k = i;
                if(l >= i)
                {
                    k = l + 1;
                    vector.setSize(k);
                }
            }
            vector.setElementAt(read(xmlpullparser, vector, l, s, s1, ((PropertyInfo) (obj))), l);
            l++;
            xmlpullparser.nextTag();
            i = k;
        }
        xmlpullparser.require(3, null, null);
    }

    public void setAddAdornments(boolean flag)
    {
        addAdornments = flag;
    }

    public void setBodyOutEmpty(boolean flag)
    {
        if(flag)
            bodyOut = null;
    }

    public void writeBody(XmlSerializer xmlserializer)
        throws IOException
    {
        if(bodyOut != null)
        {
            multiRef = new Vector();
            multiRef.addElement(bodyOut);
            Object aobj[] = getInfo(null, bodyOut);
            String s;
            if(dotNet)
                s = "";
            else
                s = (String)aobj[0];
            xmlserializer.startTag(s, (String)aobj[1]);
            if(dotNet)
                xmlserializer.attribute(null, "xmlns", (String)aobj[0]);
            if(addAdornments)
            {
                if(aobj[2] == null)
                    s = "o0";
                else
                    s = (String)aobj[2];
                xmlserializer.attribute(null, "id", s);
                xmlserializer.attribute(enc, "root", "1");
            }
            writeElement(xmlserializer, bodyOut, null, aobj[3]);
            if(dotNet)
                s = "";
            else
                s = (String)aobj[0];
            xmlserializer.endTag(s, (String)aobj[1]);
        }
    }

    protected void writeElement(XmlSerializer xmlserializer, Object obj, PropertyInfo propertyinfo, Object obj1)
        throws IOException
    {
        if(obj1 != null)
        {
            ((Marshal)obj1).writeInstance(xmlserializer, obj);
            return;
        }
        if((obj instanceof KvmSerializable) || obj == SoapPrimitive.NullNilElement || obj == SoapPrimitive.NullSkip)
        {
            writeObjectBodyWithAttributes(xmlserializer, (KvmSerializable)obj);
            return;
        }
        if(obj instanceof Vector)
        {
            writeVectorBody(xmlserializer, (Vector)obj, propertyinfo.elementType);
            return;
        } else
        {
            throw new RuntimeException("Cannot serialize: " + obj);
        }
    }

    public void writeObjectBody(XmlSerializer xmlserializer, KvmSerializable kvmserializable)
        throws IOException
    {
        int j = kvmserializable.getPropertyCount();
        PropertyInfo propertyinfo = new PropertyInfo();
        int i = 0;
        while(i < j) 
        {
            Object obj = kvmserializable.getProperty(i);
            kvmserializable.getPropertyInfo(i, properties, propertyinfo);
            if(!(obj instanceof SoapObject))
            {
                if((propertyinfo.flags & 1) == 0)
                {
                    Object obj1 = kvmserializable.getProperty(i);
                    if((obj != null || !skipNullProperties) && obj1 != SoapPrimitive.NullSkip)
                    {
                        xmlserializer.startTag(propertyinfo.namespace, propertyinfo.name);
                        writeProperty(xmlserializer, obj1, propertyinfo);
                        xmlserializer.endTag(propertyinfo.namespace, propertyinfo.name);
                    }
                }
            } else
            {
                SoapObject soapobject = (SoapObject)obj;
                Object obj2 = ((Object) (getInfo(null, soapobject)));
                obj = (String)obj2[0];
                String s = (String)obj2[1];
                if(propertyinfo.name != null && propertyinfo.name.length() > 0)
                    obj = propertyinfo.name;
                else
                    obj = (String)obj2[1];
                if(propertyinfo.namespace != null && propertyinfo.namespace.length() > 0)
                    obj2 = propertyinfo.namespace;
                else
                    obj2 = (String)obj2[0];
                xmlserializer.startTag(((String) (obj2)), ((String) (obj)));
                if(!implicitTypes)
                {
                    String s1 = xmlserializer.getPrefix(((String) (obj2)), true);
                    xmlserializer.attribute(xsi, "type", s1 + ":" + s);
                }
                writeObjectBodyWithAttributes(xmlserializer, soapobject);
                xmlserializer.endTag(((String) (obj2)), ((String) (obj)));
            }
            i++;
        }
    }

    public void writeObjectBodyWithAttributes(XmlSerializer xmlserializer, KvmSerializable kvmserializable)
        throws IOException
    {
        if(kvmserializable instanceof HasAttributes)
            writeAttributes(xmlserializer, (HasAttributes)kvmserializable);
        writeObjectBody(xmlserializer, kvmserializable);
    }

    protected void writeProperty(XmlSerializer xmlserializer, Object obj, PropertyInfo propertyinfo)
        throws IOException
    {
        if(obj == null || obj == SoapPrimitive.NullNilElement)
        {
            propertyinfo = xsi;
            if(version >= 120)
                obj = "nil";
            else
                obj = "null";
            xmlserializer.attribute(propertyinfo, ((String) (obj)), "true");
            return;
        }
        Object aobj[] = getInfo(null, obj);
        if(propertyinfo.multiRef || aobj[2] != null)
        {
            int j = multiRef.indexOf(obj);
            int i = j;
            if(j == -1)
            {
                i = multiRef.size();
                multiRef.addElement(obj);
            }
            if(aobj[2] == null)
                obj = "#o" + i;
            else
                obj = "#" + aobj[2];
            xmlserializer.attribute(null, "href", ((String) (obj)));
            return;
        }
        if(!implicitTypes || obj.getClass() != propertyinfo.type)
        {
            String s = xmlserializer.getPrefix((String)aobj[0], true);
            xmlserializer.attribute(xsi, "type", s + ":" + aobj[1]);
        }
        writeElement(xmlserializer, obj, propertyinfo, aobj[3]);
    }

    protected void writeVectorBody(XmlSerializer xmlserializer, Vector vector, PropertyInfo propertyinfo)
        throws IOException
    {
        String s;
        Object obj;
        PropertyInfo propertyinfo1;
        Object obj1;
        obj1 = "item";
        Object obj2 = null;
        int j;
        if(propertyinfo == null)
        {
            propertyinfo1 = PropertyInfo.OBJECT_TYPE;
            obj = obj1;
            s = obj2;
            break MISSING_BLOCK_LABEL_24;
        } else
        {
            s = obj2;
            obj = obj1;
            propertyinfo1 = propertyinfo;
            if(propertyinfo instanceof PropertyInfo)
            {
                s = obj2;
                obj = obj1;
                propertyinfo1 = propertyinfo;
                if(propertyinfo.name != null)
                {
                    obj = propertyinfo.name;
                    s = propertyinfo.namespace;
                    propertyinfo1 = propertyinfo;
                }
            }
            continue;
        }
        do
        {
            j = vector.size();
            obj1 = ((Object) (getInfo(propertyinfo1.type, null)));
            boolean flag;
            int i;
            if(!implicitTypes)
            {
                xmlserializer.attribute(enc, "arrayType", xmlserializer.getPrefix((String)obj1[0], false) + ":" + obj1[1] + "[" + j + "]");
                propertyinfo = s;
            } else
            {
                propertyinfo = s;
                if(s == null)
                    propertyinfo = (String)obj1[0];
            }
            flag = false;
            i = 0;
            while(i < j) 
            {
                if(vector.elementAt(i) == null)
                {
                    flag = true;
                } else
                {
                    xmlserializer.startTag(propertyinfo, ((String) (obj)));
                    boolean flag1 = flag;
                    if(flag)
                    {
                        xmlserializer.attribute(enc, "position", "[" + i + "]");
                        flag1 = false;
                    }
                    writeProperty(xmlserializer, vector.elementAt(i), propertyinfo1);
                    xmlserializer.endTag(propertyinfo, ((String) (obj)));
                    flag = flag1;
                }
                i++;
            }
            return;
        } while(true);
    }

    private static final String ANY_TYPE_LABEL = "anyType";
    private static final String ARRAY_MAPPING_NAME = "Array";
    private static final String ARRAY_TYPE_LABEL = "arrayType";
    static final Marshal DEFAULT_MARSHAL = new DM();
    private static final String HREF_LABEL = "href";
    private static final String ID_LABEL = "id";
    private static final String ITEM_LABEL = "item";
    protected static final String NIL_LABEL = "nil";
    protected static final String NULL_LABEL = "null";
    protected static final int QNAME_MARSHAL = 3;
    protected static final int QNAME_NAMESPACE = 0;
    protected static final int QNAME_TYPE = 1;
    private static final String ROOT_LABEL = "root";
    private static final String TYPE_LABEL = "type";
    static Class class$org$ksoap2$serialization$SoapObject;
    protected boolean addAdornments;
    public boolean avoidExceptionForUnknownProperty;
    protected Hashtable classToQName;
    public boolean dotNet;
    Hashtable idMap;
    public boolean implicitTypes;
    Vector multiRef;
    public Hashtable properties;
    protected Hashtable qNameToClass;
    public boolean skipNullProperties;

}
