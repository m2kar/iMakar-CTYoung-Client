// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.kobjects.xmlrpc;

import java.io.FileReader;
import org.kobjects.xml.XmlReader;

// Referenced classes of package org.kobjects.xmlrpc:
//            XmlRpcParser

public class Driver
{

    public Driver()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        (new XmlRpcParser(new XmlReader(new FileReader(args[0])))).parseResponse();
    }
}
