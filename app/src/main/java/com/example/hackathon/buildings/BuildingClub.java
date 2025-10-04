package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.actions.ClubActions;
import com.example.hackathon.models.StatsModification;

import java.util.ArrayList;
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
    public List<Action> getAction()  {
        return Arrays.asList(ClubActions.dance, ClubActions.buyDrink);
    }
}
