package com.umeng.example.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.*;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

import static com.umeng.analytics.pro.bv.t;

/**
 * Created by friends on 2017/7/10.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HttpContentTest {
    private Context mContext;
    @Rule
    public ActivityTestRule<MainActivity> mTasksActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class){
                @Override
                protected void beforeActivityLaunched() {
                    super.beforeActivityLaunched();
                    mContext = mTasksActivityTestRule.getActivity();
                }
            };
        @Test
        public void clickAddTaskButton_opensAddTaskUi() {
            // Click on the add task button
            System.out.print(233);
        }
    private static String a(byte[] var0) {
        StringBuilder var1 = new StringBuilder(var0.length * 2);

        for(int var2 = 0; var2 < var0.length; ++var2) {
            String var3 = Integer.toHexString(var0[var2]);
            int var4 = var3.length();
            if(var4 == 1) {
                var3 = "0" + var3;
            }

            if(var4 > 2) {
                var3 = var3.substring(var4 - 2, var4);
            }

            var1.append(var3.toUpperCase(Locale.getDefault()));
            if(var2 < var0.length - 1) {
                var1.append(':');
            }
        }

        return var1.toString();
    }
    public static String u(Context var0) {
        String var1 = null;

        try {
            PackageManager var2 = var0.getPackageManager();
            int var3 = PackageManager.GET_SIGNATURES;//64;
            PackageInfo var4 = var2.getPackageInfo(t(var0), var3);
            Signature[] var5 = var4.signatures;
            byte[] var6 = var5[0].toByteArray();
            ByteArrayInputStream var7 = new ByteArrayInputStream(var6);
            CertificateFactory var8 = CertificateFactory.getInstance("X509");
            X509Certificate var9 = (X509Certificate)var8.generateCertificate(var7);
            MessageDigest var10 = MessageDigest.getInstance("MD5");
            byte[] var11 = var10.digest(var9.getEncoded());
            var1 = a(var11);
        } catch (Throwable var12) {
            ;
        }

        return var1;
    }

    /**
     *
     */
    @Test
   public void testGenerateSessionId() throws  Exception{
        //var10.put("app_signature", bv.u(j));
        u(mTasksActivityTestRule.getActivity());


        /**
         * 000000000000000
         * md5加密
         * 5284047F4FFB4E04824A2FD1D1F0CD62
         *
         * var10.put("idmd5", bv.d(mContext)); //bv.c(mContext) 再取 md5
         */
        bv.d(mContext);

        /**
         * imprint 重点
         *
         * Value GwuMB3ByZXRpbWUYDTE0OTk4MjQ1NDQxNTQWtOaSyKZXGChlYTNiZWUwNDE4YjU5ZjcxMmE2ZjQ2
         MTVjNTc4MTQ5NzFjMzgyM2RkAAZsYXRlbnQYATMW/OCw1qRXGCg0ZTdhMGExNWE3MmVkMzkxOGUy
         ZDc5MjhiM2E4YTMzOGQ1YjJmNjU0ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW/OCw1qRXGCg0
         ZTdhMGExNTBjZTc2OTUyYzY4OGVmY2VmMWFkYjRmZTc4YzAyOTI0AA9pbnN0YWxsX2NoYW5uZWwY
         BVVtZW5nFvzgsNakVxgoNGU3YTBhMTUwODUwYWRjM2FjYTIyMzhmOTg3NzFmYWM0NDRkMGUyYwAL
         YXBwX3ZlcnNpb24YAzEuMBa05pLIplcYKGVhM2JlZTA0MTg5ZGE1YWU2ZDBhMDE2ODM5OTI3NjE5
         NzQ0Y2YzODIAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzA6MzQW/OCw1qRXGCg0
         ZTdhMGExNTgxNzFjNGUxYWYzZDBkNGM4M2NjMTZhNzE3OGNjZTM5AApvc192ZXJzaW9uGAU0LjQu
         Mha05pLIplcYKGVhM2JlZTA0YzQ2NGY0NGFlYTdkMjYxYWE2ZDdjN2Y3Y2ZiZTgxODAAAXYYBTUt
         NS01FrTmksimVxgoZWEzYmVlMDQ4OTk4N2I5ZmU4YTZhZWJiNzlkNzhmYTVjYzI0YWM3MAAGaml0
         dGVyGAIxMBa05pLIplcYKGVhM2JlZTA0N2ExYWE2OTIzZDU0NGJiOTE5YzdlZWIyYTIyMGU1ZDMA
         B2NoYW5uZWwYBVVtZW5nFrTmksimVxgoZWEzYmVlMDQ1MDE2NDQ0NDgyNThjY2Y5ZWI2YzdiZjkz
         Zjc3YWI0MQAEdW1pZBgiYWlmOGY5YTcxZGFhNWZjN2E0YjVlN2VlYzJiNDIzNjFkZRa05pLIplcY
         KGVhM2JlZTA0NzA3MzY5ZmEyNmMwOTg1ZDIxNmI3NTA4MjhlZWZhNTAAFQIYIGRhOTY2YzVlODA3
         NzYzMjQzNjMzMWMyN2UwOTg0OWU1AA==
         at imprint of type java.lang.String cannot be converted to JSONObject
         */

            bn var18 = af.a(mContext).a();//获取出bn对象
            if(var18 != null) {
                byte[] var19 = (new cp()).a(var18);//
//                var10.put("imprint", Base64.encodeToString(var19, 0));//base64编码字节码
                Base64.encodeToString(var19, 0);
            }

        /**
         * {"body":{"userlevel":"1"},"header":{"failed_requests":0,"access_subtype":"LTE","appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1794*1080","version_code":1,"device_model":"Android SDK built for x86","timezone":-5,"device_name":"generic_x86","imprint":"GwuMB3ByZXRpbWUYDTE0OTk4MjQ1NDQxNTQWtOaSyKZXGChlYTNiZWUwNDE4YjU5ZjcxMmE2ZjQ2\nMTVjNTc4MTQ5NzFjMzgyM2RkAAZsYXRlbnQYATMW\/OCw1qRXGCg0ZTdhMGExNWE3MmVkMzkxOGUy\nZDc5MjhiM2E4YTMzOGQ1YjJmNjU0ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW\/OCw1qRXGCg0\nZTdhMGExNTBjZTc2OTUyYzY4OGVmY2VmMWFkYjRmZTc4YzAyOTI0AA9pbnN0YWxsX2NoYW5uZWwY\nBVVtZW5nFvzgsNakVxgoNGU3YTBhMTUwODUwYWRjM2FjYTIyMzhmOTg3NzFmYWM0NDRkMGUyYwAL\nYXBwX3ZlcnNpb24YAzEuMBa05pLIplcYKGVhM2JlZTA0MTg5ZGE1YWU2ZDBhMDE2ODM5OTI3NjE5\nNzQ0Y2YzODIAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzA6MzQW\/OCw1qRXGCg0\nZTdhMGExNTgxNzFjNGUxYWYzZDBkNGM4M2NjMTZhNzE3OGNjZTM5AApvc192ZXJzaW9uGAU0LjQu\nMha05pLIplcYKGVhM2JlZTA0YzQ2NGY0NGFlYTdkMjYxYWE2ZDdjN2Y3Y2ZiZTgxODAAAXYYBTUt\nNS01FrTmksimVxgoZWEzYmVlMDQ4OTk4N2I5ZmU4YTZhZWJiNzlkNzhmYTVjYzI0YWM3MAAGaml0\ndGVyGAIxMBa05pLIplcYKGVhM2JlZTA0N2ExYWE2OTIzZDU0NGJiOTE5YzdlZWIyYTIyMGU1ZDMA\nB2NoYW5uZWwYBVVtZW5nFrTmksimVxgoZWEzYmVlMDQ1MDE2NDQ0NDgyNThjY2Y5ZWI2YzdiZjkz\nZjc3YWI0MQAEdW1pZBgiYWlmOGY5YTcxZGFhNWZjN2E0YjVlN2VlYzJiNDIzNjFkZRa05pLIplcY\nKGVhM2JlZTA0NzA3MzY5ZmEyNmMwOTg1ZDIxNmI3NTA4MjhlZWZhNTAAFQIYIGRhOTY2YzVlODA3\nNzYzMjQzNjMzMWMyN2UwOTg0OWU1AA==\n","req_time":1687288,"carrier":"Android","successful_requests":13,"device_board":"unknown","vertical_type":0,"device_manufacturer":"unknown","id_tracking":"GwSMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxbe5piaolcVAgAFdXRkaWQYGFdWeVVQem40\nWFZBREFKd2NsakM3bHhURBbc5piaolcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFuzlmJqiVxUC\nAAVpZG1kNRgeNTI4NDQ3ZjRmZmI0ZTQ4MjRhMmZkMWQxZjBjZDYyFujlmJqiVxUCABkMAA==\n","os":"Android","app_signature":"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94","cpu":"0","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"000000000000000","device_brand":"generic_x86","access":"2G\/3G","country":"US","os_version":"4.4.2","idmd5":"528447f4ffb4e4824a2fd1d1f0cd62","display_name":"UMENG SDK","sdk_type":"Android","device_manuid":"KK","mccmnc":"310260","language":"en","channel":"Umeng","device_manutime":1478741905000}}
         */

        bm var1 = ad.a(mContext).b();
        byte[] var2 = (new cp()).a(var1);
        String var3 = Base64.encodeToString(var2, 0);
        if(!TextUtils.isEmpty(var3)) {
//            JSONObject var4 = j.getJSONObject("header");
//            var4.put("id_tracking", var3);
//            this.j.put("header", var4);
        }
    }

}
