package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.models.NPC;
import com.example.hackathon.npc.NPCManager;
import com.example.hackathon.tools.ListElementRandomizer;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


public abstract class Building implements Serializable {
    private final String name;
    private final List<NPC> npcs;

    public Building(String name) {
        this.name = name;
        this.npcs = generateNPCs();
    }

    public abstract String getJobName();
    public abstract int getWorkersNumber();


    public String getName() {
        return name;
    }

    public List<NPC> generateNPCs() {
        NPCManager.generateNPCs();
        return ListElementRandomizer.pickRandom(
                NPCManager.npcs.stream()
                        .filter(e -> e.getJob().equals(getJobName()))
                        .collect(Collectors.toList()), getWorkersNumber()
        );
    }

    public NPC getNPC() {
        return ListElementRandomizer.getRandomElement(npcs);
    }

    public abstract List<Action> getAction();

}


