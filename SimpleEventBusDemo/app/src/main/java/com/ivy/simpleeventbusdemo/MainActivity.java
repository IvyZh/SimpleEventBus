package com.ivy.simpleeventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    //---------------------------------------------------------------------------------------------

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void basic(String msg) {
        tvResult.setText(msg);
    }

    public void method1(View v) {
        EventBus.getDefault().post(((Button) v).getText().toString() + new Random().nextInt(100));
    }


    //---------------------------------------------------------------------------------------------

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void basicObj(Book book) {
        tvResult.setText(book.toString());
    }

    public void method2(View v) {

        Book book = new Book("小王子", "43.8");

        EventBus.getDefault().post(book);
    }

    //---------------------------------------------------------------------------------------------

    public void method3(View v) {

        startActivity(new Intent(this, SecondActivity.class));

    }

    //---------------------------------------------------------------------------------------------
    public void method4(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
