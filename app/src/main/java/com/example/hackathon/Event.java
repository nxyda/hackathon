package com.example.hackathon;

public class Event {

    private String name;
    private String description;
    private int health;
    private int happiness;
    private int money;

    public Event() {}

    public Event(String name, String description, int health, int happiness, int money) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.happiness = happiness;
        this.money = money;
    }

    // --- Gettery ---
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getMoney() {
        return money;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
