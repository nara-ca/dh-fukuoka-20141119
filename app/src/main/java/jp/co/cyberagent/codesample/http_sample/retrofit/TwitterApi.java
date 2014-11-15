package jp.co.cyberagent.codesample.http_sample.retrofit;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by nara_kazuki on 2014/11/15.
 */
public interface TwitterApi {

    @GET("/1.1/statuses/user_timeline.json")
    public void getTimeLine(@Query("user_id") String userId, Callback<List<Status>> callback);

}
