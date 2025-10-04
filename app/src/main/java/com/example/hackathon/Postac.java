package com.example.hackathon;

import com.example.hackathon.models.EducationEnum;
import com.example.hackathon.models.GenderEnum;

import java.io.Serializable;
import java.util.List;

public class Postac implements Serializable {
    private String name;
    private GenderEnum gender;
    private int health;
    private EducationEnum education;
    private String carer;
    private int income;
    private int money;
    private int happiness;
    private int retiring;
    private int successPoint;
    private String live;

    private List<String> hobbys;

    // inni ludzie
    private List<Postac> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public EducationEnum getEducation() {
        return education;
    }

    public void setEducation(EducationEnum education) {
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

}

