package com.javaacademy.insurance;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;
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
        InsuranceService service = context.getBean(InsuranceService.class);
        InsuranceContract insuranceOfferM = service
                .getInsuranceOffer(COVERAGE, FULL_NAME, InsuranceType.MEDICAL);
        InsuranceContract insuranceOfferR = service
                .getInsuranceOffer(COVERAGE, FULL_NAME, InsuranceType.ROBBERY_PROTECTION);
        service.payInsurance(insuranceOfferM.getContractNumber());
        service.payInsurance(insuranceOfferR.getContractNumber());
    }
}
