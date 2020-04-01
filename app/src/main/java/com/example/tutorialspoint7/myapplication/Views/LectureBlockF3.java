package com.example.tutorialspoint7.myapplication.Views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.tutorialspoint7.myapplication.R;

public class LectureBlockF3 extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_block_f3);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
