package com.example.pic_pay_desafio.core.ports.`in`

import com.example.pic_pay_desafio.core.domain.TransferInformationCore

interface TransferPortIn {

    fun execute(transferInformationCore: TransferInformationCore)

}