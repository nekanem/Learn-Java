package com.example.teachcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LessonThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_three);
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
            Intent profileIntent = new Intent(LessonThree.this, UserProfile.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_settings) {
            Intent profileIntent = new Intent(LessonThree.this, Setting.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_home) {
            Intent homeIntent = new Intent(LessonThree.this, MainActivity.class);
            startActivity(homeIntent);
        }

        if (id == R.id.action_progress) {
            Intent profileIntent = new Intent(LessonThree.this, Progress.class);
            startActivity(profileIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
