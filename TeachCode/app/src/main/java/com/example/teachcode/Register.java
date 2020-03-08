package com.example.teachcode;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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

import java.util.Objects;

public class Register extends AppCompatActivity {
    EditText mFullName, mEmail, mPassword, mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth firebaseAuth;  // provide by firebase
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullNameText);
        mEmail = findViewById(R.id.emailText);
        mPassword = findViewById(R.id.passwordText);
        mPhone = findViewById(R.id.phoneText);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.createText);

        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        // user already has an account
        if (firebaseAuth.getCurrentUser() != null) {
            // direct to main activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        // user does not have an account and need to register
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getEditableText().toString().trim();
                String password = mPassword.getText().toString().trim();

                // if email or password is empty
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required.");
                    return;
                }

                // password length must be greater than 6
                if (password.length() < 6) {
                    mPassword.setError("Password must at least 6 characters.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // register the user in firebase
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // if task is successful -> we success create user
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User successfully created.", Toast.LENGTH_SHORT).show();
                            // direct to main activity
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Error. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });


    }
}
