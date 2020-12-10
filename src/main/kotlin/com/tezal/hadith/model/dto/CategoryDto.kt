package com.tezal.hadith.model.dto

import java.time.LocalDateTime

data class CategoryDto(
        val id: Long,
        val title: String,
        val createDate: LocalDateTime,
        val updateDate: LocalDateTime,
        val status: String
        )