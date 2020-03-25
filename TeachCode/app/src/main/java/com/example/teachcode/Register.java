package com.example.teachcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    EditText mfullNameRegEditText, memailRegEditText, mpasswordRegEditText, mphoneRegEditText;
    Button mRegisterBtn;
    TextView mcreateRegText;
    FirebaseAuth firebaseAuth;  // provide by firebase
    ProgressBar progressRegBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mfullNameRegEditText = findViewById(R.id.fullNameRegEditText);
        memailRegEditText = findViewById(R.id.emailRegEditText);
        mpasswordRegEditText = findViewById(R.id.passwordRegEditText);
        mphoneRegEditText = findViewById(R.id.phoneRegEditText);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mcreateRegText = findViewById(R.id.createRegText);

        firebaseAuth = FirebaseAuth.getInstance();
        progressRegBar = findViewById(R.id.progressRegBar);


        // user already has an account
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            // direct to main activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        // user does not have an account and need to register
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memailRegEditText.getText().toString().trim();
                String password = mpasswordRegEditText.getText().toString().trim();

                // if email or password is empty
                if (TextUtils.isEmpty(email)) {
                    memailRegEditText.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpasswordRegEditText.setError("Password is required.");
                    return;
                }

                // password length must be greater than 6
                if (password.length() < 6) {
                    mpasswordRegEditText.setError("Password must at least 6 characters.");
                    return;
                }

                progressRegBar.setVisibility(View.VISIBLE);

                // register the user in firebase
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // if task is successful -> we success create user
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "User successfully created.", Toast.LENGTH_SHORT).show();
                                    progressRegBar.setVisibility(View.VISIBLE);
                                    // direct to main activity
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {
                                    Toast.makeText(Register.this, "Error. Register new user failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    progressRegBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });

        // already a user option. go straight to login
        mcreateRegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressRegBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

    }
}