package com.javaacademy.insurance.insuranceCalcService;

import com.javaacademy.insurance.contract.InsuranceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Profile(value = "brazil")
@Component
@Slf4j
public class InsuranceCalcBrazilServiceImpl implements InsuranceCalcService {
    private static final BigDecimal ROBBERY_AWARD = BigDecimal.valueOf(300);
    private static final BigDecimal MEDICAL_AWARD = BigDecimal.valueOf(800);
    @Value("${app.rate.robbery}")
    private BigDecimal robberyRate;
    @Value("${app.rate.medical}")
    private BigDecimal medicalRate;

    @Override
    public BigDecimal calculateContribution(BigDecimal coverage, InsuranceType insuranceType) {
        log.info("Начинаю расчет суммы страховой премии. Сумма покрытия: {}. Тип страховки {}",
                coverage, insuranceType);
        if (insuranceType == InsuranceType.ROBBERY_PROTECTION) {
            BigDecimal price = coverage
                    .multiply(robberyRate)
                    .add(ROBBERY_AWARD)
                    .setScale(2, RoundingMode.HALF_UP);
            log.info("Расчет окончен. Сумма страховой премии: {}", price);
            return price;
        } else if (insuranceType == InsuranceType.MEDICAL) {
            BigDecimal price = coverage
                    .multiply(medicalRate)
                    .add(MEDICAL_AWARD)
                    .setScale(2, RoundingMode.HALF_UP);
            log.info("Расчет окончен. Сумма страховой премии: {}", price);
            return price;
        } else {
            log.error("В аргументы передан тип страховки, который отсутствует в реализации");
            throw new IllegalArgumentException("Не предусмотрено реализации для: " + insuranceType);
        }
    }
}
