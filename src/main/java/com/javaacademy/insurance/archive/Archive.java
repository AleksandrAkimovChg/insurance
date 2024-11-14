package com.javaacademy.insurance.archive;

import com.javaacademy.insurance.contract.InsuranceContract;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Archive {
    @Getter
    private final Map<String, InsuranceContract> allContracts = new HashMap<>();
}
