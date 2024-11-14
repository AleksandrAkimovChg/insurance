package com.javaacademy.insurance.insuranceService;

import com.javaacademy.insurance.archive.Archive;
import com.javaacademy.insurance.insuranceCalcService.InsuranceCalcService;
import com.javaacademy.insurance.util.Generator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "brazil")
@Component
public class InsuranceServiceBrazil extends InsuranceServiceImpl {

    public InsuranceServiceBrazil(@Qualifier("insuranceCalcBrazilServiceImpl") InsuranceCalcService calcService,
                                  @Qualifier("generator") Generator generator,
                                  @Qualifier("archive") Archive archive) {
        super(calcService, generator, archive);
    }
}
