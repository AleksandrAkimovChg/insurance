package com.javaacademy.insurance.insuranceService;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;

import java.math.BigDecimal;

public interface InsuranceService {
    /**
     * Выдача предложения страховки.
     * На вход сумма покрытия, фио клиента, тип страховки.
     * На выход страховой договор (статус неоплачен).
     * Созданный договор должен быть помещен в архив.
     */
    InsuranceContract getInsuranceOffer(BigDecimal coverage, String fullName, InsuranceType insuranceType);

    /**
     * Оплата страховки.
     * На вход номер договора.
     * На выход страховой договор с измененным статусом: оплаченный договор.
     * Если договора нет, выкидывается ошибка: такого договора не существует.
     */
    InsuranceContract payInsurance(String contractNumber);
}
