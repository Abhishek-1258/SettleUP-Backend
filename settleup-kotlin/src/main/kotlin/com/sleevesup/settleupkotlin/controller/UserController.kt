package com.sleevesup.settleupkotlin.controller

import com.sleevesup.settleupkotlin.DTO.UserLoginDto
import com.sleevesup.settleupkotlin.model.UserModel
import com.sleevesup.settleupkotlin.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1")
class UserController(private val userService:UserService) {
    @GetMapping("/hello")
    fun hello(): ResponseEntity<Any> {
        val result = userService.sayhello()
        return ResponseEntity.ok(result)
    }

    @PostMapping("/add-user")
    fun addUsers(@RequestBody userInfo: UserLoginDto): ResponseEntity<Any> {
        val result = userService.addUser(userInfo)
        return ResponseEntity.ok(result)
    }

    @PutMapping("/update/{id}")
    fun updateUser(@RequestBody userUpdate: UserLoginDto,@PathVariable id:Int): ResponseEntity<Any> {
        val result = userService.updateUser(userUpdate,id)
        return ResponseEntity.ok(result)
    }


    @DeleteMapping("/delete")
    fun deleteUser(@RequestBody userDelete: UserLoginDto): ResponseEntity<Any> {
        val result = userService.deleteUser(userDelete)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/get-items")
    fun getUsers(): ResponseEntity<Any> {
        val result = userService.getUsers()
        return ResponseEntity.ok(result)

    }

    @GetMapping("/getusers")
    fun getUser(@RequestParam useremail:String): ResponseEntity<Any>{
        val result = userService.getUser(useremail)
        return ResponseEntity.ok(result)
    }



}