package com.example.emergencyservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    private Button medicine,blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.setTitle("Emergency Join");

        medicine = findViewById(R.id.medicineButtonId);
        blood = findViewById(R.id.bloodButtonId);


        medicine.setOnClickListener(this);
        blood.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.medicineButtonId) {
            Intent intent = new Intent(getApplicationContext(), Medicine.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.bloodButtonId) {
            Intent intent = new Intent(getApplicationContext(),Blood.class);
            startActivity(intent);
        }
    }
}