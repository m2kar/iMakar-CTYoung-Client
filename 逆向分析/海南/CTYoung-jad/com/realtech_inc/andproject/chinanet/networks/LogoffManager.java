// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.networks;

import android.util.Log;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.realtech_inc.andproject.chinanet.networks.interfaces.HttpRequestListener;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.*;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.realtech_inc.andproject.chinanet.networks:
//            BaseNetworkAsyncTask

public class LogoffManager
{
    private class LogoffTask extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            as = new LinkedList();
            as.add(new BasicNameValuePair("uuid".toLowerCase(), uuid));
            as.add(new BasicNameValuePair("userip".toLowerCase(), userip));
            as.add(new BasicNameValuePair("acname".toLowerCase(), acName));
            return doHttpPost(logoffUrl, as);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            DebugLog.d(LogoffManager.TAG, (new StringBuilder()).append("RedirectHttpGetTask result : ").append(s).toString());
            Toast.makeText(aq.getContext(), (new StringBuilder()).append("logoff result:").append(s).toString(), 0).show();
            if(mListener == null)
                return;
            if(!isSuccess())
            {
                mListener.onResponseWithError(0xc3501);
                return;
            }
            if(s == null || s.length() == 0)
            {
                mListener.onResponseWithError(0xc3502);
                return;
            }
            Object obj = DocumentBuilderFactory.newInstance();
            try
            {
                obj = ((DocumentBuilderFactory) (obj)).newDocumentBuilder();
                InputSource inputsource = new InputSource();
                inputsource.setCharacterStream(new StringReader(s));
                s = ((DocumentBuilder) (obj)).parse(inputsource);
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogoffManager.TAG, (new StringBuilder()).append("ParserConfigurationException: ").append(s.toString()).toString(), s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogoffManager.TAG, (new StringBuilder()).append("SAXException: ").append(s.getMessage()).toString(), s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogoffManager.TAG, (new StringBuilder()).append("IOException: ").append(s.getMessage()).toString(), s);
                return;
            }
            if(s == null)
            {
                DebugLog.e(LogoffManager.TAG, "Document Parsed From The Responsed Result Of GetLogonUrlTask Is NULL!");
                return;
            }
            s = s.getElementsByTagName("ResponseCode");
            if(s.getLength() < 1)
            {
                DebugLog.e(LogoffManager.TAG, "Document Have No 'ResponseCode' ChildNode!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            if(!s.item(0).hasChildNodes() || "".equals(s.item(0).getNodeValue()))
            {
                DebugLog.e(LogoffManager.TAG, "ChildNode 'ResponseCode' Is Empty!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            s = s.item(0).getFirstChild();
            do
            {
label0:
                {
                    if(s != null)
                    {
                        if(3 != s.getNodeType())
                            break label0;
                        s = s.getNodeValue();
                        DebugLog.d(LogoffManager.TAG, (new StringBuilder()).append("ResponseCode: ").append(s).toString());
                        if("150".equals(s))
                        {
                            mListener.onResponseSuccess();
                            return;
                        }
                        if("255".equals(s))
                        {
                            mListener.onResponseWithError(0xc3503);
                            return;
                        }
                        mListener.onResponseWithError(0xf423f);
                    }
                    mListener.onResponseWithError(0xf423f);
                    return;
                }
                s = s.getNextSibling();
            } while(true);
        }

        final LogoffManager this$0;

        private LogoffTask()
        {
            this$0 = LogoffManager.this;
            BaseNetworkAsyncTask();
        }

    }

    private class LogoffTaskForUpdate extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            as = new LinkedList();
            as.add(new BasicNameValuePair("uuid".toLowerCase(), uuid));
            as.add(new BasicNameValuePair("userip".toLowerCase(), userip));
            return doHttpPost(logoffUrl, as);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            DebugLog.d(LogoffManager.TAG, (new StringBuilder()).append("RedirectHttpGetTask result : ").append(s).toString());
        }

        final LogoffManager this$0;

        private LogoffTaskForUpdate()
        {
            this$0 = LogoffManager.this;
            BaseNetworkAsyncTask();
        }

    }


    private LogoffManager()
    {
    }

    public static LogoffManager getInstance()
    {
        if(mInstance == null)
            mInstance = new LogoffManager();
        return mInstance;
    }

    public void checkNet()
    {
        AjaxCallback ajaxcallback = new AjaxCallback();
        ajaxcallback.timeout(3000);
        ((AjaxCallback)((AjaxCallback)ajaxcallback.url("http://www.baidu.com/s?wd=1&ch=4&tn=98067068_dg")).type(java/lang/String)).weakHandler(this, "checkNetCallback");
        aq.ajax(ajaxcallback);
    }

    public void checkNetCallback(String s, String s1, AjaxStatus ajaxstatus)
    {
        Log.v(TAG, "\u7F51\u7EDC\u8FDE\u63A5\u5DF2\u65AD\u5F00\uFF0C\u9000\u51FA\u767B\u5F55");
        if(s1 == null)
            mListener.onResponseWithError(0xc35cc);
    }

    public void setAq(AQuery aquery)
    {
        aq = aquery;
    }

    public void setListener(HttpRequestListener httprequestlistener)
    {
        mListener = httprequestlistener;
    }

    public void startLogoff(String s, String s1, String s2, String s3)
    {
        DebugLog.d(TAG, (new StringBuilder()).append("LogoffUrl: ").append(s).append("\r\nUuid: ").append(s1).append("\r\nUserIp: ").append(s2).toString());
        logoffUrl = s;
        uuid = s1;
        userip = s2;
        acName = s3;
        (new LogoffTask()).execute(new String[0]);
    }

    public void startLogoffForUpdate(String s, String s1, String s2)
    {
        DebugLog.d(TAG, (new StringBuilder()).append("LogoffUrl: ").append(s).append("\r\nUuid: ").append(s1).append("\r\nUserIp: ").append(s2).toString());
        logoffUrl = s;
        uuid = s1;
        userip = s2;
        (new LogoffTaskForUpdate()).execute(new String[0]);
    }

    private static final String TAG = com/realtech_inc/andproject/chinanet/networks/LogoffManager.getSimpleName();
    private static LogoffManager mInstance;
    private String acName;
    private AQuery aq;
    private String logoffUrl;
    private HttpRequestListener mListener;
    private String userip;
    private String uuid;








}
