package com.example.pic_pay_desafio.core.adapters.validation

import com.example.pic_pay_desafio.core.domain.TransferInformationCore
import com.example.pic_pay_desafio.core.domain.UserCore

interface ITransferValidation {

    fun execute(userCore: UserCore, transferInformationCore: TransferInformationCore)

}