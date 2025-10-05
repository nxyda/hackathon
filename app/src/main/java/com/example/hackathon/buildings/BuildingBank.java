package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.actions.BankActions;

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
    public int getWorkersNumber() {
        return 5;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(BankActions.getLoan, BankActions.takeDeposit);
    }
}
