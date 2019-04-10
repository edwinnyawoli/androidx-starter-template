package com.edwinnyawoli.templateapplication.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(EmptyActivity.intentFor(this, UUID.randomUUID().toString()));
    }
}
