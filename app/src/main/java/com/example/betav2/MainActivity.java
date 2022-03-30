package com.example.betav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singin(View view) {
        Intent si = new Intent(this, Singin.class);
        startActivity(si);
    }

    public void login(View view) {
        Intent si = new Intent(this, Login.class);
        startActivity(si);
    }
}
/**
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            // No user is signed in
        } else {
            // User logged in
        }
    }
 **/