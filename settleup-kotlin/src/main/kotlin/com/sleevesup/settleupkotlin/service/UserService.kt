package com.sleevesup.settleupkotlin.service

import com.sleevesup.settleupkotlin.DTO.AddFriendDto
import com.sleevesup.settleupkotlin.DTO.UserLoginDto
import com.sleevesup.settleupkotlin.DTO.UserResponseDto
import com.sleevesup.settleupkotlin.model.UserModel

interface UserService {
    fun sayhello():String

    fun addUser(userInfo:UserLoginDto): String


    fun updateUser(userUpdate:UserLoginDto,id:Int):String

    fun deleteUser(userDelete: UserLoginDto):String

    fun getUsers():List<UserModel>

    fun getUser(userEmail:String):List<String>

    fun getUserById(id:Int) : UserModel?



}