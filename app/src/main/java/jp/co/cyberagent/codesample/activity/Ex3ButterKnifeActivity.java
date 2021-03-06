package jp.co.cyberagent.codesample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jp.co.cyberagent.codesample.R;

public class Ex3ButterKnifeActivity extends Activity {

    @InjectView(R.id.ex3_text)
    TextView mTextView;
    @InjectView(R.id.ex3_image)
    ImageView mImageView;
    @InjectView(R.id.ex3_button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex3_activity);

        // Butter Knifeを使ってViewをinject
        ButterKnife.inject(this);
    }

    @OnClick(R.id.ex3_button)
    public void onClickButton() {
        // ボタンクリック時の処理
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ex3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
