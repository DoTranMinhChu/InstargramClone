package com.dtmchu.instargramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    MaterialButton button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         button = (MaterialButton) findViewById(R.id.login_button);
    }

    public void onLogin(View view) throws IOException {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();
        if(username.equals("admin@gmail.com")&&password.equals("123456")){
            Intent iHome = new Intent(LoginActivity.this,HomeActivity.class);
            iHome.putExtra("username",username);
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_LONG).show();
            startActivity(iHome);
        }else{
            Toast.makeText(LoginActivity.this,"Wrong credential",Toast.LENGTH_LONG).show();
            ((EditText) findViewById(R.id.password)).setText("");
        }

    }

    @Override
    protected void onResume() {
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        AnimationDrawable anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }
    @Override
    protected void onPause() {
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        AnimationDrawable anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
}