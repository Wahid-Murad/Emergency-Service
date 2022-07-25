package com.example.emergencyservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button medicine,blood,contactUs,aboutUs;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        medicine=findViewById(R.id.medicineButtonId);
        blood=findViewById(R.id.bloodButtonId);
        contactUs=findViewById(R.id.contactUsId);
        aboutUs=findViewById(R.id.aboutUsId);

        mAuth=FirebaseAuth.getInstance();


        medicine.setOnClickListener(this);
        blood.setOnClickListener(this);
        contactUs.setOnClickListener(this);
        aboutUs.setOnClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.signOutMenuId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.medicineButtonId)
        {
        Intent intent=new Intent(getApplicationContext(),Medicine.class);
        startActivity(intent);
        }

        if(v.getId()==R.id.bloodButtonId)
        {
            Intent intent=new Intent(getApplicationContext(),Blood.class);
            startActivity(intent);
        }

         if(v.getId()==R.id.contactUsId)
         {
          Intent intent=new Intent(getApplicationContext(),ContactUs.class);
          startActivity(intent);
         }

        if(v.getId()==R.id.aboutUsId)
        {
            Intent intent=new Intent(getApplicationContext(),AboutUs.class);
            startActivity(intent);
        }


    }
}