package com.example.hackathon;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.models.NPC;
import com.example.hackathon.npc.NPCManager;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends AppCompatActivity {

    private List<String> friendsList = new ArrayList<>();
    private ScrollView friendsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        friendsContainer = findViewById(R.id.scroll_container);

        NPCManager.generateNPCs();

        Postac.friends.addAll(NPCManager.npcs);

        displayNPCFriends();
    }

    private void displayNPCFriends() {
        friendsContainer.removeAllViews();

        for (NPC npc : NPCManager.npcs) {
            ImageView profileImage = new ImageView(this);
            profileImage.setImageResource(R.drawable.osoba);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 150);
            params.setMargins(0, 16, 0, 16);
            profileImage.setLayoutParams(params);

            profileImage.setContentDescription(npc.getName() + " profil");

            friendsContainer.addView(profileImage);
        }
    }

}
