package com.example.hackathon;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BuildingActivity extends AppCompatActivity {

    private Postac player;
    private Building building;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        player = (Postac) getIntent().getSerializableExtra("playerObj");
        building = (Building) getIntent().getSerializableExtra("buildingObj");

        Button choiceB = findViewById(R.id.choice1);
        Button choice2 = findViewById(R.id.choice2);
        Button choice3 = findViewById(R.id.choice3);
    }

}
