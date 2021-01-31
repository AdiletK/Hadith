package com.tezal.hadith.model.dto

data class HadithDto(
        val id: Long,
        val status: String,
        val imageUrl: String?,
        val transcript: String?
        )