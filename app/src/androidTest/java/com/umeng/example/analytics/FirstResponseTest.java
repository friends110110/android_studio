package com.umeng.example.analytics;

import android.app.Activity;
import android.os.Build;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.text.TextUtils;
import com.umeng.analytics.pro.*;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by friends on 2017/7/10.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class FirstResponseTest {
    private Activity mActivity;

    @Rule
    public ActivityTestRule<MainActivity> mTasksActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class){
                @Override
                protected void afterActivityLaunched() {
                    super.afterActivityLaunched();
                    mActivity = mTasksActivityTestRule.getActivity();

                }

            };
        @Test
        public void clickAddTaskButton_opensAddTaskUi() {
            // Click on the add task button
            System.out.print(233);
        }




    /**
     * 首次安装时候发包的数据内容
     * {"body":{"activate_msg":{"ts":1499889460391}},"header":{"failed_requests":0,"access_subtype":"LTE","appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1794*1080","version_code":1,"device_model":"Android SDK built for x86","timezone":-5,"device_name":"generic_x86","req_time":0,"carrier":"Android","successful_requests":0,"device_board":"unknown","vertical_type":0,"device_manufacturer":"unknown","id_tracking":"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3MxaE+OuGp1cVAgAEaW1laRgPMDAwMDAwMDAw\nMDAwMDAwFv7364anVxUCAAVpZG1kNRgeNTI4NDQ3ZjRmZmI0ZTQ4MjRhMmZkMWQxZjBjZDYyFvb3\n64anVxUCABk8GAVpZG1kNSgeNTI4NDQ3ZjRmZmI0ZTQ4MjRhMmZkMWQxZjBjZDYyFvb364anVwAY\nBGltZWkoDzAwMDAwMDAwMDAwMDAwMBb+9+uGp1cAGAphbmRyb2lkX2lkKA9mNTk5YmYwODc1YmEw\nNzMWhPjrhqdXAAA=\n","os":"Android","app_signature":"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94","cpu":"0","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"000000000000000","device_brand":"generic_x86","access":"2G\/3G","country":"US","os_version":"4.4.2","idmd5":"528447f4ffb4e4824a2fd1d1f0cd62","display_name":"UMENG SDK","sdk_type":"Android","device_manuid":"KK","mccmnc":"310260","language":"en","channel":"Umeng","device_manutime":1478741905000}}
     */


    /**
     * 对回包数据的处理， 在 bc c() byte[] var5 = this.i.a(var10); 发包数据的数据
     *
     *
     String content="{\"body\":{\"activate_msg\":{\"ts\":1499891764064}},\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"req_time\":0,\"carrier\":\"Android\",\"successful_requests\":0,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxa+vaGIp1cVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2MhbKvaGIp1cVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFsS9\\noYinVxUCABk8GAphbmRyb2lkX2lkKA9mNTk5YmYwODc1YmEwNzMWvr2hiKdXABgEaW1laSgPMDAw\\nMDAwMDAwMDAwMDAwFsS9oYinVwAYBWlkbWQ1KB41Mjg0NDdmNGZmYjRlNDgyNGEyZmQxZDFmMGNk\\nNjIWyr2hiKdXAAA=\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}";
     byte[] var1 = aa.a(d, "596087883eae2574b10013a3", String.valueOf(content).getBytes()).c();

     HttpURLConnection var3 = (HttpURLConnection)(new URL("http://alog.umeng.com/app_logs")).openConnection();
     var3.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
     String xumengsdk = "Android/6.1.1 UMENG+SDK%2F1.0+Android+SDK+built+for+x86%2F4.4.2+B604C2E005AC2ABE39983E8847E63607";
     var3.setRequestProperty("X-Umeng-Sdk", xumengsdk);
     var3.setRequestProperty("Msg-Type", "envelope/json");
     var3.setRequestProperty("Content-Type", "envelope/json");
     var3.setConnectTimeout(10000);
     var3.setReadTimeout(30000);
     var3.setRequestMethod("POST");
     var3.setDoOutput(true);
     var3.setDoInput(true);
     var3.setUseCaches(false);
     if(Build.VERSION.SDK_INT < 8) {
     System.setProperty("http.keepAlive", "false");
     }

     OutputStream var21 = var3.getOutputStream();
     var21.write(var1);
     var21.flush();
     var21.close();

     int var22 = var3.getResponseCode();
     String var6 = var3.getHeaderField("Content-Type");
     boolean var7 = false;
     if(!TextUtils.isEmpty(var6) && var6.equalsIgnoreCase("application/thrift")) {
     var7 = true;
     }
     InputStream var8 = var3.getInputStream();
     byte[] var9 = bw.b(var8);//读取到了 回包的数据包

     by.e(new String(var9))

     */

    /**
     * 接收 回包数据
     * 回包数据的 new String
     * ����������������succeed����������
     ������install_datetime��������2017-07-09 11:32:46
     ������]?����������(8ed77d0f5dd6a4aa1afe2f3e3b8d6623f974bdf0��������umid��������"aif8f9a71daa5fc7a4b5e7eec2b42361de
     ������]?����������(8ed77d0fcb9a938de671e79c4f14ef46fc08f2dd��������channel��������Umeng
     ������]?����������(8ed77d0f69217c775a07dc16c95ba1d9ef3f4b06��������install_app_version��������1.0
     ������]?����������(8ed77d0f0e782c7a5a08e7eba5fa8812f21db901��������jitter��������108537
     ������]?����������(8ed77d0f1b5c7c0ad9d09164b93c553007ca2c8e��������
     os_version��������4.4.2
     ������]?����������(8ed77d0fc772cac5e21c61f8f3ca9d5749c88157��������v��������5-5-5
     ������]?����������(8ed77d0f73dc20caee9182aa912e364834931db8��������pretime��������1500001711614
     ������]?����������(8ed77d0ffd95d70e85be41123a38f3e6357efd1f��������install_channel��������Umeng
     ������]?����������(8ed77d0feb8dfba80d0f768c7e1e85925778a8b7��������app_version��������1.0
     ������]?����������(8ed77d0ff5e32c9085e281f5682daaa12e8be7a4������������������ b3caade0a78e973699751f4992fbbb0a����

     */

    /**
     *
     * 调试 发现内容
     * Imprint(property:{pretime=ImprintValue(value:1500002097622, ts:1500002097622, guid:a6fb7b0fd2d8ebcca7fd28f3d4c25dc033728665), install_app_version=ImprintValue(value:1.0, ts:1500002097622, guid:a6fb7b0f63209f55ac898108b217f8f80410c95a), install_channel=ImprintValue(value:Umeng, ts:1500002097622, guid:a6fb7b0fd7018c80b8fe1c7feba0b69b837ad559), app_version=ImprintValue(value:1.0, ts:1500002097622, guid:a6fb7b0f40dec5019156ecb60451116c16dbd0e1), install_datetime=ImprintValue(value:2017-07-09 11:32:46, ts:1500002097622, guid:a6fb7b0ffbf3432955873651e940cbec69d1b1d7), os_version=ImprintValue(value:4.4.2, ts:1500002097622, guid:a6fb7b0fdcbb15c6d7052cba29fdd3c95532fbb3), v=ImprintValue(value:5-5-5, ts:1500002097622, guid:a6fb7b0f00fb1a38d36116462524af936ed20430), jitter=ImprintValue(value:108568, ts:1500002097622, guid:a6fb7b0f6aeacada7ba8bac7b9fd8ca707a5e0b0), channel=ImprintValue(value:Umeng, ts:1500002097622, guid:a6fb7b0fe69e6a97329d61e1a073f55072f4fc57), umid=ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1500002097622, guid:a6fb7b0f27f0dc3701bb3f0157824d6892fa08f8)}, version:1, checksum:c0897e72476fe12f106060e606d268a4)
     * 等同于 如下
     *
     0 = "pretime" -> "ImprintValue(value:1500002097622, ts:1500002097622, guid:a6fb7b0fd2d8ebcca7fd28f3d4c25dc033728665)"
     1 = "install_app_version" -> "ImprintValue(value:1.0, ts:1500002097622, guid:a6fb7b0f63209f55ac898108b217f8f80410c95a)"
     2 = "install_channel" -> "ImprintValue(value:Umeng, ts:1500002097622, guid:a6fb7b0fd7018c80b8fe1c7feba0b69b837ad559)"
     3 = "app_version" -> "ImprintValue(value:1.0, ts:1500002097622, guid:a6fb7b0f40dec5019156ecb60451116c16dbd0e1)"
     4 = "install_datetime" -> "ImprintValue(value:2017-07-09 11:32:46, ts:1500002097622, guid:a6fb7b0ffbf3432955873651e940cbec69d1b1d7)"
     5 = "os_version" -> "ImprintValue(value:4.4.2, ts:1500002097622, guid:a6fb7b0fdcbb15c6d7052cba29fdd3c95532fbb3)"
     6 = "v" -> "ImprintValue(value:5-5-5, ts:1500002097622, guid:a6fb7b0f00fb1a38d36116462524af936ed20430)"
     7 = "jitter" -> "ImprintValue(value:108568, ts:1500002097622, guid:a6fb7b0f6aeacada7ba8bac7b9fd8ca707a5e0b0)"
     8 = "channel" -> "ImprintValue(value:Umeng, ts:1500002097622, guid:a6fb7b0fe69e6a97329d61e1a073f55072f4fc57)"
     9 = "umid" -> "ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1500002097622, guid:a6fb7b0f27f0dc3701bb3f0157824d6892fa08f8)"
     */

    //第一次请求回包 保存imprint
    @Test
    public void testResponse() throws Exception{

        String content="{\"body\":{\"activate_msg\":{\"ts\":1499891764064}},\"header\":{\"failed_requests\":0,\"access_subtype\":\"LTE\",\"appkey\":\"596087883eae2574b10013a3\",\"app_version\":\"1.0\",\"resolution\":\"1794*1080\",\"version_code\":1,\"device_model\":\"Android SDK built for x86\",\"timezone\":-5,\"device_name\":\"generic_x86\",\"req_time\":0,\"carrier\":\"Android\",\"successful_requests\":0,\"device_board\":\"unknown\",\"vertical_type\":0,\"device_manufacturer\":\"unknown\",\"id_tracking\":\"GwOMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxa+vaGIp1cVAgAFaWRtZDUYHjUyODQ0N2Y0\\nZmZiNGU0ODI0YTJmZDFkMWYwY2Q2MhbKvaGIp1cVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFsS9\\noYinVxUCABk8GAphbmRyb2lkX2lkKA9mNTk5YmYwODc1YmEwNzMWvr2hiKdXABgEaW1laSgPMDAw\\nMDAwMDAwMDAwMDAwFsS9oYinVwAYBWlkbWQ1KB41Mjg0NDdmNGZmYjRlNDgyNGEyZmQxZDFmMGNk\\nNjIWyr2hiKdXAAA=\\n\",\"os\":\"Android\",\"app_signature\":\"BE:B9:05:B4:5D:71:55:8F:7F:70:3E:D1:A9:56:AD:94\",\"cpu\":\"0\",\"package_name\":\"com.umeng.example\",\"sdk_version\":\"6.1.1\",\"device_id\":\"000000000000000\",\"device_brand\":\"generic_x86\",\"access\":\"2G\\/3G\",\"country\":\"US\",\"os_version\":\"4.4.2\",\"idmd5\":\"528447f4ffb4e4824a2fd1d1f0cd62\",\"display_name\":\"UMENG SDK\",\"sdk_type\":\"Android\",\"device_manuid\":\"KK\",\"mccmnc\":\"310260\",\"language\":\"en\",\"channel\":\"Umeng\",\"device_manutime\":1478741905000}}";
        byte[] var1 = aa.a(mActivity, "596087883eae2574b10013a3", String.valueOf(content).getBytes()).c();

        HttpURLConnection var3 = (HttpURLConnection)(new URL("http://alog.umeng.com/app_logs")).openConnection();
        var3.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
        String xumengsdk = "Android/6.1.1 UMENG+SDK%2F1.0+Android+SDK+built+for+x86%2F4.4.2+B604C2E005AC2ABE39983E8847E63607";
        var3.setRequestProperty("X-Umeng-Sdk", xumengsdk);
        var3.setRequestProperty("Msg-Type", "envelope/json");
        var3.setRequestProperty("Content-Type", "envelope/json");
        var3.setConnectTimeout(10000);
        var3.setReadTimeout(30000);
        var3.setRequestMethod("POST");
        var3.setDoOutput(true);
        var3.setDoInput(true);
        var3.setUseCaches(false);
        if(Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }

        OutputStream var21 = var3.getOutputStream();
        var21.write(var1);
        var21.flush();
        var21.close();

        int var22 = var3.getResponseCode();
        String var6 = var3.getHeaderField("Content-Type");
        boolean var7 = false;
        if(!TextUtils.isEmpty(var6) && var6.equalsIgnoreCase("application/thrift")) {
            var7 = true;
        }
        InputStream var8 = var3.getInputStream();
        byte[] var9 = bw.b(var8);//读取到了 回包的数据包

//以下代码对应 bc.class 下面的 private int a(byte[] var1) {
        com.umeng.analytics.pro.bp var11 = new bp();//bp.m 数组 MSG 和 imprint
        com.umeng.analytics.pro.cj var33 = new com.umeng.analytics.pro.cj(new com.umeng.analytics.pro.cy.a());
//以下代码对应 cj.class中的  public void a(cg var1, byte[] var2) throws cm {

        var33.a(var11, var9); //就能拿到 imprint 文件和代码了
        af e = af.a(mActivity);
        if(var11.a==1){
            e.b(var11.i());
            e.d();//保留的
        }
        by.c("send log:" + var11.f());//保存 到 .imprint文件中 成功

/*

//对如下分析
// var33.b = b;下面
// var33.a == new cy.a().a(b) 下面的
        ds b = new ds();
        b.a(var9); // ds是保存回包数据的(a byte内容 c长度)  ds类中的 a(byte[] var1) 方法 将保存回包数据

        var11.a(new cy.a().a(b));

//bp.class下面 public void a(df var1) throws cm {
        df var12=new cy.a().a(b); //实现是cy  df 是 cy的父类  new cy.a().a(new ds())

//((do)j.get(var1.D())).b().b(var1, this); 翻译
// var1.D()  等于 类 dp.class
//j.get(dp.class).b().b(var1,this)
        j.get(var12.D())
*/

    }
}
