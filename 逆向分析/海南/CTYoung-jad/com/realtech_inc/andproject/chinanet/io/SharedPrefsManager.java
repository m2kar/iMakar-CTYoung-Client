// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.io;

import android.content.Context;
import android.content.SharedPreferences;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;

public class SharedPrefsManager
{

    public SharedPrefsManager()
    {
        PREFS_NS = "";
        mSharedPref = null;
        mSPEditor = null;
    }

    public static SharedPrefsManager getInstance()
    {
        com/realtech_inc/andproject/chinanet/io/SharedPrefsManager;
        JVM INSTR monitorenter ;
        SharedPrefsManager sharedprefsmanager;
        if(mInstance == null)
            mInstance = new SharedPrefsManager();
        sharedprefsmanager = mInstance;
        com/realtech_inc/andproject/chinanet/io/SharedPrefsManager;
        JVM INSTR monitorexit ;
        return sharedprefsmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public static SharedPrefsManager getInstance(String s)
    {
        com/realtech_inc/andproject/chinanet/io/SharedPrefsManager;
        JVM INSTR monitorenter ;
        if(mInstance != null)
            break MISSING_BLOCK_LABEL_49;
        mInstance = new SharedPrefsManager();
        if(s == null)
            break MISSING_BLOCK_LABEL_49;
        if(s.length() > 0 && mInstance.PREFS_NS.length() == 0)
            mInstance.PREFS_NS = s;
        s = mInstance;
        com/realtech_inc/andproject/chinanet/io/SharedPrefsManager;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public Boolean getData(String s, Boolean boolean1)
    {
        this;
        JVM INSTR monitorenter ;
        SharedPreferences sharedpreferences = mSharedPref;
        if(sharedpreferences == null) goto _L2; else goto _L1
_L1:
        sharedpreferences = null;
        boolean flag = mSharedPref.getBoolean(s, boolean1.booleanValue());
        s = Boolean.valueOf(flag);
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        DebugLog.e(TAG, (new StringBuilder()).append("Exception In SharedPreferences getBoolean(): ").append(s).toString());
        s = sharedpreferences;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L2:
        DebugLog.e(TAG, "getData(String key, Boolean value) Should Used After setContext(Context context)");
        s = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Integer getData(String s, Integer integer)
    {
        this;
        JVM INSTR monitorenter ;
        SharedPreferences sharedpreferences = mSharedPref;
        if(sharedpreferences == null) goto _L2; else goto _L1
_L1:
        sharedpreferences = null;
        int i = mSharedPref.getInt(s, integer.intValue());
        s = Integer.valueOf(i);
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        DebugLog.e(TAG, (new StringBuilder()).append("Exception In SharedPreferences getInt(): ").append(s).toString());
        s = sharedpreferences;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L2:
        DebugLog.e(TAG, "getData(String key, Integer value) Should Used After setContext(Context context)");
        s = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Long getData(String s, Long long1)
    {
        this;
        JVM INSTR monitorenter ;
        SharedPreferences sharedpreferences = mSharedPref;
        if(sharedpreferences == null) goto _L2; else goto _L1
_L1:
        sharedpreferences = null;
        long l = mSharedPref.getLong(s, long1.longValue());
        s = Long.valueOf(l);
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        DebugLog.e(TAG, (new StringBuilder()).append("Exception In SharedPreferences getLong(): ").append(s).toString());
        s = sharedpreferences;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L2:
        DebugLog.e(TAG, "getData(String key, Long value) Should Used After setContext(Context context)");
        s = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String getData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        SharedPreferences sharedpreferences = mSharedPref;
        if(sharedpreferences == null) goto _L2; else goto _L1
_L1:
        sharedpreferences = null;
        s = mSharedPref.getString(s, s1);
_L3:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        DebugLog.e(TAG, (new StringBuilder()).append("Exception In SharedPreferences getString(): ").append(s).toString());
        s = sharedpreferences;
          goto _L3
        s;
        throw s;
_L2:
        DebugLog.e(TAG, "getData(String key, String value) Should Used After setContext(Context context)");
        s = null;
          goto _L3
    }

    public void removeData(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if(mSPEditor == null)
            break MISSING_BLOCK_LABEL_78;
        mSPEditor.remove(s);
        mSPEditor.commit();
        DebugLog.d(TAG, (new StringBuilder()).append("Removed The Data: ").append(s).append(" -> ").append(mSharedPref.getString(s, "value is not exit")).toString());
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        DebugLog.e(TAG, "setData(String key, Long value) Should Used After setContext(Context context)");
          goto _L1
        s;
        throw s;
    }

    public void setContext(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if(PREFS_NS.length() != 0)
            break MISSING_BLOCK_LABEL_23;
        DebugLog.e(TAG, "SET SharedPreferences' NAME FIRST: setContent method Should Be Called After setNameSpace()");
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        mContext = context;
        mSharedPref = mContext.getSharedPreferences(PREFS_NS, 0);
        mSPEditor = mSharedPref.edit();
          goto _L1
        context;
        throw context;
    }

    public void setData(String s, Boolean boolean1)
    {
        this;
        JVM INSTR monitorenter ;
        if(mSPEditor == null)
            break MISSING_BLOCK_LABEL_84;
        mSPEditor.putBoolean(s, boolean1.booleanValue());
        mSPEditor.commit();
        DebugLog.d(TAG, (new StringBuilder()).append("Stored The Data: ").append(s).append(" -> ").append(mSharedPref.getBoolean(s, boolean1.booleanValue())).toString());
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        DebugLog.e(TAG, "setData(String key, Boolean value) Should Used After setContext(Context context)");
          goto _L1
        s;
        throw s;
    }

    public void setData(String s, Integer integer)
    {
        this;
        JVM INSTR monitorenter ;
        if(mSPEditor == null)
            break MISSING_BLOCK_LABEL_84;
        mSPEditor.putInt(s, integer.intValue());
        mSPEditor.commit();
        DebugLog.d(TAG, (new StringBuilder()).append("Stored The Data: ").append(s).append(" -> ").append(mSharedPref.getInt(s, integer.intValue())).toString());
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        DebugLog.e(TAG, "setData(String key, Integer value) Should Used After setContext(Context context)");
          goto _L1
        s;
        throw s;
    }

    public void setData(String s, Long long1)
    {
        this;
        JVM INSTR monitorenter ;
        if(mSPEditor == null)
            break MISSING_BLOCK_LABEL_84;
        mSPEditor.putLong(s, long1.longValue());
        mSPEditor.commit();
        DebugLog.d(TAG, (new StringBuilder()).append("Stored The Data: ").append(s).append(" -> ").append(mSharedPref.getLong(s, long1.longValue())).toString());
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        DebugLog.e(TAG, "setData(String key, Long value) Should Used After setContext(Context context)");
          goto _L1
        s;
        throw s;
    }

    public void setData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if(mSPEditor == null)
            break MISSING_BLOCK_LABEL_93;
        String s2;
        s2 = s1;
        if(s1 == null)
            break MISSING_BLOCK_LABEL_24;
        s2 = s1.replace("\0", "");
        mSPEditor.putString(s, s2);
        mSPEditor.commit();
        DebugLog.d(TAG, (new StringBuilder()).append("Stored The Data: ").append(s).append(" -> ").append(mSharedPref.getString(s, s2)).toString());
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        DebugLog.e(TAG, "setData(String key, String value) Should Used After setContext(Context context)");
          goto _L1
        s;
        throw s;
    }

    public void setNameSpace(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_39;
        if(s.length() <= 0 || PREFS_NS.length() != 0)
            break MISSING_BLOCK_LABEL_39;
        PREFS_NS = s;
        DebugLog.d(TAG, "Setting SharedPreferences' NameSpace Success!");
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        DebugLog.e(TAG, "Setting SharedPreferences' NameSpace fail!");
          goto _L1
        s;
        throw s;
    }

    private static final String TAG = com/realtech_inc/andproject/chinanet/io/SharedPrefsManager.getSimpleName();
    private static SharedPrefsManager mInstance = null;
    private String PREFS_NS;
    private Context mContext;
    private android.content.SharedPreferences.Editor mSPEditor;
    private SharedPreferences mSharedPref;

}
