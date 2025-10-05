package com.example.hackathon.actions;

import com.example.hackathon.models.StatsModification;

import java.util.Arrays;

public class BankActions {
    private static final Action getLoan20000 = new Action(
            "Chcę 20000zł",
            "",
            null,
            new StatsModification()
    );
    private static final Action getLoan5000 = new Action(
            "Chcę 5000zł",
            "",
            () -> new ActionResult(Arrays.asList(BankActions.getLoan, BankActions.takeDeposit), ""),
            new StatsModification()
    );
    private static final Action getLoan50000 = new Action(
            "Chcę 50000zł",
            "",
            () -> new ActionResult(Arrays.asList(BankActions.getLoan, BankActions.takeDeposit), ""),
            new StatsModification()
    );
    private static final Action getNoneLoan = new Action(
            "Wycofuje się",
            "",
            () -> new ActionResult(Arrays.asList(BankActions.getLoan, BankActions.takeDeposit), ""),
            new StatsModification()
    );
    private static final Action takeDeposit1000 = new Action(
            "Wpłacę 1000zł",
            "",
            () -> new ActionResult(Arrays.asList(BankActions.getLoan, BankActions.takeDeposit), ""),
            new StatsModification()
    );
    private static final Action takeDeposit5000 = new Action(
            "Wpłacę 5000zł",
            "",
            () -> new ActionResult(Arrays.asList(BankActions.getLoan, BankActions.takeDeposit), ""),
            new StatsModification()
    );
    private static final Action takeDeposit10000 = new Action(
            "Wpłacę 10000 zł",
            "",
            () -> new ActionResult(Arrays.asList(BankActions.getLoan, BankActions.takeDeposit), ""),
            new StatsModification()
    );
    private static final Action takeNonDeposit = new Action(
            "Wycofuje się",
            "",
            () -> new ActionResult(Arrays.asList(BankActions.getLoan, BankActions.takeDeposit), ""),
            new StatsModification()
    );
    public static final Action takeDeposit = new Action(
            "Chciałby wpłacić na lokate",
            "Przyszedłem do banku wpłacić na lokate o oprocenotwaniu rocznym 4% (powiedz mi o tym) kwote od 1000-10000 zł spytaj mnie o nią. W następnej odpowiedzi kwota zostanie sprecyzowana",
            () -> new ActionResult(
                    Arrays.asList(
                            takeDeposit1000,
                            takeDeposit5000,
                            takeDeposit10000,
                            takeNonDeposit
            ), ""
            ),
            new StatsModification()
    );
    public static final Action getLoan = new Action(
            "Chciałbym wziąć porzyczkę",
            "Przyszedłem do banku dostać kwote pieniędzy od 5000 to 50000 na co będę odpowiadał w następnej odpowiedzi, zapytaj mnie oto jak dużą chce porzyczkę",
            () -> new ActionResult(
                    Arrays.asList(
                            getLoan5000,
                            getLoan20000,
                            getLoan50000,
                            getNoneLoan
            ), ""
            ),
            new StatsModification()
    );


}
