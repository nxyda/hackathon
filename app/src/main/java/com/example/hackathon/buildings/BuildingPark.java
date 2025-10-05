package com.example.hackathon.buildings;

import com.example.hackathon.actions.Action;
import com.example.hackathon.actions.ParkActions;
import com.example.hackathon.models.NPC;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuildingPark extends Building{

    public BuildingPark() {
        super("Park");
    }

    @Override
    public String getJobName() {
        return "";
    }

    @Override
    public int getWorkersNumber() {
        return 0;
    }

    private NPC _npc;
    public void setNPC(NPC npc){
        this._npc = npc;
    }
    @Override()
    public NPC getNPC(){
        return this._npc;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(ParkActions.walk);
    }
}
