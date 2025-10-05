package com.example.hackathon.services;

import com.example.hackathon.Postac;
import com.example.hackathon.models.StatsModification;

import java.util.ArrayList;
import java.util.List;

public class TimeService {
    private static final List<StatsModification> statChanges = new ArrayList<>();

    public static void addChange(StatsModification change) {
        statChanges.add(change);
    }

    public static int pointsLeft() {
        int points = 0;
        for (StatsModification change : statChanges) {
            points += change.getCost();
        }

        return Postac.maxPoints - points;
    }

    public static void apply(){

    }
}
