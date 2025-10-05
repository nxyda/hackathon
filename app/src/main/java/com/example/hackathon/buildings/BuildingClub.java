package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.actions.ClubActions;
import com.example.hackathon.models.NPC;
import com.example.hackathon.npc.NPCManager;
import com.example.hackathon.tools.ListElementRandomizer;

import java.util.Arrays;
import java.util.List;

public class BuildingClub extends Building {

    public BuildingClub() {
        super("Klub");
    }


    @Override
    public String getJobName() {
        return "Klubowicz";
    }

    @Override
    public int getWorkersNumber() {
        return 5;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(ClubActions.dance, ClubActions.buyDrink);
    }

    @Override
    public List<NPC> generateNPCs() {
        NPCManager.generateNPCs();
        return ListElementRandomizer.pickRandom(NPCManager.npcs, getWorkersNumber());
    }
}
