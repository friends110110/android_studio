package com.umeng.example;

import android.app.Application;
import android.content.Context;

/**
 * Created by friends on 2017/7/15.
 */

public class MyApplication extends Application{
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getInstance(){
        return mContext;
    }
}
