// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SinglenetInfoDialog extends Dialog
{

    public SinglenetInfoDialog(Context context1)
    {
        super(context1);
        context = context1;
        dialog = this;
        setCustomDialog();
    }

    private void setCustomDialog()
    {
        View view = LayoutInflater.from(context).inflate(0x7f030021, null);
        info_tv = (TextView)view.findViewById(0x7f08006f);
        dialog_ok_btn = (Button)view.findViewById(0x7f080070);
        dialog_ok_btn.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
                dialog.hide();
            }

            final SinglenetInfoDialog this$0;

            
            {
                this$0 = SinglenetInfoDialog.this;
                super();
            }
        }
);
        dialog.setCancelable(false);
        requestWindowFeature(1);
        super.setContentView(view);
    }

    public Button getDialog_ok_btn()
    {
        return dialog_ok_btn;
    }

    public TextView getInfo_tv()
    {
        return info_tv;
    }

    private Context context;
    private Dialog dialog;
    private Button dialog_ok_btn;
    private TextView info_tv;

}
