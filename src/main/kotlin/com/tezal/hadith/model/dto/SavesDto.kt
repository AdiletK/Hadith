package com.tezal.hadith.model.dto

import java.time.LocalDateTime

data class SavesDto(
        val id: Long,
        val createDate: LocalDateTime,
        val updateDate: LocalDateTime,
        val hadithId: Long,
        val hadithName: String,
        val userId: Long,
        val userName: String
){
    constructor()
}