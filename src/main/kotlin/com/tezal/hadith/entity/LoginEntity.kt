package com.tezal.hadith.entity

import com.tezal.hadith.enum.LoginTypeList
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "login_table")
data class LoginEntity(
        var type: LoginTypeList,
        var credential: String,
        var password: String
) : BaseEntity()