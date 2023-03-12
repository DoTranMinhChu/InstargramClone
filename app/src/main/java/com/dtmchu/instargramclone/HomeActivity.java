package com.dtmchu.instargramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent iHome = getIntent();
        String username = iHome.getStringExtra("username");
        ((TextView) findViewById(R.id.usernametext)).setText("Welcome : " + username);
    }

    public void onMangerContact(View view) throws IOException {
        Intent iHome = new Intent(HomeActivity.this, ContactsActivity.class);
        Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_LONG).show();
        startActivity(iHome);
    }
}