package com.sleevesup.settleupkotlin.controller

import com.sleevesup.settleupkotlin.DTO.*
import com.sleevesup.settleupkotlin.service.GroupInterface
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1")
class GroupController(private val groupService: GroupInterface) {
    @PostMapping("add group")
    fun addGroup(@RequestBody userGroupRequest: UserGroupRequest): ResponseEntity<Any> {
        val result = groupService.addGroup(userGroupRequest)
        return ResponseEntity.ok(result)
    }

    @PutMapping("update")
    fun update(@RequestBody updateDes : UserGroupRequest1) : ResponseEntity<Any> {
        val result = groupService.updatedes(updateDes)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/getUsers")
    fun getGroup(@RequestBody getters:UserGroupIdDto):ResponseEntity<Any>{
        val result = groupService.getUsers(getters)
        return ResponseEntity.ok(result)
    }


    @PostMapping("/addfriend")
    fun addFriend(@RequestBody addFriends:AddFriendDto) : ResponseEntity<Any>{
        val result = groupService.addFriends(addFriends)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/getfriends")
    fun getFriends(@RequestBody getfriend:FriendRequest):ResponseEntity<Any>{
        val result = groupService.getFriends(getfriend)
        return ResponseEntity.ok(result)
    }
}