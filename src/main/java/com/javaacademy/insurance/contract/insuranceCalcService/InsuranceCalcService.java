package com.javaacademy.insurance.contract.insuranceCalcService;

import com.javaacademy.insurance.contract.InsuranceType;

import java.math.BigDecimal;

public interface InsuranceCalcService {

    /**
     * Возвращает стоимость страховки. На вход сумма покрытия, тип страховки.
     */
    BigDecimal calculateContribution(BigDecimal coverage, InsuranceType insuranceType);
}
