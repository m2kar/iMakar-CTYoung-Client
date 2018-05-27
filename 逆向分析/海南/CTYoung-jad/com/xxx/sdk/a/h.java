// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;


public final class h
{

    public h()
    {
    }

    public h(String s, String s1, String s2)
    {
        url = s;
        aF = s1;
        aG = null;
        aH = s2;
    }

    public final String toString()
    {
        return (new StringBuilder("SdkTrackRecord [id=")).append(id).append(", url=").append(url).append(", urlParams=").append(aF).append(", headParams=").append(aG).append(", httpMethod=").append(aH).append(", createDate=").append(i).append("]").toString();
    }

    private static String aA = "url";
    private static String aB = "url_params";
    private static String aC = "head_params";
    private static String aD = "http_method";
    private static String aE = "create_date";
    private static String af = "sdk_track_record";
    private static String ag = "id";
    public static final String b[] = {
        "id", "url", "url_params", "head_params", "http_method", "create_date"
    };
    public String aF;
    public String aG;
    public String aH;
    public long i;
    public long id;
    public String url;

}
