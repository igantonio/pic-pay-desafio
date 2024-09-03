package com.example.pic_pay_desafio.core.adapters

import com.example.pic_pay_desafio.core.adapters.validation.ITransferValidation
import com.example.pic_pay_desafio.core.domain.TransferInformationCore
import com.example.pic_pay_desafio.core.domain.UserCore
import com.example.pic_pay_desafio.core.exception.UserNotFoundException
import com.example.pic_pay_desafio.core.exception.TransferUnauthorizedException
import com.example.pic_pay_desafio.core.ports.`in`.TransferPortIn
import com.example.pic_pay_desafio.core.ports.out.AuthorizationPortOut
import com.example.pic_pay_desafio.core.ports.out.FindUserPortOut
import com.example.pic_pay_desafio.core.ports.out.UpdateUserPortOut
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TransferPortInAdapter(
    private val findUserPortOut: FindUserPortOut,
    private val updateUserPortOut: UpdateUserPortOut,
    private val authorizationPortOut: AuthorizationPortOut,
    @Qualifier("transferValidations") private val transferValidations: List<ITransferValidation>,
) : TransferPortIn {

    //@Transactional
    override fun execute(transferInformationCore: TransferInformationCore) {
        val userPayer = this.findUserById(transferInformationCore.payer)

        this.executeValidation(userPayer, transferInformationCore)

        val valueToTransfer = transferInformationCore.value
        val userPayee = this.findUserById(transferInformationCore.payee)

        this.executeTheTransferBetweenAccounts(valueToTransfer, userPayer, userPayee)

        if (!authorizationPortOut.isAuthorized()) {
            throw TransferUnauthorizedException("Transfer unauthorized")
        }

        //Notify push with rabbit queue

    }

    private fun findUserById(id: Long): UserCore =
        findUserPortOut.findById(id)
            ?: throw UserNotFoundException("User not found for id=$id")

    private fun executeValidation(userCore: UserCore, transferInformationCore: TransferInformationCore) {
        transferValidations.forEach { validation ->
            validation.execute(userCore, transferInformationCore)
        }
    }

    private fun executeTheTransferBetweenAccounts(value: BigDecimal, userPayer: UserCore, userPayee: UserCore) {
        userPayer.decreaseBalance(value)
        userPayee.increaseBalance(value)

        updateUserPortOut.updateUser(userPayer)
        updateUserPortOut.updateUser(userPayee)
    }
}