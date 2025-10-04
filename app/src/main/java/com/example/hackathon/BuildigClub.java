package com.example.hackathon;

import java.util.Arrays;
import java.util.List;

public class BuildigClub extends Building{

    public BuildigClub() {
        super("Klub");
    }


    @Override
    public List<String> getAction() {
        return Arrays.asList("Potańcz", "Zaproś kogoś na impreze", "Kup cos w barze");
    }
}
