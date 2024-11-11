package com.javaacademy.insurance.archive;

import com.javaacademy.insurance.contract.InsuranceContract;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Archive {
    @Getter
    private static Map<String, InsuranceContract> allContracts = new HashMap<>();
}
