// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.c;

import java.io.*;
import java.util.*;

// Referenced classes of package com.xxx.sdk.e.c:
//            c

public final class a extends OutputStream
{

    public a()
    {
        this((byte)0);
    }

    private a(byte byte0)
    {
        u = new ArrayList();
        this;
        JVM INSTR monitorenter ;
        v(1024);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int a(InputStream inputstream)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        j = count - bL;
        i = inputstream.read(c, j, c.length - j);
        int k = 0;
_L2:
        int l;
        if(i == -1)
            break; /* Loop/switch isn't completed */
        l = k + i;
        j += i;
        count = i + count;
        i = j;
        if(j != c.length)
            break MISSING_BLOCK_LABEL_79;
        v(c.length);
        i = 0;
        k = inputstream.read(c, i, c.length - i);
        j = i;
        i = k;
        k = l;
        if(true) goto _L2; else goto _L1
_L1:
        return k;
        inputstream;
        throw inputstream;
    }

    private static InputStream a(InputStream inputstream)
    {
        Object obj = new a();
        ((a) (obj)).a(inputstream);
        int i = ((a) (obj)).count;
        if(i == 0)
            return new c();
        inputstream = new ArrayList(((a) (obj)).u.size());
        obj = ((a) (obj)).u.iterator();
        do
        {
            if(!((Iterator) (obj)).hasNext())
                break;
            byte abyte0[] = (byte[])((Iterator) (obj)).next();
            int j = Math.min(abyte0.length, i);
            inputstream.add(new ByteArrayInputStream(abyte0, 0, j));
            i -= j;
        } while(i != 0);
        return new SequenceInputStream(Collections.enumeration(inputstream));
    }

    private InputStream b()
    {
        int i = count;
        if(i == 0)
            return new c();
        ArrayList arraylist = new ArrayList(u.size());
        Iterator iterator = u.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            byte abyte0[] = (byte[])iterator.next();
            int j = Math.min(abyte0.length, i);
            arraylist.add(new ByteArrayInputStream(abyte0, 0, j));
            i -= j;
        } while(i != 0);
        return new SequenceInputStream(Collections.enumeration(arraylist));
    }

    private void reset()
    {
        this;
        JVM INSTR monitorenter ;
        count = 0;
        bL = 0;
        bK = 0;
        c = (byte[])u.get(bK);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i = count;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    private String toString(String s)
    {
        return new String(toByteArray(), s);
    }

    private void v(int i)
    {
        if(bK < u.size() - 1)
        {
            bL = bL + c.length;
            bK = bK + 1;
            c = (byte[])u.get(bK);
            return;
        }
        if(c == null)
        {
            bL = 0;
        } else
        {
            i = Math.max(c.length << 1, i - bL);
            bL = bL + c.length;
        }
        bK = bK + 1;
        c = new byte[i];
        u.add(c);
    }

    private void writeTo(OutputStream outputstream)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        Iterator iterator;
        i = count;
        iterator = u.iterator();
_L2:
        int j;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        byte abyte0[] = (byte[])iterator.next();
        j = Math.min(abyte0.length, i);
        outputstream.write(abyte0, 0, j);
        i -= j;
        if(i != 0) goto _L2; else goto _L1
_L1:
        return;
        outputstream;
        throw outputstream;
    }

    public final void close()
    {
    }

    public final byte[] toByteArray()
    {
        this;
        JVM INSTR monitorenter ;
        int j = count;
        if(j != 0) goto _L2; else goto _L1
_L1:
        byte abyte0[] = EMPTY_BYTE_ARRAY;
_L4:
        this;
        JVM INSTR monitorexit ;
        return abyte0;
_L2:
        Iterator iterator;
        abyte0 = new byte[j];
        iterator = u.iterator();
        int i = 0;
_L6:
        if(!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        int k;
        byte abyte1[] = (byte[])iterator.next();
        k = Math.min(abyte1.length, j);
        System.arraycopy(abyte1, 0, abyte0, i, k);
        j -= k;
        if(j != 0) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_97;
        Exception exception;
        exception;
        throw exception;
        i += k;
          goto _L6
    }

    public final String toString()
    {
        return new String(toByteArray());
    }

    public final void write(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int k = count - bL;
        int j = k;
        if(k != c.length)
            break MISSING_BLOCK_LABEL_35;
        v(count + 1);
        j = 0;
        c[j] = (byte)i;
        count = count + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        if(i < 0 || i > abyte0.length || j < 0 || i + j > abyte0.length || i + j < 0)
            throw new IndexOutOfBoundsException();
        if(j == 0)
            return;
        this;
        JVM INSTR monitorenter ;
        int l;
        int j1;
        j1 = count + j;
        l = count - bL;
        int k = j;
_L2:
        if(k <= 0)
            break; /* Loop/switch isn't completed */
        int i1;
        i1 = Math.min(k, c.length - l);
        System.arraycopy(abyte0, (i + j) - k, c, l, i1);
        i1 = k - i1;
        k = i1;
        if(i1 <= 0)
            continue; /* Loop/switch isn't completed */
        v(j1);
        l = 0;
        k = i1;
        if(true) goto _L2; else goto _L1
_L1:
        count = j1;
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    private static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    private int bK;
    private int bL;
    private byte c[];
    private int count;
    private final List u;

}
