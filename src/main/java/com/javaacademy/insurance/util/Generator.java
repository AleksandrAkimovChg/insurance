package com.javaacademy.insurance.util;

public class Generator {

    /**
     * Уникальный идентификатор договора страхования
     */
    public static String generateUniqueIdContract() {
        return String.valueOf(System.currentTimeMillis());
    }
}
