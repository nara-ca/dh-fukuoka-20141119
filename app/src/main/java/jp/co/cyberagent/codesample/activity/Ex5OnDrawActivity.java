package jp.co.cyberagent.codesample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import jp.co.cyberagent.codesample.R;

public class Ex5OnDrawActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex5_activity);
    }

    public static void startEx5OnDrawActivity(Activity fromActivity) {
        Intent intent = new Intent(fromActivity, Ex5OnDrawActivity.class);
        fromActivity.startActivity(intent);
    }
}
