package com.example.teachcode;

import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText memailLogText, mpasswordLogText;
    Button mloginBtn;
    TextView mcreateUserLogText, mforgetPassword, mteacherLogSignIn;
    FirebaseAuth firebaseAuth;  // provide by firebase
    ProgressBar mprogressLogBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        memailLogText = findViewById(R.id.emailLogText);
        mpasswordLogText = findViewById(R.id.passwordLogText);
        mloginBtn = findViewById(R.id.loginBtn);
        mcreateUserLogText = findViewById(R.id.createUserLogTeacherText);
        mforgetPassword = findViewById(R.id.forgetPassword);
        mteacherLogSignIn = findViewById(R.id.teacherLogSignIn);

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

        // forget password reset
        mforgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());

                passwordResetDialog.setTitle("Reset Password");
                passwordResetDialog.setMessage("Enter Your Email To Receive Reset Link: ");
                passwordResetDialog.setView(resetMail);

                // yes for reset password
                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String email = resetMail.getText().toString().trim();
                        firebaseAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "Send reset password link successfully.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Send reset password link failed." + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                // no for reset password
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing and redirect back to login view
                    }
                });

                passwordResetDialog.create().show();

            }
        });

        // direct to teacher login activity
        mteacherLogSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogressLogBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), TeacherLogin.class));
            }
        });
    }
}
