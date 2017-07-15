package com.umeng.example.analytics;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by friends on 2017/7/10.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CompareImprintTestUtils {
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




}
