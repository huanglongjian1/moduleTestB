package retrofit;


import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NetApi {
    String BASE_URL = "https://www.jianshu.com/";

    @GET("/")
    Observable<ResponseBody> get();

    @GET("{p}/{lo}")
    Observable<ResponseBody> getSearchBook(@Path("p") String p, @Path("lo") String lo);
}
