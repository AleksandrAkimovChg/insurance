package com.javaacademy.insurance.contract.insuranceService;

import com.javaacademy.insurance.contract.Country;
import com.javaacademy.insurance.contract.Currency;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.contract.insuranceCalcService.InsuranceCalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile(value = "brazil")
@Component
@Slf4j
public class InsuranceServiceBrazilImpl implements InsuranceService {
    InsuranceCalcService calcService;
    @Value("${brazil.currency}")
    Currency currency;
    @Value("${brazil.country}")
    Country country;

    public InsuranceServiceBrazilImpl(@Qualifier("insuranceCalcBrazilServiceImpl") InsuranceCalcService calcService) {
        this.calcService = calcService;
    }

    @Override
    public InsuranceContract getInsuranceOffer(BigDecimal coverage, String fullName, InsuranceType insuranceType) {
        log.info("Начинаю формировать предложение для суммы покрытия {}. ФИО клиента: {}. Тип страховки: {}.",
                coverage, fullName, insuranceType);
        InsuranceContract insuranceOffer = InsuranceService.super.getInsuranceOffer(coverage, fullName, insuranceType);
        BigDecimal contribution = insuranceOffer
                .getContribution()
                .add(calcService.calculateContribution(coverage, insuranceType));
        insuranceOffer.setContribution(contribution);
        insuranceOffer.setCurrency(currency);
        insuranceOffer.setCountry(country);
        log.info("Рассчитана страховая премия: {}, валюта: {}, страна: {}, для страховки {} с номером договора: {}.",
                contribution, currency, country, insuranceType, insuranceOffer.getContractNumber());
        log.info("Закончено формирование предложения");
        return insuranceOffer;
    }

    @Override
    public InsuranceContract payInsurance(String policyNumber) {
        log.info("Начинаю оплату суммы страховой премии. Номер договора страхования: {}.", policyNumber);
        return InsuranceService.super.payInsurance(policyNumber);
    }
}
