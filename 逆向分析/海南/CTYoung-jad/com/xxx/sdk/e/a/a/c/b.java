// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.c;

import com.xxx.sdk.e.a.a.a.e;
import com.xxx.sdk.e.a.a.d.b.a;
import com.xxx.sdk.e.a.a.d.b.d;
import com.xxx.sdk.e.a.a.d.b.f;
import com.xxx.sdk.e.a.a.d.b.g;
import com.xxx.sdk.e.a.a.d.b.j;
import com.xxx.sdk.e.a.a.d.b.k;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.e.a.a.d.i;
import com.xxx.sdk.e.a.a.e.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.xxx.sdk.e.a.a.c:
//            i

public final class b
{

    public b(ByteBuffer bytebuffer, com.xxx.sdk.e.a.a.d.a.f f1)
    {
        byteOrder = ByteOrder.LITTLE_ENDIAN;
        locale = e.b;
        a_java_nio_ByteBuffer_fld = bytebuffer.duplicate();
        a_java_nio_ByteBuffer_fld.order(byteOrder);
        a_com_xxx_sdk_e_a_a_d_a_f_fld = f1;
    }

    private com.xxx.sdk.e.a.a.c.i a()
    {
        return a_com_xxx_sdk_e_a_a_c_i_fld;
    }

    private a a()
    {
        int l = a_java_nio_ByteBuffer_fld.getInt();
        int i1 = a_java_nio_ByteBuffer_fld.getInt();
        a a1 = new a();
        if(l > 0)
            a1.bP = a_com_xxx_sdk_e_a_a_d_h_fld.e[l];
        a1.name = a_com_xxx_sdk_e_a_a_d_h_fld.e[i1];
        if(a1.name.isEmpty() && d != null && i1 < d.length)
            a1.name = d[i1];
        l = a_java_nio_ByteBuffer_fld.getInt();
        if(l > 0)
            a1.bQ = a_com_xxx_sdk_e_a_a_d_h_fld.e[l];
        a1.d = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
        return a1;
    }

    private d a()
    {
        d d1 = new d();
        int l = a_java_nio_ByteBuffer_fld.getInt();
        if(l > 0)
            d1.data = a_com_xxx_sdk_e_a_a_d_h_fld.e[l];
        d1.e = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
        com.xxx.sdk.e.a.a.c.i i1 = a_com_xxx_sdk_e_a_a_c_i_fld;
        return d1;
    }

    private f a()
    {
        int l = a_java_nio_ByteBuffer_fld.getInt();
        int i1 = a_java_nio_ByteBuffer_fld.getInt();
        f f1 = new f();
        if(l > 0)
            f1.prefix = a_com_xxx_sdk_e_a_a_d_h_fld.e[l];
        if(i1 > 0)
            f1.uri = a_com_xxx_sdk_e_a_a_d_h_fld.e[i1];
        return f1;
    }

    private g a()
    {
        int l = a_java_nio_ByteBuffer_fld.getInt();
        int i1 = a_java_nio_ByteBuffer_fld.getInt();
        g g1 = new g();
        if(l > 0)
            g1.prefix = a_com_xxx_sdk_e_a_a_d_h_fld.e[l];
        if(i1 > 0)
            g1.uri = a_com_xxx_sdk_e_a_a_d_h_fld.e[i1];
        return g1;
    }

    private com.xxx.sdk.e.a.a.d.b.h a()
    {
        com.xxx.sdk.e.a.a.d.b.h h1 = new com.xxx.sdk.e.a.a.d.b.h();
        int l = a_java_nio_ByteBuffer_fld.getInt();
        int i1 = a_java_nio_ByteBuffer_fld.getInt();
        if(l > 0)
            h1.bP = a_com_xxx_sdk_e_a_a_d_h_fld.e[l];
        h1.name = a_com_xxx_sdk_e_a_a_d_h_fld.e[i1];
        if(a_com_xxx_sdk_e_a_a_c_i_fld != null)
            a_com_xxx_sdk_e_a_a_c_i_fld.a(h1);
        return h1;
    }

