package retrofit;

import android.content.Context;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private Context mCntext;

    OkHttpClient client = new OkHttpClient();

    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    private RetrofitHelper(Context mContext) {
        mCntext = mContext;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(NetApi.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
               .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public NetApi getServer() {
        return mRetrofit.create(NetApi.class);
    }
}

