// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.constant;

import com.realtech_inc.andproject.chinanet.utils.MD5Crypto;

public class UserInfoConstants
{

    public UserInfoConstants()
    {
    }

    public static String KEYWORD_FLAG_LOGINED_ON = MD5Crypto.md5("flag_logined_on");
    public static String KEYWORD_USER_INFO_DATA_FILE_NAME = MD5Crypto.md5("user_info");
    public static String KEYWORD_USER_NAME = MD5Crypto.md5("account");
    public static String KEYWORD_USER_PSW = MD5Crypto.md5("password");

}
