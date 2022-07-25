package com.example.emergencyservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signInSignUp,emergencyJoin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signInSignUp=findViewById(R.id.signInSignUpId);
        emergencyJoin=findViewById(R.id.emergencyJoinId);


        signInSignUp.setOnClickListener(this);
        emergencyJoin.setOnClickListener(this);

     getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nocolor)));

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.signInSignUpId)
        {
            Intent intent = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.emergencyJoinId)
        {
            Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(intent);
        }

    }


}