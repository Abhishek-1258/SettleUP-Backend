package com.sleevesup.settleupkotlin.model

import javax.persistence.*

@Entity
@Table(name = "expense")
data class ExpenseTrack(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null,

    @Column
    var amount: Int,

    @Column
    var split: Int,

    @ManyToOne
    @JoinColumn(name="group_id")
    var group: Group?=null,

    @Column
    var paidby:Int
)