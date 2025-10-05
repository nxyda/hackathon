package com.example.hackathon.npc;

import com.example.hackathon.actions.Action;
import com.example.hackathon.models.GenderEnum;
import com.example.hackathon.models.NPC;
import com.example.hackathon.models.Relation;
import com.example.hackathon.models.RelationTraitEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NPCBuilder {
    private static final Random random = new Random();
    private static int _id = 0;
    private int id;
    private String name;
    private String job;
    private String type;
    private Relation relation;
    private List<Action> actions = new ArrayList<>();
    private GenderEnum gender;

    private static int get_next_id() {
        return _id++;
    }

    public static NPC buildBasic(String job, String typ, List<Action> jobActions) {
        String[] names = {
                "Eryk", "Mira", "Tomasz", "Lena",
                 "Iga", "Borys", "Zofia",
                "Piotr", "Natalia", "Ania", "Bartek",
                "Maks", "Małgorzata", "Olek",
                "Adam", "Agnieszka", "Kacper", "Marcelina", "Olaf"
        };

        String name = names[random.nextInt(names.length)];
        GenderEnum gender = GenderEnum.MALE;
        if (name.toCharArray()[name.length() - 1] == 'a') {
            gender = GenderEnum.FEMALE;
        }

        int romantic = 0;
        int friendship = 0;
        RelationTraitEnum trait = RelationTraitEnum.getEntries()
                .get(random.nextInt(RelationTraitEnum.values().length));
        Relation relation = new Relation(romantic, friendship, trait);


        return new NPCBuilder()
                .setId(get_next_id())
                .setName(name)
                .setJob(job)
                .setType(typ)
                .setRelation(relation)
                .setActions(jobActions)
                .setGender(gender)
                .build();
    }

    public NPCBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public NPCBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public NPCBuilder setJob(String job) {
        this.job = job;
        return this;
    }

    public NPCBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public NPCBuilder setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public NPCBuilder setRelation(Relation relation) {
        this.relation = relation;
        return this;
    }

    public NPCBuilder addAction(Action action) {
        this.actions.add(action);
        return this;
    }

    public NPCBuilder setActions(List<Action> actions) {
        this.actions = actions;
        return this;
    }

    public NPC build() {

        return new NPC(id, name, job, type, relation, actions, gender);

    }
}
