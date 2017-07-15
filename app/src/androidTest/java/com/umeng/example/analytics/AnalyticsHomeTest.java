package com.umeng.example.analytics;


import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.*;
import com.umeng.example.MainActivity;
import com.umeng.example.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.security.MessageDigest;

/**
 * Created by friends on 2017/7/10.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AnalyticsHomeTest {
//    public AnalyticsHomeTest(Activity context){
//        mActivity =context;
//    }
//    public AnalyticsHomeTest(){}
    @Rule
    public ActivityTestRule<MainActivity> mTasksActivityTestRule =new ActivityTestRule<MainActivity>(MainActivity.class){
        @Override
        protected void afterActivityLaunched() {
            // empty by default
            mActivity = mTasksActivityTestRule.getActivity();
        }
    } ;
    public static String md5(final String s) {
        if (s == null) {
            return null;
        }
        try {
            final byte[] bytes = s.getBytes();
            final MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bytes);
            final byte[] digest = instance.digest();
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; ++i) {
                sb.append(String.format("%02X", digest[i]));
            }
            return sb.toString();
        }
        catch (Exception ex) {
            return s.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }
    private String a(final Context context) {
        final StringBuffer sb = new StringBuffer();
        sb.append("Android").append("/").append("6.1.1").append(" ");
        try {
            final StringBuffer sb2 = new StringBuffer();
            sb2.append(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString());
            sb2.append("/");
            String b="";
            try {
                b= context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
            catch (PackageManager.NameNotFoundException ex) {

            }
            sb2.append(b);
            sb2.append(" ");
            sb2.append(Build.MODEL);
            sb2.append("/");
            sb2.append(Build.VERSION.RELEASE);
            sb2.append(" ");
            //sb2.append(a(AnalyticsConfig.getAppkey(context)));
            sb2.append(md5(appKey));//
            sb.append(URLEncoder.encode(sb2.toString(), "UTF-8"));
        }
        catch (Throwable t) {}
        return sb.toString();
    }
    private boolean c() {
        PackageManager var1 = this.mActivity.getPackageManager();
        if(var1.checkPermission("android.permission.ACCESS_NETWORK_STATE", this.mActivity.getPackageName()) != 0) {
            return false;
        } else {
            try {
                ConnectivityManager var2 = (ConnectivityManager)this.mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);//"connectivity");
                if(!bv.a(this.mActivity, "android.permission.ACCESS_NETWORK_STATE")) {
                    return false;
                }

                NetworkInfo var3 = var2.getActiveNetworkInfo();
                if(var3 != null && var3.getType() != 1) {
                    String var4 = var3.getExtraInfo();
                    if(var4 != null && (var4.equals("cmwap") || var4.equals("3gwap") || var4.equals("uniwap"))) {
                        return true;
                    }
                }
            } catch (Throwable var5) {
                ;
            }

            return false;
        }
    }

    private Activity mActivity;
    String requestUrl[] = {"http://alog.umeng.com/app_logs","http://alog.umengcloud.com/app_logs"};
    String appKey = "596087883eae2574b10013a3";
    private byte[] requestUrl(final byte[] array, final String url) {
        HttpURLConnection httpURLConnection = null;
        try {
            be e =new be(mActivity);//记录时间， 与下面的 e.b()对应 记录发请求 和 响应的 间隔时间
            if (e != null) {
                e.a();
            }
            if (c()) {
                httpURLConnection = (HttpURLConnection) new URL(url).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
            }else{
                httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
            }
            httpURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
            httpURLConnection.setRequestProperty("X-Umeng-Sdk", a(mActivity));
            httpURLConnection.setRequestProperty("Msg-Type", "envelope/json");
            httpURLConnection.setRequestProperty("Content-Type", "envelope/json");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            if (Build.VERSION.SDK_INT < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            final OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(array);
            outputStream.flush();
            outputStream.close();
            if (e != null) {
                e.b();
            }
            final int responseCode = httpURLConnection.getResponseCode();
            final String headerField = httpURLConnection.getHeaderField("Content-Type");
            boolean b = false;
            if (!TextUtils.isEmpty((CharSequence)headerField) && headerField.equalsIgnoreCase("application/thrift")) {
                b = true;
            }
            if (responseCode == 200 && b) {
                by.c(" Send message to " + url);
                final InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    return bw.b(inputStream);
                }
                finally {
                    bw.c(inputStream);//酷似 close inputstream的操作
                }
            }
        }
        catch (Throwable t) {
            by.e("IOException,Failed to send message.", t);
            return null;
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return null;
    }
    private void b() {
        String var1 = af.a(mActivity).b().d("");
        String var2 = af.a(mActivity).b().c("");
        if(!TextUtils.isEmpty(var1)) {
            com.umeng.analytics.a.f = bt.b(var1);
        }

        if(!TextUtils.isEmpty(var2)) {
            com.umeng.analytics.a.g = bt.b(var2);
        }

        com.umeng.analytics.a.h = new String[]{com.umeng.analytics.a.f, com.umeng.analytics.a.g};
        int var3 = bg.a(mActivity).b();
        if(var3 != -1) {
            if(var3 == 0) {
                com.umeng.analytics.a.h = new String[]{"http://alog.umeng.com/app_logs", "http://alog.umengcloud.com/app_logs"};
            } else if(var3 == 1) {
                com.umeng.analytics.a.h = new String[]{"http://alog.umengcloud.com/app_logs", "http://alog.umeng.com/app_logs"};
            }
        }

    }

    @Test
    public void requestUmeng() throws Exception {
        //bc 中 c()发包方法
        String content = mActivity.getResources().getText(R.string.body_content).toString();
        //接下来 解析 content的内容
        String content2="        {\"body\":{\"userlevel\":\"1\"},\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwuMB3ByZXRpbWUYDTE0OTk4NTAxMzYwNTQW7OfG4KZXGCg4NmJiNjQwNjc3ZmI1ODg2ZWIwNmEy\\nOTE0ODY5NWNmZDg5NWUyZDY1AAZsYXRlbnQYATMW\\/OCw1qRXGCg0ZTdhMGExNWE3MmVkMzkxOGUy\\nZDc5MjhiM2E4YTMzOGQ1YjJmNjU0ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW\\/OCw1qRXGCg0\\nZTdhMGExNTBjZTc2OTUyYzY4OGVmY2VmMWFkYjRmZTc4YzAyOTI0AA9pbnN0YWxsX2NoYW5uZWwY\\nBVVtZW5nFvzgsNakVxgoNGU3YTBhMTUwODUwYWRjM2FjYTIyMzhmOTg3NzFmYWM0NDRkMGUyYwAL\\nYXBwX3ZlcnNpb24YAzEuMBbs58bgplcYKDg2YmI2NDA2OTAzYzIyN2NjMWMyNTNiNzVkNzQ0NDdj\\nZWEwNGQ0ODMAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzA6MzQW\\/OCw1qRXGCg0\\nZTdhMGExNTgxNzFjNGUxYWYzZDBkNGM4M2NjMTZhNzE3OGNjZTM5AApvc192ZXJzaW9uGAU0LjQu\\nMhbs58bgplcYKDg2YmI2NDA2OTRiNzc3NmY4NmJiMzFkNGU0NzU0Y2ZhNTU4N2YxMWQAAXYYBTUt\\nNS01FuznxuCmVxgoODZiYjY0MDZmNjEzZDRkNWU4NmI5OThmOTZmYWU3YzQzYjBkM2VlNQAGaml0\\ndGVyGAExFuznxuCmVxgoODZiYjY0MDZkNmIxNmQzZTNlMTJhNTRjOGY4MzViOTBkY2EyNTE4NQAH\\nY2hhbm5lbBgFVW1lbmcW7OfG4KZXGCg4NmJiNjQwNmE1ZmI1ZTBjOWQwMGNhZjE4YTgwNDUyYmZk\\nMGVmYjliAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFuznxuCmVxgo\\nODZiYjY0MDZlMzFiN2JjYTBlZjA5NGY1NTYxOTVhZjRmMjc5NmZhZgAVAhggYjQ2Njg2N2M0NGYy\\nMGFiYWM2MmUyMmU5ZWFmYzU4NTAA\\n\",\"req_time\":49,\"carrier\":\"Android\",\"successful_requests\":15,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwSMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxbe5piaolcVAgAFdXRkaWQYGFdWeVVQem40\\nWFZBREFKd2NsakM3bHhURBbc5piaolcVAgAFaWRtZDUYHjUyODQ0N2Y0ZmZiNGU0ODI0YTJmZDFk\\nMWYwY2Q2Mhbo5ZiaolcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFuzlmJqiVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}\n";
        content=content2;
        //对于 imprint 方面的内容可能是关键
        //Imprint(property:{pretime=ImprintValue(value:1499764532416, ts:1499764532416, guid:b0c682007f19211d053be67189b0d1f1eb3df131), latent=ImprintValue(value:3, ts:1499571034174, guid:4e7a0a15a72ed3918e2d7928b3a8a338d5b2f654), install_app_version=ImprintValue(value:1.0, ts:1499571034174, guid:4e7a0a150ce76952c688efcef1adb4fe78c02924), install_channel=ImprintValue(value:Umeng, ts:1499571034174, guid:4e7a0a150850adc3aca2238f98771fac444d0e2c), app_version=ImprintValue(value:1.0, ts:1499764532416, guid:b0c68200fb29ba4037b54b76b719e684a9320d71), install_datetime=ImprintValue(value:2017-07-09 11:30:34, ts:1499571034174, guid:4e7a0a158171c4e1af3d0d4c83cc16a7178cce39), os_version=ImprintValue(value:4.4.2, ts:1499764532416, guid:b0c68200afb34b8bd256abf9b1d8ff0d482b1d9e), v=ImprintValue(value:5-5-5, ts:1499764532416, guid:b0c6820086a4ed7fcd4869dcad26675994d1ff8e), jitter=ImprintValue(value:1, ts:1499764532416, guid:b0c68200c58298d4fe221a29ff0a2765ca3be0e1), channel=ImprintValue(value:Umeng, ts:1499764532416, guid:b0c6820073c0dd68082f9252dec8a4cbf7b1b3f3), umid=ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1499764532416, guid:b0c68200d9961f3096fa0a708301e3b4cc74293b)}, version:1, checksum:c6209d767b41176e150f4f89ed1b2b6c)
        bn var18= af.a(mActivity).a();


        aa var9 = aa.a(mActivity, appKey, content.getBytes());//发包前奏
        byte[] var10 = var9.c();//发包数据
        cc.a(mActivity).g();//不大有用

        //aw 中的 发包方法
        b();//将 com.umeng.analytics.a.h 设置 如下 地址 顺序
        byte []result=null;
        for (int i=0;i<com.umeng.analytics.a.h.length;i++){// 对应 requestUrl "http://alog.umeng.com/app_logs"  "http://alog.umengcloud.com/app_logs"
           result = requestUrl(var10,com.umeng.analytics.a.h[i]);
            if(result != null) {
//                if(this.e != null) {
//                    this.e.c();
//                }
//                break;
            }

//            if(this.e != null) {
//                this.e.d();
//            }
        }
        int var12;
        if(result == null) {
            var12 = 1;
        } else {
            var12 = a(result);
        }
        // 对应于bc文件下的 switch(var12) { case 2:
        if (var12==2) {
            ad.a(mActivity).d();
            new be(mActivity).k();
            Log.i("MobclickAgent", new String(result));
        }

    }

    private int a(byte[] var1) {
        bp var2 = new bp();
        cj var3 = new cj(new com.umeng.analytics.pro.cy.a());
        af e = af.a(mActivity);
        try {
            var3.a(var2, var1);
            if(var2.a == 1) {
                e.b(var2.i());
                e.d();
            }

            by.c("send log:" + var2.f());
        } catch (Throwable var5) {}

        return var2.a == 1?2:3;
    }
}