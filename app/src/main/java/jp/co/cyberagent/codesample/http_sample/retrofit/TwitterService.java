package jp.co.cyberagent.codesample.http_sample.retrofit;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by nara_kazuki on 2014/11/15.
 */
public class TwitterService {

    /**
     * 指定されたユーザーのタイムラインを取得します。
     */
    public void getTimeLine(String userId, Callback<List<Status>> callback) {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("https://api.twitter.com")
                .build();

        TwitterApi twitterApi = adapter.create(TwitterApi.class);
        twitterApi.getTimeLine(userId, callback);
    }
}
