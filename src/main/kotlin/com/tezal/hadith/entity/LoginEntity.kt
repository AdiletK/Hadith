package com.tezal.hadith.entity

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "login_table")
data class LoginEntity(
        var type: String,
        var credential: String,
        var password: String
) : BaseEntity()