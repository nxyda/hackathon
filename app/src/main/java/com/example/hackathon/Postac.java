package com.example.hackathon;

import com.example.hackathon.models.EducationEnum;
import com.example.hackathon.models.GenderEnum;

import java.io.Serializable;
import java.util.List;

public abstract class Postac implements Serializable {

    public static int maxPoints;
    public static String name;
    public static GenderEnum gender;
    public static int health = 100;
    public static int age = 18;
    public static EducationEnum education;
    public static String carer;
    public static int income;
    public static int money = 1000;
    public static int happiness = 100;
    public static int retiring;
    public static int successPoint;
    public static String live;
    public static String personality;
    public static List<String> hobbys;
    public static List<Postac> friends;

    public static void applyEvent(Event event) {
        health += event.getHealth();
        if (health > 100) health = 100;
        if (health < 0) health = 0;

        happiness += event.getHappiness();
        if (happiness > 100) happiness = 100;
        if (happiness < 0) happiness = 0;

        money += event.getMoney();
        if (money < 0) money = 0;
    }
}
