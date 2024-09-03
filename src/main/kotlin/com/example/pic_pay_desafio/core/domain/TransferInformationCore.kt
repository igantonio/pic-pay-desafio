package com.example.pic_pay_desafio.core.domain

import java.math.BigDecimal

data class TransferInformationCore(
    val value: BigDecimal,
    val payer: Long,
    val payee: Long,
)
