package com.example.pic_pay_desafio.core.adapters.validation

import com.example.pic_pay_desafio.core.domain.TransferInformationCore
import com.example.pic_pay_desafio.core.domain.UserCore
import com.example.pic_pay_desafio.core.exception.PositiveValueException
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class PositiveValueValidation : ITransferValidation {

    override fun execute(userCore: UserCore, transferInformationCore: TransferInformationCore) {
        if (transferInformationCore.value <= BigDecimal.ZERO) {
            throw PositiveValueException("Only positive value are valid for transfer")
        }
    }
}