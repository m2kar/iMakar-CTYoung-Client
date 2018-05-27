// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.b;


public final class g extends Enum
{

    private g(String s, int i)
    {
        super(s, i);
    }

    private static g a(String s)
    {
        return (g)Enum.valueOf(com/xxx/sdk/b/g, s);
    }

    private static g[] a()
    {
        return (g[])$VALUES.clone();
    }

    private static final g $VALUES[];
    public static final g h5;
    public static final g image;
    public static final g text;
    public static final g video;

    static 
    {
        h5 = new g("h5", 0);
        text = new g("text", 1);
        image = new g("image", 2);
        video = new g("video", 3);
        $VALUES = (new g[] {
            h5, text, image, video
        });
    }
}
