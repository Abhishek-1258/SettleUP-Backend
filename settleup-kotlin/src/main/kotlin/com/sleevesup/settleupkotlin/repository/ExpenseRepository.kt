package com.sleevesup.settleupkotlin.repository

import com.sleevesup.settleupkotlin.model.ExpenseTrack
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository: JpaRepository<ExpenseTrack,Int> {
}