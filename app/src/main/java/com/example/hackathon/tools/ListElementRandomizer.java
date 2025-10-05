package com.example.hackathon.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListElementRandomizer {
    private static final Random random = new Random();

    public static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    public static <T> List<T> pickRandom(List<T> source, int n) {
        if (source == null)
            throw new IllegalArgumentException("Lista nie może być null.");
        if (n < 0)
            throw new IllegalArgumentException("Nie można wybrać ujemnej liczby elementów.");

        List<T> copy = new ArrayList<>(source);
        Collections.shuffle(copy, new Random());

        if (n >= copy.size()) {
            return copy; // jak ktoś chce więcej, dostaje wszystko, ale przetasowane
        }

        return copy.subList(0, n);
    }
}
