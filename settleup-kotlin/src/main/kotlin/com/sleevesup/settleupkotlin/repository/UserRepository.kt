package com.sleevesup.settleupkotlin.repository

import com.sleevesup.settleupkotlin.model.UserModel
import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<UserModel, Int>{
    fun findByEmail(email:String): UserModel?
}

