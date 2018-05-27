// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.a;

import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.f.p;
import com.xxx.f.z;
import com.xxx.sdk.b.a;
import com.xxx.sdk.d.i;
import com.xxx.sdk.e.a.a.d.h;
import com.xxx.sdk.f.d;
import java.util.ArrayList;
import java.util.List;

public final class b
    implements z
{

    public b()
    {
    }

    public b(p p1)
    {
        d = p1;
        super();
    }

    private static String b(int j)
    {
        switch(j)
        {
        default:
            return (new StringBuilder("ScreenOrientation:")).append(Integer.toHexString(j)).toString();

        case 3: // '\003'
            return "behind";

        case 10: // '\n'
            return "fullSensor";

        case 13: // '\r'
            return "fullUser";

        case 0: // '\0'
            return "landscape";

        case 14: // '\016'
            return "locked";

        case 5: // '\005'
            return "nosensor";

        case 1: // '\001'
            return "portrait";

        case 8: // '\b'
            return "reverseLandscape";

        case 9: // '\t'
            return "reversePortrait";

        case 4: // '\004'
            return "sensor";

        case 6: // '\006'
            return "sensorLandscape";

        case 7: // '\007'
            return "sensorPortrait";

        case -1: 
            return "unspecified";

        case 2: // '\002'
            return "user";

        case 11: // '\013'
            return "userLandscape";

        case 12: // '\f'
            return "userPortrait";
        }
    }

    private static String c(int j)
    {
        switch(j)
        {
        default:
            return (new StringBuilder("LaunchMode:")).append(Integer.toHexString(j)).toString();

        case 0: // '\0'
            return "standard";

        case 1: // '\001'
            return "singleTop";

        case 2: // '\002'
            return "singleTask";

        case 3: // '\003'
            return "singleInstance";
        }
    }

    private static String d(int j)
    {
        ArrayList arraylist = new ArrayList();
        if((j & 0x1000) == 0) goto _L2; else goto _L1
_L1:
        arraylist.add("density");
_L4:
        return h.a(arraylist, "|");
_L2:
        if((0x40000000 & j) != 0)
            arraylist.add("fontScale");
        else
        if((j & 0x10) != 0)
            arraylist.add("keyboard");
        else
        if((j & 0x20) != 0)
            arraylist.add("keyboardHidden");
        else
        if((j & 0x2000) != 0)
            arraylist.add("direction");
        else
        if((j & 4) != 0)
            arraylist.add("locale");
        else
        if((j & 1) != 0)
            arraylist.add("mcc");
        else
        if((j & 2) != 0)
            arraylist.add("mnc");
        else
        if((j & 0x40) != 0)
            arraylist.add("navigation");
        else
        if((j & 0x80) != 0)
            arraylist.add("orientation");
        else
        if((j & 0x100) != 0)
            arraylist.add("screenLayout");
        else
        if((j & 0x400) != 0)
            arraylist.add("screenSize");
        else
        if((j & 0x800) != 0)
            arraylist.add("smallestScreenSize");
        else
        if((j & 8) != 0)
            arraylist.add("touchscreen");
        else
        if((j & 0x200) != 0)
            arraylist.add("uiMode");
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String e(int j)
    {
        int i1;
        ArrayList arraylist;
        i1 = j & 0xf0;
        j &= 0xf;
        arraylist = new ArrayList(2);
        i1;
        JVM INSTR lookupswitch 4: default 64
    //                   0: 90
    //                   16: 185
    //                   32: 173
    //                   48: 161;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_90;
_L1:
        arraylist.add((new StringBuilder("WindowInputModeAdjust:")).append(Integer.toHexString(i1)).toString());
_L13:
        j;
        JVM INSTR tableswitch 0 5: default 128
    //                   0 154
    //                   1 233
    //                   2 221
    //                   3 197
    //                   4 245
    //                   5 209;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L7:
        break; /* Loop/switch isn't completed */
_L6:
        arraylist.add((new StringBuilder("WindowInputModeState:")).append(Integer.toHexString(j)).toString());
_L14:
        return h.a(arraylist, "|");
_L5:
        arraylist.add("adjustNothing");
          goto _L13
_L4:
        arraylist.add("adjustPan");
          goto _L13
_L3:
        arraylist.add("adjustResize");
          goto _L13
_L10:
        arraylist.add("stateAlwaysHidden");
          goto _L14
_L12:
        arraylist.add("stateAlwaysVisible");
          goto _L14
_L9:
        arraylist.add("stateHidden");
          goto _L14
_L8:
        arraylist.add("stateUnchanged");
          goto _L14
_L11:
        arraylist.add("stateVisible");
          goto _L14
    }

    private static String f(int j)
    {
        int i1;
        ArrayList arraylist;
        arraylist = new ArrayList(3);
        if((j & 0x10) != 0)
        {
            j ^= 0x10;
            arraylist.add("system");
        }
        i1 = j;
        if((j & 0x20) != 0)
        {
            i1 = j ^ 0x20;
            arraylist.add("development");
        }
        i1;
        JVM INSTR tableswitch 0 3: default 84
    //                   0 117
    //                   1 129
    //                   2 141
    //                   3 153;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        arraylist.add((new StringBuilder("ProtectionLevel:")).append(Integer.toHexString(i1)).toString());
_L7:
        return h.a(arraylist, "|");
_L2:
        arraylist.add("normal");
        continue; /* Loop/switch isn't completed */
_L3:
        arraylist.add("dangerous");
        continue; /* Loop/switch isn't completed */
_L4:
        arraylist.add("signature");
        continue; /* Loop/switch isn't completed */
_L5:
        arraylist.add("signatureOrSystem");
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static String g(int j)
    {
        switch(j)
        {
        default:
            return (new StringBuilder("installLocation:")).append(Integer.toHexString(j)).toString();

        case 0: // '\0'
            return "auto";

        case 1: // '\001'
            return "internalOnly";

        case 2: // '\002'
            return "preferExternal";
        }
    }

    public final boolean a(String s)
    {
        p.a(d);
        if(!com.xxx.e.g.b(s)) goto _L2; else goto _L1
_L1:
        com.xxx.e.e.a(p.a(d), Uri.parse(s));
        p.a(d).click();
        p.a(d).am();
        i.a().sendEmptyMessage(86);
_L4:
        d.update(a.URL_CHANGED);
        return true;
_L2:
        p.a(d).click();
        p.a(d).loadUrl(s);
        if(p.a(d) <= 0L)
            p.a(d, System.currentTimeMillis());
        if(!d.F && d.getVisibility() == 0)
        {
            d.handler.removeCallbacks(p.a(d));
            p.a(d).setVisibility(0);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final void k()
    {
        if(com.xxx.e.e.a(p.a(d)))
        {
            d.update(a.FAILED);
            return;
        }
        if(d.bY != 0) goto _L2; else goto _L1
_L1:
        d.update(a.FIRST_URL_LOADED);
_L4:
        p p1 = d;
        p1.bY = p1.bY + 1;
        return;
_L2:
        if(d.bY == 1)
            p.a(d).am();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final void l()
    {
        d.update(a.FAILED);
    }

    public final void m()
    {
    }

    public p d;
}
