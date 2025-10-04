package com.example.hackathon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuildingZus extends Building{
    public BuildingZus() {
        super("ZUS");
    }

    @Override
    public List<String> getAction() {
        return Arrays.asList("Złóż wniosek o rente", "Złóż wniosek o emeryture", "Zgłoś ubezpieczenie");
    }
}
