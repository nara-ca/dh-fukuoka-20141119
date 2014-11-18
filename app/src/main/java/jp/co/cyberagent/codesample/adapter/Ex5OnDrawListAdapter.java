package jp.co.cyberagent.codesample.adapter;

import android.content.Context;
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
public class Ex5OnDrawListAdapter extends ArrayAdapter<String> {

    public Ex5OnDrawListAdapter(Context context, List<String> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.ex5_on_draw_list_item, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(getItem(position));
        viewHolder.imageView.setImageResource(R.drawable.simplog_logo);
        viewHolder.imageView2.setImageResource(R.drawable.simplog_logo);

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
}
