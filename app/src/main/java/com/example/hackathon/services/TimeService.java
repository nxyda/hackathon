package com.example.hackathon.services;

import com.example.hackathon.Postac;
import com.example.hackathon.models.StatsModification;

import java.util.ArrayList;
import java.util.List;

public class TimeService {
    public static final int AGE_STEP = 5;
    private static  List<StatsModification> statChanges = new ArrayList<>();

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

    private static void clear(){
        statChanges = new ArrayList<>();
    }

    public static void apply() {
        for (StatsModification change : statChanges) {
            Postac.age += AGE_STEP;

            if (change.getEducation() != null) {
                Postac.education = change.getEducation();
            }
            if (change.getLive() != null) {
                Postac.live = change.getLive();
            }
            if (change.getHealthChange() != 0) {
                Postac.live += change.getHealthChange();
            }
            if (change.getHappiness() != 0) {
                Postac.live += change.getHappiness();
            }
            if (change.getNpc() != null) {
                change.getNpc()
                        .getRelation()
                        .setRomantic(change.getNpc()
                                .getRelation()
                                .getRomantic() + change.getRelationChange());
                change.getNpc()
                        .getRelation()
                        .setFriendship(change.getNpc()
                                .getRelation()
                                .getFriendship() + change.getFriendshipChange());
            }

            Postac.money += change.getIncome();
        }

        Postac.maxPoints = Postac.age / 20;
        Postac.maxPoints -= (100 - Postac.health)/ 30;
        if(Postac.happiness < 30){
            Postac.health -= (30 - Postac.happiness) /2;

        }
        if(Postac.health < 70){
            Postac.happiness -= (70 - Postac.health) /3;
        }


    }
}
