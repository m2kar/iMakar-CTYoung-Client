// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.c;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

// Referenced classes of package com.xxx.sdk.e.c:
//            e, b, a

public final class d
{

    public d()
    {
    }

    private static int a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[4096];
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if(-1 == i)
                break;
            outputstream.write(abyte0, 0, i);
            l += i;
        } while(true);
        if(l > 0x7fffffffL)
            return -1;
        else
            return (int)l;
    }

    private static int a(Reader reader, Writer writer)
    {
        char ac[] = new char[4096];
        long l = 0L;
        do
        {
            int i = reader.read(ac);
            if(-1 == i)
                break;
            writer.write(ac, 0, i);
            l += i;
        } while(true);
        if(l > 0x7fffffffL)
            return -1;
        else
            return (int)l;
    }

    private static long a(InputStream inputstream, long l)
    {
        if(l < 0L)
            throw new IllegalArgumentException((new StringBuilder("Skip count must be non-negative, actual: ")).append(l).toString());
        if(d == null)
            d = new byte[2048];
        long l1 = l;
        do
        {
            if(l1 <= 0L)
                break;
            long l2 = inputstream.read(d, 0, (int)Math.min(l1, 2048L));
            if(l2 < 0L)
                break;
            l1 -= l2;
        } while(true);
        return l - l1;
    }

    private static long a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[4096];
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if(-1 != i)
            {
                outputstream.write(abyte0, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while(true);
    }

    private static long a(InputStream inputstream, OutputStream outputstream, byte abyte0[])
    {
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if(-1 != i)
            {
                outputstream.write(abyte0, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while(true);
    }

    private static long a(Reader reader, long l)
    {
        if(l < 0L)
            throw new IllegalArgumentException((new StringBuilder("Skip count must be non-negative, actual: ")).append(l).toString());
        if(a_char_array1d_static_fld == null)
            a_char_array1d_static_fld = new char[2048];
        long l1 = l;
        do
        {
            if(l1 <= 0L)
                break;
            long l2 = reader.read(a_char_array1d_static_fld, 0, (int)Math.min(l1, 2048L));
            if(l2 < 0L)
                break;
            l1 -= l2;
        } while(true);
        return l - l1;
    }

    private static long a(Reader reader, Writer writer)
    {
        char ac[] = new char[4096];
        long l = 0L;
        do
        {
            int i = reader.read(ac);
            if(-1 != i)
            {
                writer.write(ac, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while(true);
    }

    private static long a(Reader reader, Writer writer, long l, long l1)
    {
        char ac[];
        ac = new char[4096];
        if(l > 0L)
        {
            if(l < 0L)
                throw new IllegalArgumentException((new StringBuilder("Skip count must be non-negative, actual: ")).append(l).toString());
            if(a_char_array1d_static_fld == null)
                a_char_array1d_static_fld = new char[2048];
            long l2 = l;
            do
            {
                if(l2 <= 0L)
                    break;
                long l5 = reader.read(a_char_array1d_static_fld, 0, (int)Math.min(l2, 2048L));
                if(l5 < 0L)
                    break;
                l2 -= l5;
            } while(true);
            l2 = l - l2;
            if(l2 != l)
                throw new EOFException((new StringBuilder("Chars to skip: ")).append(l).append(" actual: ").append(l2).toString());
        }
        if(l1 != 0L) goto _L2; else goto _L1
_L1:
        long l3 = 0L;
_L4:
        return l3;
_L2:
        int i;
        char c1 = '\u1000';
        i = c1;
        if(l1 > 0L)
        {
            i = c1;
            if(l1 < 4096L)
                i = (int)l1;
        }
        l = 0L;
_L6:
        l3 = l;
        if(i <= 0) goto _L4; else goto _L3
_L3:
        int j;
        j = reader.read(ac, 0, i);
        l3 = l;
        if(-1 == j) goto _L4; else goto _L5
_L5:
        writer.write(ac, 0, j);
        long l4 = l + (long)j;
        l = l4;
        if(l1 > 0L)
        {
            i = (int)Math.min(l1 - l4, 4096L);
            l = l4;
        }
          goto _L6
    }

    private static long a(Reader reader, Writer writer, long l, long l1, char ac[])
    {
        if(l > 0L)
        {
            if(l < 0L)
                throw new IllegalArgumentException((new StringBuilder("Skip count must be non-negative, actual: ")).append(l).toString());
            if(a_char_array1d_static_fld == null)
                a_char_array1d_static_fld = new char[2048];
            long l2 = l;
            do
            {
                if(l2 <= 0L)
                    break;
                long l5 = reader.read(a_char_array1d_static_fld, 0, (int)Math.min(l2, 2048L));
                if(l5 < 0L)
                    break;
                l2 -= l5;
            } while(true);
            l2 = l - l2;
            if(l2 != l)
                throw new EOFException((new StringBuilder("Chars to skip: ")).append(l).append(" actual: ").append(l2).toString());
        }
        if(l1 != 0L) goto _L2; else goto _L1
_L1:
        long l3 = 0L;
_L4:
        return l3;
_L2:
        int i;
        char c1 = '\u1000';
        i = c1;
        if(l1 > 0L)
        {
            i = c1;
            if(l1 < 4096L)
                i = (int)l1;
        }
        l = 0L;
_L6:
        l3 = l;
        if(i <= 0) goto _L4; else goto _L3
_L3:
        int j;
        j = reader.read(ac, 0, i);
        l3 = l;
        if(-1 == j) goto _L4; else goto _L5
_L5:
        writer.write(ac, 0, j);
        long l4 = l + (long)j;
        l = l4;
        if(l1 > 0L)
        {
            i = (int)Math.min(l1 - l4, 4096L);
            l = l4;
        }
          goto _L6
    }

    private static long a(Reader reader, Writer writer, char ac[])
    {
        long l = 0L;
        do
        {
            int i = reader.read(ac);
            if(-1 != i)
            {
                writer.write(ac, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while(true);
    }

    private static BufferedReader a(Reader reader)
    {
        if(reader instanceof BufferedReader)
            return (BufferedReader)reader;
        else
            return new BufferedReader(reader);
    }

    public static String a(InputStream inputstream)
    {
        Charset charset = Charset.defaultCharset();
        e e1 = new e();
        a(inputstream, ((Writer) (e1)), charset);
        return e1.toString();
    }

    private static String a(InputStream inputstream, Charset charset)
    {
        e e1 = new e();
        a(inputstream, ((Writer) (e1)), charset);
        return e1.toString();
    }

    private static String a(Reader reader)
    {
        e e1 = new e();
        a(reader, ((Writer) (e1)));
        return e1.toString();
    }

    public static List a(InputStream inputstream)
    {
        return a(inputstream, Charset.defaultCharset());
    }

    private static List a(InputStream inputstream, String s)
    {
        return a(inputstream, com.xxx.sdk.e.c.b.a(s));
    }

    private static List a(InputStream inputstream, Charset charset)
    {
        return a(((Reader) (new InputStreamReader(inputstream, com.xxx.sdk.e.c.b.a(charset)))));
    }

    private static List a(Reader reader)
    {
        ArrayList arraylist;
        if(reader instanceof BufferedReader)
            reader = (BufferedReader)reader;
        else
            reader = new BufferedReader(reader);
        arraylist = new ArrayList();
        for(String s = reader.readLine(); s != null; s = reader.readLine())
            arraylist.add(s);

        return arraylist;
    }

    public static void a(Closeable closeable)
    {
        if(closeable == null)
            break MISSING_BLOCK_LABEL_10;
        closeable.close();
        return;
        closeable;
    }

    private static void a(InputStream inputstream, long l)
    {
        if(l < 0L)
            throw new IllegalArgumentException((new StringBuilder("Bytes to skip must not be negative: ")).append(l).toString());
        long l1 = a(inputstream, l);
        if(l1 != l)
            throw new EOFException((new StringBuilder("Bytes to skip: ")).append(l).append(" actual: ").append(l1).toString());
        else
            return;
    }

    private static void a(InputStream inputstream, Writer writer)
    {
        a(inputstream, writer, Charset.defaultCharset());
    }

    private static void a(InputStream inputstream, Writer writer, String s)
    {
        a(inputstream, writer, com.xxx.sdk.e.c.b.a(s));
    }

    private static void a(InputStream inputstream, Writer writer, Charset charset)
    {
        a(((Reader) (new InputStreamReader(inputstream, com.xxx.sdk.e.c.b.a(charset)))), writer);
    }

    private static void a(Reader reader, long l)
    {
        if(l < 0L)
            throw new IllegalArgumentException((new StringBuilder("Skip count must be non-negative, actual: ")).append(l).toString());
        if(a_char_array1d_static_fld == null)
            a_char_array1d_static_fld = new char[2048];
        long l1 = l;
        do
        {
            if(l1 <= 0L)
                break;
            long l2 = reader.read(a_char_array1d_static_fld, 0, (int)Math.min(l1, 2048L));
            if(l2 < 0L)
                break;
            l1 -= l2;
        } while(true);
        l1 = l - l1;
        if(l1 != l)
            throw new EOFException((new StringBuilder("Chars to skip: ")).append(l).append(" actual: ").append(l1).toString());
        else
            return;
    }

    public static void a(String s, Writer writer)
    {
        if(s != null)
        {
            writer.write(s);
            writer.flush();
        }
    }

    private static void a(Collection collection, String s, Writer writer)
    {
        if(collection == null)
            return;
        String s1 = s;
        if(s == null)
            s1 = bY;
        for(collection = collection.iterator(); collection.hasNext(); writer.write(s1))
        {
            s = ((String) (collection.next()));
            if(s != null)
                writer.write(s.toString());
        }

        writer.flush();
    }

    public static void a(byte abyte0[], OutputStream outputstream)
    {
        if(abyte0 != null)
        {
            outputstream.write(abyte0);
            outputstream.flush();
        }
    }

    private static void a(char ac[], Writer writer)
    {
        if(ac != null)
        {
            writer.write(ac);
            writer.flush();
        }
    }

    private static byte[] a(long l)
    {
        do
        {
            if(l > 0x7fffffffL)
                throw new IllegalArgumentException((new StringBuilder("Size cannot be greater than Integer max value: ")).append(l).toString());
            l = (int)l;
        } while(true);
    }

    public static byte[] a(InputStream inputstream)
    {
        a a1 = new a();
        byte abyte0[] = new byte[4096];
        do
        {
            int i = inputstream.read(abyte0);
            if(-1 != i)
                a1.write(abyte0, 0, i);
            else
                return a1.toByteArray();
        } while(true);
    }

    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    private static char a_char_static_fld = 47;
    private static char a_char_array1d_static_fld[];
    private static char b = 92;
    private static final int bM = 2048;
    private static String bW = "\n";
    private static String bX = "\r\n";
    private static String bY;
    private static char c;
    private static byte d[];

    static 
    {
        char c1 = File.separatorChar;
        e e1 = new e((byte)0);
        PrintWriter printwriter = new PrintWriter(e1);
        printwriter.println();
        bY = e1.toString();
        printwriter.close();
    }
}
