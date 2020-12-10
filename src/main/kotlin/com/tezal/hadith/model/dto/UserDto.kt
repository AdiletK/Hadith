package com.tezal.hadith.model.dto

import java.time.LocalDateTime

data class UserDto(
        val id: Long,
        val createDate: LocalDateTime,
        val updateDate: LocalDateTime,
        val userName: String,
        val settingId: Long,
        val loginId: Long
)