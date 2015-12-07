package hello.com.hello;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * Created by kongfei on 12/1/15.
 */
public class TestHandlerActivity extends Activity {

    private static final String TAG = "TestHandlerActivity";

    private Handler mHandler;
    private HandlerThread mHandlerThread;

    private boolean mRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);

        Log.i(TAG, "Thread name:" +
                "" + Thread.currentThread().getName());

        mHandlerThread = new HandlerThread("Test", 5);
        mHandlerThread.start();

        mHandler = new Handler(Looper.myLooper() ,new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {

                Log.i(TAG, msg.what +  "Thread handleMessage name" + Thread.currentThread().getName());

                return false;

            }
        });

        mHandler.post(mRunnable);

//        AsyncTask

        FutureTask ft = new FutureTask<String>(new Callable(){

            @Override
            public Object call() throws Exception {

                return null;
            }
        });

    }

    private Runnable mRunnable = new Runnable() {

        @Override
        public void run() {

//            while (mRunning) {
//
//                Log.d("MainActivity", "test HandlerThread...");
//
//                try {
//                    Thread.sleep(200);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }

            Log.i(TAG,"Thread name" + Thread.currentThread().getName());

            mHandler.sendEmptyMessage(1);
        }
    };

}
