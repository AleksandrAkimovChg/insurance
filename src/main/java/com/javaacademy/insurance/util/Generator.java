package com.javaacademy.insurance.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Generator {
    private long count = 1;
    @Value("${app.country}")
    Country country;

    /**
     * Уникальный идентификатор договора страхования
     */
    public String generateUniqueIdContract() {
        return System.currentTimeMillis() + country.getIndex() + count++;
    }
}
