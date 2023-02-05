package com.dtmchu.instargramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent iHome = getIntent();
        String username = iHome.getStringExtra("username");
        ((TextView) findViewById(R.id.usernametext)).setText("Welcome : " + username);
    }
}