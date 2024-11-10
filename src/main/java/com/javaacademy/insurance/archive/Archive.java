package com.javaacademy.insurance.archive;

import com.javaacademy.insurance.contract.InsuranceContract;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class Archive {
    @Getter
    private static Map<String, InsuranceContract> allContracts = new HashMap<>();
}
