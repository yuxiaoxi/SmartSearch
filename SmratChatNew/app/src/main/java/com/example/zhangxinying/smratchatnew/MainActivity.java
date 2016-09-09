package com.example.zhangxinying.smratchatnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmartChatFragment fragment = new SmartChatFragment();
        getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment).commit();

    }
}