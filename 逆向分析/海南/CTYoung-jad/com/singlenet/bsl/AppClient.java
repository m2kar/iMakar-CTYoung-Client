// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.singlenet.bsl;

import java.io.*;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.singlenet.bsl:
//            Utils

public class AppClient
{

    public AppClient(String s, String s1, int i)
    {
        aesKey = "1234567812345678";
        server = "127.0.0.1";
        port = 54321;
        aesKey = s;
        server = s1;
        port = i;
    }

    public byte[] getByteStreamForSetAccount(String s, String s1, String s2)
        throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException
    {
        return getByteStreamWithCmdString(String.format("SETACCOUNT %s %s %s", new Object[] {
            s, s1, s2
        }));
    }

    public byte[] getByteStreamWithCmdString(String s)
        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException
    {
        SecretKeySpec secretkeyspec = new SecretKeySpec(aesKey.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretkeyspec);
        s = cipher.doFinal(s.getBytes("utf-8")); // AES 加密后
        byte abyte0[] = Utils.intToBytes(s.length); //
        byte abyte1[] = new byte[abyte0.length + s.length];
        /*
        public static void (Object src,
                             int srcPos,
                             Object dest,
                             int destPos,
                             int length)
         */
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        System.arraycopy(s, 0, abyte1, abyte0.length, s.length);
        return abyte1;
    }

    public String sendLoginCmdToServer(String s, String s1, String s2)
    {
        byte abyte0[];
        String s4;
        s4 = "OK.";
        if(s == null || s.length() == 0)
            return "Param key can't is emptyl.";
        if(s1 == null || s1.length() == 0)
            return "Param username can't is empty.";
        if(s2 == null || s2.length() == 0)
            return "Param password can't is empty.";
        abyte0 = null;
        s = getByteStreamForSetAccount(s, s1, s2);
        abyte0 = s;
        s1 = s4;
_L1:
        Object obj;
        s = s1;
        if(abyte0 == null)
            break MISSING_BLOCK_LABEL_113;
        obj = null;
        s = null;
        s4 = null;
        s2 = new Socket(server, port);
        s2.getOutputStream().write(abyte0);
        s2.close();
        s2.close();
        s = s1;
_L2:
        return s;
        s;
        s.printStackTrace();
        s1 = s.getLocalizedMessage();
          goto _L1
        s;
        s.printStackTrace();
        s = s1;
          goto _L2
        s2;
        s1 = s4;
_L6:
        s = s1;
        String s3 = s2.getLocalizedMessage();
        s = s1;
        s2.printStackTrace();
        s1.close();
        s = s3;
          goto _L2
        s;
        s.printStackTrace();
        s = s3;
          goto _L2
        s2;
        s1 = obj;
_L5:
        s = s1;
        s3 = s2.getLocalizedMessage();
        s = s1;
        s2.printStackTrace();
        s1.close();
        s = s3;
          goto _L2
        s;
        s.printStackTrace();
        s = s3;
          goto _L2
        s1;
_L4:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            s.printStackTrace();
        }
        throw s1;
        s1;
        s = s2;
        if(true) goto _L4; else goto _L3
_L3:
        s;
        s1 = s2;
        s2 = s;
          goto _L5
        s;
        s1 = s2;
        s2 = s;
          goto _L6
    }

    private String aesKey;
    private int port;
    private String server;
}