    private void a(com.xxx.sdk.e.a.a.c.i l)
    {
        a_com_xxx_sdk_e_a_a_c_i_fld = l;
    }

    private long[] a(k k1)
    {
        int i1 = k1.o() / 4;
        k1 = new long[i1];
        for(int l = 0; l < i1; l++)
            k1[l] = a(a_java_nio_ByteBuffer_fld);

        return k1;
    }

    private static String c(String s, String s1)
    {
        int j1 = Integer.parseInt(s1);
        if(!"screenOrientation".equals(s)) goto _L2; else goto _L1
_L1:
        j1;
        JVM INSTR tableswitch -1 14: default 92
    //                   -1 150
    //                   0 123
    //                   1 132
    //                   2 153
    //                   3 114
    //                   4 141
    //                   5 129
    //                   6 144
    //                   7 147
    //                   8 135
    //                   9 138
    //                   10 117
    //                   11 156
    //                   12 159
    //                   13 120
    //                   14 126;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L3:
        s1 = (new StringBuilder("ScreenOrientation:")).append(Integer.toHexString(j1)).toString();
_L42:
        return s1;
_L8:
        return "behind";
_L15:
        return "fullSensor";
_L18:
        return "fullUser";
_L5:
        return "landscape";
_L19:
        return "locked";
_L10:
        return "nosensor";
_L6:
        return "portrait";
_L13:
        return "reverseLandscape";
_L14:
        return "reversePortrait";
_L9:
        return "sensor";
_L11:
        return "sensorLandscape";
_L12:
        return "sensorPortrait";
_L4:
        return "unspecified";
_L7:
        return "user";
_L16:
        return "userLandscape";
_L17:
        return "userPortrait";
_L2:
        if(!"configChanges".equals(s)) goto _L21; else goto _L20
_L20:
        s = new ArrayList();
        if((j1 & 0x1000) == 0) goto _L23; else goto _L22
_L22:
        s.add("density");
_L24:
        return h.a(s, "|");
_L23:
        if((0x40000000 & j1) != 0)
            s.add("fontScale");
        else
        if((j1 & 0x10) != 0)
            s.add("keyboard");
        else
        if((j1 & 0x20) != 0)
            s.add("keyboardHidden");
        else
        if((j1 & 0x2000) != 0)
            s.add("direction");
        else
        if((j1 & 4) != 0)
            s.add("locale");
        else
        if((j1 & 1) != 0)
            s.add("mcc");
        else
        if((j1 & 2) != 0)
            s.add("mnc");
        else
        if((j1 & 0x40) != 0)
            s.add("navigation");
        else
        if((j1 & 0x80) != 0)
            s.add("orientation");
        else
        if((j1 & 0x100) != 0)
            s.add("screenLayout");
        else
        if((j1 & 0x400) != 0)
            s.add("screenSize");
        else
        if((j1 & 0x800) != 0)
            s.add("smallestScreenSize");
        else
        if((j1 & 8) != 0)
            s.add("touchscreen");
        else
        if((j1 & 0x200) != 0)
            s.add("uiMode");
        if(true) goto _L24; else goto _L21
_L21:
        if(!"windowSoftInputMode".equals(s)) goto _L26; else goto _L25
_L25:
        int l;
        l = j1 & 0xf0;
        j1 &= 0xf;
        s = new ArrayList(2);
        l;
        JVM INSTR lookupswitch 4: default 556
    //                   0: 583
    //                   16: 684
    //                   32: 671
    //                   48: 658;
           goto _L27 _L28 _L29 _L30 _L31
_L28:
        break MISSING_BLOCK_LABEL_583;
_L27:
        s.add((new StringBuilder("WindowInputModeAdjust:")).append(Integer.toHexString(l)).toString());
_L39:
        j1;
        JVM INSTR tableswitch 0 5: default 624
    //                   0 651
    //                   1 736
    //                   2 723
    //                   3 697
    //                   4 749
    //                   5 710;
           goto _L32 _L33 _L34 _L35 _L36 _L37 _L38
_L33:
        break; /* Loop/switch isn't completed */
_L32:
        s.add((new StringBuilder("WindowInputModeState:")).append(Integer.toHexString(j1)).toString());
_L40:
        return h.a(s, "|");
_L31:
        s.add("adjustNothing");
          goto _L39
_L30:
        s.add("adjustPan");
          goto _L39
_L29:
        s.add("adjustResize");
          goto _L39
_L36:
        s.add("stateAlwaysHidden");
          goto _L40
_L38:
        s.add("stateAlwaysVisible");
          goto _L40
_L35:
        s.add("stateHidden");
          goto _L40
_L34:
        s.add("stateUnchanged");
          goto _L40
_L37:
        s.add("stateVisible");
          goto _L40
_L26:
        if("launchMode".equals(s))
            switch(j1)
            {
            default:
                return (new StringBuilder("LaunchMode:")).append(Integer.toHexString(j1)).toString();

            case 0: // '\0'
                return "standard";

            case 1: // '\001'
                return "singleTop";

            case 2: // '\002'
                return "singleTask";

            case 3: // '\003'
                return "singleInstance";
            }
        if("installLocation".equals(s))
            switch(j1)
            {
            default:
                return (new StringBuilder("installLocation:")).append(Integer.toHexString(j1)).toString();

            case 0: // '\0'
                return "auto";

            case 1: // '\001'
                return "internalOnly";

            case 2: // '\002'
                return "preferExternal";
            }
        if(!"protectionLevel".equals(s)) goto _L42; else goto _L41
_L41:
        s = new ArrayList(3);
        int i1 = j1;
        if((j1 & 0x10) != 0)
        {
            i1 = j1 ^ 0x10;
            s.add("system");
        }
        j1 = i1;
        if((i1 & 0x20) != 0)
        {
            j1 = i1 ^ 0x20;
            s.add("development");
        }
        j1;
        JVM INSTR tableswitch 0 3: default 1008
    //                   0 1042
    //                   1 1055
    //                   2 1068
    //                   3 1081;
           goto _L43 _L44 _L45 _L46 _L47
_L43:
        s.add((new StringBuilder("ProtectionLevel:")).append(Integer.toHexString(j1)).toString());
_L49:
        return h.a(s, "|");
_L44:
        s.add("normal");
        continue; /* Loop/switch isn't completed */
_L45:
        s.add("dangerous");
        continue; /* Loop/switch isn't completed */
_L46:
        s.add("signature");
        continue; /* Loop/switch isn't completed */
_L47:
        s.add("signatureOrSystem");
        if(true) goto _L49; else goto _L48
_L48:
    }

