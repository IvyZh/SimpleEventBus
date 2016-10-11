package com.ivy.simpleeventbusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Ivy on 2016/10/11.
 *
 * @description:
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void method1(View v) {
        EventBus.getDefault().post("来自SecondActivity的String信息");
        finish();
    }

    public void method2(View v) {
        Book book = new Book("数学之美", "66");
        EventBus.getDefault().post(book);
        finish();
    }

}
