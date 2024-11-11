package com.javaacademy.insurance.contract.insuranceService;

import com.javaacademy.insurance.archive.Archive;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.contract.StatusType;

import java.math.BigDecimal;

public interface InsuranceService {
    /**
     * Выдача предложения страховки.
     * На вход сумма покрытия, фио клиента, тип страховки.
     * На выход страховой договор (статус неоплачен).
     * Созданный договор помещен в архив.
     */

    default InsuranceContract getInsuranceOffer(BigDecimal coverage, String fullName, InsuranceType insuranceType) {
        InsuranceContract contract = new InsuranceContract(coverage, fullName, insuranceType, StatusType.UNPAID);
        Archive.getAllContracts().put(contract.getContractNumber(), contract);
        return contract;
    }

    /**
     * Оплату страховки.
     * На вход номер договора.
     * На выход страховой договор с измененным статусом: оплаченный договор.
     * Если договора нет, выкидывается ошибка: такого договора не существует.
     */

    default InsuranceContract payInsurance(String contractNumber) {
        InsuranceContract contract = Archive.getAllContracts().get(contractNumber);
        if (contract == null) {
            throw new IllegalArgumentException("Договора с таким номером не существует.");
        }
        contract.setStatusType(StatusType.PAID);
        return contract;
    }
}
