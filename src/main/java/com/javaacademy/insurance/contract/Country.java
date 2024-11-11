package com.javaacademy.insurance.contract;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Country {
    JAPAN("Япония"), BRAZIL("Бразилия");

    final String name;

    @Override
    public String toString() {
        return name;
    }
}
