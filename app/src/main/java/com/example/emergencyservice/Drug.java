package com.example.emergencyservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Drug extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug);

        this.setTitle("Drug");
    }
}