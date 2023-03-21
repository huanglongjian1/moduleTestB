package com.example.module_cart;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit.RetrofitHelper;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MyFragment_01 extends Fragment {
    public void refresh(String newsTitle, String newsContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);//把visibilityLayout设置成可见
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);//获取新闻标题控件
        TextView newsContentText = (TextView) view.findViewById(R.id.news_content);//获取新闻正文控件
        newsTitleText.setText(newsTitle);//刷新新闻标题
        newsContentText.setText(newsContent);//刷新新闻内容

    }

    public Observable<ResponseBody> getnews() {
        Observable<ResponseBody> observable = RetrofitHelper.getInstance(getContext()).getServer().get();
        return observable;
    }

    View view;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.module_cart_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getnews().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<ResponseBody>() {
                            @Override
                            public void accept(ResponseBody responseBody) throws Throwable {
                                String _newsTitle = "新闻长度" + responseBody.contentLength();
                                String _newsContent = responseBody.string();
                                refresh(_newsTitle, _newsContent);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Throwable {
                                Log.e("throwable", throwable.getMessage());
                            }
                        });
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout, null);
        Log.e("++++++", "增加");
        return view;
    }
}
