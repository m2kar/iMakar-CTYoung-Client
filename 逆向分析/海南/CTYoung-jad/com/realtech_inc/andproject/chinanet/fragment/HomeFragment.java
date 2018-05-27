// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.*;
import android.webkit.*;
import android.widget.AdapterView;
import android.widget.ListView;
import com.actionbarsherlock.app.*;
import com.actionbarsherlock.view.MenuItem;
import com.realtech_inc.andproject.chinanet.activity.HomeActivity;
import com.realtech_inc.andproject.chinanet.adapter.DrawerOptionAdapter;
import com.realtech_inc.andproject.chinanet.adapter.DrawerOptions;
import com.realtech_inc.andproject.chinanet.constant.Constant;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;

public class HomeFragment extends SherlockFragment
{
    private class ActionBarHelper
    {

        public void init()
        {
            mActionBar.setDisplayShowTitleEnabled(false);
            mActionBar.setLogo(getResources().getDrawable(0x7f0200a0));
            mActionBar.setDisplayShowHomeEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setBackgroundDrawable(getResources().getDrawable(0x7f020071));
            CharSequence charsequence = getActivity().getTitle();
            mDrawerTitle = charsequence;
            mTitle = charsequence;
        }

        public void onDrawerClosed()
        {
            mActionBar.setTitle(mTitle);
        }

        public void onDrawerOpened()
        {
            mActionBar.setTitle(mDrawerTitle);
        }

        private final ActionBar mActionBar;
        private CharSequence mDrawerTitle;
        private CharSequence mTitle;
        final HomeFragment this$0;

        private ActionBarHelper()
        {
            this$0 = HomeFragment.this;
            super();
            mActionBar = ((SherlockFragmentActivity)getActivity()).getSupportActionBar();
        }

    }

    private class DemoDrawerListener
        implements android.support.v4.widget.DrawerLayout.DrawerListener
    {

        public void onDrawerClosed(View view)
        {
            mDrawerToggle.onDrawerClosed(view);
            mActionBar.onDrawerClosed();
        }

        public void onDrawerOpened(View view)
        {
            mDrawerToggle.onDrawerOpened(view);
            mActionBar.onDrawerOpened();
        }

        public void onDrawerSlide(View view, float f)
        {
            mDrawerToggle.onDrawerSlide(view, f);
        }

        public void onDrawerStateChanged(int i)
        {
            mDrawerToggle.onDrawerStateChanged(i);
        }

        final HomeFragment this$0;

        private DemoDrawerListener()
        {
            this$0 = HomeFragment.this;
            super();
        }

    }

    private class DrawerItemClickListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            DebugLog.d(TAG, (new StringBuilder()).append("Item Clicked Info:\r\npostion = ").append(i).append("\r\nid = ").append(l).toString());
            HomeActivity.clickedPosition = i;
            HomeActivity.showDialog();
        }

        private final String TAG;
        final HomeFragment this$0;

        private DrawerItemClickListener()
        {
            this$0 = HomeFragment.this;
            super();
            TAG = com/realtech_inc/andproject/chinanet/fragment/HomeFragment$DrawerItemClickListener.getSimpleName();
        }

    }


    public HomeFragment()
    {
    }

    private ActionBarHelper createActionBarHelper()
    {
        return new ActionBarHelper();
    }

    public static Fragment newInstance()
    {
        return new HomeFragment();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        DebugLog.i(TAG, "onCreate start...");
        super.onCreate(bundle);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        DebugLog.i(TAG, "onCreate finished");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        DebugLog.i(TAG, "onCreateView start...");
        layoutinflater = layoutinflater.inflate(0x7f030024, viewgroup, false);
        mDrawerLayout = (DrawerLayout)layoutinflater.findViewById(0x7f080076);
        listView = (ListView)layoutinflater.findViewById(0x7f080078);
        viewgroup = (WebView)layoutinflater.findViewById(0x7f080077);
        viewgroup.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
                startActivity(webview);
                return true;
            }

            final HomeFragment this$0;

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        }
);
        viewgroup.getSettings().setJavaScriptEnabled(true);
        try
        {
            viewgroup.loadUrl((new StringBuilder()).append("http://mobile1hb.189joy.com/?s=").append(System.currentTimeMillis()).append("&version=").append(getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName).toString());
            viewgroup.loadUrl((new StringBuilder()).append(Constant.AD_URL).append("?s=").append(System.currentTimeMillis()).append("&version=").append(getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName).toString());
        }
        // Misplaced declaration of an exception variable
        catch(ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        mDrawerLayout.setDrawerListener(new DemoDrawerListener());
        mDrawerLayout.setDrawerShadow(0x7f02007d, 0x800003);
        listView.setAdapter(new DrawerOptionAdapter(getActivity().getApplicationContext(), 0x7f030023, new DrawerOptions()));
        listView.setOnItemClickListener(new DrawerItemClickListener());
        listView.setCacheColorHint(0);
        listView.setScrollingCacheEnabled(false);
        listView.setScrollContainer(false);
        listView.setFastScrollEnabled(true);
        listView.setSmoothScrollbarEnabled(true);
        mActionBar = createActionBarHelper();
        mActionBar.init();
        mDrawerToggle = new SherlockActionBarDrawerToggle(getActivity(), mDrawerLayout, 0x7f02008e, 0x7f0a001d, 0x7f0a001b);
        mDrawerToggle.syncState();
        DebugLog.i(TAG, "onCreateView finished");
        return layoutinflater;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if(mDrawerToggle.onOptionsItemSelected(menuitem))
            return true;
        else
            return super.onOptionsItemSelected(menuitem);
    }

    private static final String TAG = com/realtech_inc/andproject/chinanet/fragment/HomeFragment.getSimpleName();
    private ListView listView;
    private ActionBarHelper mActionBar;
    private DrawerLayout mDrawerLayout;
    private SherlockActionBarDrawerToggle mDrawerToggle;



}
