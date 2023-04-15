package com.sleevesup.settleupkotlin.repository

import com.sleevesup.settleupkotlin.model.Group
import org.springframework.data.jpa.repository.JpaRepository

interface GroupRepository : JpaRepository<Group, Long> {
}
