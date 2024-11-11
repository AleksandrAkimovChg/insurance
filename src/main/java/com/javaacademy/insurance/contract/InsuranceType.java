package com.javaacademy.insurance.contract;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InsuranceType {
    MEDICAL("\"Медицинское страхование\""), ROBBERY_PROTECTION("\"Защита от грабежа\"");

    final String name;

    @Override
    public String toString() {
        return name;
    }
}
