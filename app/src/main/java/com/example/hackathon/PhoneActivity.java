package com.example.hackathon;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends AppCompatActivity {

    private List<String> friendsList = new ArrayList<>();
    private LinearLayout friendsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        friendsContainer = findViewById(R.id.friends_container);


        displayFriends();
    }

    private void displayFriends() {
        friendsContainer.removeAllViews();

        for (String friend : friendsList) {
            ImageView profileImage = new ImageView(this);
            profileImage.setImageResource(R.drawable.osoba);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 150);
            params.setMargins(0, 16, 0, 16);
            profileImage.setLayoutParams(params);


            profileImage.setContentDescription(friend + " profil");

            friendsContainer.addView(profileImage);
        }
    }
}
