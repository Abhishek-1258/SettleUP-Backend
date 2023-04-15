package com.sleevesup.settleupkotlin.utils

import com.sleevesup.settleupkotlin.repository.UserRepository
import java.util.regex.Pattern

object Validation {

    const val phoneRegex = "^[a-zA-Z]*\$"
    fun isEmailValid(email:String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

//    fun isEmailUnique(email: String): Boolean{
//        val uniqueEmail = UserRepository.findByEmail()
//    }

    fun isPhoneValid(phone: String): Boolean {
        //if(phone.length != 10 and Pattern.compile("^[a-zA-Z]*\$"))

        if(phone.length != 10 && phone.matches(phoneRegex.toRegex())) {
            return false
        }

        return true
    }
}