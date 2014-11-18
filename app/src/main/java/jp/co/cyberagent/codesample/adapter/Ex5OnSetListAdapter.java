package jp.co.cyberagent.codesample.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.co.cyberagent.codesample.R;

/**
 * Created by nara_kazuki on 2014/11/15.
 */
public class Ex5OnSetListAdapter extends ArrayAdapter<String> {

    private Resources mResources;
    private int mRound;

    public Ex5OnSetListAdapter(Context context, List<String> items) {
        super(context, 0, items);

        mResources = context.getResources();
        mRound = mResources.getDimensionPixelSize(R.dimen.list_item_round);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.ex5_on_set_list_item, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Bitmap bmp = circle(BitmapFactory.decodeResource(mResources, R.drawable.simplog_logo));

        viewHolder.textView.setText(getItem(position));
        viewHolder.imageView.setImageBitmap(bmp);
        viewHolder.imageView2.setImageBitmap(bmp);

        return view;
    }

    class ViewHolder {

        @InjectView(R.id.ex5_list_item_image)
        ImageView imageView;
        @InjectView(R.id.ex5_list_item_image2)
        ImageView imageView2;
        @InjectView(R.id.ex5_list_item_text)
        TextView textView;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    private Bitmap circle(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int size = (width >= height) ? height : width;

        // roundRect
        final Rect rect = new Rect(0, 0, size, size);
        final RectF rectf = new RectF(0, 0, size, size);

        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        paint.setAntiAlias(true);

        canvas.drawRoundRect(rectf, mRound, mRound, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}
