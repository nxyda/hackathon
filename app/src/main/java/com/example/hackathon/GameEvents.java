package com.example.hackathon;

import java.util.ArrayList;
import java.util.List;

public class GameEvents {

    public static List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        events.add(new Event("Wypadek", "Miałeś wypadek, zdrowie spada!", -30, -10, 0));
        events.add(new Event("Pandemia", "Lockdown – możesz pracować tylko zdalnie", 0, -5, 0));
        events.add(new Event("Powódź", "Twój dom został zalany, straciłeś pieniądze!", 0, -20, -10000));
        events.add(new Event("Strata na giełdzie", "Zainwestowałeś źle i straciłeś pieniądze", 0, -10, -5000));
        events.add(new Event("Śmierć przyjaciela", "Tracisz bliską osobę...", 0, -50, 0));
        events.add(new Event("Uzależnienie", "Wpadłeś w uzależnienie, szczęście spada", -10, -30, 0));
        events.add(new Event("Rozwód", "Rozwiodłeś się – szczęście spada", 0, -40, 0));
        events.add(new Event("Nowy przyjaciel", "Poznałeś nowego znajomego!", 0, +20, 0));
        events.add(new Event("Krach na rynku pracy", "Utraciłeś pracę", 0, -20, 0));
        events.add(new Event("Choroba", "Zachorowałeś", -20, -15, 0));
        events.add(new Event("Wyjazd", "Pojechałeś na wakacje z rodziną", 0, +20, -2000));
        events.add(new Event("Nowe hobby", "Znalazłeś nowe hobby!", 0, +10, 0));
        events.add(new Event("Wpadka", "Masz dziecko!", 0, 0,  0));
        events.add(new Event("Remont", "Robisz remont, dużo wydatków", 0, -10, -8000));
        events.add(new Event("Awans", "Dostałeś awans!", 0, +20, +3000));
        events.add(new Event("Pochwała", "Szef cię pochwalił", 0, +10, 0));
        events.add(new Event("Kłótnia ze znajomym", "Pokłóciłeś się z przyjacielem", 0, -20, 0));
        events.add(new Event("Złamanie nogi", "Złamałeś nogę, zdrowie spada!", -10, -10, 0));
        events.add(new Event("Wesele", "Byłeś na weselu – świetna zabawa!", 0, +30, -1000));
        events.add(new Event("Stary znajomy", "Odezwał się do ciebie stary znajomy", 0, +10, 0));
        events.add(new Event("Wybory", "Wyniki wyborów wpłynęły na ciebie", 0, +10, 0));
        events.add(new Event("Event sportowy", "Byłeś na meczu – świetne emocje!", 0, +10, -100));
        events.add(new Event("Kradzież", "Zostałeś okradziony!", 0, -20, -2000));
        events.add(new Event("Inflacja", "Twoje oszczędności tracą wartość", 0, -15, -3000));
        events.add(new Event("Mandat", "Dostałeś mandat za złe parkowanie", 0, -5, -300));
        events.add(new Event("Spotkanie idola", "Spotkałeś swojego idola!", 0, +50, 0));
        events.add(new Event("Kłótnia w rodzinie", "Pokłóciłeś się z rodziną", 0, -20, 0));
        events.add(new Event("Awaria auta", "Auto się zepsuło, musisz płacić za naprawę", 0, -10, -2000));

        return events;
    }

}
