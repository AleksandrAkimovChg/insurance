package com.javaacademy.insurance.contract;

import com.javaacademy.insurance.util.Generator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

public class InsuranceContract {
    private static long postfix;
    @Getter
    @Setter
    private String contractNumber = Generator.generateUniqueIdContract() + "_" + postfix++;
    @Getter
    @Setter
    private BigDecimal contribution = BigDecimal.ZERO;
    @Setter
    private BigDecimal coverage = BigDecimal.ZERO;
    @Setter
    private Currency currency;
    private String fullName;
    @Setter
    private Country country;
    private InsuranceType insuranceType;
    @Setter
    private StatusType statusType;

    public InsuranceContract(BigDecimal coverage, String fullName, InsuranceType insuranceType, StatusType statusType) {
        this.coverage = this.coverage.add(coverage);
        this.fullName = fullName;
        this.insuranceType = insuranceType;
        this.statusType = statusType;
    }
}
