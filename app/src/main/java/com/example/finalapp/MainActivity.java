package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent;
        if(newUser()) {
            intent = new Intent(this, ActivityMenu.class);
        } else {
            intent = new Intent(this, ActivityLogin.class);
        }
        startActivity(intent);
        finish();
    }

    private boolean newUser() {
        SharedPreferences preferences = getSharedPreferences("user.dat", MODE_PRIVATE);
        return preferences.getBoolean("registered", false);
    }
}