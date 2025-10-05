package com.example.hackathon.actions;

import static java.lang.Math.pow;

import com.example.hackathon.models.StatsModification;
import com.example.hackathon.services.TimeService;
import com.example.hackathon.tools.ListElementRandomizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClubActions {


    public static final Action dance = new Action(
            "Idz potańczyć",
            "Idziemy razem potańczyć w klubie może będzie fajnie",
            ClubActions::danceMechanic,
            new StatsModification(
                    2,
                    0,
                    null,
                    0,
                    5,
                    null,
                    null,
                    0,
                    0
            )
    );
    public static final Action buyDrink = new Action(
            "Kup drinka",
            "Kupujesz i wypijasz drinka",
            () -> new ActionResult(Arrays.asList(ClubActions.dance, ClubActions.buyDrink),""),
            new StatsModification(
                    1,
                    -3,
                    null,
                    -200,
                    5,
                    null,
                    null,
                    0,
                    0
            )
    );
    private static final Action talkAfterDance = new Action(
            "Porozmawiajmy",
            "Poznaliśmy się tańcząc w klubie, od razu konwersacja zczełą się kleić, powiedz coś więcej o sobie",
            ClubActions::chooseToAddContact,
            new StatsModification(
                    0,
                    0,
                    null,
                    0,
                    5,
                    null,
                    null,
                    0,
                    0
            )
    );
    private static final Action leave = new Action("Wyjdź", "Wychodzisz z klubu", null, new StatsModification());


    private static ActionResult chooseToAddContact() {
        List<Action> actions = Arrays.asList(
                new Action("Zapisz kontakt", "", null, new StatsModification(
                        0,
                        0,
                        null,
                        0,
                        0,
                        null,
                        null,
                        10,
                        0
                )),
                leave
        );

        return new ActionResult(actions, "Pojawia się możliwość dodania osoby do kontaktów");
    }


    private static ActionResult danceMechanic() {
        var actions = List.of(talkAfterDance, leave);
        List<Action> a = Collections.singletonList(ListElementRandomizer.getRandomElement(actions));
        String desc= "";
        if (a.get(0).getVisibleName().equals("Wyjdź")) {
            desc = "Niestety nie złapaliście kontaktu";
        }
        return new ActionResult(a, desc);
    }


}
