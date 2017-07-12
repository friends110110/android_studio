package com.umeng.example.analytics;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Base64;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;

/**
 * Created by friends on 2017/7/10.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class Base64Test {
    @Rule
    public ActivityTestRule<MainActivity> mTasksActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);
        @Test
        public void clickAddTaskButton_opensAddTaskUi() {
            // Click on the add task button
            System.out.print(233);
        }
        @Test
        public void testBase64Imprint(){
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            byteArrayOutputStream.reset();

//            String encode = Base64.encodeToString("", 0);
//            Base64.decode(encode,0);
        }
        @Test
        public void testBaseDecodeImprint(){
            String encode = "GwuMB3ByZXRpbWUYDTE0OTk3NjQ1MzI0MTYWgJP1jqZXGChiMGM2ODIwMDdmMTkyMTFkMDUzYmU2 NzE4OWIwZDFmMWViM2RmMTMxAAZsYXRlbnQYATMW/OCw1qRXGCg0ZTdhMGExNWE3MmVkMzkxOGUy ZDc5MjhiM2E4YTMzOGQ1YjJmNjU0ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW/OCw1qRXGCg0 ZTdhMGExNTBjZTc2OTUyYzY4OGVmY2VmMWFkYjRmZTc4YzAyOTI0AA9pbnN0YWxsX2NoYW5uZWwY BVVtZW5nFvzgsNakVxgoNGU3YTBhMTUwODUwYWRjM2FjYTIyMzhmOTg3NzFmYWM0NDRkMGUyYwAL YXBwX3ZlcnNpb24YAzEuMBaAk/WOplcYKGIwYzY4MjAwZmIyOWJhNDAzN2I1NGI3NmI3MTllNjg0 YTkzMjBkNzEAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTE6MzA6MzQW/OCw1qRXGCg0 ZTdhMGExNTgxNzFjNGUxYWYzZDBkNGM4M2NjMTZhNzE3OGNjZTM5AApvc192ZXJzaW9uGAU0LjQu MhaAk/WOplcYKGIwYzY4MjAwYWZiMzRiOGJkMjU2YWJmOWIxZDhmZjBkNDgyYjFkOWUAAXYYBTUt NS01FoCT9Y6mVxgoYjBjNjgyMDA4NmE0ZWQ3ZmNkNDg2OWRjYWQyNjY3NTk5NGQxZmY4ZQAGaml0 dGVyGAExFoCT9Y6mVxgoYjBjNjgyMDBjNTgyOThkNGZlMjIxYTI5ZmYwYTI3NjVjYTNiZTBlMQAH Y2hhbm5lbBgFVW1lbmcWgJP1jqZXGChiMGM2ODIwMDczYzBkZDY4MDgyZjkyNTJkZWM4YTRjYmY3 YjFiM2YzAAR1bWlkGCJhaWY4ZjlhNzFkYWE1ZmM3YTRiNWU3ZWVjMmI0MjM2MWRlFoCT9Y6mVxgo YjBjNjgyMDBkOTk2MWYzMDk2ZmEwYTcwODMwMWUzYjRjYzc0MjkzYgAVAhggYzYyMDlkNzY3YjQx MTc2ZTE1MGY0Zjg5ZWQxYjJiNmMA ";
            Base64.decode(encode,0);
        }

        @Test
    public void testBase64IdTracking(){
            String encode = "GwSMCmFuZHJvaWRfaWQYD2Y1OTliZjA4NzViYTA3Mxbe5piaolcVAgAFdXRkaWQYGFdWeVVQem40 WFZBREFKd2NsakM3bHhURBbc5piaolcVAgAEaW1laRgPMDAwMDAwMDAwMDAwMDAwFuzlmJqiVxUC AAVpZG1kNRgeNTI4NDQ3ZjRmZmI0ZTQ4MjRhMmZkMWQxZjBjZDYyFujlmJqiVxUCABkMAA== ";
            Base64.decode(encode,0);
        }
    }
