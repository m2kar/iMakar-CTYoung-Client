// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;

// Referenced classes of package com.realtech_inc.andproject.chinanet.activity:
//            UpdateBindActivity, AccountBindActivity

public class AccountManagerActivity extends Activity
{

    public AccountManagerActivity()
    {
    }

    private void initData()
    {
        if(!"".equals(SPM.getData("LastLogonUser", "")) && !"".equals(SPM.getData("LastLogonPswd", "")))
        {
            bind_or_update.setText("\u4FEE\u6539\u8D26\u53F7");
            miaoshu.setText((new StringBuilder()).append("\u8D26\u53F7\u540D:").append(SPM.getData("LastLogonUser", "")).toString());
            miaoshu.setTextColor(Color.parseColor("#397F00"));
            bind_or_update.setOnClickListener(new android.view.View.OnClickListener() {

                public void onClick(View view)
                {
                    startActivity(new Intent(context, com/realtech_inc/andproject/chinanet/activity/UpdateBindActivity));
                    finish();
                }

                final AccountManagerActivity this$0;

            
            {
                this$0 = AccountManagerActivity.this;
                super();
            }
            }
);
            return;
        } else
        {
            bind_or_update.setText("\u7ED1\u5B9A\u8D26\u53F7");
            miaoshu.setText("\u8D26\u53F7\u540D\uFF1A\u4F60\u8FD8\u672A\u7ED1\u5B9A\u5BBD\u5E26\u8D26\u53F7");
            bind_or_update.setOnClickListener(new android.view.View.OnClickListener() {

                public void onClick(View view)
                {
                    startActivity(new Intent(context, com/realtech_inc/andproject/chinanet/activity/AccountBindActivity));
                    finish();
                }

                final AccountManagerActivity this$0;

            
            {
                this$0 = AccountManagerActivity.this;
                super();
            }
            }
);
            return;
        }
    }

    private void initWidget()
    {
        back = (ImageView)findViewById(0x7f080045);
        back.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                finish();
            }

            final AccountManagerActivity this$0;

            
            {
                this$0 = AccountManagerActivity.this;
                super();
            }
        }
);
        bind_or_update = (Button)findViewById(0x7f080047);
        miaoshu = (TextView)findViewById(0x7f080046);
    }

    protected void onCreate(Bundle bundle)
    {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(0x7f030016);
        context = getApplicationContext();
        initWidget();
        initData();
    }

    private static final SharedPrefsManager SPM = SharedPrefsManager.getInstance();
    private ImageView back;
    private Button bind_or_update;
    private Context context;
    private EditText et_password;
    private EditText et_username;
    private TextView miaoshu;


}
