package com.javaacademy.insurance.insuranceService;

import com.javaacademy.insurance.archive.Archive;
import com.javaacademy.insurance.insuranceCalcService.InsuranceCalcService;
import com.javaacademy.insurance.util.Generator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "japan")
@Component
public class InsuranceServiceJapan extends InsuranceServiceImpl {
    public InsuranceServiceJapan(@Qualifier("insuranceCalcJapanServiceImpl") InsuranceCalcService calcService,
                                 @Qualifier("generator") Generator generator,
                                 @Qualifier("archive") Archive archive) {
        super(calcService, generator, archive);
    }
}
