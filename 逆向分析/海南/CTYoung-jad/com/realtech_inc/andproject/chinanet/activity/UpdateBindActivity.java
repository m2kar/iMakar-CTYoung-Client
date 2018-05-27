// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;

public class UpdateBindActivity extends Activity
{

    public UpdateBindActivity()
    {
    }

    private void initData()
    {
        tv_account.setText(SPM.getData("LastLogonUser", ""));
        update.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                if("".equals(et_username.getText().toString().trim()))
                {
                    Toast.makeText(context, "\u8D26\u6237\u540D\u4E0D\u80FD\u4E3A\u7A7A", 1).show();
                    return;
                }
                if("".equals(et_password.getText().toString().trim()))
                {
                    Toast.makeText(context, "\u5BC6\u7801\u4E0D\u80FD\u4E3A\u7A7A", 1).show();
                    return;
                } else
                {
                    UpdateBindActivity.SPM.setData("LastLogonUser", et_username.getText().toString().trim());
                    UpdateBindActivity.SPM.setData("LastLogonPswd", et_password.getText().toString().trim());
                    finish();
                    return;
                }
            }

            final UpdateBindActivity this$0;

            
            {
                this$0 = UpdateBindActivity.this;
                super();
            }
        }
);
    }

    private void initWidget()
    {
        back = (ImageView)findViewById(0x7f080045);
        back.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                finish();
            }

            final UpdateBindActivity this$0;

            
            {
                this$0 = UpdateBindActivity.this;
                super();
            }
        }
);
        tv_account = (TextView)findViewById(0x7f08006a);
        et_username = (EditText)findViewById(0x7f080048);
        et_password = (EditText)findViewById(0x7f080049);
        update = (Button)findViewById(0x7f08006b);
    }

    protected void onCreate(Bundle bundle)
    {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(0x7f030020);
        context = getApplicationContext();
        initWidget();
        initData();
    }

    private static final SharedPrefsManager SPM = SharedPrefsManager.getInstance();
    private ImageView back;
    private Context context;
    private EditText et_password;
    private EditText et_username;
    private TextView tv_account;
    private Button update;





}
