// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e;

import com.xxx.sdk.e.a.a.d.h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class g
{

    public g()
    {
    }

    private static String a(Iterable iterable, String s)
    {
        iterable = iterable.iterator();
        if(iterable != null)
        {
            if(!iterable.hasNext())
                return "";
            Object obj = iterable.next();
            if(!iterable.hasNext())
            {
                if(obj != null)
                    return obj.toString();
            } else
            {
                StringBuilder stringbuilder = new StringBuilder(256);
                if(obj != null)
                    stringbuilder.append(obj);
                do
                {
                    if(!iterable.hasNext())
                        break;
                    if(s != null)
                        stringbuilder.append(s);
                    Object obj1 = iterable.next();
                    if(obj1 != null)
                        stringbuilder.append(obj1);
                } while(true);
                return stringbuilder.toString();
            }
        }
        return null;
    }

    private static String a(Iterator iterator, String s)
    {
        if(iterator != null)
        {
            if(!iterator.hasNext())
                return "";
            Object obj = iterator.next();
            if(!iterator.hasNext())
            {
                if(obj != null)
                    return obj.toString();
            } else
            {
                StringBuilder stringbuilder = new StringBuilder(256);
                if(obj != null)
                    stringbuilder.append(obj);
                do
                {
                    if(!iterator.hasNext())
                        break;
                    if(s != null)
                        stringbuilder.append(s);
                    Object obj1 = iterator.next();
                    if(obj1 != null)
                        stringbuilder.append(obj1);
                } while(true);
                return stringbuilder.toString();
            }
        }
        return null;
    }

    private static ZipEntry a(ZipFile zipfile, String s)
    {
        return zipfile.getEntry(s);
    }

    private static boolean a(CharSequence charsequence)
    {
        if(!h.isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = charsequence.length();
        int i = 0;
label0:
        do
        {
label1:
            {
                if(i >= j)
                    break label1;
                if(!Character.isDigit(charsequence.charAt(i)))
                    break label0;
                i++;
            }
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private static byte[] a(InputStream inputstream)
    {
        byte abyte0[] = new byte[1024];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
_L3:
        int i = inputstream.read(abyte0);
        if(i == -1) goto _L2; else goto _L1
_L1:
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L3
        Exception exception;
        exception;
_L5:
        bytearrayoutputstream.close();
        throw exception;
        exception;
        inputstream.close();
        throw exception;
_L2:
        exception = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        inputstream.close();
        return exception;
        exception;
        bytearrayoutputstream = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static String d(String s, String s1)
    {
        if(!h.isEmpty(s))
        {
            if(s1.isEmpty())
                return "";
            int i = s.indexOf(s1);
            if(i != -1)
                return s.substring(0, i);
        }
        return s;
    }

    private static boolean isEmpty(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }
}
