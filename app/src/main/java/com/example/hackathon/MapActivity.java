package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

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

        for (int id : buttonIds) {
            Button b = findViewById(id);
            b.setOnClickListener(v -> {
                // Przeniesienie do MainActivity
                Intent intent = new Intent(MapActivity.this, TestActivity.class);
                startActivity(intent);
            });
        }
    }
}
