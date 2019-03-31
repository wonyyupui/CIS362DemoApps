package com.bateman.countingthreadexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends AppCompatActivity {

    //DECLARE UI TEXTVIEW AND COUNT OBJECT
    private TextView countTextView;
    private Integer count;
    private Thread thread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //REFERENCE THE TEXTVIEW UI ELEMENT ON THE LAYOUT
        countTextView = findViewById(R.id.textView);
        count = 0;
    }



    //*************RUNNABLE **************/
    private Runnable countNumbers = new Runnable () {
        private static final int DELAY = 1000;
        public void run() {
            try {
                while (true) {
                    count ++;
                    Thread.sleep (DELAY);
                    threadHandler.sendEmptyMessage(0);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };

    //**************HANDLER****************/
    public Handler threadHandler = new Handler() {
        public void handleMessage (android.os.Message message){
            countTextView.setText(count.toString());
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    public void threadStart(View view) {
        //INITIALIZE THE COUNTER


        thread = new Thread (countNumbers);

        //CREATE A THREAD AND START IT

        thread.start();
    }

    public void threadStop(View view) {

        thread.interrupt();
    }
}
