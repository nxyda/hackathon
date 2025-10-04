package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.models.NPC;
import com.example.hackathon.npc.NPCBuilder;
import com.example.hackathon.tools.ListElementRandomizer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class Building implements Serializable {
    private String name;
    private List<NPC> npcs;

    public Building(String name) {
        this.name = name;
        this.npcs = generateNPCs();
    }
    public abstract String getJobName();


    public String getName() {
        return name;
    }

    public List<NPC> generateNPCs(){
        List<NPC> lista = new ArrayList<NPC>();
        for(int i = 0; i < 5; i ++){
            lista.add(NPCBuilder.buildBasic(getJobName(), "worker", getAction()));
        }
        return lista;
    }

    public NPC getNPC(){
        return ListElementRandomizer.getRandomElement(npcs);
    }

    public abstract List<Action> getAction();

}


