package UIHandler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


import androidx.annotation.NonNull;


public class MainLooper {
    public static void runOnUiThread(Runnable runnable) {
        Handler mUIhandler = new Handler(Looper.getMainLooper());
        if (Thread.currentThread().getName() != "main") {
            mUIhandler.post(runnable);
            Log.e("当前线程", Thread.currentThread().getName());
        } else {
            runnable.run();
        }
    }
}
