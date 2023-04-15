package com.sleevesup.settleupkotlin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Table(name="userdata")
@Entity

data class UserModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = -1,
    @Column
    var firstname:String,
    @Column
    var lastname:String,
    @Column
    var age:Int,
    @Column
    var phonenumber: String,

    @Column
    var email:String,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
        name = "users_group",
        joinColumns = [JoinColumn(name = "group_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    var groupList: MutableList<Group> = mutableListOf<Group>()
)


