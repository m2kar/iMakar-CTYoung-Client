// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.realtech_inc.andproject.chinanet.constant.UserInfoConstants;

// Referenced classes of package com.realtech_inc.andproject.chinanet.activity:
//            BaseActivity

public class WlanMainActivity extends BaseActivity
{

    public WlanMainActivity()
    {
    }

    private void doCreateConnect()
    {
        et_Account.setEnabled(false);
        et_Password.setEnabled(false);
        btn_Login.setEnabled(false);
        startConntectTask(et_Account.getText().toString(), et_Password.getText().toString());
    }

    private void doDisConnect()
    {
        btn_Logout.setEnabled(false);
        startDisConnectTask();
    }

    private void doResumeConnect()
    {
        et_Account.setEnabled(false);
        et_Password.setEnabled(false);
        btn_Login.setEnabled(false);
        startConntectTask(preferences.getString(UserInfoConstants.KEYWORD_USER_NAME, null), preferences.getString(UserInfoConstants.KEYWORD_USER_PSW, null));
    }

    private void initView()
    {
        et_Account = (EditText)findViewById(0x7f08004e);
        et_Password = (EditText)findViewById(0x7f080049);
        btn_Login = (Button)findViewById(0x7f08004f);
        btn_Logout = (Button)findViewById(0x7f080050);
        et_Password.setInputType(129);
    }

    private void login()
    {
        if(preferences.getBoolean(UserInfoConstants.KEYWORD_FLAG_LOGINED_ON, false))
        {
            doCreateConnect();
            return;
        } else
        {
            doResumeConnect();
            return;
        }
    }

    private void onError()
    {
        et_Account.setEnabled(true);
        et_Password.setEnabled(true);
        btn_Login.setEnabled(true);
    }

    private void onLogin()
    {
        btn_Logout.setEnabled(true);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(UserInfoConstants.KEYWORD_USER_NAME, et_Account.getText().toString());
        editor.putString(UserInfoConstants.KEYWORD_USER_PSW, et_Password.getText().toString());
        editor.putBoolean(UserInfoConstants.KEYWORD_FLAG_LOGINED_ON, true);
        editor.commit();
    }

    private void onLogout()
    {
        et_Account.setEnabled(true);
        et_Password.setEnabled(true);
        btn_Login.setEnabled(true);
        android.content.SharedPreferences.Editor editor = getSharedPreferences(UserInfoConstants.KEYWORD_USER_INFO_DATA_FILE_NAME, 0).edit();
        editor.putBoolean(UserInfoConstants.KEYWORD_FLAG_LOGINED_ON, true);
        editor.commit();
    }

    private void startConntectTask(String s, String s1)
    {
        onLogin();
    }

    private void startDisConnectTask()
    {
        onLogout();
    }

    void notifyView(int i, Bundle bundle)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030019);
        preferences = getSharedPreferences(UserInfoConstants.KEYWORD_USER_INFO_DATA_FILE_NAME, 0);
        initView();
    }

    private Button btn_Login;
    private Button btn_Logout;
    private EditText et_Account;
    private EditText et_Password;
    private SharedPreferences preferences;
}
