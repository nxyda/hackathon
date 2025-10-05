package com.example.hackathon.npc;

import com.example.hackathon.models.NPC;

import java.util.ArrayList;
import java.util.List;

public class NPCManager {
    public static ArrayList<NPC> npcs = new ArrayList<NPC>();

    public static void generateNPCs(){
        if(!npcs.isEmpty()){
            return;
        }

        for(int i = 0; i < 5; i++){
            npcs.add(NPCBuilder.buildBasic("Bankier", "worker", new ArrayList<>()));
        }

        for(int i = 0; i < 10; i++){
            npcs.add(NPCBuilder.buildBasic("pracownik biurowy", "worker", new ArrayList<>()));
        }
        for(int i = 0; i < 5; i++){
            npcs.add(NPCBuilder.buildBasic("pracownik zus", "worker", new ArrayList<>()));
        }
    }
}
