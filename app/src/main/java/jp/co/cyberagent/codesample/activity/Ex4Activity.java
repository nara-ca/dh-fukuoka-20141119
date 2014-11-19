package jp.co.cyberagent.codesample.activity;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jp.co.cyberagent.codesample.R;

public class Ex4Activity extends Activity implements View.OnClickListener,
        LoaderManager.LoaderCallbacks<List<String>>, AbsListView.OnScrollListener,
        CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4_activity);

        // ボタンのクリックイベントを設定
        ((Button) findViewById(R.id.ex4_button_1)).setOnClickListener(this);
        ((Button) findViewById(R.id.ex4_button_2)).setOnClickListener(this);
        ((Button) findViewById(R.id.ex4_button_3)).setOnClickListener(this);

        ((Switch) findViewById(R.id.ex4_switch)).setOnCheckedChangeListener(this);

        // AsyncTaskLoaderの初期化
        getLoaderManager().initLoader(0, null, this);

        ((ListView) findViewById(R.id.ex4_list)).setOnScrollListener(this);
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

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ex4_button_1:
                fireButton1Event(view);
                break;
            case R.id.ex4_button_2:
                fireButton2Event(view);
                break;
            case R.id.ex4_button_3:
                finish();
                break;
            default:

                break;
        }
    }

    @Override
    public Loader onCreateLoader(int i, Bundle bundle) {
        AsyncTaskLoader<List<String>> asyncTaskLoader = new AsyncTaskLoader<List<String>>(this) {
            @Override
            public List<String> loadInBackground() {

                // ここでAPIを叩いて表示文字列を取得するものとする。
                // 実際はAPI叩かないのでダミー処理としてランダムな秒数待機してから値を返却。
                try {
                    int wait = (int) Math.ceil(Math.random() * 3000);
                    Log.d("CodeSample", "待ち時間: " + wait);

                    Thread thread = new Thread();
                    thread.sleep(wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<String> ret = new ArrayList<String>();
                for (int i = 0; i < 30; i++) {
                    ret.add("String " + i);
                }
                return ret;
            }
        };
        return asyncTaskLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> o) {
        Toast.makeText(this, "リストの読み込みが終了しました。", Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, o);
        ((ListView) findViewById(R.id.ex4_list)).setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i > 0 && i + i2 >= i3) {
            Toast.makeText(this, "最後までスクロールしました", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            findViewById(R.id.ex4_root).setBackgroundColor(Color.parseColor("#639c12"));
        } else {
            findViewById(R.id.ex4_root).setBackgroundColor(Color.WHITE);
        }
    }

    public void fireButton1Event(View view) {
        getLoaderManager().getLoader(0).forceLoad();
    }

    public void fireButton2Event(View view) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new ArrayList<String>());
        ((ListView) findViewById(R.id.ex4_list)).setAdapter(adapter);
    }

    public static void startEx4Activity(Activity fromActivity) {
        Intent intent = new Intent(fromActivity, Ex4Activity.class);
        fromActivity.startActivity(intent);
    }
}
