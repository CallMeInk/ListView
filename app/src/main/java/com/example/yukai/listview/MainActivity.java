package com.example.yukai.listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {

    private final static String TAG = "yukai";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.my_list_view);
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setContext(MainActivity.this);
        mListView.setAdapter(myAdapter);
//        mListView.setSelection(6);
        Log.e(TAG, "thread info: " + Thread.currentThread().getName());
//        mListView.smoothScrollBy(60, 200);33333
//        mListView.smoothScrollByOffset(50);

        Thread mThread = new MyThread();
        mThread.run();
//        mListView.post(new Runnable() {
//            @Override
//            public void run() {
//                Log.e(TAG, "post thread info : " + Thread.currentThread().getName());
//                mListView.smoothScrollToPosition(6);
//            }
//        });
    }

    private class MyThread extends Thread{
        @Override
        public void run() {
            Log.e(TAG, "post MyThread info : " + Thread.currentThread().getName());
            mListView.smoothScrollToPosition(6);
        }
    }
}
