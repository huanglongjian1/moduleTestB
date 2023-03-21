package com.example.moduletestb;


import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApp extends Application {
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
            //下面2行必须卸载ARouter init 之间，否则无效
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun的模式下必须开启，线上必须关闭)
            ARouter.openDebug();
        }

        // 官方建议在Application中初始化
        ARouter.init(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
