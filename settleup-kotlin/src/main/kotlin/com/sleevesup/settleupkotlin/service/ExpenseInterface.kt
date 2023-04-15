package com.sleevesup.settleupkotlin.service

import com.sleevesup.settleupkotlin.DTO.ExpenseDto

interface ExpenseInterface {

    fun addGroup(expense:ExpenseDto) : Any
}