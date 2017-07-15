package com.umeng.example.analytics;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/15.
 */

public class RequestStorageCompareTest {


    private Activity mActivity;

    @Rule
    public ActivityTestRule<MainActivity> mTasksActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class){
                @Override
                protected void beforeActivityLaunched() {
                    super.beforeActivityLaunched();
                    mActivity = mTasksActivityTestRule.getActivity();
                }
            };
    @Test
    public void clickAddTaskButton_opensAddTaskUi() {
        // Click on the add task button
        System.out.print(233);
    }
/**
 * 第一次启动的时候
 * e = {bn@831565959120} "Imprint(property:{pretime=ImprintValue(value:1500011500358, ts:1500011500359, guid:3771cb0fd59716fefd598fdfe27e266f00d4e2bd), install_app_version=ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fbeb96d113f41c258368d99db64f79b7d), install_channel=ImprintValue(value:Umeng, ts:1500011500359, guid:3771cb0f74f2858e3cce7dcb2d53178c257d75a2), app_version=ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fea19e582fa53c4b013b52a4e563ddb14), install_datetime=ImprintValue(value:2017-07-09 11:32:46, ts:1500011500359, guid:3771cb0f23e81a62844162aa4c2ba4b4e2d902d4), os_version=ImprintValue(value:4.4.2, ts:1500011500359, guid:3771cb0f7285e8cb6b0909899b571ce5c84a4f43), v=ImprintValue(value:5-5-5, ts:1500011500359, guid:3771cb0f0d1a52e330fd3ede49715737acf327b4), jitter=ImprintValue(value:114423, ts:1500011500359, guid:3771cb0f2549c190cb877f220fb986019c34afcd), channel=ImprintValue(value:Umeng, ts:1500011500358, guid:3671cb0fc42af81d788eab38a1df28179bdb9331), umid=ImprintValue(value:aif8f9a71d"
 a = {HashMap@831565993984}  size = 10
 0 = {HashMap$HashMapEntry@831566813744} "pretime" -> "ImprintValue(value:1500011500358, ts:1500011500359, guid:3771cb0fd59716fefd598fdfe27e266f00d4e2bd)"
 1 = {HashMap$HashMapEntry@831566234576} "install_app_version" -> "ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fbeb96d113f41c258368d99db64f79b7d)"
 2 = {HashMap$HashMapEntry@831566814224} "install_channel" -> "ImprintValue(value:Umeng, ts:1500011500359, guid:3771cb0f74f2858e3cce7dcb2d53178c257d75a2)"
 3 = {HashMap$HashMapEntry@831566814688} "app_version" -> "ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fea19e582fa53c4b013b52a4e563ddb14)"
 4 = {HashMap$HashMapEntry@831566363640} "install_datetime" -> "ImprintValue(value:2017-07-09 11:32:46, ts:1500011500359, guid:3771cb0f23e81a62844162aa4c2ba4b4e2d902d4)"
 5 = {HashMap$HashMapEntry@831566235512} "os_version" -> "ImprintValue(value:4.4.2, ts:1500011500359, guid:3771cb0f7285e8cb6b0909899b571ce5c84a4f43)"
 6 = {HashMap$HashMapEntry@831566235968} "v" -> "ImprintValue(value:5-5-5, ts:1500011500359, guid:3771cb0f0d1a52e330fd3ede49715737acf327b4)"
 7 = {HashMap$HashMapEntry@831566235040} "jitter" -> "ImprintValue(value:114423, ts:1500011500359, guid:3771cb0f2549c190cb877f220fb986019c34afcd)"
 8 = {HashMap$HashMapEntry@831566234096} "channel" -> "ImprintValue(value:Umeng, ts:1500011500358, guid:3671cb0fc42af81d788eab38a1df28179bdb9331)"
 9 = {HashMap$HashMapEntry@831566364152} "umid" -> "ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1500011500359, guid:3771cb0f8a34d6d5733eb743e2858f1d2dac9129)"
 c = "117b02e2dcbad28df059aeb70350888d"
 */


