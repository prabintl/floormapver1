package com.example.tutorialspoint7.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tutorialspoint7.myapplication.Adapters.MainAdapter;
import com.example.tutorialspoint7.myapplication.Model.MyModel;
import com.example.tutorialspoint7.myapplication.Views.Canteen;
import com.example.tutorialspoint7.myapplication.Views.GeographicalLocation;
import com.example.tutorialspoint7.myapplication.Views.LectureBlock;
import com.example.tutorialspoint7.myapplication.Views.Outdoor;
import com.example.tutorialspoint7.myapplication.Views.TowerBlock;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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
            list.add(new MyModel(R.color.colorAccent,"Tower Block", R.drawable.towerblock));
            list.add(new MyModel(R.color.colorPrimary,"Lecture Block", R.drawable.ukblock));
            list.add(new MyModel(R.color.colorPurple,"Outdoor", R.drawable.outdoor));
            list.add(new MyModel(R.color.colorOrange,"Canteen", R.drawable.canteen));
            list.add(new MyModel(R.color.colorOrange,"Geographical", R.drawable.canteen));

            mainAdapter = new MainAdapter(list);
            mainAdapter.setOnItemClickListener(new MainAdapter.ClickListener(){
                @Override
                public void onItemClick(int position, View v) {
                    switch (position){
                        case 0:
                            Intent towerBlock = new Intent(getApplicationContext(), TowerBlock.class);
                            startActivity(towerBlock);
                            break;
                        case 1:
                            Intent lectureBlock = new Intent(getApplicationContext(), LectureBlock.class);
                            startActivity(lectureBlock);
                            break;
                        case 2:
                            Intent canteen = new Intent(getApplicationContext(), Outdoor.class);
                            startActivity(canteen);
                            break;
                        case 3:
                            Intent outdoor = new Intent(getApplicationContext(), Canteen.class);
                            startActivity(outdoor);
                            break;
                        case 4:
                            Intent geoLocation = new Intent(getApplicationContext(), GeographicalLocation.class);
                            startActivity(geoLocation);
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
