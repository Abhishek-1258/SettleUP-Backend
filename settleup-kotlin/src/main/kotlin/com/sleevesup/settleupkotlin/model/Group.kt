package com.sleevesup.settleupkotlin.model

import javax.persistence.*

@Entity
@Table(name = "grouptable")
data class Group (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,

    @Column
    var groupname: String,

    @Column
    var groupdescription:String,

    @Column(name = "grouptype")
    var groupType: String,

    @ManyToMany
    @JoinTable(
        name = "users_group",
        joinColumns = [JoinColumn(name = "group_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]

    )
    var userList: MutableList<UserModel> = mutableListOf<UserModel>()
)