package retrofit;

import android.content.Context;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;

public class DataManager {
    private NetApi mRetrofitService;

    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Observable<ResponseBody> get() {
        return mRetrofitService.get();
    }
}
