package com.fcm.t;

import android.os.Bundle;
import android.widget.Toast;

import com.fcm.plugin.service.FCMpluginInitializer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MutableLiveData<String> token = FCMpluginInitializer.getCurrentToken();
        token.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, "Token - >>> : " + s, Toast.LENGTH_LONG).show();
            }
        });
    }
}
