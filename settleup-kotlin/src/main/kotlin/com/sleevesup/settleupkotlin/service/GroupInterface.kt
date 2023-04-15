package com.sleevesup.settleupkotlin.service

import com.sleevesup.settleupkotlin.DTO.*

interface GroupInterface {
    fun addGroup(group:UserGroupRequest) : String

    fun updatedes(updateDes : UserGroupRequest1) : String

    fun getUsers(groupList : UserGroupIdDto) : UserGroupResponse

    fun addFriends(addFriend: AddFriendDto):Any

    fun getFriends(friends:FriendRequest):Any
}