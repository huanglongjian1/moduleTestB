package com.example.module_cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.export_cart.CartRouterTable;

@Route(path = CartRouterTable.PATH_PAGE_CART)
public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        findViewById(R.id.carttv).setOnClickListener(this);

    }

    @Autowired
    String key1;

    @Autowired(name = "key2")
    String str;

    @Override
    public void onClick(View v) {
        ARouter.getInstance().inject(this);
        Log.e("AAAAAAAAAAAAAAAA", "AAAAAAAAAAAA");
        Log.e("key:", key1 + "----" + str);


    }
}