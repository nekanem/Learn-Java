package com.example.teachcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_home) {
            Intent profileIntent = new Intent(Setting.this, MainActivity.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_profile) {
            Intent sameIntent = new Intent(Setting.this, UserProfile.class);
            startActivity(sameIntent);
        }

        if (id == R.id.action_settings) {
            Intent profileIntent = new Intent(Setting.this, Setting.class);
            startActivity(profileIntent);
        }

        if (id == R.id.action_progress) {
            Intent profileIntent = new Intent(Setting.this, Progress.class);
            startActivity(profileIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
