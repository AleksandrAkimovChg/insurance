package com.javaacademy.insurance.util;

import com.javaacademy.insurance.contract.Country;
import org.springframework.beans.factory.annotation.Value;

public class Generator {
    private static long count = 1;

    /**
     * Уникальный идентификатор договора страхования
     */
    public static String generateUniqueIdContract() {
        return System.currentTimeMillis() + "IS" + count++;
    }



}
