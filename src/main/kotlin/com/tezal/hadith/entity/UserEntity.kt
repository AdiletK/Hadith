package com.tezal.hadith.entity

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user_table")
data class UserEntity(
        var userName: String,
        var phone: String
) : BaseEntity() {

}