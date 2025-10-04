package com.example.hackathon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuildingOffice extends Building{
    public BuildingOffice() {
        super("Biurowiec");
    }

    @Override
    public List<String> getAction() {
        return Arrays.asList("Pójdź do pracy", "Zapytaj o podwyżke", "Porozmawiaj z kolega z pracy");
    }
}
