package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.buildings.Building;
import com.example.hackathon.buildings.BuildingBank;
import com.example.hackathon.buildings.BuildingClub;
import com.example.hackathon.buildings.BuildingOffice;
import com.example.hackathon.buildings.BuildingPark;

import com.example.hackathon.buildings.Building;
import com.example.hackathon.buildings.BuildingBank;
import com.example.hackathon.buildings.BuildingOffice;

import java.util.List;
import java.util.Random;

public class MapActivity extends AppCompatActivity {

    private ImageView playerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        playerImageView = findViewById(R.id.player);

        moveHome();

        List<Event> events = GameEvents.getAllEvents();
        Event losowy = events.get(new Random().nextInt(events.size()));


        // przyciski mapy
        int[] buttonIds = {
                R.id.button_szpital,
                R.id.button_uczelnia,
                R.id.button_zus,
                R.id.button_galeria,
                R.id.button_bank,
                R.id.button_kino,
                R.id.button_teatr,
                R.id.button_bar,
                R.id.button_klub,
                R.id.button_mieszkanie,
                R.id.button_biurowiec,
                R.id.button_dom,
                R.id.button_silownia,
                R.id.button_restauracja,
                R.id.button_park,
                R.id.button_stadion
        };

        // odpowiadające im budynki
        Building[] buildings = {
//                new BuildingHospital(),
//                new BuildingUniversity(),
//                new BuildingZUS(),
//                new BuildingGallery(),
                new BuildingBank(),
//                new BuildingCinema(),
//                new BuildingTheatre(),
//                new BuildingBar(),
                new BuildingClub(),
//                new BuildingApartment(),
                new BuildingOffice(),
//                new BuildingHouse(),
//                new BuildingGym(),
//                new BuildingRestaurant(),
                new BuildingPark(),
//                new BuildingStadium()
        };

        for (int i = 0; i < buttonIds.length; i++) {
            int index = i;
            Button b = findViewById(buttonIds[i]);
            b.setOnClickListener(v -> {
                Intent intent = new Intent(MapActivity.this, DialogActivity.class);
                intent.putExtra("playerObj", player);
                intent.putExtra("buildingObj", buildings[index]);
                startActivity(intent);
            });
        }

        ImageView phoneButton = findViewById(R.id.phone);
        phoneButton.setOnClickListener(v -> {
            Intent intent = new Intent(MapActivity.this, PhoneActivity.class);
            intent.putExtra("playerObj", player);
            startActivity(intent);
        });
    }

    private void moveHome() {
        if ("House".equals(player.getLive())) {
            playerImageView.setX(60f);
            playerImageView.setY(270f);
        } else {
            playerImageView.setX(250 * getResources().getDisplayMetrics().density);
            playerImageView.setY(240 * getResources().getDisplayMetrics().density);
        }
    }
}
