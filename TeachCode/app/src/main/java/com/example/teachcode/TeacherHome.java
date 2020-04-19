package com.example.teachcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class TeacherHome extends AppCompatActivity {

    FirebaseAuth firebaseAuth;  // provide by firebase
    FirebaseFirestore db;
    private RecyclerView student_list;
    String userID;
    TextView studentData;
    ListView student_ListView;
    private ArrayList<String> studentsArray=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        studentData = findViewById(R.id.studentData);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        db.collection("users")
                .whereEqualTo("userType", "student")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("HEREEEEEE susssss", document.getId() + " => " + document.getData().toString());
                                studentData.setText(document.getData().toString());
                                studentsArray.add(document.getData().toString());

                            }
                            //studentData.setText((CharSequence) studentsArray);

                        } else {
                            Log.d("HEREEEEEEE faillllll", "Error getting documents: ", task.getException());
                        }
                    }
                });


    }
//    class students{
//        private String name;
//        private String email;
//
//
//    }
//    private class MyAdapter extends BaseAdapter {
//
//        // override other abstract methods here
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup container) {
//            if (convertView == null) {
//                convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
//            }
//
//            ((TextView) convertView.findViewById(android.R.id.text1))
//                    .setText(getItem(position));
//            return convertView;
//        }
//    }
}
