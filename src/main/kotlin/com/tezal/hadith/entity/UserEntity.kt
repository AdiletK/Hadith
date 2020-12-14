package com.tezal.hadith.entity

import com.tezal.hadith.enums.RoleList
import javax.persistence.*

@Entity
@Table(name = "user_table")
data class UserEntity(
        var userName: String,
        var password: String,
        @ManyToOne var settingEntity: SettingEntity?,
        @ManyToOne var loginEntity: LoginEntity?,
        @ElementCollection(fetch = FetchType.EAGER)
        var roles: MutableList<RoleList>
) : BaseEntity() {

}