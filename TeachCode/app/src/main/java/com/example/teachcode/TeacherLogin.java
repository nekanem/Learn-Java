package com.example.teachcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class TeacherLogin extends AppCompatActivity {

    EditText memailLogTeacherText, mpasswordLogTeacherText;
    Button mloginTeacherBtn;
    TextView mcreateUserLogTeacherText, mforgetPasswordTeacher, mstudentLogSignIn;
    FirebaseAuth firebaseAuth;  // provide by firebase
    ProgressBar mprogressLogBar;
    FirebaseFirestore db;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);


        memailLogTeacherText = findViewById(R.id.emailLogTeacherText);
        mpasswordLogTeacherText = findViewById(R.id.passwordLogTeacherText);
        mloginTeacherBtn = findViewById(R.id.loginTeacherBtn);
        mcreateUserLogTeacherText = findViewById(R.id.createUserLogTeacherText);
        mforgetPasswordTeacher = findViewById(R.id.forgetPasswordTeacher);
        mstudentLogSignIn = findViewById(R.id.studentLogSignIn);

        firebaseAuth = FirebaseAuth.getInstance();
        mprogressLogBar = findViewById(R.id.progressLogBar2);


        mloginTeacherBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String email = memailLogTeacherText.getText().toString().trim();
                String password = mpasswordLogTeacherText.getText().toString().trim();

                // if email or password is empty
                if (TextUtils.isEmpty(email)) {
                    memailLogTeacherText.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpasswordLogTeacherText.setError("Password is required.");
                    return;
                }

                // password length must be greater than 6
                if (password.length() < 6) {
                    mpasswordLogTeacherText.setError("Password must at least 6 characters.");
                    return;
                }

                mprogressLogBar.setVisibility(View.VISIBLE);

                // Authenticate users
                /*DocumentReference isUserATeacher = db.collection("teachers").document(firebaseAuth.getUid());
                if(isUserATeacher==null){
                    mpasswordLogTeacherText.setError("NOt a teacher");
                    return;
                }*/

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {  // complete listener is even handler
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // check if log in is successful or not
                                if (task.isSuccessful()) {
                                    Toast.makeText(TeacherLogin.this, "Log in successfully.", Toast.LENGTH_SHORT).show();
                                    mprogressLogBar.setVisibility(View.VISIBLE);
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {
                                    Toast.makeText(TeacherLogin.this, "Error. Log in failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    mprogressLogBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });


        // not a user yet option. go straight to register
        mcreateUserLogTeacherText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogressLogBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        // forget password reset
        mforgetPasswordTeacher.setOnClickListener(new View.OnClickListener() {
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
                                Toast.makeText(TeacherLogin.this, "Send reset password link successfully.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(TeacherLogin.this, "Send reset password link failed." + e.getMessage(), Toast.LENGTH_SHORT).show();
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
        mstudentLogSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogressLogBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }
}
