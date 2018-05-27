// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.auth;

import android.accounts.*;
import android.app.Activity;
import android.content.*;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.androidquery.AQuery;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import java.io.IOException;
import org.apache.http.HttpRequest;

// Referenced classes of package com.androidquery.auth:
//            AccountHandle

public class GoogleHandle extends AccountHandle
    implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnCancelListener
{
    private class Task extends AsyncTask
    {

        protected transient Bundle doInBackground(String as[])
        {
            as = am.getAuthToken(acc, type, null, act, null, null);
            try
            {
                as = (Bundle)as.getResult();
            }
            // Misplaced declaration of an exception variable
            catch(String as[])
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch(String as[])
            {
                AQUtility.debug(as);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch(String as[])
            {
                AQUtility.debug(as);
                return null;
            }
            return as;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onPostExecute(Bundle bundle)
        {
            if(bundle != null && bundle.containsKey("authtoken"))
            {
                token = bundle.getString("authtoken");
                success(act);
                return;
            } else
            {
                failure(act, -102, "rejected");
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Bundle)obj);
        }

        final GoogleHandle this$0;

        private Task()
        {
            this$0 = GoogleHandle.this;
            super();
        }

    }


    public GoogleHandle(Activity activity, String s, String s1)
    {
        String s2 = s1;
        if("aq.account".equals(s1))
            s2 = getActiveAccount(activity);
        act = activity;
        type = s.substring(2);
        email = s2;
        am = AccountManager.get(activity);
    }

    private void accountDialog()
    {
        Object obj = new android.app.AlertDialog.Builder(act);
        accs = am.getAccountsByType("com.google");
        int j = accs.length;
        if(j == 1)
        {
            auth(accs[0]);
            return;
        }
        String as[] = new String[j];
        for(int i = 0; i < j; i++)
            as[i] = accs[i].name;

        ((android.app.AlertDialog.Builder) (obj)).setItems(as, this);
        ((android.app.AlertDialog.Builder) (obj)).setOnCancelListener(this);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        (new AQuery(act)).show(((android.app.Dialog) (obj)));
    }

    private void auth(Account account)
    {
        acc = account;
        (new Task()).execute(new String[0]);
    }

    public static String getActiveAccount(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("aq.account", null);
    }

    public static void setActiveAccount(Context context, String s)
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("aq.account", s).commit();
    }

    public void applyToken(AbstractAjaxCallback abstractajaxcallback, HttpRequest httprequest)
    {
        httprequest.addHeader("Authorization", (new StringBuilder()).append("GoogleLogin auth=").append(token).toString());
    }

    protected void auth()
    {
        if(email == null)
        {
            accountDialog();
        } else
        {
            Account aaccount[] = am.getAccountsByType("com.google");
            int i = 0;
            while(i < aaccount.length) 
            {
                Account account = aaccount[i];
                if(email.equals(account.name))
                {
                    auth(account);
                    return;
                }
                i++;
            }
        }
    }

    public boolean authenticated()
    {
        return token != null;
    }

    public boolean expired(AbstractAjaxCallback abstractajaxcallback, AjaxStatus ajaxstatus)
    {
        int i = ajaxstatus.getCode();
        return i == 401 || i == 403;
    }

    public String getCacheUrl(String s)
    {
        return (new StringBuilder()).append(s).append("#").append(token).toString();
    }

    public String getType()
    {
        return type;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        failure(act, -102, "cancel");
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = accs[i];
        AQUtility.debug("acc", ((Account) (dialoginterface)).name);
        setActiveAccount(act, ((Account) (dialoginterface)).name);
        auth(dialoginterface);
    }

    public boolean reauth(AbstractAjaxCallback abstractajaxcallback)
    {
        am.invalidateAuthToken(acc.type, token);
        try
        {
            token = am.blockingGetAuthToken(acc, type, true);
            AQUtility.debug("re token", token);
        }
        // Misplaced declaration of an exception variable
        catch(AbstractAjaxCallback abstractajaxcallback)
        {
            AQUtility.debug(abstractajaxcallback);
            token = null;
        }
        return token != null;
    }

    private Account acc;
    private Account accs[];
    private Activity act;
    private AccountManager am;
    private String email;
    private String token;
    private String type;






/*
    static String access$502(GoogleHandle googlehandle, String s)
    {
        googlehandle.token = s;
        return s;
    }

*/
}
