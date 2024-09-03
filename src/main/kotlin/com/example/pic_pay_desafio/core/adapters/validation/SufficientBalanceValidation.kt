package com.example.pic_pay_desafio.core.adapters.validation

import com.example.pic_pay_desafio.core.domain.TransferInformationCore
import com.example.pic_pay_desafio.core.domain.UserCore
import com.example.pic_pay_desafio.core.exception.InsufficientBalanceException
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class SufficientBalanceValidation : ITransferValidation {

    override fun execute(userCore: UserCore, transferInformationCore: TransferInformationCore) {
        if (this.isValueTransferGreaterOrEqualThanBalance(userCore.balance, transferInformationCore.value)) {
            throw InsufficientBalanceException("Insufficient balance for transfer")
        }
    }

    private fun isValueTransferGreaterOrEqualThanBalance(balance: BigDecimal, value: BigDecimal): Boolean =
        value > balance
}