package com.example.teachcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button btnSub;
    String given1;
    String actual1 = "String name = \"John\";";
    String given2;
    String actual2 = "//";
    String given3;
    String actual3 = "==";
    String given4;
    String actual4 = "switch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        btnSub = findViewById(R.id.btnSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    given1 = editText1.getText().toString();
                    given2 = editText1.getText().toString();
                    given3 = editText1.getText().toString();
                    given4 = editText1.getText().toString();
                } catch (Exception ex) {
                    Toast toast = Toast.makeText(getApplicationContext(), "An Answer Was not Entered", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //print correct/incorrect as toast
                //print correct and go to lesson 2
                if (actual1.equals(given1) && actual2.equals(given2) && actual3.equals(given3) && actual4.equals(given4)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));  // go back to MainActivity, change late maybe
                    finish();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "At Least One Answer is Incorrect, Try Again", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_profile) {
            Intent profileIntent = new Intent(Quiz.this, UserProfile.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_settings) {
            Intent profileIntent = new Intent(Quiz.this, Setting.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_home) {
            Intent homeIntent = new Intent(Quiz.this, MainActivity.class);
            startActivity(homeIntent);
        }

        if (id == R.id.action_progress) {
            Intent profileIntent = new Intent(Quiz.this, UserProfile.class);
            startActivity(profileIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
