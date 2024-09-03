package com.example.pic_pay_desafio.infra.persistence.adapter

import com.example.pic_pay_desafio.core.domain.UserCore
import com.example.pic_pay_desafio.core.enums.UserTypeEnumCore
import com.example.pic_pay_desafio.core.ports.out.FindUserPortOut
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class FindUserAdapter : FindUserPortOut {

    override fun findById(id: Long): UserCore? {
        if(id == 1L) {
            return UserCore(
                id = 1L,
                name = "Joao",
                cpf = "111.111.111-11",
                email = "Joao@gmail.com",
                password = "senha123",
                balance = BigDecimal.ZERO,
                type = UserTypeEnumCore.COMUM
            )
        } else {
            return UserCore(
                id = 2L,
                name = "Maria",
                cpf = "222.222.222-22",
                email = "Maria@gmail.com",
                password = "senha123",
                balance = BigDecimal.TWO,
                type = UserTypeEnumCore.LOJISTA
            )
        }


    }
}