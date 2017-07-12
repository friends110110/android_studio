package com.umeng.example.analytics;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.bv;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
