package com.example.pic_pay_desafio.core.domain

import com.example.pic_pay_desafio.core.enums.UserTypeEnumCore
import java.math.BigDecimal

data class UserCore(
    val id: Long,
    val name: String,
    val cpf: String,
    val email: String,
    val password: String,
    var balance: BigDecimal,
    val type: UserTypeEnumCore
) {
    fun decreaseBalance(value: BigDecimal) {
        this.balance -= value
    }

    fun increaseBalance(value: BigDecimal) {
        this.balance += value
    }

}
