package com.umeng.example.analytics;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Base64;
import com.umeng.analytics.pro.*;
import com.umeng.example.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;

/**
 * Created by friends on 2017/7/10.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ImprintTest {
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

    /**
     * 从 data目录下 取出的 .imprint文件的内容
     * @throws Exception
     */
    @Test
        public void testFetchImprint() throws Exception{
            String str = new String(bw.b(mActivity.openFileInput(".imprint")));
            System.out.println(str);


        /**
         * af c()
         */
        byte var3[]=bw.b(mActivity.openFileInput(".imprint"));
            bn var4 = new bn();
            (new cj()).a(var4, var3);
            var4.d().get("codex").c();

//        this.a = this.a(var1, "defcon");
//        this.b = this.a(var1, "latent");
//        this.c = this.a(var1, "codex");
//        this.d = this.a(var1, "report_policy");
//        this.e = this.a(var1, "report_interval");
//        this.f = this.b(var1, "client_test");
//        this.g = this.a(var1, "test_report_interval");
//        this.h = this.b(var1, "umid");
//        this.i = this.a(var1, "integrated_test");
//        this.j = this.a(var1, "latent_hours");
//        this.k = this.b(var1, "country");
//        this.l = this.b(var1, "domain_p");
//        this.m = this.b(var1, "domain_s");
//        this.n = this.b(var1, "initial_view_time");
//        this.o = this.b(var1, "track_list");

        /**
         *   bp.class 中 static
         *   j.put(dp.class, new bp.b());
             j.put(dq.class, new bp.d());
             EnumMap var0 = new EnumMap(bp.e.class);
             var0.put(bp.e.a, new cs("resp_code", 1, new ct(8)));
             var0.put(bp.e.b, new cs("msg", 2, new ct(11)));
         var0.put(bp.e.c, new cs("imprint", 2, new cx(12, bn.class)));
         d = Collections.unmodifiableMap(var0);
         cs.a(bp.class, d);

         */
    }

    /**
     * 好好研究下
     * af d() 将生成 imprint文件内容
     */
    @Test
    public void testWriteImprintTofile(){
        String str = "Imprint(property:{pretime=ImprintValue(value:1499935296795, ts:1499935296795, guid:6b2f700b6b50fb48fb31e9780a1f02e645f87cd2), install_app_version=ImprintValue(value:1.0, ts:1499935296796, guid:6c2f700b913b18a0e9161e49ffd89ebd95911580), install_channel=ImprintValue(value:Umeng, ts:1499935296796, guid:6c2f700bce7093e4e11c17f56394fdc9dcf95288), app_version=ImprintValue(value:1.0, ts:1499935296795, guid:6b2f700b05815bd45ac01e1cdb1a07a989cfda09), install_datetime=ImprintValue(value:2017-07-09 11:32:46, ts:1499935296796, guid:6c2f700b749635746461ec303ef9fc3c9f6a63e4), os_version=ImprintValue(value:4.4.2, ts:1499935296795, guid:6b2f700bc1c2630e23f03825d92ea0e91dbc3396), v=ImprintValue(value:5-5-5, ts:1499935296796, guid:6c2f700b16305c9a7ecbcaf3dad5a9545caccb8d), jitter=ImprintValue(value:56826, ts:1499935296795, guid:6b2f700b885651b7116807b513dd9bdba4ac33d8), channel=ImprintValue(value:Umeng, ts:1499935296795, guid:6b2f700be9eda3aff03e00a3a6a0e37637e89fea), umid=ImprintValue(value:aif8f9a71daa5fc7a4b5e7eec2b42361de, ts:1499935296795, guid:6b2f700b0e51a564c4e24a8de5609a18e33e38a1)}, version:1, checksum:a38792124398221335b5b87091d8f981)";
        HashMap <String,bo> map =new HashMap<>();//str map->map
        bn e=new bn(map,1,"a38792124398221335b5b87091d8f981");

        if(e != null) {
            try {
                byte[] var1 = (new cp()).a(e);
                bw.a(new File(mActivity.getFilesDir(), ".imprint"), var1);
            } catch (Exception var2) {
                var2.printStackTrace();
            }

        }

    }

    /**
     * af专门对于 imprint操作的单例类
     * 发送请求给后台时候
     * 1.先从 文件 .imprint 读取 信息
     * 2. 组装字节码发送
     * 从文件中 读取 .imprint 内容
     * @throws Exception
     */
    @Test
    public void testReadFromImprint() throws Exception{
        af f = af.a(mActivity);
        byte[] var3 = bw.b(mActivity.openFileInput(".imprint"));
        bn var4 = new bn();
        cj ccj = new cj();
        ccj.a(var4,var3);
        bn e = var4;
        af.a d =  f.b();//内部类对象 通过 该方法返回  漏洞
        d.a(var4);
        System.out.println(e);//为结果

//        af f = af.a(mActivity);
//        bn b = f.a();//查看信息、

        //组装成 imprint json 段 内容 发包用
        bn var18 = af.a(mActivity).a();
        if(var18 != null) {
            byte[] var19 = (new cp()).a(var18);
//            var10.put("imprint", Base64.encodeToString(var19, 0));
            Base64.encodeToString(var19, 0);//组装用于发包用
        }
    }

    }