    private Locale getLocale()
    {
        return locale;
    }

    private void parse()
    {
        Object obj;
        obj = a();
        break MISSING_BLOCK_LABEL_6;
_L3:
        com.xxx.sdk.e.a.a.d.b b1;
        do
        {
            do
            {
                do
                    return;
                while(obj == null || ((com.xxx.sdk.e.a.a.d.b) (obj)).bu != 3);
                obj = a();
            } while(obj == null);
            com.xxx.sdk.e.a.a.e.c.u(((com.xxx.sdk.e.a.a.d.b) (obj)).bu);
            a_com_xxx_sdk_e_a_a_d_h_fld = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, (i)obj);
            b1 = a();
        } while(b1 == null);
        obj = b1;
        if(b1.bu != 384)
            continue; /* Loop/switch isn't completed */
        int j2 = ((k)b1).o() / 4;
        obj = new long[j2];
        for(int l = 0; l < j2; l++)
            obj[l] = a(a_java_nio_ByteBuffer_fld);

        d = new String[obj.length];
        for(int i1 = 0; i1 < obj.length; i1++)
            d[i1] = com.xxx.sdk.e.a.a.d.b.b.a(obj[i1]);

          goto _L1
_L6:
        int j1 = a_java_nio_ByteBuffer_fld.getInt();
        int k2 = a_java_nio_ByteBuffer_fld.getInt();
        f f1 = new f();
        if(j1 > 0)
            f1.prefix = a_com_xxx_sdk_e_a_a_d_h_fld.e[j1];
        if(k2 > 0)
            f1.uri = a_com_xxx_sdk_e_a_a_d_h_fld.e[k2];
        a_com_xxx_sdk_e_a_a_c_i_fld.a(f1);
_L10:
        long l3;
        a_java_nio_ByteBuffer_fld.position((int)(l3 + (long)((com.xxx.sdk.e.a.a.d.b) (obj)).o()));
_L1:
        obj = a();
        if(obj == null) goto _L3; else goto _L2
_L2:
        l3 = a_java_nio_ByteBuffer_fld.position();
        ((com.xxx.sdk.e.a.a.d.b) (obj)).bu;
        JVM INSTR tableswitch 256 260: default 312
    //                   256 349
    //                   257 162
    //                   258 424
    //                   259 432
    //                   260 510;
           goto _L4 _L5 _L6 _L7 _L8 _L9
_L4:
        int k1;
        int l2;
        g g1;
        if(((com.xxx.sdk.e.a.a.d.b) (obj)).bu >= 256 && ((com.xxx.sdk.e.a.a.d.b) (obj)).bu <= 383)
            a(a_java_nio_ByteBuffer_fld, ((com.xxx.sdk.e.a.a.d.b) (obj)).o());
        else
            throw new com.xxx.sdk.e.a.a.b.a((new StringBuilder("Unexpected chunk type:")).append(((com.xxx.sdk.e.a.a.d.b) (obj)).bu).toString());
          goto _L10
_L5:
        k1 = a_java_nio_ByteBuffer_fld.getInt();
        l2 = a_java_nio_ByteBuffer_fld.getInt();
        g1 = new g();
        if(k1 > 0)
            g1.prefix = a_com_xxx_sdk_e_a_a_d_h_fld.e[k1];
        if(l2 > 0)
            g1.uri = a_com_xxx_sdk_e_a_a_d_h_fld.e[l2];
        a_com_xxx_sdk_e_a_a_c_i_fld.a(g1);
          goto _L10
_L7:
        a();
          goto _L10
_L8:
        com.xxx.sdk.e.a.a.d.b.h h1 = new com.xxx.sdk.e.a.a.d.b.h();
        int l1 = a_java_nio_ByteBuffer_fld.getInt();
        int i3 = a_java_nio_ByteBuffer_fld.getInt();
        if(l1 > 0)
            h1.bP = a_com_xxx_sdk_e_a_a_d_h_fld.e[l1];
        h1.name = a_com_xxx_sdk_e_a_a_d_h_fld.e[i3];
        if(a_com_xxx_sdk_e_a_a_c_i_fld != null)
            a_com_xxx_sdk_e_a_a_c_i_fld.a(h1);
          goto _L10
_L9:
        Object obj1 = new d();
        int i2 = a_java_nio_ByteBuffer_fld.getInt();
        if(i2 > 0)
            obj1.data = a_com_xxx_sdk_e_a_a_d_h_fld.e[i2];
        obj1.e = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
        obj1 = a_com_xxx_sdk_e_a_a_c_i_fld;
          goto _L10
    }

    private void setLocale(Locale locale1)
    {
        if(locale1 != null)
            locale = locale1;
    }

    public final j a()
    {
        int k1;
        int j2;
        j j3;
        com.xxx.sdk.e.a.a.d.b.c c1;
        int l = a_java_nio_ByteBuffer_fld.getInt();
        k1 = a_java_nio_ByteBuffer_fld.getInt();
        j3 = new j();
        if(l > 0)
            j3.bP = a_com_xxx_sdk_e_a_a_d_h_fld.e[l];
        j3.name = a_com_xxx_sdk_e_a_a_d_h_fld.e[k1];
        a_java_nio_ByteBuffer_fld.getShort();
        a_java_nio_ByteBuffer_fld.getShort();
        j2 = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        a_java_nio_ByteBuffer_fld.getShort();
        a_java_nio_ByteBuffer_fld.getShort();
        a_java_nio_ByteBuffer_fld.getShort();
        c1 = new com.xxx.sdk.e.a.a.d.b.c(j2);
        k1 = 0;
_L29:
        if(k1 >= j2) goto _L2; else goto _L1
_L1:
        a a1;
        int i1 = a_java_nio_ByteBuffer_fld.getInt();
        int l1 = a_java_nio_ByteBuffer_fld.getInt();
        a1 = new a();
        if(i1 > 0)
            a1.bP = a_com_xxx_sdk_e_a_a_d_h_fld.e[i1];
        a1.name = a_com_xxx_sdk_e_a_a_d_h_fld.e[l1];
        if(a1.name.isEmpty() && d != null && l1 < d.length)
            a1.name = d[l1];
        i1 = a_java_nio_ByteBuffer_fld.getInt();
        if(i1 > 0)
            a1.bQ = a_com_xxx_sdk_e_a_a_d_h_fld.e[i1];
        a1.d = com.xxx.sdk.e.a.a.e.c.a(a_java_nio_ByteBuffer_fld, a_com_xxx_sdk_e_a_a_d_h_fld);
        if(a_com_xxx_sdk_e_a_a_c_i_fld == null) goto _L4; else goto _L3
_L3:
        int j1;
        int i2;
        Object obj;
        Object obj1;
        String s;
        obj = a_com_xxx_sdk_e_a_a_d_a_f_fld;
        obj1 = locale;
        if(a1.bQ != null)
            obj1 = a1.bQ;
        else
        if(a1.d != null)
            obj1 = a1.d.a(((com.xxx.sdk.e.a.a.d.a.f) (obj)), ((Locale) (obj1)));
        else
            obj1 = "";
        obj = obj1;
        if(!b.contains(a1.name)) goto _L6; else goto _L5
_L5:
        if(!h.isEmpty(((CharSequence) (obj1)))) goto _L8; else goto _L7
_L7:
        j1 = 0;
_L30:
        obj = obj1;
        if(j1 == 0) goto _L6; else goto _L9
_L9:
        s = a1.name;
        i2 = Integer.parseInt(((String) (obj1)));
        if(!"screenOrientation".equals(s)) goto _L11; else goto _L10
_L10:
        i2;
        JVM INSTR tableswitch -1 14: default 1502
    //                   -1 1582
    //                   0 1519
    //                   1 1540
    //                   2 1589
    //                   3 563
    //                   4 1561
    //                   5 1533
    //                   6 1568
    //                   7 1575
    //                   8 1547
    //                   9 1554
    //                   10 1505
    //                   11 1596
    //                   12 1603
    //                   13 1512
    //                   14 1526;
           goto _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28
_L12:
        try
        {
            obj = (new StringBuilder("ScreenOrientation:")).append(Integer.toHexString(i2)).toString();
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            obj = obj1;
        }
_L6:
        a1.value = ((String) (obj));
        c1.a[k1] = a1;
_L4:
        k1++;
          goto _L29
_L8:
        i2 = ((CharSequence) (obj1)).length();
        j1 = 0;
_L31:
label0:
        {
            if(j1 >= i2)
                break MISSING_BLOCK_LABEL_558;
            if(Character.isDigit(((CharSequence) (obj1)).charAt(j1)))
                break label0;
            j1 = 0;
        }
          goto _L30
        j1++;
          goto _L31
        j1 = 1;
          goto _L30
_L17:
        obj = "behind";
          goto _L32
_L11:
        if(!"configChanges".equals(s)) goto _L34; else goto _L33
_L33:
        obj = new ArrayList();
        if((i2 & 0x1000) == 0) goto _L36; else goto _L35
_L35:
        ((List) (obj)).add("density");
_L37:
        obj = h.a(((Iterable) (obj)), "|");
          goto _L32
_L36:
        if((0x40000000 & i2) == 0)
            break MISSING_BLOCK_LABEL_639;
        ((List) (obj)).add("fontScale");
          goto _L37
        if((i2 & 0x10) == 0)
            break MISSING_BLOCK_LABEL_659;
        ((List) (obj)).add("keyboard");
          goto _L37
        if((i2 & 0x20) == 0)
            break MISSING_BLOCK_LABEL_679;
        ((List) (obj)).add("keyboardHidden");
          goto _L37
        if((i2 & 0x2000) == 0)
            break MISSING_BLOCK_LABEL_700;
        ((List) (obj)).add("direction");
          goto _L37
        if((i2 & 4) == 0)
            break MISSING_BLOCK_LABEL_720;
        ((List) (obj)).add("locale");
          goto _L37
        if((i2 & 1) == 0)
            break MISSING_BLOCK_LABEL_740;
        ((List) (obj)).add("mcc");
          goto _L37
        if((i2 & 2) == 0)
            break MISSING_BLOCK_LABEL_760;
        ((List) (obj)).add("mnc");
          goto _L37
        if((i2 & 0x40) == 0)
            break MISSING_BLOCK_LABEL_781;
        ((List) (obj)).add("navigation");
          goto _L37
        if((i2 & 0x80) == 0)
            break MISSING_BLOCK_LABEL_803;
        ((List) (obj)).add("orientation");
          goto _L37
        if((i2 & 0x100) == 0)
            break MISSING_BLOCK_LABEL_825;
        ((List) (obj)).add("screenLayout");
          goto _L37
        if((i2 & 0x400) == 0)
            break MISSING_BLOCK_LABEL_847;
        ((List) (obj)).add("screenSize");
          goto _L37
        if((i2 & 0x800) == 0)
            break MISSING_BLOCK_LABEL_869;
        ((List) (obj)).add("smallestScreenSize");
          goto _L37
        if((i2 & 8) == 0) goto _L39; else goto _L38
_L38:
        ((List) (obj)).add("touchscreen");
          goto _L37
_L39:
        if((i2 & 0x200) == 0) goto _L37; else goto _L40
_L40:
        ((List) (obj)).add("uiMode");
          goto _L37
_L34:
        if(!"windowSoftInputMode".equals(s)) goto _L42; else goto _L41
_L41:
        j1 = i2 & 0xf0;
        i2 &= 0xf;
        obj = new ArrayList(2);
        j1;
        JVM INSTR lookupswitch 4: default 1619
    //                   0: 1622
    //                   16: 1087
    //                   32: 1073
    //                   48: 1059;
           goto _L43 _L44 _L45 _L46 _L47
_L43:
        ((List) (obj)).add((new StringBuilder("WindowInputModeAdjust:")).append(Integer.toHexString(j1)).toString());
          goto _L44
_L111:
        ((List) (obj)).add((new StringBuilder("WindowInputModeState:")).append(Integer.toHexString(i2)).toString());
_L48:
        obj = h.a(((Iterable) (obj)), "|");
          goto _L32
_L47:
        ((List) (obj)).add("adjustNothing");
          goto _L44
_L46:
        ((List) (obj)).add("adjustPan");
          goto _L44
_L45:
        ((List) (obj)).add("adjustResize");
          goto _L44
_L114:
        ((List) (obj)).add("stateAlwaysHidden");
          goto _L48
_L116:
        ((List) (obj)).add("stateAlwaysVisible");
          goto _L48
_L113:
        ((List) (obj)).add("stateHidden");
          goto _L48
_L112:
        ((List) (obj)).add("stateUnchanged");
          goto _L48
_L115:
        ((List) (obj)).add("stateVisible");
          goto _L48
_L42:
        if(!"launchMode".equals(s)) goto _L50; else goto _L49
_L49:
        i2;
        JVM INSTR tableswitch 0 3: default 1663
    //                   0 1666
    //                   1 1674
    //                   2 1682
    //                   3 1690;
           goto _L51 _L52 _L53 _L54 _L55
        if(true) goto _L32; else goto _L56
_L32:
        if(true) goto _L57; else goto _L56
_L57:
        if(true) goto _L58; else goto _L56
_L56:
_L51:
        obj = (new StringBuilder("LaunchMode:")).append(Integer.toHexString(i2)).toString();
          goto _L58
_L50:
        if(!"installLocation".equals(s)) goto _L60; else goto _L59
_L59:
        i2;
        JVM INSTR tableswitch 0 2: default 1698
    //                   0 1701
    //                   1 1709
    //                   2 1717;
           goto _L61 _L62 _L63 _L64
        if(true) goto _L58; else goto _L65
_L58:
        if(true) goto _L66; else goto _L65
_L66:
        if(true) goto _L67; else goto _L65
_L67:
        if(true) goto _L68; else goto _L65
_L68:
        if(true) goto _L69; else goto _L65
_L69:
        if(true) goto _L70; else goto _L65
_L70:
        if(true) goto _L71; else goto _L65
_L71:
        if(true) goto _L72; else goto _L65
_L72:
        if(true) goto _L73; else goto _L65
_L73:
        if(true) goto _L74; else goto _L65
_L74:
        if(true) goto _L75; else goto _L65
_L75:
        if(true) goto _L76; else goto _L65
_L76:
        if(true) goto _L77; else goto _L65
_L77:
        if(true) goto _L78; else goto _L65
_L78:
        if(true) goto _L79; else goto _L65
_L79:
        if(true) goto _L80; else goto _L65
_L80:
        if(true) goto _L81; else goto _L65
_L81:
        if(true) goto _L82; else goto _L65
_L82:
        if(true) goto _L83; else goto _L65
_L83:
        if(true) goto _L84; else goto _L65
_L84:
        if(true) goto _L85; else goto _L65
_L85:
        if(true) goto _L86; else goto _L65
_L86:
        if(true) goto _L87; else goto _L65
_L87:
        if(true) goto _L88; else goto _L65
_L88:
        if(true) goto _L89; else goto _L65
_L89:
        if(true) goto _L90; else goto _L65
_L90:
        if(true) goto _L91; else goto _L65
_L91:
        if(true) goto _L92; else goto _L65
_L92:
        if(true) goto _L93; else goto _L65
_L93:
        if(true) goto _L94; else goto _L65
_L94:
        if(true) goto _L95; else goto _L65
_L95:
        if(true) goto _L96; else goto _L65
_L96:
        if(true) goto _L97; else goto _L65
_L97:
        if(true) goto _L98; else goto _L65
_L98:
        if(true) goto _L99; else goto _L65
_L99:
        if(true) goto _L100; else goto _L65
_L100:
        if(true) goto _L101; else goto _L65
_L101:
        if(true) goto _L102; else goto _L65
_L102:
        if(true) goto _L103; else goto _L65
_L103:
        if(true) goto _L104; else goto _L65
_L104:
        if(true) goto _L6; else goto _L65
_L65:
_L61:
        obj = (new StringBuilder("installLocation:")).append(Integer.toHexString(i2)).toString();
          goto _L6
_L60:
        obj = obj1;
        if(!"protectionLevel".equals(s)) goto _L6; else goto _L105
_L105:
        obj = new ArrayList(3);
        j1 = i2;
        if((i2 & 0x10) == 0) goto _L107; else goto _L106
_L106:
        j1 = i2 ^ 0x10;
        ((List) (obj)).add("system");
_L107:
        i2 = j1;
        if((j1 & 0x20) == 0) goto _L109; else goto _L108
_L108:
        i2 = j1 ^ 0x20;
        ((List) (obj)).add("development");
          goto _L109
_L117:
        ((List) (obj)).add((new StringBuilder("ProtectionLevel:")).append(Integer.toHexString(i2)).toString());
_L110:
        obj = h.a(((Iterable) (obj)), "|");
          goto _L6
_L118:
        ((List) (obj)).add("normal");
          goto _L110
_L119:
        ((List) (obj)).add("dangerous");
          goto _L110
_L120:
        ((List) (obj)).add("signature");
          goto _L110
_L121:
        ((List) (obj)).add("signatureOrSystem");
          goto _L110
_L2:
        j3.a = c1;
        if(a_com_xxx_sdk_e_a_a_c_i_fld != null)
            a_com_xxx_sdk_e_a_a_c_i_fld.a(j3);
        return j3;
_L24:
        obj = "fullSensor";
          goto _L6
_L27:
        obj = "fullUser";
          goto _L6
_L14:
        obj = "landscape";
          goto _L6
_L28:
        obj = "locked";
          goto _L6
_L19:
        obj = "nosensor";
          goto _L6
_L15:
        obj = "portrait";
          goto _L6
_L22:
        obj = "reverseLandscape";
          goto _L6
_L23:
        obj = "reversePortrait";
          goto _L6
_L18:
        obj = "sensor";
          goto _L6
_L20:
        obj = "sensorLandscape";
          goto _L6
_L21:
        obj = "sensorPortrait";
          goto _L6
_L13:
        obj = "unspecified";
          goto _L6
_L16:
        obj = "user";
          goto _L6
_L25:
        obj = "userLandscape";
          goto _L6
_L26:
        obj = "userPortrait";
          goto _L6
_L44:
        i2;
        JVM INSTR tableswitch 0 5: default 1660
    //                   0 1047
    //                   1 1143
    //                   2 1129
    //                   3 1101
    //                   4 1157
    //                   5 1115;
           goto _L111 _L48 _L112 _L113 _L114 _L115 _L116
_L52:
        obj = "standard";
          goto _L6
_L53:
        obj = "singleTop";
          goto _L6
_L54:
        obj = "singleTask";
          goto _L6
_L55:
        obj = "singleInstance";
          goto _L6
_L62:
        obj = "auto";
          goto _L6
_L63:
        obj = "internalOnly";
          goto _L6
_L64:
        obj = "preferExternal";
          goto _L6
_L109:
        i2;
        JVM INSTR tableswitch 0 3: default 1756
    //                   0 1418
    //                   1 1432
    //                   2 1446
    //                   3 1460;
           goto _L117 _L118 _L119 _L120 _L121
    }

    public final com.xxx.sdk.e.a.a.d.b a()
    {
        if(!a_java_nio_ByteBuffer_fld.hasRemaining())
            return null;
        long l1 = a_java_nio_ByteBuffer_fld.position();
        int l = a_java_nio_ByteBuffer_fld.getShort() & 0xffff;
        int i1 = 0xffff & a_java_nio_ByteBuffer_fld.getShort();
        long l2 = a(a_java_nio_ByteBuffer_fld);
        switch(l)
        {
        default:
            throw new com.xxx.sdk.e.a.a.b.a((new StringBuilder("Unexpected chunk type:")).append(l).toString());

        case 3: // '\003'
            return new com.xxx.sdk.e.a.a.d.b.e(l, i1, l2);

        case 1: // '\001'
            i j1 = new i(l, i1, l2);
            j1.o = a(a_java_nio_ByteBuffer_fld);
            j1.p = a(a_java_nio_ByteBuffer_fld);
            j1.q = a(a_java_nio_ByteBuffer_fld);
            j1.r = a(a_java_nio_ByteBuffer_fld);
            j1.s = a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return j1;

        case 384: 
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return new k(l, i1, l2);

        case 256: 
        case 257: 
        case 258: 
        case 259: 
        case 260: 
            com.xxx.sdk.e.a.a.d.b.i k1 = new com.xxx.sdk.e.a.a.d.b.i(l, i1, l2);
            k1.bE = (int)a(a_java_nio_ByteBuffer_fld);
            k1.bF = (int)a(a_java_nio_ByteBuffer_fld);
            a_java_nio_ByteBuffer_fld.position((int)(l1 + (long)i1));
            return k1;
        }
    }

    private static final Set b = new HashSet(Arrays.asList(new String[] {
        "screenOrientation", "configChanges", "windowSoftInputMode", "launchMode", "installLocation", "protectionLevel"
    }));
    public com.xxx.sdk.e.a.a.c.i a_com_xxx_sdk_e_a_a_c_i_fld;
    private final com.xxx.sdk.e.a.a.d.a.f a_com_xxx_sdk_e_a_a_d_a_f_fld;
    public h a_com_xxx_sdk_e_a_a_d_h_fld;
    public ByteBuffer a_java_nio_ByteBuffer_fld;
    private ByteOrder byteOrder;
    public String d[];
    public Locale locale;

}
