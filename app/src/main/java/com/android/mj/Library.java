package com.android.mj;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.mj.exception.CrashHandler;
import com.android.mj.tools.LogUtil;
import com.android.mj.tools.activity_manager.ActivityManager;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.jpush.android.api.JPushInterface;

/**
 * author: Rea.X
 * date: 2017/12/2.
 */

public class Library {

    private static Application application;
    private static boolean isDebug;

    public static boolean isDebug() {
        return isDebug;
    }

    public static Application get() {
        return application;
    }

    public static Context getContext() {
        return application.getApplicationContext();
    }

    public static void init(Application application, String bmobkey, boolean isDebug) {
        Library.application = application;
        Library.isDebug = isDebug;
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(application);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(application);
        if (!TextUtils.isEmpty(bmobkey))
            Bmob.initialize(application, bmobkey);
        AVOSCloud.initialize(application, "1J7dxpxtmBe9BKL59e7v3d3p-gzGzoHsz", "QXU1cpfBzN53LWNOjyHUlngP");
        AVOSCloud.setDebugLogEnabled(BuildConfig.DEBUG);
        ActivityManager.startWatcher(application);
        queryRuntimeConfig();
    }

    //检查配置是否过期，过期就不再让使用了
    private static void queryRuntimeConfig() {
        AVQuery<AVObject> avquery = new AVQuery<>("RuntimeConfig");
        avquery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e != null) return;
                if (list != null && list.size() != 0) {
                    for (AVObject config : list) {
                        String packagename = config.getString("packagename");
                        boolean isenable = config.getBoolean("isenable");
                        LogUtil.e("packagename::" + packagename + " isenable:" + isenable);
                        if (packagename.equalsIgnoreCase(application.getPackageName()) && !isenable) {
                            Library.setIsTimeout(true);
                            break;
                        }
                    }
                }
            }
        });
    }

    private static boolean isTimeout;

    public static boolean isTimeout() {
        return isTimeout;
    }

    public static void setIsTimeout(boolean isTimeout) {
        Library.isTimeout = isTimeout;
    }
}
