package com.example.hackathon.actions;

import com.example.hackathon.models.StatsModification;

public class ParkActions {
    public static final Action walk = new Action(
            "Choćmy na spacer",
            "Spotykamy się we dwoje w parku i zapraszam cię na spacer",
            null,
            new StatsModification(
                    2,
                    3,
                    null,
                    -100,
                    6,
                    null,
                    null,
                    10,
                    3
            )
    );
}
