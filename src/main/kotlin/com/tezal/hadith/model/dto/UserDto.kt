package com.tezal.hadith.model.dto

import java.time.LocalDateTime

data class UserDto(
        var id: Long,
        val createDate: LocalDateTime,
        val updateDate: LocalDateTime,
        var userName: String,
        var password: String,
        val settingId: Long,
        val loginId: Long
)