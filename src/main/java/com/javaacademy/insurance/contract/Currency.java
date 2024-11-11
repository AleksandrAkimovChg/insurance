package com.javaacademy.insurance.contract;

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
