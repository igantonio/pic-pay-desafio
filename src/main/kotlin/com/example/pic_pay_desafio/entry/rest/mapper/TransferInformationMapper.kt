package com.example.pic_pay_desafio.entry.rest.mapper

import com.example.pic_pay_desafio.core.domain.TransferInformationCore
import com.example.pic_pay_desafio.entry.rest.request.TransferInformationRequest

fun TransferInformationRequest.toCore() =
    TransferInformationCore(
        value = this.value,
        payer = this.payer,
        payee = this.payee,
    )