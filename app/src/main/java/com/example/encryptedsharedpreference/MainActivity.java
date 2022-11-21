package com.example.encryptedsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String SHARED_FILE_NAME = "encryptedFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreference();
    }

    private void sharedPreference() {
        SharedPreferences prefs = this.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_PRIVATE);
    }
}