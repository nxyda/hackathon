package com.example.hackathon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuildingBank extends Building{

    public BuildingBank() {
        super("Bank");
    }

    @Override
    public List<String> getAction() {
        return Arrays.asList("Wez kredyt", "Zaloz lokate", "Zainwestuj w obligacje");
    }
}
