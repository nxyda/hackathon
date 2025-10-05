package com.example.hackathon.tools;

import java.util.Objects;

public class EnumRandomize {
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        T[] values = clazz.getEnumConstants();
        return Objects.requireNonNull(values)[new java.util.Random().nextInt(values.length)];
    }
}
