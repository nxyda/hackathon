package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.buildings.Building;

public class BuildingActivity extends AppCompatActivity {

    private Postac player;
    private Building building;
    private Button back;

//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        player = (Postac) getIntent().getSerializableExtra("playerObj");
        building = (Building) getIntent().getSerializableExtra("buildingObj");

        Button choice1 = findViewById(R.id.choice1);
        Button choice2 = findViewById(R.id.choice2);
        Button choice3 = findViewById(R.id.choice3);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(BuildingActivity.this, MapActivity.class);
            intent.putExtra("playerObj", player);
            intent.putExtra("buildingObj", building);
            startActivity(intent);
        });
    }

}
