package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.models.EducationEnum;

import java.util.ArrayList;
import java.util.List;

public class CharacterCreatorActivity extends AppCompatActivity {

    Button buttonDalej = findViewById(R.id.dalej);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creator);

        setupButtonWithImage(R.id.mezczyzna, R.id.mezczyzna_image);
        setupButtonWithImage(R.id.literatura, R.id.literatura_image);

        setupButtonWithImage(R.id.kobieta, R.id.kobeita_image);
        setupButtonWithImage(R.id.muzyka, R.id.muzyka_image);
        setupButtonWithImage(R.id.sport, R.id.sport_image);
        setupButtonWithImage(R.id.nauka, R.id.nauka_image);
        setupButtonWithImage(R.id.sztuka, R.id.sztuka_image);
        setupButtonWithImage(R.id.internet, R.id.internet_image);
        setupButtonWithImage(R.id.gotowanie, R.id.gotowanie_image);
//        setupButtonWithImage(R.id.inwestowanie, R.id.inwestowanie_image);
        setupButtonWithImage(R.id.filmy, R.id.filmy_image);
        setupButtonWithImage(R.id.literatura, R.id.literatura_image);
        setupButtonWithImage(R.id.srednie, R.id.srednie_image);
        setupButtonWithImage(R.id.wyzsze, R.id.wyzsze_image);

        buttonDalej.setOnClickListener(v -> {
            nextScreen();
        });

    }

    private void setupButtonWithImage(int buttonId, int imageId) {
        Button button = findViewById(buttonId);
        ImageView imageView = findViewById(imageId);

        button.setOnClickListener(v -> {
            imageView.setImageResource(R.drawable.button_green);
        });
    }

    private void nextScreen() {
        Postac player = new Postac();

        ImageView mezczyznaImage = findViewById(R.id.mezczyzna_image);
        ImageView kobietaImage = findViewById(R.id.kobeita_image);

        if (isGreen(mezczyznaImage)) {
            player.setGender('M');
        } else if (isGreen(kobietaImage)) {
            player.setGender('K');
        }

        ImageView srednieImage = findViewById(R.id.srednie_image);
        ImageView wyzszeImage = findViewById(R.id.wyzsze_image);

        if (isGreen(srednieImage)) {
            player.setEducation(EducationEnum.valueOf("Średnie"));
        } else if (isGreen(wyzszeImage)) {
            player.setEducation(EducationEnum.valueOf("Wyższe"));
        }


        List<String> hobbys = new ArrayList<>();

        if (isGreen(findViewById(R.id.sport_image))) hobbys.add("Sport");
        if (isGreen(findViewById(R.id.nauka_image))) hobbys.add("Nauka");
        if (isGreen(findViewById(R.id.sztuka_image))) hobbys.add("Sztuka");
        if (isGreen(findViewById(R.id.muzyka_image))) hobbys.add("Muzyka");
        if (isGreen(findViewById(R.id.internet_image))) hobbys.add("Internet");
        if (isGreen(findViewById(R.id.gotowanie_image))) hobbys.add("Gotowanie");
        if (isGreen(findViewById(R.id.filmy_image))) hobbys.add("Filmy");
        if (isGreen(findViewById(R.id.literatura_image))) hobbys.add("Literatura");

        player.setHobbys(hobbys);



        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("playerObj", player);
        startActivity(intent);
    }

    private boolean isGreen(ImageView imageView) {
        Object tag = imageView.getTag();
        return tag != null && tag.equals("green");
    }
}
