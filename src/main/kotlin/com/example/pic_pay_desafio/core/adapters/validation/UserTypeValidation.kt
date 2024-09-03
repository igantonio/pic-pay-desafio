package com.example.pic_pay_desafio.core.adapters.validation

import com.example.pic_pay_desafio.core.domain.TransferInformationCore
import com.example.pic_pay_desafio.core.domain.UserCore
import com.example.pic_pay_desafio.core.enums.UserTypeEnumCore
import com.example.pic_pay_desafio.core.exception.UserTypeInvalidException
import org.springframework.stereotype.Component

@Component
class UserTypeValidation : ITransferValidation {

    override fun execute(userCore: UserCore, transferInformationCore: TransferInformationCore) {
        if (UserTypeEnumCore.LOJISTA == userCore.type) {
            throw UserTypeInvalidException("Invalid user type for transfer")
        }
    }
}