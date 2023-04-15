package com.sleevesup.settleupkotlin.service

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.sleevesup.settleupkotlin.DTO.UserLoginDto
import com.sleevesup.settleupkotlin.model.UserModel
import com.sleevesup.settleupkotlin.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class UserServiceImplTest {
    @Mock
    private lateinit var userRepository: UserRepository
    private lateinit var userServiceImpl:UserServiceImpl

    @BeforeEach
    private fun setup(){
        MockitoAnnotations.initMocks(this)
        userServiceImpl = UserServiceImpl(userRepository)
    }


    @Test
    fun `checking for email validation`() {
        val userSample = UserLoginDto(
            "Abhishek",
            "Sriramoju",
            21,
            "7893155755",
            "sriramojugmail.com"
        )

        val ExpectingError = "Enter Valid Emailid"


        //Act
        whenever(userRepository.save(any<UserModel>())).then { it.arguments.first() }
        val Result:String = userServiceImpl.addUser(userSample)

        //Assert
        assertThat(Result).isEqualTo(ExpectingError)
    }

    @Test
    fun`Update user`() {
        val user1 = UserLoginDto(
            "Abhishek",
            "Sriramoju",
            21,
            "9849145655",
            "sriram@gmail.com"
        )
        val user = UserModel(
            10,
            "Abhishek",
            "Sriramoju",
            22,
            "7893156",
            "sri@gmail.com"
        )
        userRepository.save(user)
        //Act
        whenever(userRepository.save(any<UserModel>())).then { it.arguments.first() }
        val result:String = userServiceImpl.updateUser(userUpdate = user1,10)
        assertThat(result).isEqualTo("${user.firstname} details has been updated")
    }

    @Test
    fun `Get the user when the mail id is given`(){
        val userEmail="sri@gmail.com"
        val user = UserModel(
            6,
            "Abhishek",
            "Sriramoju",
            22,
            "7893156",
            "sri@gmail.com",
            mutableListOf()
        )

//        whenever(userRepository.findByEmail(email = "sri@gmail.com")).thenReturn(user)
//        val result = userRepository.findByEmail("sri@gmail.com")
//        if (result != null) {
//            assertThat(result).isEqualTo(equals("Abhishek"))
//        }
    }
}