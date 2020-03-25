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

public class Login extends AppCompatActivity {
    EditText memailLogText, mpasswordLogText;
    Button mloginBtn;
    TextView mcreateUserLogText;
    FirebaseAuth firebaseAuth;  // provide by firebase
    ProgressBar mprogressLogBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        memailLogText = findViewById(R.id.emailLogText);
        mpasswordLogText = findViewById(R.id.passwordLogText);
        mloginBtn = findViewById(R.id.loginBtn);
        mcreateUserLogText = findViewById(R.id.createUserLogText);

        firebaseAuth = FirebaseAuth.getInstance();
        mprogressLogBar = findViewById(R.id.progressLogBar);


        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = memailLogText.getText().toString().trim();
                String password = mpasswordLogText.getText().toString().trim();

                // if email or password is empty
                if (TextUtils.isEmpty(email)) {
                    memailLogText.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpasswordLogText.setError("Password is required.");
                    return;
                }

                // password length must be greater than 6
                if (password.length() < 6) {
                    mpasswordLogText.setError("Password must at least 6 characters.");
                    return;
                }

                mprogressLogBar.setVisibility(View.VISIBLE);

                // Authenticate users
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {  // complete listener is even handler
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // check if log in is successful or not
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "Log in successfully.", Toast.LENGTH_SHORT).show();
                                    mprogressLogBar.setVisibility(View.VISIBLE);
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {
                                    Toast.makeText(Login.this, "Error. Log in failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    mprogressLogBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });

        // not a user yet option. go straight to register
        mcreateUserLogText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogressLogBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

    }
}
