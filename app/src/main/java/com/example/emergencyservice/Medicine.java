package com.example.emergencyservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Medicine extends AppCompatActivity implements View.OnClickListener {

    private ImageView beximco,aci,square,incepta,reneta,drug,delta,transcom,acme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        this.setTitle("Medicine");

        beximco=findViewById(R.id.beximcoImageViewId);
        aci=findViewById(R.id.aciImageViewId);
        square=findViewById(R.id.squareImageViewId);
        incepta=findViewById(R.id.inceptaImageViewId);
        reneta=findViewById(R.id.renetaImageViewId);
        drug=findViewById(R.id.drugImageViewId);
        delta=findViewById(R.id.deltaImageViewId);
        transcom=findViewById(R.id.transcomImageViewId);
        acme=findViewById(R.id.acmeImageViewId);

        beximco.setOnClickListener(this);
        aci.setOnClickListener(this);
        square.setOnClickListener(this);
        incepta.setOnClickListener(this);
        reneta.setOnClickListener(this);
        drug.setOnClickListener(this);
        delta.setOnClickListener(this);
        transcom.setOnClickListener(this);
        acme.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.beximcoImageViewId){
            Intent intent=new Intent(getApplicationContext(),Beximco.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.aciImageViewId){
            Intent intent=new Intent(getApplicationContext(),Aci.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.squareImageViewId){
            Intent intent=new Intent(getApplicationContext(),Square.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.inceptaImageViewId){
            Intent intent=new Intent(getApplicationContext(),Incepta.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.renetaImageViewId){
            Intent intent=new Intent(getApplicationContext(),Reneta.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.drugImageViewId){
            Intent intent=new Intent(getApplicationContext(),Drug.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.deltaImageViewId){
            Intent intent=new Intent(getApplicationContext(),Delta.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.transcomImageViewId){
            Intent intent=new Intent(getApplicationContext(),Transcom.class);
            startActivity(intent);
        }

                if(v.getId()==R.id.acmeImageViewId){
            Intent intent=new Intent(getApplicationContext(),Acme.class);
            startActivity(intent);
        }





    }
}