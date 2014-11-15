package jp.co.cyberagent.codesample.http_sample.picasso;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by nara_kazuki on 2014/11/15.
 */
public class PicassoSample {

    /**
     * 指定されたURLの画像をダウンロードしてImageViewにセットします。
     */
    public void loadImage(Context context, String url, ImageView imageView) {
        // これだけ
        Picasso.with(context).load(url).into(imageView);
    }
}
