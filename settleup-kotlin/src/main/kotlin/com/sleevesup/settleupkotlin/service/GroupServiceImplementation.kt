package com.sleevesup.settleupkotlin.service

import com.sleevesup.settleupkotlin.DTO.*
import com.sleevesup.settleupkotlin.model.UserModel
import com.sleevesup.settleupkotlin.model.Group
import com.sleevesup.settleupkotlin.repository.GroupRepository
import com.sleevesup.settleupkotlin.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class GroupServiceImplementation(private val groupRepository: GroupRepository,
    private val userRepository: UserRepository,
    private val userService: UserService) :GroupInterface {
    override fun addGroup(grouprequest: UserGroupRequest): String {
        try {
            val userList = userRepository.findAllById(grouprequest.group_user)
            val Group = Group(
                groupname = grouprequest.groupname,
                groupdescription = grouprequest.groupdescription,
                userList = userList,
                groupType = "Friend"
            )
            val response = groupRepository.save(Group)
            return "${Group.groupname} added"
        }
        catch (ex: Exception){
            return "User not found"
        }
    }



    override fun updatedes(updateDes: UserGroupRequest1): String {
        val updatedes : Group = groupRepository.findById(updateDes.id).get()
        updatedes.groupdescription = updateDes.groupdes
        groupRepository.save(updatedes)
        return "Description has been updated"

    }

    override fun getUsers(groupList: UserGroupIdDto): UserGroupResponse {
        val groupDetails:Group = groupRepository.findById(groupList.id.toLong()).get()
        val emptyList : MutableList<String> = mutableListOf<String>()
        if(groupDetails.userList.size > 0){
            for (ele in groupDetails.userList) {
                emptyList.add(ele.firstname)
                }
        }
        return UserGroupResponse(groupDetails.id,groupDetails.groupname,emptyList)
    }

    override fun addFriends(addFriend: AddFriendDto): Any {
        val friendOne:UserModel? = userService.getUserById(addFriend.friendId1)
        val friendTwo:UserModel? = userService.getUserById(addFriend.friendId2)
        val friendShip = Group(groupname = "Friendship", groupdescription = "Friend",groupType="Friend")
        if(friendOne != null && friendTwo != null) {
            friendShip.userList.add(friendOne)
            friendShip.userList.add(friendTwo)
            groupRepository.save(friendShip)
            return "Friends Has Been Added"
        }else{
            return "User Cannot Be Found"
        }
    }

    override fun getFriends(friends:FriendRequest):Any{
        val friendOne : UserModel? = userService.getUserById(friends.id)
        val friendList:MutableList<String> = mutableListOf<String>()
        if(friendOne != null){
            for (ele in friendOne.groupList){
                if (ele.groupType == "Friend"){
                    for(ele2 in ele.userList){
                        friendList.add(ele2.firstname)
                    }
                }
                else{
                    continue
                }
            }
            return friendList
        }
        else{
            return "no Friends"
        }
    }
}
