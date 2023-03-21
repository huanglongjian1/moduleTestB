package com.example.moduletestb;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.export_cart.CartRouterTable;
import com.example.export_cart.CartServiceUtil;

import java.util.logging.Handler;

import UIHandler.MainLooper;

public class MainActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ARouter.getInstance().inject(this);
        findViewById(R.id.maintv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ARouter.getInstance().build("/module_home/ModuleHomeMainActivity").navigation();
            }

        });

    }


}