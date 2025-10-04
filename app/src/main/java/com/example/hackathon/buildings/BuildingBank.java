package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.models.StatsModification;

import java.util.Arrays;
import java.util.List;

public class BuildingBank extends Building {

    public BuildingBank() {
        super("Bank");
    }

    @Override
    public String getJobName() {
        return "Bankier";
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(


        );
    }
}
