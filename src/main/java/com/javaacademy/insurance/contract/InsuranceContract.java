package com.javaacademy.insurance.contract;

import com.javaacademy.insurance.util.Generator;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class InsuranceContract {
    @Getter
    private final String contractNumber = Generator.generateUniqueIdContract();
    @Getter
    @Setter
    private BigDecimal contribution = BigDecimal.ZERO;
    private BigDecimal coverage = BigDecimal.ZERO;
    @Setter
    private Currency currency;
    private final String fullName;
    @Setter
    private Country country;
    private final InsuranceType insuranceType;
    @Setter
    private StatusType statusType;

    public InsuranceContract(BigDecimal coverage, String fullName, InsuranceType insuranceType, StatusType statusType) {
        this.coverage = this.coverage.add(coverage);
        this.fullName = fullName;
        this.insuranceType = insuranceType;
        this.statusType = statusType;
    }
}
