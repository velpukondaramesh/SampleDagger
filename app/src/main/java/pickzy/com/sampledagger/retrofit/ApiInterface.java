package pickzy.com.sampledagger.retrofit;

import java.util.List;

import pickzy.com.sampledagger.model.CryptoData;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {
    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);
}
