package com.umeng.example.analytics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.bv;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by friends on 2017/7/10.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HttpHeadTest {
    @Rule
    public ActivityTestRule<MainActivity> mTasksActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);
        @Test
        public void clickAddTaskButton_opensAddTaskUi() {
            // Click on the add task button
            System.out.print(233);
        }

    /**
     *  header X-Umeng-SDK
     *  Android/6.1.1 UMENG+SDK%2F1.0+Android+SDK+built+for+x86%2F4.4.2+B604C2E005AC2ABE39983E8847E63607
     *  URLEncoder.encode(var3.toString(), "UTF-8")
     *  URLDecoder.decode(urlEncodeStr,"UTF-8") appkey md5 32位 大写
     *  Android/6.1.1 UMENG SDK/1.0 Android SDK built for x86/4.4.2 B604C2E005AC2ABE39983E8847E63607
     */
    @Test
    public void testUrlEncodeAndDecode() throws Exception{
        // Click on the add task button
        System.out.print(233);
        String urlEncodeStr="Android/6.1.1 UMENG+SDK%2F1.0+Android+SDK+built+for+x86%2F4.4.2+B604C2E005AC2ABE39983E8847E63607";
        String appkey = "596087883eae2574b10013a3";//友盟申请来的appkey
        //以下为 http head X-Umeng-Sdk 头部内容
        String encode = getX_Umeng_SdkVal(mTasksActivityTestRule.getActivity(),appkey);
        String urlDecodeStr= URLDecoder.decode(urlEncodeStr,"UTF-8");
        System.out.println(urlDecodeStr);
    }


    private static String md5(final String s) {
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

    /**
     * 获取X-Umeng-Sdk value值
     * @param context
     * @param appKey
     * @return
     */
    private String getX_Umeng_SdkVal(final Context context, String appKey) {
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
            catch (PackageManager.NameNotFoundException ex) {}
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

    /**
     * bd.class 下 c(context g) 方法 开始 session_id
     * @param var1
     * @return
     */
    public String b(Context var1) {
        String var2 = bv.c(var1);
        String var3 = AnalyticsConfig.getAppkey(var1);
        long var4 = System.currentTimeMillis();
        if(var3 == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        } else {
            StringBuilder var6 = new StringBuilder();
            var6.append(var4).append(var3).append(var2);
            String f = com.umeng.analytics.pro.bw.a(var6.toString());
            return f;
        }
    }
    @Test
    public void testGenerateSessionId(){
        b(mTasksActivityTestRule.getActivity());
    }

}
