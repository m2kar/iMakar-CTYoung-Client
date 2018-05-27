// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.networks;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.androidquery.AQuery;
import com.realtech_inc.andproject.chinanet.constant.Constant;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;
import com.realtech_inc.andproject.chinanet.networks.interfaces.HttpRequestListener;
import com.realtech_inc.andproject.chinanet.utils.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import javax.xml.parsers.*;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.realtech_inc.andproject.chinanet.networks:
//            BaseNetworkAsyncTask

public class LogonManager
{
    class DevInfoRegisterTask extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            HashMap hashmap = new HashMap();
            hashmap.put("osType", "Android");
            hashmap.put("devType", Build.MANUFACTURER);
            hashmap.put("devModel", Build.MODEL);
            hashmap.put("username", mLastUserName);
            hashmap.put("osVersion", android.os.Build.VERSION.RELEASE);
            hashmap.put("userIp", mLastUserIp);
            hashmap.put("imei", LogonManager.SPM.getData("IMEI", ""));
            hashmap.put("mac", ((WifiManager)aq.getContext().getSystemService("wifi")).getConnectionInfo().getMacAddress());
            as = ((String []) (SimUtility.getSimInfo(aq.getContext())));
            if(as != null)
            {
                if(as instanceof MultiSim)
                    as = (new StringBuilder()).append("\u53CC\u5361-").append(((MultiSim)as).getProvidersName1()).append("-").append(((MultiSim)as).getProvidersName2()).toString();
                else
                    as = ((SingleSim)as).getProvidersName();
                hashmap.put("operator", as);
            }
            hashmap.put("phone1", "");
            hashmap.put("phone2", "");
            return doWSPost("http://112.67.253.74:8080/services/DevInfoRegisterService?wsdl", "http://service.longhz.com/", "devInfoRegister", hashmap);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
        }

        final LogonManager this$0;

        DevInfoRegisterTask()
        {
            this$0 = LogonManager.this;
            BaseNetworkAsyncTask();
        }
    }

    class GetPortalUrlTask extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("Start HTTP GET Request With URL: '").append(url).toString());
            return doHttpGet(url);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            Object obj;
            LogonTask logontask;
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("GetLogonUrlTask result: ").append(s).toString());
            if(!isSuccess())
                if(isCancelled())
                    DebugLog.e(LogonManager.TAG, "GetLogonUrlTask Request Canceled Because No Params!");
                else
                    DebugLog.e(LogonManager.TAG, "GetLogonUrlTask Request Failed!");
            if(s == null || s.length() == 0)
            {
                mListener.onResponseWithError(0xc3502);
                return;
            }
            if(s.contains("baidu") && !s.contains("userurl=http://www.baidu.com"))
                mListener.onResponseWithError(0xc3504);
            if(s.contains("location.href"))
            {
                location = s.substring(s.indexOf("location.href=\""));
                location = location.replace("location.href=\"", "");
                location = location.substring(0, location.indexOf("\""));
                (new GetPortalUrlTask()).execute(new String[0]);
                return;
            }
            obj = DocumentBuilderFactory.newInstance();
            try
            {
                obj = ((DocumentBuilderFactory) (obj)).newDocumentBuilder();
                InputSource inputsource = new InputSource();
                inputsource.setCharacterStream(new StringReader(s));
                obj = ((DocumentBuilder) (obj)).parse(inputsource);
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogonManager.TAG, (new StringBuilder()).append("ParserConfigurationException: ").append(s.toString()).toString(), s);
                mListener.onResponseWithError(0xf423f);
                return;
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogonManager.TAG, (new StringBuilder()).append("SAXException: ").append(s.getMessage()).toString(), s);
                mListener.onResponseWithError(0xf423f);
                return;
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogonManager.TAG, (new StringBuilder()).append("IOException: ").append(s.getMessage()).toString(), s);
                mListener.onResponseWithError(0xf423f);
                return;
            }
            if(obj == null)
            {
                DebugLog.e(LogonManager.TAG, "Document Parsed From The Responsed Result Of GetLogonUrlTask Is NULL!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            s = ((Document) (obj)).getElementsByTagName("LoginURL");
            if(s.getLength() < 1)
            {
                DebugLog.e(LogonManager.TAG, "Document Have No 'LoginURL' ChildNode!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            if(!s.item(0).hasChildNodes() || "".equals(s.item(0).getNodeValue()))
            {
                DebugLog.e(LogonManager.TAG, "ChildNode 'LoginURL' Is Empty!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            s = s.item(0).getFirstChild();
label0:
            do
            {
label1:
                {
                    if(s != null)
                    {
                        if(3 != s.getNodeType())
                            break label1;
                        DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("LoginURL: ").append(s.getNodeValue()).toString());
                        Constant.setLogonUrl(s.getNodeValue());
                    }
                    if(com.realtech_inc.andproject.chinanet.constant.Constant.RunMode.REALTECH.equals(Constant.runMode))
                    {
                        (new LogonTask()).execute(new String[] {
                            Constant.URL_LOGON
                        });
                        return;
                    }
                    break label0;
                }
                s = s.getNextSibling();
            } while(true);
            logontask = new LogonTask();
            if(!com.realtech_inc.andproject.chinanet.constant.Constant.RunMode.HUAWEI.equals(Constant.runMode) && !com.realtech_inc.andproject.chinanet.constant.Constant.RunMode.ONLINE.equals(Constant.runMode)) goto _L2; else goto _L1
_L1:
            s = ((Document) (obj)).getElementsByTagName("UserIp");
            if(s.getLength() < 1)
            {
                DebugLog.e(LogonManager.TAG, "Document Have No 'UserIp' ChildNode!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            if(!s.item(0).hasChildNodes() || "".equals(s.item(0).getNodeValue()))
            {
                DebugLog.e(LogonManager.TAG, "ChildNode 'UserIp' Is Empty!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            s = s.item(0).getFirstChild();
label2:
            do
            {
label3:
                {
                    if(s != null)
                    {
                        if(3 != s.getNodeType())
                            break label3;
                        if(!intranetip.equals(s.getNodeValue()))
                        {
                            mListener.onResponseWithError(0xc3503);
                            return;
                        }
                        DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("UserIp: ").append(s.getNodeValue()).toString());
                        logontask.setUserip(s.getNodeValue());
                    }
                    s = ((Document) (obj)).getElementsByTagName("Uuid");
                    if(s.getLength() < 1)
                    {
                        DebugLog.e(LogonManager.TAG, "Document Have No 'Uuid' ChildNode!");
                        mListener.onResponseWithError(0xf423f);
                        return;
                    }
                    break label2;
                }
                s = s.getNextSibling();
            } while(true);
            if(!s.item(0).hasChildNodes() || "".equals(s.item(0).getNodeValue()))
            {
                DebugLog.e(LogonManager.TAG, "ChildNode 'Uuid' Is Empty!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            s = s.item(0).getFirstChild();
label4:
            do
            {
label5:
                {
                    if(s != null)
                    {
                        if(3 != s.getNodeType())
                            break label5;
                        DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("Uuid: ").append(s.getNodeValue()).toString());
                        logontask.setUuid(s.getNodeValue());
                    }
                    s = ((Document) (obj)).getElementsByTagName("AcName");
                    if(s.getLength() < 1)
                    {
                        DebugLog.e(LogonManager.TAG, "Document Have No 'AcName' ChildNode!");
                        mListener.onResponseWithError(0xf423f);
                        return;
                    }
                    break label4;
                }
                s = s.getNextSibling();
            } while(true);
            if(!s.item(0).hasChildNodes() || "".equals(s.item(0).getNodeValue()))
            {
                DebugLog.e(LogonManager.TAG, "ChildNode 'AcName' Is Empty!");
                mListener.onResponseWithError(0xf423f);
                return;
            }
            s = s.item(0).getFirstChild();
_L7:
            if(s == null) goto _L2; else goto _L3
_L3:
            if(3 != s.getNodeType()) goto _L5; else goto _L4
_L4:
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("AcName: ").append(s.getNodeValue()).toString());
            logontask.setAcName(s.getNodeValue());
            mAcName = s.getNodeValue();
_L2:
            logontask.setUsername(mLastUserName);
            logontask.setPassword(mLastPassWord);
            logontask.setRatingtype(checkType());
            logontask.execute(new String[] {
                Constant.URL_LOGON
            });
            return;
_L5:
            s = s.getNextSibling();
            if(true) goto _L7; else goto _L6
_L6:
        }

        protected void onPreExecute()
        {
            if(location != null && !"".equals(location))
            {
                url = location;
                return;
            } else
            {
                url = Constant.URL_GETPORTAL;
                return;
            }
        }

        final LogonManager this$0;
        private String url;

        GetPortalUrlTask()
        {
            this$0 = LogonManager.this;
            BaseNetworkAsyncTask();
        }
    }

    class LogonTask extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(new BasicNameValuePair("uuid", uuid));
            arraylist.add(new BasicNameValuePair("acname", acName));
            arraylist.add(new BasicNameValuePair("userip", userip));
            arraylist.add(new BasicNameValuePair("username", username));
            arraylist.add(new BasicNameValuePair("password", password));
            arraylist.add(new BasicNameValuePair("ratingtype", ratingtype));
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("Start HTTP POST Request With URL: '").append(as[0].toString()).append("' And Params: ").append(arraylist.toString()).toString());
            return doHttpPost(as[0].toString(), arraylist);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            Object obj;
            Object obj1;
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("LogonTask result: ").append(s).toString());
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
            String s1 = "73";
            String s2 = "";
            obj = "";
            String s6 = "";
            obj1 = DocumentBuilderFactory.newInstance();
            String s3;
            String s4;
            String s5;
            Document document;
            try
            {
                obj1 = ((DocumentBuilderFactory) (obj1)).newDocumentBuilder();
                InputSource inputsource = new InputSource();
                inputsource.setCharacterStream(new StringReader(s));
                document = ((DocumentBuilder) (obj1)).parse(inputsource);
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogonManager.TAG, (new StringBuilder()).append("ParserConfigurationException: ").append(s.toString()).toString(), s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogonManager.TAG, (new StringBuilder()).append("SAXException: ").append(s.getMessage()).toString(), s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                DebugLog.e(LogonManager.TAG, (new StringBuilder()).append("IOException: ").append(s.getMessage()).toString(), s);
                return;
            }
            s3 = s2;
            s4 = s1;
            s5 = s6;
            obj1 = obj;
            if(document == null) goto _L2; else goto _L1
_L1:
            obj1 = document.getElementsByTagName("ResponseCode");
            s = s1;
            if(((NodeList) (obj1)).getLength() <= 0) goto _L4; else goto _L3
_L3:
            s = s1;
            if(!((NodeList) (obj1)).item(0).hasChildNodes()) goto _L4; else goto _L5
_L5:
            s = s1;
            if("".equals(((NodeList) (obj1)).item(0).getNodeValue())) goto _L4; else goto _L6
_L6:
            obj1 = ((NodeList) (obj1)).item(0).getFirstChild();
_L27:
            s = s1;
            if(obj1 == null) goto _L4; else goto _L7
_L7:
            if(3 != ((Node) (obj1)).getNodeType()) goto _L9; else goto _L8
_L8:
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("ResponseCode: ").append(((Node) (obj1)).getNodeValue()).toString());
            s = ((Node) (obj1)).getNodeValue();
_L4:
            obj1 = document.getElementsByTagName("LogoffURL");
            s1 = s2;
            if(((NodeList) (obj1)).getLength() <= 0) goto _L11; else goto _L10
_L10:
            s1 = s2;
            if(!((NodeList) (obj1)).item(0).hasChildNodes()) goto _L11; else goto _L12
_L12:
            s1 = s2;
            if("".equals(((NodeList) (obj1)).item(0).getNodeValue())) goto _L11; else goto _L13
_L13:
            obj1 = ((NodeList) (obj1)).item(0).getFirstChild();
_L28:
            s1 = s2;
            if(obj1 == null) goto _L11; else goto _L14
_L14:
            if(3 != ((Node) (obj1)).getNodeType()) goto _L16; else goto _L15
_L15:
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("LogoffURL: ").append(((Node) (obj1)).getNodeValue()).toString());
            s1 = ((Node) (obj1)).getNodeValue();
_L11:
            obj1 = document.getElementsByTagName("Uuid");
            s2 = ((String) (obj));
            if(((NodeList) (obj1)).getLength() <= 0) goto _L18; else goto _L17
_L17:
            s2 = ((String) (obj));
            if(!((NodeList) (obj1)).item(0).hasChildNodes()) goto _L18; else goto _L19
_L19:
            s2 = ((String) (obj));
            if("".equals(((NodeList) (obj1)).item(0).getNodeValue())) goto _L18; else goto _L20
_L20:
            obj1 = ((NodeList) (obj1)).item(0).getFirstChild();
_L29:
            s2 = ((String) (obj));
            if(obj1 == null) goto _L18; else goto _L21
_L21:
            if(3 != ((Node) (obj1)).getNodeType()) goto _L23; else goto _L22
_L22:
            DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("Uuid: ").append(((Node) (obj1)).getNodeValue()).toString());
            s2 = ((Node) (obj1)).getNodeValue();
_L18:
            obj = document.getElementsByTagName("UserIp");
            s3 = s1;
            s4 = s;
            s5 = s6;
            obj1 = s2;
            if(((NodeList) (obj)).getLength() <= 0) goto _L2; else goto _L24
_L24:
            s3 = s1;
            s4 = s;
            s5 = s6;
            obj1 = s2;
            if(!((NodeList) (obj)).item(0).hasChildNodes()) goto _L2; else goto _L25
_L25:
            s3 = s1;
            s4 = s;
            s5 = s6;
            obj1 = s2;
            if("".equals(((NodeList) (obj)).item(0).getNodeValue())) goto _L2; else goto _L26
_L26:
            obj = ((NodeList) (obj)).item(0).getFirstChild();
_L30:
            s3 = s1;
            s4 = s;
            s5 = s6;
            obj1 = s2;
            if(obj != null)
            {
                if(3 != ((Node) (obj)).getNodeType())
                    break MISSING_BLOCK_LABEL_896;
                DebugLog.d(LogonManager.TAG, (new StringBuilder()).append("UserIp: ").append(((Node) (obj)).getNodeValue()).toString());
                s5 = ((Node) (obj)).getNodeValue();
                obj1 = s2;
                s4 = s;
                s3 = s1;
            }
_L2:
            onLogonFinish(s4, s3, ((String) (obj1)), s5);
            return;
_L9:
            obj1 = ((Node) (obj1)).getNextSibling();
              goto _L27
_L16:
            obj1 = ((Node) (obj1)).getNextSibling();
              goto _L28
_L23:
            obj1 = ((Node) (obj1)).getNextSibling();
              goto _L29
            obj = ((Node) (obj)).getNextSibling();
              goto _L30
        }

        public void setAcName(String s)
        {
            acName = s;
        }

        public void setPassword(String s)
        {
            password = s;
        }

        public void setRatingtype(String s)
        {
            ratingtype = s;
        }

        public void setUserip(String s)
        {
            userip = s;
        }

        public void setUsername(String s)
        {
            username = s;
        }

        public void setUuid(String s)
        {
            uuid = s;
        }

        private String acName;
        private String password;
        private String ratingtype;
        final LogonManager this$0;
        private String userip;
        private String username;
        private String uuid;

        LogonTask()
        {
            this$0 = LogonManager.this;
            BaseNetworkAsyncTask();
        }
    }

    class UserRegisterTask extends BaseNetworkAsyncTask
    {

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            as = new HashMap();
            as.put("osInfo", "Android");
            as.put("clientVersion", version);
            as.put("userName", mLastUserName);
            return doWSPost("http://count.singlenet.cn:8080/services/UserRegisterService?wsdl", "http://service.longhz.com/", "userRegister", as);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
        }

        final LogonManager this$0;

        UserRegisterTask()
        {
            this$0 = LogonManager.this;
            BaseNetworkAsyncTask();
        }
    }


    private LogonManager()
    {
    }

    private String checkType()
    {
        Object obj = SimUtility.getSimInfo(aq.getContext());
        if(obj != null)
        {
            boolean flag = false;
            if(obj instanceof MultiSim)
            {
                if(((MultiSim)obj).getProvidersName1().equals("\u4E2D\u56FD\u7535\u4FE1") || ((MultiSim)obj).getProvidersName2().equals("\u4E2D\u56FD\u7535\u4FE1"))
                    flag = true;
            } else
            if(((SingleSim)obj).getProvidersName().equals("\u4E2D\u56FD\u7535\u4FE1"))
                flag = true;
            if(flag)
                return "1";
            else
                return "0";
        } else
        {
            return "0";
        }
    }

    public static LogonManager getInstance()
    {
        if(mInstance == null)
            mInstance = new LogonManager();
        return mInstance;
    }

    private void onLogonFinish(String s, String s1, String s2, String s3)
    {
        DebugLog.i(TAG, (new StringBuilder()).append("onLogonFinish\nresCode = ").append(s).append("\n").append("logoffUrl = ").append(s1).append("\n").append("uuid = ").append(s2).append("\n").toString());
        if("200".equals(s))
        {
            mLastLogoffUrl = s1;
            Constant.setLogoffUrl(mLastLogoffUrl);
            SPM.setData("LastLogoffUrl", mLastLogoffUrl);
            mLastLogoffUuid = s2;
            SPM.setData("LastLogoffUuid", mLastLogoffUuid);
            mLastUserIp = s3;
            SPM.setData("LastLogoffUserIp", mLastUserIp);
            SPM.setData("LastLogoffAcName", mAcName);
            mListener.onResponseSuccess();
            (new UserRegisterTask()).execute(new String[0]);
            (new DevInfoRegisterTask()).execute(new String[0]);
            return;
        }
        if("71".equals(s))
        {
            mListener.onResponseWithError(0xc35c8);
            return;
        }
        if("72".equals(s))
        {
            mListener.onResponseWithError(0xc3504);
            return;
        }
        if("73".equals(s))
        {
            mListener.onResponseWithError(0xc3505);
            return;
        }
        if("74".equals(s))
        {
            mListener.onResponseWithError(0xc3503);
            return;
        } else
        {
            mListener.onResponseWithError(Integer.valueOf(s).intValue());
            return;
        }
    }

    public String getVersion()
    {
        return version;
    }

    public void setAq(AQuery aquery)
    {
        aq = aquery;
    }

    public void setListener(HttpRequestListener httprequestlistener)
    {
        mListener = httprequestlistener;
    }

    public void setVersion(String s)
    {
        version = s;
    }

    public void startLogon(String s, String s1, String s2)
    {
        DebugLog.d(TAG, (new StringBuilder()).append("Username: ").append(s).append("\r\nPassword: ").append(s1).toString());
        mLastUserName = s.trim();
        mLastPassWord = s1.trim();
        intranetip = s2;
        (new GetPortalUrlTask()).execute(new String[0]);
    }

    private static final SharedPrefsManager SPM = SharedPrefsManager.getInstance();
    private static final String TAG = com/realtech_inc/andproject/chinanet/networks/LogonManager.getSimpleName();
    private static LogonManager mInstance;
    private AQuery aq;
    private String intranetip;
    private String location;
    private String mAcName;
    private String mLastLogoffUrl;
    private String mLastLogoffUuid;
    private String mLastPassWord;
    private String mLastUserIp;
    private String mLastUserName;
    private HttpRequestListener mListener;
    private String version;




/*
    static String access$002(LogonManager logonmanager, String s)
    {
        logonmanager.location = s;
        return s;
    }

*/








/*
    static String access$402(LogonManager logonmanager, String s)
    {
        logonmanager.mAcName = s;
        return s;
    }

*/





}
