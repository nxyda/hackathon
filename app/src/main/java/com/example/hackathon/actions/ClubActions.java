package com.example.hackathon.actions;

import com.example.hackathon.models.StatsModification;
import com.example.hackathon.tools.ListElementRandomizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClubActions {


    public static final Action dance = new Action(
            "Idz potańczyć",
            "Jest możliwość poznania kogoś w tanecznych klimatach klubowych",
            ClubActions::danceMechanic,
            new StatsModification()
    );
    public static final Action buyDrink = new Action(
            "Kup drinka",
            "Kupujesz i wypijasz drinka",
            () -> new ActionResult(Arrays.asList(ClubActions.dance, ClubActions.buyDrink),""),
            new StatsModification()
    );
    private static final Action talkAfterDance = new Action(
            "Porozmawiaj z daną osobą",
            "Prowadzicie miłą rozmowe i poznana osoba mile opowiada o sobie",
            ClubActions::chooseToAddContact,
            new StatsModification()
    );
    private static final Action leave = new Action("Wyjdź", "Wychodzisz z klubu", null, new StatsModification());


    private static ActionResult chooseToAddContact() {
        List<Action> actions = Arrays.asList(
                new Action("Zapisz kontakt", "", null, new StatsModification()),
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
