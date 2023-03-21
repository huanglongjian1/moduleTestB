package com.example.module_home.presenter;

import android.content.Context;
import android.content.Intent;



import com.example.module_home.view.BookView;
import com.example.module_home.view.V;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit.DataManager;

public class BookPresenter implements Presenter {
    private DataManager manager;


    private CompositeDisposable mCompositeSubscription;


    private Context mContext;

    public BookPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeSubscription = new CompositeDisposable();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (!mCompositeSubscription.isDisposed()) {
            mCompositeSubscription.dispose();
        }
    }

    @Override
    public void pause() {

    }

    BookView mView;

    @Override
    public void attachView(V view) {
        mView = (BookView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {
    }

    public void getSearchBooks() {
        mCompositeSubscription.add(manager.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Throwable {
                        mView.onSuccess(responseBody.string());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        mView.onError(throwable.getMessage());
                    }
                })
        );
    }
}
