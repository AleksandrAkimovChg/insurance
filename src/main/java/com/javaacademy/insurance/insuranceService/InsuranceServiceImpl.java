package com.javaacademy.insurance.insuranceService;

import com.javaacademy.insurance.archive.Archive;
import com.javaacademy.insurance.contract.StatusType;
import com.javaacademy.insurance.util.Currency;
import com.javaacademy.insurance.util.Country;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.exception.PolicyNumberHasNoMatch;
import com.javaacademy.insurance.insuranceCalcService.InsuranceCalcService;
import com.javaacademy.insurance.util.Generator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Slf4j
public abstract class InsuranceServiceImpl implements InsuranceService {
    Generator generator;
    InsuranceCalcService calcService;
    Archive archive;
    @Value("${app.currency}")
    Currency currency;
    @Value("${app.country}")
    Country country;

    protected InsuranceServiceImpl(InsuranceCalcService calcService, Generator generator, Archive archive) {
        this.calcService = calcService;
        this.generator = generator;
        this.archive = archive;
    }

    @Override
    public InsuranceContract getInsuranceOffer(BigDecimal coverage, String fullName, InsuranceType insuranceType) {
        log.info("Начинаю формировать предложение для суммы покрытия {}. ФИО клиента: {}. Тип страховки: {}.",
                coverage, fullName, insuranceType);
        InsuranceContract insuranceOffer = new InsuranceContract();
        insuranceOffer.setContractNumber(generator.generateUniqueIdContract());
        BigDecimal contribution = calcService.calculateContribution(coverage, insuranceType);
        insuranceOffer.setContribution(contribution);
        insuranceOffer.setCoverage(coverage);
        insuranceOffer.setCurrency(currency);
        insuranceOffer.setFullName(fullName);
        insuranceOffer.setCountry(country);
        insuranceOffer.setInsuranceType(insuranceType);
        archive.getAllContracts().put(insuranceOffer.getContractNumber(), insuranceOffer);
        log.info("Рассчитана страховая премия: {}, валюта: {}, страна: {}, для страховки {} с номером договора: {}.",
                contribution, currency, country, insuranceType, insuranceOffer.getContractNumber());
        log.info("Закончено формирование предложения");
        return insuranceOffer;
    }

    /**
     * Оплату страховки.
     * На вход номер договора.
     * На выход страховой договор с измененным статусом: оплаченный договор.
     * Если договора нет, выкидывается ошибка: такого договора не существует.
     */
    @Override
    public InsuranceContract payInsurance(String contractNumber) {
        InsuranceContract contract = archive.getAllContracts().get(contractNumber);
        if (contract == null) {
            throw new PolicyNumberHasNoMatch("Договора с таким номером не существует.");
        }
        log.info("Начинаю оплату суммы страховой премии. Номер договора страхования: {}.", contractNumber);
        contract.setStatusType(StatusType.PAID);
        return contract;
    }
}
