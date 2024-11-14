package com.javaacademy.insurance.contract;

import com.javaacademy.insurance.util.Country;
import com.javaacademy.insurance.util.Currency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class InsuranceContract {
    @Getter
    private String contractNumber;
    private BigDecimal contribution = BigDecimal.ZERO;
    private BigDecimal coverage = BigDecimal.ZERO;
    private Currency currency;
    private String fullName;
    private Country country;
    private InsuranceType insuranceType;
    private StatusType statusType = StatusType.UNPAID;
}
