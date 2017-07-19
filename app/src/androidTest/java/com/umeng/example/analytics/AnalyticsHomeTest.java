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

    /**
     * bc c()拿完 idtracking那里获取 操作的数据
     * @throws Exception
     */
    @Test
    public void requestUmeng() throws Exception {
        //bc 中 c()发包方法
        String content = mActivity.getResources().getText(R.string.body_content).toString();
        //接下来 解析 content的内容
        //初次启动
        content = "{\"body\":{\"activate_msg\":{\"ts\":1500062380032}},\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"req_time\":0,\"carrier\":\"Android\",\"successful_requests\":0,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxas7v2qqFcVAgAEaW1laRgPMDAwMDAwMDAw\\nMDAwMDAwFrbu\\/aqoVxUCAAVpZG1kNRgeNTI4NDQ3ZjRmZmI0ZTQ4MjRhMmZkMWQxZjBjZDYyFrLu\\n\\/aqoVxUCABk8GAphbmRyb2lkX2lkKA9mNTk5YmYwODc1YmEwNzMWrO79qqhXABgFaWRtZDUoHjUy\\nODQ0N2Y0ZmZiNGU0ODI0YTJmZDFkMWYwY2Q2Mhay7v2qqFcAGARpbWVpKA8wMDAwMDAwMDAwMDAw\\nMDAWtu79qqhXAAA=\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}\n";
//        String content2="{\"body\":{\"sessions\":[{\"id\":\"AA1388CC6E75B57BE3098B580EA4D86B\",\"end_time\":\"1500096617127\",\"start_time\":\"1500096617057\",\"duration\":70}]},\"header\":{\"failed_requests\":0,\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1184*720\",\"version_code\":1,\"device_model\":\"HUAWEI C199\",\"timezone\":8,\"device_name\":\"hwC199\",\"mc\":\"24:09:95:eb:67:78\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAwOTY3NzkyNzAWjNDiy6hXGCg3NjM2ZDA3NDdmNzMyNjQ3NjAyZDIw\\nZGIzZjMxZTU3YzNjMWQ0YjBjABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAWxKvJnqZXGCg5MjQ4\\nODUwMTkyMzc3YTg0YTI3Nzk4MGI0NWUxMzhjZWJjZjIxZmM1AA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFsaryZ6mVxgoOTM0ODg1MDEwYWJiZGJhMmE0ODU3YzU0MmM2MDEwYWU1NWMwMGFhYwALYXBw\\nX3ZlcnNpb24YAzEuMBaM0OLLqFcYKDc2MzZkMDc0MGNmODNjNmE4NDY2N2Y2MWNhMzU0MTZhNTAw\\nYzUwYmQAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTI6NTc6NDUWxKvJnqZXGCg5MjQ4\\nODUwMTlkZjMyMDNkODRhOThkNDg5MmEyMTRhYTg3MDExZTk2AApvc192ZXJzaW9uGAU0LjQuMhaM\\n0OLLqFcYKDc2MzZkMDc0NzM1ZTY3ZjlhNDNkODBjMDQ2NjZmMDdjODRlZjA5ZDQAAXYYBTUtNS01\\nFozQ4suoVxgoNzYzNmQwNzRlZGRmNWUwODJlOGRhNzZiYmQxMGU2MWVmZTQ0YmJlOQAGaml0dGVy\\nGAEwFozQ4suoVxgoNzYzNmQwNzQxNGM2MTJjNTNlZDBmMzkwNzBkYTAyOTNmZDFmNmU5OQAEdW1p\\nZBgiYWlmOGY5YTcxZGFhNWZjN2E0YjVlN2VlYzJiNDIzNjFkZRaM0OLLqFcYKDc2MzZkMDc0OTYy\\nMmQ5YjY5M2E2NDIwZGFjMTA2MmFiMGY3ZjdmMTQAB2NoYW5uZWwYBVVtZW5nFozQ4suoVxgoNzYz\\nNmQwNzRiN2IzYThiMjlmODRiMWZiY2I0MzJiMjQzNmE1Y2I4MAAVAhggZTkxNDA0NThiZDNhNjhk\\nMDdhOTBkYmJiZWQ5MzFjZWYA\\n\",\"req_time\":24,\"carrier\":\"中国电信\",\"successful_requests\":21,\"device_board\":\"C199\",\"vertical_type\":0,\"device_manufacturer\":\"HUAWEI\",\"id_tracking\":\"GwWMCmFuZHJvaWRfaWQYEDQxMWNmNmJiMGJmZjZhOGYWzODGnqZXFQIAA21hYxgRMjQ6MDk6OTU6\\nZWI6Njc6NzgWlODGnqZXFQIABnNlcmlhbBgMMjQwOTk1ZWI3NzE4FsTgxp6mVxUCAAVpZG1kNRgg\\nY2U5Y2RlNzI5ODdmMzliNmNjODUzNzc5ZDk1ZTFlN2QW\\/t\\/GnqZXFQIABGltZWkYDkEwMDAwMDRG\\nRjI0RDE4FsLgxp6mVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"A8:85:FE:29:16:07:F8:12:EE:78:15:A2:0F:F3:49:6A\",\"cpu\":\"ARMv7 Processor rev 3 (v7l)\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"A000004FF24D18\",\"device_brand\":\"Huawei\",\"access\":\"wifi\",\"country\":\"CN\",\"os_version\":\"4.4.2\",\"idmd5\":\"ce9cde72987f39b6cc853779d95e1e7d\",\"display_name\":\"友盟SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"HuaweiC199\",\"mccmnc\":\"46003\",\"language\":\"zh\",\"channel\":\"Umeng\",\"device_manutime\":1422528853000}}";
        //String content2 = "{\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAyNjU3NzY1NTkW3pb47KlXGChkZjY3YTM3ZWU3MTIyMmRlYmFiYmMx\\nY2QyNTk0NDIxMDM5NzBlZDA2ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW\\/rWQ7KlXGCgwZjZm\\nYWU3ZWIwM2ZlODNlYzA3ZjFjNGI0ZmExN2NhZTFkMWFmMjE2AA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFv61kOypVxgoMGY2ZmFlN2VhYmM3NzgzNjNjMDk1ZjEyZTk0NzI0ZGQ0YWQ3MTMzNwALYXBw\\nX3ZlcnNpb24YAzEuMBb+tZDsqVcYKDBmNmZhZTdlMjczZjYzNzdkMDExYjFiZjEyY2YyNzRjZGYw\\nZWRmZDUAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzI6NDYW\\/rWQ7KlXGCgwZjZm\\nYWU3ZWZmOTllNDFkZTc4OGU0OGQwMjJjMjQ1MDNiZDQzZmFiAApvc192ZXJzaW9uGAU0LjQuMhb+\\ntZDsqVcYKDBmNmZhZTdlZjVlYTE5ZjMyMWE1NWU2OGU0ZjVkMzFmOTk1ZGJkYmYAAXYYBTUtNS01\\nFv61kOypVxgoMGY2ZmFlN2UxZTIzYzlhYWJjMjljZDU2YzdmZDJlYjIwN2ZmNzQwOAAGaml0dGVy\\nGAYyMDI0MjEW2uDO7KlXGCg1ZGJhYTU3ZTg1YTM1NWJjNWU5NmZiY2RjMjY0NDM1YjgxOTE4YmU2\\nAAdjaGFubmVsGAVVbWVuZxb+tZDsqVcYKDBmNmZhZTdlZjQzMTg4YmU5NzZiZDRhY2U5ODk3MDgx\\nMDdlNGJiMWEABHVtaWQYImFpZjhmOWE3MWRhYTVmYzdhNGI1ZTdlZWMyYjQyMzYxZGUW\\/rWQ7KlX\\nGCgwZjZmYWU3ZWI1YjJlMDFkZjNlYmNjNjQ4MGJiY2JkZTgyYjFlMmRmABUCGCAzYjgyY2Y4OGM4\\nN2RiNDk0MjhhMDhiYmQwNzliZmMwNAA=\\n\",\"req_time\":53,\"carrier\":\"Android\",\"successful_requests\":4,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxas7v2qqFcVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2Mhay7v2qqFcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFrbu\\n\\/aqoVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}";
        //第n次启动
//        content2="{\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAyNjk1Nzg4ODgWkKrI8KlXGChmODY4NjU3ZmFlNmU5NmQxNGJiZDVj\\nMTMwYzg0ZThjMDg4NmZhYzkxABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAWkKrI8KlXGChmODY4\\nNjU3ZjZiM2NhZjhjODllMWYxMTMzZDI3NDRhNjhmMjIwNjljAA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFpCqyPCpVxgoZjg2ODY1N2ZiYTk3MWJjYzhkMzAxMGEwODE0OWI1ZjRmNDExMmE1MwALYXBw\\nX3ZlcnNpb24YAzEuMBaQqsjwqVcYKGY4Njg2NTdmMTIzZjQ5NjY0MjIzZjFlZGQ5MzUwODNkNGJk\\nZDFhMWEAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzI6NDYWkKrI8KlXGChmODY4\\nNjU3ZmQxYmI2NWYwZjZkZGY1OGEyODhiZDczZWY2Yzk1NTAxAApvc192ZXJzaW9uGAU0LjQuMhaQ\\nqsjwqVcYKGY4Njg2NTdmYjc0NWRmNDQxZTVmOTkzYzQ2ODI4N2I1MjY2OWMzZWEAAXYYBTUtNS01\\nFpCqyPCpVxgoZjg2ODY1N2YzNWI4MWJkOGMxZTRlM2U3NzEzMTUxMTNjYjA1OGIzZQAGaml0dGVy\\nGAYyMDI0MjEWkKrI8KlXGChmODY4NjU3ZjlmZmYwYzIwN2JiMTUzN2I2N2JlMzU0ZDhiOWI2M2I5\\nAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFpCqyPCpVxgoZjg2ODY1\\nN2Y2NjRjMTM1ODg1ZWY0Njg2YzE1ZGQwNzE2ZWI5ZTEyZAAHY2hhbm5lbBgFVW1lbmcWkKrI8KlX\\nGChmODY4NjU3ZjczZTkyYzE5Y2E0NmRhZjAyMGMyYjRjODU0Y2Q1YWQwABUCGCA5YWVkNDZlYTE1\\nNjNmMjI3OWI0MDhiYjgyOWVmOTY0YQA=\\n\",\"req_time\":53,\"carrier\":\"Android\",\"successful_requests\":4,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxas7v2qqFcVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2Mhay7v2qqFcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFrbu\\n\\/aqoVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}\n";
        content="{\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAyNzEwMzQyMjEW2v358alXGCgxZDVkNzM3ZmNkNDJkMzlmNWRkY2M2\\nNzE5ZGFkZjVkY2I1M2E2NDRmABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW2v358alXGCgxZDVk\\nNzM3ZjM4ZDY3NDIzZmQyMDNjYWVhYzFlZmI3NWM3ZmI3MTI2AA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFtr9+fGpVxgoMWQ1ZDczN2Y3NTExNTA1ZDUzNmQxMDEwMWZhNjgxZWM4NGE5N2ExMwALYXBw\\nX3ZlcnNpb24YAzEuMBba\\/fnxqVcYKDFkNWQ3MzdmNjkzZmY3NzU4NDEyMzg1N2Q5NWYzNGU0OTM4\\nNjFlZWEAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzI6NDYW2v358alXGCgxZDVk\\nNzM3ZjEzMmU1Y2EyZmU2M2E2YjhmMmYzOTNhN2I3MTk4YzFiAApvc192ZXJzaW9uGAU0LjQuMhba\\n\\/fnxqVcYKDFkNWQ3MzdmNjFkZjZhMjAwOGU4NGUzZWFjZWVlNmFlNDZjYTU4MzIAAXYYBTUtNS01\\nFtr9+fGpVxgoMWQ1ZDczN2ZhNmU4NzNlMjk1NzA1Y2ZlNjgzNDU5Njg5MmFiMWMwNQAGaml0dGVy\\nGAYyMDI0MjEW2v358alXGCgxZDVkNzM3ZjFkZDU3M2YxYWQ2ZDc4MDljMmI2NGJkNzc3Y2VjNGI0\\nAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFtr9+fGpVxgoMWQ1ZDcz\\nN2Y5NzFmYzY4MGFhNTZkNDFkOGYxMjhhYzA0ZWNkZDEyYgAHY2hhbm5lbBgFVW1lbmcW2v358alX\\nGCgxZDVkNzM3ZjIyNGZkODljZDJiOGNlNjI4YWYxODJhZjdiYWFiNzkxABUCGCAyNTk1ODk5YTUz\\nZTU4YjZiMTI5NDEwZmZlOTRhZTVjYgA=\\n\",\"req_time\":13470,\"carrier\":\"Android\",\"successful_requests\":5,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxas7v2qqFcVAgAEaW1laRgPMDAwMDAwMDAw\\nMDAwMDAwFrbu\\/aqoVxUCAAVpZG1kNRgeNTI4NDQ3ZjRmZmI0ZTQ4MjRhMmZkMWQxZjBjZDYyFrLu\\n\\/aqoVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}";
        //事件
//        String content2 = "{\"body\":{\"ekv\":[{\"F7CF59F06106593E7F2C45BA644EF7BA\":[{\"id\":\"MY_EVENT_ID\",\"_umpname\":\"com.umeng.example.analytics.AnalyticsHome\",\"ts\":1500063365236,\"MY_EVENT_ID\":\"\"}]}]},\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAyNjU3NzY1NTkW3pb47KlXGChkZjY3YTM3ZWU3MTIyMmRlYmFiYmMx\\nY2QyNTk0NDIxMDM5NzBlZDA2ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW\\/rWQ7KlXGCgwZjZm\\nYWU3ZWIwM2ZlODNlYzA3ZjFjNGI0ZmExN2NhZTFkMWFmMjE2AA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFv61kOypVxgoMGY2ZmFlN2VhYmM3NzgzNjNjMDk1ZjEyZTk0NzI0ZGQ0YWQ3MTMzNwALYXBw\\nX3ZlcnNpb24YAzEuMBb+tZDsqVcYKDBmNmZhZTdlMjczZjYzNzdkMDExYjFiZjEyY2YyNzRjZGYw\\nZWRmZDUAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzI6NDYW\\/rWQ7KlXGCgwZjZm\\nYWU3ZWZmOTllNDFkZTc4OGU0OGQwMjJjMjQ1MDNiZDQzZmFiAApvc192ZXJzaW9uGAU0LjQuMhb+\\ntZDsqVcYKDBmNmZhZTdlZjVlYTE5ZjMyMWE1NWU2OGU0ZjVkMzFmOTk1ZGJkYmYAAXYYBTUtNS01\\nFv61kOypVxgoMGY2ZmFlN2UxZTIzYzlhYWJjMjljZDU2YzdmZDJlYjIwN2ZmNzQwOAAGaml0dGVy\\nGAYyMDI0MjEW2uDO7KlXGCg1ZGJhYTU3ZTg1YTM1NWJjNWU5NmZiY2RjMjY0NDM1YjgxOTE4YmU2\\nAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFv61kOypVxgoMGY2ZmFl\\nN2ViNWIyZTAxZGYzZWJjYzY0ODBiYmNiZGU4MmIxZTJkZgAHY2hhbm5lbBgFVW1lbmcW\\/rWQ7KlX\\nGCgwZjZmYWU3ZWY0MzE4OGJlOTc2YmQ0YWNlOTg5NzA4MTA3ZTRiYjFhABUCGCAzYjgyY2Y4OGM4\\nN2RiNDk0MjhhMDhiYmQwNzliZmMwNAA=\\n\",\"req_time\":53,\"carrier\":\"Android\",\"successful_requests\":4,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxas7v2qqFcVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2Mhay7v2qqFcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFrbu\\n\\/aqoVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}\n";

        //onpause之后 onresume 有效
        content="{\"body\":{\"sessions\":[{\"autopages\":[{\"page_name\":\"com.umeng.example.analytics.AnalyticsHome\",\"duration\":71954}],\"id\":\"0C68996F4371E0C1B022D70AF9EE7E6F\",\"start_time\":\"1500074042808\",\"duration\":69599,\"end_time\":\"1500074112407\"}]},\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAyNzY1MDE5NzEWpreV96lXGChhM2NmMWU3ZjkzZTZkM2FiYzEyZGFm\\nZTIyZWZlOGViZjVmYWM4Y2Q2ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAWmN6I96lXGChmYzc1\\nMWQ3ZmU2MWViYWU3NzA3MzE2NjhlYzZkZWQwMzNlOWVjZjMyAA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFpjeiPepVxgoZmM3NTFkN2Y1NzQxZmY0NzVkNjJhOWRmNTcxZmFmYmNjZDRhMzE2NAALYXBw\\nX3ZlcnNpb24YAzEuMBaY3oj3qVcYKGZjNzUxZDdmOTdjN2UyODVhZTc2NWJjYTJhNDcyZjVmODlj\\nMDZlOTUAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzI6NDYWmN6I96lXGChmYzc1\\nMWQ3ZmE2N2ZjMjQyZDBmY2E3MDEwYjhmZDViZDM3OTVkZDFhAApvc192ZXJzaW9uGAU0LjQuMhaY\\n3oj3qVcYKGZjNzUxZDdmMzZjY2EwNmNmYzVjZmQxNjg0MjY0NmU3YTFmMzkyZDcAAXYYBTUtNS01\\nFpjeiPepVxgoZmM3NTFkN2Y5Y2MwYmM2ZGY2NzhjOTU1ZWU3ZGQwZDdmMjc0NDk4MwAGaml0dGVy\\nGAYyMDI0MjEWmN6I96lXGChmYzc1MWQ3ZmI0MjZiOGZjYTczMjVhMTZiYzUwNzQ2NjkwYjZlZjJm\\nAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFpjeiPepVxgoZmM3NTFk\\nN2Y2ODlkYWY2MDUxYmIwM2QzM2E0NzBiMDkyMGM3NGVhNgAHY2hhbm5lbBgFVW1lbmcWmN6I96lX\\nGChmYzc1MWQ3ZjRlMjNmMTM0NzU0NjM2MjM4MWI1YjI4OTcwOGMxNDA2ABUCGCAzZjZlNGRlZTU5\\nY2VkYTM5ZTdiM2Q5ZWQzNTZhODY1MgA=\\n\",\"req_time\":27,\"carrier\":\"Android\",\"successful_requests\":2,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3MxbW1v61qFcVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2MhbO1v61qFcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFtTW\\n\\/rWoVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}\n";
        //content="{\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAyNzYzOTc5NjQWmN6I96lXGChmYzc1MWQ3ZjFmMjNmZDVjMzMxYjFm\\nZmEzMTMyOWE3OTU0YTNiZGViABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAWmN6I96lXGChmYzc1\\nMWQ3ZmU2MWViYWU3NzA3MzE2NjhlYzZkZWQwMzNlOWVjZjMyAA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFpjeiPepVxgoZmM3NTFkN2Y1NzQxZmY0NzVkNjJhOWRmNTcxZmFmYmNjZDRhMzE2NAALYXBw\\nX3ZlcnNpb24YAzEuMBaY3oj3qVcYKGZjNzUxZDdmOTdjN2UyODVhZTc2NWJjYTJhNDcyZjVmODlj\\nMDZlOTUAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzI6NDYWmN6I96lXGChmYzc1\\nMWQ3ZmE2N2ZjMjQyZDBmY2E3MDEwYjhmZDViZDM3OTVkZDFhAApvc192ZXJzaW9uGAU0LjQuMhaY\\n3oj3qVcYKGZjNzUxZDdmMzZjY2EwNmNmYzVjZmQxNjg0MjY0NmU3YTFmMzkyZDcAAXYYBTUtNS01\\nFpjeiPepVxgoZmM3NTFkN2Y5Y2MwYmM2ZGY2NzhjOTU1ZWU3ZGQwZDdmMjc0NDk4MwAGaml0dGVy\\nGAYyMDI0MjEWmN6I96lXGChmYzc1MWQ3ZmI0MjZiOGZjYTczMjVhMTZiYzUwNzQ2NjkwYjZlZjJm\\nAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFpjeiPepVxgoZmM3NTFk\\nN2Y2ODlkYWY2MDUxYmIwM2QzM2E0NzBiMDkyMGM3NGVhNgAHY2hhbm5lbBgFVW1lbmcWmN6I96lX\\nGChmYzc1MWQ3ZjRlMjNmMTM0NzU0NjM2MjM4MWI1YjI4OTcwOGMxNDA2ABUCGCAyMmVkNDgyNDhh\\nYWNlNzZiYjlkODEwOTBmNzYzYWUwZgA=\\n\",\"req_time\":60,\"carrier\":\"Android\",\"successful_requests\":1,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3MxbW1v61qFcVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2MhbO1v61qFcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFtTW\\n\\/rWoVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}\n";
        content="{\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"imprint\":\"GwqMB3ByZXRpbWUYDTE1MDAzNTcwOTcxNzQWrNuDxKpXGChhNjE0MmM2NGM1NzhlZTlkZTc4OTZi\\nNjdmM2FiZGE0ZDY4M2ZjZTNmABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAWkPTlwqpXGCg3OGRm\\nNDA2NGEzNGJiZjQ4NjkwZmNkYzM3MTkwYmE1MWI5NTdhMjExAA9pbnN0YWxsX2NoYW5uZWwYBVVt\\nZW5nFpD05cKqVxgoNzhkZjQwNjQ5MDgwODFjOGRiMGU3MGNhZjZiMWI1YTAwYzE1MWIwNgALYXBw\\nX3ZlcnNpb24YAzEuMBaQ9OXCqlcYKDc4ZGY0MDY0ZWE3OTc5MWNiYzFhMDE0MmE4NzAyMmE0YTY4\\nY2RhYTAAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzI6NDYWkPTlwqpXGCg3OGRm\\nNDA2NDBmMjVjZjM0NDI1Zjg5YzRlNzMyNzhkZjdjMzEwMDc5AApvc192ZXJzaW9uGAU0LjQuMhaQ\\n9OXCqlcYKDc4ZGY0MDY0NmY0YjdjMjg2MTQ4NzQzNWEwN2E3MTZjN2NlNjY3NTQAAXYYBTUtNS01\\nFpD05cKqVxgoNzhkZjQwNjQ5YzNhODcyMThiNTNhYWVlN2IwZTViN2JmN2VkZjNlMAAGaml0dGVy\\nGAYyNjA0MDIWkKy0w6pXGCg3OGU5NWE2NDIzMDk3ZmI2OWVlZDk5MjllNzYwNmZlODU2ODI1ZDVj\\nAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFpD05cKqVxgoNzhkZjQw\\nNjRlZDM5MTcwNjBmZTIwYjRmZGJlZWIzMjQ2YjhkZGFiOQAHY2hhbm5lbBgFVW1lbmcWkPTlwqpX\\nGCg3OGRmNDA2NGM2ZjlkYjAzMjJjODQ0ZTI5ZWQ2MjhhMjc3NzBkNjY2ABUCGCBmOTNhMGRlNTEy\\nMWJkNGNjZWEwMjZkYTY3NTlkYzgxNwA=\\n\",\"req_time\":56,\"carrier\":\"Android\",\"successful_requests\":3,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxb4prXKqFcVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2Mhb6prXKqFcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFvKm\\ntcqoVxUCABkMAA==\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}\n";
        //对于 imprint 方面的内容可能是关键
        //Imprint(property:{pretime=ImprintValue(value:1499764532416, ts:1499764532416, guid:b0c682007f19211d053be67189b0d1f1eb3df131), latent=ImprintValue(value:3, ts:1499571034174, guid:4e7a0a15a72ed3918e2d7928b3a8a338d5b2f654), install_app_version=ImprintValue(value:1.0, ts:1499571034174, guid:4e7a0a150ce76952c688efcef1adb4fe78c02924), install_channel=ImprintValue(value:Umeng, ts:1499571034174, guid:4e7a0a150850adc3aca2238f98771fac444d0e2c), app_version=ImprintValue(value:1.0, ts:1499764532416, guid:b0c68200fb29ba4037b54b76b719e684a9320d71), install_datetime=ImprintValue(value:2017-07-09 11:30:34, ts:1499571034174, guid:4e7a0a158171c4e1af3d0d4c83cc16a7178cce39), os_version=ImprintValue(value:4.4.2, ts:1499764532416, guid:b0c68200afb34b8bd256abf9b1d8ff0d482b1d9e), v=ImprintValue(value:5-5-5, ts:1499764532416, guid:b0c6820086a4ed7fcd4869dcad26675994d1ff8e), jitter=ImprintValue(value:1, ts:1499764532416, guid:b0c68200c58298d4fe221a29ff0a2765ca3be0e1), channel=ImprintValue(value:Umeng, ts:1499764532416, guid:b0c6820073c0dd68082f9252dec8a4cbf7b1b3f3), umid=ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1499764532416, guid:b0c68200d9961f3096fa0a708301e3b4cc74293b)}, version:1, checksum:c6209d767b41176e150f4f89ed1b2b6c)
        bn var18= af.a(mActivity).a();//用于读取imprint 有或无 单例类

        aa var9 = aa.a(mActivity, appKey, content.getBytes());//发包前奏
        byte[] var10 = var9.c();//发包数据
        cc.a(mActivity).g();//不大有用

        //aw 中的 发包方法
        b();//将 com.umeng.analytics.a.h 设置 如下 地址 顺序
        byte []result=null;
        for (int i=0;i<com.umeng.analytics.a.h.length;i++){// 对应 requestUrl "http://alog.umeng.com/app_logs"  "http://alog.umengcloud.com/app_logs"
           result = requestUrl(var10,com.umeng.analytics.a.h[i]);
            if(result != null) {
                System.out.println(new String(result));
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