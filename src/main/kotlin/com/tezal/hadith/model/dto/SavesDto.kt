package com.tezal.hadith.model.dto

data class SavesDto(
        val id: Long,
        val hadithId: Long,
        val userId: Long,
        val userName: String
)