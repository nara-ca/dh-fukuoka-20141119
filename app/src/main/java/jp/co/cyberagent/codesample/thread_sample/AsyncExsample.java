package jp.co.cyberagent.codesample.thread_sample;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by nara_kazuki on 2014/11/15.
 */
public class AsyncExsample {

    /**
     * UI Threadに対してメッセージを送るサンプルです。
     */
    public static void sendMessageToUIThread() {

        // ここは UI Thread
        // このHandlerはUI Threadでnewしたので、UI Threadに対してメッセージを送るHandlerです。
        final Handler mainHandler = new Handler();

        // 別Threadで処理をします
        Thread workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // ここは別Threadで動きます。
                // そのため、ここでViewを操作すると例外が発生します。

                // UI Threadに対してメッセージを送るHandlerを取得
                // このThreadを開始する前に作った mainHandler を使っても同じことなります。
                Handler uiHandler = new Handler(Looper.getMainLooper());
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // ここはUI Threadで動きます
                    }
                });

                // ちなみに、ここでこんな感じでHandlerを作ってもUI Threadにはメッセージを送ってくれません。
                // Androidのバージョンによってはそもそも例外が出るかも
                Handler workerHandler = new Handler();
            }
        });

        // Thread開始
        workerThread.start();
    }
}
