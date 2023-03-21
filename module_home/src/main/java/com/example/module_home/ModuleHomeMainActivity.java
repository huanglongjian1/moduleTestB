package com.example.module_home;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.export_cart.CartServiceUtil;
import com.example.export_cart.ICartService;
import com.example.module_home.presenter.BookPresenter;
import com.example.module_home.view.BookView;
import com.example.module_home.view.V;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit.RetrofitHelper;

@Route(path = "/module_home/ModuleHomeMainActivity")
public class ModuleHomeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_home_main);
        testMVP();
        //调用购物车组件服务：获取购物车商品数量
        TextView tvCartProductCount = findViewById(R.id.module_home_tv);
        tvCartProductCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartServiceUtil.navigateCartPage("param1", "param2");
            }
        });
        tvCartProductCount.setText("购物车商品数量:" + CartServiceUtil.getCartProductCount().productCount);

        findViewById(R.id.addfragment).setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override
            public void onClick(View v) {
                logget();
                Fragment fragment = CartServiceUtil.getCartProductFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                transaction.commit();


            }
        });
    }

    public void logget() {
        Observable<ResponseBody> observable = RetrofitHelper.getInstance(ModuleHomeMainActivity.this).getServer().getSearchBook("p", "7b839b7c5884");

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody o) throws Throwable {
                        Log.e("ResponseBody:", o.string());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.e("ResponseBody:", throwable.getMessage());
                    }
                });


    }

    public void test() {
        ICartService iCartService = ARouter.getInstance().navigation(ICartService.class);
        Log.e("test:", iCartService.getProductFragment().toString() + "-----" + iCartService.getProductCountInCart().toString());
    }

    public void testMVP() {
        BookPresenter bookPresenter = new BookPresenter(ModuleHomeMainActivity.this);
        bookPresenter.onCreate();
        bookPresenter.attachView((V) bookView);
        bookPresenter.getSearchBooks();

    }

     BookView bookView = new BookView() {
        @Override
        public void onSuccess(String success) {
            Log.e("bookView+success：", success);
        }

        @Override
        public void onError(String error) {
            Log.e("bookView+error:", error);
        }
    };
}