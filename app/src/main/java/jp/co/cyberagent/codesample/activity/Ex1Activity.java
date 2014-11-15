package jp.co.cyberagent.codesample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import jp.co.cyberagent.codesample.R;
import jp.co.cyberagent.codesample.fragment.Ex1Fragment;

public class Ex1Activity extends Activity {

    private Ex1Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex1_activity);

        mFragment = (Ex1Fragment) getFragmentManager().findFragmentById(R.id.ex1_fragment);

        findViewById(R.id.ex1_fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragmentButtonClick();
            }
        });

        findViewById(R.id.ex1_fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragmentButtonClick();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ex1, menu);
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

    /**
     * Activityのボタンがクリックされたイベント処理です。
     */
    public void onActivityButtonClick() {
        Toast.makeText(this, "Activityのボタンがクリックされました＠Activity", Toast.LENGTH_SHORT).show();
    }

    /**
     * Fragmentのボタンがクリックされたイベント処理です。
     * どうしてもFragmentのボタンが押されたタイミングでActivityの処理を動かしたい。
     */
    public void onFragmentButtonClick() {

        Toast.makeText(this, "Fragmentのボタンがクリックされました＠Activity", Toast.LENGTH_SHORT).show();
    }
}
