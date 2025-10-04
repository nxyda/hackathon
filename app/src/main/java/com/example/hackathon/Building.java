package com.example.hackathon;

import java.io.Serializable;
import java.util.List;

public abstract class Building implements Serializable {
    private String name;

    public Building(String name) {
        this.name = name;
    }package com.example.hackathon;

import java.io.Serializable;
import java.util.List;

    public abstract class Building implements Serializable {
        private String name;

        public Building(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract List<String> getAction();

    }


    public String getName() {
        return name;
    }

    public abstract List<String> getAction();

}
