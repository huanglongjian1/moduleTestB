package com.example.module_home.presenter;

import android.content.Intent;

import com.example.module_home.view.V;


public interface Presenter {
    void onCreate();

    void onStart();//暂时没用到

    void onStop();

    void pause();//暂时没用到

    void attachView(V view);

    void attachIncomingIntent(Intent intent);//暂时没用到
}

