// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.constant;


// Referenced classes of package com.realtech_inc.andproject.chinanet.constant:
//            BaseObject

public class AccountInfo extends BaseObject
{

    public AccountInfo()
    {
    }

    public boolean equals(Object obj)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = false;
        if(this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag2;
        if(obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        if(getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (AccountInfo)obj;
        if(id == null) goto _L7; else goto _L6
_L6:
        flag = flag2;
        if(!id.equals(((AccountInfo) (obj)).id)) goto _L4; else goto _L8
_L8:
        if(username == null) goto _L10; else goto _L9
_L9:
        flag = flag2;
        if(!username.equals(((AccountInfo) (obj)).username)) goto _L4; else goto _L11
_L11:
        if(password == null) goto _L13; else goto _L12
_L12:
        flag = flag1;
        if(password.equals(((AccountInfo) (obj)).password)) goto _L15; else goto _L14
_L14:
        flag = false;
_L15:
        return flag;
_L7:
        if(((AccountInfo) (obj)).id == null) goto _L8; else goto _L16
_L16:
        return false;
_L10:
        if(((AccountInfo) (obj)).username == null) goto _L11; else goto _L17
_L17:
        return false;
_L13:
        if(((AccountInfo) (obj)).password != null) goto _L14; else goto _L18
_L18:
        flag = flag1;
          goto _L15
    }

    public Long getId()
    {
        return id;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return username;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if(id != null)
            i = id.hashCode();
        else
            i = 0;
        if(username != null)
            j = username.hashCode();
        else
            j = 0;
        if(password != null)
            k = password.hashCode();
        return (i * 31 + j) * 31 + k;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AccountInfo{id=").append(id).append(", username='").append(username).append('\'').append(", password='").append(password).append('\'').append('}').toString();
    }

    private Long id;
    private String password;
    private String username;
}
