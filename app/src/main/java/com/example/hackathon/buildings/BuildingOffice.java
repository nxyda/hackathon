package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.actions.OfficeActions;

import java.util.Arrays;
import java.util.List;

public class BuildingOffice extends Building implements Workplace {
    public BuildingOffice() {
        super("Biurowiec");
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
        return Arrays.asList(
                OfficeActions.meetCoworkers,
                OfficeActions.work,
                OfficeActions.promotionRequest
        );
    }
}
