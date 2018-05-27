// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.kobjects.pim;


// Referenced classes of package org.kobjects.pim:
//            PimItem

public class VCard extends PimItem
{

    public VCard()
    {
    }

    public VCard(VCard vcard)
    {
        super(vcard);
    }

    public int getArraySize(String s)
    {
        if(s.equals("n"))
            return 5;
        return !s.equals("adr") ? -1 : 6;
    }

    public String getType()
    {
        return "vcard";
    }
}
