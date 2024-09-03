package com.example.pic_pay_desafio.infra.persistence.adapter

import com.example.pic_pay_desafio.core.domain.UserCore
import com.example.pic_pay_desafio.core.ports.out.UpdateUserPortOut
import org.springframework.stereotype.Service

@Service
class UpdateUserAdapter : UpdateUserPortOut {

    override fun updateUser(userCore: UserCore) {
        println("Updating $userCore")
    }
}