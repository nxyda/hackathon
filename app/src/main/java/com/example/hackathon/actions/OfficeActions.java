package com.example.hackathon.actions;

import com.example.hackathon.models.StatsModification;
import com.example.hackathon.tools.ListElementRandomizer;

import java.util.Arrays;
import java.util.List;

public class OfficeActions {

    private static final Action workSmall = new Action("", "", null, new StatsModification());
    private static final Action workNormal = new Action("", "", null, new StatsModification());
    private static final Action workBig = new Action("", "", null, new StatsModification());
    public static final Action work = new Action(
            "Chcę pracować",
            "Przychodzę do mojej parcy by zadecydować na jaki wymiar umowy o pracę chcę mieć (3/4, pełną, robić nadgodziny), zapytaj mnie oto, traktuj prace abstrakcyjnie",
            OfficeActions::chooseWorkTime,
            new StatsModification()
    );
    private static final Action smallTalk = new Action(
            "",
            "",
            () -> new ActionResult(List.of(work), ""),
            new StatsModification()
    );
    private static final Action getContact = new Action(
            "",
            "",
            () -> new ActionResult(List.of(work), ""),
            new StatsModification()
    );
    private static final Action leave = new Action(
            "",
            "",
            () -> new ActionResult(List.of(work), ""),
            new StatsModification()
    );
    private static final Action deepTalk = new Action(
            "",
            "",
            () -> new ActionResult(
                    Arrays.asList(OfficeActions.getContact, OfficeActions.leave),
                    ""
            ),
            new StatsModification()
    );
    public static final Action meetCoworkers = new Action(
            "Porozmawiaj z zespołem",
            "",
            OfficeActions::meetingCoworkers,
            new StatsModification()
    );
    public static final Action promotionRequest = new Action(
            "Proszę o podwyżkę",
            "Przychodze do szefa po podwyżkę, musisz mi znacząco jej odmówić.",
            () -> new ActionResult(Arrays.asList(meetCoworkers, OfficeActions.work), ""),
            new StatsModification()
    );

    private static ActionResult meetingCoworkers() {
        var actions = Arrays.asList(smallTalk, smallTalk, smallTalk, smallTalk, deepTalk);
        return new ActionResult(ListElementRandomizer.pickRandom(actions, 1), "");
    }

    private static ActionResult chooseWorkTime() {
        var actions = Arrays.asList(workSmall, workNormal, workBig);

        return new ActionResult(actions, "");
    }


}
