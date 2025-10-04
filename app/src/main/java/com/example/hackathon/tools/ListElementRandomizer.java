package com.example.hackathon.tools;

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
}
