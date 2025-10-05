package com.example.hackathon.actions;

import com.example.hackathon.models.StatsModification;

public class ZusActions {
    public static final Action ike = new Action(
            "Chcę Wpłacić na IKE",
            "Załóż mi ike w zus i opowiedz mi o tym",
            null,
            new StatsModification(
                    0,
                    0,
                    null,
                    -1000,
                    -5,
                    null,
                    null,
                    0,
                    0
            )
    );

}
