package com.umeng.example.analytics;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgent.EScenarioType;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import com.umeng.analytics.social.UMPlatformData.UMedia;
import com.umeng.example.MainActivity;
import com.umeng.example.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsHome extends Activity {
    private Context mContext;
    private final String mPageName = "AnalyticsHome";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.umeng_example_analytics);

        mContext = this;
        MobclickAgent.setDebugMode(true);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
        MobclickAgent.openActivityDurationTrack(false);
        // MobclickAgent.setAutoLocation(true);
        // MobclickAgent.setSessionContinueMillis(1000);
//         MobclickAgent.startWithConfigure(
//         new MobclickAgent.UMAnalyticsConfig(mContext, "596087883eae2574b10013a3", "Umeng",
//         EScenarioType.E_UM_NORMAL));
        MobclickAgent.setScenarioType(mContext, EScenarioType.E_UM_NORMAL);

        //加密开启
        MobclickAgent.enableEncrypt(true);
    }


    @Override
    public void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(mPageName);//往preferenceshare 放入 key val值
//        MobclickAgent.onResume(mContext);

//        AnalyticsHomeTest home = new AnalyticsHomeTest(this);
//        try {
//            home.requestUmeng();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * open new page  放到 bf的map里面
     * onevent 放到aq的map里面
     * b.b()
     * 把操作记录放在数据库中
     */
    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd(mPageName);
        MobclickAgent.onPause(mContext);

    }

    /**
     * android:onClick="onButtonClick"
     *
     * @param view
     */
    public void onButtonClick(View view) {
        int id = view.getId();
        switch (id) {
        case R.id.umeng_example_analytics_event_cc:
            List<String> keyPath = new ArrayList<String>();
            keyPath.add("one");
            keyPath.add("two");
            keyPath.add("tree");
            MobclickAgent.onEvent(mContext, keyPath, 20, "label");
            break;
        case R.id.umeng_example_analytics_event:
            MobclickAgent.onEvent(mContext, "click");
            MobclickAgent.onEvent(mContext, "click", "button");
            break;
        case R.id.umeng_example_analytics_ekv:
            Map<String, String> map_ekv = new HashMap<String, String>();
            map_ekv.put("type", "popular");
            map_ekv.put("artist", "JJLin");

            MobclickAgent.onEvent(mContext, "music", map_ekv);
            break;
        case R.id.umeng_example_analytics_duration:

            Map<String, String> map_value = new HashMap<String, String>();
            map_value.put("type", "popular");
            map_value.put("artist", "JJLin");

            MobclickAgent.onEventValue(this, "music", map_value, 12000);
            break;
        case R.id.umeng_example_analytics_make_crash:
            "123".substring(10);
            break;
        case R.id.umeng_example_analytics_js_analytic:
            startActivity(new Intent(this, WebviewAnalytic.class));
            break;
        case R.id.umeng_example_analytics_fragment_stack:
            startActivity(new Intent(this, FragmentStack.class));
            break;
        case R.id.umeng_example_analytics_fragment_tabs:
            startActivity(new Intent(this, FragmentTabs.class));
            break;
        case R.id.umeng_example_analytics_social:

            UMPlatformData platform = new UMPlatformData(UMedia.SINA_WEIBO, "user_id");
            platform.setGender(GENDER.MALE); // optional
            platform.setWeiboId("weiboId"); // optional

            MobclickAgent.onSocialEvent(this, platform);
            break;
        case R.id.umeng_example_analytics_signin:
            MobclickAgent.onProfileSignIn("example_id");
            break;

        case R.id.umeng_example_analytics_signoff:
            MobclickAgent.onProfileSignOff();
            break;
        case R.id.umeng_example_analytics_click_onresume:
            MobclickAgent.onResume(this);
            /**
             * 里面有个时间戳的，必须等 onpause调用了一次 才能再调用onresume
             * bd 类下
             * private boolean b(SharedPreferences var1)
             */
//            MobclickAgent.onPause(this);
            break;
        case R.id.umeng_example_click_open_new_page:
            MobclickAgent.onPageStart("open_this_page");
            break;
        case R.id.umeng_example_click_count_event:
            MobclickAgent.onEvent(this,"MY_EVENT_ID");
            break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Hook();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    // /对于好多应用，会在程序中杀死 进程，这样会导致我们统计不到此时Activity结束的信息，
    // /对于这种情况需要调用 'MobclickAgent.onKillProcess( Context )'
    // /方法，保存一些页面调用的数据。正常的应用是不需要调用此方法的。
    private void Hook() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setPositiveButton("退出应用", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                MobclickAgent.onKillProcess(mContext);

                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
            }
        });
        builder.setNeutralButton("后退一下", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
//                finish();
//                onPause();
                Intent intent = new Intent();
                intent.setClass(AnalyticsHome.this, MainActivity.class);
                AnalyticsHome.this.startActivity(intent);
            }
        });
        builder.setNegativeButton("点错了", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder.show();
    }
}