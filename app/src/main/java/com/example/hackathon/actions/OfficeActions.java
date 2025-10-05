package com.example.hackathon.actions;

import com.example.hackathon.models.StatsModification;
import com.example.hackathon.tools.ListElementRandomizer;

import java.util.Arrays;
import java.util.List;

public class OfficeActions {

    private static final Action workSmall = new Action(
            "Popracuję na 3/4 etatu",
            "",
            null,
            new StatsModification(7, -4, null, 3000, -5, null, null, 0, 0)
    );
    private static final Action workNormal = new Action(
            "Popracuję na pełen etat",
            "",
            null,
            new StatsModification(8, -6, null, 4000, -6, null, null, 0, 0)
    );
    private static final Action workBig = new Action(
            "Będę robił nadgodziny", "", null, new StatsModification(
            10, -10, null, 6000, -10, null,

            null, 0, 0
    )
    );
    public static final Action work = new Action(
            "Chcę pracować",
            "Przychodzę do mojej parcy by zadecydować na jaki wymiar umowy o pracę chcę mieć (3/4, pełną, robić nadgodziny), zapytaj mnie oto, traktuj prace abstrakcyjnie",
            OfficeActions::chooseWorkTime,
            new StatsModification()
    );
    private static final Action smallTalk = new Action(
            "Small talk",
            "",
            () -> new ActionResult(List.of(work), ""),
            new StatsModification(
                    0,
                    0,
                    null,
                    0,
                    1,
                    null,
                    null,
                    0,
                    0
            )
    );
    private static final Action getContact = new Action(
            "Poprosze kontakt",
            "",
            () -> new ActionResult(List.of(work), ""),
            new StatsModification(
                    0,
                    -4,
                    null,
                    0,
                    3,
                    null,
                    null,
                    0,
                    10
            )
    );
    private static final Action leave = new Action(
            "Wyjdź",
            "",
            () -> new ActionResult(List.of(work), ""),
            new StatsModification()
    );
    private static final Action deepTalk = new Action(
            "Porozmawiajmy więcej",
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
            new StatsModification(
                    1,
                    0,
                    null,
                    0,
                    1,
                    null,
                    null,
                    0,
                    0
            )
    );
    public static final Action promotionRequest = new Action(
            "Proszę o podwyżkę",
            "Przychodze do szefa po podwyżkę, musisz mi znacząco jej odmówić.",
            () -> new ActionResult(Arrays.asList(meetCoworkers, OfficeActions.work), ""),
            new StatsModification(
                    1,
                    0,
                    null,
                    0,
                    -4,
                    null,
                    null,
                    0,
                    0
            )
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
