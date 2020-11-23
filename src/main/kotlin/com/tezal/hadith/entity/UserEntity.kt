package com.tezal.hadith.entity

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "user_table")
data class UserEntity(
        var userName: String,
        @ManyToOne var settingEntity: SettingEntity,
        @ManyToOne var loginEntity: LoginEntity
) : BaseEntity() {

}