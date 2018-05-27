// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.realtech_inc.andproject.chinanet.networks.UpdateManager;

public class LoadingActive extends Activity
{

    public LoadingActive()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f03001d);
        aq = new AQuery(this);
        um = UpdateManager.getInstance();
        um.init(this, aq);
        tv_version = (TextView)findViewById(0x7f080062);
        AlphaAnimation alphaanimation;
        try
        {
            tv_version.setText(getString(0x7f0a0045, new Object[] {
                getPackageManager().getPackageInfo(getPackageName(), 0).versionName
            }));
        }
        // Misplaced declaration of an exception variable
        catch(Bundle bundle)
        {
            tv_version.setText(getString(0x7f0a0045, new Object[] {
                ""
            }));
        }
        bundle = (ImageView)findViewById(0x7f080061);
        alphaanimation = new AlphaAnimation(0.1F, 1.0F);
        alphaanimation.setDuration(3000L);
        bundle.setAnimation(alphaanimation);
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation)
            {
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                um.checkUpdate();
            }

            final LoadingActive this$0;

            
            {
                this$0 = LoadingActive.this;
                super();
            }
        }
);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if(menuitem.getItemId() == 0x7f08007b)
            return true;
        else
            return super.onOptionsItemSelected(menuitem);
    }

    protected void onResume()
    {
        super.onResume();
    }

    private AQuery aq;
    private TextView tv_version;
    private UpdateManager um;

}
