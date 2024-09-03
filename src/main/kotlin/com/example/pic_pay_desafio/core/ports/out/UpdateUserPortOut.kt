package com.example.pic_pay_desafio.core.ports.out

import com.example.pic_pay_desafio.core.domain.UserCore

interface UpdateUserPortOut {

    fun updateUser(userCore: UserCore)

}