package com.javaacademy.insurance.util;

public class Generator {
    private static long count = 1;

    /**
     * Уникальный идентификатор договора страхования
     */
    public static String generateUniqueIdContract() {
        return System.currentTimeMillis() + "IS" + count++;
    }



}
