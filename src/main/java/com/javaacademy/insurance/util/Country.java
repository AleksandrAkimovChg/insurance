package com.javaacademy.insurance.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Country {
    JAPAN("Япония", "J"), BRAZIL("Бразилия", "BR");

    private final String name;
    @Getter
    private final String index;

    @Override
    public String toString() {
        return name;
    }
}
