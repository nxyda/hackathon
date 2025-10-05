package com.example.hackathon;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.actions.Action;
import com.example.hackathon.actions.ActionResult;
import com.example.hackathon.buildings.Building;
import com.example.hackathon.models.NPC;

import java.util.ArrayList;
import java.util.List;

public class BuildingActivity extends AppCompatActivity {
// @todo Trzeba dodać weryfiacje czy akcja może być pokazana (czy mamy finanse + czy mamy punkty dnia)
    private Building building;
    private NPC npc;
    private List<Action> actions;
    private List<OpenAIClient.Message> history = new ArrayList<>();

    private TextView npcText;
    private Button choice1, choice2, choice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        building = (Building) getIntent().getSerializableExtra("buildingObj");
        npc = building.getNPC();
        actions = new ArrayList<>(building.getAction());

        npcText = findViewById(R.id.konwersacja); // Dodaj w XML np. <TextView android:id="@+id/npcText" .../>
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);

        history.add(new OpenAIClient.Message("user", "Jestem "+ Postac.gender +" i jestem w " + building.getName()));

        updateButtons();

        choice1.setOnClickListener(v -> handleActionClick(0));
        choice2.setOnClickListener(v -> handleActionClick(1));
        choice3.setOnClickListener(v -> handleActionClick(2));
    }

    private void handleActionClick(int index) {
        if (index >= actions.size()) return;

        Action option = actions.get(index);
        actions = new ArrayList<>();

        if (option.getNextActionChooser() != null) {
            ActionResult result = option.getNextActionChooser().invoke();
            actions = result.getActions();
        }

        getResponse(npc, option, newText -> npcText.setText(newText));
        updateButtons();
    }

    private void updateButtons() {
        if (actions.size() > 0) {
            choice1.setText(actions.get(0).getVisibleName());
            choice1.setEnabled(true);
        } else {
            choice1.setText("");
            choice1.setEnabled(false);
        }

        if (actions.size() > 1) {
            choice2.setText(actions.get(1).getVisibleName());
            choice2.setEnabled(true);
        } else {
            choice2.setText("");
            choice2.setEnabled(false);
        }

        if (actions.size() > 2) {
            choice3.setText(actions.get(2).getVisibleName());
            choice3.setEnabled(true);
        } else {
            choice3.setText("");
            choice3.setEnabled(false);
        }
    }

    private void getResponse(NPC npc, Action option, ResponseCallback callback) {
        history.add(new OpenAIClient.Message(
                "user",
                "Mówię: " + option.getVisibleName() + "; chodzi mi o " + option.getDescription()
        ));

        OpenAIClient.sendMessage(
                history,
                "Jesteś " + npc.getName() + ", właśnie rozmawiasz z osobą, która przyszła do ciebie coś i masz się wcielić w rolę "
                        + npc.getJob() + " o usposobieniu " + npc.getRelation().getTrait()
                        + ". Nie zadawaj pytań, odpowiadaj jak człowiek, pozytywnie i krótko.",
                response -> {
                    String reply = "Hmm...";
                    if (response != null && response.getOutput() != null && !response.getOutput().isEmpty()) {
                        var last = response.getOutput().get(response.getOutput().size() - 1);
                        if (last.getContent() != null && !last.getContent().isEmpty()) {
                            reply = last.getContent().get(0).getText();
                        }
                    }

                    history.add(new OpenAIClient.Message("assistant", reply));
                    runOnUiThread(() -> callback.onResponse(reply));
                }
        );
    }

    interface ResponseCallback {
        void onResponse(String newText);
    }
}
