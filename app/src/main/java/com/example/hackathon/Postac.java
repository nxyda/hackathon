package com.example.hackathon;

import java.io.Serializable;
import java.util.List;

public class Postac implements Serializable {
    private String name;
    private char gender;
    private int health;
    private int age;
    private String education;
    private String carer;
    private int income;
    private int money;
    private int happiness;
    private int retiring;
    private int successPoint;
    private String live;
    private String personality;

    private List<String> hobbys;

    private List<Postac> friends;

    public Postac() {
        this.health = 100;
        this.happiness = 100;
        this.money = 1000;
        this.age = 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAge() {return age;}

    public void setAge(int age) {}

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCarer() {
        return carer;
    }

    public void setCarer(String carer) {
        this.carer = carer;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getRetiring() {
        return retiring;
    }

    public void setRetiring(int retiring) {
        this.retiring = retiring;
    }

    public int getSuccessPoint() {
        return successPoint;
    }

    public void setSuccessPoint(int successPoint) {
        this.successPoint = successPoint;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public List<Postac> getFriends() {
        return friends;
    }

    public void setFriends(List<Postac> friends) {
        this.friends = friends;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getPersonality() {return personality;}

    public void setPersonality(String personality) {this.personality = personality;}

    public void applyEvent(Event event) {

        this.health += event.getHealth();
        if (this.health > 100) this.health = 100;
        if (this.health < 0) this.health = 0;

        this.happiness += event.getHappiness();
        if (this.happiness > 100) this.happiness = 100;
        if (this.happiness < 0) this.happiness = 0;

        this.money += event.getMoney();
        if (this.money < 0) this.money = 0;

    }
}
