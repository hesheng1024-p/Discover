package com.example.a14512.discover;

import android.app.Application;
import android.content.Context;

import com.example.a14512.discover.utils.PLog;
import com.example.a14512.discover.utils.SharedPreferencesUtil;

/**
 * @author 14512 on 2018/1/27
 */

public class DiscoverApplication extends Application {
    private static Context mContext;
    public static String cacheDir = "";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        long startTime = System.currentTimeMillis();
        SharedPreferencesUtil.init(this);
        PLog.e("startTime", startTime + "");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }

    }


    public static Context getContext() {
        return mContext;
    }
}