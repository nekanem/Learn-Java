package com.example.teachcode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;

public class UserProfile extends AppCompatActivity {

    TextView mfullName, memail, mphone, mverifyMsg;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;
    String userID;
    Button verifyBtn;
    private static final String TAG = "UserProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        mfullName = findViewById(R.id.fullNameMain);
        memail = findViewById(R.id.emailMain);
        mphone = findViewById(R.id.phoneMain);
        mverifyMsg = findViewById(R.id.verifyMsg);
        verifyBtn = findViewById(R.id.verifyBtn);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        userID = firebaseAuth.getCurrentUser().getUid();

        // if email is not verified
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (!firebaseUser.isEmailVerified()) {
            mverifyMsg.setVisibility(View.VISIBLE);
            verifyBtn.setVisibility(View.VISIBLE);

            verifyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    // verify email sending link
                    firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(v.getContext(), "Verification link has been sent to your email.", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "sendEmailVerification - onFailure: failed sending verify link. " + e.toString());
                        }
                    });
                }
            });
        }

        // displaying the user's profile
        DocumentReference documentReference = firestore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mphone.setText(documentSnapshot.getString("phone"));
                mfullName.setText(documentSnapshot.getString("fullName"));
                memail.setText(documentSnapshot.getString("email"));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_home){

            Intent profileIntent = new Intent (UserProfile.this, MainActivity.class);
            startActivity(profileIntent);
        }

        if(id == R.id.action_profile){

            Intent sameIntent = new Intent (UserProfile.this, UserProfile.class);
            startActivity(sameIntent);
        }

        if(id == R.id.action_settings){

            Intent profileIntent = new Intent (UserProfile.this, Setting.class);
            startActivity(profileIntent);


        }



        if(id == R.id.action_progress){

            Intent profileIntent = new Intent (UserProfile.this, Progress.class);
            startActivity(profileIntent);

        }


        return super.onOptionsItemSelected(item);
    }



}
