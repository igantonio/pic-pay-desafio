package com.example.pic_pay_desafio.core.configuration

import com.example.pic_pay_desafio.core.adapters.validation.ITransferValidation
import com.example.pic_pay_desafio.core.adapters.validation.PositiveValueValidation
import com.example.pic_pay_desafio.core.adapters.validation.SufficientBalanceValidation
import com.example.pic_pay_desafio.core.adapters.validation.UserTypeValidation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CreateTransferValidationListConfiguration(
    private val userTypeValidation: UserTypeValidation,
    private val positiveValueValidation: PositiveValueValidation,
    private val sufficientBalanceValidation: SufficientBalanceValidation,
) {

    @Bean
    fun transferValidations(): List<ITransferValidation> =
        listOf(userTypeValidation, positiveValueValidation, sufficientBalanceValidation)

}