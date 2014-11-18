package jp.co.cyberagent.codesample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.co.cyberagent.codesample.R;


public class IndexActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.button_ex2_scroll)
    public void showMaterialScrollAcrivity() {
        Ex2ScrollActivity.startEx2ScrollAcrivity(this);
    }

    @OnClick(R.id.button_ex2_list)
    public void showMaterialListActivity() {
        Ex2ListActivity.startEx2ListAcrivity(this);
    }

    @OnClick(R.id.button_ex4)
    public void showEx4SampleActivity() {
        Ex4Activity.startEx4Activity(this);
    }

    @OnClick(R.id.button_ex5_draw)
    public void showEx5DrawActivity() {
        Ex5OnDrawActivity.startEx5OnDrawActivity(this);
    }

    @OnClick(R.id.button_ex5_set)
    public void showEx5SetActivity() {
        Ex5OnSetActivity.startEx5OnSetActivity(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
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
