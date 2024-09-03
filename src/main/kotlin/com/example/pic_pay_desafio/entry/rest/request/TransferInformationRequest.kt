package com.example.pic_pay_desafio.entry.rest.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

class TransferInformationRequest(
//    @field:Positive(message = "The transfer value must be greater than zero")
    val value: BigDecimal,
    @field:NotNull(message = "Payer amount is mandatory")
    val payer: Long,
    @field:NotNull(message = "Payee amount is mandatory")
    val payee: Long,
)