package com.example.emergencyservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Account extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpEmailEditText,signUpPasswordEditText,firstNameEditText,lastNameEditText,phoneNumberEditText;
    private TextView signInTextView;
    private Button signUpButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        this.setTitle("Sign Up Activity");

        mAuth = FirebaseAuth.getInstance();

        signUpEmailEditText=findViewById(R.id.signUpEmailEditTextId);
        signUpPasswordEditText=findViewById(R.id.signUpPasswordEditTextId);
        firstNameEditText=findViewById(R.id.firstNameEditTextId);
        lastNameEditText=findViewById(R.id.lastNameEditTextId);
        phoneNumberEditText=findViewById(R.id.phoneNumberEditTextId);
        signUpButton=findViewById(R.id.signUpButtonId);
        signInTextView=findViewById(R.id.signInTextViewId);
        progressBar=findViewById(R.id.progressbarId);

        signUpButton.setOnClickListener(this);
        signInTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUpButtonId:
                userRegister();


                break;

            case R.id.signInTextViewId:
                Intent intent=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);


        }

    }

    private void userRegister() {


        String firstName=firstNameEditText.getText().toString().trim();
        String lastName=lastNameEditText.getText().toString().trim();
        String phoneNumber=phoneNumberEditText.getText().toString().trim();
        String email=signUpEmailEditText.getText().toString().trim();
        String password=signUpPasswordEditText.getText().toString().trim();


        //first Name
        if(firstName.isEmpty()) {
            firstNameEditText.setError("Enter Your First Name");
            firstNameEditText.requestFocus();
            return;
        }

        if(firstName.length()>15)
        {
            firstNameEditText.setError("Maximum length of First Name Should be in 15");
            firstNameEditText.requestFocus();
            return;
        }

        //last Name
        if(lastName.isEmpty()) {
            lastNameEditText.setError("Enter Your Last Name");
            lastNameEditText.requestFocus();
            return;
        }

        if(lastName.length()>15)
        {
            lastNameEditText.setError("Maximum length of Last Name Should be in 15");
            lastNameEditText.requestFocus();
            return;
        }

        //Email
        if(email.isEmpty()) {
            signUpPasswordEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if(email.length()>40)
        {
            signUpEmailEditText.setError("Maximum length of email Should be in 40");
            signUpEmailEditText.requestFocus();
            return;
        }



        //Phone Number
        if(phoneNumber.isEmpty()) {
            phoneNumberEditText.setError("Enter Your Phone Number");
            phoneNumberEditText.requestFocus();
            return;
        }

        if(phoneNumber.length()<=10 || phoneNumber.length()>11)
        {
            phoneNumberEditText.setError("Please Enter a Valid Phone Number with total 11 digit");
            phoneNumberEditText.requestFocus();
            return;
        }



        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter a Password");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<8)
        {
            signUpPasswordEditText.setError("Minimum length of Password Should be 8");
            signUpPasswordEditText.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);


        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Register is Succesfull", Toast.LENGTH_SHORT).show();
                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "User is Already Registered", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



    }
}