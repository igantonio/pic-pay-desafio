package com.example.pic_pay_desafio.infra.client.adapter

import com.example.pic_pay_desafio.core.ports.out.AuthorizationPortOut
import org.springframework.stereotype.Service

@Service
class AuthorizationAdapter : AuthorizationPortOut {

    override fun isAuthorized(): Boolean {
        return true
    }
}