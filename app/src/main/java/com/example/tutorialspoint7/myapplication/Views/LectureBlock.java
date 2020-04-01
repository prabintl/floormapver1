package com.example.tutorialspoint7.myapplication.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tutorialspoint7.myapplication.Adapters.MainAdapter;
import com.example.tutorialspoint7.myapplication.Model.MyModel;
import com.example.tutorialspoint7.myapplication.R;

import java.util.ArrayList;

public class LectureBlock extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<MyModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = new ArrayList<>();
        list.add(new MyModel(R.color.colorPrimary, "Ground Floor", R.drawable.towerblock));
        list.add(new MyModel(R.color.colorPrimary, "First Floor", R.drawable.ukblock));
        list.add(new MyModel(R.color.colorPrimary, "Second Floor", R.drawable.canteen));

        mainAdapter = new MainAdapter(list);
        mainAdapter.setOnItemClickListener(new MainAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                switch (position) {
                    case 0:
                        Intent groundFloor = new Intent(getApplicationContext(), LectureBlockF1.class);
                        startActivity(groundFloor);
                        break;
                    case 1:
                        Intent firstFloor = new Intent(getApplicationContext(), LectureBlockF2.class);
                        startActivity(firstFloor);
                        break;
                    case 2:
                        Intent secondFloor = new Intent(getApplicationContext(), LectureBlockF3.class);
                        startActivity(secondFloor);
                        break;
                }
            }
        });
        recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
