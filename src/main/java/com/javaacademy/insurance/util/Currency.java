package com.javaacademy.insurance.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Currency {
    YEN("йена"), REAL("реал");

    final String name;

    @Override
    public String toString() {
        return name;
    }
}
