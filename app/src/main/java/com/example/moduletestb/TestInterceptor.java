package com.example.moduletestb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;


import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.export_cart.CartRouterTable;

// 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
@Interceptor(priority = 1, name = "登录拦截")
public class TestInterceptor implements IInterceptor {
    Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
   //    postcard.setTag("登录已失效，请重新登录");
     //   postcard.setExtra(666);
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

        Log.e("拦截器初始化", "init--" + Thread.currentThread().getName()+"---"+context.toString()+"="+context.hashCode());
    }
}
