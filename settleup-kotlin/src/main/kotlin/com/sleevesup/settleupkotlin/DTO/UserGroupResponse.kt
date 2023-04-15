package com.sleevesup.settleupkotlin.DTO

class UserGroupResponse(var id:Long,var groupname:String,var user_list:MutableList<String> = mutableListOf<String>()) {
}