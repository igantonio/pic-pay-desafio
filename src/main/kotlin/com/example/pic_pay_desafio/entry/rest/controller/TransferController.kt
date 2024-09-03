package com.example.pic_pay_desafio.entry.rest.controller

import com.example.pic_pay_desafio.core.domain.TransferInformationCore
import com.example.pic_pay_desafio.core.ports.`in`.TransferPortIn
import com.example.pic_pay_desafio.entry.rest.mapper.toCore
import com.example.pic_pay_desafio.entry.rest.request.TransferInformationRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transfer")
@Validated
class TransferController(
    private val transferPortIn: TransferPortIn
) {

    @PostMapping
    fun execute(@Valid @RequestBody transferInformationRequest: TransferInformationRequest): ResponseEntity<Void> {
        transferPortIn.execute(transferInformationRequest.toCore())
        return ResponseEntity.ok().build()
    }


}