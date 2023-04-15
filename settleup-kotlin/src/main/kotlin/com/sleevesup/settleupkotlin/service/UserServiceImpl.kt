package com.sleevesup.settleupkotlin.service

import com.sleevesup.settleupkotlin.DTO.UserLoginDto
import com.sleevesup.settleupkotlin.model.UserModel
import com.sleevesup.settleupkotlin.repository.UserRepository
import com.sleevesup.settleupkotlin.utils.Validation
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun sayhello(): String {
        return "Hello"
    }

    override fun addUser(userInfo: UserLoginDto): String {
        if(!Validation.isEmailValid(userInfo.email)) {
            return "Enter Valid Emailid"
        }

        if(!Validation.isPhoneValid(userInfo.phonenumber)){
            return "Enter Valid Phone Number"
        }

        if(userRepository.findByEmail(userInfo.email) != null){
            return "${userInfo.email} Email already exist"
        }

        userRepository.deleteById(1)

        val user = UserModel(
            firstname = userInfo.firstName,
            lastname = userInfo.lastName,
            age = userInfo.age,
            phonenumber = userInfo.phonenumber,
            email = userInfo.email
        )
        val createdUser = userRepository.save(user)
        return "${createdUser.firstname} details has been added"


    }

    override fun updateUser(userUpdate: UserLoginDto, id: Int): String {
        var user = UserModel(
            id = id,
            firstname = userUpdate.firstName,
            lastname = userUpdate.lastName,
            age = userUpdate.age,
            phonenumber = userUpdate.phonenumber,
            email = userUpdate.email)
            if(user != null){
                user = userRepository.save(user)
                return "${user.firstname} details has been updated"}
            else{
                return "Enter valid details"
            }
    }
    override fun getUsers(): List<UserModel> {
        return userRepository.findAll()
    }

    override fun deleteUser(userDelete: UserLoginDto): String {
        val delete = userRepository.findByEmail(userDelete.email)
        if(delete != null) {
            userRepository.deleteById(delete.id)
            return "${delete.email} details has been deleted"
        }

        return "${userDelete.email} does not exist"
    }

    override fun getUser(userEmail:String) : List<String>{
        val user = userRepository.findByEmail(userEmail)
        if(user != null){
            val groupNameList = user.groupList.map { it.groupname }
            return groupNameList
        }
        return emptyList<String>()

    }

    override fun getUserById(id: Int): UserModel? {
        return userRepository.findById(id).get()

    }


}
