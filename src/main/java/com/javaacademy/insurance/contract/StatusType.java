package com.javaacademy.insurance.contract;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusType {
    PAID("Оплачено"), UNPAID("Не оплачено");

    final String name;
}
