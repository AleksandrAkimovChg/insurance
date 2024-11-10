package com.javaacademy.insurance;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.contract.insuranceCalcService.InsuranceCalcService;
import com.javaacademy.insurance.contract.insuranceService.InsuranceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class InsuranceApplication {
    private static final BigDecimal COVERAGE = BigDecimal.valueOf(1_000_000);
    private static final String FULL_NAME = "Петров Иван Васильевич";

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(InsuranceApplication.class, args);

        InsuranceService japan = context.getBean("insuranceServiceJapanImpl", InsuranceService.class);
        InsuranceCalcService brazilCalc = context
                .getBean("insuranceCalcJapanServiceImpl", InsuranceCalcService.class);
        InsuranceContract insuranceOfferM = japan
                .getInsuranceOffer(COVERAGE, FULL_NAME, InsuranceType.MEDICAL);
        InsuranceContract insuranceOfferR = japan
                .getInsuranceOffer(COVERAGE, FULL_NAME, InsuranceType.ROBBERY_PROTECTION);
        japan.payInsurance(insuranceOfferM.getContractNumber());
        japan.payInsurance(insuranceOfferR.getContractNumber());

//        InsuranceService brazil = context.getBean("insuranceServiceBrazilImpl", InsuranceService.class);
//        InsuranceCalcService brazilCalc = context
//              .getBean("insuranceCalcBrazilServiceImpl", InsuranceCalcService.class);
//        InsuranceContract insuranceOfferM = brazil
//              .getInsuranceOffer(COVERAGE, fullName, InsuranceType.MEDICAL);
//        InsuranceContract insuranceOfferR = brazil
//              .getInsuranceOffer(COVERAGE, fullName, InsuranceType.ROBBERY_PROTECTION);
//
//        brazil.payInsurance(insuranceOfferM.getContractNumber());
//        brazil.payInsurance(insuranceOfferR.getContractNumber());

        System.out.println("Доброе утро, Вьетнам");
    }
}
