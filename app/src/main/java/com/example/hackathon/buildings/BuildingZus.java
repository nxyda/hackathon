package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;

import java.util.Arrays;
import java.util.List;

public class BuildingZus extends Building{
    public BuildingZus() {
        super("ZUS");
    }

    @Override
    public String getJobName() {
        return "";
    }

    @Override
    public int getWorkersNumber() {
        return 5;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList();
    }
}