/**
 * 执行了一次 onresume之后的情况
 * result = {bn@831565885904} "Imprint(property:{pretime=ImprintValue(value:1500011500358, ts:1500011500359, guid:3771cb0fd59716fefd598fdfe27e266f00d4e2bd), install_app_version=ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fbeb96d113f41c258368d99db64f79b7d), install_channel=ImprintValue(value:Umeng, ts:1500011500359, guid:3771cb0f74f2858e3cce7dcb2d53178c257d75a2), app_version=ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fea19e582fa53c4b013b52a4e563ddb14), install_datetime=ImprintValue(value:2017-07-09 11:32:46, ts:1500011500359, guid:3771cb0f23e81a62844162aa4c2ba4b4e2d902d4), os_version=ImprintValue(value:4.4.2, ts:1500011500359, guid:3771cb0f7285e8cb6b0909899b571ce5c84a4f43), v=ImprintValue(value:5-5-5, ts:1500011500359, guid:3771cb0f0d1a52e330fd3ede49715737acf327b4), jitter=ImprintValue(value:114423, ts:1500011500359, guid:3771cb0f2549c190cb877f220fb986019c34afcd), umid=ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1500011500359, guid:3771cb0f8a34d6d5733eb743e2858f1d2dac9129), channel="
 a = {HashMap@831565939056}  size = 10
 0 = {HashMap$HashMapEntry@831565940832} "pretime" -> "ImprintValue(value:1500011500358, ts:1500011500359, guid:3771cb0fd59716fefd598fdfe27e266f00d4e2bd)"
 1 = {HashMap$HashMapEntry@831565944168} "install_app_version" -> "ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fbeb96d113f41c258368d99db64f79b7d)"
 2 = {HashMap$HashMapEntry@831565945488} "install_channel" -> "ImprintValue(value:Umeng, ts:1500011500359, guid:3771cb0f74f2858e3cce7dcb2d53178c257d75a2)"
 3 = {HashMap$HashMapEntry@831565946504} "app_version" -> "ImprintValue(value:1.0, ts:1500011500359, guid:3771cb0fea19e582fa53c4b013b52a4e563ddb14)"
 4 = {HashMap$HashMapEntry@831565947272} "install_datetime" -> "ImprintValue(value:2017-07-09 11:32:46, ts:1500011500359, guid:3771cb0f23e81a62844162aa4c2ba4b4e2d902d4)"
 5 = {HashMap$HashMapEntry@831565948296} "os_version" -> "ImprintValue(value:4.4.2, ts:1500011500359, guid:3771cb0f7285e8cb6b0909899b571ce5c84a4f43)"
 6 = {HashMap$HashMapEntry@831565949880} "v" -> "ImprintValue(value:5-5-5, ts:1500011500359, guid:3771cb0f0d1a52e330fd3ede49715737acf327b4)"
 7 = {HashMap$HashMapEntry@831565950896} "jitter" -> "ImprintValue(value:114423, ts:1500011500359, guid:3771cb0f2549c190cb877f220fb986019c34afcd)"
 8 = {HashMap$HashMapEntry@831565952688} "umid" -> "ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1500011500359, guid:3771cb0f8a34d6d5733eb743e2858f1d2dac9129)"
 9 = {HashMap$HashMapEntry@831565951624} "channel" -> "ImprintValue(value:Umeng, ts:1500011500358, guid:3671cb0fc42af81d788eab38a1df28179bdb9331)"
 c = "117b02e2dcbad28df059aeb70350888d"
 */



    /**
     * 未操作的时候
     * {"body":{"activate_msg":{"ts":1500097548650}},"header":{"failed_requests":0,"appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1184*720","version_code":1,"device_model":"HUAWEI C199","timezone":8,"device_name":"hwC199","mc":"24:09:95:eb:67:78","req_time":0,"carrier":"中国电信","successful_requests":0,"device_board":"C199","vertical_type":0,"device_manufacturer":"HUAWEI","id_tracking":"GwWMCmFuZHJvaWRfaWQYEDQxMWNmNmJiMGJmZjZhOGYWltvQzKhXFQIAA21hYxgRMjQ6MDk6OTU6\nZWI6Njc6NzgWjNvQzKhXFQIABnNlcmlhbBgMMjQwOTk1ZWI3NzE4Fpza0MyoVxUCAARpbWVpGA5B\nMDAwMDA0RkYyNEQxOBaA29DMqFcVAgAFaWRtZDUYIGNlOWNkZTcyOTg3ZjM5YjZjYzg1Mzc3OWQ5\nNWUxZTdkFtja0MyoVxUCABlcGAZzZXJpYWwoDDI0MDk5NWViNzcxOBac2tDMqFcAGAVpZG1kNSgg\nY2U5Y2RlNzI5ODdmMzliNmNjODUzNzc5ZDk1ZTFlN2QW2NrQzKhXABgEaW1laSgOQTAwMDAwNEZG\nMjREMTgWgNvQzKhXABgDbWFjKBEyNDowOTo5NTplYjo2Nzo3OBaM29DMqFcAGAphbmRyb2lkX2lk\nKBA0MTFjZjZiYjBiZmY2YThmFpbb0MyoVwAA\n","os":"Android","app_signature":"A8:85:FE:29:16:07:F8:12:EE:78:15:A2:0F:F3:49:6A","cpu":"ARMv7 Processor rev 3 (v7l)","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"A000004FF24D18","device_brand":"Huawei","access":"wifi","country":"CN","os_version":"4.4.2","idmd5":"ce9cde72987f39b6cc853779d95e1e7d","display_name":"友盟SDK","sdk_type":"Android","device_manuid":"HuaweiC199","mccmnc":"46003","language":"zh","channel":"Umeng","device_manutime":1422528853000}}
     */

    /**
     * 点击一次 open_new_page页面的时候
     * {"body":{"sessions":[{"id":"E559C567A13B5D1E4A90634C8DC73CB7","end_time":"1500097547767","start_time":"1500097547556","duration":211}]},"header":{"failed_requests":0,"appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1184*720","version_code":1,"device_model":"HUAWEI C199","timezone":8,"device_name":"hwC199","mc":"24:09:95:eb:67:78","imprint":"GwqMB3ByZXRpbWUYDTE1MDAwOTc3MTQ3NDMW7ujUzKhXGCg0N2Y4YTY3NDExYzYwZWRiNjdjM2Vj\nODlmYmFhZWI4NDNiZmU0YzY0ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW7ujUzKhXGCg0N2Y4\nYTY3NGFlODE3YmQ0MmIwN2RiNWZhMzA3NTRhMWY0MWY4NWFiAA9pbnN0YWxsX2NoYW5uZWwYBVVt\nZW5nFu7o1MyoVxgoNDdmOGE2NzQ4YjgyNmQ1N2M0ZGM0MGIxZTMwN2QzMmE1Zjc0ODFhNQALYXBw\nX3ZlcnNpb24YAzEuMBbu6NTMqFcYKDQ3ZjhhNjc0ZTQwOGRjY2RlMjFlMDNjZWJiMjc1MTJjMjE0\nNTJjMzgAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTI6NTc6NDUW7ujUzKhXGCg0N2Y4\nYTY3NGQwZGZmNzlhMDM4NWJhYTlmYmYzMTZlNjk5MzNiNTEwAApvc192ZXJzaW9uGAU0LjQuMhbu\n6NTMqFcYKDQ3ZjhhNjc0NzBlZDVlZWI5ZWY3OTVjYzRjZGZhMGU4ZDM3ZGMyYTIAAXYYBTUtNS01\nFu7o1MyoVxgoNDdmOGE2NzRlZWY0MzY5YWY5MGFkNjYxNjYwMTU4Yzk2Yzk5Y2NmOQAGaml0dGVy\nGAEwFu7o1MyoVxgoNDdmOGE2NzQwNmQyNDRmYTk0NzdlMWRkN2IwMWM0MjAzY2E1MzgzMgAHY2hh\nbm5lbBgFVW1lbmcW7ujUzKhXGCg0N2Y4YTY3NDY2MGY4OGJiNzRmZmU1NjA3ODAwODJiMDY4M2Q5\nNGNhAAR1bWlkGCBjZTljZGU3Mjk4N2YzOWI2Y2M4NTM3NzlkOTVlMWU3ZBbu6NTMqFcYKDQ3Zjhh\nNjc0MTlkNTEwMjg2ODIwZjA1NjNjMTY2OTg3ODFjNDQyYWUAFQIYIDU5ZWNlZDdlMDQ1OTVmNTli\nNTY3Yzc2NjU3ZjI0MjJlAA==\n","req_time":720,"carrier":"中国电信","successful_requests":1,"device_board":"C199","vertical_type":0,"device_manufacturer":"HUAWEI","id_tracking":"GwWMCmFuZHJvaWRfaWQYEDQxMWNmNmJiMGJmZjZhOGYWltvQzKhXFQIAA21hYxgRMjQ6MDk6OTU6\nZWI6Njc6NzgWjNvQzKhXFQIABnNlcmlhbBgMMjQwOTk1ZWI3NzE4Fpza0MyoVxUCAARpbWVpGA5B\nMDAwMDA0RkYyNEQxOBaA29DMqFcVAgAFaWRtZDUYIGNlOWNkZTcyOTg3ZjM5YjZjYzg1Mzc3OWQ5\nNWUxZTdkFtja0MyoVxUCAAA=\n","os":"Android","app_signature":"A8:85:FE:29:16:07:F8:12:EE:78:15:A2:0F:F3:49:6A","cpu":"ARMv7 Processor rev 3 (v7l)","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"A000004FF24D18","device_brand":"Huawei","access":"wifi","country":"CN","os_version":"4.4.2","idmd5":"ce9cde72987f39b6cc853779d95e1e7d","display_name":"友盟SDK","sdk_type":"Android","device_manuid":"HuaweiC199","mccmnc":"46003","language":"zh","channel":"Umeng","device_manutime":1422528853000}}
     */

    /**
     * 点击n次 MY_EVENT_ID事件的数据
     * {"body":{"ekv":[{"6C7F57FBEE49702C870E91415107AF82":[{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097966553,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097966585,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097966593,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097967753,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097968188,"MY_EVENT_ID":""}]}],"sessions":[{"id":"6C7F57FBEE49702C870E91415107AF82","end_time":"1500097847996","start_time":"1500097847869","duration":127}]},"header":{"failed_requests":0,"appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1184*720","version_code":1,"device_model":"HUAWEI C199","timezone":8,"device_name":"hwC199","mc":"24:09:95:eb:67:78","imprint":"GwqMB3ByZXRpbWUYDTE1MDAwOTc5NjAzNzQW7ObyzKhXGChjNjNiYTI3NDQ2ZjBhMmU5OGQ1YmNm\nNzIzMjJjMGFjMWIwNjE4MmU4ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW7ujUzKhXGCg0N2Y4\nYTY3NGFlODE3YmQ0MmIwN2RiNWZhMzA3NTRhMWY0MWY4NWFiAA9pbnN0YWxsX2NoYW5uZWwYBVVt\nZW5nFu7o1MyoVxgoNDdmOGE2NzQ4YjgyNmQ1N2M0ZGM0MGIxZTMwN2QzMmE1Zjc0ODFhNQALYXBw\nX3ZlcnNpb24YAzEuMBbu6NTMqFcYKDQ3ZjhhNjc0ZTQwOGRjY2RlMjFlMDNjZWJiMjc1MTJjMjE0\nNTJjMzgAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTI6NTc6NDUW7ujUzKhXGCg0N2Y4\nYTY3NGQwZGZmNzlhMDM4NWJhYTlmYmYzMTZlNjk5MzNiNTEwAApvc192ZXJzaW9uGAU0LjQuMhbu\n6NTMqFcYKDQ3ZjhhNjc0NzBlZDVlZWI5ZWY3OTVjYzRjZGZhMGU4ZDM3ZGMyYTIAAXYYBTUtNS01\nFu7o1MyoVxgoNDdmOGE2NzRlZWY0MzY5YWY5MGFkNjYxNjYwMTU4Yzk2Yzk5Y2NmOQAGaml0dGVy\nGAEwFu7o1MyoVxgoNDdmOGE2NzQwNmQyNDRmYTk0NzdlMWRkN2IwMWM0MjAzY2E1MzgzMgAHY2hh\nbm5lbBgFVW1lbmcW7ujUzKhXGCg0N2Y4YTY3NDY2MGY4OGJiNzRmZmU1NjA3ODAwODJiMDY4M2Q5\nNGNhAAR1bWlkGCBjZTljZGU3Mjk4N2YzOWI2Y2M4NTM3NzlkOTVlMWU3ZBbu6NTMqFcYKDQ3Zjhh\nNjc0MTlkNTEwMjg2ODIwZjA1NjNjMTY2OTg3ODFjNDQyYWUAFQIYIGZiNTdkNzU4ZWRlZWIyODlk\nYmZkOTdjYTI1ZGFkM2MxAA==\n","req_time":84,"carrier":"中国电信","successful_requests":2,"device_board":"C199","vertical_type":0,"device_manufacturer":"HUAWEI","id_tracking":"GwWMCmFuZHJvaWRfaWQYEDQxMWNmNmJiMGJmZjZhOGYWltvQzKhXFQIAA21hYxgRMjQ6MDk6OTU6\nZWI6Njc6NzgWjNvQzKhXFQIABnNlcmlhbBgMMjQwOTk1ZWI3NzE4Fpza0MyoVxUCAARpbWVpGA5B\nMDAwMDA0RkYyNEQxOBaA29DMqFcVAgAFaWRtZDUYIGNlOWNkZTcyOTg3ZjM5YjZjYzg1Mzc3OWQ5\nNWUxZTdkFtja0MyoVxUCAAA=\n","os":"Android","app_signature":"A8:85:FE:29:16:07:F8:12:EE:78:15:A2:0F:F3:49:6A","cpu":"ARMv7 Processor rev 3 (v7l)","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"A000004FF24D18","device_brand":"Huawei","access":"wifi","country":"CN","os_version":"4.4.2","idmd5":"ce9cde72987f39b6cc853779d95e1e7d","display_name":"友盟SDK","sdk_type":"Android","device_manuid":"HuaweiC199","mccmnc":"46003","language":"zh","channel":"Umeng","device_manutime":1422528853000}}
     */
}
