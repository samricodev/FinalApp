package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.txtUsuario);
        pass = findViewById(R.id.txtContrasena);
    }
    public void login(View view) {

        Usuario usr = new Usuario(user.getText().toString().trim(), pass.getText().toString());
        savePreferences(usr);

        Intent intent = new Intent(ActivityLogin.this, ActivityMenu.class);
        startActivity(intent);
        finish();
    }

    private void savePreferences(Usuario user) {
        SharedPreferences preferences = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", user.getNombre());
        editor.putString("password", user.getPasswd());
        editor.putBoolean("registered", true);
        editor.apply();
    }

    public void exit(View view){
        finish();
    }
}