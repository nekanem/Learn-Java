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

public class LessonFour extends AppCompatActivity {

    EditText editText1;
    Button btnSub;
    String given;
    String actual = "Samsung";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_four);
        editText1 = findViewById(R.id.editText1);
        btnSub = findViewById(R.id.btnSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    given = editText1.getText().toString();
                } catch (Exception ex) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Answer not Entered", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //print correct/incorrect as toast
                //print correct and go to lesson 2
                if (actual.equals(given)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));  // go back to MainActivity, change late maybe
                    finish();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Incorrect, Try Again", Toast.LENGTH_SHORT);
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
            Intent profileIntent = new Intent(LessonFour.this, UserProfile.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_settings) {
            Intent profileIntent = new Intent(LessonFour.this, Setting.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_home) {
            Intent homeIntent = new Intent(LessonFour.this, MainActivity.class);
            startActivity(homeIntent);
        }

        if (id == R.id.action_progress) {
            Intent profileIntent = new Intent(LessonFour.this, Progress.class);
            startActivity(profileIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
